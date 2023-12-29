package diapos;

import java.io.File;
import javax.imageio.ImageIO;
import main.GamePanel;

public class DiapoManager {

    private Diapo[] diapos;
    GamePanel gp;

    public DiapoManager(GamePanel gp) {
        this.gp = gp;
        this.diapos = new Diapo[10];
        getDiapoImage();
    }
    
    public Diapo[] getDiapos() {
        return this.diapos;
    }

    private void getDiapoImage() {
        try {
            diapos[0] = new Diapo();
            diapos[0].setImage(ImageIO.read(new File("res/diapos/diapo1.png")));
            diapos[1] = new Diapo();
            diapos[1].setImage(ImageIO.read(new File("res/diapos/diapo2.png")));
            diapos[2] = new Diapo();
            diapos[2].setImage(ImageIO.read(new File("res/diapos/diapo3.png")));
            diapos[3] = new Diapo();
            diapos[3].setImage(ImageIO.read(new File("res/diapos/diapo4.png")));
            diapos[4] = new Diapo();
            diapos[4].setImage(ImageIO.read(new File("res/diapos/diapo5.png")));
            diapos[5] = new Diapo();
            diapos[5].setImage(ImageIO.read(new File("res/diapos/diapo6.png")));
            diapos[6] = new Diapo();
            diapos[6].setImage(ImageIO.read(new File("res/diapos/diapo7.png")));
            diapos[7] = new Diapo();
            diapos[7].setImage(ImageIO.read(new File("res/diapos/diapo8.png")));
            
        } catch (Exception e) {}
    }
}