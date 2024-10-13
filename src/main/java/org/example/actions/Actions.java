package org.example.actions;

import org.example.entity.*;
import org.example.map.Map;
import org.example.model.Coordinates;
import org.example.model.EntityName;

import java.util.HashMap;
import java.util.List;

public class Actions {
    private final Map map = new Map(10, 10);

    /**
     * действия, совершаемые перед стартом симуляции.
     * Пример - расставить объекты и существ на карте
     */
    public Map initActions() {
        this.createEntities();

        return map;
    }

    /**
     * действия, совершаемые каждый ход.
     * Примеры - передвижение существ, добавить травы или травоядных, если их осталось слишком мало
     */
    public void turnActions() {
        HashMap<Coordinates, Entity> cloneMapEntities = new HashMap<>(this.map.getEntities());

        cloneMapEntities.values().forEach(entity -> {
            if (entity instanceof Predator predator) {
                predator.makeMove(this.map);
                return;
            }

            if (entity instanceof Herbivore herbivore) {
                herbivore.makeMove(this.map);
            }
        });
    }

    private void createEntities() {
        this.createEntitiesByEntityName(EntityName.GRASS);
        this.createEntitiesByEntityName(EntityName.ROCK);
        this.createEntitiesByEntityName(EntityName.TREE);
        this.createEntitiesByEntityName(EntityName.HERBIVORE);
        this.createEntitiesByEntityName(EntityName.PREDATOR);
    }

    private void createEntitiesByEntityName(EntityName entityName) {
        // 100 -> 100 / 10
        // 100 -> 100 / 20
        //
        int mapCount = this.map.getWidth() * this.map.getHeight();

        switch (entityName) {
            case GRASS:
                for (int i = 0; i < mapCount / 5; i++) {
                    Coordinates coordinates = this.getRandomCoordinates();
                    Grass grass = new Grass(coordinates);
                    this.map.setEntity(coordinates, grass);
                }
                break;
            case ROCK:
                for (int i = 0; i < mapCount / 10; i++) {
                    Coordinates coordinates = this.getRandomCoordinates();
                    Rock rock = new Rock(coordinates);
                    this.map.setEntity(coordinates, rock);
                }
                break;
            case TREE:
                for (int i = 0; i < mapCount / 20; i++) {
                    Coordinates coordinates = this.getRandomCoordinates();
                    Tree tree = new Tree(coordinates);
                    this.map.setEntity(coordinates, tree);
                }
                break;
            case HERBIVORE:
                for (int i = 0; i < mapCount / 10; i++) {
                    Coordinates coordinates = this.getRandomCoordinates();
                    Herbivore herbivore = new Herbivore(coordinates);
                    this.map.setEntity(coordinates, herbivore);
                }
                break;
            case PREDATOR:
                for (int i = 0; i < mapCount / 10; i++) {
                    Coordinates coordinates = this.getRandomCoordinates();
                    Predator predator = new Predator(coordinates);
                    this.map.setEntity(coordinates, predator);
                }
                break;
        }
    }

    private Coordinates getRandomCoordinates() {
        int randomY = (int) (Math.random() * this.map.getHeight());
        int randomX = (int) (Math.random() * this.map.getHeight());
        Coordinates coordinates = Coordinates.builder().y(randomY).x(randomX).build();

        if (this.map.isCoordinatesEmpty(coordinates)) {
            return coordinates;
        } else {
            return this.getRandomCoordinates();
        }
    }
}
