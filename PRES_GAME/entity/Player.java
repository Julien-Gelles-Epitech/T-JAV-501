package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import main.GamePanel;
import main.KeyHandler;
import sprite.Animation;

public class Player extends Entity{
    
    private GamePanel gamePanel;
    private KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;

    private Animation walkLeft = new Animation(setWalkingSprites("res/player/sprite.png", 9), 5);
    private Animation walkRight = new Animation(setWalkingSprites("res/player/sprite.png", 11), 5);
    private Animation walkUp = new Animation(setWalkingSprites("res/player/sprite.png", 8), 5);
    private Animation walkDown = new Animation(setWalkingSprites("res/player/sprite.png", 10), 5);

    private Animation standUp = new Animation(setStandingSprite("res/player/sprite.png", 8), 8);
    private Animation standDown = new Animation(setStandingSprite("res/player/sprite.png", 10), 8);
    private Animation standLeft = new Animation(setStandingSprite("res/player/sprite.png", 9), 8);
    private Animation standRight = new Animation(setStandingSprite("res/player/sprite.png", 11), 8);

    private Animation standing = standDown;
    private Animation animation = standing;
    
    

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        this.worldX = gamePanel.tileSize * 17;
        this.worldY = gamePanel.tileSize * 23;
        this.speed = 2*gamePanel.scale;
        this.screenX = gamePanel.screenWidth/2-(gamePanel.tileSize/2);
        this.screenY = 8*gamePanel.screenHeight/10;
        this.keyHandler = keyHandler;
        this.solidArea = new Rectangle((int) (3 * gamePanel.tileSize / 10), (int) (6 * gamePanel.tileSize / 10), (int) (4 * gamePanel.tileSize / 10), (int) (3 * gamePanel.tileSize / 10));

    }

    public void update() {
        collisionOn = false;
        gamePanel.collisionChecker.checkTile(this);

        if (keyHandler.upPressed || keyHandler.downPressed || keyHandler.leftPressed || keyHandler.rightPressed) {
            if (keyHandler.upPressed) {
                if (!this.collisionOn) worldY -= speed;
                animation = walkUp;
                standing = standUp;
            }
            if (keyHandler.downPressed) {
                if (!this.collisionOn) worldY += speed;
                animation = walkDown;
                standing = standDown;
            }
            if (keyHandler.leftPressed) {
                if (!this.collisionOn) worldX -= speed;
                animation = walkLeft;
                standing = standLeft;
            }
            if (keyHandler.rightPressed) {
                if (!this.collisionOn) worldX += speed;
                animation = walkRight;
                standing = standRight;
            }
            animation.start();
        } else {
            animation.stop();
            this.animation = standing;
        }
        animation.update();
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(animation.getSprite(), this.screenX, this.screenY, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
