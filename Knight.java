import java.awt.*;

public class Knight extends Figure {
    private static final String WHITE = "images/pieces/wkn.png";
    private static final String BLACK = "images/pieces/bkn.png";

    public Knight(String color, Point pos)
    {
        super(color, pos);
        if(color == "white") setFigureIMG(WHITE);
        else setFigureIMG(BLACK);
        System.out.println(color + "Skoczek");
    }
}