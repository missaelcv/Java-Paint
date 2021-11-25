package figuras;

import java.awt.*;

public class SemiCirculo extends Figura {

    Point puntoInicial;
    Point puntoFinal;
    int x;
    int y;
    int anchura;
    int altura;

    public SemiCirculo(Color color, Color color2, Boolean R, Point puntoInicial, Point puntoFinal) {
        super(color, color2, R);
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
        this.x = puntoInicial.x;
        this.y = puntoInicial.y;
        this.anchura = 1;
        this.altura = 1;
    }

    public SemiCirculo(Color color, Color color2, Boolean R, Point puntoInicial) {
        this(color, color2, R, puntoInicial, puntoInicial);
    }

    public void actualizar(Point puntoFinal) {
        this.puntoFinal = puntoFinal;
        this.anchura = puntoFinal.x - x;
        this.altura = puntoFinal.y - y;
    }

    public void dibujar(Graphics g) {
        if (puntoInicial != null && puntoFinal != null) {

            if (getR()) {
                g.setColor(getColorDeSegundoPlano());
                g.fillArc(x, y, anchura, puntoFinal.y, 0, 180);
            }
            g.setColor(getColorDePrimerPlano());
            g.drawLine(puntoInicial.x, ((int) (puntoFinal.y * 0.50) + y), puntoFinal.x, ((int) (puntoFinal.y * 0.50) + y));
            g.drawArc(x, Math.abs(y), anchura, Math.abs(puntoFinal.y) , 0, 180);

        }
    }
}
