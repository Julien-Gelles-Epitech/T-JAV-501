package tile;

import java.io.File;
import javax.imageio.ImageIO;
import main.GamePanel;

public class TileManager {

    private Tile[] tiles;
    GamePanel gp;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        this.tiles = new Tile[11];
        getTileImage();
    }
    
    public Tile[] getTiles() {
        return this.tiles;
    }

    private void getTileImage() {
        try {
            tiles[0] = new Tile();
            tiles[0].setImage(ImageIO.read(new File("res/tiles/grass.png")));
            tiles[1] = new Tile();
            tiles[1].setImage(ImageIO.read(new File("res/tiles/spawn.png")));
            tiles[1].setCollision(true);
            tiles[2] = new Tile();
            tiles[2].setImage(ImageIO.read(new File("res/tiles/bush.png")));
            tiles[2].setCollision(true);
            tiles[3] = new Tile();
            tiles[3].setImage(ImageIO.read(new File("res/tiles/cactus.png")));
            tiles[3].setCollision(true);
            tiles[4] = new Tile();
            tiles[4].setImage(ImageIO.read(new File("res/tiles/cactus2.png")));
            tiles[4].setCollision(true);
            tiles[5] = new Tile();
            tiles[5].setImage(ImageIO.read(new File("res/tiles/mud7.png")));
            tiles[6] = new Tile();
            tiles[6].setImage(ImageIO.read(new File("res/tiles/rock.png")));
            tiles[6].setCollision(true);
            tiles[7] = new Tile();
            tiles[7].setImage(ImageIO.read(new File("res/tiles/rock2.png")));
            tiles[7].setCollision(true);
            tiles[8] = new Tile();
            tiles[8].setImage(ImageIO.read(new File("res/tiles/stump.png")));
            tiles[8].setCollision(true);
            tiles[9] = new Tile();
            tiles[9].setImage(ImageIO.read(new File("res/tiles/sand.png")));
            tiles[10] = new Tile();
            tiles[10].setImage(ImageIO.read(new File("res/tiles/water6.png")));
        } catch (Exception e) {
            System.out.println("Tile Manager: "+e);
        }
    }
}