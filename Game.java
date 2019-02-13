import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Game implements MouseListener
{
    private JFrame frame;
    private Board board;
    private Player player1;
    private Player player2;
    public void mouseClicked(MouseEvent event) {}
    public void mouseEntered(MouseEvent event) {}
    public void mouseExited(MouseEvent event) {}
    public void mouseReleased(MouseEvent event) {}

    public void mousePressed(MouseEvent event) {
        if(player1.isPlayerFigures(board.getPosByPoint(event.getPoint()))) System.out.println("Tak");
            else System.out.println("Nie");
        //player1.getPlayerFigures()[0].setFigurePosX(5);
        //player1.getPlayerFigures()[0].setFigurePosY(5);
        //System.out.println("Press " + event.getPoint());
        frame.repaint();
    }

    public Game(JFrame frame, Board board, Player player1, Player player2)
    {
        this.frame = frame;
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }
}
