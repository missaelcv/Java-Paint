package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class FiguraRellenable extends Figura {

    private Color colorDeSegundoPlano;
    private Boolean relleno;
    protected Rectangle rectangulo;
    private Boolean esFiguraActual;

    FiguraRellenable(Color colorDePrimerPlano, Color colorDeSegundoPlano, Boolean relleno) {
        super(colorDePrimerPlano);
        this.relleno = relleno;
        this.colorDeSegundoPlano = colorDeSegundoPlano;
        esFiguraActual = true;
        rectangulo = new Rectangle();
    }

    public Rectangle getRectangulo() {
        return rectangulo;
    }

    public void setRectangulo(Rectangle rectangulo) {
        this.rectangulo = rectangulo;
    }

    public Boolean esFiguraActual() {
        return esFiguraActual;
    }

    public void establecerComoFiguraActual(Boolean esFiguraActual) {
        this.esFiguraActual = esFiguraActual;
    }

    public Color getColorDeSegundoPlano() {
        return colorDeSegundoPlano;
    }

    public void setColorDeSegundoPlano(Color colorDeSegundoPlano) {
        this.colorDeSegundoPlano = colorDeSegundoPlano;
    }

    public Boolean getRelleno() {
        return relleno;
    }

    public void setRelleno(Boolean relleno) {
        this.relleno = relleno;
    }

    public void dibujar(Graphics g) {

        int anchura = rectangulo.width;
        int altura = rectangulo.height;
        int x = rectangulo.x;
        int y = rectangulo.y;
        int variacion = 5;

        if (esFiguraActual) {

            g.setColor(Color.black);

            x = anchura < 0 ? x + anchura : x;
            y = altura < 0 ? y + altura : y;
            anchura = Math.abs(anchura);
            altura = Math.abs(altura);
            g.drawRect(x, y, anchura, altura);

            g.setColor(Color.white);
            for (int i = x; i < x + anchura; i += variacion * 2) {
                g.setColor(Color.white);
                g.drawLine(i, y, i + variacion, y);
                g.drawLine(i, y + altura, i + variacion, y + altura);
                /*g.setColor(Color.black);
                g.drawLine(i + variacion, y, i + variacion * 2, y);
                g.drawLine(i + variacion, y + altura, i + variacion * 2, y + altura);*/
            }

            for (int i = y; i < y + altura; i += variacion * 2) {
                g.setColor(Color.white);
                g.drawLine(x, i, x, i + variacion);
                g.drawLine(x + anchura, i, x + anchura, i + variacion);
                /*g.setColor(Color.black);
                g.drawLine(x, i + variacion, x, i + variacion * 2);
                g.drawLine(x + anchura, i + variacion, x + anchura, i + variacion + variacion * 2);*/
            }

            g.setColor(Color.black);
//            for (int i = x; i <= x + anchura; i += anchura / 2) {
//                g.drawRect(i, y, variacion * 2, variacion * 2);
//            }
            g.drawRect(x - variacion / 2, y - variacion / 2, variacion, variacion);
            g.drawRect(x - variacion / 2 + anchura / 2, y - variacion / 2, variacion, variacion);
            g.drawRect(x - variacion / 2 + anchura, y - variacion / 2, variacion, variacion);

            g.drawRect(x - variacion / 2, y - variacion / 2 + altura / 2, variacion, variacion);
            g.drawRect(x - variacion / 2 + anchura, y - variacion / 2 + altura / 2, variacion, variacion);

            g.drawRect(x - variacion / 2, y - variacion / 2 + altura, variacion, variacion);
            g.drawRect(x - variacion / 2 + anchura / 2, y - variacion / 2 + altura, variacion, variacion);
            g.drawRect(x - variacion / 2 + anchura, y - variacion / 2 + altura, variacion, variacion);

        }
    }
}
