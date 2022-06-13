package gameobjects;

import game.Jumper;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import staticManagers.SpriteManager;

public class Obstacle extends GameObject {
    private static final long serialVersionUID = 1L;
    private static int[] heights = { 36, 55 };
    private BufferedImage sprite;

    public Obstacle() {
        super(Jumper.WIDTH + 30, 30, heights[new Random().nextInt(heights.length)]);

        if(getHeight() == 36) {
            sprite = SpriteManager.getImage("3");
        }else {
            sprite = SpriteManager.getImage(Integer.toString(new Random().nextInt(2) + 1));
        }
    }

    @Override
    public void update() {
        setX(getX() - getSpeed());
    }

    @Override
    public void drawYourself(Graphics g) {
        g.drawImage(sprite, getX(), getY() - getHeight(), this);
    }

    public boolean outOfBounds() {
        return getX() + getWidth() <= 0;
    }

    public boolean checkCollision(GameObject o) {
        return getBounds().intersects(o.getBounds());
    }
}