import java.awt.*;

public class Pawn extends Figure
{
    private static final String WHITE = "images/pieces/wpa.png";
    private static final String BLACK = "images/pieces/bpa.png";

    public Pawn(String color, Point pos)
    {
        super(color, pos);
        if(color == "white") setFigureIMG(WHITE);
            else setFigureIMG(BLACK);
        System.out.println(color + " pawn");
    }
}
