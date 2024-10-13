package org.example.entity;

import org.example.model.Coordinates;
import org.example.model.EntityName;

public class Tree extends Entity {
    public Tree(Coordinates coordinates) {
        super(coordinates, EntityName.TREE);
    }

    @Override
    public String getViewIcon() {
        return "\uD83C\uDF33";
    }
}
