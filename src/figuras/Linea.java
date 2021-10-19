/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

/**
 *
 * @author Misael Caceres Villar 
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Linea extends Figura{
    Point puntoInicial;
    Point puntoFinal;

    public Linea(Point puntoInicial, Point puntoFinal) {
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
    }

    public Linea(Point puntoInicial) {
        this(puntoInicial, puntoInicial);
    }

    public void actualizar( Point puntoFinal ) {
        this.puntoFinal = puntoFinal;
    }


    public void dibujar(Graphics g) {
        if(puntoInicial != null && puntoFinal != null) {
            g.setColor(Color.black);
            //g.drawLine( puntoInicial.x, puntoInicial.y, puntoFinal.x, puntoFinal.y );
           g.drawLine( puntoInicial.x, puntoInicial.y, puntoFinal.x, puntoFinal.y );
           g.drawRect(puntoInicial.x, puntoInicial.y, puntoFinal.x-puntoInicial.x, puntoFinal.y-puntoInicial.y);
           g.drawOval(puntoInicial.x, puntoInicial.y, puntoFinal.x-puntoInicial.x, puntoFinal.y-puntoInicial.y);
        }
    }
}
