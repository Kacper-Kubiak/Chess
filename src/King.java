import java.awt.*;

public class King extends Figure {

    private static final String WHITE = "images/pieces/wki.png";
    private static final String BLACK = "images/pieces/bki.png";

    public King(String color, Point pos)
    {
        super(color, pos);
        if(color == "white") setFigureIMG(WHITE);
        else setFigureIMG(BLACK);
        System.out.println(color + "Król");
    }
}
