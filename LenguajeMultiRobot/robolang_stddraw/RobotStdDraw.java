package robolang_stddraw;

public class RobotStdDraw {

	private Posicion posicion;
	private double velocidad;
	private double incremento_tiempo = 0.25;

	public RobotStdDraw () {
		initMundo();

	}
	private void initMundo() {
		posicion = new Posicion();
		velocidad = 0.0;

		double Tam = 5;
		StdDraw.setXscale (0, Tam);
		StdDraw.setYscale (0, Tam);
		StdDraw.setPenRadius (0.005);
		StdDraw.setPenColor (StdDraw.BLUE);
		draw(null, posicion);
		StdDraw.show();
	}

	public void girar(double angulo) {
		System.out.println("Rumbo: " + posicion.rumbo + " angulo: " + angulo);
		posicion.rumbo += angulo;
		posicion.rumbo = normalize(posicion.rumbo);
		System.out.println("Rumbo: " + posicion.rumbo + " angulo: " + angulo);
	}

	public void avanzar(double velocidad, double dist) {
		this.velocidad = velocidad;
		double dist_recorrida = 0.0;
		while(dist_recorrida < dist) {
			double d = this.velocidad * incremento_tiempo; 
			double incx = d * Math.cos(deg2rad(posicion.rumbo));
			double incy = d * Math.sin(deg2rad(posicion.rumbo));
			dist_recorrida += Math.sqrt(incx*incx + incy*incy);
			Posicion anterior = new Posicion();
			anterior.x = posicion.x; anterior.y = posicion.y; anterior.rumbo = posicion.rumbo;
			posicion.x += incx;
			posicion.y += incy;
			draw(anterior, posicion);
		}
	}

	private void draw (Posicion anterior, Posicion actual) {
		if (anterior != null) {
			StdDraw.setPenColor (StdDraw.BLUE);
		    StdDraw.filledCircle(anterior.x+0.5+1, anterior.y+0.5+1, 0.08);
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
	public double deg2rad(double angulo) {
		return angulo*Math.PI / 180.0;
	}
}
