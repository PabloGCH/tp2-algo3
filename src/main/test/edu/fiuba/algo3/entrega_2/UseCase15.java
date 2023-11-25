package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.mapJsonParser.*;
import edu.fiuba.algo3.modelo.squares.Beast;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UseCase15 {
    @Test
        void EnemiesFileReturnsEnemiesArray() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        EnemyParser parser = new EnemyParser();
        ArrayList<Beast> enemies;
        enemies = parser.loadEnemies("src/main/resources/files/enemies.json",
                    "enemies.json");
        assertTrue(enemies.get(0) instanceof Beast);
        assertTrue(enemies.get(1) instanceof Beast);
        assertTrue(enemies.get(2) instanceof Beast);
        assertTrue(enemies.get(3) instanceof Beast);
        assertTrue(enemies.get(4) instanceof Beast);
    }
}
