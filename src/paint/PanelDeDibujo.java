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

    /**
     *
     * @param g
     */
    
    //@override
    protected void paintComponet(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.red);
        
        int distancia = 20;
        int total =0;
        for (int y = distancia; y < getHeight() && total < 27; y += distancia) {
            total ++;
        g.drawString(" "+  total, 0, y);
        g.drawLine(10, y, getWidth() -10 ,y);}
        
        
        g.setColor(Color.red);
        g.drawLine(distancia * 2,0, distancia * 2, getHeight());
    }
    
}
