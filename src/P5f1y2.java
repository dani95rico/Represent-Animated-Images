/** Aplicacion: Animaciones
 * @author Laura Delgado Marquez
 * @version 1.0
 */

public class P5f1y2 {

	/** Metodo principal
	 * @param args - Guarda en la primera posicion el tipo de animacion escogido
	 */
	
	public static final String [] DIBUJO = {"T0.gif","T1.gif","T2.gif","T3.gif","T4.gif","T5.gif"};
	public static final int ANCHO = 300;
	public static final int ALTO = 300;
	public static final int RETARDO = 200;
	public static final int INICIO = 10;
	public static final int VELOCIDAD = 10;
	public static final int IMAGEN_FIJA = 5;
	
	public static void main (String[] args) throws AnimacionException {
		//Declaracion de variables
		Animacion animacion = null;
		int numAnimacion = validarParametros(args);
		
		//Programa principal
		if (numAnimacion <= 4)
			animacion = ejecutarAnimacion(numAnimacion, animacion);
		else
		animacion = ejecutarEfecto(numAnimacion, animacion);
		
		player(animacion);
	}
	
	/**
	 * Ejecuta la animacion elegida en el switch
	 * @param numAnimacion - Es el número elegido por el usuario de la animación a ejecutar
	 * @param animacion - Guardara la animacion a ejecutar
	 * @return la animacion que se le pasa al main para que ejecute
	 * @throws AnimacionException 
	 */
	public static Animacion ejecutarAnimacion (int numAnimacion, Animacion animacion) throws AnimacionException {
		switch (numAnimacion) {
		case 1:
			animacion = new AnimacionImagen ("AnimacionImagen", ANCHO, ALTO, DIBUJO[IMAGEN_FIJA]);
			player(animacion);
			break;
		case 2:
			animacion = new AnimacionImagenes ("AnimacionImagenes", ANCHO, ALTO, DIBUJO);
			player(animacion);
			break;
		case 3:
			animacion = new AnimacionImagenesCircular ("AnimacionImagenCircular", ANCHO, ALTO, DIBUJO);
			player(animacion);
			break;
		case 4:
			animacion = new AnimacionMovimiento ("AnimacionMovimiento", ANCHO, ALTO, DIBUJO[IMAGEN_FIJA], INICIO, INICIO, VELOCIDAD, VELOCIDAD);
			player(animacion);
			break;
		default:
			break;
		}
		return animacion;
	}

	/**
	 * Ejecuta la animacion elegida en el switch
	 * @param numAnimacion - Es el número elegido por el usuario de la animación a ejecutar
	 * @param animacion - Guardara la animacion a ejecutar
	 * @return la animacion que se le pasa al main para que ejecute
	 */
	public static Animacion ejecutarEfecto (int numAnimacion, Animacion animacion) {
		Efecto efecto1 = new EfectoEscalaGrises();
		Efecto efecto2 = new EfectoLibre();
		Efecto efecto3 = new EfectoSecuencia(efecto1,efecto2);
		switch (numAnimacion) {
		case 5:
			animacion = new AnimacionImagenConEfecto ("EfectoEscalaGrises", ANCHO, ALTO, DIBUJO[IMAGEN_FIJA], efecto1);
			player(animacion);
			break;
		case 6:
			animacion = new AnimacionImagenConEfecto ("EfectoLibre", ANCHO, ALTO, DIBUJO[IMAGEN_FIJA], efecto2);
			player(animacion);
			break;
		case 7:
			animacion = new AnimacionImagenConEfecto ("EfectoSecuencia", ANCHO, ALTO, DIBUJO[IMAGEN_FIJA], efecto3);
			player(animacion);
			break;	
		default:
			break;
		}
		return animacion;
	}
	
	/**
	 * Metodo que presenta la animacion
	 * @param a - animacion a ejecutar
	 */
	public static void player (Animacion a) {
		while (!a.estaFinalizada()) {
			a.ejecutarPaso();
			try {
				Thread.sleep(RETARDO);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/** 
	 * Método que valida el parametro del main
	 * @param args Array de String pasado como parametro al main
	 * @return true si los parámetros introducidos son correctos
	 */
	public static int validarParametros (String[] args) {
		int numAnimacion = 0;
		if (args.length != 1) {
			System.out.println("Error en los argumentos del programa");
			System.out.println("Teclear: java P5f1y2 [numero de animacion]");
		}
		else {
			if ((Integer.parseInt(args[0]) > 7 ) || (Integer.parseInt(args[0]) < 0))
				System.out.println ("Los valores de los argumentos no permiten jugar");
			else
			numAnimacion = Integer.parseInt(args[0]);
		}
		return numAnimacion;
	}
}
