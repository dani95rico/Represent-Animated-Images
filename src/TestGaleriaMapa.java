import java.util.*;

/** Aplicacion: Animaciones
 * @author Laura Delgado Marquez
 * @version 1.0
 */

public class TestGaleriaMapa {
	
	/** Metodo principal
	 * @param args
	 */
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String [] args) {
		
		//Creacion de la galeria
		IGaleria galeria = null;
		
		try {
			
			switch(menu()) {
			
			case 1:
				galeria = new GaleriaF2();
				break;
				
			case 2:
				galeria = new GaleriaF3();
				break;
			
			default:
				break;
			
			}
			
			//Creacion de los albumes
			galeria.crearAlbum("Album1");
			Album album1=galeria.getAlbum("Album1");
			galeria.crearAlbum("Album2");
			Album album2=galeria.getAlbum("Album2");
			
			
			annadirFotos(galeria,album1,album2);
			imprimirFotos(album1,album2);

			try {
				galeria.presentarAlbum("Album1");
			} catch(GaleriaException e) {
				System.out.println(e.getMessage());
			}
			
			borrarFotos(album1,album2);
			borrarAlbumes(galeria,album1,album2);
			
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		  }
		  catch(Exception e) {
			System.out.println(e.getMessage());
		  }
	}
	
	/**
	 * Añade las fotos a los dos albumes pasados por parametro
	 * @param galeria - La galeria fotografica
	 * @param album1 - Primer album de fotos
	 * @param album2 - Segundo album de fotos
	 */
	public static void annadirFotos (IGaleria galeria, Album album1, Album album2){
		
		album1.addFoto(new Foto("Foto2",new Date(),"T0.gif"));
		album1.addFoto(new Foto("Foto3",new Date(),"T1.gif"));
		album1.addFoto(new Foto("Foto4",new Date(),"T2.gif"));
		album1.addFoto(new Foto("Foto4",new Date(),"T3.gif"));
		album1.addFoto(new Foto("Foto5",new Date(),"T4.gif"));
		album1.addFoto(new Foto("Foto6",new Date(),"T5.gif"));

		album2.addFoto(new Foto("Foto2",new Date(),"T0.gif"));
		album2.addFoto(new Foto("Foto3",new Date(),"T1.gif"));
		album2.addFoto(new Foto("Foto4",new Date(),"T2.gif"));
		album2.addFoto(new Foto("Foto4",new Date(),"T3.gif"));
		album2.addFoto(new Foto("Foto5",new Date(),"T4.gif"));
		album2.addFoto(new Foto("Foto6",new Date(),"T5.gif"));

	}
	
	/**
	 * Imprime las fotos de los dos albumes pasados por parametro
	 * @param album1 - Primer album de fotos
	 * @param album2 - Segundo album de fotos
	 */
	public static void imprimirFotos (Album album1, Album album2){
		for(int i=0; i<album1.getNumFotos(); i++)
			System.out.println("Album 1:" + album1.getFoto(i).toString());
		for(int i=0; i<album2.getNumFotos(); i++)
			System.out.println("Album 2:" + album2.getFoto(i).toString());
	}
	
	/**
	 * Borra las fotos de los dos albumes pasados por parametro
	 * @param album1 - Primer album de fotos
	 * @param album2 - Segundo album de fotos
	 */
	public static void borrarFotos (Album album1, Album album2){
		for(int i=0; i<album1.getNumFotos(); i++)
			album1.delFoto(i);
	}
	
	/**
	 * Borra las fotos de los dos albumes pasados por parametro
	 * @param galeria - La galeria fotografica
	 * @param album1 - Primer album de fotos
	 * @param album2 - Segundo album de fotos
	 */
	public static void borrarAlbumes (IGaleria galeria, Album album1, Album album2){
		galeria.delAlbum("Album1");
		galeria.delAlbum("Album2");
	}
	
	/**
	 * Imprime el menu de opciones
	 * @return la opcion escogida
	 */
	public static int menu (){
		int opcion;
		do {
		System.out.println("1. Crear un set");
		System.out.println("2. Crear un mapa");
		System.out.print("Introduzca la opcion que desee (1 o 2): ");
		opcion = sc.nextInt();
		} while ((opcion < 0) || (opcion > 2));
		return opcion;
	}
	
}
