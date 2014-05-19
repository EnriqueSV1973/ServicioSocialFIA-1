package sv.ues.fia.serviciosocialfia;

import android.app.Activity;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;




public class ModificarExpedienteActivity extends Activity {

	BDControl helper;
	EditText IDEXPEDIENTE;
	EditText IDBITACORA;
	EditText CARNETEMPLEADO;
	EditText CODCARRERA; 
	EditText CARNETALUMNO;
	EditText NOMBREALUMNO;
	EditText APELLIDOALUMNO;
	EditText SEXOALUMNO;
	EditText FECHAINICIOSERVICIO;
	EditText FECHAFINSERVICIO; 
	EditText ESTADOEXPEDIENTE;
	EditText TELEFONO;
	EditText EMAIL;
	EditText OBSERVACIONES;
	EditText VALORSERVICIO;
	EditText HORASACUMULA;
	EditText FECHAACUMULA;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modificar_expediente);
		helper=new BDControl(this);
		IDEXPEDIENTE = (EditText) findViewById(R.id.editTxtInsertCarnetAlumno);
		CARNETEMPLEADO = (EditText) findViewById(R.id.editTextCodEmp);
		CODCARRERA = (EditText) findViewById(R.id.editTxtInsertCarrAlumno); 
		CARNETALUMNO = (EditText) findViewById(R.id.editTxtInsertCarnetAlumno);
		NOMBREALUMNO = (EditText) findViewById(R.id.editTxtInsertNomAlumno);
		APELLIDOALUMNO = (EditText) findViewById(R.id.editTxtInsertApeAlumno);
		SEXOALUMNO = (EditText) findViewById(R.id.editTextSexo);
		FECHAINICIOSERVICIO = (EditText) findViewById(R.id.editTxtInsertFechaInAlumno);
		FECHAFINSERVICIO=(EditText) findViewById(R.id.editTxtInsertFechaFinAlumno);
		ESTADOEXPEDIENTE =(EditText) findViewById(R.id.editTextEstado);// Estados A: Activo, T: Terminado, S: Suspendido
		TELEFONO = (EditText) findViewById(R.id.editTxtInsertTelInAlumno);
		EMAIL = (EditText) findViewById(R.id.editTxtInsertEmailAlumno);
		OBSERVACIONES = (EditText) findViewById(R.id.editTxtInsertObsAlumno);		
	}
	//Adicionado throws SQLException
	public void actualizarAlumno(View v) throws SQLException {
			String idExpediente = IDEXPEDIENTE.getText().toString();
			String idBitacora = IDBITACORA.getText().toString();
			String carnetEmpleado = CARNETEMPLEADO.getText().toString();;
			String codCarrera = CODCARRERA.getText().toString();;
			String carnetAlumno = CARNETALUMNO.getText().toString();
			String nombreAlumno = NOMBREALUMNO.getText().toString();
			String apellidoAlumno = APELLIDOALUMNO.getText().toString();
			String sexoAlumno=SEXOALUMNO.getText().toString();;
			String fechaInicioServicio = FECHAINICIOSERVICIO.getText().toString();
			String fechaFinServicio = FECHAFINSERVICIO.getText().toString();
			String estadoExpediente = ESTADOEXPEDIENTE.getText().toString();;
			String telefono = TELEFONO.getText().toString();
			String email = EMAIL.getText().toString();
			String observaciones = OBSERVACIONES.getText().toString();
			float valorServicio = Float.parseFloat(VALORSERVICIO.getText().toString());
			int horasAcumula =Integer.parseInt(HORASACUMULA.getText().toString());
			String fechaAcumula = FECHAACUMULA.getText().toString();;
			// Validaciones
			String regInsertados;
			AlumnoExpediente alumno = new AlumnoExpediente();		
			regInsertados=alumno.validaciones(carnetAlumno,nombreAlumno,
					apellidoAlumno, fechaInicioServicio, telefono,
					email,sexoAlumno,fechaFinServicio,estadoExpediente,horasAcumula);
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
			CARNETEMPLEADO.setText(""); 
			CODCARRERA.setText("");
			CARNETALUMNO.setText("");
			NOMBREALUMNO.setText("");
			APELLIDOALUMNO.setText("");
			SEXOALUMNO .setText("");
			FECHAINICIOSERVICIO.setText("");
			FECHAFINSERVICIO.setText(""); 
			ESTADOEXPEDIENTE.setText("");
			TELEFONO.setText("");
			EMAIL.setText("");
			OBSERVACIONES.setText("");
		}
}
