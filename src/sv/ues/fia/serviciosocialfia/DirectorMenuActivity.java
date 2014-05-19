package sv.ues.fia.serviciosocialfia;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DirectorMenuActivity extends ListActivity {

	String[] opciones = { "Gestión de estudiantes", "Gestión de proyectos" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, opciones));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.director_menu, menu);
		return true;

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		if (position == 0) {
			Intent intent = new Intent(this, GestionDeEstudiantesActivity.class);
			startActivity(intent);
		} else {
			Intent intent = new Intent(this, GestionDeProyectosActivity.class);
			startActivity(intent);
		}

	}
}