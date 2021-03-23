package platformer2020.Entities;

import platformer2020.main.GameCore;
import platformer2020.terrainObjects.TerrainBlock;

public abstract class Entity {

    protected double x;
    protected double y;
    protected int xWithOffset;
    protected int yWithOffset;
   // protected int xWithOffsetLeft;
 //   protected int yWithOffsetLeft;
    protected double dx;
    protected double dy;

    protected int width;
    protected int height;

    protected int collisionWidth;
    protected int collisionHeight;

    protected int currRow;
    protected int currCol;
    protected double xDestination;
    protected double yDestination;
    protected double xTemp;
    protected double yTemp;

    protected boolean left;
    protected boolean right;

    protected boolean jumping;
    protected boolean falling;

    protected double moveSpeed;
    protected double maxSpeed;
    protected double stopSpeed;
    protected double fallSpeed;
    protected double maxFallSpeed;
    protected double jumpStart;
    protected double stopJumpSpeed;

    protected int tileSize;

    protected boolean bottomLeft,bottomRight;
    protected boolean topLeft,topRight;
    protected boolean rightTop,rightBottom;
    protected boolean leftTop,leftBottom;

    public void checkForCollision(){
        currCol = (int)x / tileSize;
        currRow = (int)(y + 50) / tileSize;

        xDestination = x + dx;
        yDestination = y + dy;

        xTemp = x;
        yTemp = y;

        checkSides(x, yDestination);
        if(dy < 0) {
            if(topLeft || topRight) {
                dy = 0;
                yTemp = (currRow - 2) * tileSize + collisionHeight;
            }
            else {
                yTemp += dy;
            }
        }
        if(dy > 0) {
            if(bottomLeft || bottomRight) {
                dy = 0;
                falling = false;
                yTemp = (currRow + 1) * tileSize - collisionHeight;
            }
            else {
                yTemp += dy;
            }
        }

        checkSides(xDestination, y);
        if(dx < 0) {
            if(!leftTop && !leftBottom) {
                xTemp += dx;
            }

        }
        if(dx > 0) {
            if(!rightTop && !rightBottom) {
                xTemp += dx;
            }
        }

        if(!falling) {
            checkSides(x, yDestination + 1);
            if(!bottomLeft && !bottomRight) {
                falling = true;
            }
        }
    }
    TerrainBlock tb ;
    private void checkSides(double x, double y) {

        bottomLeft = GameCore.collisionBlocks.stream().anyMatch(element ->
               (element.getX()) / tileSize == (int)((x + 10) / tileSize)
                        && element.getY() / tileSize == (int)(y / tileSize) + 1);

        bottomRight = GameCore.collisionBlocks.stream().anyMatch(element ->
                (element.getX()) / tileSize == (int)((x + collisionWidth - 10) / tileSize)
                        && element.getY() / tileSize == (int)(y / tileSize) + 1);

        topLeft = GameCore.collisionBlocks.stream().anyMatch(element ->
                (element.getX()) / tileSize == (int)((x + 10) / tileSize)
                        && element.getY() / tileSize == (int)(y - 2) / tileSize);

        topRight = GameCore.collisionBlocks.stream().anyMatch(element ->
                (element.getX()) / tileSize == (int)((x + collisionWidth - 10) / tileSize)
                        && element.getY() / tileSize == (int)(y - 2) / tileSize);

        leftTop = GameCore.collisionBlocks.stream().anyMatch(element ->
                (element.getX()) / tileSize == (int)((x - 1) / tileSize)
                        && element.getY() / tileSize == (int)(y + 1) / tileSize);

        leftBottom = GameCore.collisionBlocks.stream().anyMatch(element ->
                (element.getX()) / tileSize == (int)((x - 1) / tileSize)
                        && element.getY() / tileSize == (int)((y + (collisionHeight - 1))  / tileSize));

        rightTop = GameCore.collisionBlocks.stream().anyMatch(element ->
                (element.getX()) / tileSize == (int)((x + (collisionWidth - 1)) / tileSize)
                        && element.getY() / tileSize == (int)(y + 1) / tileSize);

        rightBottom = GameCore.collisionBlocks.stream().anyMatch(element ->
                (element.getX()) / tileSize == (int)((x + (collisionWidth - 1)) / tileSize)
                        && element.getY() / tileSize == (int)((y + (collisionHeight - 1))  / tileSize));

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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getxWithOffset() {
        return xWithOffset;
    }

    public int getyWithOffset() {
        return yWithOffset;
    }

    public int getCollisionWidth() {
        return collisionWidth;
    }

    public int getCollisionHeight() {
        return collisionHeight;
    }

    public boolean isFalling() {
        return falling;
    }

    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public boolean isJumping() {
        return jumping;
    }
}
