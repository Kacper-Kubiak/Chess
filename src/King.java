import java.awt.*;

import static java.lang.StrictMath.abs;

public class King extends Figure {

    private static final String WHITE = "images/pieces/wki.png";
    private static final String BLACK = "images/pieces/bki.png";
    private String type = "king";

    public King(String color, Point pos)
    {
        super(color, pos);
        if(color == "white") setFigureIMG(WHITE);
        else setFigureIMG(BLACK);
        System.out.println(color + "Król");
    }

    public boolean validMove(Point nextHop)
    {
        if(abs(this.getFigurePosX() - nextHop.x) <= 1 && abs(this.getFigurePosY() - nextHop.y) <= 1)
        {
            return true;
        }
        return false;
    }

    public boolean validAttack(Point nextHop)
    {
        return validMove(nextHop);
    }
}
