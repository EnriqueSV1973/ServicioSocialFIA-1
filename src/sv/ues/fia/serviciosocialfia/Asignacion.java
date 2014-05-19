package sv.ues.fia.serviciosocialfia;

public class Asignacion {

	private String idProyecto;
	private String idExpediente;
	
	public Asignacion(){
		
	}
	
	public Asignacion(String idProyecto, String idExpediente) {
		super();
		this.idProyecto = idProyecto;
		this.idExpediente = idExpediente;
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
	
	
}
