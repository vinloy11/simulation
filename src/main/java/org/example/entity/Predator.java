package org.example.entity;

import org.example.map.Map;
import org.example.model.Coordinates;
import org.example.model.EntityName;

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
//        System.out.println("Predator make move");
    }
}
