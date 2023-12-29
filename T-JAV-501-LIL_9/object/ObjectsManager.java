package object;

import main.GamePanel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.*;

public class ObjectsManager {
    public int randomCol, randomRow, randomNumber;
    private GamePanel gamePanel;
    private Object[] objects;
    public Object currentItem;

    public ObjectsManager(GamePanel gp_) {
        this.gamePanel = gp_;
        this.objects = new Object[10];
        getObjectsImage();
        scheduleRandomObject();
    }

    private void getObjectsImage() {
        try {
            objects[0] = new Object();
            objects[0].setImage(ImageIO.read(new File("res/weapons/blue.png")));
            objects[0].setName("blue");
            objects[1] = new Object();
            objects[1].setImage(ImageIO.read(new File("res/weapons/green.png")));
            objects[1].setName("green");
            objects[2] = new Object();
            objects[2].setImage(ImageIO.read(new File("res/weapons/red.png")));
            objects[2].setName("red");
            objects[3] = new Object();
            objects[3].setImage(ImageIO.read(new File("res/weapons/katana.png")));
            objects[3].setName("katana");
            objects[4] = new Object();
            objects[4].setImage(ImageIO.read(new File("res/weapons/shield.png")));
            objects[4].setName("shield");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void scheduleRandomObject() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                getRandomObject();
            }
        }, 0, 5000);
    }

    private void getRandomObject() {
        Random rand = new Random();
        randomNumber = rand.nextInt(5);
        randomCol = rand.nextInt(gamePanel.COL);
        randomRow = rand.nextInt(gamePanel.ROW);
        currentItem = this.objects[randomNumber];
    }

    public void draw(Graphics2D g2) {
        if (currentItem != null) {
            if (gamePanel.map.getMapTiles()[randomCol][randomRow] == 2 || gamePanel.map.getMapTiles()[randomCol][randomRow] == 0) {
                g2.drawImage(this.currentItem.getImage(), randomCol * gamePanel.tileSize, randomRow * gamePanel.tileSize, gamePanel.tileSize, gamePanel.tileSize, null);
            } else {
                getRandomObject();
                draw(g2);
            }
        }
    }
}
