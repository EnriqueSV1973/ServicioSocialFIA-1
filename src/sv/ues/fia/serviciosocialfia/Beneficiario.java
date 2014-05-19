package sv.ues.fia.serviciosocialfia;

public class Beneficiario {

	private String idBeneficiario;
	private String carnetEmpleado;
	private String nombreOrganizacion;
	private String nombreRepresentante;
	private String apellidoRepresentante;
	private int telefonoBenef;
	private String direccionBenef;
	private String email;
	
	public Beneficiario(){
		
	}

	public Beneficiario(String idBeneficiario, String carnetEmpleado,
			String nombreOrganizacion, String nombreRepresentante,
			String apellidoRepresentante, int telefonoBenef,
			String direccionBenef, String email) {
		this.idBeneficiario = idBeneficiario;
		this.carnetEmpleado = carnetEmpleado;
		this.nombreOrganizacion = nombreOrganizacion;
		this.nombreRepresentante = nombreRepresentante;
		this.apellidoRepresentante = apellidoRepresentante;
		this.telefonoBenef = telefonoBenef;
		this.direccionBenef = direccionBenef;
		this.email = email;
	}

	public String getIdBeneficiario() {
		return idBeneficiario;
	}

	public void setIdBeneficiario(String idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}

	public String getCarnetEmpleado() {
		return carnetEmpleado;
	}

	public void setCarnetEmpleado(String carnetEmpleado) {
		this.carnetEmpleado = carnetEmpleado;
	}

	public String getNombreOrganizacion() {
		return nombreOrganizacion;
	}

	public void setNombreOrganizacion(String nombreOrganizacion) {
		this.nombreOrganizacion = nombreOrganizacion;
	}

	public String getNombreRepresentante() {
		return nombreRepresentante;
	}

	public void setNombreRepresentante(String nombreRepresentante) {
		this.nombreRepresentante = nombreRepresentante;
	}

	public String getApellidoRepresentante() {
		return apellidoRepresentante;
	}

	public void setApellidoRepresentante(String apellidoRepresentante) {
		this.apellidoRepresentante = apellidoRepresentante;
	}

	public int getTelefonoBenef() {
		return telefonoBenef;
	}

	public void setTelefonoBenef(int telefonoBenef) {
		this.telefonoBenef = telefonoBenef;
	}

	public String getDireccionBenef() {
		return direccionBenef;
	}

	public void setDireccionBenef(String direccionBenef) {
		this.direccionBenef = direccionBenef;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
