public abstract class Animacion {
	
	//Atributos del constructor
	private String nombre;
	private int ancho;
	private int alto;
	protected Escenario p;
	
	/**
	 * Crea una animacion con el nombre proporcionado que se mostrara en un
	 * escenario de tamanno ancho x alto
	 * @param nombre - el nombre de la animacion
	 * @param ancho - el ancho del escenario donde mostrarla (en pixels)
	 * @param alto - el alto del escenario donde mostrarla (en pixels)
	 * @throws 
	 */
	public Animacion (String nombre, int ancho, int alto) {
		if (nombre == null)
			throw new IllegalArgumentException ("El nombre no puede ser null");
		if (ancho <= 0)
			throw new IllegalArgumentException ("El ancho no puede ser negativo");
		if (alto <= 0)
			throw new IllegalArgumentException ("El alto no puede ser negativo");			
	
		this.nombre = nombre;
		this.ancho = ancho;
		this.alto = alto;
		p = new Escenario(nombre, ancho, alto);

	}
	
	/**
	 * Devuelve el ancho del escenario
	 * @return el ancho del escenario
	 */
	public int getAncho() {
		return ancho;
	}
	
	/**
	 * Devuelve el alto del escenario
	 * @return el alto del escenario
	 */
	public int getAlto() {
		return alto;
	}

	/**
	 * Devuelve el nombre de la animacion
	 * @return el nombre de la animacion
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Ejecuta un paso de la animacion y prepara todo para ejecutar
	 * el siguiente paso. Se llamar· en un bucle hasta que finalice
	 * la animacion, de forma que se vaya ejecutando paso a paso.
	 * @throws Exception 
	 */
	public abstract void ejecutarPaso ();

	
	/**
	 * Devuevle si la animacion ha finalizado o no.
	 * @return true si la animacion ha finalizado
	 */
	public abstract boolean estaFinalizada();
	
	
}