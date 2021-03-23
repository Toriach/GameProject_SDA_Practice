package platformer2020.Misc;

import platformer2020.Graphic_Misc.Animation;
import platformer2020.Graphic_Misc.ResourcesLoader;
import platformer2020.main.MyFrame;

public class charSelectAnim_Knight extends Animation {
    private ResourcesLoader rc;
    public charSelectAnim_Knight(int timerDelay) {
        super(timerDelay);
        rc = MyFrame.resourcesLoader;
    }

    @Override
    protected void prepareImage() {
        super.prepareImage();

        setAnimationParameters(150, rc.player_Knight_idle, false,0,false);
        if (animationFrame > rc.player_Knight_idle - 1) {
            animationFrame = 0;
        }
        currentImage = rc.playerKnightSet_idle[animationFrame];
    }
}
