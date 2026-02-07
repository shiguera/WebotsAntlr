package robolang_stddraw;

public class Posicion {
    public double x, y, rumbo;

    public Posicion() {
        x = 0.0;
        y = 0.0;
        rumbo = 0.0;
    }
    public Posicion(double x, double y, double rumbo) {
        this.x = x;
        this.y = y;
        this.rumbo = rumbo;
    }
}
