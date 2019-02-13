import java.awt.*;

import static java.lang.StrictMath.abs;

public class Bishop extends Figure {
    private static final String WHITE = "images/pieces/wbi.png";
    private static final String BLACK = "images/pieces/bbi.png";
    private String type = "bishop";

    public Bishop(String color, Point pos)
    {
        super(color, pos);
        if(color == "white") setFigureIMG(WHITE);
        else setFigureIMG(BLACK);
        System.out.println(color + "Goniec");
    }

    public boolean validMove(Point nextHop)
    {
        if(abs(this.getFigurePosX() - nextHop.x) == abs(this.getFigurePosY() - nextHop.y) ) {
            return true;
        }
        return false;
    }

    public boolean validAttack(Point nextHop)
    {
        return validMove(nextHop);
    }

    public String getType()
    {
        return type;
    }

    public boolean haveColision(Figure[] figures, Point nextHop)
    {
        Point podejrzane[] = new Point[8];
        int index = 0;
        int mniejsza;
        int wieksza;
        if(nextHop.x < getFigurePos().x) {
            mniejsza = nextHop.x;
            wieksza = getFigurePos().x;
        }else{
            mniejsza = getFigurePos().x;
            wieksza = nextHop.x;
        }
        for(int i = mniejsza; i < wieksza; i++) {
            if (nextHop.y < getFigurePos().y) {
                for (int j = nextHop.y; j < getFigurePos().y; j++) {
                    if(validMove(new Point(i,j))) podejrzane[index++] = new Point(i,j);
                }
            } else {
                for (int j = getFigurePos().y; j < nextHop.y; j++) {
                    if(validMove(new Point(i,j))) podejrzane[index++] = new Point(i,j);
                }
            }
        }
        for(int i=0; i<32; i++)
        {
            for(int j=0; j<index; j++)
            {
                if(figures[i] == this) continue;
                if(figures[i].getFigurePosX() == nextHop.x && figures[i].getFigurePosY() == nextHop.y) continue;
                if(figures[i].getFigurePosX() == podejrzane[j].x && figures[i].getFigurePosY() == podejrzane[j].y){
                    return true;
                }
            }
        }
        return false;
    }
}
