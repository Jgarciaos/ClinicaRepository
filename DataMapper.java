package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Paciente;
import co.edu.unbosque.model.PacienteDTO;
import co.edu.unbosque.model.Personal;
import co.edu.unbosque.model.PersonalDTO;

public class DataMapper {

	// Personal

	public static Personal personalDTOToPersonal(PersonalDTO newData) {
		Personal entity;
		entity = new Personal(newData.getId(), newData.getNombre(), newData.getDocumento(), newData.getSexo(),
				newData.getProfesion());
		return entity;
	}

	public static PersonalDTO personalToPersonalDTO(Personal entity) {
		PersonalDTO dto;
		dto = new PersonalDTO(entity.getId(), entity.getNombre(), entity.getDocumento(), entity.getSexo(),
				entity.getProfesion());
		return dto;
	}

	public static ArrayList<PersonalDTO> listaPersonalToListaPersonalDTO(ArrayList<Personal> entityList) {
		ArrayList<PersonalDTO> dtoList = new ArrayList<>();
		for (PersonalDTO p : dtoList) {
			dtoList.add(new PersonalDTO(p.getId(), p.getNombre(), p.getDocumento(), p.getSexo(), p.getProfesion()));

		}
		return dtoList;
	}

	public static ArrayList<Personal> listaPersonalDTOToListaPersonal(ArrayList<PersonalDTO> dtoList) {
		ArrayList<Personal> entityList = new ArrayList<>();
		for (PersonalDTO p : dtoList) {
			entityList.add(new Personal(p.getId(), p.getNombre(), p.getDocumento(), p.getSexo(), p.getProfesion()));
		}
		return entityList;
	}

	// Paciente

	public static Paciente pacienteDTOToPaciente(PacienteDTO newData) {
		Paciente entity;
		entity = new Paciente(newData.getNombre(), newData.getEdad(), newData.getSexo(), newData.getDocumento(),
				newData.getTipoDocumento(), newData.getTriaje(), newData.getFechaIngreso(), newData.getDiagnostico());
		return entity;
	}

	public static PacienteDTO pacienteToPacienteDTO(Paciente newData) {
		PacienteDTO dto;
		dto = new PacienteDTO(newData.getNombre(), newData.getEdad(), newData.getSexo(), newData.getDocumento(),
				newData.getTipoDocumento(), newData.getTriaje(), newData.getFechaIngreso(), newData.getDiagnostico());
		return dto;
	}

	public static ArrayList<PacienteDTO> listaPacienteToListaPacienteDTO(ArrayList<Paciente> entityList) {
		ArrayList<PacienteDTO> dtoList = new ArrayList<>();
		for (Paciente paciente : entityList) {
			dtoList.add(new PacienteDTO(paciente.getNombre(), paciente.getEdad(), paciente.getSexo(),
					paciente.getDocumento(), paciente.getTipoDocumento(), paciente.getTriaje(),
					paciente.getFechaIngreso(), paciente.getDiagnostico()));
		}
		return dtoList;

	}

	public static ArrayList<Paciente> listaPacienteDTOToListaPaciente(ArrayList<PacienteDTO> dtoList) {
		ArrayList<Paciente> entityList = new ArrayList<>();
		for (PacienteDTO pacienteDto : dtoList) {
			entityList.add(new Paciente(pacienteDto.getNombre(), pacienteDto.getEdad(), pacienteDto.getSexo(),
					pacienteDto.getDocumento(), pacienteDto.getTipoDocumento(), pacienteDto.getTriaje(),
					pacienteDto.getFechaIngreso(), pacienteDto.getDiagnostico()));
		}
		return entityList;

	}

}