package figuras;

import java.awt.Color;
import java.awt.Graphics;

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
     public void paint(Graphics g)
   {
      g.setColor(new Color(255,0,0));
      g.drawString("Stephanie B. Orihuela",400,100);
      g.drawLine(630,140,600,140);
      g.drawLine(600,140,570,170);
      g.drawLine(570,170,570,190);
      g.drawLine(570,190,590,210);
      g.drawLine(590,210,640,250);
      g.drawLine(640,250,690,210);
      g.drawLine(690,210,710,190);
      g.drawLine(710,190,710,170);
      g.drawLine(710,170,690,140);
      g.drawLine(690,140,660,140);
      g.drawLine(660,140,640,170);
      g.drawLine(640,170,630,140);

   }
    
}
