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
import java.awt.Graphics;
import java.awt.Point;

public abstract class Figura {

    public abstract void actualizar(Point puntoFinal);
    public abstract void dibujar(Graphics g);
}
