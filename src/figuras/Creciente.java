package figuras;

import java.awt.*;

public class Creciente extends FiguraRellenable {

    Point puntoInicial;
    Point puntoFinal;
    int x;
    int y;
    int anchura;
    int altura;

    public Creciente(Color color, Color color2, Boolean relleno, Point puntoInicial) {
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
            g.fillArc(x, y, anchura, altura, -190, 200);
        }

        g.setColor(getColorDePrimerPlano());
        g.drawArc(x, (int) (y * 0.99), anchura, (int) (altura * 0.8), -170, 160);
        g.drawArc(x, y, anchura, altura, -193, 203);

        this.setRectangulo(new Rectangle(x, y, anchura, altura));
        super.dibujar(g);
    }
}
