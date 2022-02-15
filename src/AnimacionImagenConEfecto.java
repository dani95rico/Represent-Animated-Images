
public class AnimacionImagenConEfecto extends AnimacionImagen {
	
	//Atributo del constructor
		private Imagen imagen;
	
	/**
	 * Crea una animacion con el nombre proporcionado que se mostrara
	 * en un Escenario de tamanno ancho x alto. La animacion mostrara
	 * la imagen cuyo nombre de fichero se pasa como parametro
	 * (aplicandole antes el efecto indicado) y terminara.
	 * @param nombre - el nombre de la animacion
	 * @param ancho - el ancho del escenario donde mostrarla (en pixels)
	 * @param alto - el alto del escenario donde mostrarla (en pixels)
	 * @param imagen - el nombre del fichero con la imagen a mostrar
	 * @param efecto - el efecto a aplicar a la imagen antes de mostrarla
	 * @throws Exception 
	 */
	public AnimacionImagenConEfecto(String nombre, int ancho, int alto, String imagen, Efecto efecto) {
		super(nombre, ancho, alto, imagen);
		
		if(imagen==null)
			throw new IllegalArgumentException("La imagen no puede ser null");
		
		if(efecto==null)
			throw new IllegalArgumentException("El efecto no puede ser null");
		
		this.imagen=efecto.transformar(this.imagen);
	}
	
	/**
	 * Ejecuta un paso de la animacion y prepara todo para ejecutar el
	 * siguiente paso. Se llamara en un bucle hasta que finalice la animacion,
	 * de forma que se vaya ejecutando paso a paso.
	 */
	public void ejecutarPaso() {
		
		if(estaFinalizada())
			throw new IllegalStateException("El paso ha finalizado");
		
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
