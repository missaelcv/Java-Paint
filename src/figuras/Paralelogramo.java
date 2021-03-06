package figuras;

import java.awt.*;

public class Paralelogramo extends FiguraRellenable {

    int x;
    int y;
    int anchura;
    int altura;

    public Paralelogramo(Color color, Color color2, Boolean relleno, Point puntoInicial) {
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

        Point punto1 = new Point((int) (x + anchura * 0.2), y);
        Point punto2 = new Point((int) (x), y + altura);
        Point punto3 = new Point((int) (x + anchura - (anchura * 0.2)), y + altura);
        Point punto4 = new Point(x + anchura, y);

        if (getRelleno()) {
            g.setColor(getColorDeSegundoPlano());
            g.fillPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto4.x}, new int[]{punto1.y, punto2.y, punto3.y, punto4.y}, 4);
        }

        g.setColor(getColorDePrimerPlano());
        g.drawPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto4.x}, new int[]{punto1.y, punto2.y, punto3.y, punto4.y}, 4);

        this.setRectangulo(new Rectangle(x, y, anchura, altura));
        super.dibujar(g);

    }

}
