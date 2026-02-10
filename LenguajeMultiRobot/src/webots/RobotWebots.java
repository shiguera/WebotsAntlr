package webots;

import com.cyberbotics.webots.controller.Robot;
import com.cyberbotics.webots.controller.Compass;
import com.cyberbotics.webots.controller.DistanceSensor;
import com.cyberbotics.webots.controller.GPS;
import com.cyberbotics.webots.controller.Motor;
import com.cyberbotics.webots.controller.Pen;

/**
 * Vehículo terrestre simple con 4 ruedas-motor y los siguientes sensores:
 * - 2 DistanceSensor en la parte delantera, uno a la izquierda y otro a la
 * derecha.
 * - 1 Compass
 * - 1 GPS
 * - 1 Pen
 */
public class RobotWebots extends Robot {
	/**
	 * Valor máximo para que los DistanceSensor indiquen que
	 * detectan un obstáculo.
	 */
	protected double OBSTACLE_DISTANCE=950.0;

	/**
	 * Máxima velocidad de los motores de las ruedas.
	 */
	protected double maxVelocity = 10.0;
	/**
	 * Intervalo de tiempo utilizado en la simulación. Lo fija el Controller y lo recibe
	 * el vehículo a través del constructor. Tiene que ser una potencia de 2. Valores menores de 32
	 * dan lugar a errores de cálculo. Se mide en milisegundos.
	 */
	protected int timeStep;
	/**
	 * Sensores de distancia del vehículo. Tiene 2 en la parte delantera.
	 */
	protected DistanceSensor[] ds;
	/**
	 * Motores de las 4 ruedas
	 */
	protected Motor[] wheels;
	/**
	 * Indica la dirección en la que está orientado el vehículo.
	 */
	protected Compass compass;
	/**
	 * Proporciona las coordenadas del vehículo.
	 */
	protected GPS gps;
	/**
	 * Permite escribir una línea mientras se mueve el vehículo.
	 */
	protected Pen pen;

	/**
	 * Constructor. Se invoca desde el Controller y necesita como argumento el 
	 * intervalo de la simulación en milisegundos.
	 * @param timeStep
	 */
	public RobotWebots(int timeStep) {
		this.timeStep = timeStep;
		initSensors();
		initMotors();
		step();
	}
	/**
	 * Inicializa los sensores del vehículo.
	 */
	protected void initSensors() {
		ds = new DistanceSensor[2];
		String[] dsNames = { "ds_right", "ds_left" };
		for (int i = 0; i < 2; i++) {
			ds[i] = this.getDistanceSensor(dsNames[i]);
			ds[i].enable(timeStep);
		}
		compass = this.getCompass("compass");
		compass.enable(timeStep);

		gps = this.getGPS("gps");
		gps.enable(timeStep);

		pen = this.getPen("pen");
		pen.setInkColor(0x000000, 1.0);
		pen.write(true);

	}

	/**
	 * Inicializa los cuatro motores de las ruedas.
	 */
	protected void initMotors() {
		wheels = new Motor[4];
		String[] wheelsNames = { "ruedaDelanteraIzquierda", "ruedaDelanteraDerecha",
				"ruedaTraseraIzquierda", "ruedaTraseraDerecha" };
		for (int i = 0; i < 4; i++) {
			wheels[i] = this.getMotor(wheelsNames[i]);
			wheels[i].setPosition(Double.POSITIVE_INFINITY);
			wheels[i].setVelocity(0.0);
		}
	}

	/**
	 * Avanza la simulación un intervalo
	 */
	public void step() {
		this.step(timeStep);
	}

	public double getMaxVelocity() {
		return maxVelocity;
	}

	public double getLeftVelocity() {
		return wheels[0].getVelocity();
	}

	public double getRightVelocity() {
		return wheels[1].getVelocity();
	}

	/**
	 * Establece la misma velocidad en las cuatro ruedas.
	 * @param v Múltiplo de la maxVelocity. Por ejemplo, v=1.0 equivale
	 * a establecer la velocidad máxima, v=0.5 establece la velocidad en 
	 * un 50% de la velocidad máxima y v=2.0 establece la velocidad en el doble de
	 * la velocidad máxima.
	 */
	public void setVelocity(double v) {
		setLeftVelocity(v);
		setRightVelocity(v);
	}

	/**
	 * Establece la velocidad de las dos ruedas del lado izquierdo.
	 * @param v
	 */
	public void setLeftVelocity(double v) {
		wheels[0].setVelocity(v*maxVelocity);
		wheels[2].setVelocity(v*maxVelocity);
		step();
	}

	/**
	 * Establece la velocidad de las dos ruedas del lado derecho.
	 * @param v
	 */
	public void setRightVelocity(double v) {
		wheels[1].setVelocity(v*maxVelocity);
		wheels[3].setVelocity(v*maxVelocity);
		step();
	}

	/**
	 * Inicia el giro del vehículo hacia la derecha sobre el eje z sin avance
	 */
	public void pivotRight() {
		//System.out.println("pivotRight()");
		setLeftVelocity(0.1);
		setRightVelocity(-0.1);
	}

	/**
	 * Inicia el giro del vehículo hacia la izquierda sobre el eje z sin avance
	 */
	public void pivotLeft() {
		setLeftVelocity(-0.1);
		setRightVelocity(0.1);
	}

	/**
	 * Pivota hacia la izquierda un ángulo angle
	 * @param angle
	 */
	public void pivotLeft(double angle) {
		double previousAngle = getBearingInDegrees();
		double rotatedAngle = 0.0;
		double increment = 0.0;
		pivotLeft();
		
		while (step(timeStep) != -1) {
			double currentAngle = getBearingInDegrees();
			if (currentAngle > previousAngle) {
				increment = 360.0 - currentAngle + previousAngle;
			} else {
				increment = previousAngle - currentAngle;
			}
			rotatedAngle = rotatedAngle + increment;
			previousAngle = currentAngle;
			if (rotatedAngle >= angle) {
				return;
			}
		}
	}

	/**
	 * Pivota el hacia la derecha un ángulo angle
	 * @param angle
	 */
	public void pivotRight(double angle) {
		double previousAngle = getBearingInDegrees();
		double rotatedAngle = 0.0;
		double increment = 0.0;
		pivotRight();
		
		while (step(timeStep) != -1) {
			double currentAngle = getBearingInDegrees();
			if (currentAngle < previousAngle) {
				increment = currentAngle -360 + previousAngle;
			} else {
				increment = currentAngle - previousAngle;
			}
			rotatedAngle = rotatedAngle + increment;
			previousAngle = currentAngle;
			if (rotatedAngle >= angle) {
				return;
			}
		}
	}

	/**
	 * Pivota el vehículo un ángulo angle. Si angle>0, pivota hacia la derecha.
	 * Si angle<0, pivota hacia la izquuierda.
	 * @param angle
	 */
	public void pivotAngle(double angle) {
		// Ángulos pequeños no está resuelto
		if (Math.abs(angle) < 1.0) {
			return;
		}

		// Guardar velocidades antes del giro
		double leftVelocity = getLeftVelocity();
		double rightVelocity = getRightVelocity();

		if (angle > 0) {
			pivotRight(angle);
		} else {
			pivotLeft(-angle);
		}
		setLeftVelocity(leftVelocity);
		setRightVelocity(rightVelocity);
	}

	/**
	 * Avanza en la misma dirección en la que estaba a una velocidad
	 * velocity y hasta una distancia distance.
	 * @param velocity
	 * @param distance
	 */
	public void moveForward(double velocity, double distance) {
		//System.out.println("moveForward()");
		double[] startPos = gps.getValues();
		setVelocity(velocity);
		while (step(timeStep)!=-1) {
			double distToStart = distance(startPos, getGpsValues());
			//System.out.println(distToStart);
			if (distToStart >= distance) {
				setVelocity(0.0);
				return;
			}
		}
	}
	/**
	 * Calcula la distancia entre dos puntos representados por arrays de tres coordenadas.
	 * @param start
	 * @param end
	 * @return
	 */
	public double distance(double[] start, double[] end) {
		double x2 = (start[0] - end[0]) * (start[0] - end[0]);
		double y2 = (start[1] - end[1]) * (start[1] - end[1]);
		double z2 = (start[2] - end[2]) * (start[2] - end[2]);
		return Math.sqrt(x2 + y2 + z2);
	}

	/**
	 * Determina si alguno de los DistanceSensor del vehículo detecta un obstáculo
	 * a distancia menor que OBSTACLE_DISTANCE.
	 * @return
	 */
	public boolean hasObstacle() {
		for (int i = 0; i < 2; i++) {
			if (ds[i].getValue() < 950.0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 0º = Eje Y (Norte)
	 * 90º = Eje X (Este)
	 * 180 = Eje -X (Sur)
	 * 270 = Eje -Y (Oeste)
	 * 
	 * @return
	 */
	public double getBearingInDegrees() {
		double[] north = this.compass.getValues();
		double rad = Math.atan2(north[1], north[0]);
		double bearing = round2((rad / Math.PI) * 180.0);
		if (bearing < 0.0) {
			bearing = bearing + 360.0;
		}
		return bearing;
	}

	public void printGpsValues() {
		double[] v = this.gps.getValues();
		System.out.println(round2(v[0]) + " " + round2(v[1]) + " " + round2(v[2]));
	}

	public double[] getGpsValues() {
		return this.gps.getValues();
	}

	public static double round2(double x) {
		double result = Math.round(x * 100.0) / 100.0;
		return result;
	}

}
