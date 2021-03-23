package platformer2020.terrainObjects;

import platformer2020.main.GameCore;
import platformer2020.main.MainMenu;
import platformer2020.main.MyFrame;

import java.awt.*;

public class BorderBlock extends TerrainBlock {
    private String borderOrientation = "";
    private int blockID = 0;

    public BorderBlock(int x, int y, int width, int height, String borderOrientation,int blockID) {
        super(x, y, width, height,blockID);
        this.x = x;
        this.y = y;
        this.blockID = blockID;
        this.width = width;
        this.height = height;
        this.borderOrientation = borderOrientation;

        rectangle = new Rectangle(x, y, width, height);

        if (borderOrientation.equals("top")) {
            terrainImage = MyFrame.resourcesLoader.tileSet[3];
        } else if (borderOrientation.equals("bottom")) {
            terrainImage = MyFrame.resourcesLoader.tileSet[0];
        } else if (borderOrientation.equals("left")) {
            terrainImage = MyFrame.resourcesLoader.tileSet[2];
        } else if (borderOrientation.equals("right")) {
            terrainImage = MyFrame.resourcesLoader.tileSet[1];
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
