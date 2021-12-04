package figuras;

import java.awt.*;

public class Ovalo extends FiguraRellenable {

    int x;
    int y;
    int anchura;
    int altura;

    public Ovalo(Color color, Color color2, Boolean relleno, Point puntoInicial) {
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

        int x = (this.anchura < 0) ? this.x + anchura : this.x;
        int y = (this.altura < 0) ? this.y + altura : this.y;

        if (getRelleno()) {
            g.setColor(getColorDeSegundoPlano());
            g.fillOval(x, y, Math.abs(anchura), Math.abs(altura));
        }

        g.setColor(getColorDePrimerPlano());
        g.drawOval(x, y, Math.abs(anchura), Math.abs(altura));

    }
}
