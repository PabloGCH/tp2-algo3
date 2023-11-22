package edu.fiuba.algo3.modelo.mapJsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import edu.fiuba.algo3.modelo.squares.Beast;

public class EnemyParser {
    public ArrayList<Beast> loadEnemies(String filePath, String fileName) throws  MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile{
        ArrayList<Beast> enemies = new ArrayList<>();
        try {
            JSONArray enemiesJsonArray = this.getEnemiesObject(filePath);
            for (Object element : enemiesJsonArray) {
                JSONObject object = (JSONObject) element;
                String value = (String) object.get("Enemy");
                Beast newBeast = new Beast(); //It may require to implement a constructor with the name of the enemy
                enemies.add(newBeast);
            }
        } catch(ClassCastException e) {
            //IT CAN BE ASSUMED THAT IF IT FAILS TO CAST AN OBJECT IS BECAUSE THE JSON IS INVALID
            //SINCE IS ONLY CASTING AFTER GETTING VALUES FROM THE FILE
            throw new InvalidMapFile();
        }
        return enemies;
    }

    public JSONArray getEnemiesObject(String filePath) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
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
            if(!mapjsonObject.containsKey("enemies")){
                throw new InvalidMapFile();
            }
            return (JSONArray) mapjsonObject.get("enemies");
        } catch(FileNotFoundException e) {
            throw new MapFileNotFound();
        } catch(IOException e) {
            throw new MapFileFailedToOpenOrClose();
        } catch(ParseException e) {
            throw new MapFileCouldNotBeParsed();
        }
    }
}
