package platformer2020.Entities.Player;

import platformer2020.Graphic_Misc.Animation;
import platformer2020.Graphic_Misc.ResourcesLoader;
import platformer2020.main.MyFrame;

public class PlayerAnimation_Knight extends Animation{
    private Player player;
    ResourcesLoader rc;
    public PlayerAnimation_Knight(int timerDelay,Player player) {
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
            setAnimationParameters(150, rc.player_Knight_idle, true, 30);
            if(animationFrame > rc.player_Knight_idle - 1){ animationFrame = 0; }
            currentImage = rc.playerKnightSet_idle[animationFrame];
        }
        if(walk_player){
            setAnimationParameters(150, rc.player_walk,false,0);
            if(animationFrame > rc.player_walk - 1){ animationFrame = 0; }
            currentImage = rc.playerKnightSet_walk[animationFrame];
        }
        if(player.getDy() > 0){
            setAnimationParameters(150, rc.playerJumpAndFalling,false,0);
            currentImage = rc.playerKnight_falling;
        }
        if(player.isJumping()){
            setAnimationParameters(150, rc.playerJumpAndFalling,false,0);
            currentImage = rc.playerKnightJump;
        }
        if(player_attacking){
            setAnimationParameters(150, rc.player_Knight_attack,false,0);
            if(animationFrame >= rc.player_Knight_attack - 1){
                animationFrame = 0;
            }
            currentImage = rc.playerKnightSet_Attack[animationFrame];
        }
    }

}
