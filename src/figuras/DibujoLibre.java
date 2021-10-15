/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author josearielpereyra
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
        if (puntos.size()==1) {
            g.drawLine(puntos.get(0).x, puntos.get(0).y, puntos.get(0).x, puntos.get(0).y);
        }
        
        for (int i = 1; i < puntos.size(); i++) {
            g.drawLine(puntos.get(i - 1).x, puntos.get(i - 1).y, puntos.get(i).x, puntos.get(i).y);
        }
    }

//    BufferedImage papel;
//    Graphics2D crallon;
}
