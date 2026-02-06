package co.edu.unbosque.util.exception;

public class IdLimitException extends Exception{
	public IdLimitException() {
		super("Número de identificación excede el límite permitido (10 caracteres)");
	}
}
