package figuras;

import java.awt.*;

public class Linea extends Figura {

    Point puntoInicial;
    Point puntoFinal;

    public Linea(Color color,Color color2, Boolean R, Point puntoInicial, Point puntoFinal) {
        super(color,color2, R);
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
    }

    public Linea(Color color,Color color2, Boolean R, Point puntoInicial) {
        this(color,color2, R, puntoInicial, puntoInicial);
    }

    public void actualizar(Point puntoFinal) {
        this.puntoFinal = puntoFinal;
    }

    public void dibujar(Graphics g) {
        if (puntoInicial != null && puntoFinal != null) {
            g.setColor(getColorDePrimerPlano());
            g.drawLine(puntoInicial.x, puntoInicial.y, puntoFinal.x, puntoFinal.y);
        }
    }
}
