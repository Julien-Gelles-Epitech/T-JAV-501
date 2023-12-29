package tile;

import java.awt.Graphics2D;
import java.io.File;
import java.util.Scanner;

import diapos.DiapoManager;
import main.GamePanel;

public class PresentationMap extends Site{

    public PresentationMap(TileManager tileM, GamePanel gameP, DiapoManager diapoM) {
        super(tileM, gameP, diapoM);
    }

    @Override
    public void loadMap() {
        try (Scanner scanner = new Scanner(new File("./res/maps/presMap.txt"))) {
            for (int j = 0; j < gamePanel.maxWorldRow; j++) {
                String line = scanner.nextLine();
                String[] numbers = line.split(" ");
                for (int i = 0; i < gamePanel.maxWorldCol; i++) {
                    int num = Integer.parseInt(numbers[i]);
                    mapTileNum[i][j] = num;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void draw(Graphics2D g2) {
        super.draw(g2);
        setDiapoImage(12, 15, 14, 8, g2, 0);
        setDiapoImage(28, 15, 14, 8, g2, 1);
        setDiapoImage(44, 15, 14, 8, g2, 2);
        setDiapoImage(60, 15, 14, 8, g2, 3);
        setDiapoImage(76, 15, 14, 8, g2, 4);
        setDiapoImage(92, 15, 14, 8, g2, 5);
        setDiapoImage(108, 15, 14, 8, g2, 6);
        setDiapoImage(124, 15, 14, 8, g2, 7);
    }

    public void setDiapoImage(int x, int y, int w, int h, Graphics2D g2, int diapo) {
        int worldX = x*gamePanel.tileSize;
        int worldY = y*gamePanel.tileSize;
        int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
        int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;
        g2.drawImage(this.diapoManager.getDiapos()[diapo].getImage(), screenX, screenY, w*gamePanel.tileSize, h*gamePanel.tileSize, null);
    }
}