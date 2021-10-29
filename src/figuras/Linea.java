/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

/**
 *
 * @author Misael 
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Linea extends Figura{
    Point puntoInicial;
    Point puntoFinal;

    public Linea(Color color, Point puntoInicial, Point puntoFinal) {
        super(color);
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
    }

    public Linea(Color color, Point puntoInicial) {
        this(color, puntoInicial, puntoInicial);
    }

    public void actualizar( Point puntoFinal ) {
        this.puntoFinal = puntoFinal;
    }

    public void dibujar(Graphics g) {
        if(puntoInicial != null && puntoFinal != null) {
            g.setColor( getColorDePrimerPlano() );
            g.drawLine( puntoInicial.x, puntoInicial.y, puntoFinal.x, puntoFinal.y );
        }
    }
}
