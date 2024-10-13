package org.example.render;

import org.example.entity.Entity;
import org.example.map.Map;
import org.example.model.Coordinates;

public class Renderer {
    public void render(Map map) {
        System.out.println("\033\143");

        for (int j = 0; j < map.getHeight(); j++) {
            for (int i = 0; i < map.getWidth(); i++) {
                Coordinates coordinates = Coordinates.builder().x(i).y(j).build();
                Entity entity = map.getEntity(coordinates);
                if (entity != null) {
                    System.out.print(entity.getViewIcon());
                } else {
                    System.out.print("⬛");
                }
                if (i == map.getWidth() - 1) {
                    System.out.println();
                }
            }
        }
    }
}
