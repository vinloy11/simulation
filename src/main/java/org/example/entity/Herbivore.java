package org.example.entity;

import org.example.map.Map;
import org.example.model.Coordinates;
import org.example.model.EntityName;
import org.example.search.Search;

import java.util.Set;

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

        boolean thisIsCow = map.getEntity(this.coordinates).name.equals(EntityName.HERBIVORE);
        if (!thisIsCow) {
            return;
        }

        Coordinates closestCoordinatesEntity = search.getClosestEntity(this.coordinates, EntityName.GRASS, map);
        boolean isClosest = this.coordinates.isClosest(closestCoordinatesEntity);
        boolean isGrass = map.getEntity(closestCoordinatesEntity).name.equals(EntityName.GRASS);

        if (isClosest && isGrass) {
            map.deleteEntity(this.coordinates);
            this.setCoordinates(closestCoordinatesEntity);
            map.setEntity(closestCoordinatesEntity, this);
        } else {
            this.move(map, search);
        }
    }

    private void move(Map map, Search search) {
        Set<Coordinates> visitedCoordinates = search.getVisitedCoordinates();

        for (Coordinates coordinates : visitedCoordinates) {
            if (map.isCoordinatesEmpty(coordinates) && this.coordinates.isClosest(coordinates)) {
                map.deleteEntity(this.coordinates);
                this.setCoordinates(coordinates);
                map.setEntity(coordinates, this);
                break;
            }
        }
    }
}
