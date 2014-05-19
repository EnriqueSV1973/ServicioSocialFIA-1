package sv.ues.fia.serviciosocialfia;

public class Tutor {

	private String codigoTutor;
	private String idBeneficiario;
	private String nombreTutor;
	private String apellidoTutor;
	private String sexoTutor;
	
	public Tutor(){
		
	}

	public Tutor(String codigoTutor, String idBeneficiario, String nombreTutor,
			String apellidoTutor, String sexoTutor) {
		super();
		this.codigoTutor = codigoTutor;
		this.idBeneficiario = idBeneficiario;
		this.nombreTutor = nombreTutor;
		this.apellidoTutor = apellidoTutor;
		this.sexoTutor = sexoTutor;
	}

	public String getCodigoTutor() {
		return codigoTutor;
	}

	public void setCodigoTutor(String codigoTutor) {
		this.codigoTutor = codigoTutor;
	}

	public String getIdBeneficiario() {
		return idBeneficiario;
	}

	public void setIdBeneficiario(String idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}

	public String getNombreTutor() {
		return nombreTutor;
	}

	public void setNombreTutor(String nombreTutor) {
		this.nombreTutor = nombreTutor;
	}

	public String getApellidoTutor() {
		return apellidoTutor;
	}

	public void setApellidoTutor(String apellidoTutor) {
		this.apellidoTutor = apellidoTutor;
	}

	public String getSexoTutor() {
		return sexoTutor;
	}

	public void setSexoTutor(String sexoTutor) {
		this.sexoTutor = sexoTutor;
	}
	
}
