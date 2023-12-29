package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import diapos.DiapoManager;
import entity.Player;
import tile.PresentationMap;
import tile.Site;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
    
    private final int originalTileSize = 16;
    public final int scale = 5;
    public final int tileSize = originalTileSize*scale;
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize*maxScreenCol;
    public final int screenHeight = tileSize*maxScreenRow;
    public final int maxWorldCol = 150;
    public final int maxWorldRow = 30;
    public final int worldWidth = tileSize*maxWorldCol;
    public final int worldHeight = tileSize*maxWorldRow;
    private final int FPS = 60;

    int screenWidth2 = screenWidth;
    int screenHeight2 = screenHeight;
    BufferedImage tempScreen;
    Graphics2D g2;

    private Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();
    public TileManager tileManager = new TileManager(this);
    public DiapoManager diapoManager = new DiapoManager(this);
    public Site map = new PresentationMap(tileManager, this, diapoManager);
    public Player player = new Player(this, keyHandler);
    public CollisionChecker collisionChecker = new CollisionChecker(this);

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);

        tempScreen = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
        g2 = (Graphics2D)tempScreen.getGraphics();
        setFullScreen();
    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void setFullScreen() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        gd.setFullScreenWindow(Main.window);
        screenWidth2 = Main.window.getWidth();
        screenHeight2 = Main.window.getHeight();
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
                drawToTempScreen();
                drawToScreen();
                // repaint();
                update();
                delta--;
            }
        }
    }

    public void update() {
        player.update();
    }
    public void drawToTempScreen() {
        map.draw(g2);
        player.draw(g2);
    }

    public void drawToScreen() {
        Graphics g = getGraphics();
        g.drawImage(tempScreen, 0, 0, screenWidth2, screenHeight2, null);
        g.dispose();
    }

    // public void paintComponent(Graphics graphics) {
    //     super.paintComponent(graphics);
    //     Graphics2D graphics2D = (Graphics2D)graphics;

    //     map.draw(graphics2D);
    //     player.draw(graphics2D);

    //     graphics2D.dispose();
    // }

}