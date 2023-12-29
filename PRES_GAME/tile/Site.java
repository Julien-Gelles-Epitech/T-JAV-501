package tile;

import java.awt.Graphics2D;

import diapos.DiapoManager;
import main.GamePanel;

public abstract class Site {
    
    protected TileManager tileManager;
    protected GamePanel gamePanel;
    protected DiapoManager diapoManager;

    protected int mapTileNum[][];

    protected Site(TileManager tileM, GamePanel gameP, DiapoManager diapoM) {
        this.tileManager = tileM;
        this.diapoManager = diapoM;
        this.gamePanel = gameP;
        mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
        loadMap();
    }

    public int[][] getMapTiles() {
        return this.mapTileNum;
    }

    public abstract void loadMap();

    public void draw(Graphics2D g2) {
        for (int i = 0; i < gamePanel.maxWorldCol; i++) {
            for (int j = 0; j < gamePanel.maxWorldRow; j++) {

                int tileNum = this.mapTileNum[i][j];
                int worldX = i*gamePanel.tileSize;
                int worldY = j*gamePanel.tileSize;
                int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
                int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;
                if (worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX &&
                    worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
                    worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
                    worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY) {
                    g2.drawImage(this.tileManager.getTiles()[tileNum].getImage(), screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
                }
            }
        }
    }

}
