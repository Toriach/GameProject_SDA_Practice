package platformer2020.Entities.interactable;

import platformer2020.Graphic_Misc.Animation;
import platformer2020.Graphic_Misc.ResourcesLoader;
import platformer2020.main.MyFrame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Door {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int itemID;
    protected Rectangle hitBox;
    protected BufferedImage image;
    protected ResourcesLoader rc;
    private Animation animation;

    public Door(int x, int y, int width, int height, int itemID) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.itemID = itemID;
        rc = MyFrame.resourcesLoader;
        hitBox = new Rectangle(x + 5,y+ 5,width-5,height-5);

        if(itemID == 1){
            image = rc.DoorClose;
        }else if(itemID == 2){
            image = rc.DoorOpen;
        }
    }

    public void update(){ }

    public void draw(Graphics2D g){
        g.drawImage(image,x,y,width,height,null);
      //  g.drawRect(x + 15,y+ 5,width-30,height-5);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getItemID() {
        return itemID;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }
}
