/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Misael Caceres
 */
public class PanelDeDibujo extends JPanel {
    
    public PanelDeDibujo () {
        setBackground  (Color.WHITE);
           
    }
    
    protected void paintComponet(Graphics g){
         super.paintComponent(g);
         
         g.drawLine(10, 10, 300, 350);
    }
    
}
