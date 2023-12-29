package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, isAttackPressed, isAttacking, isDancing;
    public boolean upPressed2, downPressed2, leftPressed2, rightPressed2, isAttackPressed2, isAttacking2, isDancing2;

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_Z:
                upPressed = true;
                break;
            case KeyEvent.VK_S:
                downPressed = true;
                break;
            case KeyEvent.VK_Q:
                leftPressed = true;
                break;
            case KeyEvent.VK_D:
                rightPressed = true;
                break;
            case KeyEvent.VK_SPACE:
                isAttackPressed = true;
                isAttacking = true;
                break;
            case KeyEvent.VK_F:
                isDancing = true;
                break;
            case KeyEvent.VK_M:
                isDancing2 = true;
                break;
            case KeyEvent.VK_UP:
                upPressed2 = true;
                break;
            case KeyEvent.VK_DOWN:
                downPressed2 = true;
                break;
            case KeyEvent.VK_LEFT:
                leftPressed2 = true;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed2 = true;
                break;
            case KeyEvent.VK_SHIFT:
                isAttackPressed2 = true;
                isAttacking2= true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_Z:
                upPressed = false;
                break;
            case KeyEvent.VK_S:
                downPressed = false;
                break;
            case KeyEvent.VK_Q:
                leftPressed = false;
                break;
            case KeyEvent.VK_D:
                rightPressed = false;
                break;
            case KeyEvent.VK_UP:
                upPressed2 = false;
                break;
            case KeyEvent.VK_DOWN:
                downPressed2 = false;
                break;
            case KeyEvent.VK_LEFT:
                leftPressed2 = false;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed2 = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
