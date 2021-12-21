package figuras;

import java.awt.*;

public class Quatrebol extends FiguraRellenable {

    Point puntoInicial;
    Point puntoFinal;
    int x;
    int y;
    int anchura;
    int altura;

    public Quatrebol(Color color, Color color2, Boolean relleno, Point puntoInicial) {
        super(color, color2, relleno);
        this.x = puntoInicial.x;
        this.y = puntoInicial.y;
        this.anchura = 1;
        this.altura = 1;
    }

    public void actualizar(Point puntoInicial) {

        this.puntoFinal = puntoFinal;
        this.anchura = puntoInicial.x - x;
        this.altura = puntoInicial.y - y;

    }

    public void dibujar(Graphics g) {

        int x = this.anchura < 0 ? this.x + this.anchura : this.x;
        int y = this.altura < 0 ? this.y + this.altura : this.y;
        int anchura = Math.abs(this.anchura);
        int altura = Math.abs(this.altura);

        if (getRelleno()) {

            g.setColor(getColorDeSegundoPlano());
            g.drawLine(x + anchura / 2, y + altura / 2, x + anchura / 2, y + altura / 2);
            g.fillArc(x + anchura / 4, y, anchura / 2, altura / 2, 0, 360);
            g.fillArc(x, y + altura / 4, anchura / 2, altura / 2, 0, 360);
            g.fillArc(x + anchura / 4, y + altura / 2, anchura / 2, altura / 2, 0, 360);
            g.fillArc(x + anchura / 2, y + altura / 4, anchura / 2, altura / 2, 0, 360);

        }

        g.setColor(getColorDePrimerPlano());
        g.drawArc(x + anchura / 4, y, anchura / 2, altura / 2, 0, 180);
        g.drawArc(x, y + altura / 4, anchura / 2, altura / 2, 90, 180);
        g.drawArc(x + anchura / 4, y + altura / 2, anchura / 2, altura / 2, 180, 180);
        g.drawArc(x + anchura / 2, y + altura / 4, anchura / 2, altura / 2, 90, -180);

        this.setRectangulo(new Rectangle(x, y, anchura, altura));
        super.dibujar(g);
    }
}
