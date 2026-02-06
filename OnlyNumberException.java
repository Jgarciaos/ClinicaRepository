package co.edu.unbosque.util.exception;

public class OnlyNumberException extends Exception{	
	public OnlyNumberException() {
		super("No se pueden ingresar letras");
	}
}
