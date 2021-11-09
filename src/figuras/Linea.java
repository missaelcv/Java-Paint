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
