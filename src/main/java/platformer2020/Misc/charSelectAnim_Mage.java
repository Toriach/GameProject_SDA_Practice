package platformer2020.Misc;

import platformer2020.Graphic_Misc.Animation;
import platformer2020.Graphic_Misc.ResourcesLoader;
import platformer2020.main.MyFrame;

public class charSelectAnim_Mage extends Animation {
    private ResourcesLoader rc;
    public charSelectAnim_Mage(int timerDelay) {
        super(timerDelay);
        rc = MyFrame.resourcesLoader;
    }

    @Override
    protected void prepareImage() {
        super.prepareImage();

        setAnimationParameters(150, rc.player_mage_idle, false, 0,false);
        if (animationFrame > rc.player_mage_idle - 1) {
            animationFrame = 0;
        }
        currentImage = rc.playerMageSet_idle[animationFrame];
    }
}
