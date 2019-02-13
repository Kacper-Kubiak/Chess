import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Board
{
    private Point position[][] = new Point[8][8];
    private String boardIMG = "images/plansza.png";

    public Board() {
        for(int i=0; i<8; i++) {
            //System.out.println(58 * (i+1) + 10);
            for(int j=0; j<8; j++) {
                position[i][j] = new Point(58 * (i+1) + 10, 58 * (j+1) + 38);
                //System.out.println(58 * (i+1) +" "+ 58 * (j+1));
            }
        }

    }

    public String getBoardIMG() {
        return this.boardIMG;
    }

    public Point getPosByPoint(Point pos)
    {
        int x = pos.x;
        int y = pos.y;
        /*for(int i=0; i<8; i++) {
            if(x >= position[i][0].x && x <= position[i][0].x+58)
            {
                System.out.print(i+1+" ");
            }
        }
        for(int i=0; i<8; i++) {
            if(y >= position[0][i].y && y <= position[0][i].y+58)
            {
                System.out.print(i+1+" ");
            }
        }*/
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if (x >= position[i][0].x && x <= position[i][0].x + 58) {
                    if (y >= position[0][j].y && y <= position[0][j].y + 58) {
                        //System.out.println((i+1) + " " + (j+1));
                        return new Point(i+1, j+1);
                    }
                }
            }
        }
        return new Point(0,0);
    }
}
