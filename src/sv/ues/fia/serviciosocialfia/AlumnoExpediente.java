package sv.ues.fia.serviciosocialfia;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlumnoExpediente {

	private String idExpediente;
	private String idBitacora;
	private String carnetEmpleado;
	private String codCarrera;
	private String carnetAlumno;
	private String nombreAlumno;
	private String apellidoAlumno;
	private String sexoAlumno;
	private String fechaInicioServicio;
	private String fechaFinServicio;
	private String estadoExpediente;
	private String telefono;
	private String email;
	private String observaciones;
	private float valorServicio;
	private int horasAcumula;
	private String fechaAcumula;

	public AlumnoExpediente() {

	}

	public AlumnoExpediente(String idExpediente, String idBitacora,
			String carnetEmpleado, String codCarrera, String carnetAlumno,
			String nombreAlumno, String apellidoAlumno, String sexoAlumno,
			String fechaInicioServicio, String fechaFinServicio,
			String estadoExpediente, String telefono, String email,
			String observaciones, float valorServicio, int horasAcumula,
			String fechaAcumula) {
		this.idExpediente = idExpediente;
		this.idBitacora = idBitacora;
		this.carnetEmpleado = carnetEmpleado;
		this.codCarrera = codCarrera;
		this.carnetAlumno = carnetAlumno;
		this.nombreAlumno = nombreAlumno;
		this.apellidoAlumno = apellidoAlumno;
		this.sexoAlumno = sexoAlumno;
		this.fechaInicioServicio = fechaInicioServicio;
		this.fechaFinServicio = fechaFinServicio;
		this.estadoExpediente = estadoExpediente;
		this.telefono = telefono;
		this.email = email;
		this.observaciones = observaciones;
		this.valorServicio = valorServicio;
		this.horasAcumula = horasAcumula;
		this.fechaAcumula = fechaAcumula;
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

	public String getCarnetEmpleado() {
		return carnetEmpleado;
	}

	public void setCarnetEmpleado(String carnetEmpleado) {
		this.carnetEmpleado = carnetEmpleado;
	}

	public String getCodCarrera() {
		return codCarrera;
	}

	public void setCodCarrera(String codCarrera) {
		this.codCarrera = codCarrera;
	}

	public String getCarnetAlumno() {
		return carnetAlumno;
	}

	public void setCarnetAlumno(String carnetAlumno) {
		this.carnetAlumno = carnetAlumno;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getApellidoAlumno() {
		return apellidoAlumno;
	}

	public void setApellidoAlumno(String apellidoAlumno) {
		this.apellidoAlumno = apellidoAlumno;
	}

	public String getSexoAlumno() {
		return sexoAlumno;
	}

	public void setSexoAlumno(String sexoAlumno) {
		this.sexoAlumno = sexoAlumno;
	}

	public String getFechaInicioServicio() {
		return fechaInicioServicio;
	}

	public void setFechaInicioServicio(String fechaInicioServicio) {
		this.fechaInicioServicio = fechaInicioServicio;
	}

	public String getFechaFinServicio() {
		return fechaFinServicio;
	}

	public void setFechaFinServicio(String fechaFinServicio) {
		this.fechaFinServicio = fechaFinServicio;
	}

	public String getEstadoExpediente() {
		return estadoExpediente;
	}

	public void setEstadoExpediente(String estadoExpediente) {
		this.estadoExpediente = estadoExpediente;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public float getValorServicio() {
		return valorServicio;
	}

	public void setValorServicio(float valorServicio) {
		this.valorServicio = valorServicio;
	}

	public int getHorasAcumula() {
		return horasAcumula;
	}

	public void setHorasAcumula(int horasAcumula) {
		this.horasAcumula = horasAcumula;
	}

	public String getFechaAcumula() {
		return fechaAcumula;
	}

	public void setFechaAcumula(String fechaAcumula) {
		this.fechaAcumula = fechaAcumula;
	}
	public static boolean esEmailValido(String email) {
		boolean isValid = false;

		String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		CharSequence inputStr = email;

		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.matches()) {
			isValid = true;
		}
		return isValid;
	}

	public boolean validarFecha(String fecha) {
		boolean resultado = true;
		if (fecha == null)
			resultado = false;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy",
				Locale.getDefault());
		if (fecha.trim().length() != dateFormat.toPattern().length())
			resultado = false;
		// dateFormat.setLenient(false);
		return resultado;
	}

	public String validaciones(String carnetAlumno, String nombreAlumno,
			String apellidoAlumno, String fechaInicioServicio, String telefono,
			String email) {
		String evaluacion = "";
		if (carnetAlumno.length() != 7) {
			evaluacion = "El carnet debe ser de 7 caracteres";
		}
		if (nombreAlumno.length() < 3) {
			if (evaluacion == "") {
				evaluacion = "El nombre debe ser de 3 caracteres";
			} else {
				evaluacion = evaluacion
						+ ",el nombre debe ser de 3 o más caracteres";
			}
		}
		if (apellidoAlumno.length() < 3) {
			if (evaluacion == "") {
				evaluacion = "El apellido debe ser de 3 o más caracteres";
			} else {
				evaluacion = evaluacion
						+ ",el apellido debe ser de 3 o más caracteres";
			}
		}
		if (!validarFecha(fechaInicioServicio)) 
			{
				if (evaluacion == "") {
					evaluacion = "La fecha debe ser en formato dd/mm/aa";
				} else {
					evaluacion = evaluacion
							+ ", la fecha debe ser en formato dd/mm/aa";
				}

			}
			if (!(telefono.length() == 8)) {
				if (evaluacion == "") {
					evaluacion = "El teléfono debe ser de 8 números sin guiones";
				} else {
					evaluacion = evaluacion
							+ ",el teléfono debe ser de 8 números sin guiones";
				}
			}
			if (!esEmailValido(email))
			{
				if (evaluacion == "") {
					evaluacion = "El email no es válido";
				} else {
					evaluacion = evaluacion
							+ ", el email no es válido";
				}
			}	
		return evaluacion;
	}

	public String validaciones(String carnetAlumno, String nombreAlumno,
			String apellidoAlumno, String fechaInicioServicio, String telefono,
			String email,String genero,String fechaFinServicio,String estadoExpediente,int horasAcumula) {
		String evaluacion = validaciones(carnetAlumno,nombreAlumno,apellidoAlumno,fechaInicioServicio,telefono,email);
		if (!((genero=="F"|| genero=="M"))) {
			if (evaluacion == "") {
				evaluacion = "El genero debe ser F=Femenino o M=Masculino";
			} else {
				evaluacion = evaluacion
						+ ",El genero debe ser F=Femenino o M=Masculino";
			}
		}
		if (!(fechaFinServicio=="00/00/00")) {
			if (!validarFecha(fechaFinServicio)) 
			{
				if (evaluacion == "") {
					evaluacion = "La fecha debe ser en formato dd/mm/aa o ser 00/00/00";
				} else {
					evaluacion = evaluacion
							+ ", la fecha debe ser en formato dd/mm/aa o ser 00/00/00";
				}
			}
		}
		if (!((estadoExpediente=="A"|| estadoExpediente=="T"|| estadoExpediente=="S"))) {
			if (evaluacion == "") {
				evaluacion = "El estado debe ser A: Activo, T: Terminado, S: Suspendido";
			} else {
				evaluacion = evaluacion
						+ ",El estado debe ser A: Activo, T: Terminado, S: Suspendido";
			}
				
		}
		else
		{
			if (((estadoExpediente=="T"&& horasAcumula<500))) {
				if (evaluacion == "") {
					evaluacion = "El estado no puede ser A: Activo, porque tiene menos de 500 horas";
				} else {
					evaluacion = evaluacion
							+ ",el estado no puede ser A: Activo, porque tiene menos de 500 horas";
				}
					
			}			
		}
		return evaluacion;
	}
	
}
