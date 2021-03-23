package platformer2020.Graphic_Misc;

import platformer2020.Entities.Player.Player;
import platformer2020.main.MainMenu;
import platformer2020.main.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


public class HUD implements ActionListener {
    private ResourcesLoader rc;
    private BufferedImage HudBar;
    private BufferedImage ScoreImg;
    private Timer timer;

    public int Score = 0;
    public int ammo = 10;
    public int maxAmmo = 10;
    int charType;

    public HUD(int charType) {
        rc = MyFrame.resourcesLoader;
        HudBar = rc.HudBar;
        ScoreImg = rc.scoreTxtImg;
        this.charType = charType;
        timer = new Timer(1500,this);
        timer.start();
    }

    public void draw(Graphics2D g){
        g.drawImage(HudBar,5,5,150,50,null);
        g.drawImage(ScoreImg,15,12,50,30,null);

        if(charType == 2) {
            g.drawImage(HudBar,150,5,220,50,null);
            g.setColor(Color.blue);
            g.fillRect(255, 12, (int)(100 * ammo / maxAmmo), 30);
        }

        g.setColor(Color.black);
        g.setFont(new Font("Bank Gothic", Font.BOLD, 32));
        g.drawString(""+Score,80,38);
        if(charType == 2) {
            g.setColor(Color.YELLOW);
            g.drawString("Mana: " + ammo + " / " + maxAmmo, 160, 38);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(ammo < maxAmmo){
            ammo++;
        }
    }
}
