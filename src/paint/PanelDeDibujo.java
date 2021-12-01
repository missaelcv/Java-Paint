package paint;

import figuras.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelDeDibujo extends javax.swing.JPanel {

    Color colorDePrimerPlano;
    Boolean R;

    public JPanel getPanelDeHerramientas() {
        return panelDeHerramientas;
    }
    Color colorDeSegundoPlano;

    Figura figuraActual;
    ArrayList<Figura> figuras;
    Stack<Figura> figurasDeshechas;

    public void deshacer() {
        if (!figuras.isEmpty()) {
            figurasDeshechas.push(figuras.remove(figuras.size() - 1));
            repaint();
        }
    }

    public void rehacer() {
        if (!figurasDeshechas.isEmpty()) {
            figuras.add(figurasDeshechas.pop());
            repaint();
        }
    }

    public void guardar() {
        BufferedImage imagen = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imagen.createGraphics();

        this.paint(g2d);

        JFileChooser selector = new JFileChooser();
       int opcion = selector.showSaveDialog(this);
       
       if (opcion == JFileChooser.APPROVE_OPTION){

        File  archivo = selector.getSelectedFile();
        try {
            ImageIO.write(imagen, "jpg", archivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2d.dispose();
    }
    }

    public PanelDeDibujo() {
        initComponents();

        colorDePrimerPlano = Color.BLACK;
        colorDeSegundoPlano = Color.WHITE;

        figuras = new ArrayList<>();
        figurasDeshechas = new Stack<>();

        setBackground(Color.WHITE);

        class Manejador extends MouseAdapter {

            @Override
            public void mousePressed(MouseEvent evento) {

                R = btnFill.isSelected();

                if (btnLinea.isSelected()) {
                    figuraActual = new Linea(colorDePrimerPlano, colorDeSegundoPlano, R, evento.getPoint());
                } else if (btnRectangulo.isSelected()) {
                    figuraActual = new Rectangulo(colorDePrimerPlano, colorDeSegundoPlano, R, evento.getPoint());
                } else if (btnOvalo.isSelected()) {
                    figuraActual = new Ovalo(colorDePrimerPlano, colorDeSegundoPlano, R, evento.getPoint());
                } else if (btnTriangulo.isSelected()) {
                    figuraActual = new Triangulo(colorDePrimerPlano, colorDeSegundoPlano, R, evento.getPoint());
                } else if (btnTrianguloRectangulo.isSelected()) {
                    figuraActual = new TrianguloRectangulo(colorDePrimerPlano, colorDeSegundoPlano, R, evento.getPoint());
                } else if (btnTrapecio.isSelected()) {
                    figuraActual = new Trapecio(colorDePrimerPlano, colorDeSegundoPlano, R, evento.getPoint());
                } else if (btnParalelogramo.isSelected()) {
                    figuraActual = new Paralelogramo(colorDePrimerPlano, colorDeSegundoPlano, R, evento.getPoint());
                } else if (btnTrianguloEscaleno.isSelected()) {
                    figuraActual = new TrianguloEscaleno(colorDePrimerPlano, colorDeSegundoPlano, R, evento.getPoint());
                } else if (btnEstrella.isSelected()) {
                    figuraActual = new Estrella(colorDePrimerPlano, colorDeSegundoPlano, R, evento.getPoint());
                } else if (btnPentagono.isSelected()) {
                    figuraActual = new Pentagono(colorDePrimerPlano, colorDeSegundoPlano, R, evento.getPoint());
                } else if (btnRombo.isSelected()) {
                    figuraActual = new Rombo(colorDePrimerPlano, colorDeSegundoPlano, R, evento.getPoint());
                } else if (btnBorrador.isSelected()) {
                    figuraActual = new Borrador(colorDePrimerPlano, colorDeSegundoPlano, R, evento.getPoint());
                } else if (btnCruz.isSelected()) {
                    figuraActual = new Cruz(colorDePrimerPlano, colorDeSegundoPlano, R, evento.getPoint());
                } else if (btnSemiCirculo.isSelected()) {
                    figuraActual = new SemiCirculo(colorDePrimerPlano, colorDeSegundoPlano, R, evento.getPoint());
                } else if (btnRing.isSelected()) {
                    figuraActual = new Ring(colorDePrimerPlano, colorDeSegundoPlano, R, evento.getPoint());
                } else if (btnFlecha.isSelected()) {
                    figuraActual = new Flecha(colorDePrimerPlano, colorDeSegundoPlano, R, evento.getPoint());
                } else if (btnTrianguloEquilatero.isSelected()) {
                    figuraActual = new TrianguloEquilatero(colorDePrimerPlano, colorDeSegundoPlano, R, evento.getPoint());
                } else if (btnCometa.isSelected()) {
                    figuraActual = new Cometa(colorDePrimerPlano, colorDeSegundoPlano, R, evento.getPoint());
                } else if (btnMultiuso.isSelected()) {
                    figuraActual = new Pic(colorDePrimerPlano, colorDeSegundoPlano, R, evento.getPoint());
                } else {
                    figuraActual = new DibujoLibre(colorDePrimerPlano, colorDeSegundoPlano, R, evento.getPoint());
                }

                figuras.add(figuraActual);
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                try {
                    Image imagen = new ImageIcon(getClass().getResource("/imagenes/lapiz2.png")).getImage();

                    setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                } catch (Exception excepcion) {
                    System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                    excepcion.printStackTrace();
                }
            }

            @Override
            public void mouseDragged(MouseEvent evento) {
                figuraActual.actualizar(evento.getPoint());
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
        for (int y = distancia; y < getHeight(); y += distancia) {

            g.drawString("" + y, 0, y);
            g.drawLine(20, y, getWidth(), y);
        }

        for (int x = distancia; x < getWidth(); x += distancia) {
            if (x % 40 == 0) {
                g.drawString("" + x, x, 20);
            }
            g.drawLine(x, 20, x, getHeight());
        }

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
        jPanel1 = new javax.swing.JPanel();
        btnLapiz = new javax.swing.JToggleButton();
        btnLinea = new javax.swing.JToggleButton();
        btnRectangulo = new javax.swing.JToggleButton();
        btnOvalo = new javax.swing.JToggleButton();
        btnTriangulo = new javax.swing.JToggleButton();
        btnTrapecio = new javax.swing.JToggleButton();
        btnTrianguloRectangulo = new javax.swing.JToggleButton();
        btnParalelogramo = new javax.swing.JToggleButton();
        btnTrianguloEscaleno = new javax.swing.JToggleButton();
        btnCometa = new javax.swing.JToggleButton();
        btnEstrella = new javax.swing.JToggleButton();
        btnPentagono = new javax.swing.JToggleButton();
        btnRombo = new javax.swing.JToggleButton();
        btnBorrador = new javax.swing.JToggleButton();
        btnCruz = new javax.swing.JToggleButton();
        btnSemiCirculo = new javax.swing.JToggleButton();
        btnRing = new javax.swing.JToggleButton();
        btnTrianguloEquilatero = new javax.swing.JToggleButton();
        btnFlecha = new javax.swing.JToggleButton();
        btnMultiuso = new javax.swing.JToggleButton();
        btnFill = new javax.swing.JToggleButton();
        panelColor = new javax.swing.JPanel();
        botonDePrimerPlano = new javax.swing.JToggleButton();
        botonDeSegundoPlano = new javax.swing.JToggleButton();

        setLayout(new java.awt.BorderLayout());

        panelDeHerramientas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelDeHerramientas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                panelDeHerramientasPropertyChange(evt);
            }
        });
        panelDeHerramientas.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridLayout(2, 0));

        buttonGroup1.add(btnLapiz);
        btnLapiz.setText("Lapiz");
        btnLapiz.setFocusable(false);
        btnLapiz.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLapiz.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnLapiz);

        buttonGroup1.add(btnLinea);
        btnLinea.setText("Linea");
        btnLinea.setFocusable(false);
        btnLinea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLinea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnLinea);

        buttonGroup1.add(btnRectangulo);
        btnRectangulo.setText("Rectang");
        btnRectangulo.setFocusable(false);
        btnRectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnRectangulo);

        buttonGroup1.add(btnOvalo);
        btnOvalo.setText("Ovalo");
        btnOvalo.setFocusable(false);
        btnOvalo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOvalo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnOvalo);

        buttonGroup1.add(btnTriangulo);
        btnTriangulo.setText("Triangulo");
        btnTriangulo.setFocusable(false);
        btnTriangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTriangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTriangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrianguloActionPerformed(evt);
            }
        });
        jPanel1.add(btnTriangulo);

        buttonGroup1.add(btnTrapecio);
        btnTrapecio.setText("Trapecio");
        btnTrapecio.setFocusable(false);
        btnTrapecio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTrapecio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnTrapecio);

        buttonGroup1.add(btnTrianguloRectangulo);
        btnTrianguloRectangulo.setText("Triangulo Rec");
        btnTrianguloRectangulo.setFocusable(false);
        btnTrianguloRectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTrianguloRectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTrianguloRectangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrianguloRectanguloActionPerformed(evt);
            }
        });
        jPanel1.add(btnTrianguloRectangulo);

        buttonGroup1.add(btnParalelogramo);
        btnParalelogramo.setText("Paralelogramo");
        btnParalelogramo.setFocusable(false);
        btnParalelogramo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnParalelogramo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnParalelogramo);

        buttonGroup1.add(btnTrianguloEscaleno);
        btnTrianguloEscaleno.setText("Triangulo Esca");
        btnTrianguloEscaleno.setFocusable(false);
        btnTrianguloEscaleno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTrianguloEscaleno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTrianguloEscaleno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrianguloEscalenoActionPerformed(evt);
            }
        });
        jPanel1.add(btnTrianguloEscaleno);

        buttonGroup1.add(btnCometa);
        btnCometa.setFocusable(false);
        btnCometa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCometa.setLabel("Cometa");
        btnCometa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnCometa);

        buttonGroup1.add(btnEstrella);
        btnEstrella.setText("Estrella");
        btnEstrella.setFocusable(false);
        btnEstrella.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEstrella.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEstrella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstrellaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEstrella);

        buttonGroup1.add(btnPentagono);
        btnPentagono.setText("Pentagono");
        btnPentagono.setFocusable(false);
        btnPentagono.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPentagono.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPentagono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPentagonoActionPerformed(evt);
            }
        });
        jPanel1.add(btnPentagono);

        buttonGroup1.add(btnRombo);
        btnRombo.setText("Rombo");
        btnRombo.setFocusable(false);
        btnRombo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRombo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRomboActionPerformed(evt);
            }
        });
        jPanel1.add(btnRombo);

        buttonGroup1.add(btnBorrador);
        btnBorrador.setText("Borrador");
        btnBorrador.setFocusable(false);
        btnBorrador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBorrador.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBorrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorradorActionPerformed(evt);
            }
        });
        jPanel1.add(btnBorrador);

        buttonGroup1.add(btnCruz);
        btnCruz.setText("Cruz");
        btnCruz.setFocusable(false);
        btnCruz.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCruz.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnCruz);

        buttonGroup1.add(btnSemiCirculo);
        btnSemiCirculo.setText("SemiCirculo");
        btnSemiCirculo.setFocusable(false);
        btnSemiCirculo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSemiCirculo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnSemiCirculo);

        buttonGroup1.add(btnRing);
        btnRing.setText("Ring");
        btnRing.setFocusable(false);
        btnRing.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRing.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnRing);

        buttonGroup1.add(btnTrianguloEquilatero);
        btnTrianguloEquilatero.setText("Triangulo Equil");
        btnTrianguloEquilatero.setFocusable(false);
        btnTrianguloEquilatero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTrianguloEquilatero.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnTrianguloEquilatero);

        buttonGroup1.add(btnFlecha);
        btnFlecha.setText("Flecha");
        btnFlecha.setFocusable(false);
        btnFlecha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFlecha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFlecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlechaActionPerformed(evt);
            }
        });
        jPanel1.add(btnFlecha);

        buttonGroup1.add(btnMultiuso);
        btnMultiuso.setText("MultiUso");
        btnMultiuso.setFocusable(false);
        btnMultiuso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMultiuso.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMultiuso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiusoActionPerformed(evt);
            }
        });
        jPanel1.add(btnMultiuso);

        btnFill.setText("Cubeta De Pint");
        btnFill.setFocusable(false);
        btnFill.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFill.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFillActionPerformed(evt);
            }
        });
        jPanel1.add(btnFill);
        btnFill.getAccessibleContext().setAccessibleName("prueba");

        panelDeHerramientas.add(jPanel1, java.awt.BorderLayout.CENTER);

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

        panelDeHerramientas.add(panelColor, java.awt.BorderLayout.EAST);

        add(panelDeHerramientas, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void botonDePrimerPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDePrimerPlanoActionPerformed
        Color color = JColorChooser.showDialog(this, "Seleccione el color de Primer Plano", colorDePrimerPlano);
        if (color != null) {
            colorDePrimerPlano = color;
            botonDePrimerPlano.setBackground(color);
        }
    }//GEN-LAST:event_botonDePrimerPlanoActionPerformed

    private void botonDeSegundoPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDeSegundoPlanoActionPerformed
        Color color = JColorChooser.showDialog(this, "Seleccione el color de Primer Plano", colorDeSegundoPlano);
        if (color != null) {
            colorDeSegundoPlano = color;
            botonDeSegundoPlano.setBackground(color);
        }
    }//GEN-LAST:event_botonDeSegundoPlanoActionPerformed

    private void btnTrianguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrianguloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTrianguloActionPerformed

    private void btnTrianguloRectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrianguloRectanguloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTrianguloRectanguloActionPerformed

    private void btnTrianguloEscalenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrianguloEscalenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTrianguloEscalenoActionPerformed

    private void btnEstrellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstrellaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEstrellaActionPerformed

    private void btnPentagonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPentagonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPentagonoActionPerformed

    private void btnRomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRomboActionPerformed

    private void btnBorradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorradorActionPerformed

    private void panelDeHerramientasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_panelDeHerramientasPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_panelDeHerramientasPropertyChange

    private void btnFlechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFlechaActionPerformed

    private void btnFillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFillActionPerformed

    }//GEN-LAST:event_btnFillActionPerformed

    private void btnMultiusoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultiusoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMultiusoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botonDePrimerPlano;
    private javax.swing.JToggleButton botonDeSegundoPlano;
    private javax.swing.JToggleButton btnBorrador;
    private javax.swing.JToggleButton btnCometa;
    private javax.swing.JToggleButton btnCruz;
    private javax.swing.JToggleButton btnEstrella;
    private javax.swing.JToggleButton btnFill;
    private javax.swing.JToggleButton btnFlecha;
    private javax.swing.JToggleButton btnLapiz;
    private javax.swing.JToggleButton btnLinea;
    private javax.swing.JToggleButton btnMultiuso;
    private javax.swing.JToggleButton btnOvalo;
    private javax.swing.JToggleButton btnParalelogramo;
    private javax.swing.JToggleButton btnPentagono;
    private javax.swing.JToggleButton btnRectangulo;
    private javax.swing.JToggleButton btnRing;
    private javax.swing.JToggleButton btnRombo;
    private javax.swing.JToggleButton btnSemiCirculo;
    private javax.swing.JToggleButton btnTrapecio;
    private javax.swing.JToggleButton btnTriangulo;
    private javax.swing.JToggleButton btnTrianguloEquilatero;
    private javax.swing.JToggleButton btnTrianguloEscaleno;
    private javax.swing.JToggleButton btnTrianguloRectangulo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelColor;
    private javax.swing.JPanel panelDeHerramientas;
    // End of variables declaration//GEN-END:variables
}
