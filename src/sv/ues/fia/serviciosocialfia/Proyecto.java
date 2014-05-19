package sv.ues.fia.serviciosocialfia;

public class Proyecto {

	private String idProyecto;
	private String idBeneficiario;
	private String idTipoProyecto;
	private String carnetEmpleado;
	private String idTipoDeTrabajo;
	private String nombreDeProyecto;
	private String descripcionProyecto;
	private int duracionProyecto;
	private String fechaInicioProy;
	private String fechaFinProy;
	private String estadoProyecto;
	private float valorProyecto;
	private String estadoAsignacion;
	
	public Proyecto(){
		
	}

	public Proyecto(String idProyecto, String idBeneficiario,
			String idTipoProyecto, String carnetEmpleado,
			String idTipoDeTrabajo, String nombreDeProyecto,
			String descripcionProyecto, int duracionProyecto,
			String fechaInicioProy, String fechaFinProy, String estadoProyecto,
			float valorProyecto, String estadoAsignacion) {
		super();
		this.idProyecto = idProyecto;
		this.idBeneficiario = idBeneficiario;
		this.idTipoProyecto = idTipoProyecto;
		this.carnetEmpleado = carnetEmpleado;
		this.idTipoDeTrabajo = idTipoDeTrabajo;
		this.nombreDeProyecto = nombreDeProyecto;
		this.descripcionProyecto = descripcionProyecto;
		this.duracionProyecto = duracionProyecto;
		this.fechaInicioProy = fechaInicioProy;
		this.fechaFinProy = fechaFinProy;
		this.estadoProyecto = estadoProyecto;
		this.valorProyecto = valorProyecto;
		this.estadoAsignacion = estadoAsignacion;
	}

	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getIdBeneficiario() {
		return idBeneficiario;
	}

	public void setIdBeneficiario(String idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}

	public String getIdTipoProyecto() {
		return idTipoProyecto;
	}

	public void setIdTipoProyecto(String idTipoProyecto) {
		this.idTipoProyecto = idTipoProyecto;
	}

	public String getCarnetEmpleado() {
		return carnetEmpleado;
	}

	public void setCarnetEmpleado(String carnetEmpleado) {
		this.carnetEmpleado = carnetEmpleado;
	}

	public String getIdTipoDeTrabajo() {
		return idTipoDeTrabajo;
	}

	public void setIdTipoDeTrabajo(String idTipoDeTrabajo) {
		this.idTipoDeTrabajo = idTipoDeTrabajo;
	}

	public String getNombreDeProyecto() {
		return nombreDeProyecto;
	}

	public void setNombreDeProyecto(String nombreDeProyecto) {
		this.nombreDeProyecto = nombreDeProyecto;
	}

	public String getDescripcionProyecto() {
		return descripcionProyecto;
	}

	public void setDescripcionProyecto(String descripcionProyecto) {
		this.descripcionProyecto = descripcionProyecto;
	}

	public int getDuracionProyecto() {
		return duracionProyecto;
	}

	public void setDuracionProyecto(int duracionProyecto) {
		this.duracionProyecto = duracionProyecto;
	}

	public String getFechaInicioProy() {
		return fechaInicioProy;
	}

	public void setFechaInicioProy(String fechaInicioProy) {
		this.fechaInicioProy = fechaInicioProy;
	}

	public String getFechaFinProy() {
		return fechaFinProy;
	}

	public void setFechaFinProy(String fechaFinProy) {
		this.fechaFinProy = fechaFinProy;
	}

	public String getEstadoProyecto() {
		return estadoProyecto;
	}

	public void setEstadoProyecto(String estadoProyecto) {
		this.estadoProyecto = estadoProyecto;
	}

	public float getValorProyecto() {
		return valorProyecto;
	}

	public void setValorProyecto(float valorProyecto) {
		this.valorProyecto = valorProyecto;
	}

	public String getEstadoAsignacion() {
		return estadoAsignacion;
	}

	public void setEstadoAsignacion(String estadoAsignacion) {
		this.estadoAsignacion = estadoAsignacion;
	}
	
}
