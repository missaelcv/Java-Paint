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
public class BoteDePintura extends FiguraRellenable{

    public BoteDePintura(Color colorDePrimerPlano, Color colorDeSegundoPlano, Boolean relleno) {
        super(colorDePrimerPlano, colorDeSegundoPlano, relleno);
    }

    @Override
    public void actualizar(Point puntoFinal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dibujar(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
