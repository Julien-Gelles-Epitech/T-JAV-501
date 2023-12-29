package main;

import entity.Entity;

public class CollisionChecker {

    GamePanel gamePanel;

    public CollisionChecker(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void checkTile(Entity entity) {

        int entityLeft = entity.worldX + entity.solidArea.x;
        int entityRight = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTop = entity.worldY + entity.solidArea.y;
        int entityBottom= entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = (int)entityLeft/gamePanel.tileSize;
        int entityRightCol = (int)entityRight/gamePanel.tileSize;
        int entityTopRow = (int)entityTop/gamePanel.tileSize;
        int entityBottomRow = (int)entityBottom/gamePanel.tileSize;

        int tileNum1;
        int tileNum2;

        if (gamePanel.keyHandler.upPressed) {
            entityTopRow = (int)(entityTop - entity.speed)/gamePanel.tileSize;
            tileNum1 = gamePanel.map.getMapTiles()[entityLeftCol][entityTopRow];
            tileNum2 = gamePanel.map.getMapTiles()[entityRightCol][entityTopRow];
            if (gamePanel.tileManager.getTiles()[tileNum1].isCollision() || gamePanel.tileManager.getTiles()[tileNum2].isCollision()) {
                entity.collisionOn = true;
            }
        }
        if (gamePanel.keyHandler.downPressed) {
            entityBottomRow = (int)(entityBottom + entity.speed)/gamePanel.tileSize;
            tileNum1 = gamePanel.map.getMapTiles()[entityLeftCol][entityBottomRow];
            tileNum2 = gamePanel.map.getMapTiles()[entityRightCol][entityBottomRow];
            if (gamePanel.tileManager.getTiles()[tileNum1].isCollision() || gamePanel.tileManager.getTiles()[tileNum2].isCollision()) {
                entity.collisionOn = true;
            }
        }
        if (gamePanel.keyHandler.rightPressed) {
            entityRightCol = (int)(entityRight + entity.speed)/gamePanel.tileSize;
            tileNum1 = gamePanel.map.getMapTiles()[entityRightCol][entityTopRow];
            tileNum2 = gamePanel.map.getMapTiles()[entityRightCol][entityBottomRow];
            if (gamePanel.tileManager.getTiles()[tileNum1].isCollision() || gamePanel.tileManager.getTiles()[tileNum2].isCollision()) {
                entity.collisionOn = true;
            }
        }
        if (gamePanel.keyHandler.leftPressed) {
            entityLeftCol = (int)(entityLeft - entity.speed)/gamePanel.tileSize;
            tileNum1 = gamePanel.map.getMapTiles()[entityLeftCol][entityTopRow];
            tileNum2 = gamePanel.map.getMapTiles()[entityLeftCol][entityBottomRow];
            if (gamePanel.tileManager.getTiles()[tileNum1].isCollision() || gamePanel.tileManager.getTiles()[tileNum2].isCollision()) {
                entity.collisionOn = true;
            }
        }
    }
}
