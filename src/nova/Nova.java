/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nova;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author 802790
 */
public class Nova extends Space {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Sets up multiple JPanels
        JFrame level = new JFrame();
        
        level.setSize(1200, 960);
        Space c = new Space();
        level.add(c);
        level.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        level.setVisible(true);
        level.setLocationRelativeTo(null);
        level.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
        c.keyPressed (e);
        
        
    }
        	            @Override
            public void keyReleased(KeyEvent e) {
                c.keyReleased(e);
            }
});
        
    }
    
}
