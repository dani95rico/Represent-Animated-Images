import java.io.*;
/**
 * Programa que lee un fichero binario con los datos de una presentaciÛn
 * y ejecuta dicha presnetaciÛn
 * @author programacion II
 * @version 1.0
 */
public class Presentar {
	/**
	 * Programa principal
	 * @param args Argumentos recibidos al ejecutar el programa:
	 *             nombre del fichero con la presentaciÛn
	 */
	public static void main(String[] args) {
		DataInputStream fEntrada = null;
		if (args.length!=1){
			System.out.println("error en los par·metros de entrada");
			System.out.println("formato comando: java Presentar <nombre fichero presentaciÛn>");
		}
		else{
			try{
				boolean eof =false;
				String nombre="",fecha="";
				int numero,retardo=0;
				String [] ficheros=null;
				fEntrada = new DataInputStream( new FileInputStream (args[0]));
				while(!eof){
					try{
						nombre = fEntrada.readUTF();
					}catch (EOFException  e){
						eof= true;
					}
					if (!eof){
				//		fecha = fEntrada.readUTF(); este campo ha sido eliminado en la ˙ltima versiÛn
						retardo= fEntrada.readInt();
						numero= fEntrada.readInt();
						ficheros = new String[numero];
						System.out.println("Fotos contenidas en la presentaciÛn:");
						for (int i=0; i<numero;i++){
							ficheros[i]=fEntrada.readUTF();
							System.out.println("\t"+ficheros[i]);
						}
					}
				}
				// comienza la presentaciÛn
				System.out.println("comienza la presentaciÛn de fecha: "+fecha+ " y de nombre: "+ nombre);
				Animacion a = new AnimacionImagenes(nombre,200,200, ficheros);
				player(a, retardo);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (AnimacionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if ( fEntrada != null )
					try {
						fEntrada.close();
					} catch (IOException e) {
							e.printStackTrace();
					}
			}
		}
	}
private static void player (Animacion m, int delay) {
		
		while (!m.estaFinalizada()) {
			m.ejecutarPaso();
			try {
				Thread.sleep( delay );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
