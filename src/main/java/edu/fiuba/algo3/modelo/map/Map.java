package edu.fiuba.algo3.modelo.map;
import java.util.ArrayList;

import edu.fiuba.algo3.modelo.squares.NullPosition;
import edu.fiuba.algo3.modelo.squares.Position;
import edu.fiuba.algo3.modelo.squares.PositionCollection;
import edu.fiuba.algo3.modelo.squares.SquareModel;


public class Map implements PositionCollection {
    private ArrayList<ArrayList<Position>> map;

    public Map(int width, int height, ArrayList<Position> path) {
        this.buildMap(width, height);
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

    public Position getPosition(int row, int column) {
        return this.map.get(row).get(column);
    }

}
