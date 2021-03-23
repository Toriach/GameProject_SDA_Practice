package platformer2020.Entities.Collectible;

import platformer2020.Graphic_Misc.Animation;
import platformer2020.Graphic_Misc.ResourcesLoader;
import platformer2020.main.MyFrame;

public class CollectibleAnimation extends Animation {

    private ResourcesLoader rc;
    public CollectibleAnimation(int timerDelay) {
        super(timerDelay);
        rc = MyFrame.resourcesLoader;
    }

    @Override
    protected void prepareImage() {
        super.prepareImage();

        setAnimationParameters(200, rc.goldCoinAnimationCount, false,0,false);
        if (animationFrame > rc.goldCoinAnimationCount) {
            animationFrame = 0;
        }
        currentImage = rc.goldCoinSet[animationFrame];
    }
}
