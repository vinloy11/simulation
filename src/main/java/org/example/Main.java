package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Simulation simulation = new Simulation();

        System.out.println("1: startSimulation");
        System.out.println("2: pauseSimulation");
        System.out.println("3: nextTurn");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        while (n != 0) {
            switch (n) {
                case 1:
                    simulation.startSimulation();
                    break;
                case 2:
                    simulation.pauseSimulation();
                    break;
                case 3:
                    simulation.nextTurn();
                    break;
            }

            n = scanner.nextInt();
        }
    }
}