import java.awt.*;

public class Bishop extends Figure {
    private static final String WHITE = "images/pieces/wbi.png";
    private static final String BLACK = "images/pieces/bbi.png";

    public Bishop(String color, Point pos)
    {
        super(color, pos);
        if(color == "white") setFigureIMG(WHITE);
        else setFigureIMG(BLACK);
        System.out.println(color + "Goniec");
    }
}
