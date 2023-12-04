package edu.fiuba.algo3.modelo.mapJsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.squares.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class MapJsonParser implements Parser {
    public ArrayList<Square> loadMap(String filePath, String fileName) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        ArrayList<Square> path = new ArrayList<>();
        try {
            int xPosition, yPosition;
            JSONArray pathJsonArray = this.getPathObject(filePath);
            JSONObject element;
            String value;
            Square newSquare;
            EffectFactory effectFactory = new EffectFactory();
            Effect prize, obstacle;

            final int LAST_ARRAY_INDEX = pathJsonArray.size() - 1;
            for (int i = 0; i < LAST_ARRAY_INDEX; i++) {
                element = (JSONObject) pathJsonArray.get(i);

                value = (String) element.get("obstaculo");
                obstacle = effectFactory.createSquare(value);

                value = (String) element.get("premio");
                prize = effectFactory.createSquare(value);

                xPosition = Math.toIntExact((long)element.get("x"));
                yPosition = Math.toIntExact((long)element.get("y"));
                //xPosition = (int) element.get("x");
                //yPosition = (int) element.get("y");
                Position squarePosition = new Position(xPosition, yPosition, i);
                newSquare = new Square(obstacle,prize, squarePosition);
                path.add(newSquare);
            }
            Position middlePosition = path.get((path.size() + 1) / 2).getPosition();
            var finishLineEffect = new FinishLineEffect();
            finishLineEffect.setMiddlePosition(middlePosition);
            element = (JSONObject) pathJsonArray.get(LAST_ARRAY_INDEX);

            xPosition = Math.toIntExact((long)element.get("x"));
            yPosition = Math.toIntExact((long)element.get("y"));
            //xPosition = (int) element.get("x");
            //yPosition = (int) element.get("y");
            Position squarePosition = new Position(xPosition, yPosition, LAST_ARRAY_INDEX);

            value = (String) element.get("obstaculo");
            obstacle = effectFactory.createSquare(value);

            path.add(new Square(obstacle, finishLineEffect, squarePosition));
        } catch (ClassCastException e) {
            throw new InvalidMapFile();
        }
        return path;
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
