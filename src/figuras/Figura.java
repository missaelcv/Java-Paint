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
    
    Figura(Color colorDePrimerPlano) {
        this.colorDePrimerPlano = colorDePrimerPlano;
    }
    
    public abstract void actualizar( Point puntoFinal );
    public abstract void dibujar( Graphics g );

    public Color getColorDePrimerPlano() {
        return colorDePrimerPlano;
    }

    public void setColorDePrimerPlano(Color colorDePrimerPlano) {
        this.colorDePrimerPlano = colorDePrimerPlano;
    }
}
