package org.example;

import lombok.Data;
import org.example.actions.Actions;
import org.example.map.Map;
import org.example.render.Renderer;

import java.io.IOException;

@Data
public class Simulation {
    Renderer renderer = new Renderer();
    Actions actions = new Actions();
    public Map map = actions.initActions();
    boolean aliveSimulation = true;

    public Simulation() {
        renderer.render(this.map);
    }

    /**
     * запустить бесконечный цикл симуляции и рендеринга
     */
    public void startSimulation() throws InterruptedException {
        while (aliveSimulation) {
            this.nextTurn();
            Thread.sleep(2000);
        }
    }

    /**
     * просимулировать и отрендерить один ход
     */
    public void nextTurn() {
        this.actions.turnActions();
        renderer.render(this.map);
    }

    /**
     * приостановить бесконечный цикл симуляции и рендеринга
     */
    public void pauseSimulation() {
        this.aliveSimulation = false;
    }
}
