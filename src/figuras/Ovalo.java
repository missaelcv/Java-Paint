/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Misael Caceres
 */
public class Ovalo extends Rectangulo{
   
    public Ovalo( Color color, Point puntoInicial ) {
        super(color, puntoInicial);
    }

    public void dibujar(Graphics g) {
        g.setColor( getColorDePrimerPlano() );
        
        int x = (this.anchura < 0) ? this.x + anchura : this.x;
        int y = (this.altura < 0) ? this.y + altura : this.y;
        
        g.drawOval( x, y, Math.abs( anchura ), Math.abs( altura ) );
    }
}
