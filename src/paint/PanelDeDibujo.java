/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package paint;

import figuras.Deltoide;
import figuras.DibujoLibre;
import figuras.Figura;
import figuras.Hexagono;
import figuras.Linea;
import figuras.Trapecio;
import figuras.Ovalo;
import figuras.Pentagono;
import figuras.Rectangulo;
import figuras.Rombo;
import figuras.Trapezoide;
import figuras.Triangulo;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author josearielpereyra
 */
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
                else if( btnOvalo.isSelected() )      {
                    figuraActual = new Ovalo( colorDePrimerPlano, evento.getPoint() );
                }
                else if( btnTriangulo.isSelected() ) {
                    figuraActual = new Triangulo( colorDePrimerPlano, evento.getPoint() );
                }
                else if( btnRombo.isSelected() ) {
                    figuraActual = new Rombo( colorDePrimerPlano, evento.getPoint() );
                }
                else if( btnPentagono.isSelected() ) {
                    figuraActual = new Pentagono( colorDePrimerPlano, evento.getPoint() );
                }
                else if( btnHexagono.isSelected() ) {
                    figuraActual = new Hexagono( colorDePrimerPlano, evento.getPoint() );
                }
                else if( btnTrapecio.isSelected() ) {
                    figuraActual = new Trapecio( colorDePrimerPlano, evento.getPoint() );
                }
                 else if( btnDeltoide.isSelected() ) {
                    figuraActual = new Deltoide( colorDePrimerPlano, evento.getPoint() );
                }
                  else if( btnTrapezoide.isSelected() ) {
                    figuraActual = new Trapezoide( colorDePrimerPlano, evento.getPoint() );
                }
                 
                else {
                    figuraActual = new DibujoLibre( colorDePrimerPlano, evento.getPoint() );  
                }
                
//                try {
//                    Image imagen = new ImageIcon(getClass().getResource("/imagenes/lapiz.png")).getImage();
//                    setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 63), "custom cursor"));
//                } catch (Exception excepcion) {
//                    System.out.println("Ocurrio un error y no se pudo cargar la imagen");
//                    excepcion.printStackTrace();
//                }
//                
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelDeHerramientas = new javax.swing.JPanel();
        barraDeHerramientas = new javax.swing.JToolBar();
        btnLapiz = new javax.swing.JToggleButton();
        btnLinea = new javax.swing.JToggleButton();
        btnRectangulo = new javax.swing.JToggleButton();
        btnOvalo = new javax.swing.JToggleButton();
        btnRombo = new javax.swing.JToggleButton();
        btnTriangulo = new javax.swing.JToggleButton();
        btnPentagono = new javax.swing.JToggleButton();
        btnHexagono = new javax.swing.JToggleButton();
        btnTrapecio = new javax.swing.JToggleButton();
        btnDeltoide = new javax.swing.JToggleButton();
        btnTrapezoide = new javax.swing.JToggleButton();
        panelColor = new javax.swing.JPanel();
        botonDePrimerPlano = new javax.swing.JToggleButton();
        botonDeSegundoPlano = new javax.swing.JToggleButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraDeHerramientas.setFloatable(false);
        barraDeHerramientas.setRollover(true);

        buttonGroup1.add(btnLapiz);
        btnLapiz.setSelected(true);
        btnLapiz.setText("Lapiz");
        btnLapiz.setFocusable(false);
        btnLapiz.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLapiz.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraDeHerramientas.add(btnLapiz);

        buttonGroup1.add(btnLinea);
        btnLinea.setText("Linea");
        btnLinea.setFocusable(false);
        btnLinea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLinea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraDeHerramientas.add(btnLinea);

        buttonGroup1.add(btnRectangulo);
        btnRectangulo.setText("Rectangulo");
        btnRectangulo.setFocusable(false);
        btnRectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraDeHerramientas.add(btnRectangulo);

        buttonGroup1.add(btnOvalo);
        btnOvalo.setText("Ovalo");
        btnOvalo.setFocusable(false);
        btnOvalo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOvalo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraDeHerramientas.add(btnOvalo);

        buttonGroup1.add(btnRombo);
        btnRombo.setText("Rombo");
        btnRombo.setFocusable(false);
        btnRombo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRombo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraDeHerramientas.add(btnRombo);

        buttonGroup1.add(btnTriangulo);
        btnTriangulo.setText("Triangulo");
        btnTriangulo.setFocusable(false);
        btnTriangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTriangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraDeHerramientas.add(btnTriangulo);

        buttonGroup1.add(btnPentagono);
        btnPentagono.setText("Pentagono");
        btnPentagono.setFocusable(false);
        btnPentagono.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPentagono.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraDeHerramientas.add(btnPentagono);

        buttonGroup1.add(btnHexagono);
        btnHexagono.setText("Hexagono");
        btnHexagono.setFocusable(false);
        btnHexagono.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHexagono.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraDeHerramientas.add(btnHexagono);

        buttonGroup1.add(btnTrapecio);
        btnTrapecio.setText("Trapecio");
        btnTrapecio.setFocusable(false);
        btnTrapecio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTrapecio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraDeHerramientas.add(btnTrapecio);

        buttonGroup1.add(btnDeltoide);
        btnDeltoide.setText("Deltoide");
        btnDeltoide.setFocusable(false);
        btnDeltoide.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeltoide.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeltoide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeltoideActionPerformed(evt);
            }
        });
        barraDeHerramientas.add(btnDeltoide);

        buttonGroup1.add(btnTrapezoide);
        btnTrapezoide.setText("Trapezoide");
        btnTrapezoide.setFocusable(false);
        btnTrapezoide.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTrapezoide.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTrapezoide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrapezoideActionPerformed(evt);
            }
        });
        barraDeHerramientas.add(btnTrapezoide);

        panelDeHerramientas.add(barraDeHerramientas);

        panelColor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonDePrimerPlano.setBackground(new java.awt.Color(0, 0, 0));
        botonDePrimerPlano.setToolTipText("Color de Primer Plano");
        botonDePrimerPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDePrimerPlanoActionPerformed(evt);
            }
        });
        panelColor.add(botonDePrimerPlano, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 29));

        botonDeSegundoPlano.setBackground(new java.awt.Color(255, 255, 255));
        botonDeSegundoPlano.setToolTipText("Color de Segundo Plano");
        botonDeSegundoPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDeSegundoPlanoActionPerformed(evt);
            }
        });
        panelColor.add(botonDeSegundoPlano, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 29));

        panelDeHerramientas.add(panelColor);

        add(panelDeHerramientas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 90));
    }// </editor-fold>//GEN-END:initComponents

    private void botonDePrimerPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDePrimerPlanoActionPerformed
        Color color = JColorChooser.showDialog(this, "Seleccione el color de Primer Plano", colorDePrimerPlano);
        if(color != null) {
            colorDePrimerPlano = color;
            botonDePrimerPlano.setBackground(color);
        }
    }//GEN-LAST:event_botonDePrimerPlanoActionPerformed

    private void botonDeSegundoPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDeSegundoPlanoActionPerformed
        Color color = JColorChooser.showDialog(this, "Seleccione el color de Primer Plano", colorDeSegundoPlano);
        if(color != null) {
            colorDeSegundoPlano = color;
            botonDeSegundoPlano.setBackground(color);
        }
    }//GEN-LAST:event_botonDeSegundoPlanoActionPerformed

    private void btnDeltoideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeltoideActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeltoideActionPerformed

    private void btnTrapezoideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrapezoideActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTrapezoideActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar barraDeHerramientas;
    private javax.swing.JToggleButton botonDePrimerPlano;
    private javax.swing.JToggleButton botonDeSegundoPlano;
    private javax.swing.JToggleButton btnDeltoide;
    private javax.swing.JToggleButton btnHexagono;
    private javax.swing.JToggleButton btnLapiz;
    private javax.swing.JToggleButton btnLinea;
    private javax.swing.JToggleButton btnOvalo;
    private javax.swing.JToggleButton btnPentagono;
    private javax.swing.JToggleButton btnRectangulo;
    private javax.swing.JToggleButton btnRombo;
    private javax.swing.JToggleButton btnTrapecio;
    private javax.swing.JToggleButton btnTrapezoide;
    private javax.swing.JToggleButton btnTriangulo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel panelColor;
    private javax.swing.JPanel panelDeHerramientas;
    // End of variables declaration//GEN-END:variables
}
