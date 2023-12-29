package main;

import entity.Entity;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {

        int entityLeft = entity.x + entity.solidArea.x;
        int entityRight = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTop = entity.y + entity.solidArea.y;
        int entityBottom= entity.y + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = (int)entityLeft/gp.tileSize;
        int entityRightCol = (int)entityRight/gp.tileSize;
        int entityTopRow = (int)entityTop/gp.tileSize;
        int entityBottomRow = (int)entityBottom/gp.tileSize;

        int tileNum1;
        int tileNum2;

        if (entity.keyH.upPressed || entity.keyH.upPressed2) {
            entityTopRow = (int)(entityTop - entity.speed)/gp.tileSize;
            tileNum1 = gp.map.getMapTiles()[entityLeftCol][entityTopRow];
            tileNum2 = gp.map.getMapTiles()[entityRightCol][entityTopRow];
            if (gp.tileM.getTiles()[tileNum1].isCollision() || gp.tileM.getTiles()[tileNum2].isCollision()) {
                entity.collisionOn = true;
            }
        }
        if (entity.keyH.downPressed || entity.keyH.downPressed2) {
            entityBottomRow = (int)(entityBottom + entity.speed)/gp.tileSize;
            tileNum1 = gp.map.getMapTiles()[entityLeftCol][entityBottomRow];
            tileNum2 = gp.map.getMapTiles()[entityRightCol][entityBottomRow];
            if (gp.tileM.getTiles()[tileNum1].isCollision() || gp.tileM.getTiles()[tileNum2].isCollision()) {
                entity.collisionOn = true;
            }
        }
        if (entity.keyH.rightPressed || entity.keyH.rightPressed2) {
            entityRightCol = (int)(entityRight + entity.speed)/gp.tileSize;
            tileNum1 = gp.map.getMapTiles()[entityRightCol][entityTopRow];
            tileNum2 = gp.map.getMapTiles()[entityRightCol][entityBottomRow];
            if (gp.tileM.getTiles()[tileNum1].isCollision() || gp.tileM.getTiles()[tileNum2].isCollision()) {
                entity.collisionOn = true;
            }
        }
        if (entity.keyH.leftPressed || entity.keyH.leftPressed2) {
            entityLeftCol = (int)(entityLeft - entity.speed)/gp.tileSize;
            tileNum1 = gp.map.getMapTiles()[entityLeftCol][entityTopRow];
            tileNum2 = gp.map.getMapTiles()[entityLeftCol][entityBottomRow];
            if (gp.tileM.getTiles()[tileNum1].isCollision() || gp.tileM.getTiles()[tileNum2].isCollision()) {
                entity.collisionOn = true;
            }
        }
    }
}
