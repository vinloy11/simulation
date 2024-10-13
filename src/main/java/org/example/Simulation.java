package org.example;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.actions.Actions;
import org.example.map.Map;
import org.example.render.Renderer;

@Data
public class Simulation {
    Renderer renderer = new Renderer();
    Actions actions = new Actions();
    public Map map = actions.initActions();

    public Simulation() {
        renderer.render(this.map);

        this.nextTurn();
    }

    /**
     * запустить бесконечный цикл симуляции и рендеринга
     */
    public void startSimulation() {

    }

    /**
     * просимулировать и отрендерить один ход
     */
    public void nextTurn() {
        this.actions.turnActions();
        renderer.render(this.map);

        System.out.println();

        //    -
    }

    /**
     * приостановить бесконечный цикл симуляции и рендеринга
     */
    public void pauseSimulation() {

    }
}
