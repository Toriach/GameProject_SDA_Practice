package platformer2020.Graphic_Misc.Decors;

import platformer2020.Graphic_Misc.Animation;
import platformer2020.Graphic_Misc.ResourcesLoader;
import platformer2020.main.MyFrame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DecorElement {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int itemID;
    protected Rectangle hitBox;
    protected BufferedImage image;
    protected ResourcesLoader rc;
    private Animation animation;

    public DecorElement(int x, int y, int width, int height, int itemID) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.itemID = itemID;
        rc = MyFrame.resourcesLoader;
            switch (itemID){
                case 1:
                    animation = new DecorAnimation(200, 0, rc.Window);
                    break;
                case 2:
                    animation = new DecorAnimation(300, rc.torchCount, rc.torch);
                    break;
            }
    }

    public void draw(Graphics2D g){
        g.drawImage(animation.getImage(),x,y,width,height,null);
      //  g.drawRect(x,y,width,height);
    }
}
