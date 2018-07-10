package com.game.zmeika.main;

public class Fruit {
    public int applePositionX;
    public int applePositionY;

    public Fruit(int applePositionX, int applePositionY) {
        this.applePositionX = applePositionX;
        this.applePositionY = applePositionY;
    }

    public void setApplePosition() {
        applePositionX = (int) (Math.random() * Launcher.WIDTH);
        applePositionY = (int) (Math.random() * Launcher.HEIGHT);
    }
}
