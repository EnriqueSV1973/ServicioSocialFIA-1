package sv.ues.fia.serviciosocialfia;

public class Registro {

	private String idProyecto;
	private String idExpediente;
	private String idBitacora;
	private String horaInicio;
	private String horaFin;
	private String fechaActividad;
	private int cantidadHoras;
	
	public Registro(){
		
	}

	public Registro(String idProyecto, String idExpediente, String idBitacora,
			String horaInicio, String horaFin, String fechaActividad,
			int cantidadHoras) {
		super();
		this.idProyecto = idProyecto;
		this.idExpediente = idExpediente;
		this.idBitacora = idBitacora;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.fechaActividad = fechaActividad;
		this.cantidadHoras = cantidadHoras;
	}

	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
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

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public String getFechaActividad() {
		return fechaActividad;
	}

	public void setFechaActividad(String fechaActividad) {
		this.fechaActividad = fechaActividad;
	}

	public int getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	
}
