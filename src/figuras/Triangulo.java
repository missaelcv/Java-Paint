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
public class Triangulo extends Rectangulo {

    Point puntoInicial;
    Point puntoFinal;

    public Triangulo(Color color, Point puntoInicial) {
        super(color, puntoInicial);
    }

    public void dibujar(Graphics g) {
        int x = this.anchura < 0 ? this.x + this.anchura : this.x;
        int y = this.altura < 0 ? this.y + this.altura : this.y;
        int anchura = Math.abs(this.anchura);
        int altura = Math.abs(this.altura);
        
        Point punto1 = new Point(x, y + altura); 
        Point punto2 = new Point(x + anchura/2, y);
        Point punto3 = new Point(x + anchura, y + altura);
        
        g.setColor(Color.BLUE);
        g.fillPolygon( new int []{ punto1.x, punto2.x, punto3.x}, new int []{ punto1.y, punto2.y, punto3.y}, 3 );
        g.setColor(Color.black);
        g.drawPolygon( new int []{ punto1.x, punto2.x, punto3.x}, new int []{ punto1.y, punto2.y, punto3.y}, 3 );
        
         punto1 = new Point(x, y + altura / 2); 
         punto2 = new Point(x + anchura/2, y);
         punto3 = new Point(x + anchura, y + altura / 2);
         Point punto4 = new Point(x + anchura / 2, y + altura);   
    }
}
