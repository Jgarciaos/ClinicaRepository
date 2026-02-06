package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.PacienteDAO;
import co.edu.unbosque.model.persistence.PersonalDAO;

public class ModelFacade {

	private PacienteDAO pacienteDAO;
	private PersonalDAO personalDAO;

	public ModelFacade() {
		pacienteDAO = new PacienteDAO();
		personalDAO = new PersonalDAO();
	}

	public PacienteDAO getPacienteDAO() {
		return pacienteDAO;
	}

	public void setPacienteDAO(PacienteDAO pacienteDAO) {
		this.pacienteDAO = pacienteDAO;
	}

	public PersonalDAO getPersonalDAO() {
		return personalDAO;
	}

	public void setPersonalDAO(PersonalDAO personalDAO) {
		this.personalDAO = personalDAO;
	}

}
