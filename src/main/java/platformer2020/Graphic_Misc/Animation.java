package platformer2020.Graphic_Misc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Animation implements ActionListener {

    protected Timer timer;
    protected int timerDelay;
    protected BufferedImage currentImage;
    protected boolean delayed = false;
    protected boolean delayedStart = false;
    protected Boolean alreadyDelayedStart = false;

    protected Boolean idle_player = false;
    protected Boolean walk_player = true;
    protected Boolean player_attacking = false;

    protected int animationDelay;
    protected int numberOfFrames;
    protected int animationFrame = 0;
    protected int delayedStartCounter = 0;

    private int delayCounter = 0;

    public Animation(int timerDelay) {
        this.timerDelay = timerDelay;
        timer = new Timer(timerDelay, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        prepareImage();
        if(alreadyDelayedStart){
            delayedStart = false;
        }

        if(!delayedStart) {
            delayedStartCounter = 0;
            animationFrame++;
            if (delayed) {
                delayCounter++;
            }

            if (animationFrame >= numberOfFrames) {
                animationFrame = numberOfFrames - 1;
                if (delayCounter > animationDelay || !delayed) {
                    animationFrame = 0;
                    if (delayed) {
                        delayCounter = 0;
                    }
                }
            }
        }else {
            animationFrame = 0;
            delayedStartCounter++;
            if(delayedStartCounter >= 15){
                delayedStart = false;
                alreadyDelayedStart = true;
                delayedStartCounter = 0;
            }

        }

    }
    protected void prepareImage(){}

    public BufferedImage getImage() {
        return currentImage;
    }

    public void setAnimationParameters(int timerDelay, int numberOfFrames) {
        this.timerDelay = timerDelay;
        timer.setDelay(timerDelay);

        this.numberOfFrames = numberOfFrames;
    }

    public void setAnimationParameters(int timerDelay, int numberOfFrames, boolean delayed, int animationDelay) {
        this.timerDelay = timerDelay;
        timer.setDelay(timerDelay);
        this.numberOfFrames = numberOfFrames;
        this.delayed = delayed;
        this.animationDelay = animationDelay;
    }

    public void setAnimationParameters(int timerDelay, int numberOfFrames, boolean delayed, int animationDelay,boolean delayedStart) {
        this.timerDelay = timerDelay;
        timer.setDelay(timerDelay);
        this.numberOfFrames = numberOfFrames;
        this.delayed = delayed;
        this.animationDelay = animationDelay;
        this.delayedStart = delayedStart;
    }

    public Boolean getIdle_player() {
        return idle_player;
    }

    public void setIdle_player(Boolean idle_player) {
        this.idle_player = idle_player;
    }

    public Boolean getWalk_player() {
        return walk_player;
    }

    public void setWalk_player(Boolean walk_player) {
        this.walk_player = walk_player;
    }

    public int getAnimationFrame() {
        return animationFrame;
    }

    public void setAnimationFrame(int animationFrame) {
        this.animationFrame = animationFrame;
    }

    public boolean isDelayedStart() {
        return delayedStart;
    }

    public void setDelayedStart(boolean delayedStart) {
        this.delayedStart = delayedStart;
    }

    public Boolean getPlayer_attacking() {
        return player_attacking;
    }

    public void setPlayer_attacking(Boolean player_attacking) {
        this.player_attacking = player_attacking;
    }
}
