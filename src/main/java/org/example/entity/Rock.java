package org.example.entity;

import org.example.model.Coordinates;
import org.example.model.EntityName;

public class Rock extends Entity {
    public Rock(Coordinates coordinates) {
        super(coordinates, EntityName.ROCK);
    }

    @Override
    public String getViewIcon() {
        return "\uD83D\uDDFF";
    }
}
