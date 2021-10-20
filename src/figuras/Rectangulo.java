/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Misael Caceres
 */
public class Rectangulo extends Figura{

    @Override
    public void actualizar(Point puntoFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dibujar(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Metodos Distitnos 
    
    private double longitud;
    private double anchura;
 
    public Rectangulo(double longitud, double anchura) {
        this.longitud = longitud;
        this.anchura = anchura;
    }
 
    public Rectangulo() {
        this.longitud = 1;
        this.anchura = 1;
    }
//Metodos para calcular el perimetro y el Aréa
 
    public double getlongitud() {
        return longitud;
    }
 
    public double getanchura() {
        return anchura;
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
 
    @Override
    public String toString() {
        return "Rectangulo{" + "longitud=" + longitud + ", anchura=" + anchura + '}';
 
    }
 
    ///////////////////////////
    public double calcularArea() {
        return anchura * longitud;
    }
 
    public double calculaPerimetro() {
        return (2 * anchura) + (2 * longitud);
    }
    ///////////////////////////
 
    public static void main(String[] args) {
        Rectangulo rect = new Rectangulo();
        rect.setanchura(-12.2);
        rect.setlongitud(12.2);
        System.out.println(rect.calcularArea());
        System.out.println(rect.calculaPerimetro());
    }
         
}
