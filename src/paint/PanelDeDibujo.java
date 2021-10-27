/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import figuras.*;
import figuras.DibujoLibre;
import javax.swing.SwingUtilities;

public class PanelDeDibujo extends JPanel {

    int almacenaNumerito;
    Figura figuraActual;
    ArrayList<Figura> figuras;

    DibujoLibre punto;

    public int getAlmacenaNumerito() {
        return almacenaNumerito;
    }

    public void setAlmacenaNumerito(int almacenaNumerito) {
        this.almacenaNumerito = almacenaNumerito;
    }

    public PanelDeDibujo() {

        figuras = new ArrayList<>();

        setBackground(Color.WHITE);

        class Manejador extends MouseAdapter {

            @Override
            public void mousePressed(MouseEvent evento) {

                if (evento.getButton() == MouseEvent.BUTTON1) {

//                    if (getAlmacenaNumerito() == 1) {
//                        figuraActual = new Rectangulo(evento.getPoint());
//                    } else if (getAlmacenaNumerito() == 2) {
//                        figuraActual = new Linea(evento.getPoint());
//                    } else if (getAlmacenaNumerito() == 3) {
//                        figuraActual = new Ovalo(evento.getPoint());
//                    } else if (getAlmacenaNumerito() == 4) {
//                        figuraActual = new DibujoLibre(evento.getPoint());
//                    } 

                    switch (getAlmacenaNumerito()) {
                        case 1:
                            figuraActual = new Rectangulo(evento.getPoint());
                            break;
                        case 2:
                            figuraActual = new Linea(evento.getPoint());
                            break;
                        case 3:
                            figuraActual = new Triangulo(evento.getPoint());
                            break;
                        case 4:
                            figuraActual = new DibujoLibre(evento.getPoint());
                            break;
                         case 5:
                            figuraActual = new Rombo(evento.getPoint());
                            break;
                        default:
                            figuraActual = new DibujoLibre(evento.getPoint());
                            break;
                    }

                    figuras.add(figuraActual);
                    repaint();
                }

                if (evento.getButton() == MouseEvent.BUTTON3) {

                    figuraActual = new DibujoLibre(evento.getPoint());
                    figuras.add(figuraActual);
                }
            }

            @Override
            public void mouseDragged(MouseEvent evento) {

                if (SwingUtilities.isLeftMouseButton(evento)) {

                    figuraActual.actualizar(evento.getPoint());
                }

                if (SwingUtilities.isRightMouseButton(evento)) {

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