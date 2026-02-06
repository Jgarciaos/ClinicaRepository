package co.edu.unbosque.model;

public class PacienteDTO {

	private int id;
	private String nombre;
	private int edad;
	private String sexo;
	private int documento;
	private String tipoDocumento;
	private int triaje;
	private String fechaIngreso;
	private String diagnostico;

	public PacienteDTO() {
		// TODO Auto-generated constructor stub
	}

	public PacienteDTO(int id, String nombre, int edad, String sexo, int documento, String tipoDocumento, int triaje,
			String fechaIngreso, String diagnostico) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.triaje = triaje;
		this.fechaIngreso = fechaIngreso;
		this.diagnostico = diagnostico;
	}

	public PacienteDTO(String nombre, int edad, String sexo, int documento, String tipoDocumento, int triaje,
			String fechaIngreso, String diagnostico) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.triaje = triaje;
		this.fechaIngreso = fechaIngreso;
		this.diagnostico = diagnostico;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getTriaje() {
		return triaje;
	}

	public void setTriaje(int triaje) {
		this.triaje = triaje;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	@Override
	public String toString() {
		return "PacienteDTO [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", documento="
				+ documento + ", tipoDocumento=" + tipoDocumento + ", triaje=" + triaje + ", fechaIngreso="
				+ fechaIngreso + ", diagnostico=" + diagnostico + "]";
	}

}
