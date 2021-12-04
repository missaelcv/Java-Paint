package figuras;

import java.awt.*;

public abstract class Figura {

    private Color colorDePrimerPlano;

    Figura(Color colorDePrimerPlano) {
        this.colorDePrimerPlano = colorDePrimerPlano;
    }

    public abstract void actualizar(Point puntoFinal);

    public abstract void dibujar(Graphics g);

    public Color getColorDePrimerPlano() {
        return colorDePrimerPlano;
    }

    public void setColorDePrimerPlano(Color colorDePrimerPlano) {
        this.colorDePrimerPlano = colorDePrimerPlano;
    }

}
