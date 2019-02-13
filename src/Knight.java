import java.awt.*;

import static java.lang.StrictMath.abs;

public class Knight extends Figure {
    private static final String WHITE = "images/pieces/wkn.png";
    private static final String BLACK = "images/pieces/bkn.png";
    private String type = "knight";

    public Knight(String color, Point pos)
    {
        super(color, pos);
        if(color == "white") setFigureIMG(WHITE);
        else setFigureIMG(BLACK);
        System.out.println(color + "Skoczek");
    }

    public boolean validMove(Point nextHop)
    {
        //System.out.println((this.getFigurePosX() - nextHop.x) + " " ());
        if(abs(this.getFigurePosX() - nextHop.x) == 2) {
            if(abs(this.getFigurePosY() - nextHop.y) == 1) {
                return true;
            }
        }
        else if(abs(this.getFigurePosY() - nextHop.y) == 2) {
            if(abs(this.getFigurePosX() - nextHop.x) == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean validAttack(Point nextHop)
    {
        return validMove(nextHop);
    }
}
