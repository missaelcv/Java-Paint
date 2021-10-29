/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

/**
 *
 * @author Misael Caceres
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

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
