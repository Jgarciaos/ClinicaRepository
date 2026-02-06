package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Paciente;
import co.edu.unbosque.model.PacienteDTO;

public class PacienteDAO {

	private ArrayList<Paciente> listaPacientes;
	private final String TEXT_FILE_NAME = "pacientes.csv";

	public PacienteDAO() {
		listaPacientes = new ArrayList<Paciente>();
		cargarDesdeArchivo();
	}

	public boolean crear(PacienteDTO datoNuevo) {
		if (find(DataMapper.pacienteDTOToPaciente(datoNuevo)) == null) {
			listaPacientes.add(DataMapper.pacienteDTOToPaciente(datoNuevo));
			escribirEnArchivo();
			return true;
		} else {
			return false;
		}
	}

	public String mostrarTodo() {
		String salida = "";
		if (listaPacientes.isEmpty()) {
			return "No hay cuentas en la lista";
		} else {
			for (Paciente paciente : listaPacientes) {
				salida += paciente;
			}
			return salida;
		}
	}

	public boolean eliminar(PacienteDTO datoEliminar) {
		Paciente found = find(DataMapper.pacienteDTOToPaciente(datoEliminar));
		if (found != null) {
			listaPacientes.remove(found);
			escribirEnArchivo();
			return true;
		} else {
			return false;
		}
	}

	public Paciente find(Paciente toFind) {
		Paciente found = null;
		if (!listaPacientes.isEmpty()) {
			for (Paciente paciente : listaPacientes) {
				if (paciente.getDocumento() == toFind.getDocumento()) {
					found = paciente;
					return found;
				} else {
					continue;
				}
			}
		} else {
			return null;
		}
		return null;
	}

	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaPacientes.size(); i++) {
			contenido += listaPacientes.get(i).getId() + ";";
			contenido += listaPacientes.get(i).getNombre() + ";";
			contenido += listaPacientes.get(i).getEdad() + ";";
			contenido += listaPacientes.get(i).getSexo() + ";";
			contenido += listaPacientes.get(i).getDocumento() + ";";
			contenido += listaPacientes.get(i).getTipoDocumento() + ";";
			contenido += listaPacientes.get(i).getTriaje() + ";";
			contenido += listaPacientes.get(i).getFechaIngreso() + ";";
			contenido += listaPacientes.get(i).getDiagnostico() + "\n";

		}

		FileManager.escribirArchivoDeTexto(TEXT_FILE_NAME, contenido);

	}

	public void cargarDesdeArchivo() {
		String contenido = FileManager.leerArchivoDeTexto(TEXT_FILE_NAME);
		if (contenido.isBlank() || contenido.isEmpty()) {
			return;
		}
		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			int id = Integer.parseInt(columnas[0]);
			String nombre = columnas[1];
			int edad = Integer.parseInt(columnas[2]);
			String sexo = columnas[3];
			int documento = Integer.parseInt(columnas[4]);
			String tipoDocumento = columnas[5];
			int triaje = Integer.parseInt(columnas[6]);
			String fechaIngreso = columnas[7];
			String diagnostico = columnas[8];
			listaPacientes.add(new Paciente(id, nombre, edad, sexo, documento, tipoDocumento, triaje, fechaIngreso, diagnostico));
		}

	}
	
    public boolean update(PacienteDTO previous, PacienteDTO newData) {
    	Paciente found = find(DataMapper.pacienteDTOToPaciente(previous));
        if (found != null) {
            listaPacientes.remove(found);
            listaPacientes.add(DataMapper.pacienteDTOToPaciente(newData));
            escribirEnArchivo();
            return true;
        } else {
            return false;
        }
    }

}
