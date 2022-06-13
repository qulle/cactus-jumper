package game;

import gameobjects.Obstacle;
import gameobjects.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
import staticManagers.ScoreManager;
import staticManagers.ColorManager;

public class Game extends JPanel {
    private static final long serialVersionUID = 1L;
    private static int[] delays = { 700, 800, 850, 900, 950, 1000, 1100, 1800 };

    private Jumper jumper;
    private Timer gameLoopTimer;
    private Player player = new Player(50, 20, 20);
    private List<Obstacle> obstacles = new ArrayList<Obstacle>();
    private char[][] map;
    private int mapWidth = 64;
    private int mapHeight = 32;
    private int obstacleInterval = 0;
    private int obstacleDelay = 1000;
    private boolean gameOver = false;

    private int d1  = 2; 
    private int dd1 = 2;
    private int d2  = 4;
    private int dd2 = 4;
    private int d3  = 5;
    private int dd3 = 5;
    private int d4  = 2;
    private int dd4 = 2;

    public Game(Jumper jumper) {
        this.jumper = jumper;
        ScoreManager.loadHighscore();
        initMap();
        setFocusable(true);
        
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                player.resetCommand(e.getKeyCode());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_P) {
                    toggleGame();
                }else if(e.getKeyCode() == KeyEvent.VK_R) {
                    gameLoopTimer.stop();
                    ScoreManager.handleScore(player.getScore());
                    Game.this.jumper.newGame();
                }else {
                    player.setCommand(e.getKeyCode());
                }
            }
        });

        gameLoopTimer = new Timer(18, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                // Update player
                player.update();

                if(player.checkCollision(obstacles)) {
                    gameLoopTimer.stop();
                    gameOver = true;
                }

                // Update obstacles
                List<Obstacle> copyObstacles = new ArrayList<Obstacle>(obstacles);
                for(Obstacle o : copyObstacles) {
                    o.update();

                    if(o.checkCollision(player)) {
                        gameLoopTimer.stop();
                        gameOver = true;
                    }

                    if(o.outOfBounds()) {
                        obstacles.remove(o);
                        player.addScore();
                    }
                }

                // Make new obstacles
                obstacleInterval += 20;
                if(obstacleInterval >= obstacleDelay) {
                    obstacles.add(new Obstacle());
                    obstacleInterval = 0;
                    obstacleDelay = delays[new Random().nextInt(delays.length)];
                }

                repaint();
                Toolkit.getDefaultToolkit().sync();
            }
        });
          
        gameLoopTimer.start();
    }

    private void toggleGame() {
        if(gameLoopTimer.isRunning()) {
            gameLoopTimer.stop();
        }else {
            if(!gameOver) { 
                gameLoopTimer.start();
            }
        }
    }

    public void initMap() {
        map = new char[mapHeight][mapWidth];

         map[0] = "----------------------------------------------------------------".toCharArray();
         map[1] = "----------------------------------------%!@@@-------------------".toCharArray();
         map[2] = "--------------------------------------%@@!!!@@------------------".toCharArray();
         map[3] = "------------------------------------%%%@@!!!%%@@----------------".toCharArray();
         map[4] = "-------------------!@-------------------------------------------".toCharArray();
         map[5] = "------------------%%@@---------------------------!!-------------".toCharArray();
         map[6] = "-----------------%!!@@@@-----------------------!!@@!------------".toCharArray();
         map[7] = "--------------@@!!%%@@@!!@@------------------%%%@!!!@@@!--------".toCharArray();
         map[8] = "-------------------------------------------@@%%!!@@!%%@@@-------".toCharArray();
         map[9] = "-----------------------------------------%%!!@@@@@@!!@@@@@------".toCharArray();
        map[10] = "----------!@----------------------------------------------------".toCharArray();
        map[11] = "-------%%!!!!@--------------------------------------------------".toCharArray();
        map[12] = "-----%%%@@@@!!@@@-----------------------------------------------".toCharArray();
        map[13] = "--@@@%%@@!!@@@@@@@@---------------------------------------------".toCharArray();
        map[14] = "----------------------------------------------------------------".toCharArray();
        map[15] = "----------------------------------------------------------------".toCharArray();
        map[16] = "----------------------------------------------------------------".toCharArray();
        map[17] = "----------------------------------------------------------------".toCharArray();
        map[18] = "----------------------------------------------------------------".toCharArray();
        map[19] = "----------------------------------------------------------------".toCharArray();
        map[20] = "----------------------------------------------------------------".toCharArray();
        map[21] = "----------------------------------------------------------------".toCharArray();
        map[22] = "----------------------------------------------------------------".toCharArray();
        map[23] = "----------------------------------------------------------------".toCharArray();
        map[24] = "----------------------------------------------------------------".toCharArray();
        map[25] = "----------------------------------------------------------------".toCharArray();
        map[26] = "5412234532312123356713523635245677532234566321134556556677334335".toCharArray();
        map[27] = "==223??1234+23==2??45+==?22323?++?45==233?==3+3+23=342573=+66=++".toCharArray();
        map[28] = "??=?3345?=+==+=???===++??+?676+=+++==+++=?????=??367++=+??=???=?".toCharArray();
        map[29] = "??=?++===??=?=??=?++?=?=?=+=+++=?+=+=+??==?=?=???==?=?=?=+??=?=+".toCharArray();
        map[30] = "?+++==+=+?===++=+=?=+?=?=+=?=+==?+=+=?==?==?++=?=+=?=?=?++=+=?==".toCharArray();
        map[31] = "=??+?=?=?=+??==?=?==?=?=???=?=+?=??=?=?=?=?=?++=++=+??+?=+?=?=?+".toCharArray();
    }

    private int animateRows(int sRow, int eRow, int delay, int defaultDelay) {
        if(delay == 0) {
            for(int y = sRow; y <= eRow; y++) {
                char c = map[y][0];
                for(int x = 0; x < mapWidth - 1; x++) {
                    map[y][x] = map[y][x + 1];
                }
                map[y][mapWidth - 1] = c; 
            }
            delay = defaultDelay + 1;
        }

        return --delay;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int xCord = 0;
        int yCord = 0;

        // Animate clouds
        d1 = animateRows(1,  3,  d1, dd1);
        d2 = animateRows(4,  9,  d2, dd2);
        d3 = animateRows(10, 13, d3, dd3);
        d4 = animateRows(26, 31, d4, dd4);

        // Render
        for(int y = 0; y < mapHeight; ++y) {
            for(int x = 0; x < mapWidth; ++x) {
                g.setColor(ColorManager.getColor(map[y][x]));
                g.fillRect(xCord, yCord, 15, 15);
                xCord += 15;
            }
            yCord += 15;
            xCord = 0;
        }

        g.setColor(Color.decode("#232323"));
        g.drawString("Score : " + Integer.toString(player.getScore()), 5, 15);
        g.drawString("Highscore : " + Integer.toString(ScoreManager.getHighscore()), 5, 35);
        g.drawString("Space - jump", 5, 55);
        g.drawString("R - restart", 5, 75);
        g.drawString("P - toggle paus", 5, 95);
          
        for(Obstacle o : obstacles) {
            o.drawYourself(g);
        }

        player.drawYourself(g);

        if(gameOver) {
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.setColor(Color.decode("#ffc705"));
            g.drawString("Game Over", 420, 250);
        }
    }
}