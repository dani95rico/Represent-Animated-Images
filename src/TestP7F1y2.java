import java.io.*;
import java.util.*;

/** Aplicacion: Animaciones
 * @author Laura Delgado Marquez
 * @version 1.0
 */

public class TestP7F1y2 {
	
	/** Metodo principal
	 * @param args
	 */
	public static final int RETARDO = 200;
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws GaleriaException {
		
		//Creacion de la galeria
		IGaleria galeria = new GaleriaF2();
		
		//Creacion de los albumes
		galeria.crearAlbum("Album1");
		Album album1=galeria.getAlbum("Album1");
		galeria.crearAlbum("Album2");
		Album album2=galeria.getAlbum("Album2");
		
		try{
		
			boolean existeFichero = new File("albumes.bin").isFile();
			
				if(!existeFichero){
					annadirFotos(galeria,album1,album2);
					guardarAlbumes("albumes.bin",galeria);
					generarInfoAlbumes("albumes.txt",galeria);
				}
				else
					galeria = recuperarAlbumes("albumes.bin");
				
				imprimirFotos(album1,album2);
				galeria.presentarAlbum("Album1");
				galeria.presentarAlbum("Album2");
				guardarPresentacion("nombreFichero.bin","Album1", galeria.getAlbum("Album1"));

				borrarFotos(album1,album2);
				borrarAlbumes(galeria,album1,album2);
				
		}catch (IllegalArgumentException e){
			e.printStackTrace();
		}
		catch (IllegalStateException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch (RuntimeException e){
			e.printStackTrace();
		}
		catch (GaleriaException e){
			e.printStackTrace();
		}
		finally {
			System.out.println("El programa ha finalizado");
		}
}
	
	/**
	 * Annade las fotos a los dos albumes pasados por parametro
	 * @param galeria - La galeria fotografica
	 * @param album1 - Primer album de fotos
	 * @param album2 - Segundo album de fotos
	 */
	public static void annadirFotos (IGaleria galeria, Album album1, Album album2){
		
		album1.addFoto(new Foto("Foto1",new Date(),"T0.gif"));
		album1.addFoto(new Foto("Foto2",new Date(),"T1.gif"));
		album1.addFoto(new Foto("Foto3",new Date(),"T2.gif"));
		album1.addFoto(new Foto("Foto4",new Date(),"T3.gif"));
		album1.addFoto(new Foto("Foto5",new Date(),"T4.gif"));
		album1.addFoto(new Foto("Foto6",new Date(),"T5.gif"));

		album2.addFoto(new Foto("Foto1",new Date(),"T0.gif"));
		album2.addFoto(new Foto("Foto2",new Date(),"T1.gif"));
		album2.addFoto(new Foto("Foto3",new Date(),"T2.gif"));
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
	 * Guarda en un fichero binario, cuyo nombre se guarda en el parametro
	 * fichero, todos los objetos de la clase album almacenados en una
	 * galeria de fotos que se pasa en el parametro gf
	 * @param fichero - Nombre del fichero binario
	 * @param gf - Galeria que almacena las fotos
	 * @return true si la operacion se ha realizado sin errores y false en
	 * caso contrario
	 */
	private static boolean guardarAlbumes(String fichero, IGaleria gf){

		String[] albumesGuardar;
		boolean finalizado = false;
		
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
			albumesGuardar = gf.getAlbumes();
			for(int i=0; i<albumesGuardar.length;i++){
				oos.writeObject(gf.getAlbum(albumesGuardar[i]));
			}
			finalizado=true;
			oos.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return finalizado;
	}

	/**
	 * Recupera de un fichero binario (creado con el metodo anterior) cuyo nombre
	 * se pasa en el parametro fichero todos los objetos de la clase album almacenados
	 * en el, y devolvera una galeria de fotos creada a partir de dichos objetos o
	 * el valor null si se ha producido un error
	 * @param fichero - Nombre del fichero binario
	 * @return la galeria de fotos, o null si se produce algun error
	 */
	private static IGaleria recuperarAlbumes(String fichero){
		boolean eof = false;
		Album album = null;
		GaleriaF2 galeria = new GaleriaF2();
		
		try{
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fichero));
			while(!eof){
				try{
				album=(Album)entrada.readObject();
				galeria.crearAlbum("Album3");
			}catch(EOFException e){
				eof=true;
			}catch(NullPointerException e){
				e.printStackTrace();
			}
		}
			entrada.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return galeria;
	}

	/**
	 * Almacena la informacion de la galeria de fotos en un fichero de texto
	 * cuyo nombre se pasa por el parametro fichero. Cada una de las lineas
	 * de dicho fichero debera contener la informacion correspondiente al
	 * nombre, al fichero y a la foto.
	 * @param fichero - Nombre del fichero binario
	 * @param gf - Galeria que almacena las fotos
	 */
	private static void generarInfoAlbumes (String fichero, IGaleria gf){
		
		String[] albums;
		albums=gf.getAlbumes();
		
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
			for(int i=0;i<albums.length;i++){
				bw.write("Nombre album: " + albums[i]+ "\n");
				for(int j=0;j<gf.getAlbum(albums[i]).getNumFotos();j++){
					bw.write("Nombre foto: " +gf.getAlbum(albums[i]).getFoto(j)+ "\t");
				}
				bw.write("\n");
			}
			bw.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Almacena en ficheros binarios informaciones que permiten realizar la presentacion
	 * de las imagenes de un album
	 * @param nombreFichero - Nombre que tendra el fichero
	 * @param nombrePresentacion - Nombre asignado a la presentacion
	 * @param album - Album sobre el que se realizara la presentacion
	 * @throws IOException
	 */
	private static void guardarPresentacion(String nombreFichero, String nombrePresentacion, Album album) throws IOException{
		
		System.out.println("¿Quieres guardar la presentacion? Teclee s o S en caso afirmativo:");
		String guardar = sc.nextLine();
		if(guardar.equalsIgnoreCase("s")){
			try{
				
				DataOutputStream dos= new DataOutputStream(new FileOutputStream(nombreFichero));
				
				dos.writeUTF(nombrePresentacion);
				dos.writeInt(RETARDO);
				dos.writeInt(album.getNumFotos());
				
				for (int i=0; i<album.getNumFotos();i++)
					dos.writeUTF(album.getFoto(i).getNomFichero());
				
				dos.close();
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}