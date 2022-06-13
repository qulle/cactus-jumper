package game;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JFrame;
import staticManagers.SpriteManager;

public class Jumper extends JFrame{
    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 960;
    public static final int HEIGHT = 480;
    public static final int FLOORHEIGHT = HEIGHT - 90;
    private Game game;
    
    public static void main(String[] args) {
        new Jumper().setVisible(true);
    }

    public Jumper() {
        setTitle("Jumper");
        getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
        pack();
        setResizable(false);
        Jumper.centerWindow(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SpriteManager.loadImages();
        newGame();
    }

    public void newGame() {
        game = new Game(this);
        getContentPane().add(game);
        revalidate();
        game.requestFocusInWindow();
        repaint();
    }

    public static void centerWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
}