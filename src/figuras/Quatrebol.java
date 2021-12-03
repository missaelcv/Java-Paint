package figuras;

import java.awt.*;

public class Quatrebol extends FiguraRellenable {

    Point puntoInicial;
    Point puntoFinal;
    int x;
    int y;
    int anchura;
    int altura;

    public Quatrebol(Color color, Color color2, Boolean relleno, Point puntoInicial, Point puntoFinal) {
        super(color, color2, relleno);
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
        this.x = puntoInicial.x;
        this.y = puntoInicial.y;
        this.anchura = 1;
        this.altura = 1;
    }

    public Quatrebol(Color color, Color color2, Boolean relleno, Point puntoInicial) {
        this(color, color2, relleno, puntoInicial, puntoInicial);
    }

    public void actualizar(Point puntoFinal) {
        this.puntoFinal = puntoFinal;
        this.anchura = puntoFinal.x - x;
        this.altura = puntoFinal.y - y;
    }

    public void dibujar(Graphics g) {
        if (puntoInicial != null && puntoFinal != null) {

            if (getRelleno()) {
                g.setColor(getColorDeSegundoPlano());
                g.fillRect((int) (puntoInicial.x + anchura * 0.50), (int) (puntoFinal.y + altura * 0.50), anchura + 5, altura + 5);
                g.fillArc(puntoInicial.x + anchura / 2, puntoFinal.y, anchura, altura, 0, 180);
                g.fillArc(puntoInicial.x, puntoFinal.y + altura / 2, anchura, altura, 90, 180);
                g.fillArc(puntoInicial.x + anchura / 2, puntoFinal.y + altura, anchura, altura, 180, 180);
                g.fillArc(puntoInicial.x + anchura, puntoFinal.y + altura / 2, anchura, altura, 90, -180);
            }

            g.setColor(getColorDePrimerPlano());
            g.drawArc(puntoInicial.x + anchura / 2, puntoFinal.y, anchura, altura, 0, 180);
            g.drawArc(puntoInicial.x, puntoFinal.y + altura / 2, anchura, altura, 90, 180);
            g.drawArc(puntoInicial.x + anchura / 2, puntoFinal.y + altura, anchura, altura, 180, 180);
            g.drawArc(puntoInicial.x + anchura, puntoFinal.y + altura / 2, anchura, altura, 90, -180);

        }
    }
}
