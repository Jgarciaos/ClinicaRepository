package co.edu.unbosque.util.exception;

public class OnlyStringException extends Exception{
	
	public OnlyStringException() {
		super("No se pueden ingresar ni numeros ni simbolos");
	}

}
