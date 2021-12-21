package figuras;

import java.awt.*;

public class TrianguloEscaleno extends FiguraRellenable {

    int x;
    int y;
    int anchura;
    int altura;

    public TrianguloEscaleno(Color color, Color color2, Boolean relleno, Point puntoInicial) {
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

        Point punto1 = new Point((int) (x + anchura * 0.30), y + altura);
        Point punto2 = new Point(x, y);
        Point punto3 = new Point(x + anchura, y + altura);

        if (getRelleno()) {
            g.setColor(getColorDeSegundoPlano());
            g.fillPolygon(new int[]{punto1.x, punto2.x, punto3.x}, new int[]{punto1.y, punto2.y, punto3.y}, 3);
        }

        g.setColor(getColorDePrimerPlano());
        g.drawPolygon(new int[]{punto1.x, punto2.x, punto3.x}, new int[]{punto1.y, punto2.y, punto3.y}, 3);

        this.setRectangulo(new Rectangle(x, y, anchura, altura));
        super.dibujar(g);
    }
}
