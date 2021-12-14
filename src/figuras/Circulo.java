package figuras;

import java.awt.*;

public class Circulo extends FiguraBordeable {

    Point puntoInicial;
    Point puntoFinal;
    int x;
    int y;
    int anchura;
    int altura;

    public Circulo(Color color, Color color2, Boolean relleno, Point puntoInicial, Boolean agregarRectangulo) {
        super(color, color2, relleno, agregarRectangulo);
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
        this.x = puntoInicial.x;
        this.y = puntoInicial.y;
        this.anchura = 1;
        this.altura = 1;
    }

    @Override
    public void actualizar(Point puntoFinal) {
        this.puntoFinal = puntoFinal;
        this.anchura = puntoFinal.x - x;
        this.altura = puntoFinal.y - y;
    }

    @Override
    public void dibujar(Graphics g) {
//Esta figura debe ser eliminada
        /*int x = (this.anchura < 0) ? this.x + anchura : this.x;
        int y = (this.altura < 0) ? this.y + altura : this.y;

        if (getRelleno()) {
            g.setColor(getColorDeSegundoPlano());
            g.fillArc(x, y, Math.abs(anchura), y, 0, 360);
        }
        
        if (getAgregarRectangulo()) {
            g.drawRect(x, y, Math.abs(anchura), Math.abs(altura));
        }
        
        g.setColor(getColorDePrimerPlano());
        g.drawArc(x, Math.abs(y), Math.abs(anchura), Math.abs(y), 0, 360);
         */
        System.out.println("Figura en proceso de eliminacion");
    }

}
