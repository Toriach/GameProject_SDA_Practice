package platformer2020.Misc;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Button {
    private int x;
    private int y;
    private int width;
    private int height;
    private Rectangle hitBox;
    private boolean Active = false;
    private BufferedImage idleImage;
    private BufferedImage activeImage;

    public Button(int x, int y, int width, int height, BufferedImage idleImage, BufferedImage activeImage) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.idleImage = idleImage;
        this.activeImage = activeImage;
        hitBox = new Rectangle(x,y,width,height);
    }

    public void draw(Graphics2D g){
        if(Active){
            g.drawImage(activeImage,x,y,width,height,null);
        }else{
            g.drawImage(idleImage,x,y,width,height,null);
        }
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
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

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }
}
