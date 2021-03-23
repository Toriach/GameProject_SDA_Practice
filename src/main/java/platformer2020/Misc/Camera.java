package platformer2020.Misc;

import platformer2020.Entities.Player.Player;
import platformer2020.main.GameCore;
import platformer2020.main.MyFrame;

public class Camera {
    private double offsetX, offsetY;
    private MyFrame myFrame;
    private int xMax, yMax;
    private int cameraOffset = 245;
    public Camera(double x, double y, MyFrame myFrame){
        this.offsetX = x;
        this.offsetY = y;
        this.myFrame = myFrame;
        xMax =  (GameCore.boardWidth * GameCore.tileSize)
                + GameCore.tileSize + cameraOffset;
        yMax = (GameCore.boardHeight * GameCore.tileSize)
                + GameCore.tileSize  + cameraOffset;
    }
    int Diff_PlayerYAndOffsetY; // that name...
    //offsetY = (player.getY() + player.getHeight()) - myFrame.getHeight() / 2; // dont remove
    public void update(Player player){
        offsetX = (player.getX() + player.getWidth()) - myFrame.getWidth() / 2;

        Diff_PlayerYAndOffsetY = (int)(offsetY - ( player.getY() + player.getHeight() - myFrame.getHeight() / 2));

        if(player.getRightBottomCollision() || player.getLeftBottomCollision()) {

            if(offsetY < player.getY() + player.getHeight() - myFrame.getHeight() / 2){
                if (Diff_PlayerYAndOffsetY > 2 || Diff_PlayerYAndOffsetY < -2) {
                    offsetY += 4;
                }
            }else if(offsetY > player.getY() + player.getHeight() - myFrame.getHeight() / 2) {
                if (Diff_PlayerYAndOffsetY > 2 || Diff_PlayerYAndOffsetY < -2) {
                    offsetY -= 4;
                }
            }else{
                // do nothing :)
            }
        }

        if(player.getY() > offsetY + (myFrame.getHeight() / 2)){
            offsetY += 10;
        }
        if(GameCore.reGenerateBoard) {
            if (player.getY() > offsetY - (myFrame.getHeight())) {
                offsetY -= 10;
            }
        }

       // System.out.println((Diff_PlayerYAndOffsetY > 2) + " " + (Diff_PlayerYAndOffsetY < -2) + " " + Diff_PlayerYAndOffsetY);

        if(offsetX < 0) { offsetX = 0; }
        if(offsetY < GameCore.tileSize) { offsetY = GameCore.tileSize; }

        if(offsetX + myFrame.getSize().getWidth()  > xMax) { offsetX = (xMax - myFrame.getWidth());}
        if(offsetY + myFrame.getHeight() > yMax) { offsetY = (yMax - myFrame.getHeight() ); }
       // System.out.println(myFrame.getHeight() / 3 + " " + (myFrame.getHeight() / 3) * 2 );
    }

    public double getOffsetX(){
        return offsetX;
    }

    public double getOffsetY(){
        return offsetY;
    }

    public void setOffsetX(double offsetX){
        this.offsetX = offsetX;
    }

    public void setOffsetY(double offsetY){
        this.offsetY = offsetY;
    }
}
