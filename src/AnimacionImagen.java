public class AnimacionImagen extends Animacion{
		
	//Atributos del constructor
	private Imagen imagen;
	
	/**
	 * Crea una animacion con el nombre proporcionado que se mostrara
	 * en un Escenario de tamanno ancho x alto. La animacion mostrara
	 * la imagen cuyo nombre de fichero se pasa como parametro y terminara.
	 * @param nombre - el nombre de la animacion
	 * @param ancho - el ancho del escenario donde mostrarla (en pixels)
	 * @param alto - el alto del escenario donde mostrarla (en pixels)
	 * @param imagen - el nombre del fichero con la imagen a mostrar
	 * @throws   
	 */
	public AnimacionImagen (String nombre, int ancho, int alto, String imagen) {
		super (nombre, ancho, alto);
		
		if (imagen == null)
			throw new IllegalArgumentException("La imagen no puede ser null");
		
		this.imagen = new Imagen (imagen);
	}
	
	/**
	 * Ejecuta un paso de la animacion y prepara todo para ejecutar el
	 * siguiente paso. Se llamara en un bucle hasta que finalice la animacion,
	 * de forma que se vaya ejecutando paso a paso.
	 */
	public void ejecutarPaso() {
		p.dibujarImagen(10, 10, imagen);
	}
	
	/**
	 * Devuevle si la animacion ha finalizado o no.
	 * @return true si la animaciÛn ha finalizado
	 */
	public boolean estaFinalizada() {
		return false;
	}
	

}
