package org.example.entity;

import lombok.Data;
import org.example.model.Coordinates;
import org.example.model.EntityName;

@Data
public abstract class Entity {
    protected Coordinates coordinates;
    protected EntityName name;

    public Entity(Coordinates coordinates, EntityName name) {
        this.coordinates = coordinates;
        this.name = name;
    }

    public abstract String getViewIcon();
}
