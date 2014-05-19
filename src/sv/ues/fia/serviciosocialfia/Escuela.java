package sv.ues.fia.serviciosocialfia;

public class Escuela {
	
	private String codEscuela;
	private String nombreEscuela;
	
	public Escuela(){
		
	}

	public Escuela(String codEscuela, String nombreEscuela) {
		super();
		this.codEscuela = codEscuela;
		this.nombreEscuela = nombreEscuela;
	}

	public String getCodEscuela() {
		return codEscuela;
	}

	public void setCodEscuela(String codEscuela) {
		this.codEscuela = codEscuela;
	}

	public String getNombreEscuela() {
		return nombreEscuela;
	}

	public void setNombreEscuela(String nombreEscuela) {
		this.nombreEscuela = nombreEscuela;
	}
	
}
