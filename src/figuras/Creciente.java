package figuras;

import java.awt.*;

public class Creciente extends FiguraRellenable {

    Point puntoInicial;
    Point puntoFinal;
    int x;
    int y;
    int anchura;
    int altura;

    public Creciente(Color color, Color color2, Boolean relleno, Point puntoInicial, Point puntoFinal) {
        super(color, color2, relleno);
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
        this.x = puntoInicial.x;
        this.y = puntoInicial.y;
        this.anchura = 1;
        this.altura = 1;
    }

    public Creciente(Color color, Color color2, Boolean relleno, Point puntoInicial) {
        this(color, color2, relleno, puntoInicial, puntoInicial);
    }

    public void actualizar(Point puntoFinal) {
        this.puntoFinal = puntoFinal;
        this.anchura = puntoFinal.x - x;
        this.altura = puntoFinal.y - y;
    }

    public void dibujar(Graphics g) {
        if (puntoInicial != null && puntoFinal != null) {
            /* En espera de algoritmo FloodFill
            if (getRelleno()) {
                g.setColor(getColorDeSegundoPlano());
                g.fillArc(puntoInicial.x, puntoFinal.y, anchura, altura, -197, 210);
            }
             */

            g.setColor(getColorDePrimerPlano());
            g.drawArc(puntoInicial.x, (int) (puntoFinal.y * 0.99), anchura, (int) (altura * 0.8), -170, 160);
            g.drawArc(puntoInicial.x, puntoFinal.y, anchura, altura, -190, 200);
        }
    }
}
