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
public class Trapezoide extends Rectangulo{
    
    public Trapezoide(Color color, Point puntoInicial) {
        super(color, puntoInicial);
    }
   public void dibujar(Graphics g) {
        int x = this.anchura < 0 ? this.x + this.anchura : this.x;
        int y = this.altura < 0 ? this.y + this.altura : this.y;
        int anchura = Math.abs(this.anchura);
        int altura = Math.abs(this.altura);
         
       Point punto4 = new Point( (int)(x + anchura * 0.1), y+ altura);  
       Point punto3 = new Point(x + anchura, y + altura / 2);
       Point punto2 = new Point(x + anchura/2, y);
       Point punto1 = new Point(x, y + altura / 2); 
       
        g.setColor(Color.BLUE);
        g.drawPolygon( new int []{ punto1.x, punto2.x, punto3.x, punto4.x},
                       new int []{ punto1.y, punto2.y, punto3.y, punto4.y}, 4 );
    }
}
