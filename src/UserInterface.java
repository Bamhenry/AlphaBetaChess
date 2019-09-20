import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserInterface extends JPanel implements MouseListener, MouseMotionListener {
    static int x=0, y=0;
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.LIGHT_GRAY);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
       
        Image chessPiecesImage;
        chessPiecesImage=new ImageIcon("ChessPieces.png").getImage();
        g.drawImage(chessPiecesImage, x, y, x+164, y+164, 0, 0, 164, 164, this);
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        x=e.getX();
        y=e.getY();
        repaint();}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
