package figuras;

import java.awt.*;

public class Hexagono extends FiguraRellenable {

    int x;
    int y;
    int anchura;
    int altura;

    public Hexagono(Color color, Color color2, Boolean relleno, Point puntoInicial) {
        super(color, color2, relleno);
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

        Point punto1 = new Point(x, (int) (y - altura * 0.50));
        Point punto2 = new Point((int) (x + (anchura / 2)), y - altura);
        Point punto3 = new Point(x + anchura, (int) (y - altura * 0.50));
        Point punto4 = new Point(x + anchura, (int) (y + (altura * 0.50)));
        Point punto5 = new Point((int) (x + (anchura / 2)), y + altura);
        Point punto6 = new Point(x, (int) (y + (altura * 0.50)));

        if (getRelleno()) {
            g.setColor(getColorDeSegundoPlano());
            g.fillPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto4.x, punto5.x, punto6.x},
            new int[]{punto1.y, punto2.y, punto3.y, punto4.y, punto5.y, punto6.y}, 6);
        }

        g.setColor(getColorDePrimerPlano());
        g.drawPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto4.x, punto5.x, punto6.x},
            new int[]{punto1.y, punto2.y, punto3.y, punto4.y, punto5.y, punto6.y}, 6);

        this.setRectangulo(new Rectangle(x, y, anchura, altura));
        super.dibujar(g);
    }
}
