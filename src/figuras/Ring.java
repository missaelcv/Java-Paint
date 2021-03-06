package figuras;

import java.awt.*;

public class Ring extends FiguraRellenable {

    int x;
    int y;
    int anchura;
    int altura;

    public Ring(Color color, Color color2, Boolean relleno, Point puntoInicial) {
        super(color, color2, relleno);
        this.x = puntoInicial.x;
        this.y = puntoInicial.y;
        this.anchura = 1;
        this.altura = 1;
    }

    public void actualizar(Point puntoActual) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y;
    }

    public void dibujar(Graphics g) {

        int x = this.anchura < 0 ? this.x + this.anchura : this.x;
        int y = this.altura < 0 ? this.y + this.altura : this.y;
        int anchura = Math.abs(this.anchura);
        int altura = Math.abs(this.altura);

        if (getRelleno()) {
            g.setColor(getColorDeSegundoPlano());
            g.fillOval(x, y, Math.abs(anchura), Math.abs(altura));
            g.setColor(Color.white);
            if (anchura > 0 && altura > 0) {
                g.fillOval(x + anchura / 4, y + altura / 4, Math.abs(anchura / 2), Math.abs(altura / 2));
            } else if (anchura < 0 && altura > 0) {
                g.fillOval((int) (x - (anchura * 0.25)), y + altura / 4, Math.abs((int) (anchura * 0.50)), Math.abs(altura / 2));
            } else if (anchura > 0 && altura < 0) {
                g.fillOval((int) (x + (anchura * 0.25)), y - altura / 4, Math.abs((int) (anchura * 0.50)), Math.abs(altura / 2));
            } else if (anchura > 0 && altura < 0) {
                g.fillOval((int) (x + (anchura * 0.25)), y - altura / 4, Math.abs((int) (anchura * 0.50)), Math.abs(altura / 2));
            } else if (anchura < 0 && altura < 0) {
                g.fillOval((int) (x - (anchura * 0.25)), y - altura / 4, Math.abs((int) (anchura * 0.50)), Math.abs(altura / 2));
            }

        }

        g.setColor(getColorDePrimerPlano());
        g.drawOval(x, y, Math.abs(anchura), Math.abs(altura));

        if (anchura > 0 && altura > 0) {
            g.drawOval(x + anchura / 4, y + altura / 4, Math.abs(anchura / 2), Math.abs(altura / 2));
        } else if (anchura < 0 && altura > 0) {
            g.drawOval((int) (x - (anchura * 0.25)), y + altura / 4, Math.abs((int) (anchura * 0.50)), Math.abs(altura / 2));
        } else if (anchura > 0 && altura < 0) {
            g.drawOval((int) (x + (anchura * 0.25)), y - altura / 4, Math.abs((int) (anchura * 0.50)), Math.abs(altura / 2));
        } else if (anchura > 0 && altura < 0) {
            g.drawOval((int) (x + (anchura * 0.25)), y - altura / 4, Math.abs((int) (anchura * 0.50)), Math.abs(altura / 2));
        } else if (anchura < 0 && altura < 0) {
            g.drawOval((int) (x - (anchura * 0.25)), y - altura / 4, Math.abs((int) (anchura * 0.50)), Math.abs(altura / 2));
        }

        this.setRectangulo(new Rectangle(x, y, anchura, altura));
        super.dibujar(g);
    }
}
