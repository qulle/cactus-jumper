package gameobjects;

import game.Jumper;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;

public abstract class GameObject extends JComponent{
    private static final long serialVersionUID = 1L;

    public abstract void drawYourself(Graphics g);
    public abstract void update();

    private int x;
    private int y = Jumper.FLOORHEIGHT;
    private int speed = 5;
    private int weight = 1;
    private int jumpStrength = 0;
    private int width;
    private int height;
    private Rectangle bounds;

    public Rectangle getBounds() {
        return bounds;
    }

    public GameObject(int x, int width, int height) {
        this.x = x;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(x, y - height, width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }

    public int getJumpStrength() {
        return jumpStrength;
    }
    
    public void setJumpStrength(int jumpStrength) {
        this.jumpStrength = jumpStrength;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
        bounds.setLocation(x, y - height);
    }

    public void setY(int y) {
        this.y = y;
        bounds.setLocation(x, y - height);
    }
}