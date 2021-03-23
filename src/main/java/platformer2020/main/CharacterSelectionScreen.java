package platformer2020.main;

import platformer2020.Graphic_Misc.LightOval;
import platformer2020.Graphic_Misc.ResourcesLoader;
import platformer2020.Misc.charSelectAnim_Knight;
import platformer2020.Misc.charSelectAnim_Mage;
import platformer2020.Misc.charSelectAnim_Rogue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CharacterSelectionScreen extends JPanel implements ActionListener, MouseListener {
    private MyFrame mf;
    private Timer timer;

    private double mouseX;
    private double mouseY;
    private int selectedCharacter = 1;
    private BufferedImage cursorImg;
    private BufferedImage pedestal;
    private charSelectAnim_Rogue charSelectAnimations_Rogue;
    private charSelectAnim_Mage charSelectAnimations_Mage;
    private charSelectAnim_Knight charSelectAnimations_Knight;
    private int borderX = 130;
    private int borderY = 440;
    private int borderWidth = 70;
    private int borderHeight = 60;
    private boolean selectedRogue = false;
    private boolean selectedMage = false;
    private boolean selectedKnight = false;
    LightOval lightOval;

    public CharacterSelectionScreen(MyFrame mf) {
        this.mf = mf;
        timer = new Timer(33, this);
        timer.start();
        setFocusable(true);
        addMouseListener(this);
        try {
            mf.resourcesLoader = new ResourcesLoader();
            cursorImg = mf.resourcesLoader.cursors[0];
            pedestal = mf.resourcesLoader.pedestal;
            charSelectAnimations_Rogue = new charSelectAnim_Rogue(200);
            charSelectAnimations_Mage = new charSelectAnim_Mage(200);
            charSelectAnimations_Knight = new charSelectAnim_Knight(200);
        } catch (IOException e) {
            e.printStackTrace();
        }
        lightOval = new LightOval(165, 485, 75, mf);
    }

    public void update() {
        mouseX = MouseInfo.getPointerInfo().getLocation().getX();
        mouseY = MouseInfo.getPointerInfo().getLocation().getY();
        if (selectedCharacter > 3) {
            selectedCharacter = 1;
        }

        if (mouseX > 130 && mouseX < 130 + borderWidth &&
                mouseY > 440 && mouseY < 440 + borderHeight) {
            selectedCharacter = 1;
            selectedRogue = true;
            selectedMage = false;
            selectedKnight = false;
        } else if (mouseX > 480 && mouseX < 480 + borderWidth &&
                mouseY > 440 && mouseY < 440 + borderHeight) {
            selectedCharacter = 2;
            selectedRogue = false;
            selectedMage = true;
            selectedKnight = false;
        } else if (mouseX > 830 && mouseX < 830 + borderWidth &&
                mouseY > 440 && mouseY < 440 + borderHeight) {
            selectedCharacter = 3;
            selectedRogue = false;
            selectedMage = false;
            selectedKnight = true;
        }
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        ////////////////////////////////////
        g.drawImage(mf.resourcesLoader.backgroundCharacterSelection, 0, 0, mf.getWidth(), mf.getHeight(), null);
        g.setFont(new Font("Bank Gothic",Font.BOLD,18));
        g.drawImage(pedestal, 50, 500, null);
        g.drawImage(pedestal, 400, 500, null);
        g.drawImage(pedestal, 750, 500, null);

        if (selectedCharacter == 1) {
            borderX = 130;
            lightOval.setPosition(165, 485);
            g.drawRect(borderX, borderY, borderWidth, borderHeight);
            g.drawImage(charSelectAnimations_Rogue.getImage(), 121, 390, null);
            g.drawImage(mf.resourcesLoader.charSelectBorder, borderX, borderY, borderWidth, borderHeight, null);
        } else if (selectedCharacter == 2) {
            borderX = 480;
            lightOval.setPosition(520, 485);
            g.drawRect(borderX, borderY, borderWidth, borderHeight);
            g.drawImage(charSelectAnimations_Mage.getImage(), 471, 390, null);
            g.drawImage(mf.resourcesLoader.charSelectBorder, borderX, borderY, borderWidth, borderHeight, null);
        } else if (selectedCharacter == 3) {
            borderX = 830;
            lightOval.setPosition(870, 485);
            g.drawRect(borderX, borderY, borderWidth, borderHeight);
            g.drawImage(charSelectAnimations_Knight.getImage(), 821, 390, null);
            g.drawImage(mf.resourcesLoader.charSelectBorder, borderX, borderY, borderWidth, borderHeight, null);
        }
        lightOval.draw(g);

        // set darkness~~
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.90f));
        g.fillRect(0, 0, mf.getWidth(), mf.getHeight());
        // end of darkness
        g.setColor(Color.white);
        if (selectedCharacter == 1) {
            g.drawString("Rogue",135,430);
        }else if (selectedCharacter == 2) {
            g.drawString("Mage",490,430);
        }else if (selectedCharacter == 3) {
            g.drawString("Knight",835,430);
        }
        g.drawImage(cursorImg, (int) mouseX - 10, (int) mouseY - 5, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(selectedRogue){
            mf.initMainGame(1);
        }else if(selectedMage){
            mf.initMainGame(2);
        }else if(selectedKnight){
            mf.initMainGame(3);
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
