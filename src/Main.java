import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main
{
    protected void createAndShowGUI()
    {
        //Ustawienie parametrów okna
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Wczytywanie planszy
        Board board = new Board();

        //Wczytywanie pionków

        //Tworzenie dwóch graczy
        Player player1 = new Player(false, "black");
        Player player2 = new Player(false, "white");

        //Ładowanie pionków gracza
        player1.loadFigure();
        player2.loadFigure();

        //Zmienne do rysowania GUI
        JPainter images = new JPainter();
        JPanel panel = new JPanel();

        //Rysowanie GUI - z podanej ścieżki obrazka
        images.setBoard(board.getBoardIMG());

        //Rysowanie pionków gracza 1
        for(int i=0; i<16; i++) {
            images.setFigure(player1.getPlayerFigures()[i]);
        }

        //Rysowanie pionków gracza 2
        for(int i=0; i<16; i++) {
            images.setFigure(player2.getPlayerFigures()[i]);
        }

        //Dodanie do panelu obrazków
        panel.add(images);
        //Dodanie do okna aplikacji panelu z grą
        frame.add(panel);
        //Wyświetlenie okna aplikacji
        frame.setVisible(true);

        Game game = new Game(frame, board, player1, player2);
        frame.addMouseListener(game);
        //Game game = new Game(board, player1, player2);
    }

    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                Main app = new Main();
                app.createAndShowGUI();
            }
        });
    }
}