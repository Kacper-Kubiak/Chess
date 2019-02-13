import javax.swing.text.Position;
import java.awt.*;

public class Figure
{
    private String color;
    private String figureIMG;
    private int x;
    private int y;
    private boolean selected = false;
    private boolean active = true;

    public Figure(String Color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public Figure(String Color, Point pos) {
        this.color = color;
        this.x = pos.x;
        this.y = pos.y;
    }

    public String getFigureColor() {
        return color;
    }

    public void setFigureIMG(String path) {
        figureIMG = path;
    }

    public String getFigureIMG()
    {
        return figureIMG;
    }

    public int getFigurePosX(){
        return x;
    }

    public int getFigurePosY(){
        return y;
    }

    public Point getFigurePos() {
        return new Point(x, y);
    }

    public void setFigurePos(Point pos) {
        x = pos.x;
        y = pos.y;
    }
    public void setFigurePosX(int x){
        this.x = x;
    }
    public void setFigurePosY(int y){
        this.y = y;
    }
    public boolean getSelected()
    {
        return selected;
    }
    public void setSelected(boolean status)
    {
        selected = status;
    }
    public boolean getActive()
    {
        return active;
    }
    public void setActive(boolean status)
    {
        active = status;
    }
}
