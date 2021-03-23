package platformer2020.Entities.Enemys;

import platformer2020.Graphic_Misc.Animation;
import platformer2020.Graphic_Misc.ResourcesLoader;
import platformer2020.main.MyFrame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyAnimation extends Animation {
    private ResourcesLoader rl;
    private int animCount;
    private BufferedImage[] imageArray;
    public EnemyAnimation(int timerDelay, int animCount, BufferedImage[] imageArray) {
        super(timerDelay);
        this.animCount = animCount;
        this.imageArray = imageArray;
        rl = MyFrame.resourcesLoader;

    }

    @Override
    protected void prepareImage() {
        super.prepareImage();

        setAnimationParameters(100, animCount, false,0,false);
        if (animationFrame > animCount - 1) {
            animationFrame = 0;
        }
        currentImage = imageArray[animationFrame];
    }


}
