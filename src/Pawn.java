import java.awt.*;

public class Pawn extends Figure
{
    private static final String WHITE = "images/pieces/wpa.png";
    private static final String BLACK = "images/pieces/bpa.png";
    private String color;
    private boolean firstMove = true;
    private String type = "pawn";

    public Pawn(String color, Point pos)
    {
        super(color, pos);
        if(color == "white") setFigureIMG(WHITE);
            else setFigureIMG(BLACK);
        System.out.println(color + " pawn");
        this.color = color;
    }

    public boolean validMove(Point nextHop)
    {
        int maxHop = 1;
        if(firstMove) maxHop = 2;
        if(color == "white" && this.getFigurePosY() - nextHop.y <= maxHop &&
            this.getFigurePosY() - nextHop.y > 0 &&
            this.getFigurePosX() - nextHop.x == 0)
        {
            firstMove = false;
            return true;
        }
        else if(color == "black" && this.getFigurePosY() - nextHop.y >= -maxHop &&
            this.getFigurePosY() - nextHop.y < 0 &&
            this.getFigurePosX() - nextHop.x == 0)
        {
            firstMove = false;
            return true;
        }
        return false;
    }

    public boolean validAttack(Point nextHop)
    {
        if(this.getFigurePosX() - nextHop.x == 1 || this.getFigurePosX() - nextHop.x == -1)
        {
            if(color == "white" && this.getFigurePosY() - nextHop.y == 1) {
                  return true;
            }
            else if(color == "black" && this.getFigurePosY() - nextHop.y == -1) {
                return true;
            }
        }
        return false;
    }
}
