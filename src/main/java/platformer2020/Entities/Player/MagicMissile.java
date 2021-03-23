package platformer2020.Entities.Player;

import platformer2020.Misc.Projectile;
import platformer2020.main.MainMenu;

public class MagicMissile extends Projectile {

    public MagicMissile(int x, int y, int width, int height, boolean playerFaceRight) {
        super(x, y, width, height , playerFaceRight);
        image = rc.magicMissileImg;
        projectileSpeed = 8;
    }
}
