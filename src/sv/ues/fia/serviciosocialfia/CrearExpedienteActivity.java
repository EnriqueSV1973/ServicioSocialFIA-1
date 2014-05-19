package sv.ues.fia.serviciosocialfia;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.net.ParseException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class CrearExpedienteActivity extends Activity {

	BDControl helper;
	EditText IDEXPEDIENTE;
	String IDBITACORA = "";// Campo que debe de eliminarse
	String CARNETEMPLEADO = "";// Campo que no es necesario
	String CODCARRERA = "1515";// Solo es la escuela
	EditText CARNETALUMNO;
	EditText NOMBREALUMNO;
	EditText APELLIDOALUMNO;
	String SEXOALUMNO;
	EditText FECHAINICIOSERVICIO;
	String FECHAFINSERVICIO = "00/00/00"; // Inicializado para saber que no esta
											// concluido
	String ESTADOEXPEDIENTE;
	EditText TELEFONO;
	EditText EMAIL;
	EditText OBSERVACIONES;
	float VALORSERVICIO = 0;
	int HORASACUMULA = 0;
	String FECHAACUMULA = "00/00/00";// Inicializado para saber que no esta
										// concluido
	private RadioButton masculino, femenino;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crear_expediente);
		helper = new BDControl(this);
		IDEXPEDIENTE = (EditText) findViewById(R.id.editTxtInsertCarnetAlumno);
		// IDBITACORA= Este campo no se utiliza;
		CARNETEMPLEADO = ""; // Este campo debe ser capturado al inicio con el
								// pasword
		CODCARRERA = "1515"; // Este campo queda fijo por ser la escuela de Ing.
								// en sistemas;
		CARNETALUMNO = (EditText) findViewById(R.id.editTxtInsertCarnetAlumno);
		NOMBREALUMNO = (EditText) findViewById(R.id.editTxtInsertNomAlumno);
		APELLIDOALUMNO = (EditText) findViewById(R.id.editTxtInsertApeAlumno);
		masculino = (RadioButton) findViewById(R.id.radGenAlMas);
		femenino = (RadioButton) findViewById(R.id.radGenAlFem);
		FECHAINICIOSERVICIO = (EditText) findViewById(R.id.editTxtInsertFechaInAlumno);
		// **FECHAFINSERVICIO=(EditText) findViewById(R.id.editCarnet);;
		ESTADOEXPEDIENTE = "A";// Estados A: Activo, T: Terminado, S: Suspendido
		TELEFONO = (EditText) findViewById(R.id.editTxtInsertTelInAlumno);
		EMAIL = (EditText) findViewById(R.id.editTxtInsertEmailAlumno);
		OBSERVACIONES = (EditText) findViewById(R.id.editTxtInsertObsAlumno);
	}

	public void insertarAlumno(View v) {
		String idExpediente = IDEXPEDIENTE.getText().toString();
		String idBitacora = IDBITACORA;
		String carnetEmpleado = CARNETEMPLEADO;
		String codCarrera = CODCARRERA;
		String carnetAlumno = CARNETALUMNO.getText().toString();
		String nombreAlumno = NOMBREALUMNO.getText().toString();
		String apellidoAlumno = APELLIDOALUMNO.getText().toString();
		String sexoAlumno;
		if (masculino.isChecked() == true) {
			sexoAlumno = String.valueOf("M");
		} else {
			sexoAlumno = String.valueOf("F");
		}
		String fechaInicioServicio = FECHAINICIOSERVICIO.getText().toString();
		String fechaFinServicio = FECHAFINSERVICIO;
		String estadoExpediente = ESTADOEXPEDIENTE;
		String telefono = TELEFONO.getText().toString();
		String email = EMAIL.getText().toString();
		String observaciones = OBSERVACIONES.getText().toString();
		float valorServicio = VALORSERVICIO;
		int horasAcumula = HORASACUMULA;
		String fechaAcumula = FECHAACUMULA;
		// Validaciones
		String regInsertados;
		AlumnoExpediente alumno = new AlumnoExpediente();		
		regInsertados=alumno.validaciones(carnetAlumno,nombreAlumno,apellidoAlumno,fechaInicioServicio,telefono,email);
		if (regInsertados=="") {
			// Comenzar proceso de insercion
			alumno.setIdExpediente(idExpediente);
			alumno.setIdBitacora(idBitacora);
			alumno.setCarnetEmpleado(carnetEmpleado);
			alumno.setCodCarrera(codCarrera);
			alumno.setCarnetAlumno(carnetAlumno);
			alumno.setNombreAlumno(nombreAlumno);
			alumno.setApellidoAlumno(apellidoAlumno);
			alumno.setSexoAlumno(sexoAlumno);
			alumno.setFechaInicioServicio(fechaInicioServicio);
			alumno.setFechaFinServicio(fechaFinServicio);
			alumno.setEstadoExpediente(estadoExpediente);
			alumno.setTelefono(telefono);
			alumno.setEmail(email);
			alumno.setObservaciones(observaciones);
			alumno.setValorServicio(valorServicio);
			alumno.setHorasAcumula(horasAcumula);
			alumno.setFechaAcumula(fechaAcumula);

			regInsertados = helper.insertar(alumno);
			Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
		} else
		{
			Toast.makeText(this, regInsertados, Toast.LENGTH_LONG).show();
		}
	}

	public void limpiarTexto(View v) {
		IDEXPEDIENTE.setText("");
		// IDBITACORA= Este campo no se utiliza;
		CARNETEMPLEADO = ""; // Este campo debe ser capturado al inicio con el
								// pasword
		CODCARRERA = "1515"; // Este campo queda fijo por ser la escuela de Ing.
								// en sistemas;
		CARNETALUMNO.setText("");
		NOMBREALUMNO.setText("");
		APELLIDOALUMNO.setText("");
		masculino.setChecked(true);
		femenino.setChecked(false);
		FECHAINICIOSERVICIO.setText("");
		// **FECHAFINSERVICIO=(EditText) findViewById(R.id.editCarnet);;
		ESTADOEXPEDIENTE = "A";// Estados A: Activo, T: Terminado, S: Suspendido
		TELEFONO.setText("");
		EMAIL.setText("");
		OBSERVACIONES.setText("");
	}

}
