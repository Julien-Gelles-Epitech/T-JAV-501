  package entity;

import main.GamePanel;
import main.KeyHandler;
import object.ObjectsManager;
import sprite.Animation;
import sprite.Sprite;
import tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.util.Objects;

import java.util.TimerTask;


  public class Player extends Entity {
    GamePanel gamePanel;
    String direction = "down";
    boolean offensive;
    boolean defensive;
    ObjectsManager obj;

    public BufferedImage[] setWalkingSprites(String file, int row) {
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

    public BufferedImage[] setAttackingSprites(String file, int row) {
        BufferedImage[] buffer = {
            Sprite.getSprite(0, row, file),
            Sprite.getSprite(1, row, file),
            Sprite.getSprite(2, row, file),
            Sprite.getSprite(3, row, file),
            Sprite.getSprite(4, row, file),
            Sprite.getSprite(5, row, file)};
        return buffer;
    }

    private Animation walkLeft = new Animation(setWalkingSprites("res/player/sprite.png", 9), 5);
    private Animation walkRight = new Animation(setWalkingSprites("res/player/sprite.png", 11), 5);
    private Animation walkUp = new Animation(setWalkingSprites("res/player/sprite.png", 8), 5);
    private Animation walkDown = new Animation(setWalkingSprites("res/player/sprite.png", 10), 8);
    private Animation attackDown = new Animation(setAttackingSprites("res/player/sprite.png", 14), 5);
    private Animation attackUp = new Animation(setAttackingSprites("res/player/sprite.png", 12), 5);
    private Animation attackLeft = new Animation(setAttackingSprites("res/player/sprite.png", 13), 5);
    private Animation attackRight = new Animation(setAttackingSprites("res/player/sprite.png", 15), 5);
    BufferedImage[] upStand = {Sprite.getSprite(0, 8, "res/player/sprite.png")};
    BufferedImage[] downStand = {Sprite.getSprite(0, 10, "res/player/sprite.png")};
    BufferedImage[] leftStand = {Sprite.getSprite(0, 9, "res/player/sprite.png")};
    BufferedImage[] rightStand = {Sprite.getSprite(0, 11, "res/player/sprite.png")};
    BufferedImage[] deadStand = {Sprite.getSprite(5, 20, "res/player/sprite.png")};

    private Animation walkLeftKatana = new Animation(setWalkingSprites("res/player/spriteDagger.png", 9), 5);
    private Animation walkRightKatana = new Animation(setWalkingSprites("res/player/spriteDagger.png", 11), 5);
    private Animation walkUpKatana = new Animation(setWalkingSprites("res/player/spriteDagger.png", 8), 5);
    private Animation walkDownKatana = new Animation(setWalkingSprites("res/player/spriteDagger.png", 10), 8);
    private Animation attackDownKatana = new Animation(setAttackingSprites("res/player/spriteDagger.png", 14), 5);
    private Animation attackUpKatana = new Animation(setAttackingSprites("res/player/spriteDagger.png", 12), 5);
    private Animation attackLeftKatana = new Animation(setAttackingSprites("res/player/spriteDagger.png", 13), 5);
    private Animation attackRightKatana = new Animation(setAttackingSprites("res/player/spriteDagger.png", 15), 5);
    BufferedImage[] upStandKatana = {Sprite.getSprite(0, 8, "res/player/spriteDagger.png")};
    BufferedImage[] downStandKatana = {Sprite.getSprite(0, 10, "res/player/spriteDagger.png")};
    BufferedImage[] leftStandKatana = {Sprite.getSprite(0, 9, "res/player/spriteDagger.png")};
    BufferedImage[] rightStandKatana = {Sprite.getSprite(0, 11, "res/player/spriteDagger.png")};
    BufferedImage[] deadStandKatana = {Sprite.getSprite(5, 20, "res/player/spriteDagger.png")};


    private Animation walkLeftShield = new Animation(setWalkingSprites("res/player/spriteShield.png", 9), 5);
    private Animation walkRightShield = new Animation(setWalkingSprites("res/player/spriteShield.png", 11), 5);
    private Animation walkUpShield = new Animation(setWalkingSprites("res/player/spriteShield.png", 8), 5);
    private Animation walkDownShield = new Animation(setWalkingSprites("res/player/spriteShield.png", 10), 8);
    private Animation attackDownShield = new Animation(setAttackingSprites("res/player/spriteShield.png", 14), 5);
    private Animation attackUpShield = new Animation(setAttackingSprites("res/player/spriteShield.png", 12), 5);
    private Animation attackLeftShield = new Animation(setAttackingSprites("res/player/spriteShield.png", 13), 5);
    private Animation attackRightShield = new Animation(setAttackingSprites("res/player/spriteShield.png", 15), 5);
    BufferedImage[] upStandShield = {Sprite.getSprite(0, 8, "res/player/spriteShield.png")};
    BufferedImage[] downStandShield = {Sprite.getSprite(0, 10, "res/player/spriteShield.png")};
    BufferedImage[] leftStandShield = {Sprite.getSprite(0, 9, "res/player/spriteShield.png")};
    BufferedImage[] rightStandShield = {Sprite.getSprite(0, 11, "res/player/spriteShield.png")};
    BufferedImage[] deadStandShield = {Sprite.getSprite(5, 20, "res/player/spriteShield.png")};


    private Animation walkLeftBoth = new Animation(setWalkingSprites("res/player/spriteBoth.png", 9), 5);
    private Animation walkRightBoth = new Animation(setWalkingSprites("res/player/spriteBoth.png", 11), 5);
    private Animation walkUpBoth = new Animation(setWalkingSprites("res/player/spriteBoth.png", 8), 5);
    private Animation walkDownBoth = new Animation(setWalkingSprites("res/player/spriteBoth.png", 10), 8);
    private Animation attackDownBoth = new Animation(setAttackingSprites("res/player/spriteBoth.png", 14), 5);
    private Animation attackUpBoth = new Animation(setAttackingSprites("res/player/spriteBoth.png", 12), 5);
    private Animation attackLeftBoth = new Animation(setAttackingSprites("res/player/spriteBoth.png", 13), 5);
    private Animation attackRightBoth = new Animation(setAttackingSprites("res/player/spriteBoth.png", 15), 5);
    BufferedImage[] upStandBoth = {Sprite.getSprite(0, 8, "res/player/spriteBoth.png")};
    BufferedImage[] downStandBoth = {Sprite.getSprite(0, 10, "res/player/spriteBoth.png")};
    BufferedImage[] leftStandBoth = {Sprite.getSprite(0, 9, "res/player/spriteBoth.png")};
    BufferedImage[] rightStandBoth = {Sprite.getSprite(0, 11, "res/player/spriteBoth.png")};
    BufferedImage[] deadStandBoth = {Sprite.getSprite(5, 20, "res/player/spriteBoth.png")};

    private Animation standing = new Animation(downStand, 10);
    private Animation animation = standing;

    private Animation dance = new Animation(setAttackingSprites("res/player/sprite.png", 2), 5);


    public Player(GamePanel gamePanel, KeyHandler keyHandler, int x, int y) {
        this.gamePanel = gamePanel;
        this.keyH = keyHandler;
        this.x = x;
        this.y = y;
        this.speed = gamePanel.scale;
        this.obj = gamePanel.ObjectsM;
        solidArea = new Rectangle((int) (4 * gamePanel.tileSize / 10), (int) (8 * gamePanel.tileSize / 10), (int) (4 * gamePanel.tileSize / 10), (int) (1 * gamePanel.tileSize / 3));
    }

    public void update() {
        collisionOn = false;
        gamePanel.cCheker.checkTile(this);

        int currentRow = (int) ((this.y + (8 * gamePanel.tileSize / 10)) / gamePanel.tileSize);
        int currentCol = (int) ((this.x + (gamePanel.tileSize / 2)) / gamePanel.tileSize);

        int tileNb = gamePanel.map.getMapTiles()[currentCol][currentRow];
        Tile currentTile = gamePanel.tileM.getTiles()[tileNb];
        if (life <= 0) {
            direction = "dead";
            if (count == 0 ) {
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            gameOver("joueur 1", "res/player/sprite.png");
                        } catch (IOException | FontFormatException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, 650);
            }
            count+=1;
        }


        if (obj.currentItem != null && currentCol == obj.randomCol && currentRow == obj.randomRow) {
            switch (obj.currentItem.getName()) {
                case "blue":
                    speed += 1;
                    obj.currentItem = null;
                    break;
                case "katana":
                    power += 5;
                    this.offensive = true;
                    obj.currentItem = null;
                    break;
                case "shield":
                    block += 2;
                    this.defensive = true;
                    obj.currentItem = null;
                    break;
                case "green":
                    life += 10;
                    obj.currentItem = null;
                    break;
                case "red":
                    power += 2;
                    obj.currentItem = null;
                    break;
            }
        }
            if (!Objects.equals(direction, "dead") && keyH.upPressed || !Objects.equals(direction, "dead") &&  keyH.downPressed || !Objects.equals(direction, "dead") &&  keyH.leftPressed || !Objects.equals(direction, "dead") &&  keyH.rightPressed || !Objects.equals(direction, "dead") &&  keyH.isAttackPressed ) {
                keyH.isDancing = false;
                if (keyH.isAttackPressed) {
                    attack = true;
                    switch (direction) {
                        case "up":
                            if (this.offensive && this.defensive) animation = attackUpBoth;
                            else if (this.offensive) animation = attackUpKatana;
                            else if (this.defensive) animation = attackUpShield;
                            else animation = attackUp;
                            animation.start();
                            timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    keyH.isAttackPressed = false;
                                }
                            }, 650);
                            break;
                        case "down":
                            if (this.offensive && this.defensive) animation = attackDownBoth;
                            else if (this.offensive) animation = attackDownKatana;
                            else if (this.defensive) animation = attackDownShield;
                            else animation = attackDown;
                            animation.start();
                            timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    keyH.isAttackPressed = false;
                                }
                            }, 650);
                            break;
                        case "left":
                            if (this.offensive && this.defensive) animation = attackLeftBoth;
                            else if (this.offensive) animation = attackLeftKatana;
                            else if (this.defensive) animation = attackLeftShield;
                            else animation = attackLeft;
                            animation.start();
                            timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    keyH.isAttackPressed = false;
                                }
                            }, 650);
                            break;
                        case "right":
                            if (this.offensive && this.defensive) animation = attackRightBoth;
                            else if (this.offensive) animation = attackRightKatana;
                            else if (this.defensive) animation = attackRightShield;
                            else animation = attackRight;
                            animation.start();
                            timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    keyH.isAttackPressed = false;
                                }
                            }, 650);
                            break;
                    }
                } else {
                    if (keyH.upPressed) {
                        if (!this.collisionOn) y -= speed + currentTile.getSpeedChange();
                        direction = "up";
                        if (this.offensive && this.defensive) animation = walkUpBoth;
                        else if (this.offensive) animation = walkUpKatana;
                        else if (this.defensive) animation = walkUpShield;
                        else animation = walkUp;
                        animation.start();
                    }
                    if (keyH.downPressed) {
                        if (!this.collisionOn) y += speed + currentTile.getSpeedChange();
                        direction = "down";
                        if (this.offensive && this.defensive) animation = walkDownBoth;
                        else if (this.offensive) animation = walkDownKatana;
                        else if (this.defensive) animation = walkDownShield;
                        else animation = walkDown;
                        animation.start();
                    }
                    if (keyH.leftPressed) {
                        if (!this.collisionOn) x -= speed + currentTile.getSpeedChange();
                        direction = "left";
                        if (this.offensive && this.defensive) animation = walkLeftBoth;
                        else if (this.offensive) animation = walkLeftKatana;
                        else if (this.defensive) animation = walkLeftShield;
                        else animation = walkLeft;
                        animation.start();
                    }
                    if (keyH.rightPressed) {
                        if (!this.collisionOn) x += speed + currentTile.getSpeedChange();
                        direction = "right";
                        if (this.offensive && this.defensive) animation = walkRightBoth;
                        else if (this.offensive) animation = walkRightKatana;
                        else if (this.defensive) animation = walkRightShield;
                        else animation = walkRight;
                        animation.start();
                    }
                }
            } else {
                switch (direction) {
                    case "dead":
                        keyH.isDancing = false;
                        if (this.offensive && this.defensive) standing = new Animation(deadStandBoth, 10);
                        else if (this.offensive) standing = new Animation(deadStandKatana, 10);
                        else if (this.defensive) standing = new Animation(deadStandShield, 10);
                        else standing = new Animation(deadStand, 10);
                        break;
                    case "up":
                        if (this.offensive && this.defensive) standing = new Animation(upStandBoth, 10);
                        else if (this.offensive) standing = new Animation(upStandKatana, 10);
                        else if (this.defensive) standing = new Animation(upStandShield, 10);
                        else standing = new Animation(upStand, 10);
                        break;
                    case "down":
                        if (this.offensive && this.defensive) standing = new Animation(downStandBoth, 10);
                        else if (this.offensive) standing = new Animation(downStandKatana, 10);
                        else if (this.defensive) standing = new Animation(downStandShield, 10);
                        else standing = new Animation(downStand, 10);
                        break;
                    case "left":
                        if (this.offensive && this.defensive) standing = new Animation(leftStandBoth, 10);
                        else if (this.offensive) standing = new Animation(leftStandKatana, 10);
                        else if (this.defensive) standing = new Animation(leftStandShield, 10);
                        else standing = new Animation(leftStand, 10);
                        break;
                    case "right":
                        if (this.offensive && this.defensive) standing = new Animation(rightStandBoth, 10);
                        else if (this.offensive) standing = new Animation(rightStandKatana, 10);
                        else if (this.defensive) standing = new Animation(rightStandShield, 10);
                        else standing = new Animation(rightStand, 10);
                        break;

                }
                animation.stop();
                if (keyH.isDancing){
                    this.animation = dance;
                    animation.start();
                }
                else this.animation = standing;
            }
            animation.update();
        }

        public void draw(Graphics g2) {
            g2.drawImage(animation.getSprite(), x, y, (int) (gamePanel.tileSize * 1.2), (int) (gamePanel.tileSize * 1.2), null);
            int barWidth = 100;
            int barHeight = 10;
            int barX = 10;
            int barY = 10;
    
            int filledWidth = (int) ((double) life / 50 * barWidth);
            g2.setColor(Color.RED);
            g2.fillRect(barX, barY, barWidth, barHeight);
            g2.setColor(Color.GREEN);
            g2.fillRect(barX, barY, filledWidth, barHeight);
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("default", Font.BOLD, 16));
            g2.drawString("Health : " + life, barX, barY + 23);
            g2.drawString("Strength : " + power, barX + 100, barY + 23);
            g2.drawString("Block : " + block, barX + 210, barY + 23);
        }
}