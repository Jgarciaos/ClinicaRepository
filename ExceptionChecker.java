package co.edu.unbosque.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import co.edu.unbosque.util.exception.DateFormatException;
import co.edu.unbosque.util.exception.GenderFormatException;
import co.edu.unbosque.util.exception.IdLimitException;
import co.edu.unbosque.util.exception.NegativeFloatException;
import co.edu.unbosque.util.exception.NegativeNumberException;
import co.edu.unbosque.util.exception.OnlyNumberException;
import co.edu.unbosque.util.exception.OnlyStringException;
import co.edu.unbosque.util.exception.WorkPositionException;

public class ExceptionChecker {

	public static void checkNegativeNumber(int numero) throws NegativeNumberException {
		if (numero < 0) {
			throw new NegativeNumberException();
		}
	}

	public static void checkNegativeFloat(float numero) throws NegativeFloatException {
		if (numero < 0) {
			throw new NegativeFloatException();
		}
	}

	public static void checkStringInput(String texto) throws OnlyStringException {
		if (!texto.matches("^[a-zA-Z ]+$")) {
			throw new OnlyStringException();
		}
	}

	public static void checkNumberInput(int numero) throws OnlyNumberException {
		if (numero > 0 || numero < 0) {
			throw new OnlyNumberException();
		}
	}
	
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static void checkDateFormat(String fecha) throws DateFormatException {
		try {
			LocalDate.parse(fecha, DATE_FORMATTER);
		} catch (DateTimeParseException e) {
			throw new DateFormatException();
		}
	}
	
	public static void checkIdLimit(long documentoPaciente) throws IdLimitException {
		if(documentoPaciente<0 || documentoPaciente>= 1999999999) {
			throw new IdLimitException();
		}
	}
	
	public static void checkGenderFormat(String genero) throws GenderFormatException {
		if (genero == null) {
			throw new GenderFormatException();
		}
		
		String valor = genero.toLowerCase();
		
		if(!valor.equals("f") && !valor.equals("m")) {
			throw new GenderFormatException();
		}
	}
	
	public static void checkWorkPosition(String cargo) throws WorkPositionException {
		if (cargo == null) {
			throw new WorkPositionException();
		}
		
		String valor = cargo.toLowerCase();
		
		if(!valor.equals("enfermero") && !valor.equals("doctor")) {
			throw new WorkPositionException();
		}
	}

}
