/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nova;

import java.awt.Color;

/**
 *
 * @author 802790
 */
public class Bullet extends Character {
    public Bullet(){
        super();
        
        
        }
    public Bullet(int x, int y,Color color, int size, String name ){
            super(x, y, color, size, name);
    }
    public void update(){
        super.update();
    }
}

