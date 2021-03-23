package platformer2020.Entities.Enemys;

import platformer2020.Graphic_Misc.Animation;
import platformer2020.Graphic_Misc.ResourcesLoader;

import java.awt.*;

public abstract class Enemy {
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
    protected Animation animation;
    protected ResourcesLoader rl;
    protected Rectangle hitBox;

    public void draw(Graphics2D g){}

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getxWithOffset() {
        return xWithOffset;
    }

    public void setxWithOffset(int xWithOffset) {
        this.xWithOffset = xWithOffset;
    }

    public int getyWithOffset() {
        return yWithOffset;
    }

    public void setyWithOffset(int yWithOffset) {
        this.yWithOffset = yWithOffset;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
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

    public int getCollisionWidth() {
        return collisionWidth;
    }

    public void setCollisionWidth(int collisionWidth) {
        this.collisionWidth = collisionWidth;
    }

    public int getCollisionHeight() {
        return collisionHeight;
    }

    public void setCollisionHeight(int collisionHeight) {
        this.collisionHeight = collisionHeight;
    }

    public int getCurrRow() {
        return currRow;
    }

    public void setCurrRow(int currRow) {
        this.currRow = currRow;
    }

    public int getCurrCol() {
        return currCol;
    }

    public void setCurrCol(int currCol) {
        this.currCol = currCol;
    }

    public double getxDestination() {
        return xDestination;
    }

    public void setxDestination(double xDestination) {
        this.xDestination = xDestination;
    }

    public double getyDestination() {
        return yDestination;
    }

    public void setyDestination(double yDestination) {
        this.yDestination = yDestination;
    }

    public double getxTemp() {
        return xTemp;
    }

    public void setxTemp(double xTemp) {
        this.xTemp = xTemp;
    }

    public double getyTemp() {
        return yTemp;
    }

    public void setyTemp(double yTemp) {
        this.yTemp = yTemp;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public boolean isFalling() {
        return falling;
    }

    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    public double getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(double moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getStopSpeed() {
        return stopSpeed;
    }

    public void setStopSpeed(double stopSpeed) {
        this.stopSpeed = stopSpeed;
    }

    public double getFallSpeed() {
        return fallSpeed;
    }

    public void setFallSpeed(double fallSpeed) {
        this.fallSpeed = fallSpeed;
    }

    public double getMaxFallSpeed() {
        return maxFallSpeed;
    }

    public void setMaxFallSpeed(double maxFallSpeed) {
        this.maxFallSpeed = maxFallSpeed;
    }

    public double getJumpStart() {
        return jumpStart;
    }

    public void setJumpStart(double jumpStart) {
        this.jumpStart = jumpStart;
    }

    public double getStopJumpSpeed() {
        return stopJumpSpeed;
    }

    public void setStopJumpSpeed(double stopJumpSpeed) {
        this.stopJumpSpeed = stopJumpSpeed;
    }

    public int getTileSize() {
        return tileSize;
    }

    public void setTileSize(int tileSize) {
        this.tileSize = tileSize;
    }

    public boolean isBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(boolean bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public boolean isBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(boolean bottomRight) {
        this.bottomRight = bottomRight;
    }

    public boolean isTopLeft() {
        return topLeft;
    }

    public void setTopLeft(boolean topLeft) {
        this.topLeft = topLeft;
    }

    public boolean isTopRight() {
        return topRight;
    }

    public void setTopRight(boolean topRight) {
        this.topRight = topRight;
    }

    public boolean isRightTop() {
        return rightTop;
    }

    public void setRightTop(boolean rightTop) {
        this.rightTop = rightTop;
    }

    public boolean isRightBottom() {
        return rightBottom;
    }

    public void setRightBottom(boolean rightBottom) {
        this.rightBottom = rightBottom;
    }

    public boolean isLeftTop() {
        return leftTop;
    }

    public void setLeftTop(boolean leftTop) {
        this.leftTop = leftTop;
    }

    public boolean isLeftBottom() {
        return leftBottom;
    }

    public void setLeftBottom(boolean leftBottom) {
        this.leftBottom = leftBottom;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public ResourcesLoader getRl() {
        return rl;
    }

    public void setRl(ResourcesLoader rl) {
        this.rl = rl;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

    public void setHitBox(Rectangle hitBox) {
        this.hitBox = hitBox;
    }
}
