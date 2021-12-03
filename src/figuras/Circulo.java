package figuras;

import java.awt.*;

public class Circulo extends FiguraRellenable {

    Point puntoInicial;
    Point puntoFinal;
    int x;
    int y;
    int anchura;
    int altura;

    public Circulo(Color color, Color color2, Boolean relleno, Point puntoInicial, Point puntoFinal) {
        super(color, color2, relleno);
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
        this.x = puntoInicial.x;
        this.y = puntoInicial.y;
        this.anchura = 1;
        this.altura = 1;
    }

    public Circulo(Color color, Color color2, Boolean R, Point puntoInicial) {
        this(color, color2, R, puntoInicial, puntoInicial);
    }

    @Override
    public void actualizar(Point puntoFinal) {
        this.puntoFinal = puntoFinal;
        this.anchura = puntoFinal.x - x;
        this.altura = puntoFinal.y - y;
    }

    @Override
    public void dibujar(Graphics g) {

        int x = (this.anchura < 0) ? this.x + anchura : this.x;
        int y = (this.altura < 0) ? this.y + altura : this.y;

        if (getRelleno()) {
            g.setColor(getColorDeSegundoPlano());
            g.fillArc(x, y, Math.abs(anchura), puntoFinal.y, 0, 360);
        }
        g.setColor(getColorDePrimerPlano());

        g.drawArc(x, Math.abs(y), Math.abs(anchura), Math.abs(puntoFinal.y), 0, 360);

    }

}
