import java.awt.*;

public class Player
{
    private boolean AI;
    private String color;
    private Figure selected = null;

    private Figure figure[] = new Figure[16];//16 figure per user

    public Player(boolean AI,  String color) {
        this.AI = AI;
        this.color = color;
        //Wieża
        //figure[0] = new Rook();
    }

    public boolean isPlayer(){
        //Jeżeli gracz to nie bot
        return !AI;
    }

    public String getPlayerColor() {
        return color;
    }

    public void loadFigure()
    {
        /*
        King // Król
        Queen // Hetman
        Rook // Wieża
        Bishop //Goniec
        Knight	// Skoczek
        Pawn // Pionek
        */
        int startpos = 8;
        if(color == "black") startpos = 1;

        figure[0] = new Rook(color,  new Point(1, startpos));
        figure[1] = new Knight(color, new Point(2, startpos));
        figure[2] = new Bishop(color, new Point(3, startpos));
        figure[3] = new Queen(color, new Point(4, startpos));
        figure[4] = new King(color, new Point(5, startpos));
        figure[5] = new Bishop(color, new Point(6, startpos));
        figure[6] = new Knight(color, new Point(7, startpos));
        figure[7] = new Rook(color, new Point(8, startpos));
        for(int i=8; i<16; i++) {
            figure[i] = new Pawn(color, new Point(i-7, color=="black"?2:7));
        }
    }

    public Figure[] getPlayerFigures()
    {
        return figure;
    }

    public boolean isPlayerFigures(Point position)
    {
        for(int i=0; i<16; i++)
        {
            if(!figure[i].getActive()) continue;
            if(figure[i].getFigurePosX() == position.x && figure[i].getFigurePosY() == position.y) return true;
        }
        return false;
    }

    public Figure getPlayerSelected()
    {
        for(int i=0; i<16; i++)
        {
            if(figure[i].getSelected() == true) return figure[i];
        }
        return null;
    }

    public void setPlayerSelected(Figure selected)
    {
        for(int i=0; i<16; i++)
        {
            if(figure[i] == selected) selected.setSelected(!selected.getSelected());
            else figure[i].setSelected(false);
        }
    }

    public void clearPlayerSelected()
    {
        for(int i=0; i<16; i++) figure[i].setSelected(false);
    }

    public Figure getFigureByPoint(Point point)
    {
        for(int i=0; i<16; i++)
        {
            if(!figure[i].getActive()) continue;
            if(figure[i].getFigurePosX() == point.x && figure[i].getFigurePosY() == point.y) return figure[i];
        }
        return null;
    }

    public boolean move(Figure moveFigure, Point movePoint)
    {
        moveFigure.setFigurePos(movePoint);
        return false;
    }
}
