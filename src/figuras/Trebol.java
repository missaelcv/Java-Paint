package figuras;

import java.awt.*;

public class Trebol extends FiguraBordeable {

    Point puntoInicial;
    Point puntoFinal;
    int x;
    int y;
    int anchura;
    int altura;

    public Trebol(Color color, Color color2, Boolean relleno, Point puntoInicial, Boolean agregarRectangulo) {
        super(color, color2, relleno, agregarRectangulo);
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

        int x = this.anchura < 0 ? this.x + this.anchura : this.x;
        int y = this.altura < 0 ? this.y + this.altura : this.y;
        int anchura = Math.abs(this.anchura);
        int altura = Math.abs(this.altura);

        //Agregando el Relleno de Figura Trebol Final 
        if (getRelleno()) {
            g.setColor(getColorDeSegundoPlano());

            g.fillArc(x + anchura / 4, y, anchura / 2, (int) (altura / 1.20), 0, 360);
            g.fillArc(x, (int) (y + altura / 2.6), (int) (anchura / 1.8), (int) (altura / 1.6), 0, 360);
            g.fillArc((int) (x + anchura / 2.2), (int) (y + altura / 2.6), (int) (anchura / 1.8), (int) (altura / 1.6), 0, 360);
        }

        g.setColor(getColorDePrimerPlano());
        g.drawArc(x + anchura / 4, y, anchura / 2, (int) (altura / 1.20), 5, 174);
        g.drawArc(x, (int) (y + altura / 2.6), (int) (anchura / 1.8), (int) (altura / 1.6), 93, 237);
        g.drawArc((int) (x + anchura / 2.2), (int) (y + altura / 2.6), (int) (anchura / 1.8), (int) (altura / 1.6), 89, -241);

        if (getAgregarRectangulo()) {
            g.drawRect(x, y, Math.abs(anchura), Math.abs(altura));
        }

    }
}
