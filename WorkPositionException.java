package co.edu.unbosque.util.exception;

public class WorkPositionException extends Exception {
	public WorkPositionException() {
		super("Formato no válido, escriba \"enfermero\" o \"doctor\" según corresponda a su cargo.");
	}
}
