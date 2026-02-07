package robolang_stddraw;

import java.util.ArrayList;

public class RobotStdDraw {

	private Posicion posicion;
	private double velocidad;
	private double incremento_tiempo = 0.15;
	private double scale = 0.5;
	private ArrayList<Posicion> posiciones = new ArrayList<Posicion>();

	public RobotStdDraw() {
		initMundo();

	}

	private void initMundo() {
		posicion = new Posicion();
		velocidad = 0.0;
		posiciones.add(posicion);
		double Tam = 5;
		StdDraw.setTitle("RobotStdDraw ejecutando RoboLang");
		StdDraw.setXscale(0, Tam);
		StdDraw.setYscale(0, Tam);
		StdDraw.setPenRadius(0.005);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.enableDoubleBuffering();
		StdDraw.picture(posicion.x + 0.5 + 1, posicion.y + 0.5 + 1, "img/coche.png", scale, scale, posicion.rumbo);
		StdDraw.show();
	}

	public void girar(double angulo) {
		posicion.rumbo += angulo;
		posicion.rumbo = normalize(posicion.rumbo);
	}

	public void avanzar(double velocidad, double dist) {
		this.velocidad = velocidad;
		double dist_recorrida = 0.0;
		while (dist_recorrida < dist) {
			StdDraw.clear();
			double d = this.velocidad * incremento_tiempo;
			double incx = d * Math.cos(deg2rad(posicion.rumbo));
			double incy = d * Math.sin(deg2rad(posicion.rumbo));

			posicion.x += incx;
			posicion.y += incy;
			posiciones.add(new Posicion(posicion.x, posicion.y, posicion.rumbo)); // ← Copia!

			dist_recorrida += Math.sqrt(incx * incx + incy * incy);

			StdDraw.setPenColor(StdDraw.GRAY);
			for (int i = 0; i < posiciones.size() - 1; i++) { 
				Posicion origen = posiciones.get(i);
				Posicion fin = posiciones.get(i + 1);
				//StdDraw.line(origen.x + 0.5 + 1, origen.y + 0.5 + 1, fin.x + 0.5 + 1, fin.y + 0.5 + 1);
				StdDraw.filledCircle(origen.x + 0.5 + 1, origen.y + 0.5 + 1, 0.02);
			}

			// Robot actual
			StdDraw.picture(posicion.x + 0.5 + 1, posicion.y + 0.5 + 1,
					"img/coche.png", scale, scale, posicion.rumbo);

			StdDraw.show();
			StdDraw.pause(100); // Más rápido para animación suave
		}
	}

	private void draw(Posicion anterior, Posicion actual) {
		double scale = 0.35;
		if (anterior != null) {
			StdDraw.picture(anterior.x + 0.5 + 1, anterior.y + 0.5 + 1, "img/coche_vacio.png", scale, scale,
					anterior.rumbo);
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.filledCircle(anterior.x + 0.5 + 1, anterior.y + 0.5 + 1, 0.04);
			int anteultima_posicion = posiciones.size() - 2;
			if (anteultima_posicion > 0) {
				Posicion anteultimo = posiciones.get(anteultima_posicion);
				StdDraw.line(anteultimo.x + 0.5 + 1, anteultimo.y + 0.5 + 1, anterior.x + 0.5 + 1, anterior.y + 0.5 + 1);
			}
		} else {
			StdDraw.setPenColor(StdDraw.ORANGE);
			StdDraw.filledCircle(actual.x + 0.5 + 1, actual.y + 0.5 + 1, 0.12);
		}
		StdDraw.picture(actual.x + 0.5 + 1, actual.y + 0.5 + 1, "img/coche.png", scale, scale, actual.rumbo);
	}

	private void draw_old(Posicion anterior, Posicion actual) {
		if (anterior != null) {
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.filledCircle(anterior.x + 0.5 + 1, anterior.y + 0.5 + 1, 0.08);
		} else {
			StdDraw.setPenColor(StdDraw.ORANGE);
			StdDraw.filledCircle(actual.x + 0.5 + 1, actual.y + 0.5 + 1, 0.12);
		}
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.filledCircle(actual.x + 0.5 + 1, actual.y + 0.5 + 1, 0.08);
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
		return angulo * Math.PI / 180.0;
	}
}
