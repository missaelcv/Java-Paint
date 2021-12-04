package figuras;

import java.awt.*;
import java.util.ArrayList;

public class DibujoLibre extends Figura {

    ArrayList<Point> puntos;

    public DibujoLibre(Color color, Point puntoActual) {
        super(color);
        puntos = new ArrayList<>();
        puntos.add(puntoActual);
    }

    public void actualizar(Point puntoActual) {
        puntos.add(puntoActual);
    }

    public void dibujar(Graphics g) {
        g.setColor(getColorDePrimerPlano());

        if (!puntos.isEmpty()) {
            if (puntos.size() == 1) {
                g.drawLine(puntos.get(0).x, puntos.get(0).y, puntos.get(0).x, puntos.get(0).y);
            } else {
                for (int i = 1; i < puntos.size(); i++) {
                    g.drawLine(puntos.get(i - 1).x, puntos.get(i - 1).y, puntos.get(i).x, puntos.get(i).y);
                }
            }
        }
    }
}
