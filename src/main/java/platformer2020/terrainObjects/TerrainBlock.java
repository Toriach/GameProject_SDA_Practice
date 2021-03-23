package platformer2020.terrainObjects;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class TerrainBlock {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Rectangle rectangle;
    protected BufferedImage terrainImage;
    protected int blockID;

    public TerrainBlock(int x, int y, int width, int height,int blockID) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public void draw(Graphics2D g){
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

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public int getBlockID() {
        return blockID;
    }
}
