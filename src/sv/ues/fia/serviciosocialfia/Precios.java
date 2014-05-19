package sv.ues.fia.serviciosocialfia;

public class Precios {
	
	private String idTipoDeTrabajo;
	private int corr;
	private float precio;
	private String fechaInicialApliPre;
	private String fechaFinalApliPre;
	private String observacion;
	
	public Precios(){
		
	}

	public Precios(String idTipoDeTrabajo, int corr, float precio,
			String fechaInicialApliPre, String fechaFinalApliPre,
			String observacion) {
		super();
		this.idTipoDeTrabajo = idTipoDeTrabajo;
		this.corr = corr;
		this.precio = precio;
		this.fechaInicialApliPre = fechaInicialApliPre;
		this.fechaFinalApliPre = fechaFinalApliPre;
		this.observacion = observacion;
	}

	public String getIdTipoDeTrabajo() {
		return idTipoDeTrabajo;
	}

	public void setIdTipoDeTrabajo(String idTipoDeTrabajo) {
		this.idTipoDeTrabajo = idTipoDeTrabajo;
	}

	public int getCorr() {
		return corr;
	}

	public void setCorr(int corr) {
		this.corr = corr;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getFechaInicialApliPre() {
		return fechaInicialApliPre;
	}

	public void setFechaInicialApliPre(String fechaInicialApliPre) {
		this.fechaInicialApliPre = fechaInicialApliPre;
	}

	public String getFechaFinalApliPre() {
		return fechaFinalApliPre;
	}

	public void setFechaFinalApliPre(String fechaFinalApliPre) {
		this.fechaFinalApliPre = fechaFinalApliPre;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
}
