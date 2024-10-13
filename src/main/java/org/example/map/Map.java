package org.example.map;

import lombok.Data;
import org.example.entity.Entity;
import org.example.entity.Rock;
import org.example.model.Coordinates;

import java.util.ArrayList;
import java.util.HashMap;

@Data
public class Map {
    // 1) x10,y10 -> create entities -> MAP tree(empty and not empty) - initActions
    // 2) forEach(tree) -> if not null -> makeMove() -> findEntity() -> step(this.mapXY = null, new x,y = entity) - turnActions
    // 2) tree -> [][] -> print
    private int width;
    private int height;
    private HashMap<Coordinates, Entity> entities = new HashMap<>();


    public Map(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private void initMap() {

    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        entities.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.getOrDefault(coordinates, null);
    }

    public boolean isCoordinatesEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }
}
