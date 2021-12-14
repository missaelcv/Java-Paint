package figuras;

import java.awt.*;

public class Rombo extends FiguraBordeable {

    int x;
    int y;
    int anchura;
    int altura;

    public Rombo(Color color, Color color2, Boolean relleno, Point puntoInicial, Boolean agregarRectangulo) {
        super(color, color2, relleno, agregarRectangulo);
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
        int x = this.anchura < 0 ? this.x + this.anchura : this.x;
        int y = this.altura < 0 ? this.y + this.altura : this.y;
        int anchura = Math.abs(this.anchura);
        int altura = Math.abs(this.altura);

        Point punto1 = new Point(x, y + altura / 2);
        Point punto2 = new Point(x + anchura / 2, y);
        Point punto3 = new Point(x + anchura, y + altura / 2);
        Point punto4 = new Point(x + anchura / 2, y + altura);

        if (getRelleno()) {
            g.setColor(getColorDeSegundoPlano());
            g.fillPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto4.x}, new int[]{punto1.y, punto2.y, punto3.y, punto4.y}, 4);
        }

        g.setColor(getColorDePrimerPlano());
        g.drawPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto4.x}, new int[]{punto1.y, punto2.y, punto3.y, punto4.y}, 4);

        if (getAgregarRectangulo()) {
            g.drawRect(x, y, Math.abs(anchura), Math.abs(altura));
        }

    }
}
