package robolang_consola;

import java.util.Locale;

/**
 * Este robot gestiona su posición (x,y) y el rumbo hacia el que está apuntando,
 * medido en grados sexagesimales.
 */
public class RobotConsola {

    double rumbo;
    double x, y;
    double inc_tiempo = 1;
    int milisegundos_pausa = 500;

    public RobotConsola() {
        this.rumbo = 0.0;
        this.x = 0.0;
        this.y = 0.0;
    }

    public void hacerGiro(double angulo) {
        System.out.printf("   --- hacerGiro(%.2f): \n", angulo);
        rumbo += angulo;
        rumbo = normalize(rumbo);
        pausa();
        System.out.println("   --- Nueva posición: " + this.toString());
    }

    public void hacerAvance(double v, double d) {
        System.out.printf("   --- hacerAvance(%.2f, %.2f): ", v, d);
        double dist_recorrida = 0;
        while (dist_recorrida < d) {
            double d_parcial = v * inc_tiempo; // d_parcial = v*t
            dist_recorrida += d_parcial;
            double incx = d_parcial * Math.cos(deg2rad(rumbo));
            x += incx;
            double incy = d_parcial * Math.sin(deg2rad(rumbo));
            y += incy;
            System.out.print("\uD83D\uDE97 ");
            pausa();
        }
        System.out.println("\n   --- Nueva posición: " + this.toString());

    }

    private void pausa() {
        try {
            Thread.sleep(milisegundos_pausa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "(%.2f, %.2f, %.2f)", x, y, rumbo);
    }

    public double normalize(double angulo) {
        double dosPi = 360.0;
        // Hacer el módulo usando el valor absoluto de 360
        angulo = angulo % dosPi;
        // Si el resultado es negativo, lo llevamos al rango [0, 360)
        if (angulo < 0) {
            angulo += dosPi;
        }
        return angulo;
    }

    public double deg2rad(double angulo) {
        return angulo * Math.PI / 180.0;
    }
}
