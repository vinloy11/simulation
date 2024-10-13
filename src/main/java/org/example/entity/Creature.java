package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.map.Map;
import org.example.model.Coordinates;
import org.example.model.EntityName;

public abstract class Creature extends Entity {
    @Getter
    @Setter
    private int hp = 3;
    int speed = 1;

    public Creature(Coordinates coordinates, EntityName name) {
        super(coordinates, name);
    }

    protected abstract void makeMove(Map map);
}
