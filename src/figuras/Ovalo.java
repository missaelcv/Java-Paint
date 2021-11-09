/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author josearielpereyra
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
