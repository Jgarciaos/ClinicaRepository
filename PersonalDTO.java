package co.edu.unbosque.model;

public class PersonalDTO {
	private int id;
	private String nombre;
	private int documento;
	private String sexo;
	private String profesion;

	public PersonalDTO() {
		// TODO Auto-generated constructor stub
	}

	public PersonalDTO(int id, String nombre, int documento, String sexo, String profesion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.documento = documento;
		this.sexo = sexo;
		this.profesion = profesion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	@Override
	public String toString() {
		return "Personal" + "\nId:" + id + "\nNombre:" + nombre + "\nDocumento:" + documento + "\nSexo:" + sexo
				+ "\nProfesion:" + profesion;
	}

}
