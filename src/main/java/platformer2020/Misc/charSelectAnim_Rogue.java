package platformer2020.Misc;

import platformer2020.Graphic_Misc.Animation;
import platformer2020.Graphic_Misc.ResourcesLoader;
import platformer2020.main.MyFrame;

public class charSelectAnim_Rogue extends Animation {
    private ResourcesLoader rc;
    public charSelectAnim_Rogue(int timerDelay) {
        super(timerDelay);
        rc = MyFrame.resourcesLoader;
    }

    @Override
    protected void prepareImage() {
        super.prepareImage();

        setAnimationParameters(150, rc.player_Rogue_idle, false, 0,false);
        if (animationFrame > rc.player_Rogue_idle - 1) {
            animationFrame = 0;
        }
        currentImage = rc.playerRogueSet_idle[animationFrame];
    }

}
