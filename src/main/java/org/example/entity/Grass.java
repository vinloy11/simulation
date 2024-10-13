package org.example.entity;

import org.example.model.Coordinates;
import org.example.model.EntityName;

public class Grass extends Entity {
    public Grass(Coordinates coordinates) {
        super(coordinates, EntityName.GRASS);
    }

    @Override
    public String getViewIcon() {
        return "\uD83E\uDEBA";
    }
}
