package figuras;

import java.awt.Color;

public abstract class FiguraRellenable extends Figura {

    private Color colorDeSegundoPlano;
    private Boolean relleno;

    FiguraRellenable(Color colorDePrimerPlano, Color colorDeSegundoPlano, Boolean relleno) {
        super(colorDePrimerPlano);
        this.relleno = relleno;
        this.colorDeSegundoPlano = colorDeSegundoPlano;
    }

    public Color getColorDeSegundoPlano() {
        return colorDeSegundoPlano;
    }

    public void setColorDeSegundoPlano(Color colorDeSegundoPlano) {
        this.colorDeSegundoPlano = colorDeSegundoPlano;
    }

    public Boolean getRelleno() {
        return relleno;
    }

    public void setRelleno(Boolean relleno) {
        this.relleno = relleno;
    }
}
