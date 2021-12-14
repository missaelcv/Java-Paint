package figuras;

import java.awt.*;

public class Trebol extends FiguraBordeable {

    Point puntoInicial;
    Point puntoFinal;
    int x;
    int y;
    int anchura;
    int altura;

    public Trebol(Color color, Color color2, Boolean relleno, Point puntoInicial, Boolean agregarRectangulo) {
        super(color, color2, relleno, agregarRectangulo);
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
        this.x = puntoInicial.x;
        this.y = puntoInicial.y;
        this.anchura = 1;
        this.altura = 1;
    }

    public void actualizar(Point puntoFinal) {
        this.puntoFinal = puntoFinal;
        this.anchura = puntoFinal.x - x;
        this.altura = puntoFinal.y - y;
    }

    public void dibujar(Graphics g) {
        if (puntoInicial != null && puntoFinal != null) {

            //Agregando el Relleno de Figura Trebol Final 
            if (getRelleno()) {
                g.setColor(getColorDeSegundoPlano());

                g.fillArc(puntoInicial.x + anchura / 2, puntoFinal.y, anchura, altura, -5, 360);
                g.fillArc((int) (puntoInicial.x + anchura * 0.030), (int) (puntoFinal.y + altura * 0.55), anchura, altura, 93, 360);
                g.fillArc((int) (puntoInicial.x + anchura * 0.970), (int) (puntoFinal.y + altura * 0.55), anchura, altura, 88, -360);
            }

            g.setColor(getColorDePrimerPlano());
            g.drawArc(puntoInicial.x + anchura / 2, puntoFinal.y, anchura, altura, -5, 190);
            g.drawArc((int) (puntoInicial.x + anchura * 0.030), (int) (puntoFinal.y + altura * 0.55), anchura, altura, 93, 247);
            g.drawArc((int) (puntoInicial.x + anchura * 0.970), (int) (puntoFinal.y + altura * 0.55), anchura, altura, 88, -250);

            if (getAgregarRectangulo()) {
                g.drawRect(x, y, Math.abs(anchura), Math.abs(altura));
            }
        }
    }
}
