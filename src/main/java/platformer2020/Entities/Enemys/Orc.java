package platformer2020.Entities.Enemys;

import platformer2020.Graphic_Misc.Animation;
import platformer2020.main.MyFrame;

import java.awt.*;

public class Orc extends Enemy {
    private Animation animation;

    private boolean dying;

    public Orc(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rl = MyFrame.resourcesLoader;
        animation = new EnemyAnimation(200, rl.orcAnimCount_idle, rl.orc_idle);
        hitBox = new Rectangle(x, y, width, height);
    }

    public void draw(Graphics2D g) {
        g.drawImage(animation.getImage(), (int) x, (int) y, width, height, null);
        // g.drawRect((int) x, (int) y,width,height);
    }
}
