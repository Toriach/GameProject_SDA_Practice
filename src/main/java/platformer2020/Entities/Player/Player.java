package platformer2020.Entities.Player;

import platformer2020.Entities.Entity;
import platformer2020.Graphic_Misc.Animation;
import platformer2020.main.GameCore;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Entity implements ActionListener, KeyListener {
    private int charType;
    private Rectangle bodyHitBoxRectangle;
    private Rectangle attackRect;

    private int animationCount = 0;

    private boolean animationRight = true;
    private boolean animationIdle = true;
    private boolean animationLeft = false;

    private Animation playerAnimation;

    public Player(int x, int y, int tileSize, int charType) {
        this.x = x;
        this.y = y;
        this.tileSize = tileSize;
        this.charType = charType;

        width = 128;
        height = 128;

        moveSpeed = 0.75;
        maxSpeed = 8.0;
        stopSpeed = 1.0;

        fallSpeed = 1.0;
        maxFallSpeed = 10.0;

        jumpStart = -15.5;
        stopJumpSpeed = 1.0;

        collisionHeight = 45;
        collisionWidth = 50;

        if (charType == 1) {
            playerAnimation = new PlayerAnimation_Rogue(200, this);
        }
        if (charType == 2) {
            playerAnimation = new PlayerAnimation_Mage(200, this);
        }
        if (charType == 3) {
            playerAnimation = new PlayerAnimation_Knight(200, this);
        }

        bodyHitBoxRectangle = new Rectangle(x, y, collisionWidth, collisionHeight);

    }

    public void update() {
        nextPosition();
        checkForCollision();

        setPosition(xTemp, yTemp);

        xWithOffset = (int) x - 13;
        yWithOffset = (int) y - tileSize - 14;

        bodyHitBoxRectangle.setLocation((int) x, (int) y);
    // TODO me
        if(charType == 3 || charType == 1) {
            if (playerAnimation.getPlayer_attacking()) {
                if (animationRight) {
                    attackRect = new Rectangle((int) x + collisionWidth, (int) y, 40, 35);
                }
                if (animationLeft) {
                    attackRect = new Rectangle((int) x - collisionWidth + 10, (int) y, 40, 35);
                }
                // check if hit any object
                for (int i = 0; i < GameCore.collisionBlocks.size(); i++) {
                    if (GameCore.collisionBlocks.get(i).getRectangle().intersects(attackRect)) {
                        if (GameCore.collisionBlocks.get(i).getBlockID() == 2) {
                            GameCore.collisionBlocks.remove(i);
                        }
                    }
                }

                if(GameCore.enemies.get(0).getHitBox().intersects(bodyHitBoxRectangle)){
                    GameCore.enemies.remove(GameCore.enemies.get(0));
                }

            } else {
                attackRect = null;
            }
        }

    }

    private void nextPosition() {
        // movement
        if (left) {
            dx -= moveSpeed;
            if (dx < -maxSpeed) {
                dx = -maxSpeed;
            }
        } else if (right) {
            dx += moveSpeed;
            if (dx > maxSpeed) {
                dx = maxSpeed;
            }
        } else {
            if (dx > 0) {
                dx -= stopSpeed;
                if (dx < 0) {
                    dx = 0;
                }
            } else if (dx < 0) {
                dx += stopSpeed;
                if (dx > 0) {
                    dx = 0;
                }
            }
        }
        // jumping
        if (jumping && !falling) {
            dy = jumpStart;
            falling = true;
        }

        // falling
        if (falling) {
            dy += fallSpeed;

            if (dy > 0) jumping = false;
            if (dy < 0 && !jumping) dy += stopJumpSpeed;

            if (dy > maxFallSpeed) dy = maxFallSpeed;

        }

    }

    public void draw(Graphics2D g) {

        if (animationRight) {
            g.drawImage(playerAnimation.getImage(), xWithOffset, yWithOffset, null);
        }
        if (animationLeft) {
            g.drawImage(playerAnimation.getImage(), (int) x + width / 2, yWithOffset, -width, height, null);
        }

        if (GameCore.debugMode) {
            if (playerAnimation.getPlayer_attacking()) {
                if (animationRight) {
                    g.drawRect((int) x + collisionWidth, (int) y, 40, 35);
                }
                if (animationLeft) {
                    g.drawRect((int) x - collisionWidth + 10, (int) y, 40, 35);
                }
            }
            g.setColor(Color.GREEN);
            g.drawRect(bodyHitBoxRectangle.x, bodyHitBoxRectangle.y, bodyHitBoxRectangle.width, bodyHitBoxRectangle.height);
            g.setColor(Color.BLUE);
            // g.drawRect(feetRectangle.x,feetRectangle.y,feetRectangle.width,feetRectangle.height);
            g.setColor(Color.RED);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        animationCount++;
        if (animationCount >= 6) animationCount = 0;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            left = true;
            animationLeft = true;
            animationRight = false;
            playerAnimation.setIdle_player(false);
            playerAnimation.setWalk_player(true);
            playerAnimation.setDelayedStart(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            right = true;
            animationRight = true;
            animationLeft = false;
            playerAnimation.setIdle_player(false);
            playerAnimation.setWalk_player(true);
            playerAnimation.setDelayedStart(false);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (!topLeft && !topRight) {
                jumping = true;
                playerAnimation.setIdle_player(false);
                playerAnimation.setDelayedStart(false);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            playerAnimation.setIdle_player(false);
            playerAnimation.setDelayedStart(false);
            playerAnimation.setPlayer_attacking(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            left = false;
            playerAnimation.setWalk_player(false);
            playerAnimation.setIdle_player(true);
            playerAnimation.setDelayedStart(true);
            playerAnimation.setAnimationFrame(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            right = false;
            playerAnimation.setWalk_player(false);
            playerAnimation.setIdle_player(true);
            playerAnimation.setDelayedStart(true);
            playerAnimation.setAnimationFrame(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            jumping = false;
            playerAnimation.setIdle_player(true);
            playerAnimation.setDelayedStart(true);
            playerAnimation.setAnimationFrame(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            playerAnimation.setPlayer_attacking(false);
            playerAnimation.setIdle_player(true);
            playerAnimation.setDelayedStart(true);
            playerAnimation.setAnimationFrame(0);
            if(charType == 2) {
                GameCore.addPlayerBullet();
            }
        }
    }

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

    public Rectangle getBodyHitBoxRectangle() {
        return bodyHitBoxRectangle;
    }

    public void setBodyHitBoxRectangle(Rectangle bodyHitBoxRectangle) {
        this.bodyHitBoxRectangle = bodyHitBoxRectangle;
    }

    public boolean isAnimationRight() {
        return animationRight;
    }

    public void setAnimationRight(boolean animationRight) {
        this.animationRight = animationRight;
    }

    public boolean isAnimationLeft() {
        return animationLeft;
    }

    public void setAnimationLeft(boolean animationLeft) {
        this.animationLeft = animationLeft;
    }

    public boolean isAnimationIdle() {
        return animationIdle;
    }

    public void setAnimationIdle(boolean animationIdle) {
        this.animationIdle = animationIdle;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean getRightBottomCollision() {
        return rightBottom;
    }

    public boolean getLeftBottomCollision() {
        return leftBottom;
    }

}
