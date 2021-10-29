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
import java.util.Stack;
import javax.swing.SwingUtilities;

public class PanelDeDibujo extends javax.swing.JPanel {

    Color colorDePrimerPlano;

    public JPanel getPanelDeHerramientas() {
        return panelDeHerramientas;
    }
    Color colorDeSegundoPlano;
  
    Figura figuraActual;
    ArrayList<Figura> figuras;
    Stack<Figura> figurasDeshechas;
    
    
    public void deshacer() {
        if( !figuras.isEmpty() ) {
            figurasDeshechas.push( figuras.remove( figuras.size() - 1 ) );
            repaint();
        }
    }

    public void rehacer() {
        if( !figurasDeshechas.isEmpty() ) {
            figuras.add( figurasDeshechas.pop() );
            repaint();
        }
    }
    
    public PanelDeDibujo() {
        initComponents();
        
        colorDePrimerPlano = Color.BLACK;
        colorDeSegundoPlano = Color.WHITE;
        
        figuras = new ArrayList<>();
        figurasDeshechas = new Stack<>();
        
        setBackground( Color.WHITE );
        
        
        class Manejador extends MouseAdapter{

            @Override
            public void mousePressed(MouseEvent evento) {
                if( btnLinea.isSelected() ) {
                    figuraActual = new Linea( colorDePrimerPlano, evento.getPoint() );
                }
                else if( btnRectangulo.isSelected() ) {
                    figuraActual = new Rectangulo( colorDePrimerPlano, evento.getPoint() );
                }
                else if( btnOvalo.isSelected() ) {
                    figuraActual = new Ovalo( colorDePrimerPlano, evento.getPoint() );
                }
                else {
                    figuraActual = new DibujoLibre( colorDePrimerPlano, evento.getPoint() );
                    
                }
                
                try {
                    Image imagen = new ImageIcon(getClass().getResource("/imagenes/lapiz.png")).getImage();
                    setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 63), "custom cursor"));
                } catch (Exception excepcion) {
                    System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                    excepcion.printStackTrace();
                }
                
                figuras.add(figuraActual );
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent evento ) {
                figuraActual.actualizar(evento.getPoint());
                repaint();
            }
        }
        
        Manejador manejador = new Manejador();
        this.addMouseListener( manejador );
        this.addMouseMotionListener( manejador );
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
                
        g.setColor(Color.RED);
        g.drawLine(distancia * 2, 0, distancia * 2, getHeight());
        
        for (Figura figura : figuras) {
            figura.dibujar(g);
        }   
    }
}