package sv.ues.fia.serviciosocialfia;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Build;

public class GestionDeEstudiantesActivity extends  ListActivity {
	String[] opciones = {"Crear Expediente","Modificar Expediente","Eliminar Expediente", "Consultar Expediente"};
	String[] activities = {"CrearExpedienteActivity","ModificarExpedienteActivity","EliminarExpedienteActivity", "ConsultarExpedienteActivity"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opciones));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		String nombre = activities[position];
		try {
			Class<?>clase=Class.forName("sv.ues.fia.serviciosocialfia."+nombre);
			Intent intent = new Intent(this, clase);
			startActivity(intent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
