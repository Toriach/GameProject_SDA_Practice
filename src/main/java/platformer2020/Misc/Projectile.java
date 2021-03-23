package platformer2020.Misc;

import platformer2020.Graphic_Misc.ResourcesLoader;
import platformer2020.main.MyFrame;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Projectile {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Rectangle hitBox;
    protected boolean playerFaceRight;
    protected BufferedImage image;
    protected ResourcesLoader rc;
    protected int projectileSpeed;

    public Projectile(int x, int y, int width, int height,boolean playerFaceRight) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.playerFaceRight = playerFaceRight;
        hitBox = new Rectangle(x, y, width, height);
        rc = MyFrame.resourcesLoader;
    }

    public void update() {
        if(playerFaceRight){
            x += projectileSpeed;
        }else {
            x -= projectileSpeed;
        }
        hitBox = new Rectangle(x, y, width, height);
    }

    public void draw(Graphics2D g) {
        if(playerFaceRight) {
            g.drawImage(image, x + 35, y + 10, width, height, null);
        }
        if(!playerFaceRight) {
            g.drawImage(image, x + (width / 2) - 25, y+ 10, -width, height, null);
        }
      //  g.drawRect(x,y,width, height);
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
}
