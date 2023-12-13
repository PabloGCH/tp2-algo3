package edu.fiuba.algo3.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import edu.fiuba.algo3.modelo.Messenger;
import edu.fiuba.algo3.modelo.squares.EffectObserver;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Sound implements EffectObserver {
    private final HashMap<String, MediaPlayer> songs = new HashMap<>();
    private final HashMap<String, MediaPlayer> soundsFX = new HashMap<>();
    private MediaPlayer currentSong;
    private static final Sound instance = new Sound();
    private final double defaultVolume = 0.6;
    private final SimpleDoubleProperty musicVolumeProperty = new SimpleDoubleProperty(defaultVolume);
    private final SimpleDoubleProperty volumeFx = new SimpleDoubleProperty(defaultVolume);
    private static final String SONGS_DIRECTORY = "/sounds/music/";
    private static final String SOUNDS_FX_DIRECTORY = "/sounds/soundsFX/";
    private boolean muted = false;
    private ArrayList<MediaPlayer> soundStack = new ArrayList<MediaPlayer>();
    private Sound() {
    }
    public static Sound getInstance() {
        return instance;
    }
    public void loadMusic(String fileName, String identifier) {
        loadFile(fileName, identifier, songs, musicVolumeProperty, SONGS_DIRECTORY);
    }
    public void loadSound(String fileName, String identifier) {
        loadFile(fileName, identifier, soundsFX, volumeFx, SOUNDS_FX_DIRECTORY);
    }
    private void loadFile(String fileName, String identifier, HashMap<String, MediaPlayer> container, SimpleDoubleProperty volume, String directory){
        Media media = new Media(Objects.requireNonNull(getClass().getResource(directory + fileName).toExternalForm()));
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setOnEndOfMedia(() -> {
            System.out.println(soundStack.size());
            mediaPlayer.stop();
            mediaPlayer.seek(Duration.ZERO);
            if (!soundStack.isEmpty()) {
                this.soundStack.remove(0);
            }
            if (this.soundStack.size() > 0) {
                this.soundStack.get(0).play();
            }
        });
        mediaPlayer.volumeProperty().bindBidirectional(volume);
        container.put(identifier, mediaPlayer);
    }
    public void modifyMusicVolume(double value) {
        modifyVolume(value, musicVolumeProperty);
    }
    public void modifyEffectVolume(double value) {
        modifyVolume(value, volumeFx);
    }

    private void modifyVolume(double value, SimpleDoubleProperty volume) {
        if (value >= 0 && value <= 100){
            volume.set(value / 100);
        }
    }
    public void playFX(String identifier) {

        try {
            if (!soundsFX.containsKey(identifier)) {
                throw new ErrorSoundNotFound();
            }
            MediaPlayer currentSoundFX = soundsFX.get(identifier);
            if (currentSoundFX == null) {
                return;
            }
            soundStack.add(currentSoundFX);
            if (soundStack.size() == 1) {
                currentSoundFX.play();
            }
        } catch (ErrorSoundNotFound e) {
            Messenger.getInstance().error("File not found");
        }
    }
    public void playMusicOnce(String identifier) {
        if (!songs.containsKey(identifier))
            System.err.println("Error music");
        if (currentSong != null) {
            currentSong.stop();
        }

        currentSong = songs.get(identifier);

        currentSong.play();
    }
    public void playLoopedMusic(String identifier) {
        if (!songs.containsKey(identifier))
            System.err.println("Error music");
        if (currentSong != null) {
            currentSong.stop();
        }

        currentSong = songs.get(identifier);
        currentSong.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                currentSong.seek(Duration.ZERO);
                currentSong.play();
            }
        });

        currentSong.play();
    }

    public void stopMusic() {
        if (currentSong != null) {
            currentSong.stop();
        }
    }
    public void toggleMuteMusic() {
        currentSong.setMute(!currentSong.isMute());
    }
    public void toggleMuteSoundsFX() {
        for (MediaPlayer sound : soundsFX.values()) {
            sound.setMute(!sound.isMute());
        }
    }
    public int getMusicTracksAmount() {
        return this.songs.size();
    }
    @Override
    public void update(String effect) {
        this.playFX(effect + ".mp3");
    }
}