package platformer2020.Graphic_Misc.Decors;

import platformer2020.Graphic_Misc.Animation;
import platformer2020.Graphic_Misc.ResourcesLoader;
import platformer2020.main.MyFrame;

import java.awt.image.BufferedImage;

public class DecorAnimation extends Animation {
    private ResourcesLoader rc;
    private int animCount;
    private BufferedImage[] imageArray;

    public DecorAnimation(int timerDelay, int animCount, BufferedImage[] imageArray) {
        super(timerDelay);
        this.animCount = animCount;
        this.imageArray = imageArray;
        rc = MyFrame.resourcesLoader;
    }

    @Override
    protected void prepareImage() {
        super.prepareImage();

        setAnimationParameters(150, animCount, false,0,false);
        if (animationFrame > animCount - 1) {
            animationFrame = 0;
        }
            currentImage = imageArray[animationFrame];
    }
}
