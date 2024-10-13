package org.example.entity;

import org.example.map.Map;
import org.example.model.Coordinates;
import org.example.model.EntityName;
import org.example.search.Search;

/**
 * Травоядное
 * Может кушать и бегать
 */
public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates) {
        super(coordinates, EntityName.HERBIVORE);
    }

    @Override
    public String getViewIcon() {
        return "\uD83D\uDC04";
    }

    @Override
    public void makeMove(Map map) {
        Search search = new Search();

        Coordinates closestCoordinatesEntity = search.getClosestEntity(this.coordinates, EntityName.GRASS, map);

        // x y
        // 5 1 grass
        // 4 1 cow
        //
        //

        System.out.println(closestCoordinatesEntity);
    }
}
