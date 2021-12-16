package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class FiguraBordeable extends FiguraRellenable {

    boolean agregarRectangulo;

    FiguraBordeable(Color colorDePrimerPlano, Color colorDeSegundoPlano, Boolean relleno, boolean agregarRectangulo) {
        super(colorDePrimerPlano, colorDeSegundoPlano, relleno);
        this.agregarRectangulo = agregarRectangulo;
    }

    public boolean getAgregarRectangulo() {
        return agregarRectangulo;
    }

    public void setAgregarRectangulo(boolean agregarRectangulo) {
        this.agregarRectangulo = agregarRectangulo;
    }

    public void dibujar(Graphics g, Rectangle rectangulo) {

        int anchura = rectangulo.width;
        int altura = rectangulo.height;
        int x = rectangulo.x;
        int y = rectangulo.y;
        int variacion = 5;

        if (getAgregarRectangulo()) {

            g.setColor(Color.black);
            g.drawRect(x, y, anchura, altura);

            g.setColor(Color.white);
            for (int i = x; i < x + anchura; i += variacion * 2) {
                g.drawLine(i, y, i + variacion, y);
                g.drawLine(i, y + altura, i + variacion, y + altura);
            }

            for (int i = y; i < y + altura; i += variacion * 2) {
                g.drawLine(x, i, x, i + variacion);
                g.drawLine(x + anchura, i, x + anchura, i + variacion);
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
