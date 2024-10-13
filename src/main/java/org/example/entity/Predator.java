package org.example.entity;

import org.example.map.Map;
import org.example.model.Coordinates;
import org.example.model.EntityName;
import org.example.search.Search;

import java.util.Set;

public class Predator extends Creature {
    public Predator(Coordinates coordinates) {
        super(coordinates, EntityName.PREDATOR);
    }

    @Override
    public String getViewIcon() {
        return "\uD83D\uDC3A";
    }

    @Override
    public void makeMove(Map map) {
        Search search = new Search();

        boolean thisIsPredator = map.getEntity(this.coordinates).name.equals(EntityName.PREDATOR);
        if (!thisIsPredator) {
            return;
        }

        Coordinates closestCoordinatesEntity = search.getClosestEntity(this.coordinates, EntityName.HERBIVORE, map);

        boolean isClosest = this.coordinates.isClosest(closestCoordinatesEntity);
        boolean isHerbivore = map.getEntity(closestCoordinatesEntity).name.equals(EntityName.HERBIVORE);

        if (isClosest && isHerbivore) {
            Herbivore herbivore = (Herbivore) map.getEntity(closestCoordinatesEntity);

            if (herbivore.getHp() > 1) {
                herbivore.setHp(herbivore.getHp() - 1);
            } else {
                map.deleteEntity(this.coordinates);
                this.setCoordinates(closestCoordinatesEntity);
                map.setEntity(closestCoordinatesEntity, this);
            }
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
