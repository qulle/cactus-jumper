package gameobjects;

import game.Jumper;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player extends GameObject {
    private static final long serialVersionUID = 1L;
    private Map<Integer, Boolean> commands = new HashMap<Integer, Boolean>();	
    private int score = 0;

    public Player(int startPosX, int width, int height) {
        super(startPosX, width, height);
        setY(0); // Makes the player fall down to the floor at the start of a new game
    }

    @Override
    public void update() {
        setY(getY() - getJumpStrength());
        setJumpStrength(getJumpStrength() - getWeight()); 
        if(getY() >= Jumper.FLOORHEIGHT) {
            setY(Jumper.FLOORHEIGHT);
        }

        for(Map.Entry<Integer, Boolean> cmd : commands.entrySet()) {
            if(cmd.getValue()) {
                doCommand(cmd.getKey());
            }
        }
    }

    @Override
    public void drawYourself(Graphics g) {		
        g.setColor(Color.decode("#f6b561"));
        g.fillRect(getX(), getY() - getHeight(), getWidth(), getHeight());
        g.setColor(Color.decode("#f47b36"));
        g.drawRect(getX(), getY() - getHeight(), getWidth(), getHeight());
    }

    public void doCommand(int command) {
        switch(command) {
            case KeyEvent.VK_SPACE:
                if(getY() == Jumper.FLOORHEIGHT) {
                    setJumpStrength(14);
                }	
        }
    }

    public void setCommand(int keyCode) {
        commands.put(keyCode, true);
    }

    public void resetCommand(int keyCode) {
        commands.put(keyCode, false);
    }

    public boolean checkCollision(List<Obstacle> obstacles) {
        for(Obstacle o : obstacles) {
            if(getBounds().intersects(o.getBounds())) {
                return true;
            }
        }
        
        return false;
    }

    public void addScore() {
        score++;		
    }

    public int getScore() {
        return score;
    }
}