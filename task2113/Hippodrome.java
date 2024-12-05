package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();
    static Hippodrome game;
    public List<Horse> getHorses() {
        return horses;
    }
    public Hippodrome (List<Horse> horses) {
        this.horses = horses;
    }
    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Polly", 3, 0));
        horses.add(new Horse("Marshall", 3, 0));
        horses.add(new Horse("Kon", 3, 0));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
    void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    void move() {
        for (Horse h : horses) {
            h.move();
        }
    }
    void print() {
        for (Horse h : horses) {
            h.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner () {
        Horse winner = null;
        double max = 0;
        for (Horse h : horses) {
            if (h.distance > max) {
                winner = h;
                max = h.distance;
            }
        }
        return winner;
    }
    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
