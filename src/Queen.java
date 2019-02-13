import java.awt.*;

import static java.lang.StrictMath.abs;

public class Queen extends Figure {
    private static final String WHITE = "images/pieces/wqu.png";
    private static final String BLACK = "images/pieces/bqu.png";
    private String type = "queen";

    public Queen(String color, Point pos)
    {
        super(color, pos);
        if(color == "white") setFigureIMG(WHITE);
        else setFigureIMG(BLACK);
        System.out.println(color + "Hetman");
    }

    public boolean validMove(Point nextHop)
    {
        if((nextHop.y <= 8 || nextHop.y > 0) && this.getFigurePosX() - nextHop.x == 0) {
            return true;
        }
        else if((nextHop.x <= 8 || nextHop.x > 0) && this.getFigurePosY() - nextHop.y == 0) {
            return true;
        }
        else if(abs(this.getFigurePosX() - nextHop.x) == abs(this.getFigurePosY() - nextHop.y) ) {
            return true;
        }
        return false;
    }

    private boolean validMoveRook(Point nextHop)
    {
        if((nextHop.y <= 8 || nextHop.y > 0) && this.getFigurePosX() - nextHop.x == 0) {
            return true;
        }
        else if((nextHop.x <= 8 || nextHop.x > 0) && this.getFigurePosY() - nextHop.y == 0) {
            return true;
        }
        return false;
    }
    private boolean validMoveBishop(Point nextHop)
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
        Point podejrzane[] = new Point[64];
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
        if(getFigurePos().y != nextHop.y && getFigurePos().x == nextHop.x)
        {
            if(nextHop.y < getFigurePos().y) {
                for(int i = nextHop.y; i < getFigurePos().y; i++) {
                    if(validMoveRook(new Point(nextHop.x,i))) podejrzane[index++] = new Point(nextHop.x,i);
                }
            }else{
                for(int i = getFigurePos().y; i < nextHop.y; i++) {
                    if(validMoveRook(new Point(nextHop.x,i))) podejrzane[index++] = new Point(nextHop.x,i);
                }
            }
        }
        else if(getFigurePos().x != nextHop.x && getFigurePos().y == nextHop.y)
        {
            if(nextHop.x < getFigurePos().x) {
                for(int i = nextHop.x; i < getFigurePos().x; i++) {
                    if(validMoveRook(new Point(i,nextHop.y))) podejrzane[index++] = new Point(i,nextHop.y);
                }
            }else {
                for (int i = getFigurePos().x; i < nextHop.x; i++) {
                    if (validMoveRook(new Point(i, nextHop.y))) podejrzane[index++] = new Point(i, nextHop.y);
                }
            }
        }
        else {
            for (int i = mniejsza; i < wieksza; i++) {
                if (nextHop.y < getFigurePos().y) {
                    for (int j = nextHop.y; j < getFigurePos().y; j++) {
                        if (validMoveBishop(new Point(i, j))) {
                            podejrzane[index++] = new Point(i, j);
                        }
                    }
                } else {
                    for (int j = getFigurePos().y; j < nextHop.y; j++) {
                        if (validMoveBishop(new Point(i, j))) {
                            podejrzane[index++] = new Point(i, j);
                        }
                    }
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
