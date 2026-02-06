package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Personal;
import co.edu.unbosque.model.PersonalDTO;

public class PersonalDAO {
	private ArrayList<Personal> listaPersonal;
	private final String TEXT_FILE_NAME = "personal.csv";

	public PersonalDAO() {
		listaPersonal = new ArrayList<>();
		cargarDesdeArchivo();
	}

	public boolean crear(PersonalDTO datoNuevo) {
		if (find(DataMapper.personalDTOToPersonal(datoNuevo)) == null) {
			listaPersonal.add(DataMapper.personalDTOToPersonal(datoNuevo));
			escribirArchivo();
			return true;
		} else {
			return false;
		}
	}

	public String mostrarTodo() {
		String salida = "";
		if (listaPersonal.isEmpty()) {
			return "No hay cuentas en la lista";
		} else {
			for (Personal personal : listaPersonal) {
				salida += personal;
			}
			return salida;
		}
	}

	public boolean eliminar(PersonalDTO datoEliminar) {
		Personal found = find(DataMapper.personalDTOToPersonal(datoEliminar));
		if (found != null) {
			listaPersonal.remove(found);
			escribirArchivo();
			return true;
		} else {
			return false;
		}
	}

	public Personal find(Personal toFind) {
		Personal found = null;
		if (!listaPersonal.isEmpty()) {
			for (Personal personal : listaPersonal) {
				if (personal.getDocumento() == toFind.getDocumento()) {
					found = personal;
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

	public void escribirArchivo() {
		String contenido = "";
		for (int i = 0; i < listaPersonal.size(); i++) {
			contenido += listaPersonal.get(i).getId() + ";";
			contenido += listaPersonal.get(i).getNombre() + ";";
			contenido += listaPersonal.get(i).getDocumento() + ";";
			contenido += listaPersonal.get(i).getSexo() + ";";
			contenido += listaPersonal.get(i).getProfesion() + "\n";

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
			int documento = Integer.parseInt(columnas[2]);
			String sexo = columnas[3];
			String profesion = columnas[4];
			listaPersonal.add(new Personal(id, nombre, documento, sexo, profesion));
		}
	}
	
	
    public boolean update(PersonalDTO previous, PersonalDTO newData) {
        Personal found = find(DataMapper.personalDTOToPersonal(previous));
        if (found != null) {
            listaPersonal.remove(found);
            listaPersonal.add(DataMapper.personalDTOToPersonal(newData));
            escribirArchivo();
            return true;
        } else {
            return false;
        }
    }

}
