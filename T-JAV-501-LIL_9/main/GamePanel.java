package main;

import javax.swing.*;

import object.ObjectsManager;
import tile.*;
import entity.*;

import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    public final int COL = 25;
    public final int ROW = 15;

    final int FPS = 60;
    public final int scale = 4;
    final int originalTileSize = 16;
    public final int tileSize = originalTileSize * scale;

    public final int WIDTH = tileSize * COL;
    public final int HEIGHT = tileSize * ROW;
    KeyHandler keyH = new KeyHandler();
    public ObjectsManager ObjectsM = new ObjectsManager(this);
    Player player = new Player(this, keyH, tileSize * 2, tileSize * 7);
    PlayerTwo playerTwo = new PlayerTwo(this, keyH, tileSize * 22, tileSize * 7);
    Attack attack = new Attack(player, playerTwo, keyH, this);

    public CollisionChecker cCheker = new CollisionChecker(this);
    public TileManager tileM = new TileManager(this);
    public Site map = chooseMap();
    public Site chooseMap() {
        if (Math.random() > 0.5) return new Meadow(tileM, this);
        else return new Desert(tileM, this);
    }
    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        this.setLayout(null);

        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                System.out.println("FPS: 60");
                repaint();
                update();
                delta--;
            }
        }
    }

    private void update() {
        playerTwo.update();
        player.update();
        attack.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        map.draw(g2);
        ObjectsM.draw(g2);
        playerTwo.draw(g);
        player.draw(g);
        g2.dispose();
    }
}