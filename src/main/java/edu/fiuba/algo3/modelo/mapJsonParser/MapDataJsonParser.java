package edu.fiuba.algo3.modelo.mapJsonParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapDataJsonParser {
    public ArrayList<Integer> loadData(String filePath) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        int height;
        int width;
        ArrayList<Integer> data = new ArrayList<>();
        try {
            JSONObject measures = this.getMapObject(filePath);
            width = Math.toIntExact((long)measures.get("ancho"));
            height = Math.toIntExact((long)measures.get("largo"));
            data.add(width);
            data.add(height);
        } catch (ClassCastException e) {
            throw new InvalidMapFile();
        }
        return data;
    }
    private JSONObject getMapObject(String filePath) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        FileReader reader;
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
}