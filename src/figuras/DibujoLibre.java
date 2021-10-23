/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Misael Caceres
 */
public class DibujoLibre extends Figura {

    ArrayList<Point> puntos;

    public DibujoLibre(Point puntoInicial) {
        puntos = new ArrayList<>();
        actualizar(puntoInicial);
    }

    @Override
    public void actualizar(Point puntoFinal) {
        puntos.add(puntoFinal);
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.black);
        if (puntos.size() == 1) {
            g.drawLine(puntos.get(0).x, puntos.get(0).y, puntos.get(0).x, puntos.get(0).y);
        }

        for (int i = 1; i < puntos.size(); i++) {
            g.drawLine(puntos.get(i - 1).x, puntos.get(i - 1).y, puntos.get(i).x, puntos.get(i).y);
        }
    }
}
