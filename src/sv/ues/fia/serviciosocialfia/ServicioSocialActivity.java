package sv.ues.fia.serviciosocialfia;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ServicioSocialActivity extends ListActivity {

	String[] roles = { "Estudiante", "Tutor", "Director",
			"LlenarBD(Para pruebas)" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, roles));
			}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.servicio_social, menu);
		return true;

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		// Menú de los roles:

		// Abrir las opciones de mnú para el rol de "Estudiante"
		if (position == 0) {
			Intent act = new Intent(this, EstudianteMenunActivity.class);
			startActivity(act);
		}

		// Abrir las opciones de mnú para el rol de "Tutor"
		if (position == 1) {
			Intent act = new Intent(this, TutorMenuActivity.class);
			startActivity(act);
		}

		// Abrir las opciones de menú para el rol de "Director"
		if (position == 2) {
			Intent act = new Intent(this, DirectorMenuActivity.class);
			startActivity(act);
		}
		// Código provisional para llenar la BD y hacer pruebas
		if (position == 3) {

			// Prueba con la tabla ALUMNOEXPEDIENTE (INSERTAR)

			 AlumnoExpediente alumExpediente = new AlumnoExpediente();
			 alumExpediente.setApellidoAlumno("Trujillo");
			 alumExpediente.setCarnetAlumno("RR77880");
			 alumExpediente.setCarnetEmpleado("TT11223");
			 alumExpediente.setCodCarrera("CA77");
			 alumExpediente.setEmail("mail@mail.com");
			 alumExpediente.setEstadoExpediente("Programando");
			 alumExpediente.setFechaAcumula("fecha");
			 alumExpediente.setFechaFinServicio("fechaFin");
			 alumExpediente.setFechaInicioServicio("fechaIni");
			 alumExpediente.setHorasAcumula(20);
			 alumExpediente.setIdBitacora("AAAAA");
			 alumExpediente.setIdExpediente("RR77880");
			 alumExpediente.setNombreAlumno("nombre");
			 alumExpediente.setObservaciones("observ");
			 alumExpediente.setSexoAlumno("M");
			 alumExpediente.setTelefono("000000");
			 alumExpediente.setValorServicio(120);

			 //Abriré la BD
			 BDControl db = new BDControl(getApplicationContext());
			 //Ingreso datos
			 String registrosInsertados = db.insertar(alumExpediente);
			 Toast.makeText(this,registrosInsertados,Toast.LENGTH_SHORT).show();

			 //Ingreso de un segundo registro
			 alumExpediente.setApellidoAlumno("Trujillo");
			 alumExpediente.setCarnetAlumno("yy124405");
			 alumExpediente.setCarnetEmpleado("TT11223");
			 alumExpediente.setCodCarrera("CA77");
			 alumExpediente.setEmail("mail@mail.com");
			 alumExpediente.setEstadoExpediente("Programando");
			 alumExpediente.setFechaAcumula("fecha");
			 alumExpediente.setFechaFinServicio("fechaFin");
			 alumExpediente.setFechaInicioServicio("fechaIni");
			 alumExpediente.setHorasAcumula(20);
			 alumExpediente.setIdBitacora("AAAAA");
			 alumExpediente.setIdExpediente("yy124405");
			 alumExpediente.setNombreAlumno("nombre");
			 alumExpediente.setObservaciones("observ");
			 alumExpediente.setSexoAlumno("M");
			 alumExpediente.setTelefono("000000");
			 alumExpediente.setValorServicio(120);

			 registrosInsertados = db.insertar(alumExpediente);
			 Toast.makeText(this,registrosInsertados,Toast.LENGTH_SHORT).show();

			 //Ingreso de un tercer registro
			 alumExpediente.setApellidoAlumno("Pleitez");
			 alumExpediente.setCarnetAlumno("ER79880");
			 alumExpediente.setCarnetEmpleado("PP11223");
			 alumExpediente.setCodCarrera("car44");
			 alumExpediente.setEmail("mail@mail.com");
			 alumExpediente.setEstadoExpediente("Programando");
			 alumExpediente.setFechaAcumula("fecha");
			 alumExpediente.setFechaFinServicio("fechaFinf");
			 alumExpediente.setFechaInicioServicio("fechaInif");
			 alumExpediente.setHorasAcumula(20);
			 alumExpediente.setIdBitacora("eee");
			 alumExpediente.setIdExpediente("ER79880");
			 alumExpediente.setNombreAlumno("nombre");
			 alumExpediente.setObservaciones("observ");
			 alumExpediente.setSexoAlumno("M");
			 alumExpediente.setTelefono("0000040");
			 alumExpediente.setValorServicio(120);

			 registrosInsertados = db.insertar(alumExpediente);
			 Toast.makeText(this,registrosInsertados,Toast.LENGTH_SHORT).show();

			 //Cerraré la BD
			 db.close();

			// //Editando el primer registro
//			 AlumnoExpediente alumExpediente = new AlumnoExpediente();
//			 alumExpediente.setApellidoAlumno("Pleitez Trujillo");
//			 alumExpediente.setCarnetAlumno("RR77880");
//			 alumExpediente.setCarnetEmpleado("dsfs4");
//			 alumExpediente.setCodCarrera("sdfs");
//			 alumExpediente.setEmail("mail@mail.com");
//			 alumExpediente.setEstadoExpediente("Programando");
//			 alumExpediente.setFechaAcumula("fecha");
//			 alumExpediente.setFechaFinServicio("fechaFinf");
//			 alumExpediente.setFechaInicioServicio("fechaInif");
//			 alumExpediente.setHorasAcumula(20);
//			 alumExpediente.setIdBitacora("eee");
//			 alumExpediente.setIdExpediente("RR77880");
//			 alumExpediente.setNombreAlumno("Raúl");
//			 alumExpediente.setObservaciones("observ");
//			 alumExpediente.setSexoAlumno("M");
//			 alumExpediente.setTelefono("0000040");
//			 alumExpediente.setValorServicio(120);
//			
//			 //Abriré la BD
//			 BDControl db = new BDControl(getApplicationContext());
//			 //Actualización de datos
//			 String registrosInsertados = db.actualizar(alumExpediente);
//			 //Cerraré la BD
//			 db.close();
//			
//			 Toast.makeText(this,registrosInsertados,Toast.LENGTH_SHORT).show();

			 //Elimnaré un registro de ALUMNOEXPEDIENTE
			 alumExpediente.setCarnetAlumno("RR77880");
			 //Abriré la BD
			 db = new BDControl(getApplicationContext());
			 //Eliminando el registro con el respectivo carnet de alumno.
			 String registrosEliminados = db.eliminar(alumExpediente);
			 Toast.makeText(this,registrosEliminados,Toast.LENGTH_SHORT).show();

			 //Cerrando la BD.
			 db.close();
		}
		// Fin del menú de los roles.
	}

}