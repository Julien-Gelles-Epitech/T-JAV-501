package entity;

import main.KeyHandler;
import main.Main;

import java.awt.*;

import java.io.IOException;
import java.util.Timer;


public class Entity {
    public int x;
    public int y;
    public int speed = 2;
    public Rectangle solidArea;
    public boolean collisionOn = false;
    public KeyHandler keyH;
    public int power = 1;
    public int life = 50;

    public int block;

    public boolean attack = false;
    public Timer timer = new Timer();

    public int count = 0;


    public void gameOver(String currentDead, String imgSprite) throws IOException, FontFormatException {
        Main.gameOver(currentDead, imgSprite);
    }

    public void getDamage(int damage) {
        this.life -= damage;
        if (life < 0 ){
            life = 0;
        }
    }
}
