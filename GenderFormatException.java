package co.edu.unbosque.util.exception;

public class GenderFormatException extends Exception {
	public GenderFormatException() {
		super("Formato invalido, escriba \"masculino\" o \"femenino\" según corresponda.");
	}
}
