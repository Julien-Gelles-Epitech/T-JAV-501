package tile;

import java.awt.image.BufferedImage;

public class Tile {

    private BufferedImage image;
    private boolean collision = false;
    private int speedChange = 0;

    public BufferedImage getImage() {
        return this.image;
    }

    public void setImage(BufferedImage image_) {
        this.image = image_;
    }

    public boolean isCollision() {
        return this.collision;
    }

    public void setCollision(boolean collision_) {
        this.collision = collision_;
    }

    public void setSpeedChange (int speed) {
        this.speedChange = speed;
    }

    public int getSpeedChange () {
        return this.speedChange;
    }

}