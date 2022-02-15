
public class AnimacionImagenes extends Animacion{
	
	//Atributos del constructor
	private Imagen [] imagenes;
	private int posicion;
	
	
	/**
	 * Crea una animacion con el nombre proporcionado, la animacion
	 * se mostrara en un Escenario de tamanno ancho x alto. La animacion
	 * mostrara las imagenes cuyos nombres de ficheros se pasan como parametro
	 * en el array imagenes secuencialmente, en el mismo orden en que estan
	 * en el array, y terminara.
	 * @param nombre - el nombre de la animacion
	 * @param ancho - el ancho del escenario donde mostrarla (en pixels)
	 * @param alto - el alto del escenario donde mostrarla (en pixels)
	 * @param imagenes - array con el nombre de los ficheros con las imagenes a mostrar
	 * @throws Exception 
	 */
	public AnimacionImagenes (String nombre, int ancho, int alto, String[] imagenes) throws AnimacionException {
		super(nombre, ancho, alto);
		
		if(imagenes==null)
			throw new IllegalArgumentException("El array de imagenes no puede ser null");
		
		if (imagenes.length < 2)
			throw new AnimacionException ("El array de nombres debe contener al menos dos elementos");
		
		this.imagenes = new Imagen[imagenes.length];
		for (int i=0; i<this.imagenes.length; i++) {
			this.imagenes[i] = new Imagen (imagenes[i]);
		}
		posicion = 0;
		
	}
	
	/**
	 * Devuelve la posicion de la animacion
	 * @param posicion - posicion de la imagen a mostrar al ejecutar el siguiente paso
	 */
	public void setPosicion (int posicion) {
		this.posicion = posicion;
	}
	
	/**
	 * Devuelve el numero de imagenes que forman la animacion
	 * @return el numero de imagenes de al animacion
	 */
	public int getCuantas() {
		return imagenes.length;
	}
	
	/**
	 * Ejecuta un paso de la animacion y prepara todo para ejecutar
	 * el siguiente paso. Se llamara en un bucle hasta que finalice la animacion,
	 * de forma que se vaya ejecutando paso a paso.
	 */
	public void ejecutarPaso() {
		if (estaFinalizada())
			throw new IllegalStateException ("Ya ha terminado de ejecutar el paso");	
		else {
			p.dibujarImagen(100, 100, imagenes[posicion]);
			posicion++;
		}
}
	
	/**
	 * Devuevle si la animacion ha finalizado o no.
	 * @return true si la animacion ha finalizado
	 */
	public boolean estaFinalizada() {
		if (posicion == getCuantas())
			return true;
		else
			return false;
	}

}
