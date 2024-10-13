package org.example.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Coordinates {
    private int x;
    private int y;

    public boolean isClosest(Coordinates coordinates) {
        boolean x = Math.abs(this.getX() - coordinates.getX()) <= 1;
        boolean y =  Math.abs(this.getY() - coordinates.getY()) <= 1;
        return x && y;
    }
}
