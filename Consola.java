package co.edu.unbosque.view;

import java.util.Scanner;

public class Consola {
	private Scanner lector;

	public Consola() {
		// TODO Auto-generated constructor stub
		lector = new Scanner(System.in);
	}

	public short leerShort() {
		return lector.nextShort();
	}

	public int leerEntero() {
		return lector.nextInt();
	}

	public long leerLong() {
		return lector.nextLong();
	}

	public double leerDouble() {
		return lector.nextDouble();
	}

	public float leerFloat() {
		return lector.nextFloat();
	}

	public String leerPalabra() {
		return lector.next();
	}

	public String leerLinea() {
		return lector.nextLine();
	}

	public char leerCaracter() {
		return lector.next().charAt(0);
	}

	public boolean leerBooleano() {
		String entrada = leerPalabra().toLowerCase();

		if (entrada.contains("si")) {
			return true;
		} else {
			return false;
		}
	}

	public void imprimirConSalto(String texto) {
		System.out.println(texto);
		// String prueba = 8+"";
	}

	public void imprimirSinSalto(String texto) {
		System.out.print(texto);
	}

	public void quemarLinea() {
		// Lectura ciega
		lector.nextLine();
	}
}