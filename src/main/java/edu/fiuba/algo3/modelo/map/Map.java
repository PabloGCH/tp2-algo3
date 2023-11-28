package edu.fiuba.algo3.modelo.map;
import java.util.ArrayList;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.NullPosition;
import edu.fiuba.algo3.modelo.squares.Position;
import edu.fiuba.algo3.modelo.squares.PositionCollection;
import edu.fiuba.algo3.modelo.squares.Square;


public class Map implements PositionCollection {
    private ArrayList<ArrayList<Position>> map;
    private ArrayList<Position> path;

    public Map(int width, int height, ArrayList<Position> path) {
        this.buildMap(width, height);
        this.path = path;
        for (Position position : path) {
            position.positionSelf(this);
        }
    }

    private void buildMap(int width, int height) {
        this.map = new ArrayList<>();
        for(int i = 0; i < width; i++) {
            this.map.add(new ArrayList<>());
            for(int j = 0; j < height; j++) {
                this.map.get(i).add(new NullPosition());
            }
        }
    }

    public void setPosition(int x, int y, Position position) {
        this.map.get(x).set(y, position);
    }

    public void draw() {}

    public ArrayList<Position> getPath(){
        return path;
    }

    public void sendGladiatorToMiddle(Gladiator aGladiator){
        int middleIndex = (int) (path.stream().count() + 1) / 2;
        Position middleSquare = path.get(middleIndex);
        Position lastSquare = path.get(path.size() -1);
        middleSquare.receivePiece(aGladiator);
        lastSquare.removePiece(aGladiator);
    }
}
