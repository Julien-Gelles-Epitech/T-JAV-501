package object;

import java.awt.image.BufferedImage;

public class Object {
    private BufferedImage image;
    private String name;

    public BufferedImage getImage() {
        return this.image;
    }

    public void setImage(BufferedImage image_) {
        this.image = image_;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
