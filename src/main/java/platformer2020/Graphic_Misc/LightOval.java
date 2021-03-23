package platformer2020.Graphic_Misc;

import platformer2020.main.MyFrame;

import java.awt.*;
import java.awt.geom.Point2D;

public class LightOval {
    private float x;
    private float y;
    private float radius;
    Point2D center;
    float[] dist = {0.0f, 1.0f};
    Color[] colors = {new Color(0.0f, 0.0f, 0.0f, 0.0f), Color.black};
    RadialGradientPaint p;
    MyFrame mf;

    public LightOval(float x, float y, float radius,MyFrame mf) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.mf = mf;

        center = new Point2D.Float(x, y);
        p = new RadialGradientPaint(center, radius, dist, colors);
    }

    public void draw(Graphics2D g){
        g.setPaint(p);
    }

    public void setPosition(float x,float y){
        this.x = x;
        this.y = y;
        center = new Point2D.Float(x, y);
        p = new RadialGradientPaint(center, radius, dist, colors);
    }
}
