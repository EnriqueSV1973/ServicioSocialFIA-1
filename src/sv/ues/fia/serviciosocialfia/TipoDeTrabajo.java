package sv.ues.fia.serviciosocialfia;

public class TipoDeTrabajo {
	
	private String idTipoDeTrabajo;
	private String nombreTipo;
	
	public TipoDeTrabajo(){
		
	}

	public TipoDeTrabajo(String idTipoDeTrabajo, String nombreTipo) {
		super();
		this.idTipoDeTrabajo = idTipoDeTrabajo;
		this.nombreTipo = nombreTipo;
	}

	public String getIdTipoDeTrabajo() {
		return idTipoDeTrabajo;
	}

	public void setIdTipoDeTrabajo(String idTipoDeTrabajo) {
		this.idTipoDeTrabajo = idTipoDeTrabajo;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	
}
