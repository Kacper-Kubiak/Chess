import java.awt.*;

public class Judge
{
    private Game game;
    private Player player1;
    private Player player2;
    private Figure figures[] = new Figure[32];

    private Figure king1;
    private Figure king2;

    public Judge(Game game, Player player1, Player player2)
    {
        this.game = game;
        this.player1 = player1;
        this.player2 = player2;
        for(int i=0; i<16; i++)
        {
            figures[i] = player1.getPlayerFigures()[i];
            figures[i+16] = player2.getPlayerFigures()[i];
        }

        king1 = player1.getPlayerFigure(4);
        king2 = player2.getPlayerFigure(4);

    }

    public boolean validMyMove(Figure figure, Point nextHop)
    {
        if(!figure.validMove(nextHop)) return false;
        if(figure.getType()=="bishop" || figure.getType()=="queen" || figure.getType()=="rook") {
            if(figure.haveColision(figures, nextHop)) {
                return false;
            }
        }
        return true;
    }

    public boolean validMyAttack(Figure figure, Point nextHop)
    {
        if(!figure.validAttack(nextHop)) return false;
        if(figure.getType()=="bishop" || figure.getType()=="queen" || figure.getType()=="rook") {
            if(figure.haveColision(figures, nextHop)) {
                return false;
            }
        }
        return true;
    }

    public void canCapture(Player attacker, Player opponent)
    {
        opponent.setPlayerCapute(false);
        for(int i=0; i<attacker.getPlayerFigures().length; i++)
        {
            if(validMyAttack(attacker.getPlayerFigure(i), opponent.getPlayerFigure(4).getFigurePos()))
            {
                System.out.println(attacker.getPlayerColor() + " SZACH!!! " + opponent.getPlayerColor());
                opponent.setPlayerCapute(true);
            }
        }
    }

}
