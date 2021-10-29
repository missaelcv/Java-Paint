package figuras;

import java.awt.*;

public class Rectangulo extends Figura{
    int x;
    int y;
    int anchura;
    int altura;

    public Rectangulo(Color color, Point puntoInicial) {
        super(color);
        this.x = puntoInicial.x;
        this.y = puntoInicial.y;
        this.anchura = 1;
        this.altura = 1;
    }

    public void actualizar( Point puntoActual ) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y;
    }

    public void dibujar(Graphics g) {
        g.setColor( getColorDePrimerPlano() );
        
        int x = (this.anchura < 0) ? this.x + anchura : this.x;
        int y = (this.altura < 0) ? this.y + altura : this.y;
        
        g.drawRect( x, y, Math.abs( anchura ), Math.abs( altura ) );
    }
}