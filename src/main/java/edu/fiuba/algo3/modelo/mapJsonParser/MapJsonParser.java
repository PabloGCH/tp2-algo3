package edu.fiuba.algo3.modelo.mapJsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import edu.fiuba.algo3.modelo.RandomResult.DiceFactory;
import edu.fiuba.algo3.modelo.RandomResult.RandomResult;
import edu.fiuba.algo3.modelo.map.Map;
import edu.fiuba.algo3.modelo.squares.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class MapJsonParser implements Parser {
    public Map loadMap(String filePath, String fileName) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        int height;
        int width;
        Map map;
        try {
            ArrayList<Position> path = new ArrayList<>();
            Square previousSquare;
            JSONObject measures = this.getMapObject(filePath);
            width = Math.toIntExact((long)measures.get("ancho"));
            height = Math.toIntExact((long)measures.get("largo"));
            JSONArray pathJsonArray = this.getPathObject(filePath);
            int middleSquareIndex = (int) pathJsonArray.size() / 2;
            Square middleSquare = new Middle(new NullEffect());


            JSONObject element = (JSONObject) pathJsonArray.get(0);
            String value = (String) element.get("tipo");
            Square newSquare = this.createSquare(value, middleSquare);
            middleSquare = middleSquareIndex == 0 ? newSquare : middleSquare;
            previousSquare = newSquare;
            path.add(newSquare);

            for (int i = 1; i < pathJsonArray.size(); i++) {
                element = (JSONObject) pathJsonArray.get(i);
                value = (String) element.get("tipo");
                newSquare = this.createSquare(value, middleSquare);
                middleSquare = middleSquareIndex == i ? newSquare : middleSquare;
                previousSquare.setNextPosition(newSquare);
                path.add(newSquare);
                previousSquare = newSquare;
            }
            map = new Map(width, height, path);
        } catch (ClassCastException e) {
            //IT CAN BE ASSUMED THAT IF IT FAILS TO CAST AN OBJECT IS BECAUSE THE JSON IS INVALID
            //SINCE IS ONLY CASTING AFTER GETTING VALUES FROM THE FILE
            throw new InvalidMapFile();
        }
        return map;
    }

    private Square createSquare(String type, Square middleSquare) {
        switch (type) {
            case "Salida":
                return new Initial();
            case "Fiera":
                return new Middle(new Beast());
            case "Bacanal":
                var diceFactory = new DiceFactory();
                RandomResult dice = diceFactory.createRandomGenerator();
                return new Middle(new Bacchanalia(dice));
            case "Equipamiento":
                //NEEDS EQUIPMENT EFFECT
                return new Middle(new Upgrade());
            case "Comida":
                return new Middle(new Food());
            case "Lesion":
                return new Middle(new Injury());
            case "Llegada":
                return new FinishLine(middleSquare);
            default:
                return new Middle(new NullEffect());
        }
    }


    private JSONObject getMapObject(String filePath) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        FileReader reader;
        //TRIES TO READ MAP FILE
        try {
            reader = new FileReader(filePath);
            JSONParser parser = new JSONParser();
            Object mapObject = parser.parse(reader);
            reader.close();
            if (mapObject instanceof JSONArray) {
                throw new InvalidMapFile();
            }
            JSONObject pathjsonObject = (JSONObject) mapObject;
            if (!pathjsonObject.containsKey("mapa")) {
                throw new InvalidMapFile();
            }
            return (JSONObject) pathjsonObject.get("mapa");
        } catch (FileNotFoundException e) {
            throw new MapFileNotFound();
        } catch (IOException e) {
            throw new MapFileFailedToOpenOrClose();
        } catch (ParseException e) {
            throw new MapFileCouldNotBeParsed();
        }
    }

    private JSONArray getPathObject(String filePath) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        FileReader reader;
        //TRIES TO READ MAP FILE
        try {
            reader = new FileReader(filePath);
            JSONParser parser = new JSONParser();
            Object mapObject = parser.parse(reader);
            reader.close();
            if (mapObject instanceof JSONArray) {
                throw new InvalidMapFile();
            }
            JSONObject mapjsonObject = (JSONObject) mapObject;
            if(!mapjsonObject.containsKey("camino")){
                throw new InvalidMapFile();
            }
            JSONObject pathjsonObject = (JSONObject)mapjsonObject.get("camino");
            if(!pathjsonObject.containsKey("celdas")){
                throw new InvalidMapFile();
            }
            return (JSONArray) pathjsonObject.get("celdas");
        } catch (FileNotFoundException e) {
            throw new MapFileNotFound();
        } catch (IOException e) {
            throw new MapFileFailedToOpenOrClose();
        } catch (ParseException e) {
            throw new MapFileCouldNotBeParsed();
        }
    }
}
