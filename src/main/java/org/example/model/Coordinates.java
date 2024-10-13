package org.example.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Coordinates {
    private int x;
    private int y;

    public boolean isClosest(Coordinates coordinates) {
        int currentCoordinateSum = this.getX() + this.getY();
        int coordinateSum = coordinates.getX() + coordinates.getY();
        return Math.abs(coordinateSum - currentCoordinateSum) == 1;
    }
}
