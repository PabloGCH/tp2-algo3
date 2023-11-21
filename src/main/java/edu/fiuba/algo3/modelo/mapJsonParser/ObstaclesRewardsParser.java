package edu.fiuba.algo3.modelo.mapJsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import edu.fiuba.algo3.modelo.squares.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ObstaclesRewardsParser {
    public ArrayList<Effect> loadEffects(String filePath, String fileName) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile{
        ArrayList<Effect> effects = new ArrayList<>();
        try {
            JSONObject mapJsonObject = this.getEffectsObject(filePath);
            JSONArray effectsJsonArray;
            effectsJsonArray = (JSONArray) mapJsonObject.get(fileName);
            for(int i = 0; i < effectsJsonArray.size(); i++) {
                Object element = effectsJsonArray.get(i);
                String value = element.toString();
                Effect newEffect = this.createEffect(value);
                effects.add(newEffect);
            }
        } catch(ClassCastException e) {
            //IT CAN BE ASSUMED THAT IF IT FAILS TO CAST AN OBJECT IS BECAUSE THE JSON IS INVALID
            //SINCE IS ONLY CASTING AFTER GETTING VALUES FROM THE FILE
            throw new InvalidMapFile();
        }
        return effects;
    }

    private Effect createEffect(String type) {
        switch (type) {
            case "FOOD":
                return new Food();
            case "UPGRADE":
                return new Upgrade();
            case "WINE":
                return new Bacchanalia();
            case "BEAST":
                return new Beast();
            case "INJURY":
                return new Injury();
            default:
                return new NullEffect();
        }
    }

    private JSONObject getEffectsObject(String filePath) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        FileReader reader;
        //TRIES TO READ MAP FILE
        try {
            reader = new FileReader(filePath);
            JSONParser parser = new JSONParser();
            Object mapObject = parser.parse(reader);
            reader.close();
            if(mapObject instanceof JSONArray){
                throw new InvalidMapFile();
            }
            JSONObject mapjsonObject = (JSONObject) mapObject;
            if(!mapjsonObject.containsKey("effects")){
                throw new InvalidMapFile();
            }
            return (JSONObject) mapjsonObject.get("effects");
        } catch(FileNotFoundException e) {
            throw new MapFileNotFound();
        } catch(IOException e) {
            throw new MapFileFailedToOpenOrClose();
        } catch(ParseException e) {
            throw new MapFileCouldNotBeParsed();
        }
    }

}
