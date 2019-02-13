import java.awt.*;

public class Queen extends Figure {
    private static final String WHITE = "images/pieces/wqu.png";
    private static final String BLACK = "images/pieces/bqu.png";

    public Queen(String color, Point pos)
    {
        super(color, pos);
        if(color == "white") setFigureIMG(WHITE);
        else setFigureIMG(BLACK);
        System.out.println(color + "Hetman");
    }
}
