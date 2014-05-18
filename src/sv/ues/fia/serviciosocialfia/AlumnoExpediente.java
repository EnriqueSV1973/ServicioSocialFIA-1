package sv.ues.fia.serviciosocialfia;

public class AlumnoExpediente {

	private String idExpediente;
	private String idBitacora;
	private String carnetEmpleado;
	private String codCarrera;
	private String carnetAlumno;
	private String nombreAlumno;
	private String apellidoAlumno;
	private String sexoAlumno;
	private String fechaInicioServicio;
	private String fechaFinServicio;
	private String estadoExpediente;
	private String telefono;
	private String email;
	private String observaciones;
	private float valorServicio;
	private int horasAcumula;
	private String fechaAcumula;

	public AlumnoExpediente() {

	}

	public AlumnoExpediente(String idExpediente, String idBitacora,
			String carnetEmpleado, String codCarrera, String carnetAlumno,
			String nombreAlumno, String apellidoAlumno, String sexoAlumno,
			String fechaInicioServicio, String fechaFinServicio,
			String estadoExpediente, String telefono, String email,
			String observaciones, float valorServicio, int horasAcumula,
			String fechaAcumula) {
		this.idExpediente = idExpediente;
		this.idBitacora = idBitacora;
		this.carnetEmpleado = carnetEmpleado;
		this.codCarrera = codCarrera;
		this.carnetAlumno = carnetAlumno;
		this.nombreAlumno = nombreAlumno;
		this.apellidoAlumno = apellidoAlumno;
		this.sexoAlumno = sexoAlumno;
		this.fechaInicioServicio = fechaInicioServicio;
		this.fechaFinServicio = fechaFinServicio;
		this.estadoExpediente = estadoExpediente;
		this.telefono = telefono;
		this.email = email;
		this.observaciones = observaciones;
		this.valorServicio = valorServicio;
		this.horasAcumula = horasAcumula;
		this.fechaAcumula = fechaAcumula;
	}

	public String getIdExpediente() {
		return idExpediente;
	}

	public void setIdExpediente(String idExpediente) {
		this.idExpediente = idExpediente;
	}

	public String getIdBitacora() {
		return idBitacora;
	}

	public void setIdBitacora(String idBitacora) {
		this.idBitacora = idBitacora;
	}

	public String getCarnetEmpleado() {
		return carnetEmpleado;
	}

	public void setCarnetEmpleado(String carnetEmpleado) {
		this.carnetEmpleado = carnetEmpleado;
	}

	public String getCodCarrera() {
		return codCarrera;
	}

	public void setCodCarrera(String codCarrera) {
		this.codCarrera = codCarrera;
	}

	public String getCarnetAlumno() {
		return carnetAlumno;
	}

	public void setCarnetAlumno(String carnetAlumno) {
		this.carnetAlumno = carnetAlumno;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getApellidoAlumno() {
		return apellidoAlumno;
	}

	public void setApellidoAlumno(String apellidoAlumno) {
		this.apellidoAlumno = apellidoAlumno;
	}

	public String getSexoAlumno() {
		return sexoAlumno;
	}

	public void setSexoAlumno(String sexoAlumno) {
		this.sexoAlumno = sexoAlumno;
	}

	public String getFechaInicioServicio() {
		return fechaInicioServicio;
	}

	public void setFechaInicioServicio(String fechaInicioServicio) {
		this.fechaInicioServicio = fechaInicioServicio;
	}

	public String getFechaFinServicio() {
		return fechaFinServicio;
	}

	public void setFechaFinServicio(String fechaFinServicio) {
		this.fechaFinServicio = fechaFinServicio;
	}

	public String getEstadoExpediente() {
		return estadoExpediente;
	}

	public void setEstadoExpediente(String estadoExpediente) {
		this.estadoExpediente = estadoExpediente;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public float getValorServicio() {
		return valorServicio;
	}

	public void setValorServicio(float valorServicio) {
		this.valorServicio = valorServicio;
	}

	public int getHorasAcumula() {
		return horasAcumula;
	}

	public void setHorasAcumula(int horasAcumula) {
		this.horasAcumula = horasAcumula;
	}

	public String getFechaAcumula() {
		return fechaAcumula;
	}

	public void setFechaAcumula(String fechaAcumula) {
		this.fechaAcumula = fechaAcumula;
	}

}
