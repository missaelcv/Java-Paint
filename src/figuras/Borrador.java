package figuras;

import java.awt.*;

public class Borrador extends DibujoLibre {

    public Borrador(Color color,Color color2, Boolean R, Point puntoActual) {
        super(color,color, R, puntoActual);
    }

    @Override
    public void dibujar(Graphics g) {
        super.dibujar(g);

        g.setColor(Color.WHITE);

        int anchura = 20;

        if (!puntos.isEmpty()) {
            if (puntos.size() == 1) {
                g.fillRect(puntos.get(0).x - anchura / 2, puntos.get(0).y - anchura / 2, anchura, anchura);
            } else {
                for (int i = 1; i < puntos.size(); i++) {
                    Point punto1 = new Point(puntos.get(i - 1).x - anchura / 2, puntos.get(i - 1).y - anchura / 2),
                            punto2 = new Point(puntos.get(i).x - anchura / 2, puntos.get(i).y - anchura / 2),
                            punto3 = new Point(punto2.x + anchura, punto2.y + anchura),
                            punto4 = new Point(punto1.x + anchura, punto1.y + anchura),
                            punto5 = new Point(punto1.x, punto1.y + anchura),
                            punto6 = new Point(punto2.x, punto2.y + anchura),
                            punto7 = new Point(punto2.x + anchura, punto2.y),
                            punto8 = new Point(punto1.x + anchura, punto1.y);

                    g.fillRect(punto1.x, punto1.y, anchura, anchura);
                    int[] puntosX = {punto1.x, punto2.x, punto3.x, punto4.x};
                    int[] puntosY = {punto1.y, punto2.y, punto3.y, punto4.y};
                    g.fillPolygon(puntosX, puntosY, 4);

                    puntosX = new int[]{punto5.x, punto6.x, punto7.x, punto8.x};
                    puntosY = new int[]{punto5.y, punto6.y, punto7.y, punto8.y};
                    g.fillPolygon(puntosX, puntosY, 4);

                    g.fillRect(punto2.x, punto2.y, anchura, anchura);
                }
            }
        }
    }

}
