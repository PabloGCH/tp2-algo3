package edu.fiuba.algo3.modelo.mapJsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import edu.fiuba.algo3.modelo.RandomResult.DiceFactory;
import edu.fiuba.algo3.modelo.RandomResult.RandomResult;
import edu.fiuba.algo3.modelo.squares.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import edu.fiuba.algo3.modelo.squares.Bacchanalia;
import edu.fiuba.algo3.modelo.squares.Beast;
import edu.fiuba.algo3.modelo.squares.Food;
import edu.fiuba.algo3.modelo.squares.Injury;
import edu.fiuba.algo3.modelo.squares.NullEffect;


public class ObstaclesRewardsParser {
    public ArrayList<Effect> loadEffects(String filePath, String fileName) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile{
        ArrayList<Effect> effects = new ArrayList<>();
        try {
            JSONArray effectsJsonArray = this.getEffectsObject(filePath);
            for (Object element : effectsJsonArray) {
                JSONObject object = (JSONObject) element;
                String value = (String) object.get("effect");
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

    private JSONArray getEffectsObject(String filePath) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
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
            return (JSONArray) mapjsonObject.get("effects");
        } catch(FileNotFoundException e) {
            throw new MapFileNotFound();
        } catch(IOException e) {
            throw new MapFileFailedToOpenOrClose();
        } catch(ParseException e) {
            throw new MapFileCouldNotBeParsed();
        }
    }

}
