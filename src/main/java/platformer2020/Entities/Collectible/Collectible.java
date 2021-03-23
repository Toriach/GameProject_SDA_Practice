package platformer2020.Entities.Collectible;

import platformer2020.Graphic_Misc.Animation;
import platformer2020.Graphic_Misc.ResourcesLoader;
import platformer2020.main.MyFrame;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Collectible {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int itemID;
    protected Rectangle hitBox;
    protected BufferedImage image;
    protected ResourcesLoader rc;
    private Animation animation;

    public Collectible(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        hitBox = new Rectangle(x, y, width, height);
        rc = MyFrame.resourcesLoader;
        animation = new CollectibleAnimation(200);
    }

    public void update() {}

    public void draw(Graphics2D g) {
        g.drawImage(animation.getImage(), x+ width /2 , y + height/2 + 5 , width, height, null);
        //  g.drawRect(x+ width /2,y + height/2 + 12,width, height);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

    public void setHitBox(Rectangle hitBox) {
        this.hitBox = hitBox;
    }

    public int getItemID() {
        return itemID;
    }
}
