package edu.fiuba.algo3.modelo.mapJsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import edu.fiuba.algo3.modelo.squares.Bacchanalia;
import edu.fiuba.algo3.modelo.squares.Beast;
import edu.fiuba.algo3.modelo.squares.FinishLine;
import edu.fiuba.algo3.modelo.squares.Food;
import edu.fiuba.algo3.modelo.squares.Initial;
import edu.fiuba.algo3.modelo.squares.Injury;
import edu.fiuba.algo3.modelo.squares.Middle;
import edu.fiuba.algo3.modelo.squares.NullEffect;
import edu.fiuba.algo3.modelo.squares.Square;
import edu.fiuba.algo3.modelo.squares.Upgrade;


public class MapJsonParser {
    public ArrayList<Square> loadMap(String filePath, String fileName) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile{
        ArrayList<Square> map = new ArrayList<>();
        try {
            JSONArray mapJsonArray = this.getMapObject(filePath);
            int middleSquareIndex = (int) mapJsonArray.size() / 2;
            Square middleSquare = new Middle(new NullEffect());

            for(int i = 0; i < mapJsonArray.size(); i++) {
                JSONObject element = (JSONObject) mapJsonArray.get(i);
                String value = (String) element.get("square");
                Square newSquare = this.createSquare(value, middleSquare);
                middleSquare = middleSquareIndex == i ? newSquare : middleSquare;
                map.add(newSquare);
            }
        } catch(ClassCastException e) {
            //IT CAN BE ASSUMED THAT IF IT FAILS TO CAST AN OBJECT IS BECAUSE THE JSON IS INVALID
            //SINCE IS ONLY CASTING AFTER GETTING VALUES FROM THE FILE
            throw new InvalidMapFile();
        }
        return map;
    }

    private Square createSquare(String type, Square middleSquare) {
        switch (type) {
            case "INITIAL":
                return new Initial();
            case "BEAST":
                return new Middle(new Beast());
            case "WINE":
                return new Middle(new Bacchanalia());
            case "EQUIPMENT_UPGRADE":
                //NEEDS EQUIPMENT EFFECT
                return new Middle(new Upgrade());
            case "FOOD":
                return new Middle(new Food());
            case "INJURY":
                return new Middle(new Injury());
            case "FINAL":
                return new FinishLine(middleSquare);
            default:
                return new Middle(new NullEffect());
        }
    }


    private JSONArray getMapObject(String filePath) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
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
            if(!mapjsonObject.containsKey("map")){
                throw new InvalidMapFile();
            }
            return (JSONArray) mapjsonObject.get("map");
        } catch(FileNotFoundException e) {
            throw new MapFileNotFound();
        } catch(IOException e) {
            throw new MapFileFailedToOpenOrClose();
        } catch(ParseException e) {
            throw new MapFileCouldNotBeParsed();
        }
    }

}
