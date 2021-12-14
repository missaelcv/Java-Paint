package figuras;

import java.awt.*;

public class Poligono extends FiguraBordeable {

    int x;
    int y;
    int anchura;
    int altura;

    public Poligono(Color color, Color color2, Boolean relleno, Point puntoInicial, Boolean agregarRectangulo) {
        super(color, color2, relleno, agregarRectangulo);
        this.x = puntoInicial.x;
        this.y = puntoInicial.y;
        this.anchura = 1;
        this.altura = 1;
    }

    @Override
    public void actualizar(Point puntoActual) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y;
    }

    @Override
    public void dibujar(Graphics g) {
        int x = this.anchura < 0 ? this.x + this.anchura : this.x;
        int y = this.altura < 0 ? this.y + this.altura : this.y;
        int anchura = Math.abs(this.anchura);
        int altura = Math.abs(this.altura);

        Point punto1 = new Point(x, (int) (y - altura * 0.65));
        Point punto2 = new Point((int) (x + (anchura / 1.5)), y - altura);
        Point punto3 = new Point(x + anchura, (int) (y - altura * 0.50));
        Point punto4 = new Point((int) (x + (anchura / 1.35)), (int) (y + (altura / 10)));
        Point punto5 = new Point(x + anchura, (int) (y + (altura * 0.80)));
        Point punto6 = new Point((int) (x + (anchura / 3)), y + altura);
        Point punto7 = new Point((int) (x - (anchura / 7)), (int) (y + (altura * 0.60)));

        if (getRelleno()) {
            g.setColor(getColorDeSegundoPlano());
            g.fillPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto4.x, punto5.x, punto6.x, punto7.x}, new int[]{punto1.y, punto2.y, punto3.y, punto4.y, punto5.y, punto6.y, punto7.y}, 7);
        }

        g.setColor(getColorDePrimerPlano());
        g.drawPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto4.x, punto5.x, punto6.x, punto7.x}, new int[]{punto1.y, punto2.y, punto3.y, punto4.y, punto5.y, punto6.y, punto7.y}, 7);

        if (getAgregarRectangulo()) {
            g.drawRect(x, y, Math.abs(anchura), Math.abs(altura));
        }

    }

}
