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
import javax.swing.filechooser.FileNameExtensionFilter;

public class PanelDeDibujo extends javax.swing.JPanel {

    Color colorDePrimerPlano;
    Boolean relleno;
    File archivoActual;

    int contadorClick = 3;//Inicia en 3 para panel de dibujo sin cuadricula.

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

    public void guardarComo() {
        BufferedImage imagen = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imagen.createGraphics();
        this.paint(g2d);
        g2d.dispose();

        JFileChooser selector = new JFileChooser();
        selector.removeChoosableFileFilter( selector.getChoosableFileFilters()[0] );
        selector.addChoosableFileFilter( new FileNameExtensionFilter("jpg", "jpg") );
        selector.addChoosableFileFilter( new FileNameExtensionFilter("png", "png") );
        
        int opcion = selector.showSaveDialog(this);
        
        if (opcion == JFileChooser.APPROVE_OPTION) {
            try {
                String ruta = selector.getSelectedFile().getPath();
                String extensionDelSelector = selector.getFileFilter().getDescription();
                int indiceDePunto = ruta.lastIndexOf(".");
                String extension = indiceDePunto < 0 ? "." + extensionDelSelector : ruta.substring(indiceDePunto);
                
                if( !extension.equalsIgnoreCase(".jpg") && !extension.equalsIgnoreCase(".png")) {
                    extension = "." + extensionDelSelector;
                    ruta = ruta.substring(0, indiceDePunto);
                }

                archivoActual = new File(ruta + extension);
                ImageIO.write(imagen, extension.replace(".", ""), archivoActual);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void guardar() {
        try {
            if(archivoActual != null) {
                BufferedImage imagen = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = imagen.createGraphics();
                this.paint(g2d);
                g2d.dispose();
                
                String ruta = archivoActual.getPath();
                String extension = ruta.substring(ruta.lastIndexOf(".") + 1);
                ImageIO.write(imagen, extension, archivoActual);
            }
            else {
                guardarComo();
            }
        } catch (IOException e) {
            e.printStackTrace();
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
            public void mouseReleased(MouseEvent evento) {
                try {
                    Image imagen = new ImageIcon(getClass().getResource("/imagenes/lapiz3.png")).getImage();
//                    System.out.println("Anchura: " + imagen.getWidth(PanelDeDibujo.this));
//                    System.out.println("Altura: " + imagen.getHeight(PanelDeDibujo.this));
                    setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                } catch (Exception excepcion) {
                    System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                    excepcion.printStackTrace();
                }
            }

            @Override
            public void mousePressed(MouseEvent evento) {

                relleno = btnFill.isSelected();

                if (btnLinea.isSelected()) {
                    figuraActual = new Linea(colorDePrimerPlano, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/linea.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnRectangulo.isSelected()) {
                    figuraActual = new Rectangulo(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/rectangulo.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnOvalo.isSelected()) {
                    figuraActual = new Ovalo(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/ovalo.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnTriangulo.isSelected()) {
                    figuraActual = new Triangulo(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/triangulo.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnTrianguloRectangulo.isSelected()) {
                    figuraActual = new TrianguloRectangulo(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/trianguloEquilatero.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnTrapecio.isSelected()) {
                    figuraActual = new Trapecio(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/trapecio.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnParalelogramo.isSelected()) {
                    figuraActual = new Paralelogramo(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/paralelogramo.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnTrianguloEscaleno.isSelected()) {
                    figuraActual = new TrianguloEscaleno(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/trianguloEscaleno.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnEstrella.isSelected()) {
                    figuraActual = new Estrella(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/estrella.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnPentagono.isSelected()) {
                    figuraActual = new Pentagono(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/pentagono.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 30), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnRombo.isSelected()) {
                    figuraActual = new Rombo(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/rombo.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnBorrador.isSelected()) {
                    figuraActual = new Borrador(colorDePrimerPlano, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/borrador.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnCruz.isSelected()) {
                    figuraActual = new Cruz(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/cruz.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnSemiCirculo.isSelected()) {
                    figuraActual = new SemiCirculo(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/semiCirculo.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnRing.isSelected()) {
                    figuraActual = new Ring(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/ring.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnFlecha.isSelected()) {
                    figuraActual = new Flecha(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/flecha.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnCometa.isSelected()) {
                    figuraActual = new Cometa(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/cometa.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnHexagono.isSelected()) {
                    figuraActual = new Hexagono(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/hexagono.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnOctagono.isSelected()) {
                    figuraActual = new Octagono(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/octagono.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnPic.isSelected()) {
                    figuraActual = new Pic(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/pic.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 30), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnCirculo.isSelected()) {
                    figuraActual = new Circulo(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/circulo.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnCuadrado.isSelected()) {
//                  figuraActual = new Cuadrado(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());                    
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/cuadrado.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnCorazon.isSelected()) {
                    figuraActual = new Corazon(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/corazon.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnCreciente.isSelected()) {
                    figuraActual = new Creciente(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/creciente.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnElipse.isSelected()) {
                    figuraActual = new Elipse(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/elipse.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnPoligono.isSelected()) {
                    figuraActual = new Poligono(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/poligono.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnQuatrebol.isSelected()) {
                    figuraActual = new Quatrebol(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/quatrebol.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else if (btnTrebol.isSelected()) {
                    figuraActual = new Trebol(colorDePrimerPlano, colorDeSegundoPlano, relleno, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/trebol.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                } else {
                    figuraActual = new DibujoLibre(colorDePrimerPlano, evento.getPoint());
                    try {
                        Image imagen = new ImageIcon(getClass().getResource("/imagenes/lapiz3.png")).getImage();
                        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(imagen, new Point(0, 31), "custom cursor"));
                    } catch (Exception excepcion) {
                        System.out.println("Ocurrio un error y no se pudo cargar la imagen");
                        excepcion.printStackTrace();
                    }
                }

                figuras.add(figuraActual);
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                try {
                    Image imagen = new ImageIcon(getClass().getResource("/imagenes/lapiz3.png")).getImage();

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

    private void Cuadricula(Graphics g) {
        int distancia = 20;

        if (contadorClick == 0 || contadorClick == 1) {
            for (int y = distancia; y < getHeight(); y += distancia) {

                g.drawString("" + y, 0, y);
                g.drawLine(20, y, getWidth(), y);
            }
        }
        if (contadorClick == 0 || contadorClick == 2) {
            for (int x = distancia; x < getWidth(); x += distancia) {
                if (x % 40 == 0) {
                    g.drawString("" + x, x, 20);
                }
                g.drawLine(x, 20, x, getHeight());
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Figura figura : figuras) {
            figura.dibujar(g);
        }
        g.setColor(Color.blue);
        Cuadricula(g);
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
        bntGuardarPic = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        btnBotePintura = new javax.swing.JToggleButton();
        btnGotero = new javax.swing.JToggleButton();
        btnBorrador = new javax.swing.JToggleButton();
        btnLapiz = new javax.swing.JToggleButton();
        btnLinea = new javax.swing.JToggleButton();
        btnCuadrado = new javax.swing.JToggleButton();
        btnCirculo = new javax.swing.JToggleButton();
        btnTriangulo = new javax.swing.JToggleButton();
        btnRectangulo = new javax.swing.JToggleButton();
        btnTrianguloEscaleno = new javax.swing.JToggleButton();
        btnPentagono = new javax.swing.JToggleButton();
        btnTrianguloRectangulo = new javax.swing.JToggleButton();
        btnTrapecio = new javax.swing.JToggleButton();
        btnCometa = new javax.swing.JToggleButton();
        btnPoligono = new javax.swing.JToggleButton();
        btnParalelogramo = new javax.swing.JToggleButton();
        btnOvalo = new javax.swing.JToggleButton();
        btnElipse = new javax.swing.JToggleButton();
        btnQuatrebol = new javax.swing.JToggleButton();
        btnEstrella = new javax.swing.JToggleButton();
        btnSemiCirculo = new javax.swing.JToggleButton();
        btnHexagono = new javax.swing.JToggleButton();
        btnCreciente = new javax.swing.JToggleButton();
        btnOctagono = new javax.swing.JToggleButton();
        btnCruz = new javax.swing.JToggleButton();
        btnRing = new javax.swing.JToggleButton();
        btnPic = new javax.swing.JToggleButton();
        btnCorazon = new javax.swing.JToggleButton();
        btnFlecha = new javax.swing.JToggleButton();
        btnTrebol = new javax.swing.JToggleButton();
        btnRombo = new javax.swing.JToggleButton();
        btnFill = new javax.swing.JToggleButton();
        panelColor = new javax.swing.JPanel();
        botonDePrimerPlano = new javax.swing.JToggleButton();
        botonDeSegundoPlano = new javax.swing.JToggleButton();
        Colores = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        panelDeHerramientas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelDeHerramientas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                panelDeHerramientasPropertyChange(evt);
            }
        });
        panelDeHerramientas.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridLayout(2, 0));

        bntGuardarPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardarPic.png"))); // NOI18N
        bntGuardarPic.setToolTipText("Guardar Pic");
        bntGuardarPic.setFocusable(false);
        bntGuardarPic.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bntGuardarPic.setMaximumSize(new java.awt.Dimension(35, 35));
        bntGuardarPic.setMinimumSize(new java.awt.Dimension(35, 35));
        bntGuardarPic.setPreferredSize(new java.awt.Dimension(35, 35));
        bntGuardarPic.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bntGuardarPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntGuardarPicActionPerformed(evt);
            }
        });
        jPanel1.add(bntGuardarPic);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/grid.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        buttonGroup1.add(btnBotePintura);
        btnBotePintura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botePintura.png"))); // NOI18N
        btnBotePintura.setToolTipText("Bote de pintura");
        btnBotePintura.setMaximumSize(new java.awt.Dimension(35, 35));
        btnBotePintura.setMinimumSize(new java.awt.Dimension(35, 35));
        btnBotePintura.setPreferredSize(new java.awt.Dimension(35, 35));
        btnBotePintura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBotePinturaActionPerformed(evt);
            }
        });
        jPanel1.add(btnBotePintura);

        buttonGroup1.add(btnGotero);
        btnGotero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gotero.png"))); // NOI18N
        btnGotero.setToolTipText("Gotero");
        btnGotero.setMaximumSize(new java.awt.Dimension(35, 35));
        btnGotero.setMinimumSize(new java.awt.Dimension(35, 35));
        btnGotero.setPreferredSize(new java.awt.Dimension(35, 35));
        btnGotero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoteroActionPerformed(evt);
            }
        });
        jPanel1.add(btnGotero);

        buttonGroup1.add(btnBorrador);
        btnBorrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrador.png"))); // NOI18N
        btnBorrador.setToolTipText("Borrador");
        btnBorrador.setFocusable(false);
        btnBorrador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBorrador.setMaximumSize(new java.awt.Dimension(35, 35));
        btnBorrador.setMinimumSize(new java.awt.Dimension(35, 35));
        btnBorrador.setPreferredSize(new java.awt.Dimension(35, 35));
        btnBorrador.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBorrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorradorActionPerformed(evt);
            }
        });
        jPanel1.add(btnBorrador);

        buttonGroup1.add(btnLapiz);
        btnLapiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lapiz3.png"))); // NOI18N
        btnLapiz.setToolTipText("Lapiz");
        btnLapiz.setFocusable(false);
        btnLapiz.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLapiz.setMaximumSize(new java.awt.Dimension(35, 35));
        btnLapiz.setMinimumSize(new java.awt.Dimension(35, 35));
        btnLapiz.setPreferredSize(new java.awt.Dimension(35, 35));
        btnLapiz.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnLapiz);

        buttonGroup1.add(btnLinea);
        btnLinea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/linea.png"))); // NOI18N
        btnLinea.setToolTipText("Linea");
        btnLinea.setFocusable(false);
        btnLinea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLinea.setMaximumSize(new java.awt.Dimension(35, 35));
        btnLinea.setMinimumSize(new java.awt.Dimension(35, 35));
        btnLinea.setPreferredSize(new java.awt.Dimension(35, 35));
        btnLinea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnLinea);

        buttonGroup1.add(btnCuadrado);
        btnCuadrado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuadrado.png"))); // NOI18N
        btnCuadrado.setToolTipText("Cuadrado");
        btnCuadrado.setMaximumSize(new java.awt.Dimension(35, 35));
        btnCuadrado.setMinimumSize(new java.awt.Dimension(35, 35));
        btnCuadrado.setPreferredSize(new java.awt.Dimension(35, 35));
        btnCuadrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuadradoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCuadrado);

        buttonGroup1.add(btnCirculo);
        btnCirculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/circulo.png"))); // NOI18N
        btnCirculo.setToolTipText("Circulo");
        btnCirculo.setMaximumSize(new java.awt.Dimension(35, 35));
        btnCirculo.setMinimumSize(new java.awt.Dimension(35, 35));
        btnCirculo.setPreferredSize(new java.awt.Dimension(35, 35));
        btnCirculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCirculoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCirculo);

        buttonGroup1.add(btnTriangulo);
        btnTriangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/triangulo.png"))); // NOI18N
        btnTriangulo.setToolTipText("Triangulo");
        btnTriangulo.setFocusable(false);
        btnTriangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTriangulo.setMaximumSize(new java.awt.Dimension(35, 35));
        btnTriangulo.setMinimumSize(new java.awt.Dimension(35, 35));
        btnTriangulo.setPreferredSize(new java.awt.Dimension(35, 35));
        btnTriangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTriangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrianguloActionPerformed(evt);
            }
        });
        jPanel1.add(btnTriangulo);

        buttonGroup1.add(btnRectangulo);
        btnRectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rectangulo.png"))); // NOI18N
        btnRectangulo.setToolTipText("Rectangulo");
        btnRectangulo.setFocusable(false);
        btnRectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRectangulo.setMaximumSize(new java.awt.Dimension(35, 35));
        btnRectangulo.setMinimumSize(new java.awt.Dimension(35, 35));
        btnRectangulo.setPreferredSize(new java.awt.Dimension(35, 35));
        btnRectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnRectangulo);

        buttonGroup1.add(btnTrianguloEscaleno);
        btnTrianguloEscaleno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trianguloEscaleno.png"))); // NOI18N
        btnTrianguloEscaleno.setToolTipText("Triangulo Escaleno");
        btnTrianguloEscaleno.setFocusable(false);
        btnTrianguloEscaleno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTrianguloEscaleno.setMaximumSize(new java.awt.Dimension(35, 35));
        btnTrianguloEscaleno.setMinimumSize(new java.awt.Dimension(35, 35));
        btnTrianguloEscaleno.setPreferredSize(new java.awt.Dimension(35, 35));
        btnTrianguloEscaleno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTrianguloEscaleno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrianguloEscalenoActionPerformed(evt);
            }
        });
        jPanel1.add(btnTrianguloEscaleno);

        buttonGroup1.add(btnPentagono);
        btnPentagono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pentagono.png"))); // NOI18N
        btnPentagono.setToolTipText("Pentagono");
        btnPentagono.setFocusable(false);
        btnPentagono.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPentagono.setMaximumSize(new java.awt.Dimension(35, 35));
        btnPentagono.setMinimumSize(new java.awt.Dimension(35, 35));
        btnPentagono.setPreferredSize(new java.awt.Dimension(35, 35));
        btnPentagono.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPentagono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPentagonoActionPerformed(evt);
            }
        });
        jPanel1.add(btnPentagono);

        buttonGroup1.add(btnTrianguloRectangulo);
        btnTrianguloRectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trianguloEquilatero.png"))); // NOI18N
        btnTrianguloRectangulo.setToolTipText("Triangulo Rectangulo");
        btnTrianguloRectangulo.setFocusable(false);
        btnTrianguloRectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTrianguloRectangulo.setMaximumSize(new java.awt.Dimension(35, 35));
        btnTrianguloRectangulo.setMinimumSize(new java.awt.Dimension(35, 35));
        btnTrianguloRectangulo.setPreferredSize(new java.awt.Dimension(35, 35));
        btnTrianguloRectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTrianguloRectangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrianguloRectanguloActionPerformed(evt);
            }
        });
        jPanel1.add(btnTrianguloRectangulo);

        buttonGroup1.add(btnTrapecio);
        btnTrapecio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trapecio.png"))); // NOI18N
        btnTrapecio.setToolTipText("Trapecio");
        btnTrapecio.setFocusable(false);
        btnTrapecio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTrapecio.setMaximumSize(new java.awt.Dimension(35, 35));
        btnTrapecio.setMinimumSize(new java.awt.Dimension(35, 35));
        btnTrapecio.setPreferredSize(new java.awt.Dimension(35, 35));
        btnTrapecio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnTrapecio);

        buttonGroup1.add(btnCometa);
        btnCometa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cometa.png"))); // NOI18N
        btnCometa.setToolTipText("Cometa");
        btnCometa.setFocusable(false);
        btnCometa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCometa.setMaximumSize(new java.awt.Dimension(35, 35));
        btnCometa.setMinimumSize(new java.awt.Dimension(35, 35));
        btnCometa.setPreferredSize(new java.awt.Dimension(35, 35));
        btnCometa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnCometa);

        buttonGroup1.add(btnPoligono);
        btnPoligono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/poligono.png"))); // NOI18N
        btnPoligono.setToolTipText("Poligono");
        btnPoligono.setMaximumSize(new java.awt.Dimension(35, 35));
        btnPoligono.setMinimumSize(new java.awt.Dimension(35, 35));
        btnPoligono.setPreferredSize(new java.awt.Dimension(35, 35));
        jPanel1.add(btnPoligono);

        buttonGroup1.add(btnParalelogramo);
        btnParalelogramo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/paralelogramo.png"))); // NOI18N
        btnParalelogramo.setToolTipText("Paralelogramo");
        btnParalelogramo.setFocusable(false);
        btnParalelogramo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnParalelogramo.setMaximumSize(new java.awt.Dimension(35, 35));
        btnParalelogramo.setMinimumSize(new java.awt.Dimension(35, 35));
        btnParalelogramo.setPreferredSize(new java.awt.Dimension(35, 35));
        btnParalelogramo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnParalelogramo);

        buttonGroup1.add(btnOvalo);
        btnOvalo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ovalo.png"))); // NOI18N
        btnOvalo.setToolTipText("Ovalo");
        btnOvalo.setFocusable(false);
        btnOvalo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOvalo.setMaximumSize(new java.awt.Dimension(35, 35));
        btnOvalo.setMinimumSize(new java.awt.Dimension(35, 35));
        btnOvalo.setPreferredSize(new java.awt.Dimension(35, 35));
        btnOvalo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnOvalo);

        buttonGroup1.add(btnElipse);
        btnElipse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/elipse.png"))); // NOI18N
        btnElipse.setToolTipText("Elipse");
        btnElipse.setMaximumSize(new java.awt.Dimension(35, 35));
        btnElipse.setMinimumSize(new java.awt.Dimension(35, 35));
        btnElipse.setPreferredSize(new java.awt.Dimension(35, 35));
        btnElipse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElipseActionPerformed(evt);
            }
        });
        jPanel1.add(btnElipse);

        buttonGroup1.add(btnQuatrebol);
        btnQuatrebol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/quatrebol.png"))); // NOI18N
        btnQuatrebol.setToolTipText("Quatrebol");
        btnQuatrebol.setMaximumSize(new java.awt.Dimension(35, 35));
        btnQuatrebol.setMinimumSize(new java.awt.Dimension(35, 35));
        btnQuatrebol.setPreferredSize(new java.awt.Dimension(35, 35));
        btnQuatrebol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuatrebolActionPerformed(evt);
            }
        });
        jPanel1.add(btnQuatrebol);

        buttonGroup1.add(btnEstrella);
        btnEstrella.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estrella.png"))); // NOI18N
        btnEstrella.setToolTipText("Estrella");
        btnEstrella.setFocusable(false);
        btnEstrella.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEstrella.setMaximumSize(new java.awt.Dimension(35, 35));
        btnEstrella.setMinimumSize(new java.awt.Dimension(35, 35));
        btnEstrella.setPreferredSize(new java.awt.Dimension(35, 35));
        btnEstrella.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEstrella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstrellaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEstrella);

        buttonGroup1.add(btnSemiCirculo);
        btnSemiCirculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/semiCirculo.png"))); // NOI18N
        btnSemiCirculo.setToolTipText("Semi circulo");
        btnSemiCirculo.setFocusable(false);
        btnSemiCirculo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSemiCirculo.setMaximumSize(new java.awt.Dimension(35, 35));
        btnSemiCirculo.setMinimumSize(new java.awt.Dimension(35, 35));
        btnSemiCirculo.setPreferredSize(new java.awt.Dimension(35, 35));
        btnSemiCirculo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnSemiCirculo);

        buttonGroup1.add(btnHexagono);
        btnHexagono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hexagono.png"))); // NOI18N
        btnHexagono.setToolTipText("Hexagono");
        btnHexagono.setFocusable(false);
        btnHexagono.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHexagono.setMaximumSize(new java.awt.Dimension(35, 35));
        btnHexagono.setMinimumSize(new java.awt.Dimension(35, 35));
        btnHexagono.setPreferredSize(new java.awt.Dimension(35, 35));
        btnHexagono.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHexagono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHexagonoActionPerformed(evt);
            }
        });
        jPanel1.add(btnHexagono);

        buttonGroup1.add(btnCreciente);
        btnCreciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/creciente.png"))); // NOI18N
        btnCreciente.setToolTipText("Creciente");
        btnCreciente.setMaximumSize(new java.awt.Dimension(35, 35));
        btnCreciente.setMinimumSize(new java.awt.Dimension(35, 35));
        btnCreciente.setPreferredSize(new java.awt.Dimension(35, 35));
        btnCreciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrecienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreciente);

        buttonGroup1.add(btnOctagono);
        btnOctagono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/octagono.png"))); // NOI18N
        btnOctagono.setToolTipText("Octagono");
        btnOctagono.setFocusable(false);
        btnOctagono.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOctagono.setMaximumSize(new java.awt.Dimension(35, 35));
        btnOctagono.setMinimumSize(new java.awt.Dimension(35, 35));
        btnOctagono.setPreferredSize(new java.awt.Dimension(35, 35));
        btnOctagono.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOctagono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOctagonoActionPerformed(evt);
            }
        });
        jPanel1.add(btnOctagono);

        buttonGroup1.add(btnCruz);
        btnCruz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cruz.png"))); // NOI18N
        btnCruz.setToolTipText("Cruz");
        btnCruz.setFocusable(false);
        btnCruz.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCruz.setMaximumSize(new java.awt.Dimension(35, 35));
        btnCruz.setMinimumSize(new java.awt.Dimension(35, 35));
        btnCruz.setPreferredSize(new java.awt.Dimension(35, 35));
        btnCruz.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnCruz);

        buttonGroup1.add(btnRing);
        btnRing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ring.png"))); // NOI18N
        btnRing.setToolTipText("Ring");
        btnRing.setFocusable(false);
        btnRing.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRing.setMaximumSize(new java.awt.Dimension(35, 35));
        btnRing.setMinimumSize(new java.awt.Dimension(35, 35));
        btnRing.setPreferredSize(new java.awt.Dimension(35, 35));
        btnRing.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(btnRing);

        buttonGroup1.add(btnPic);
        btnPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pic.png"))); // NOI18N
        btnPic.setToolTipText("Pacman");
        btnPic.setMaximumSize(new java.awt.Dimension(35, 35));
        btnPic.setMinimumSize(new java.awt.Dimension(35, 35));
        btnPic.setPreferredSize(new java.awt.Dimension(35, 35));
        btnPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPicActionPerformed(evt);
            }
        });
        jPanel1.add(btnPic);

        buttonGroup1.add(btnCorazon);
        btnCorazon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/corazon.png"))); // NOI18N
        btnCorazon.setToolTipText("Corazon");
        btnCorazon.setMaximumSize(new java.awt.Dimension(35, 35));
        btnCorazon.setMinimumSize(new java.awt.Dimension(35, 35));
        btnCorazon.setPreferredSize(new java.awt.Dimension(35, 35));
        btnCorazon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorazonActionPerformed(evt);
            }
        });
        jPanel1.add(btnCorazon);

        buttonGroup1.add(btnFlecha);
        btnFlecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flecha.png"))); // NOI18N
        btnFlecha.setToolTipText("Flecha");
        btnFlecha.setFocusable(false);
        btnFlecha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFlecha.setMaximumSize(new java.awt.Dimension(35, 35));
        btnFlecha.setMinimumSize(new java.awt.Dimension(35, 35));
        btnFlecha.setPreferredSize(new java.awt.Dimension(35, 35));
        btnFlecha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFlecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlechaActionPerformed(evt);
            }
        });
        jPanel1.add(btnFlecha);

        buttonGroup1.add(btnTrebol);
        btnTrebol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trebol.png"))); // NOI18N
        btnTrebol.setToolTipText("Trebol");
        btnTrebol.setMaximumSize(new java.awt.Dimension(35, 35));
        btnTrebol.setMinimumSize(new java.awt.Dimension(35, 35));
        btnTrebol.setPreferredSize(new java.awt.Dimension(35, 35));
        btnTrebol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrebolActionPerformed(evt);
            }
        });
        jPanel1.add(btnTrebol);

        buttonGroup1.add(btnRombo);
        btnRombo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/rombo.png"))); // NOI18N
        btnRombo.setToolTipText("Rombo");
        btnRombo.setFocusable(false);
        btnRombo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRombo.setMaximumSize(new java.awt.Dimension(35, 35));
        btnRombo.setMinimumSize(new java.awt.Dimension(35, 35));
        btnRombo.setPreferredSize(new java.awt.Dimension(35, 35));
        btnRombo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRomboActionPerformed(evt);
            }
        });
        jPanel1.add(btnRombo);

        btnFill.setText("Dibujar Con Relleno");
        btnFill.setFocusable(false);
        btnFill.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFill.setMaximumSize(new java.awt.Dimension(145, 40));
        btnFill.setMinimumSize(new java.awt.Dimension(145, 40));
        btnFill.setPreferredSize(new java.awt.Dimension(145, 40));
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
        panelColor.add(botonDePrimerPlano, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 40, 29));

        botonDeSegundoPlano.setBackground(new java.awt.Color(255, 255, 255));
        botonDeSegundoPlano.setToolTipText("Color de Segundo Plano");
        botonDeSegundoPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDeSegundoPlanoActionPerformed(evt);
            }
        });
        panelColor.add(botonDeSegundoPlano, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 40, 29));

        Colores.setText("Colores:");
        panelColor.add(Colores, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 10, 50, -1));

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

    private void bntGuardarPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntGuardarPicActionPerformed

        this.guardar();

    }//GEN-LAST:event_bntGuardarPicActionPerformed

    private void btnHexagonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHexagonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHexagonoActionPerformed

    private void btnOctagonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOctagonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOctagonoActionPerformed

    private void btnGoteroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoteroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGoteroActionPerformed

    private void btnPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPicActionPerformed

    private void btnBotePinturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBotePinturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBotePinturaActionPerformed

    private void btnCirculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCirculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCirculoActionPerformed

    private void btnCuadradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuadradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCuadradoActionPerformed

    private void btnElipseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElipseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnElipseActionPerformed

    private void btnTrebolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrebolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTrebolActionPerformed

    private void btnQuatrebolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuatrebolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuatrebolActionPerformed

    private void btnCrecienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrecienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrecienteActionPerformed

    private void btnCorazonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorazonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCorazonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        contadorClick++;
        if (contadorClick > 3) {
            contadorClick = 0;
        }
        repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnTrianguloEscalenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrianguloEscalenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTrianguloEscalenoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Colores;
    private javax.swing.JToggleButton bntGuardarPic;
    private javax.swing.JToggleButton botonDePrimerPlano;
    private javax.swing.JToggleButton botonDeSegundoPlano;
    private javax.swing.JToggleButton btnBorrador;
    private javax.swing.JToggleButton btnBotePintura;
    private javax.swing.JToggleButton btnCirculo;
    private javax.swing.JToggleButton btnCometa;
    private javax.swing.JToggleButton btnCorazon;
    private javax.swing.JToggleButton btnCreciente;
    private javax.swing.JToggleButton btnCruz;
    private javax.swing.JToggleButton btnCuadrado;
    private javax.swing.JToggleButton btnElipse;
    private javax.swing.JToggleButton btnEstrella;
    private javax.swing.JToggleButton btnFill;
    private javax.swing.JToggleButton btnFlecha;
    private javax.swing.JToggleButton btnGotero;
    private javax.swing.JToggleButton btnHexagono;
    private javax.swing.JToggleButton btnLapiz;
    private javax.swing.JToggleButton btnLinea;
    private javax.swing.JToggleButton btnOctagono;
    private javax.swing.JToggleButton btnOvalo;
    private javax.swing.JToggleButton btnParalelogramo;
    private javax.swing.JToggleButton btnPentagono;
    private javax.swing.JToggleButton btnPic;
    private javax.swing.JToggleButton btnPoligono;
    private javax.swing.JToggleButton btnQuatrebol;
    private javax.swing.JToggleButton btnRectangulo;
    private javax.swing.JToggleButton btnRing;
    private javax.swing.JToggleButton btnRombo;
    private javax.swing.JToggleButton btnSemiCirculo;
    private javax.swing.JToggleButton btnTrapecio;
    private javax.swing.JToggleButton btnTrebol;
    private javax.swing.JToggleButton btnTriangulo;
    private javax.swing.JToggleButton btnTrianguloEscaleno;
    private javax.swing.JToggleButton btnTrianguloRectangulo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelColor;
    private javax.swing.JPanel panelDeHerramientas;
    // End of variables declaration//GEN-END:variables
}
