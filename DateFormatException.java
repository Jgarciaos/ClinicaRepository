package co.edu.unbosque.util.exception;

public class DateFormatException extends Exception{
	public DateFormatException() {
		super("Debe seguir el formato de fecha apropiado [día/mes/año, únicamente números]");
	}
}
