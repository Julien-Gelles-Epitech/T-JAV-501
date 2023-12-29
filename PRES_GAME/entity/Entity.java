package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import sprite.Sprite;

public abstract class Entity {

    public int worldX;
    public int worldY;
    public int speed;
    public Rectangle solidArea;
    public boolean collisionOn = false;
    
    public KeyHandler keyHandler;

    protected BufferedImage[] setStandingSprite(String file, int row) {
        BufferedImage[] buffer = {
            Sprite.getSprite(0, row, file)};
        return buffer;
    }

    protected BufferedImage[] setWalkingSprites(String file, int row) {
        BufferedImage[] buffer = {
            Sprite.getSprite(0, row, file),
            Sprite.getSprite(1, row, file),
            Sprite.getSprite(2, row, file),
            Sprite.getSprite(3, row, file),
            Sprite.getSprite(4, row, file),
            Sprite.getSprite(5, row, file),
            Sprite.getSprite(6, row, file),
            Sprite.getSprite(7, row, file),
            Sprite.getSprite(8, row, file)};
        return buffer;
    }

}