package platformer2020.main;

import platformer2020.Entities.Collectible.Coin;
import platformer2020.Entities.Collectible.Collectible;
import platformer2020.Entities.Enemys.Enemy;
import platformer2020.Entities.Enemys.Golem;
import platformer2020.Entities.Player.MagicMissile;
import platformer2020.Entities.Player.Player;
import platformer2020.Entities.interactable.Door;
import platformer2020.Graphic_Misc.Decors.DecorElement;
import platformer2020.Graphic_Misc.HUD;
import platformer2020.Misc.Camera;
import platformer2020.Misc.Projectile;
import platformer2020.terrainObjects.Block_Dirt;
import platformer2020.terrainObjects.BorderBlock;
import platformer2020.terrainObjects.TerrainBlock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCore extends JPanel implements ActionListener {
    private Timer GameLoop;
    private MyFrame myFrame;

    public static int boardWidth = 25;
    public static int boardHeight = 20;
    private int[][] gameBoard;
    public static List<TerrainBlock> collisionBlocks;
    public static int tileSize = 50;
    public boolean initFocus = true;
    private static Player player;
    private int charType;
    private Camera camera;
    private double mouseX;
    private double mouseY;
    private BufferedImage cursorImg;
    public static List<Projectile> playerBullets;
    public static List<Collectible> collectibles;
    public static HUD hud;
    public Door doorStart;
    public Door doorExit;
    public static boolean reGenerateBoard = false;
    public boolean setPlayerOnStart = false;
    public int reGenerateBoardCounter = 0;

    public static boolean debugMode = false;
    public static boolean debugModeCoordinates = false;
    public static String debugString = "";

    public List<DecorElement> decorList;

    private Random random = new Random();

    private BufferedImage background;

    // test area 51 ~~
    public static List<Enemy> enemies;


    public GameCore(MyFrame mf, int charType) {
        this.myFrame = mf;
        this.charType = charType;
        GameLoop = new Timer(16, this);
        GameLoop.start();

        cursorImg = mf.resourcesLoader.cursors[0];
        background = mf.resourcesLoader.background;
        gameInit();
        generateBoard(boardWidth, boardHeight);

    }

    public void gameInit() {
        player = new Player(150, 100, tileSize, charType);
        gameBoard = new int[boardWidth][boardHeight];
        collisionBlocks = new ArrayList<>();
        playerBullets = new ArrayList<>();
        collectibles = new ArrayList<>();
        decorList = new ArrayList<>();
        enemies = new ArrayList<>();

//        enemies.add(new Orc((tileSize * 10) - 50, (tileSize * 20) - 29, 100, 100));
//        enemies.add(new Golem((tileSize * 7) - 50, (tileSize * 20) - 29, 100, 100));

        hud = new HUD(charType);
        doorStart = new Door(1 * tileSize, 4 * tileSize - 9, 64, 64, 1);
        doorExit = new Door((24 * tileSize) - 5, (20 * tileSize) - 9, 64, 64, 2);
        addKeyListener(player);
        setFocusable(true);
        camera = new Camera(player.getX(), player.getY(), myFrame);
    }

    public void generateBoard(int boardWidth, int boardHeight) {
        // *** generate border *** //
        for (int i = 0; i <= boardWidth; i++) {
            for (int j = 0; j <= boardHeight + 1; j++) {
                if (j == 0) {
                    collisionBlocks.add(new BorderBlock(0 + (i * tileSize), tileSize + (j * tileSize), tileSize, tileSize, "top", 0));
                } else if (j == boardHeight) {
                    collisionBlocks.add(new BorderBlock(0 + (i * tileSize), tileSize + (j * tileSize), tileSize, tileSize, "bottom", 0));
                } else if (i == 0) {
                    collisionBlocks.add(new BorderBlock(0 + (i * tileSize), tileSize + (j * tileSize), tileSize, tileSize, "left", 0));
                } else if (i == boardWidth) {
                    collisionBlocks.add(new BorderBlock(0 + (i * tileSize), tileSize + (j * tileSize), tileSize, tileSize, "right", 0));
                }
            }
        }

        generateBoardV2(boardWidth, boardHeight);

        // *** generate platforms *** //

        // read gameBoard and fill it with corresponding blocks
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                if (gameBoard[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        continue;
                    }// use switch ?
                    collisionBlocks.add(new Block_Dirt((tileSize * i), (tileSize * j), tileSize, tileSize, 1));
                }
                if (gameBoard[i][j] == 2) {
                    // add destructible walls
                    collisionBlocks.add(new Block_Dirt((tileSize * i), (tileSize * j), tileSize, tileSize, 2));
                    // use switch ?
                }

            }
        }
        // test platforms
//        for (int i = 0; i < 15; i++) {
//            if (i == 0 || i == 9) {
//                continue;
//            }
//            if(i != 8) {
//                solidBlocks.add(new Block_Dirt((tileSize * i), (tileSize * 9), tileSize, tileSize));
//            }else
//            {
//               // solidBlocks.add(new BorderBlock((tileSize * i), (tileSize * 9), tileSize, tileSize,"bottom"));
//            }
//        }
//        solidBlocks.add(new Block_Dirt((tileSize * 8), (tileSize * 8), tileSize, tileSize));
//        solidBlocks.add(new Block_Dirt((tileSize * 5), (tileSize * 6), tileSize, tileSize));
        // generate starting platform
        for (int i = 1; i < 5; i++) {
            collisionBlocks.add(new Block_Dirt((tileSize * i), (tileSize * 5), tileSize, tileSize, 1));
        }


    }

    public void generateBoardV2(int boardWidth, int boardHeight) {
        for (int i = 0; i < boardWidth + 1; i++) {
            for (int j = 0; j < boardHeight + 1; j++) {
                if (i != 0 && j != 0 && j != 1 && i != boardWidth && j != boardHeight) {
                    // generate main platforms every 4 height
                    if (j % 4 == 1) {
                        if (random.nextInt(5) != 4 && random.nextInt(5) != 3) {
                            gameBoard[i][j] = 1;
                            if (random.nextInt(8) == 0) {
                                // generate destructible walls
                                gameBoard[i][j - 1] = 2;
                                gameBoard[i][j - 2] = 2;
                                gameBoard[i][j - 3] = 2;
                            }
                            // cheat last floor walls
                            if (random.nextInt(4) == 0) {
                                if (j == 17) {
                                    gameBoard[i][j + 1] = 2;
                                    gameBoard[i][j + 2] = 2;
                                    collisionBlocks.add(new Block_Dirt((tileSize * i), (tileSize * 20), tileSize, tileSize, 2));
                                }
                            }
                            if (gameBoard[i][j - 1] == 0) {
                                if (random.nextInt(5) == 0) {
                                    collectibles.add(new Coin(tileSize * i, tileSize * (j - 1), 32, 32));
                                }
                                if (random.nextInt(4) == 1) {
                                    decorList.add(new DecorElement(tileSize * i, tileSize * (j - 2), 64, 64, 1));
                                }
                                if (random.nextInt(4) == 2) {
                                    decorList.add(new DecorElement((tileSize * i), (tileSize * (j - 1)), 64, 64, 2));
                                }
                            }
                            // end of generating platform
                        }

                        if(gameBoard[i][j - 1] == 0){
                            if (random.nextInt(5) == 2) {
                               // enemies.add(new Orc((tileSize * i + 1) - 50, (tileSize * j) - 29, 100, 100));
                               // enemies.add(new Golem((tileSize * i) - 50, (tileSize * (j - 1)) - 29, 100, 100)); // TODO randomly add enemies
                            }
                        }
                    }
                }
            }
        }
        // board print for debug
        for (int j = 0; j < boardHeight; j++) {
            for (int i = 0; i < boardWidth; i++) {
                //   System.out.print("(y"+j+",x"+i+ " "+gameBoard[i][j]);
                System.out.print(" " + gameBoard[i][j]);
            }
            System.out.println();
        }
    }

    public static void addPlayerBullet() {
        if(hud.ammo > 0) {
            hud.ammo--;
            playerBullets.add(new MagicMissile((int) player.getX(), (int) player.getY(), 60, 20, player.isAnimationRight()));
        }
    }

    public void gameUpdate() {
        player.update();
        camera.update(player);
        mouseX = MouseInfo.getPointerInfo().getLocation().getX();
        mouseY = MouseInfo.getPointerInfo().getLocation().getY();

        // update bullets and check for collisions
        for (int i = 0; i < playerBullets.size(); i++) {
            // update bullets
            playerBullets.get(i).update();
            for (int j = 0; j < collisionBlocks.size(); j++) {
                if (playerBullets.get(i).getHitBox().intersects(collisionBlocks.get(j).getRectangle())) {
                    // remove bullet
                    playerBullets.remove(i);
                    if (collisionBlocks.get(j).getBlockID() == 2) {
                        // remove wall block if is destructible
                        collisionBlocks.remove(j);
                    }
                }
            }
            for (int j = 0; j < enemies.size() ; j++) {
                if(enemies.size() > 0) {
                    if (playerBullets.get(i).getHitBox().intersects(enemies.get(j).getHitBox())) {
                        GameCore.enemies.remove(GameCore.enemies.get(j));
                        playerBullets.remove(i);
                        hud.Score += 5;
                    }
                }
            }

        }

        //check for collisions with collectibles
        for (int i = 0; i < collectibles.size(); i++) {
            if (player.getBodyHitBoxRectangle().intersects(collectibles.get(i).getHitBox())) {
                if (collectibles.get(i).getItemID() == 1) {
                    collectibles.remove(i);
                    hud.Score++;
                }
            }
        }

        if (player.getBodyHitBoxRectangle().intersects(doorExit.getHitBox())) {
            reGenerateBoard = true;
            setPlayerOnStart = true;
        }

        if (reGenerateBoard) {
            regeneratePlayBoard();

        }
        // misc and 1 time use stuff //
        if (initFocus) {
            requestFocusInWindow();
            initFocus = false;
        }
    }

    // TODO fix me im a mess
    public void regeneratePlayBoard() {
        if (setPlayerOnStart) {
            player.setPosition(100, 100);
            setPlayerOnStart = false;
        }
        if (reGenerateBoard) {
            reGenerateBoardCounter++;
            if (reGenerateBoardCounter > 80) {
                gameBoard = new int[boardWidth][boardHeight];
                collisionBlocks.clear();
                collectibles.clear();
                reGenerateBoard = false;
                generateBoard(boardWidth, boardHeight);
                reGenerateBoardCounter = 0;
            }
        }
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        this.setBackground(Color.WHITE);

        AffineTransform oldTransform = g.getTransform();
        g.scale(1.3, 1.3);

        g.setColor(Color.red);

        // camera movement
        g.translate(-camera.getOffsetX(), -camera.getOffsetY());
        // draw background
        g.drawImage(background, 0, 0, null);
        drawBoard(g);

        for (int i = 0; i < collectibles.size(); i++) {
            collectibles.get(i).draw(g);
        }

        for (int i = 0; i < decorList.size(); i++) {
            decorList.get(i).draw(g);
        }
        doorStart.draw(g);
        doorExit.draw(g);

        if(enemies.size() > 0) {
            for (int i = 0; i < enemies.size(); i++) {
                enemies.get(i).draw(g);
            }

        }

        player.draw(g);
        if (debugModeCoordinates) {
            g.setColor(Color.white);
            for (int i = 0; i < boardWidth + 1; i++) {
                for (int j = 0; j < boardHeight + 2; j++) {
                    g.drawString("(" + i + " , " + j + ")",
                            (i * tileSize) + 5, (j * tileSize) + 30);
                }
            }
            g.setColor(Color.red);
        }

        for (int i = 0; i < playerBullets.size(); i++) {
            playerBullets.get(i).draw(g);
        }
        hud.draw(g);

        g.translate(camera.getOffsetX(), camera.getOffsetY());
        // debugString = camera.getOffsetX()+" " +camera.getOffsetY();
        // end of camera movement

        hud.draw(g);

        g.setTransform(oldTransform);
        g.setColor(Color.white);
        g.setFont(new Font("Bank Gothic", Font.BOLD, 18));
        g.drawString(debugString, 10, 20);
        g.drawImage(cursorImg, (int) mouseX - 10, (int) mouseY - 5, null);
    }

    public void drawDebugDots(Graphics2D g) {
//        g.setColor(Color.green);
//        if (obstacleOnRight) {
//            g.fillOval((int)player.getX() + 70, (int)player.getY() + 65, 5, 5);
//        }
//
//        if (obstacleOnLeft) {
//            g.fillOval((int)player.getX() - 25, (int)player.getY() + 65, 5, 5);
//        }
//
//        if (obstacleUnder) {
//            g.fillOval((int)player.getX() + 25, (int)player.getY() + 115, 5, 5);
//        }
//
//        if (obstacleUpward) {
//            g.fillOval((int)player.getX() + 25, (int)player.getY() - 25, 5, 5);
//        }
//        // g.fillOval(player.getX() + 50,player.getY() + 50,5, 5);
    }

    public void drawBoard(Graphics2D g) {
        for (int i = 0; i < collisionBlocks.size(); i++) {
            collisionBlocks.get(i).draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            gameUpdate();
        } catch (Exception err) {
            //System.out.println("null point again ? TODO ME
        }
        repaint();
    }


}
