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
public abstract class Figura {
     private Color colorDePrimerPlano;
    private Color colorDeSegundoPlano;
    private Boolean R;

    Figura(Color colorDePrimerPlano, Color colorDeSegundoPlano, Boolean R) {
        this.colorDePrimerPlano = colorDePrimerPlano;
        this.R = R;
        this.colorDeSegundoPlano = colorDeSegundoPlano;
    }

    public Color getColorDeSegundoPlano() {
        return colorDeSegundoPlano;
    }

    public void setColorDeSegundoPlano(Color colorDeSegundoPlano) {
        this.colorDeSegundoPlano = colorDeSegundoPlano;
    }

    public Boolean getR() {
        return R;
    }

    public void setR(Boolean R) {
        this.R = R;
    }

    public abstract void actualizar(Point puntoFinal);

    public abstract void dibujar(Graphics g);

    public Color getColorDePrimerPlano() {
        return colorDePrimerPlano;
    }

    public void setColorDePrimerPlano(Color colorDePrimerPlano) {
        this.colorDePrimerPlano = colorDePrimerPlano;
    }

}
