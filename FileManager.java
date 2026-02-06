package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Scanner;

public class FileManager {

	private static Scanner lectorDeArchivo;
	private static File archivo;
	private static PrintWriter escritorDeArchivo;
	private static final String RUTA_CARPETA = "src/archivos";

	private static FileOutputStream fos;
	private static ObjectOutputStream oos;
	private static FileInputStream fis;
	private static ObjectInputStream ois;

	// ATRIBUTOS PARA ARCH DE PROPIEDAD

	private static Properties prop;

	public static void crearCarpeta() {
		archivo = new File(RUTA_CARPETA);
		if (!archivo.exists() || !archivo.isDirectory()) {
			archivo.mkdir();
		}

	}

	public static void escribirArchivoDeTexto(String nombreDeArchivo, String contenido) {
		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreDeArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			escritorDeArchivo = new PrintWriter(archivo);
			escritorDeArchivo.println(contenido);
			escritorDeArchivo.close();
		} catch (IOException e) {
			System.out.println("Error al escribir el archivo de texto. (Creacion del archivo).");
			e.printStackTrace();
		}
	}

	public static String leerArchivoDeTexto(String nombreDeArchivo) {
		archivo = new File(RUTA_CARPETA + "/" + nombreDeArchivo);
		try {
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			lectorDeArchivo = new Scanner(archivo);
			String contenido = "";
			while (lectorDeArchivo.hasNext()) {
				contenido += lectorDeArchivo.nextLine() + "\n";
			}
			lectorDeArchivo.close();
			return contenido;
		} catch (IOException e) {
			System.out.println("Error al leer el archivo. (Creación del archivo)");
			e.printStackTrace();
		}
		return null;

	}

	public static void escribirArchivoSerializado(String nombreArchivo, Object contenido) {
		archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
		try {
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(contenido);
			oos.close();
			fos.close();
		} catch (IOException e) {
			System.out.println("Problemas al abrir el archivo serializado (Escritura)");
			e.printStackTrace();
		}
	}

	public static Object leerArchivoSerializado(String nombreArchivo) {
		archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
		Object contenido = null;
		try {
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);
			contenido = ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo serializado");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Error en los datos del archivo serializado");
			e.printStackTrace();
		}
		return contenido;
	}

	/*
	 * public static void crearArchivoDePropiedad() { prop = new Properties(); }
	 * 
	 * public static void cargarArchivoDePropiedad(String ruta) {
	 * crearArchivoDePropiedad(); try { prop.load(new FileInputStream(new
	 * File(ruta))); } catch (FileNotFoundException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 */

}