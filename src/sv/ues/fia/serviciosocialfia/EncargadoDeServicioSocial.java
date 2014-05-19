package sv.ues.fia.serviciosocialfia;

public class EncargadoDeServicioSocial {

	private String carnetEmpleado;
	private String codEscuela;
	private String nombreDirector;
	private String apellidoDirector;
	private String sexoDirector;
	private String fechaInicio;
	private String fechaFin;
	
	public EncargadoDeServicioSocial() {

	}
	
	public EncargadoDeServicioSocial(String carnetEmpleado, String codEscuela,
			String nombreDirector, String apellidoDirector,
			String sexoDirector, String fechaInicio, String fechaFin) {
		super();
		this.carnetEmpleado = carnetEmpleado;
		this.codEscuela = codEscuela;
		this.nombreDirector = nombreDirector;
		this.apellidoDirector = apellidoDirector;
		this.sexoDirector = sexoDirector;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	public String getCarnetEmpleado() {
		return carnetEmpleado;
	}
	public void setCarnetEmpleado(String carnetEmpleado) {
		this.carnetEmpleado = carnetEmpleado;
	}
	public String getCodEscuela() {
		return codEscuela;
	}
	public void setCodEscuela(String codEscuela) {
		this.codEscuela = codEscuela;
	}
	public String getNombreDirector() {
		return nombreDirector;
	}
	public void setNombreDirector(String nombreDirector) {
		this.nombreDirector = nombreDirector;
	}
	public String getApellidoDirector() {
		return apellidoDirector;
	}
	public void setApellidoDirector(String apellidoDirector) {
		this.apellidoDirector = apellidoDirector;
	}
	public String getSexoDirector() {
		return sexoDirector;
	}
	public void setSexoDirector(String sexoDirector) {
		this.sexoDirector = sexoDirector;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}
