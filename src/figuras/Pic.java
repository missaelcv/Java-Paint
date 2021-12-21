package figuras;

import java.awt.*;

public class Pic extends FiguraRellenable {

    Point puntoInicial;
    Point puntoFinal;
    int x;
    int y;
    int anchura;
    int altura;

    public Pic(Color color, Color color2, Boolean relleno, Point puntoInicial) {
        super(color, color2, relleno);
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
        this.x = puntoInicial.x;
        this.y = puntoInicial.y;
        this.anchura = 1;
        this.altura = 1;
    }

    public void actualizar(Point puntoFinal) {
        this.puntoFinal = puntoFinal;
        this.anchura = puntoFinal.x - x;
        this.altura = puntoFinal.y - y;
    }

    public void dibujar(Graphics g) {

        if (getRelleno()) {
            g.setColor(getColorDeSegundoPlano());
            g.fillArc(x, y, anchura, puntoFinal.y, 90, 270);
        }

        g.setColor(getColorDePrimerPlano());
        g.drawLine(puntoInicial.x + anchura / 2, ((int) (puntoFinal.y * 0.50) + y), puntoFinal.x, ((int) (puntoFinal.y * 0.50) + y));
        g.drawLine(puntoInicial.x + anchura / 2, puntoInicial.y, puntoInicial.x + anchura / 2, ((int) (puntoFinal.y * 0.50) + y));
        g.drawArc(x, y, anchura, puntoFinal.y, 90, 270);

        this.setRectangulo(new Rectangle(x, y, anchura, altura));
        super.dibujar(g);
    }
}
