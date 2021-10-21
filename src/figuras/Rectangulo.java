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
public class Rectangulo extends Figura{
    
    private double longitud;
    private double anchura;
    
//    int altura;
//    int anchura1;
//    int x;
//    int y;
//
//    public Rectangulo(int x, int y, int anchura1, int altura) {
//        this.x = x;
//        this.y = y;
//        this.altura = altura;
//        this.anchura1 = anchura1;
//    }
    
 
    public Rectangulo(double longitud, double anchura) {
        this.longitud = longitud;
        this.anchura = anchura;
    }
 
    public Rectangulo() {
        this.longitud = 1;
        this.anchura = 1;
    }
 
    public void setlongitud(double longitud) {
        if (longitud > 0.0 && longitud < 20.0) {
            this.longitud = longitud;
        }
    }
 
    public void setanchura(double anchura) {
        if (anchura > 0.0 && longitud < 20.0) {
            this.anchura = anchura;
        } else {
            throw new RuntimeException("la Anchura debe debe de ser > 0 < 20.0");
        }
    }
 
//    public void dibuja(Graphics g)
//    {
//        g.setColor(Color.BLACK);
//        g.drawRect(x,y ,anchura1, altura);
//    }
    
    public static void main(String[] args) {
        Rectangulo rect = new Rectangulo();
        rect.setanchura(-12.2);
        rect.setlongitud(12.2);
       
    }
    @Override
    public void actualizar(Point puntoFinal) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void dibujar(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
         
}
