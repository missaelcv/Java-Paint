/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import figuras.DibujoLibre;
import figuras.Figura;
import figuras.Linea;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Misael Caceres
 */
    
public class  PanelDeDibujo extends JPanel {

    Figura figuraActual;
    ArrayList<Figura> figuras;
   
    DibujoLibre punto;

    public PanelDeDibujo() {

        figuras = new ArrayList<>();
      
        setBackground(Color.WHITE);

        class Manejador extends MouseAdapter {

            private Point punto = new Point();

            //
            @Override
            public void mousePressed(MouseEvent evento) {
                if (evento.getButton() == MouseEvent.BUTTON1) {
                    System.out.println("Se presiono el boton 1");

                    figuraActual = new Linea(evento.getPoint());
                    figuras.add(figuraActual);
                    repaint();
                } 
                
                if (evento.getButton() == MouseEvent.BUTTON3) {
                    System.out.println("Se presiono el boton 3");
                    figuraActual = new DibujoLibre(evento.getPoint());
                    figuras.add(figuraActual);
                } 
            }

            @Override
            public void mouseDragged(MouseEvent evento) {

                if (SwingUtilities.isLeftMouseButton(evento)) {
                    System.out.println("Se arrastro el boton 1");
                    figuraActual.actualizar(evento.getPoint());
                }  
                
                if (SwingUtilities.isRightMouseButton(evento)) {
                    System.out.println("Se arrastro el boton 3");
                    figuraActual.actualizar(evento.getPoint());
                }
                repaint();
            }
        }

        Manejador manejador = new Manejador();
        this.addMouseListener(manejador);
        this.addMouseMotionListener(manejador);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // g.drawImage(papel, 0, 0, null);
        g.setColor(Color.blue);

        int distancia = 20;
        int total = 0;
        for (int y = distancia * 2; y < getHeight() && total < 27; y += distancia) {
            total++;
            g.drawString("" + total, 0, y);
            g.drawLine(10, y, getWidth() - 10, y);
        }

        g.setColor(Color.red);
        g.drawLine(distancia * 2, 0, distancia * 2, getHeight());

        for (Figura figuraActual : figuras) {
            figuraActual.dibujar(g);
        }
    }
}

