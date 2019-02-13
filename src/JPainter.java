import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class JPainter extends JComponent
{
    private BufferedImage boardImage;
    private Figure figure[] = new Figure[32];
    private BufferedImage img[] = new BufferedImage[32];
    private int lastIndex = 0;
    private BufferedImage selected;

    public void setBoard(String images)
    {
        try {
            boardImage = ImageIO.read(new File(images));
            selected = ImageIO.read(new File("images/selected.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFigure(Figure figure)
    {
        try {
            this.figure[lastIndex] = figure;
            img[lastIndex] = ImageIO.read(new File(figure.getFigureIMG()));
            lastIndex++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        g2d.drawImage(boardImage, null, 0, 0);

        for(int i=0; i<32; i++) {
            if(figure[i].getActive()) {
                g2d.drawImage(img[i], null, 58*(figure[i].getFigurePosX())+11, 58*(figure[i].getFigurePosY())+11);
            }
            if(figure[i].getSelected()) {
                g2d.drawImage(selected, null, 58*(figure[i].getFigurePosX())+11, 58*(figure[i].getFigurePosY())+11);
            }
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(boardImage.getWidth(), boardImage.getHeight());
    }
}