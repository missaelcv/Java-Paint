package figuras;

import java.awt.*;

public class Corazon extends FiguraBordeable {

    int x;
    int y;
    int anchura;
    int altura;

    public Corazon(Color color, Color color2, Boolean relleno, Point puntoInicial, Boolean agregarRectangulo) {
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

        //Puntos de las lineas
        Point punto1 = new Point((int) (x + anchura / 6.71), y + (int) (altura / 1.90));
        Point punto2 = new Point(x + anchura / 2, y + altura);

        Point punto3 = new Point((int) (x + anchura - anchura / 6.71), y + (int) (altura / 1.90));
        Point punto4 = new Point(x + anchura / 2, y + altura);

        if (getRelleno()) {
            g.setColor(getColorDeSegundoPlano());
            Point punto5 = new Point((int) (x + anchura / 2), (int) (y + altura * 0.18));
            g.fillPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto3.x, punto5.x}, new int[]{punto1.y, punto2.y, punto3.y, punto3.y, punto5.y}, 5);
            g.fillArc(x + anchura / 13, y + altura / 10, anchura / 2, altura / 2, 45, 360);
            g.fillArc(x - anchura / 13 + anchura / 2, y + altura / 10, anchura / 2, altura / 2, -45, 360);
        }

        g.setColor(getColorDePrimerPlano());

        //Arcos
        g.drawArc(x + anchura / 13, y + altura / (21 / 2), anchura / 2, altura / 2, 45, 180);
        g.drawArc(x - anchura / 13 + anchura / 2, y + altura / (21 / 2), anchura / 2, altura / 2, -45, 180);

        //Lineas
        g.drawLine(punto1.x, punto1.y, punto2.x, punto2.y);
        g.drawLine(punto3.x, punto3.y, punto4.x, punto4.y);

        if (getAgregarRectangulo()) {
            g.drawRect(x, y, Math.abs(anchura), Math.abs(altura));
        }
    }
}
