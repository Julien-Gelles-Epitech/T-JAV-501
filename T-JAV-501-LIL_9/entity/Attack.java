package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Attack extends Entity{
    private Player player;
    private PlayerTwo playerTwo;

    GamePanel gamePanel;

    public Attack(Player player, PlayerTwo playerTwo, KeyHandler keyHandler, GamePanel gamePanel) {
        this.player = player;
        this.playerTwo = playerTwo;
        this.keyH = keyHandler;
        this.gamePanel = gamePanel;
    }

    public void update(){
        if(keyH.isAttacking) {
            attacking(player, playerTwo);
            keyH.isAttacking = false;
        }
        if(keyH.isAttacking2) {
            attacking2(playerTwo, player);
            keyH.isAttacking2 = false;

        }
    }

    private void attacking(Player player, PlayerTwo playerTwo) {


        Rectangle target = new Rectangle(playerTwo.x, playerTwo.y, gamePanel.tileSize, gamePanel.tileSize);
        Rectangle attacker = null;
        switch (player.direction){
            case "up":
                attacker = new Rectangle(player.x, player.y - gamePanel.tileSize/2, gamePanel.tileSize, gamePanel.tileSize);
                break;
            case "down":
                attacker = new Rectangle(player.x, player.y + gamePanel.tileSize/2, gamePanel.tileSize, gamePanel.tileSize);
                break;
            case "left":
                attacker = new Rectangle(player.x - gamePanel.tileSize/2, player.y, gamePanel.tileSize, gamePanel.tileSize);
                break;
            case "right":
                attacker = new Rectangle(player.x + gamePanel.tileSize/2, player.y, gamePanel.tileSize, gamePanel.tileSize);
                break;
        }

        if (attacker != null && target != null) {
        Rectangle intersection = attacker.intersection(target);

        if (intersection.width > 0 && intersection.height > 0){
            if (playerTwo.block < player.power) {
                playerTwo.getDamage(player.power - playerTwo.block);
            }
        }
        }
    }
    private void attacking2(PlayerTwo playerTwo, Player player) {
        Rectangle target2 = new Rectangle(player.x, player.y, gamePanel.tileSize, gamePanel.tileSize);
        Rectangle attacker2 = null;
        switch (playerTwo.direction) {
            case "up":
                attacker2 = new Rectangle(playerTwo.x, playerTwo.y - gamePanel.tileSize/2, gamePanel.tileSize, gamePanel.tileSize);
                break;
            case "down":
                attacker2 = new Rectangle(playerTwo.x, playerTwo.y + gamePanel.tileSize/2, gamePanel.tileSize, gamePanel.tileSize);
                break;
            case "left":
                attacker2 = new Rectangle(playerTwo.x -gamePanel.tileSize/2 , playerTwo.y , gamePanel.tileSize, gamePanel.tileSize);
                break;
            case "right":
                attacker2 = new Rectangle(playerTwo.x + gamePanel.tileSize/2 , playerTwo.y , gamePanel.tileSize, gamePanel.tileSize);
                break;
        }

        if (attacker2 != null && target2 != null) {
            Rectangle intersection = attacker2.intersection(target2);
            if (intersection.width > 0 && intersection.height > 0){
                if (player.block < playerTwo.power) {
                player.getDamage(playerTwo.power - player.block);
                }
        }
        }
    }
}
