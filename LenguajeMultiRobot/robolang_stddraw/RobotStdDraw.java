package robolang_stddraw;

public class RobotStdDraw {

	private Posicion posicion;
	private double velocidad = 0.25;

	public RobotStdDraw () {
		initMundo();

	}
	private void initMundo() {
		double Tam = 5;
		StdDraw.setXscale (0, Tam);
		StdDraw.setYscale (0, Tam);
		StdDraw.setPenRadius (0.005);
		StdDraw.setPenColor (StdDraw.BLUE);
		posicion = new Posicion();
		draw(null, posicion);
		StdDraw.show();
	}

	public void girar(double angulo) {
		posicion.rumbo += angulo;
		posicion.rumbo = normalize(posicion.rumbo);
	}

	public void avanzar(double dist) {
		double dist_recorrida = 0.0;
		while(dist_recorrida < dist) {
			double incx = velocidad * Math.cos(posicion.rumbo);
			double incy = velocidad * Math.sin(posicion.rumbo);
			dist_recorrida += Math.sqrt(incx*incx + incy*incy);
			Posicion anterior = posicion;
			posicion.x += incx;
			posicion.y += incy;
			draw(anterior, posicion);
		}
	}

	private void draw (Posicion anterior, Posicion actual) {
		if (anterior != null) {
			StdDraw.setPenColor (StdDraw.BLUE);
		    StdDraw.filledCircle (anterior.x+0.5+1, anterior.y+0.5+1, 0.08);
		}
		else {
			StdDraw.setPenColor (StdDraw.ORANGE);
		    StdDraw.filledCircle (actual.x+0.5+1, actual.y+0.5+1, 0.12);
		}
		StdDraw.setPenColor (StdDraw.GREEN);
		StdDraw.filledCircle (actual.x+0.5+1, actual.y+0.5+1, 0.08);
		StdDraw.pause(1000);
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
}
