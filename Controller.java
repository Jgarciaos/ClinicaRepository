package co.edu.unbosque.controller;

import java.util.InputMismatchException;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.PacienteDTO;
import co.edu.unbosque.model.PersonalDTO;
import co.edu.unbosque.model.persistence.FileManager;
import co.edu.unbosque.util.exception.DateFormatException;
import co.edu.unbosque.util.exception.GenderFormatException;
import co.edu.unbosque.util.exception.IdLimitException;
import co.edu.unbosque.util.exception.NegativeNumberException;
import co.edu.unbosque.util.exception.WorkPositionException;
import co.edu.unbosque.view.Consola;

public class Controller {

	private Consola con;
	private ModelFacade mf;

	public Controller() {
		con = new Consola();
		mf = new ModelFacade();
	}

	public void run() {
		FileManager.crearCarpeta();
		System.out.println("Gestor Clínico");
		mainLoop: while (true) {
			System.out.println("Bienvenido al gestor clínico.");
			System.out.println("Por favor seleccione la opción que desea realizar"
					+ "\n[digite el número correspondiente a la opción deseada]: ");
			System.out.println("1 | Gestionar pacientes.");
			System.out.println("2 | Gestionar personal.");
			System.out.println("3 | Salir.");
			int opcion = 0;
			boolean validarEntrada = false;
			while (!validarEntrada) {
				try {
					opcion = con.leerEntero();
					ExceptionChecker.checkNegativeNumber(opcion);
					validarEntrada = true;
				} catch (InputMismatchException e) {
					System.out.println("Formato ingresado no valido");
					con.quemarLinea();
				} catch (NegativeNumberException e) {
					System.out.println(
							"No se permiten números negativos, digite un número correspondiente a las opciones mostradas.");
					con.quemarLinea();
				}

			}
			switch (opcion) {

			// Gestión paciente
			case 1: {
				System.out.println("Gestión Paciente");
				System.out.println("Seleccione la opción que desea realizar"
						+ "\n[Digite el número correspondiente a la opción deseada]: ");
				System.out.println("1 | Registrar paciente.");
				System.out.println("2 | Actualizar datos de un paciente.");
				System.out.println("3 | Eliminar registro de paciente.");
				System.out.println("4 | Reporte de pacientes.");
				System.out.println("5 | Retornar al menú anterior.");
				System.out.println();
				int decision = 0;
				validarEntrada = false;
				while (!validarEntrada) {
					try {
						decision = con.leerEntero();
						ExceptionChecker.checkNegativeNumber(decision);
						validarEntrada = true;
					} catch (InputMismatchException e) {
						System.out.println("Formato ingresado no valido");
						con.quemarLinea();
					} catch (NegativeNumberException e) {
						System.out.println(
								"No se permiten números negativos, digite un número correspondiente a las opciones mostradas.");
						con.quemarLinea();
					}
				}

				pacienteLoop: switch (decision) {

				// Crear paciente
				case 1: {
					con.quemarLinea();
					System.out.println("..Formulario de registro de paciente..");
					System.out.print("Nombre completo del paciente: ");
					String nombre = "";
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							nombre = con.leerLinea();
							validarEntrada = true;
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido.");
						}
					}

					System.out.print("Edad del paciente: ");
					int edad = 0;
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							edad = con.leerEntero();
							ExceptionChecker.checkNegativeNumber(edad);
							validarEntrada = true;
							con.quemarLinea();
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						} catch (NegativeNumberException e) {
							System.out.println(
									"No se permiten números negativos, digite un número correspondiente a las opciones mostradas.");
							con.quemarLinea();
						}
					}

					System.out.print("Sexo[\"F\" para femenino, \"M\" para masculino]: ");
					String sexo = "";
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							sexo = con.leerLinea();
							ExceptionChecker.checkGenderFormat(sexo);
							validarEntrada = true;
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						} catch (GenderFormatException e) {
							System.out.println("Formato inválido, digite \"F\" para femenino, \"M\" para masculino.");
						}
					}

					System.out.print("Número de identificación [Únicamente números, máximo 10]: ");
					int documentoPaciente = 0;
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							documentoPaciente = con.leerEntero();
							ExceptionChecker.checkNegativeNumber(documentoPaciente);
							ExceptionChecker.checkIdLimit(documentoPaciente);
							validarEntrada = true;
							con.quemarLinea();
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						} catch (NegativeNumberException e) {
							System.out.println(
									"No se permiten números negativos, digite un número correspondiente a las opciones mostradas.");
							con.quemarLinea();
						} catch(IdLimitException e) {
							System.out.println("Valor indicado supera el formato válido de identificación [Máximo 10 números]");
							con.quemarLinea();
						}
					}
					System.out.print("Tipo de documento: ");
					String tipoDocumento = "";
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							tipoDocumento = con.leerLinea();
							validarEntrada = true;
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						}
					}
					System.out.print("Resultado de Triaje [1 a 5]: ");
					int triaje = 0;
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							triaje = con.leerEntero();
							ExceptionChecker.checkNegativeNumber(triaje);
							validarEntrada = true;
							con.quemarLinea();
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						} catch (NegativeNumberException e) {
							System.out.println(
									"No se permiten números negativos, digite un número correspondiente a las opciones mostradas.");
							con.quemarLinea();
						}
					}

					System.out.print("Fecha de ingreso: ");
					String fechaIngreso = "";
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							fechaIngreso = con.leerLinea();
							ExceptionChecker.checkDateFormat(fechaIngreso);
							validarEntrada = true;
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						} catch (DateFormatException e) {
							System.out.println("Debe seguir el formato de fecha apropiado [día/mes/año, únicamente números]");
						}
					}

					System.out.print("Diagnóstico del paciente: ");
					String diagnostico = "";
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							diagnostico = con.leerLinea();
							validarEntrada = true;
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						}
					}

					mf.getPacienteDAO().crear(new PacienteDTO(nombre, edad, sexo, documentoPaciente, tipoDocumento,
							triaje, fechaIngreso, diagnostico));

					System.out.println("Registrando paciente...\n...");
					System.out.println("Paciente registrado.\nRetornando...");
					break;

				}

				// Actualizar paciente
				case 2: {
					con.quemarLinea();
					System.out.println("..Formulario de actualización de pacientes..");
					System.out.print("Indique el número de identificación correspondiente al paciente a modificar[Únicamente números]: ");
					int documentoPaciente = 0;
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							documentoPaciente = con.leerEntero();
							ExceptionChecker.checkNegativeNumber(documentoPaciente);
							validarEntrada = true;
							con.quemarLinea();
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						} catch (NegativeNumberException e) {
							System.out.println(
									"No se permiten números negativos, digite un número correspondiente a las opciones mostradas.");
							con.quemarLinea();
						}
					}
					System.out.print("Nuevo tipo de documento: ");
					String tipoDocumento = "";
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							tipoDocumento = con.leerLinea();
							validarEntrada = true;
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						}
					}
					System.out.print("Corrección de nombre del paciente: ");
					String nombre = "";
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							nombre = con.leerLinea();
							validarEntrada = true;
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido.");
						}
					}

					System.out.print("Corrección de edad del paciente: ");
					int edad = 0;
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							edad = con.leerEntero();
							ExceptionChecker.checkNegativeNumber(edad);
							validarEntrada = true;
							con.quemarLinea();
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						} catch (NegativeNumberException e) {
							System.out.println(
									"No se permiten números negativos, digite un número correspondiente a las opciones mostradas.");
							con.quemarLinea();
						}
					}

					System.out.print("Corrección de Sexo[Recuerde, \"F\" para femenino, \"M\" para masculino]: ");
					String sexo = "";
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							sexo = con.leerLinea();
							ExceptionChecker.checkGenderFormat(sexo);
							validarEntrada = true;
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						} catch (GenderFormatException e) {
							System.out.println("Formato inválido, digite \"F\" para femenino, \"M\" para masculino.");
						}
					}

					System.out.print("Nuevo resultado de Triaje [1 a 5]: ");
					int triaje = 0;
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							triaje = con.leerEntero();
							ExceptionChecker.checkNegativeNumber(triaje);
							validarEntrada = true;
							con.quemarLinea();
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						} catch (NegativeNumberException e) {
							System.out.println(
									"No se permiten números negativos, digite un número correspondiente a las opciones mostradas.");
							con.quemarLinea();
						}
					}

					System.out.print("Nueva fecha de ingreso: ");
					String fechaIngreso = "";
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							fechaIngreso = con.leerLinea();
							ExceptionChecker.checkDateFormat(fechaIngreso);
							validarEntrada = true;
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						} catch (DateFormatException e) {
							System.out.println("Debe seguir el formato de fecha apropiado [día/mes/año, únicamente números]");
						}
					}

					System.out.print("Nuevo diagnóstico del paciente: ");
					String diagnostico = "";
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							diagnostico = con.leerLinea();
							validarEntrada = true;
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						}
					}

					mf.getPacienteDAO().update(new PacienteDTO(null, 0, null, documentoPaciente, null, 0, null, null),
							new PacienteDTO(nombre, edad, sexo, documentoPaciente, tipoDocumento, triaje, fechaIngreso,
									diagnostico));

					System.out.println("Actualizando paciente...\n...");
					System.out.println("Paciente actualizado.\nRetornando...");
					break;

				}

				// Eliminar paciente
				case 3: {
					System.out.println("..Proceso de eliminiación de registro de un paciente..");
					System.out.print("Indique el número de identificación del paciente que desea retirar"
							+ "\n[Únicamente digitar números]: ");
					int pacienteEliminar = 0;
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							pacienteEliminar = con.leerEntero();
							ExceptionChecker.checkNegativeNumber(pacienteEliminar);
							validarEntrada = true;
							con.quemarLinea();
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						} catch (NegativeNumberException e) {
							System.out.println(
									"No se permiten números negativos, digite un número correspondiente a las opciones mostradas.");
							con.quemarLinea();
						}
					}

					if (mf.getPacienteDAO().eliminar(new PacienteDTO(null, opcion, null, pacienteEliminar, null,
							pacienteEliminar, null, null))) {
						System.out.println("Eliminando paciente...\n...");
						System.out.println("Paciente balaceado con éxito.\nRetornando...");
					}
					break;

				}

				// Mostrar pacientes
				case 4: {
					System.out.println("Reporte de paciente.");
					System.out.println(mf.getPacienteDAO().mostrarTodo());
					break;
				}

				// Retornar a menú anterior
				case 5: {
					System.out.println("Retornando...");
					break pacienteLoop;
				}

				default: {
					System.out.println(
							"Opción no valida, por favor digite un valor correspondiente a las opciones dadas.");
					break;
				}
				}
				break;
			}

			// Gestión personal
			case 2: {
				System.out.println("Gestión Personal");
				System.out.println("Seleccione la opción que desea realizar"
						+ "\n[Digite el número correspondiente a la opción deseada]: ");
				System.out.println("1 | Registrar personal.");
				System.out.println("2 | Actualizar datos de un personal en particular.");
				System.out.println("3 | Eliminar registro de personal.");
				System.out.println("4 | Reporte de personal disponible.");
				System.out.println("5 | Retornar al menú anterior.");
				System.out.println();
				int decision = 0;
				validarEntrada = false;
				while (!validarEntrada) {
					try {
						decision = con.leerEntero();
						ExceptionChecker.checkNegativeNumber(decision);
						validarEntrada = true;
					} catch (InputMismatchException e) {
						System.out.println("Formato ingresado no valido");
						con.quemarLinea();
					} catch (NegativeNumberException e) {
						System.out.println(
								"No se permiten números negativos, digite un número correspondiente a las opciones mostradas.");
						con.quemarLinea();
					}
				}
				pacienteLoop: switch (decision) {

				// Registro de personal
				case 1: {
					con.quemarLinea();
					System.out.println("..Formulario de registro de personal..");
					System.out.print("Nombre completo del personal a registrar: ");
					String nombre = "";
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							nombre = con.leerLinea();
							validarEntrada = true;
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido.");
						}
					}
					System.out.print("Número de identificación [Únicamente números]: ");
					int documentoPersonal = 0;
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							documentoPersonal = con.leerEntero();
							ExceptionChecker.checkNegativeNumber(documentoPersonal);
							ExceptionChecker.checkIdLimit(documentoPersonal);
							validarEntrada = true;
							con.quemarLinea();
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						} catch (NegativeNumberException e) {
							System.out.println(
									"No se permiten números negativos, digite un número correspondiente a las opciones mostradas.");
							con.quemarLinea();
						} catch (IdLimitException e) {
							System.out.println("Dato no válido [Máximo 10 caracteres, no puede ser negativo]");
						}
					}
					System.out.print("Sexo: ");
					String sexo = "";
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							sexo = con.leerLinea();
							ExceptionChecker.checkGenderFormat(sexo);
							validarEntrada = true;
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						} catch (GenderFormatException e) {
							System.out.println("Formato inválido, digite \"F\" para femenino, \"M\" para masculino.");
						}
					}
					System.out.print("Cargo que cumple la persona [Enfermero/a o doctor/a]: ");
					String profesion = "";
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							profesion = con.leerLinea();
							ExceptionChecker.checkWorkPosition(profesion);
							validarEntrada = true;
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						} catch (WorkPositionException e) {
							System.out.println("Formato no válido [Digite \"enfermero\" o \"doctor\" según corresponda a su profesión]");
						}
					}

					mf.getPersonalDAO().crear(new PersonalDTO(0, nombre, documentoPersonal, sexo, profesion));

					System.out.println("Registrando personal...\n...");
					System.out.println("Personal registrado.\nRetornando...");
					break;

				}

				// Actualización de personal
				case 2: {
					con.quemarLinea();
					System.out.println("..Formulario de actualización del personal..");
					System.out.print("Indique el número de identificación correspondiente al paciente a modificar [Únicamente números]: ");
					int documentoPersonal = 0;
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							documentoPersonal = con.leerEntero();
							ExceptionChecker.checkNegativeNumber(documentoPersonal);
							validarEntrada = true;
							con.quemarLinea();
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						} catch (NegativeNumberException e) {
							System.out.println(
									"No se permiten números negativos, digite un número correspondiente a las opciones mostradas.");
							con.quemarLinea();
						}
					}
					System.out.print("Corrección de nombre del empleado: ");
					String nombre = "";
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							nombre = con.leerLinea();
							validarEntrada = true;
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido.");
						}
					}
					con.quemarLinea();
					System.out.print("Ajuste de sexo [Recuerde, \"F\" para femenino, \"M\" para masculino]: ");
					String sexo = "";
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							sexo = con.leerLinea();
							ExceptionChecker.checkGenderFormat(sexo);
							validarEntrada = true;
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						} catch (GenderFormatException e) {
							System.out.println("Formato inválido, digite \"F\" para femenino, \"M\" para masculino.");
						}
					}
					System.out.print("Corrección de cargo [Enfermero/a o doctor/a]: ");
					String profesion = "";
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							profesion = con.leerLinea();
							ExceptionChecker.checkWorkPosition(profesion);
							validarEntrada = true;
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						} catch (WorkPositionException e) {
							System.out.println("Formato no válido [Digite \"enfermero\" o \"doctor\" según corresponda a su profesión]");
						}
					}

					mf.getPersonalDAO().update(new PersonalDTO(0, null, documentoPersonal, sexo, profesion),
							new PersonalDTO(0, nombre, documentoPersonal, sexo, profesion));

					System.out.println("Actualizando personal...\n...");
					System.out.println("Personal actualizado.\nRetornando...");
					break;

				}
				// Eliminar personal
				case 3: {
					System.out.println("..Proceso de despido de personal..");
					System.out.print("Indique el número de identificación del empleado a retirar"
							+ "\n[Únicamente digitar números]: ");
					int pacienteEliminar = 0;
					validarEntrada = false;
					while (!validarEntrada) {
						try {
							pacienteEliminar = con.leerEntero();
							validarEntrada = true;
							con.quemarLinea();
						} catch (InputMismatchException e) {
							System.out.println("Formato ingresado no valido");
							con.quemarLinea();
						}
					}

					if (mf.getPersonalDAO().eliminar(new PersonalDTO(decision, null, pacienteEliminar, null, null))) {
						System.out.println("Eliminando paciente...\n...");
						System.out.println("Empleado ascendido a cliente con éxito.\nRetornando...");
					}
					break;

				}

				// Mostrar personal
				case 4: {
					System.out.println("Reporte del personal.");
					System.out.println(mf.getPersonalDAO().mostrarTodo());
					break;
				}

				// Retornar al menú anterior
				case 5: {
					System.out.println("Retornando...");
					break pacienteLoop;
				}

				}
				break;
			}

			// Termina el programa
			case 3: {
				System.out.println("Tenga un buen día.");
				break mainLoop;

			}
			default: {
				System.out.println("Dato invalido, digite un número correspondiente a las opciones.");
				break;
			}
			}

		}
	}

}