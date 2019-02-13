import java.awt.*;

public class Rook extends Figure
{

    private static final String WHITE = "images/pieces/wro.png";
    private static final String BLACK = "images/pieces/bro.png";

    public Rook(String color, Point pos)
    {
        super(color, pos);
        if(color == "white") setFigureIMG(WHITE);
        else setFigureIMG(BLACK);
        System.out.println(color + " rook");
    }
}
