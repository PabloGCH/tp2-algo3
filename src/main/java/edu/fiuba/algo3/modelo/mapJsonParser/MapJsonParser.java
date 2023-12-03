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
        int height;
        int width;
        ArrayList<Square> path = new ArrayList<>();
        try {
            int xPosition, yPosition;
            JSONObject measures = this.getMapObject(filePath);
            width = Math.toIntExact((long)measures.get("ancho"));
            height = Math.toIntExact((long)measures.get("largo"));
            JSONArray pathJsonArray = this.getPathObject(filePath);


            JSONObject element;
            String value;
            Square newSquare;
            EffectFactory prizeFactory, obstacleFactory;

            final int LAST_ARRAY_INDEX = pathJsonArray.size() - 1;
            for (int i = 0; i < LAST_ARRAY_INDEX; i++) {
                element = (JSONObject) pathJsonArray.get(i);

                value = (String) element.get("obstaculo");
                obstacleFactory = obtainObstacle(value);

                value = (String) element.get("premio");
                prizeFactory = obtainPrize(value);

                xPosition = (int) element.get("x");
                yPosition = (int) element.get("y");
                Position squarePosition = new Position(xPosition, yPosition, i);
                newSquare = new Square(obstacleFactory.createEffect(),prizeFactory.createEffect(), squarePosition);
                path.add(newSquare);
            }
            Position middlePosition = path.get((path.size() + 1) / 2).getPosition();
            var finishLineEffect = new FinishLineEffect();
            finishLineEffect.setMiddlePosition(middlePosition);
            element = (JSONObject) pathJsonArray.get(LAST_ARRAY_INDEX);

            xPosition = (int) element.get("x");
            yPosition = (int) element.get("y");
            Position squarePosition = new Position(xPosition, yPosition, LAST_ARRAY_INDEX);

            value = (String) element.get("obstaculo");
            obstacleFactory = obtainObstacle(value);

            path.add(new Square(obstacleFactory.createEffect(), finishLineEffect, squarePosition));
        } catch (ClassCastException e) {
            throw new InvalidMapFile();
        }
        return path;
    }
    private EffectFactory obtainObstacle(String type){
        switch (type) {
            case "Fiera":
                return new BeastFactory();
            case "Bacanal":
                return new BacchanaliaFactory();
            case "Lesion":
                return new InjuryFactory();
            default:
                return new NullEffectFactory();
        }
    }
    private EffectFactory obtainPrize(String type){
        switch (type) {
            case "Equipamiento":
                return new UpgradeFactory();
            case "Comida":
                return new FoodFactory();
            default:
                return new NullEffectFactory();
        }
    }
    /*
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
*/

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
