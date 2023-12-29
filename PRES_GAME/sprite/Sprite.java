package sprite;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Sprite {

    private static final int TILE_SIZE = 64;
    private static Map<String, BufferedImage> spriteSheets = new HashMap<>();

    public static BufferedImage loadSprite(String file) {
        BufferedImage sprite = null;
        try {
            sprite = ImageIO.read(new File(file));
            spriteSheets.put(file, sprite);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sprite;
    }

    public static BufferedImage getSprite(int xGrid, int yGrid, String file) {
        BufferedImage spriteSheet = spriteSheets.get(file);
        if (spriteSheet == null) {
            spriteSheet = loadSprite(file);
        }
        return spriteSheet.getSubimage(xGrid * TILE_SIZE, yGrid * TILE_SIZE+5, TILE_SIZE, TILE_SIZE-5);
    }
}
