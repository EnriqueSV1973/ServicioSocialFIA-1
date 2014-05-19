package sv.ues.fia.serviciosocialfia;

public class Carreras {

	private String codCarrera;
	private String codEscuela;
	private String nombreCarrera;
	
	public Carreras(){
		
	}

	public Carreras(String codCarrera, String codEscuela, String nombreCarrera) {
		super();
		this.codCarrera = codCarrera;
		this.codEscuela = codEscuela;
		this.nombreCarrera = nombreCarrera;
	}

	public String getCodCarrera() {
		return codCarrera;
	}

	public void setCodCarrera(String codCarrera) {
		this.codCarrera = codCarrera;
	}

	public String getCodEscuela() {
		return codEscuela;
	}

	public void setCodEscuela(String codEscuela) {
		this.codEscuela = codEscuela;
	}

	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}
	
}
