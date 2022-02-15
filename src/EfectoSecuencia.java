
public class EfectoSecuencia implements Efecto {
	
	//Atributos del constructor
	private Efecto primero;
	private Efecto segundo;
	
	/**
	 * Crea un efecto compuesto de dos efectos que se aplicarán uno a continuación del otro (segundo despues de primero).
	 * @param primero - primer efecto a aplicar.
	 * @param segundo - segundo efecto a aplicar 
	 */
	public EfectoSecuencia (Efecto primero, Efecto segundo) {
		this.primero = primero;
		this.segundo = segundo;
	}
	
	/**
	 * Genera una imagen de salida a partir de la imagen de entrada aplicando el efecto que corresponda.
	 * @param original - imagen de entrada.
	 * @return la imagen de salida con el efecto aplicado.
	 */
	public Imagen transformar(Imagen original) {
		
		if(original==null)
			throw new IllegalArgumentException("La imagen no puede ser null");
		
		Imagen aux = primero.transformar(original);
		return segundo.transformar(aux);
	}
	
}