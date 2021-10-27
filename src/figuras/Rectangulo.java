package figuras;

import java.awt.*;

public class Rectangulo extends Figura {

    int x;
    int y;
    int anchura;
    int altura;

    public Rectangulo(int x, int y, int anchura, int altura) {
        this.x = x;
        this.y = y;
        this.anchura = anchura;
        this.altura = altura;
    }

    public Rectangulo(Point puntoInicial) {
        this(puntoInicial.x, puntoInicial.y,1,1);
    }

    public void actualizar(Point puntoActual) {
        this.anchura = puntoActual.x - x;
        this.altura = puntoActual.y - y;
    }
    
    //Esto es facil (si se sabe). 
    //Agramonte.

    public void dibujar(Graphics g) {
        
        int x = this.anchura < 0 ? this.x + this.anchura : this.x;
        int y = this.altura < 0 ? this.y + this.altura : this.y;
        int anchura = Math.abs(this.anchura);
        int altura = Math.abs(this.altura);

        g.setColor(Color.red);
        g.fillRect(x, y, anchura, altura);

        g.setColor(Color.black);
        g.drawRect(x, y, anchura, altura);
    }
}