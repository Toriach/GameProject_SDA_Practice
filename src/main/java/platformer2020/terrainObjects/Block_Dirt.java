package platformer2020.terrainObjects;

import platformer2020.main.GameCore;
import platformer2020.main.MainMenu;
import platformer2020.main.MyFrame;

import java.awt.*;

public class Block_Dirt extends TerrainBlock {
    private int blockID = 0;

    public Block_Dirt(int x, int y, int width, int height,int blockID) {
        super(x, y, width, height, blockID);
        this.x = x;
        this.y = y;
        this.blockID = blockID;
        this.width = width;
        this.height = height;
        rectangle = new Rectangle(x, y, width, height);

        if(blockID == 1) {
            terrainImage = MyFrame.resourcesLoader.tileSet[0];
        }
        else if(blockID == 2){
            terrainImage = MyFrame.resourcesLoader.tileSet[4];
        }
    }

    public void draw(Graphics2D g) {
        g.drawImage(terrainImage, null, x, y);
        if (GameCore.debugMode) {
            g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
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

    public void setBlockID(int blockID) {
        this.blockID = blockID;
    }
}
