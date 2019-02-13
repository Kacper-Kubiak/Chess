import java.awt.*;

public class Rook extends Figure
{
    private static final String WHITE = "images/pieces/wro.png";
    private static final String BLACK = "images/pieces/bro.png";
    private String type = "rook";

    public Rook(String color, Point pos)
    {
        super(color, pos);
        if(color == "white") setFigureIMG(WHITE);
        else setFigureIMG(BLACK);
        System.out.println(color + " rook");
    }

    public boolean validMove(Point nextHop)
    {
        if((nextHop.y <= 8 || nextHop.y > 0) && this.getFigurePosX() - nextHop.x == 0) {
            return true;
        }
        else if((nextHop.x <= 8 || nextHop.x > 0) && this.getFigurePosY() - nextHop.y == 0) {
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
        if(getFigurePos().y != nextHop.y)
        {
            if(nextHop.y < getFigurePos().y) {
                for(int i = nextHop.y; i < getFigurePos().y; i++) {
                    if(validMove(new Point(nextHop.x,i))) podejrzane[index++] = new Point(nextHop.x,i);
                }
            }else{
                for(int i = getFigurePos().y; i < nextHop.y; i++) {
                    if(validMove(new Point(nextHop.x,i))) podejrzane[index++] = new Point(nextHop.x,i);
                }
            }
        }
        else if(getFigurePos().x != nextHop.x)
        {
            if(nextHop.x < getFigurePos().x) {
                for(int i = nextHop.x; i < getFigurePos().x; i++) {
                    if(validMove(new Point(i,nextHop.y))) podejrzane[index++] = new Point(i,nextHop.y);
                }
            }else {
                for (int i = getFigurePos().x; i < nextHop.x; i++) {
                    if (validMove(new Point(i, nextHop.y))) podejrzane[index++] = new Point(i, nextHop.y);
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
