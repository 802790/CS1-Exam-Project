/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nova;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author 802790
 */
public class Space extends JPanel{
    ArrayList<Enemy> enemyList = new ArrayList();
    int[] x = new int[100];
    int[] y = new int[100];
    int color;
    int size;
    boolean touchEnemy = false;
    int spawnRate = 5000;
    final int marginX;
    final int marginY;
    public Player player;
    public Enemy[] enemy = new Enemy[50];
    private final Timer timer;
    //private Enemy enemy2;
    //private Enemy enemy3;
    
    public Space() {
        super();
        marginX = 15;
        marginY = 15;
        player = new Player(600, 480, Color.BLUE, 20, "Player");
        for (int i = 0; i < 50; i++){
        enemy[i] =  new Enemy((int) (Math.random() * 1200), 100000, Color.RED, 20, "Enemy");
        
        }
        //enemy2 = new Enemy(600, 300, Color.RED, 20, "Enemy2");
        //enemy3 = new Enemy(1000, 300, Color.RED, 20, "Enemy3");
        for(int i = 0; i < 100; i++){
        x[i] = (int) (Math.random() * 1100 + 25);
            y[i] = (int) (Math.random() * 860 + 25);
}
        timer = new Timer(); 
        timer.scheduleAtFixedRate(new ScheduleTask(), 25, 25);
        Timer spawnTimer = new Timer();
        spawnTimer.scheduleAtFixedRate(new ScheduleSpawn(), 5000, spawnRate);
   }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        
        g.setColor(Color.CYAN);
        drawStars(g);
        
        player.draw(g);
        for (int i = 0; i < 50; i++){
        enemy[i].draw(g);
        }
        //enemy2.draw(g);
        //enemy3.draw(g);
        
        
        g.dispose();
        
        
    }

    public void drawStars(Graphics g) {
        for (int i = 0; i < 100; i++) {
            
                g.setColor(Color.CYAN);
            size = (int) (Math.random() * 5 + 3);
            
            g.fillOval(x[i], y[i], WIDTH, HEIGHT);
        }
    }
    public void enemyDraw(final Graphics g){
                    int i = 0;
                    enemy[i].draw(g);
                    
                }
       
    private void heroVsEnemy(int i) {
        
        if (player.x + player.size / 2 >= enemy[i].x && player.x + player.size / 2 <= enemy[i].x +20 && player.y + player.size /2 >= enemy[i].y && player.y + player.size / 2  <= enemy[i].y +20 && enemy[i].size == 20) {
            player.kill();
        
        }
        
    }
    
    /**
     * Makes the hero and enemy bounce off walls
     */    
    private void wallCollissions(Character c) {
        
                
        c.getX();
        c.getY();
        
        if (c.getX() <= player.size / 2) {
            c.reverseX();
        }
        if (c.getX() >= this.getWidth() -20) {
            c.reverseX();
        }
        
        if (c.getY() <= 0) {
            c.reverseY();
        }
        if (c.getY() >= this.getHeight() - 20) {
            c.reverseY();
        }      
        
    }

    void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
            player.setDX(3);
        }

            if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
            player.setDX(-3);
        }
    
            if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
            player.setDY(3);
        }

            if (e.getKeyCode() == KeyEvent.VK_UP ) {
            player.setDY(-3);
        }
    }

    void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            player.setDX(0);
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            player.setDX(0);
        if (e.getKeyCode() == KeyEvent.VK_UP)
            player.setDY(0);
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            player.setDY(0);
    }
    

    
    
        
        public class ScheduleTask extends TimerTask  {
        	    
        
        @Override
        public void run() {
        player.update();
        for (int i = 0; i < enemy.length; i++){
            if(enemy[i].getX() <= player.getX()){
            enemy[i].setDX(2);
        }else{
            enemy[i].setDX(-2);
        }
        if(enemy[i].getY() <= player.getY()){
            enemy[i].setDY(2);
        }else{
            enemy[i].setDY(-2);
            
        }
        enemy[i].setX(enemy[i].getX() + (int) (Math.random() * 20 - 10));
        enemy[i].update();
        heroVsEnemy(i);
        }
        repaint();
        }
            
        }
        
        
    private class ScheduleSpawn extends TimerTask {

            int i = 0;
            public void run() {
                wallCollissions(player);
        wallCollissions(enemy[i]);
         
        enemy[i].setY(100);
        enemy[i].setX((int) (Math.random() * 1150));
        spawnRate -= 100;
        i++;
        
        
        }
    }
}
            
        
    
        
    



        
    

