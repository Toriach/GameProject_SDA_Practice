package platformer2020.Graphic_Misc;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ResourcesLoader {
// values for animation frame counter //
    public int player_walk = 6;
    public int playerJumpAndFalling = 1;
    // projectiles images count
    public int magicMissile = 1;
    // player Mage images count
    public int player_mage_idle = 12;
    // player Knight images count
    public int player_Knight_idle = 13;
    public int player_Knight_attack = 5;
    // player Rogue images count
    public int player_Rogue_idle = 19;
    public int player_Rogue_attack = 7;

    // Mobs
    // Orc
    public int orcAnimCount_idle = 18;
    // Golem
    public int golemAnimCount_idle = 10;

    // other
    public int goldCoinAnimationCount = 10;
    public int tileSetSize = 5;
    public int mainMenuButtonsSize = 2;
    public int cursorsSize = 3;

    public int torchCount = 4;

// images // images // images // images //
    // player Knight images
    public BufferedImage playerKnightJump;
    public BufferedImage playerKnight_falling;
    public BufferedImage[] playerKnightSet_idle;
    public BufferedImage[] playerKnightSet_walk;
    public BufferedImage[] playerKnightSet_Attack;

    // player Rogue images
    public BufferedImage playerRogue_falling;
    public BufferedImage playerRogueJump;
    public BufferedImage[] playerRogueSet_idle;
    public BufferedImage[] playerRogueSet_walk;
    public BufferedImage[] playerRogueSet_Attack;

    // player Mage images
    public BufferedImage playerMage_falling;
    public BufferedImage playerMageJump;
    public BufferedImage[] playerMageSet_idle;
    public BufferedImage[] playerMageSet_walk;

    // projectiles images count
    public BufferedImage magicMissileImg;

    // Collectible
    public BufferedImage[] goldCoinSet;

    // Decors
    public BufferedImage DoorOpen;
    public BufferedImage DoorClose;
    public BufferedImage[] Window;
    public BufferedImage[] torch;

    // mobs
    public BufferedImage[] orc_idle;
    public BufferedImage[] golem_idle;
    // HUD TODO do below as table
    public BufferedImage HudBar;
    public BufferedImage scoreTxtImg;

    // other
    public BufferedImage[] tileSet;
    public BufferedImage background;
    public BufferedImage backgroundMainMenu;
    public BufferedImage backgroundCharacterSelection;
    public BufferedImage charSelectBorder;
    public BufferedImage pedestal;
    public BufferedImage[] buttons;
    public BufferedImage[] buttonsActive;

    public BufferedImage[] cursors;

    public ResourcesLoader() throws IOException {
        loadResources();
    }
    public InputStream inputStream;

    public void loadResources() throws IOException {

        /* * * * * * * * * * background * * * * * * * * * * */
        inputStream = ResourcesLoader.class.getResourceAsStream("/assets/background/BackgroundBig.png");
        background = ImageIO.read(inputStream);

        /* * * * * * * * * * background - main menu * * * * */
        inputStream = ResourcesLoader.class.getResourceAsStream("/assets/background/Battleground2.png");
        backgroundMainMenu = ImageIO.read(inputStream);

        /* * * * * * * * * character selection * * * * * * * */
        // background
        inputStream = ResourcesLoader.class.getResourceAsStream("/assets/background/Battleground3.png");
        backgroundCharacterSelection = ImageIO.read(inputStream);

        // pedestal
        inputStream = ResourcesLoader.class.getResourceAsStream("/assets/terrain/pedestal.png");
        pedestal = ImageIO.read(inputStream);
        // char.selection border
        inputStream = ResourcesLoader.class.getResourceAsStream("/assets/GUI/Borders/charSelectBorder.png");
        charSelectBorder = ImageIO.read(inputStream);

        /* * * * * * * * * * buttons * * * *  * * * * * * * */
        buttons = new BufferedImage[mainMenuButtonsSize];
        for (int i = 0; i < mainMenuButtonsSize; i++) {
            inputStream = ResourcesLoader.class.getResourceAsStream("/assets/GUI/Buttons/Button_" + (i +1) + ".png");
            buttons[i] = ImageIO.read(inputStream);
        }

        /* * * * * * * * * * buttons - Active * * * * * * * */
        buttonsActive = new BufferedImage[mainMenuButtonsSize];
        for (int i = 0; i < mainMenuButtonsSize; i++) {
            inputStream = ResourcesLoader.class.getResourceAsStream("/assets/GUI/Buttons_active/ButtonActive_" + (i +1) + ".png");
            buttonsActive[i] = ImageIO.read(inputStream);
        }

        /* * * * * * * * * * Cursors * * * * * * * * * * * * */
        cursors = new BufferedImage[cursorsSize];
        for (int i = 0; i < cursorsSize; i++) {
            inputStream = ResourcesLoader.class.getResourceAsStream("/assets/GUI/Cursors/cursor_" + i + ".png");
            cursors[i] = ImageIO.read(inputStream);
        }

        /* * * * * * * * * *  Collectible * * * * * * * * * * */
        // gold coin
        goldCoinSet = new BufferedImage[goldCoinAnimationCount];
        for (int i = 0; i < goldCoinSet.length; i++) {
            inputStream = ResourcesLoader.class.getResourceAsStream("/assets/Collectible/Coin2/Gold_" + (i + 1) + ".png");
            goldCoinSet[i] = ImageIO.read(inputStream);
        }

        /* * * * * * * * * * Tile set * * * * * * * * * * */
        tileSet = new BufferedImage[tileSetSize];
        for (int i = 0; i < tileSet.length; i++) {
            inputStream = ResourcesLoader.class.getResourceAsStream("/assets/terrain/Tiles/tile" + (i + 1) + ".png");
            tileSet[i] = ImageIO.read(inputStream);
        }

        /* * * * * * * * * * HUD * * * * * * * * * * * * */
        inputStream = ResourcesLoader.class.getResourceAsStream("/assets/GUI/HUD/Table.png");
        HudBar = ImageIO.read(inputStream);
        inputStream = ResourcesLoader.class.getResourceAsStream("/assets/GUI/HUD/Score.png");
        scoreTxtImg = ImageIO.read(inputStream);

        /* * * * * * * * * * Decors * * * * * * * * * * * */
        inputStream = ResourcesLoader.class.getResourceAsStream("/assets/Decors/door1.png");
        DoorClose = ImageIO.read(inputStream);
        inputStream = ResourcesLoader.class.getResourceAsStream("/assets/Decors/door4.png");
        DoorOpen = ImageIO.read(inputStream);
        Window = new BufferedImage[1];
        inputStream = ResourcesLoader.class.getResourceAsStream("/assets/Decors/window.png");
        Window[0] = ImageIO.read(inputStream);

        torch = new BufferedImage[torchCount];
        for (int i = 0; i < torch.length; i++) {
            inputStream = ResourcesLoader.class.getResourceAsStream("/assets/Decors/torch1_" + (i + 1) + ".png");
            torch[i] = ImageIO.read(inputStream);
        }

        /* * * * * * * * * Projectiles * * * * * * * * * * */
        // magic missile
        inputStream = ResourcesLoader.class.getResourceAsStream("/assets/player/Mage/Projectile/projectile_1.png");
        magicMissileImg = ImageIO.read(inputStream);

        /* * * * * * * * * * Mobs * * * * * * * * * * * * */
        // Orc
        orc_idle = new BufferedImage[orcAnimCount_idle];
        for (int i = 0; i < orc_idle.length; i++) {
            inputStream = ResourcesLoader.class.getResourceAsStream("/assets/mobs/Orc/PNG/Idle/0_Orc_Idle_" + (i + 1) + ".png");
            orc_idle[i] = ImageIO.read(inputStream);
        }
        // golem
        golem_idle = new BufferedImage[golemAnimCount_idle];
        for (int i = 0; i < golem_idle.length; i++) {
            inputStream = ResourcesLoader.class.getResourceAsStream("/assets/mobs/Golem_1/Idle/0_Golem_Idle_00" + i + ".png");
            golem_idle[i] = ImageIO.read(inputStream);
        }

        /* * * * * * * * * * Player * * * * * * * * * * * * */

        /* * * * * * * * Hero - Mage * * * *  * * * * * * * */

        // Idle
        playerMageSet_idle = new BufferedImage[player_mage_idle];
        for (int i = 0; i < playerMageSet_idle.length; i++) {
            inputStream = ResourcesLoader.class.getResourceAsStream("/assets/player/Mage/Idle/idle" + (i + 1) + ".png");
            playerMageSet_idle[i] = ImageIO.read(inputStream);
        }

        // Walk
        playerMageSet_walk = new BufferedImage[player_walk];
        for (int i = 0; i < playerMageSet_walk.length; i++) {
            inputStream = ResourcesLoader.class.getResourceAsStream("/assets/player/Mage/Walk/walk" + (i + 1) + ".png");
            playerMageSet_walk[i] = ImageIO.read(inputStream);
        }
        // Jump
        inputStream = ResourcesLoader.class.getResourceAsStream("/assets/player/Mage/Jump/jump3.png");
        playerMageJump = ImageIO.read(inputStream);

        // Falling
        inputStream = ResourcesLoader.class.getResourceAsStream("/assets/player/Mage/High_Jump/high_jump10.png");
        playerMage_falling = ImageIO.read(inputStream);

        /* * * * * * * * Hero - Rogue * * * *  * * * * * * * */

        // Idle
        playerRogueSet_idle = new BufferedImage[player_Rogue_idle];
        for (int i = 0; i < playerRogueSet_idle.length; i++) {
            inputStream = ResourcesLoader.class.getResourceAsStream("/assets/player/Rogue/Idle/idle" + (i + 1) + ".png");
            playerRogueSet_idle[i] = ImageIO.read(inputStream);
        }

        // Attack
        playerRogueSet_Attack = new BufferedImage[player_Rogue_attack];
        for (int i = 0; i < playerRogueSet_Attack.length; i++) {
            inputStream = ResourcesLoader.class.getResourceAsStream("/assets/player/Rogue/Attack/Attack" + (i + 1) + ".png");
            playerRogueSet_Attack[i] = ImageIO.read(inputStream);
        }

        // Walk
        playerRogueSet_walk = new BufferedImage[player_walk];
        for (int i = 0; i < playerRogueSet_walk.length; i++) {
            inputStream = ResourcesLoader.class.getResourceAsStream("/assets/player/Rogue/Walk/walk" + (i + 1) + ".png");
            playerRogueSet_walk[i] = ImageIO.read(inputStream);
        }

        // Jump
        inputStream = ResourcesLoader.class.getResourceAsStream("/assets/player/Rogue/Jump/jump3.png");
        playerRogueJump = ImageIO.read(inputStream);

        // Falling
        inputStream = ResourcesLoader.class.getResourceAsStream("/assets/player/Rogue/High_Jump/high_jump11.png");
        playerRogue_falling = ImageIO.read(inputStream);

        /* * * * * * * * Hero - Knight * * * *  * * * * * * * */

        // Idle
        playerKnightSet_idle = new BufferedImage[player_Knight_idle];
        for (int i = 0; i < playerKnightSet_idle.length; i++) {
            inputStream = ResourcesLoader.class.getResourceAsStream("/assets/player/Knight/Idle/idle" + (i + 1) + ".png");
            playerKnightSet_idle[i] = ImageIO.read(inputStream);
        }

        // Walk
        playerKnightSet_walk = new BufferedImage[player_walk];
        for (int i = 0; i < playerKnightSet_walk.length; i++) {
            inputStream = ResourcesLoader.class.getResourceAsStream("/assets/player/Knight/Walk/walk" + (i + 1) + ".png");
            playerKnightSet_walk[i] = ImageIO.read(inputStream);
        }

        // Attack
        playerKnightSet_Attack = new BufferedImage[player_Knight_attack];
        for (int i = 0; i < playerKnightSet_Attack.length; i++) {
            inputStream = ResourcesLoader.class.getResourceAsStream("/assets/player/Knight/Attack/attack" + (i + 1) + ".png");
            playerKnightSet_Attack[i] = ImageIO.read(inputStream);
        }

        // Jump
        inputStream = ResourcesLoader.class.getResourceAsStream("/assets/player/Knight/Jump/jump3.png");
        playerKnightJump = ImageIO.read(inputStream);

        // Falling
        inputStream = ResourcesLoader.class.getResourceAsStream("/assets/player/Knight/High_Jump/high_jump11.png");
        playerKnight_falling = ImageIO.read(inputStream);

    }
}
