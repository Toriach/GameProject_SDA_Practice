package platformer2020.main;

import platformer2020.Graphic_Misc.ResourcesLoader;
import platformer2020.Misc.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainMenu extends JPanel implements ActionListener, MouseListener {
    private MyFrame mf;
    private Timer timer;

    public Button startButton;
    public Button exitButton;
    private double mouseX;
    private double mouseY;
    private BufferedImage cursorImg;

    public MainMenu(MyFrame mf) {
        this.mf = mf;
        timer = new Timer(33, this);
        timer.start();
        setFocusable(true);
        addMouseListener(this);
        try {
            mf.resourcesLoader = new ResourcesLoader();
            cursorImg = mf.resourcesLoader.cursors[0];
        } catch (IOException e) {
            e.printStackTrace();
        }
        startButton = new Button(50, 150, 100, 100,
                mf.resourcesLoader.buttons[0],
                mf.resourcesLoader.buttonsActive[0]);

        exitButton = new Button(mf.getWidth() - 100, 20, 60, 60,
                mf.resourcesLoader.buttons[1],
                mf.resourcesLoader.buttonsActive[1]);

    }

    public void update() {
        mouseX = MouseInfo.getPointerInfo().getLocation().getX();
        mouseY = MouseInfo.getPointerInfo().getLocation().getY();

        if (exitButton != null && startButton != null) {

            if (mouseX > exitButton.getX() &&
                    mouseX < exitButton.getX() + exitButton.getWidth() &&
                    mouseY > exitButton.getY() &&
                    mouseY < exitButton.getY() + exitButton.getHeight()) {

                exitButton.setActive(true);
                cursorImg = mf.resourcesLoader.cursors[2];
                exitButton.setSize(60, 60);
                exitButton.setPosition(mf.getWidth() - 110, 10);
            } else if (mouseX > startButton.getX() &&
                    mouseX < startButton.getX() + startButton.getWidth() &&
                    mouseY > startButton.getY() &&
                    mouseY < startButton.getY() + startButton.getHeight()) {

                startButton.setActive(true);
                cursorImg = mf.resourcesLoader.cursors[1];
                startButton.setSize(100, 100);
                startButton.setPosition(40, 140);
            } else {
                startButton.setActive(false);
                exitButton.setActive(false);
                cursorImg = mf.resourcesLoader.cursors[0];
                exitButton.setSize(40, 40);
                startButton.setSize(80, 80);
                startButton.setPosition(50, 150);
                exitButton.setPosition(mf.getWidth() - 100, 20);
            }
        }
    }


    @Override
    public void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        ////////////////////////////////////
        g.drawImage(mf.resourcesLoader.backgroundMainMenu, 0, 0, mf.getWidth(), mf.getHeight(), null);
        startButton.draw(g);
        exitButton.draw(g);

        g.drawImage(cursorImg, (int) mouseX - 10, (int) mouseY - 5, null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (exitButton.isActive()) {
            mf.dispatchEvent(new WindowEvent(mf, WindowEvent.WINDOW_CLOSING));
        }
        if (startButton.isActive()) {
            mf.initCharacterSelectionScreen();
        }
    }


    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
