package platformer2020.Entities.Player;

import platformer2020.Graphic_Misc.Animation;
import platformer2020.Graphic_Misc.ResourcesLoader;
import platformer2020.main.MyFrame;

public class PlayerAnimation_Mage extends Animation {
    private Player player;
    ResourcesLoader rc;
    public PlayerAnimation_Mage(int timerDelay,Player player) {
        super(timerDelay);
        this.player = player;
        walk_player = false;
        idle_player = true;
        rc = MyFrame.resourcesLoader;
    }

    @Override
    protected void prepareImage() {
        super.prepareImage();
        // Animation - Idle
        if(idle_player) {
            setAnimationParameters(150, rc.player_mage_idle, true, 30);
            if(animationFrame > rc.player_mage_idle - 1){ animationFrame = 0; }
            currentImage = rc.playerMageSet_idle[animationFrame];
        }
        if(walk_player){
            setAnimationParameters(150, rc.player_walk,false,0);
            if(animationFrame > rc.player_walk - 1){ animationFrame = 0; }
            currentImage = rc.playerMageSet_walk[animationFrame];
        }
        if(player.getDy() > 0){
            setAnimationParameters(150, rc.playerJumpAndFalling,false,0);
            currentImage = rc.playerMage_falling;
        }
        if(player.isJumping()){
            setAnimationParameters(150, rc.playerJumpAndFalling,false,0);
            currentImage = rc.playerMageJump;
        }
    }

}
