package figuras;

import java.awt.*;

public class Quatrebol extends FiguraBordeable {

    Point puntoInicial;
    Point puntoFinal;
    int x;
    int y;
    int anchura;
    int altura;

    public Quatrebol(Color color, Color color2, Boolean relleno, Point puntoInicial, Boolean agregarRectangulo) {
        super(color, color2, relleno, agregarRectangulo);
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
            g.fillRect((int) (x + anchura * 0.50), (int) (y + altura * 0.50), anchura + 5, altura + 5);
            g.fillArc(x + anchura / 2, y, anchura, altura, 0, 180);
            g.fillArc(x, y + altura / 2, anchura, altura, 90, 180);
            g.fillArc(x + anchura / 2, y + altura, anchura, altura, 180, 180);
            g.fillArc(x + anchura, y + altura / 2, anchura, altura, 90, -180);

        }

        g.setColor(getColorDePrimerPlano());
        g.drawArc(x + anchura / 2, y, anchura, altura, 0, 180);
        g.drawArc(x, y + altura / 2, anchura, altura, 90, 180);
        g.drawArc(x + anchura / 2, y + altura, anchura, altura, 180, 180);
        g.drawArc(x + anchura, y + altura / 2, anchura, altura, 90, -180);

        if (getAgregarRectangulo()) {
            g.drawRect(x, y, Math.abs(anchura), Math.abs(altura));
        }
    }
}
