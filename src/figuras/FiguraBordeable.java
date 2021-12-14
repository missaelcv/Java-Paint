package figuras;

import java.awt.Color;

public abstract class FiguraBordeable extends FiguraRellenable {

    boolean agregarRectangulo;

    FiguraBordeable(Color colorDePrimerPlano, Color colorDeSegundoPlano, Boolean relleno, boolean agregarRectangulo) {
        super(colorDePrimerPlano, colorDeSegundoPlano, relleno);
        this.agregarRectangulo = agregarRectangulo;
    }

    public boolean getAgregarRectangulo() {
        return agregarRectangulo;
    }

    public void setAgregarRectangulo(boolean agregarRectangulo) {
        this.agregarRectangulo = agregarRectangulo;
    }
}
