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
public class Rombo extends Rectangulo {

    Point puntoInicial;
    Point puntoFinal;

    public Rombo(int x, int y, int anchura, int altura) {
        super(x, y, anchura, altura);
    }

    public Rombo(Point puntoInicial) {
        super(puntoInicial);
    }

    public void dibujar(Graphics g) {
        int x = this.anchura < 0 ? this.x + this.anchura : this.x;
        int y = this.altura < 0 ? this.y + this.altura : this.y;
        int anchura = Math.abs(this.anchura);
        int altura = Math.abs(this.altura);

        g.setColor(Color.red);
        g.fillOval(x, y, anchura, altura);

        g.setColor(Color.black);
        g.drawOval(x, y, anchura, altura);
    }
}
