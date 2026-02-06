package co.edu.unbosque.util.exception;

public class NegativeFloatException extends Exception {
	public NegativeFloatException() {
		super("No se pueden ingresar numeros negativos");
	}
}
