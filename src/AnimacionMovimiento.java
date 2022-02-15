
public class AnimacionMovimiento extends Animacion {
	
	//Atributos del constructor
	private Imagen imagen;
	private int x;
	private int y;
	private int vx;
	private int vy;
	
	/**
	 * Crea una animacion con el nombre proporcionado, que se mostrara en un
	 * Escenario de tamanno ancho x alto. La animacion mostrara la imagen cuyo
	 * nombre de fichero se pasa como parametro, empezando en la posicion inicial
	 * x,y. En cada paso de la animacion la imagen se movera en la coordenada X e Y
	 * la cantidad de pixels especificados por los parametros vx,vy. Esta animacion
	 * termina cuando la imagen se sale totalmente del escenario que la muestra.
	 * @param nombre - el nombre de la animacion
	 * @param imagen -  el nombre del fichero con la imagen a mostrar
	 * @param ancho - el ancho del escenario donde mostrarla (en pixels)
	 * @param alto - el alto del escenario donde mostrarla (en pixels)
	 * @param x - coordenada x inicial de la imagen a mostrar
	 * @param y - coordenada y inicial de la imagen a mostrar
	 * @param vx - velocidad en la coordenada x de la imagen a mostrar
	 * @param vy - velocidad en la coordenada y de la imagen a mostrar
	 * @throws Exception 
	 */
	public AnimacionMovimiento(String nombre, int ancho, int alto, String imagen, int x, int y, int vx, int vy) {
		super (nombre, ancho, alto);
		
		if(imagen==null)
			throw new IllegalArgumentException("La imagen no puede ser null");
		
		this.imagen = new Imagen(imagen);
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
	}
	
	/**
	 * Ejecuta un paso de la animacion y prepara todo para ejecutar el siguiente paso.
	 * Se llamara en un bucle hasta que finalice la animacion, de forma que se vaya
	 * ejecutando paso a paso.
	 */
	public void ejecutarPaso() {
		p.dibujarImagen(x, y, imagen);
		x = x + vx;
		y = y + vy;
	}
	
	/**
	 * Devuevle si la animacion ha finalizado o no.
	 * @return true si la animacion ha finalizado
	 */
	public boolean estaFinalizada() {
		if ((x == getAncho())||(y == getAlto()))
			return true;
		else
			return false;
	}
	

}
