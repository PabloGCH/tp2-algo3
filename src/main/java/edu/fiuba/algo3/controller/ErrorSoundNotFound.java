package edu.fiuba.algo3.controller;

public class ErrorSoundNotFound extends Exception {
    public ErrorSoundNotFound() {
        super("Sound file not found");
    }
}
