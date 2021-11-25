package figuras;

import java.awt.*;

public class Estrella extends Figura {

    int x;
    int y;
    int anchura;
    int altura;

    public Estrella(Color color, Color color2, Boolean R, Point puntoInicial) {
        super(color, color2, R);
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

        Point punto1 = new Point(x, y);
        Point punto2 = new Point((int) (x + (anchura * 0.45)), (int) (y + (altura * 0.30)));
        Point punto3 = new Point((int) (x + anchura), (int) (y + (altura * 0.30)));
        Point punto4 = new Point((int) (x + (anchura * 0.55)), (int) (y + (altura * 0.55)));
        Point punto5 = new Point((int) (x + (anchura * 0.80)), (int) (y + altura));
        Point punto6 = new Point(x, (int) (y + (altura * 0.75)));
        Point punto7 = new Point((int) (x - (anchura * 0.80)), (int) (y + altura));
        Point punto8 = new Point((int) (x - (anchura * 0.55)), (int) (y + (altura * 0.55)));
        Point punto9 = new Point((int) (x - anchura), (int) (y + altura - (altura * 0.70)));
        Point punto10 = new Point((int) (x - (anchura * 0.45)), (int) (y + (altura * 0.30)));

        if (getR()) {
            g.setColor(getColorDeSegundoPlano());
            g.fillPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto4.x, punto5.x, punto6.x, punto7.x, punto8.x, punto9.x, punto10.x}, new int[]{punto1.y, punto2.y, punto3.y, punto4.y, punto5.y, punto6.y, punto7.y, punto8.y, punto9.y, punto10.y}, 10);
        }

        g.setColor(getColorDePrimerPlano());
        g.drawPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto4.x, punto5.x, punto6.x, punto7.x, punto8.x, punto9.x, punto10.x}, new int[]{punto1.y, punto2.y, punto3.y, punto4.y, punto5.y, punto6.y, punto7.y, punto8.y, punto9.y, punto10.y}, 10);

    }
}
