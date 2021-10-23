package figuras;

import java.awt.*;

public class Ovalo extends Rectangulo {

    Point puntoInicial;
    Point puntoFinal;

    public Ovalo(int x, int y, int anchura, int altura) {
        super(x, y, anchura, altura);
    }

    public Ovalo(Point puntoInicial) {
        super(puntoInicial);
    }

    public void dibujar(Graphics g) {
        int x = this.anchura < 0 ? this.x + this.anchura : this.x;
        int y = this.altura < 0 ? this.y + this.altura : this.y;
        int anchura = Math.abs(this.anchura);
        int altura = Math.abs(this.altura);

        g.setColor(Color.red);
        g.fillOval(x, y, anchura, altura);

        g.setColor(Color.black);
        g.drawOval(x, y, anchura, altura);
    }
}
