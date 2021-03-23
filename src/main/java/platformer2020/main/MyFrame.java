package platformer2020.main;

import platformer2020.Graphic_Misc.ResourcesLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MyFrame extends JFrame {
    private GameCore gc;
    private MainMenu mainMenu;
    private CharacterSelectionScreen charSelect;
    public static ResourcesLoader resourcesLoader;

    public MyFrame() {
        setTitle("Platformer project 2020");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1024, 720);
        mainMenu = new MainMenu(this);
        add(mainMenu);

        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
        getContentPane().setCursor(blankCursor);

        setVisible(true);
    }

    public void initCharacterSelectionScreen() {
        charSelect = new CharacterSelectionScreen(this);
        remove(mainMenu);
        add(charSelect);
        setVisible(true);
    }

    public void initMainGame(int charType) {
        gc = new GameCore(this, charType);
        remove(charSelect);
        add(gc);
        setVisible(true);
    }

    public void setCustomCursor(int cursorType) {

    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }
}
