public class GaleriaException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public GaleriaException() {}
	
	public GaleriaException(String mensajeError) {
		super (mensajeError);
	}
}