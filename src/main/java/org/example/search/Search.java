package org.example.search;

import lombok.Getter;
import org.example.entity.Entity;
import org.example.map.Map;
import org.example.model.Coordinates;
import org.example.model.EntityName;

import java.util.*;

public class Search {
    @Getter
    private final Queue<Coordinates> coordinatesQueue = new LinkedList<>();
    @Getter
    private final Set<Coordinates> visitedCoordinates = new HashSet<>();

    public Coordinates getClosestEntity(Coordinates currentCoordinates, EntityName entityName, Map map) {
        coordinatesQueue.add(currentCoordinates);

        // 4,1
        // 6,0
        while (!coordinatesQueue.isEmpty()) {
            Coordinates coordinates = coordinatesQueue.remove();
            Entity entity = map.getEntity(coordinates);
            if (entity != null && entity.getName().equals(entityName)) {
                return coordinates;
            }

            visitedCoordinates.add(coordinates);

            int x = coordinates.getX();
            int y = coordinates.getY();

            if (x - 1 >= 0) {
                Coordinates newCoordinates = Coordinates.builder().x(x-1).y(y).build();
                if (!visitedCoordinates.contains(newCoordinates)) {
                    coordinatesQueue.add(newCoordinates);
                };
            }

            if (x + 1 < map.getWidth()) {
                Coordinates newCoordinates = Coordinates.builder().x(x+1).y(y).build();
                if (!visitedCoordinates.contains(newCoordinates)) {
                    coordinatesQueue.add(newCoordinates);
                };
            }

            if (y - 1 >= 0) {
                Coordinates newCoordinates = Coordinates.builder().x(x).y(y-1).build();
                if (!visitedCoordinates.contains(newCoordinates)) {
                    coordinatesQueue.add(newCoordinates);
                };
            }

            if (y + 1 < map.getHeight()) {
                Coordinates newCoordinates = Coordinates.builder().x(x).y(y+1).build();
                if (!visitedCoordinates.contains(newCoordinates)) {
                    coordinatesQueue.add(newCoordinates);
                };
            }
        }

        return currentCoordinates;
    }

}