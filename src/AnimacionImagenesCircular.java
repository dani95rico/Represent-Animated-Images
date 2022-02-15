
public class AnimacionImagenesCircular extends AnimacionImagenes{

	/**
	 * Crea una animacion con el nombre proporcionado, la animacion se
	 * mostrara en un Escenario de tamanno ancho x alto. La animacion mostrara
	 * las imagenes cuyos nombres de ficheros se pasan como parametro en el
	 * array imagenes, en el mismo orden en que estan en el array, al mostrar
	 * la ultima imagen volvera a empezar por la primera, en circulo, por lo que
	 * esta animacion no tiene final.
	 * @param nombre - el nombre de la animacion
	 * @param ancho - el ancho del escenario donde mostrarla (en pixels)
	 * @param alto - el alto del escenario donde mostrarla (en pixels)
	 * @param imagenes - array con el nombre de los ficheros con las imagenes a mostrar
	 * @throws AnimacionException 
	 */
	public AnimacionImagenesCircular(String nombre, int ancho, int alto, String[] imagenes) throws AnimacionException {
		super (nombre, ancho, alto, imagenes);
	}
	
	/**
	 * Ejecuta un paso de la animacion y prepara todo para ejecutar
	 * el siguiente paso. Se llamara en un bucle hasta que finalice la animacion,
	 * de forma que se vaya ejecutando paso a paso.
	 */
	public void ejecutarPaso() {
		super.ejecutarPaso();
		if (super.estaFinalizada()) {
			 super.setPosicion(0);
		}
	}
	
	/**
	 * Devuevle si la animacion ha finalizado o no.
	 * @return true si la animacion ha finalizado
	 */
	public boolean estaFinalizada() {	
		return false;
	}
	
}
