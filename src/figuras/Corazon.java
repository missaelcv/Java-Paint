package figuras;

import java.awt.*;

public class Corazon extends FiguraRellenable {

    int x;
    int y;
    int anchura;
    int altura;

    public Corazon(Color color, Color color2, Boolean relleno, Point puntoInicial) {
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

        //Puntos de las lineas
        Point punto1 = new Point((int) (x + anchura / 20), y + (int) (altura / 2.50));
        Point punto2 = new Point(x + anchura / 2, y + altura);

        Point punto3 = new Point((int) (x + anchura - anchura / 20), y + (int) (altura / 2.50));
        Point punto4 = new Point(x + anchura / 2, y + altura);

        if (getRelleno()) {
            g.setColor(getColorDeSegundoPlano());
            Point punto5 = new Point((int) (x + anchura / 2), (int) (y + altura * 0.20));
            g.fillPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto3.x, punto5.x}, new int[]{punto1.y, punto2.y, punto3.y, punto3.y, punto5.y}, 5);
            g.fillArc(x, y, anchura / 2, altura / 2, 10, 360);
            g.fillArc((int) (x + anchura * 0.5), y, anchura / 2, altura / 2, -40, 360);
        }

        g.setColor(getColorDePrimerPlano());

        //Arcos
        g.drawArc(x, y, anchura / 2, altura / 2, 5, 212);
        g.drawArc((int) (x + anchura * 0.5), y, anchura / 2, altura / 2, -35, 210);

        //Lineas
        g.drawLine(punto1.x, punto1.y, punto2.x, punto2.y);
        g.drawLine(punto3.x, punto3.y, punto4.x, punto4.y);

        this.setRectangulo(new Rectangle(x, y, anchura, altura));
        super.dibujar(g);

    }
}
