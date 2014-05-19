package sv.ues.fia.serviciosocialfia;

public class Bitacora {

	private String idBitacora;
	private String codigoTutor;
	private String estadoActividad;
	private String fechaAutorizado;
	private float valorActividad;
	private float precioTrabajo;
	
	public Bitacora(){
		
	}

	public Bitacora(String idBitacora, String codigoTutor,
			String estadoActividad, String fechaAutorizado,
			float valorActividad, float precioTrabajo) {
		super();
		this.idBitacora = idBitacora;
		this.codigoTutor = codigoTutor;
		this.estadoActividad = estadoActividad;
		this.fechaAutorizado = fechaAutorizado;
		this.valorActividad = valorActividad;
		this.precioTrabajo = precioTrabajo;
	}

	public String getIdBitacora() {
		return idBitacora;
	}

	public void setIdBitacora(String idBitacora) {
		this.idBitacora = idBitacora;
	}

	public String getCodigoTutor() {
		return codigoTutor;
	}

	public void setCodigoTutor(String codigoTutor) {
		this.codigoTutor = codigoTutor;
	}

	public String getEstadoActividad() {
		return estadoActividad;
	}

	public void setEstadoActividad(String estadoActividad) {
		this.estadoActividad = estadoActividad;
	}

	public String getFechaAutorizado() {
		return fechaAutorizado;
	}

	public void setFechaAutorizado(String fechaAutorizado) {
		this.fechaAutorizado = fechaAutorizado;
	}

	public float getValorActividad() {
		return valorActividad;
	}

	public void setValorActividad(float valorActividad) {
		this.valorActividad = valorActividad;
	}

	public float getPrecioTrabajo() {
		return precioTrabajo;
	}

	public void setPrecioTrabajo(float precioTrabajo) {
		this.precioTrabajo = precioTrabajo;
	}
	
}
