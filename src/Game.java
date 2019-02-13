import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game implements MouseListener
{
    private JFrame frame;
    private Board board;
    private Player player1;
    private Player player2;
    private Judge judge;

    private String turn = "white";

    public void mouseClicked(MouseEvent event) {}
    public void mouseEntered(MouseEvent event) {}
    public void mouseExited(MouseEvent event) {}
    public void mouseReleased(MouseEvent event) {}

    public void mousePressed(MouseEvent event) {
        //Ruch gracza 1
        if(turn == player1.getPlayerColor()) {
            boardClick(event.getPoint(), player1, player2);
        }
        // Ruch gracza 2
        else if(turn == player2.getPlayerColor()) {
            boardClick(event.getPoint(), player2, player1);
        }
        //System.out.println("Press " + event.getPoint());
        frame.repaint();
    }

    private void boardClick(Point position, Player player, Player opponent) {
        if (player.isPlayerFigures(board.getPosByPoint(position))) {
            if(player.getPlayerSelected() != null)
            {
                if(player.getPlayerSelected() == player.getFigureByPoint(board.getPosByPoint(position))) {
                    player.clearPlayerSelected();
                }
            }
            else if(player.getFigureByPoint(board.getPosByPoint(position)).getActive()) {
                player.setPlayerSelected(player.getFigureByPoint(board.getPosByPoint(position)));
            }
        }
        else if(player.getPlayerSelected() != null)
        {
            //if(player.getPlayerSelected().validMove(board.getPosByPoint(position)) &&
            if(judge.validMyMove(player.getPlayerSelected(), board.getPosByPoint(position)) &&
                    !opponent.isPlayerFigures(board.getPosByPoint(position)))
            {
                player.move(player.getPlayerSelected(), board.getPosByPoint(position));
                player.clearPlayerSelected();
                turn = turn == "white" ? "black" : "white";
            }
            else if(judge.validMyAttack(player.getPlayerSelected(), board.getPosByPoint(position)) &&
                    //player.getPlayerSelected().validAttack(board.getPosByPoint(position)) &&
                    opponent.isPlayerFigures(board.getPosByPoint(position)))
            {
                player.move(player.getPlayerSelected(), board.getPosByPoint(position));
                player.clearPlayerSelected();
                opponent.getFigureByPoint(board.getPosByPoint(position)).setActive(false);
                turn = turn == "white" ? "black" : "white";
            }
        }
    }


    public Game(JFrame frame, Board board, Player player1, Player player2)
    {
        this.frame = frame;
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        judge = new Judge(this, player1, player2);
    }
}
