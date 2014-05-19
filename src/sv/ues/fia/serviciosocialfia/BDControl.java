package sv.ues.fia.serviciosocialfia;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDControl extends SQLiteOpenHelper {

	// Nombre de la base de datos de la aplicación
	private final static String NOMBRE_BD = "SSBD.s3db";

	// Versión de la base de datos de la aplicación
	private final static int VERSION_BD = 1;

	// Definición de las tablas de la base de datos de la aplicación

	// TABLA: ALUMNOEXPEDIENTE
	private static final String TABLA_ALUMNOEXPEDIENTE = "create table ALUMNOEXPEDIENTE "
			+ "(IDEXPEDIENTE        CHAR(10)             not null,"
			+ "IDBITACORA           CHAR(10)             not null,"
			+ "CARNETEMPLEADO       CHAR(7),"
			+ "CODCARRERA           CHAR(4)              not null,"
			+ "CARNETALUMNO         CHAR(7)              not null,"
			+ "NOMBREALUMNO         CHAR(30)             not null,"
			+ "APELLIDOALUMNO       CHAR(30)             not null,"
			+ "SEXOALUMNO           CHAR(1)              not null,"
			+ "FECHAINICIOSERVICIO  CHAR(10)             not null,"
			+ "FECHAFINSERVICIO     CHAR(10),"
			+ "ESTADOEXPEDIENTE     CHAR(1)              not null,"
			+ "TELEFONO             CHAR(9),"
			+ "EMAIL                CHAR(15),"
			+ "OBSERVACIONES        CHAR(100),"
			+ "VALORSERVICIO        FLOAT,"
			+ "HORASACUMULA         INTEGER,"
			+ "FECHAACUMULA         CHAR(10),"
			+ "constraint PK_ALUMNOEXPEDIENTE primary key (CARNETALUMNO));";

	// TABLA: ASIGNACION
	private static final String TABLA_ASIGNACION = "create table ASIGNACION "
			+ "(IDPROYECTO           CHAR(10)             not null,"
			+ "IDEXPEDIENTE         CHAR(10)             not null,"
			+ "constraint PK_ASIGNACION primary key (IDPROYECTO, IDEXPEDIENTE));";

	// TABLA: BENEFICIARIO
	private static final String TABLA_BENEFICIARIO = "create table BENEFICIARIO "
			+ "(IDBENEFICIARIO       CHAR(10)             not null,"
			+ "CARNETEMPLEADO       CHAR(7)              not null,"
			+ "NOMBREORGANIZACION   CHAR(50)             not null,"
			+ "NOMBREREPRESENTANTE  CHAR(30)             not null,"
			+ "APELLIDOREPRESENTANTE CHAR(30)             not null,"
			+ "TELEFONOBENEF        INTEGER,"
			+ "DIRECCIONBENEF       CHAR(50) ,"
			+ "EMAIL                CHAR(15),"
			+ "constraint PK_BENEFICIARIO primary key (IDBENEFICIARIO));";

	// TABLA: BITACORA
	private static final String TABLA_BITACORA = "create table BITACORA "
			+ "(IDBITACORA           CHAR(10)             not null,"
			+ "CODIGOTUTOR          CHAR(7)              not null,"
			+ "ESTADOACTIVIDAD      CHAR(1)              not null,"
			+ "FECHAAUTORIZADO      CHAR(10)," + "VALORACTIVIDAD       FLOAT,"
			+ "PRECIOTRABAJO        FLOAT,"
			+ "constraint PK_BITACORA primary key (IDBITACORA));";

	// TABLA: CARRERAS
	private static final String TABLA_CARRERAS = "create table CARRERAS "
			+ "(CODCARRERA           CHAR(4)              not null,"
			+ "CODESCUELA           CHAR(30)             not null,"
			+ "NOMBRECARRERA        CHAR(25)             not null,"
			+ "constraint PK_CARRERAS primary key (CODCARRERA));";

	// TABLA: ENCARGADO_DE_SERVICIO_SOCIAL
	private static final String TABLA_ENCARGADO_DE_SERVICIO_SOCIAL = "create table ENCARGADO_DE_SERVICIO_SOCIAL "
			+ "(CARNETEMPLEADO       CHAR(7)              not null,"
			+ "CODESCUELA           CHAR(30)             not null,"
			+ "NOMBREDIRECTOR       CHAR(30),"
			+ "APELLIDODIRECTOR     CHAR(30),"
			+ "SEXODIRECTOR         CHAR(1),"
			+ "FECHAINICIO          CHAR(10)             not null,"
			+ "FECHAFIN             CHAR(10) ,"
			+ "constraint PK_ENCARGADO_DE_SERVICIO_SOCIA primary key (CARNETEMPLEADO));";

	// TABLA: ESCUELA
	private static final String TABLA_ESCUELA = "create table ESCUELA "
			+ "(CODESCUELA           CHAR(30)             not null,"
			+ "NOMBREESCUELA        CHAR(15)             not null,"
			+ "constraint PK_ESCUELA primary key (CODESCUELA));";

	// TABLA: INFORME
	private static final String TABLA_INFORME = "create table INFORME "
			+ "(IDEXPEDIENTE        CHAR(10)             not null,"
			+ "CODIGOTUTOR          CHAR(7)              not null,"
			+ "CORRINFORME          INTEGER              not null,"
			+ "FECHAENTREGA         CHAR(10)             not null,"
			+ "FECHAAUTORIZACION    CHAR(10) ,"
			+ "OBJETIVOALCANZADO    CHAR(50)             not null,"
			+ "COMENTARIOS          CHAR(50),"
			+ "TIPOINFORME          CHAR(1)              not null,"
			+ "ESTADO               CHAR(2)              not null,"
			+ "constraint PK_INFORME primary key (CORRINFORME));";

	// TABLA: PRECIOS
	private static final String TABLA_PRECIOS = "create table PRECIOS "
			+ "(IDTIPODETRABAJO     CHAR(10)             not null,"
			+ "CORR                 INTEGER              not null,"
			+ "PRECIO               FLOAT                not null,"
			+ "FECHAINICIALAPLIPRE  CHAR(10)             not null,"
			+ "FECHAFINALAPLIPRE    CHAR(10) ,"
			+ "OBSERVACION          CHAR(25),"
			+ "constraint PK_PRECIOS primary key (CORR));";

	// TABLA: PROYECTO
	private static final String TABLA_PROYECTO = "create table PROYECTO "
			+ "(IDPROYECTO          CHAR(10)             not null,"
			+ "IDBENEFICIARIO       CHAR(10)             not null,"
			+ "IDTIPOPROYECTO       CHAR(10),"
			+ "CARNETEMPLEADO       CHAR(7),"
			+ "IDTIPODETRABAJO      CHAR(10)             not null,"
			+ "NOMBREDEPROYECTO     CHAR(100)            not null,"
			+ "DESCRIPCIONPROYECTO  CHAR(100)            not null,"
			+ "DURACIONPROYECTO     INTEGER,"
			+ "FECHAINICIOPROY      CHAR(10)             not null,"
			+ "FECHAFINPROY         CHAR(10) ,"
			+ "ESTADOPROYECTO       CHAR(1)              not null,"
			+ "VALORPROYECTO        FLOAT," + "ESTADOASIGNACION     CHAR(1),"
			+ "constraint PK_PROYECTO primary key (IDPROYECTO));";

	// TABLA: REGISTRO
	private static final String TABLA_REGISTRO = "create table REGISTRO "
			+ "(IDPROYECTO           CHAR(10)             not null,"
			+ "IDEXPEDIENTE         CHAR(10),"
			+ "IDBITACORA           CHAR(10)             not null,"
			+ "HORAINICIO           CHAR(10) ,"
			+ "HORAFIN              CHAR(5) ,"
			+ "FECHAACTIVIDAD       CHAR(10) ,"
			+ "CANTIDADHORAS        INTEGER,"
			+ "constraint PK_REGISTRO primary key (IDPROYECTO, IDBITACORA));";

	// TABLA: TIPO_DE_PROYECTO
	private static final String TABLA_TIPO_DE_PROYECTO = "create table TIPO_DE_PROYECTO "
			+ "(IDTIPOPROYECTO       CHAR(10)             not null,"
			+ "MODALIDADPROYECTO    CHAR(100)            not null,"
			+ "constraint PK_TIPO_DE_PROYECTO primary key (IDTIPOPROYECTO));";

	// TABLA: TIPO_DE_TRABAJO
	private static final String TABLA_TIPO_DE_TRABAJO = "create table TIPO_DE_TRABAJO "
			+ "(IDTIPODETRABAJO      CHAR(10)             not null,"
			+ "NOMBRETIPO           CHAR(30)             not null,"
			+ "constraint PK_TIPO_DE_TRABAJO primary key (IDTIPODETRABAJO));";

	// TABLA: TUTOR
	private static final String TABLA_TUTOR = "create table TUTOR "
			+ "(CODIGOTUTOR          CHAR(7)              not null,"
			+ "IDBENEFICIARIO       CHAR(10)             not null,"
			+ "NOMBRETUTOR          CHAR(30)             not null,"
			+ "APELLIDOTUTOR        CHAR(30)             not null,"
			+ "SEXOTUTOR            CHAR(1)              not null,"
			+ "constraint PK_TUTOR primary key (CODIGOTUTOR));";

	// FIN de la definición de tablas de la base de datos

	public BDControl(Context context) {
		super(context, NOMBRE_BD, null, VERSION_BD);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		// Creación de las tablas en la base de datos
		db.execSQL(TABLA_ALUMNOEXPEDIENTE);
		db.execSQL(TABLA_ASIGNACION);
		db.execSQL(TABLA_BENEFICIARIO);
		db.execSQL(TABLA_BITACORA);
		db.execSQL(TABLA_CARRERAS);
		db.execSQL(TABLA_ENCARGADO_DE_SERVICIO_SOCIAL);
		db.execSQL(TABLA_ESCUELA);
		db.execSQL(TABLA_INFORME);
		db.execSQL(TABLA_PRECIOS);
		db.execSQL(TABLA_PROYECTO);
		db.execSQL(TABLA_REGISTRO);
		db.execSQL(TABLA_TIPO_DE_PROYECTO);
		db.execSQL(TABLA_TIPO_DE_TRABAJO);
		db.execSQL(TABLA_TUTOR);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		// Borramos la tabla si ya existe y creamos una nueva
		db.execSQL("DROP TABLE IF EXISTS" + TABLA_ALUMNOEXPEDIENTE);
		db.execSQL("DROP TABLE IF EXISTS" + TABLA_ASIGNACION);
		db.execSQL("DROP TABLE IF EXISTS" + TABLA_BENEFICIARIO);
		db.execSQL("DROP TABLE IF EXISTS" + TABLA_BITACORA);
		db.execSQL("DROP TABLE IF EXISTS" + TABLA_CARRERAS);
		db.execSQL("DROP TABLE IF EXISTS" + TABLA_ENCARGADO_DE_SERVICIO_SOCIAL);
		db.execSQL("DROP TABLE IF EXISTS" + TABLA_ESCUELA);
		db.execSQL("DROP TABLE IF EXISTS" + TABLA_INFORME);
		db.execSQL("DROP TABLE IF EXISTS" + TABLA_PRECIOS);
		db.execSQL("DROP TABLE IF EXISTS" + TABLA_PROYECTO);
		db.execSQL("DROP TABLE IF EXISTS" + TABLA_REGISTRO);
		db.execSQL("DROP TABLE IF EXISTS" + TABLA_TIPO_DE_PROYECTO);
		db.execSQL("DROP TABLE IF EXISTS" + TABLA_TIPO_DE_TRABAJO);
		db.execSQL("DROP TABLE IF EXISTS" + TABLA_TUTOR);
		onCreate(db);
	}

	// FUNCIONES DE INSERCIÓN, ACTUALIZACIÓN, ELIMINACIÓN Y CONSULTA DE LAS
	// TABLAS

	// Funciones de inserción de datos

	public String insertar(AlumnoExpediente alumExp) {

		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("IDEXPEDIENTE", alumExp.getIdExpediente());
			valores.put("IDBITACORA", alumExp.getIdBitacora());
			valores.put("CARNETEMPLEADO", alumExp.getCarnetEmpleado());
			valores.put("CODCARRERA", alumExp.getCodCarrera());
			valores.put("CARNETALUMNO", alumExp.getCarnetAlumno());
			valores.put("NOMBREALUMNO", alumExp.getNombreAlumno());
			valores.put("APELLIDOALUMNO", alumExp.getApellidoAlumno());
			valores.put("SEXOALUMNO", alumExp.getSexoAlumno());
			valores.put("FECHAINICIOSERVICIO", alumExp.getFechaInicioServicio());
			valores.put("FECHAFINSERVICIO", alumExp.getFechaFinServicio());
			valores.put("ESTADOEXPEDIENTE", alumExp.getEstadoExpediente());
			valores.put("TELEFONO", alumExp.getTelefono());
			valores.put("EMAIL", alumExp.getEmail());
			valores.put("OBSERVACIONES", alumExp.getObservaciones());
			valores.put("VALORSERVICIO", alumExp.getValorServicio());
			valores.put("HORASACUMULA", alumExp.getHorasAcumula());
			valores.put("FECHAACUMULA", alumExp.getFechaAcumula());
			contador = db.insert("ALUMNOEXPEDIENTE", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}
		return "La Base de Datos no existe";
	}

	public String insertar(Asignacion asignacion) {

		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("IDPROYECTO", asignacion.getIdProyecto());
			valores.put("IDEXPEDIENTE", asignacion.getIdExpediente());
			contador = db.insert("ASIGNACION", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}
		return "La Base de Datos no existe";
	}

	public String insertar(Beneficiario beneficiario) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("IDBENEFICIARIO", beneficiario.getIdBeneficiario());
			valores.put("CARNETEMPLEADO", beneficiario.getCarnetEmpleado());
			valores.put("NOMBREORGANIZACION",
					beneficiario.getNombreOrganizacion());
			valores.put("NOMBREREPRESENTANTE",
					beneficiario.getNombreRepresentante());
			valores.put("APELLIDOREPRESENTANTE",
					beneficiario.getApellidoRepresentante());
			valores.put("TELEFONOBENEF", beneficiario.getTelefonoBenef());
			valores.put("DIRECCIONBENEF", beneficiario.getDireccionBenef());
			valores.put("EMAIL", beneficiario.getEmail());
			contador = db.insert("BENEFICIARIO", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}

		return "La Base de Datos no existe";
	}

	public String insertar(Bitacora bitacora) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("IDBITACORA", bitacora.getIdBitacora());
			valores.put("CODIGOTUTOR", bitacora.getCodigoTutor());
			valores.put("ESTADOACTIVIDAD", bitacora.getEstadoActividad());
			valores.put("FECHAAUTORIZADO", bitacora.getFechaAutorizado());
			valores.put("VALORACTIVIDAD", bitacora.getValorActividad());
			valores.put("PRECIOTRABAJO", bitacora.getPrecioTrabajo());
			contador = db.insert("BITACORA", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}

		return "La Base de Datos no existe";
	}

	public String insertar(Carreras carreras) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("CODCARRERA", carreras.getCodCarrera());
			valores.put("CODESCUELA", carreras.getCodEscuela());
			valores.put("NOMBRECARRERA", carreras.getNombreCarrera());
			contador = db.insert("CARRERAS", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}

		return "La Base de Datos no existe";
	}

	public String insertar(EncargadoDeServicioSocial encargado) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("CARNETEMPLEADO", encargado.getCarnetEmpleado());
			valores.put("CODESCUELA", encargado.getCodEscuela());
			valores.put("NOMBREDIRECTOR", encargado.getNombreDirector());
			valores.put("APELLIDODIRECTOR", encargado.getApellidoDirector());
			valores.put("SEXODIRECTOR", encargado.getSexoDirector());
			valores.put("FECHAINICIO", encargado.getFechaInicio());
			valores.put("FECHAFIN", encargado.getFechaFin());
			contador = db.insert("ENCARGADO_DE_SERVICIO_SOCIAL", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}

		return "La Base de Datos no existe";
	}

	public String insertar(Escuela escuela) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("CODESCUELA", escuela.getCodEscuela());
			valores.put("NOMBREESCUELA", escuela.getNombreEscuela());
			contador = db.insert("ESCUELA", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}

		return "La Base de Datos no existe";
	}

	public String insertar(Informe informe) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("CODIGOTUTOR", informe.getCodigoTutor());
			valores.put("IDEXPEDIENTE", informe.getIdExpediente());
			valores.put("CORRINFORME", informe.getCorrInforme());
			valores.put("FECHAENTREGA", informe.getFechaEntrega());
			valores.put("FECHAAUTORIZACION", informe.getFechaAutorizacion());
			valores.put("OBJETIVOALCANZADO", informe.getObjetivoAlcanzado());
			valores.put("COMENTARIOS", informe.getComentarios());
			valores.put("TIPOINFORME", informe.getTipoInforme());
			valores.put("ESTADO", informe.getEstado());
			contador = db.insert("INFORME", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}

		return "La Base de Datos no existe";
	}

	public String insertar(Precios precios) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("CORR", precios.getCorr());
			valores.put("IDTIPODETRABAJO", precios.getIdTipoDeTrabajo());
			valores.put("PRECIO", precios.getPrecio());
			valores.put("FECHAINICIALAPLIPRE", precios.getFechaInicialApliPre());
			valores.put("FECHAFINALAPLIPRE", precios.getFechaFinalApliPre());
			valores.put("OBSERVACION", precios.getObservacion());
			contador = db.insert("PRECIOS", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}

		return "La Base de Datos no existe";
	}

	public String insertar(Proyecto proyecto) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("IDPROYECTO", proyecto.getIdProyecto());
			valores.put("IDBENEFICIARIO", proyecto.getIdBeneficiario());
			valores.put("IDTIPOPROYECTO", proyecto.getIdTipoProyecto());
			valores.put("CARNETEMPLEADO", proyecto.getCarnetEmpleado());
			valores.put("IDTIPODETRABAJO", proyecto.getIdTipoDeTrabajo());
			valores.put("NOMBREDEPROYECTO", proyecto.getNombreDeProyecto());
			valores.put("DESCRIPCIONPROYECTO",
					proyecto.getDescripcionProyecto());
			valores.put("DURACIONPROYECTO", proyecto.getDuracionProyecto());
			valores.put("FECHAINICIOPROY", proyecto.getFechaInicioProy());
			valores.put("FECHAFINPROY", proyecto.getFechaFinProy());
			valores.put("ESTADOPROYECTO", proyecto.getEstadoProyecto());
			valores.put("ESTADOASIGNACION", proyecto.getEstadoAsignacion());
			valores.put("VALORPROYECTO", proyecto.getValorProyecto());
			contador = db.insert("PROYECTO", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}
		return "La Base de Datos no existe";
	}

	public String insertar(Registro registro) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("IDPROYECTO", registro.getIdProyecto());
			valores.put("IDEXPEDIENTE", registro.getIdExpediente());
			valores.put("IDBITACORA", registro.getIdBitacora());
			valores.put("HORAINICIO", registro.getHoraInicio());
			valores.put("HORAFIN", registro.getHoraFin());
			valores.put("FECHAACTIVIDAD", registro.getFechaActividad());
			valores.put("CANTIDADHORAS", registro.getCantidadHoras());
			contador = db.insert("REGISTRO", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}

		return "La Base de Datos no existe";
	}

	public String insertar(TipoDeProyecto tipoDeProyecto) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("IDTIPOPROYECTO", tipoDeProyecto.getIdTipoProyecto());
			valores.put("MODALIDADPROYECTO",
					tipoDeProyecto.getModalidadProyecto());
			contador = db.insert("TIPO_DE_PROYECTO", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}

		return "La Base de Datos no existe";
	}

	public String insertar(TipoDeTrabajo tipoDeTrabajo) {
		// Abriendo base de datos
		SQLiteDatabase db = getWritableDatabase();
		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registro insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("IDTIPODETRABAJO", tipoDeTrabajo.getIdTipoDeTrabajo());
			valores.put("NOMBRETIPO", tipoDeTrabajo.getNombreTipo());
			contador = db.insert("TIPO_DE_TRABAJO", null, valores);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}

		return "La Base de Datos no existe";
	}

	public String insertar(Tutor tutor) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosInsertados = "Registros insertado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			valores.put("CODIGOTUTOR", tutor.getCodigoTutor());
			valores.put("IDBENEFICIARIO", tutor.getIdBeneficiario());
			valores.put("NOMBRETUTOR", tutor.getNombreTutor());
			valores.put("APELLIDOTUTOR", tutor.getApellidoTutor());
			valores.put("SEXOTUTOR", tutor.getSexoTutor());
			contador = db.insert("TUTOR", null, valores);
			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosInsertados = "Error al Insertar el registro, Registro"
						+ "Duplicado. Verificar inserción";
			} else {
				registrosInsertados = registrosInsertados + contador;
			}
			return registrosInsertados;
		}
		return "La Base de Datos no existe";
	}

	// FIN de funciones de inserción de datos

	// Funciones de actualización de datos

	public String actualizar(AlumnoExpediente alumExp) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { alumExp.getCarnetAlumno() };
			valores.put("IDEXPEDIENTE", alumExp.getIdExpediente());
			valores.put("IDBITACORA", alumExp.getIdBitacora());
			valores.put("CARNETEMPLEADO", alumExp.getCarnetEmpleado());
			valores.put("CODCARRERA", alumExp.getCodCarrera());
			valores.put("CARNETALUMNO", alumExp.getCarnetAlumno());
			valores.put("NOMBREALUMNO", alumExp.getNombreAlumno());
			valores.put("APELLIDOALUMNO", alumExp.getApellidoAlumno());
			valores.put("SEXOALUMNO", alumExp.getSexoAlumno());
			valores.put("FECHAINICIOSERVICIO", alumExp.getFechaInicioServicio());
			valores.put("FECHAFINSERVICIO", alumExp.getFechaFinServicio());
			valores.put("ESTADOEXPEDIENTE", alumExp.getEstadoExpediente());
			valores.put("TELEFONO", alumExp.getTelefono());
			valores.put("EMAIL", alumExp.getEmail());
			valores.put("OBSERVACIONES", alumExp.getObservaciones());
			valores.put("VALORSERVICIO", alumExp.getValorServicio());
			valores.put("HORASACUMULA", alumExp.getHorasAcumula());
			valores.put("FECHAACUMULA", alumExp.getFechaAcumula());
			contador = db.update("ALUMNOEXPEDIENTE", valores,
					"CARNETALUMNO = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(Beneficiario beneficiario) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { beneficiario.getIdBeneficiario() };
			valores.put("IDBENEFICIARIO", beneficiario.getIdBeneficiario());
			valores.put("CARNETEMPLEADO", beneficiario.getCarnetEmpleado());
			valores.put("NOMBREORGANIZACION",
					beneficiario.getNombreOrganizacion());
			valores.put("NOMBREREPRESENTANTE",
					beneficiario.getNombreRepresentante());
			valores.put("APELLIDOREPRESENTANTE",
					beneficiario.getApellidoRepresentante());
			valores.put("TELEFONOBENEF", beneficiario.getTelefonoBenef());
			valores.put("DIRECCIONBENEF", beneficiario.getDireccionBenef());
			valores.put("EMAIL", beneficiario.getEmail());
			contador = db.update("BENEFICIARIO", valores, "IDBENEFICIARIO = ?",
					id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(Bitacora bitacora) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { bitacora.getIdBitacora() };
			valores.put("IDBITACORA", bitacora.getIdBitacora());
			valores.put("CODIGOTUTOR", bitacora.getCodigoTutor());
			valores.put("ESTADOACTIVIDAD", bitacora.getEstadoActividad());
			valores.put("FECHAAUTORIZADO", bitacora.getFechaAutorizado());
			valores.put("VALORACTIVIDAD", bitacora.getValorActividad());
			valores.put("PRECIOTRABAJO", bitacora.getPrecioTrabajo());
			contador = db.update("BITACORA", valores, "IDBITACORA = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(Carreras carreras) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { carreras.getCodCarrera() };
			valores.put("CODCARRERA", carreras.getCodCarrera());
			valores.put("CODESCUELA", carreras.getCodEscuela());
			valores.put("NOMBRECARRERA", carreras.getNombreCarrera());
			contador = db.update("CARRERAS", valores, "CODCARRERA = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(EncargadoDeServicioSocial encargado) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { encargado.getCarnetEmpleado() };
			valores.put("CARNETEMPLEADO", encargado.getCarnetEmpleado());
			valores.put("CODESCUELA", encargado.getCodEscuela());
			valores.put("NOMBREDIRECTOR", encargado.getNombreDirector());
			valores.put("APELLIDODIRECTOR", encargado.getApellidoDirector());
			valores.put("SEXODIRECTOR", encargado.getSexoDirector());
			valores.put("FECHAINICIO", encargado.getFechaInicio());
			valores.put("FECHAFIN", encargado.getFechaFin());
			contador = db.update("ENCARGADO_DE_SERVICIO_SOCIAL", valores,
					"CARNETEMPLEADO = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(Escuela escuela) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { escuela.getCodEscuela() };
			valores.put("CODESCUELA", escuela.getCodEscuela());
			valores.put("NOMBREESCUELA", escuela.getNombreEscuela());
			contador = db.update("ESCUELA", valores, "CODESCUELA = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(Informe informe) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { "" + informe.getCorrInforme() };
			valores.put("CODIGOTUTOR", informe.getCodigoTutor());
			valores.put("IDEXPEDIENTE", informe.getIdExpediente());
			valores.put("CORRINFORME", informe.getCorrInforme());
			valores.put("FECHAENTREGA", informe.getFechaEntrega());
			valores.put("FECHAAUTORIZACION", informe.getFechaAutorizacion());
			valores.put("OBJETIVOALCANZADO", informe.getObjetivoAlcanzado());
			valores.put("COMENTARIOS", informe.getComentarios());
			valores.put("TIPOINFORME", informe.getTipoInforme());
			valores.put("ESTADO", informe.getEstado());
			contador = db.update("INFORME", valores, "CORRINFORME = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(Precios precios) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { "" + precios.getCorr() };
			valores.put("CORR", precios.getCorr());
			valores.put("IDTIPODETRABAJO", precios.getIdTipoDeTrabajo());
			valores.put("PRECIO", precios.getPrecio());
			valores.put("FECHAINICIALAPLIPRE", precios.getFechaInicialApliPre());
			valores.put("FECHAFINALAPLIPRE", precios.getFechaFinalApliPre());
			valores.put("OBSERVACION", precios.getObservacion());
			contador = db.update("PRECIOS", valores, "CORR = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(Proyecto proyecto) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { proyecto.getIdProyecto() };
			valores.put("IDPROYECTO", proyecto.getIdProyecto());
			valores.put("IDBENEFICIARIO", proyecto.getIdBeneficiario());
			valores.put("IDTIPOPROYECTO", proyecto.getIdTipoProyecto());
			valores.put("CARNETEMPLEADO", proyecto.getCarnetEmpleado());
			valores.put("IDTIPODETRABAJO", proyecto.getIdTipoDeTrabajo());
			valores.put("NOMBREDEPROYECTO", proyecto.getNombreDeProyecto());
			valores.put("DESCRIPCIONPROYECTO",
					proyecto.getDescripcionProyecto());
			valores.put("DURACIONPROYECTO", proyecto.getDuracionProyecto());
			valores.put("FECHAINICIOPROY", proyecto.getFechaInicioProy());
			valores.put("FECHAFINPROY", proyecto.getFechaFinProy());
			valores.put("ESTADOPROYECTO", proyecto.getEstadoProyecto());
			valores.put("ESTADOASIGNACION", proyecto.getEstadoAsignacion());
			valores.put("VALORPROYECTO", proyecto.getValorProyecto());
			contador = db.update("PROYECTO", valores, "IDPROYECTO = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(TipoDeProyecto tipoDeProyecto) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { tipoDeProyecto.getIdTipoProyecto() };
			valores.put("IDTIPOPROYECTO", tipoDeProyecto.getIdTipoProyecto());
			valores.put("MODALIDADPROYECTO",
					tipoDeProyecto.getModalidadProyecto());
			contador = db.update("TIPO_DE_PROYECTO", valores,
					"IDTIPODEPROYECTO = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(TipoDeTrabajo tipoDeTrabajo) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { tipoDeTrabajo.getIdTipoDeTrabajo() };
			valores.put("IDTIPODETRABAJO", tipoDeTrabajo.getIdTipoDeTrabajo());
			valores.put("NOMBRETIPO", tipoDeTrabajo.getNombreTipo());
			contador = db.update("TIPO_DE_TRABAJO", valores,
					"IDTIPODETRABAJO = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String actualizar(Tutor tutor) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro modificado # = ";

		if (db != null) {
			ContentValues valores = new ContentValues();
			String[] id = { tutor.getCodigoTutor() };
			valores.put("CODIGOTUTOR", tutor.getCodigoTutor());
			valores.put("IDBENEFICIARIO", tutor.getIdBeneficiario());
			valores.put("NOMBRETUTOR", tutor.getNombreTutor());
			valores.put("APELLIDOTUTOR", tutor.getApellidoTutor());
			valores.put("SEXOTUTOR", tutor.getSexoTutor());
			contador = db.update("TUTOR", valores, "CODIGOTUTOR = ?", id);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al modificar el registro, Registro"
						+ "Duplicado. Verificar modificación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	// FIN de funciones de actualización de datos

	// Funciones de eliminación de datos

	public String eliminar(AlumnoExpediente alumExp) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro eliminado # = ";

		if (db != null) {
			String where = "CARNETALUMNO = '" + alumExp.getCarnetAlumno() + "'";
			contador = db.delete("ALUMNOEXPEDIENTE", where, null);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al eliminar el registro, Registro"
						+ "no encontrado. Verificar eliminación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String eliminar(Beneficiario beneficiario) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro eliminado # = ";

		if (db != null) {
			String where = "IDBENEFICIARIO = '"
					+ beneficiario.getIdBeneficiario() + "'";
			contador = db.delete("BENEFICIARIO", where, null);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al eliminar el registro, Registro"
						+ "no encontrado. Verificar eliminación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String eliminar(Bitacora bitacora) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro eliminado # = ";

		if (db != null) {
			String where = "IDBITACORA = '" + bitacora.getIdBitacora() + "'";
			contador = db.delete("BITACORA", where, null);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al eliminar el registro, Registro"
						+ "no encontrado. Verificar eliminación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String eliminar(Carreras carreras) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro eliminado # = ";

		if (db != null) {
			String where = "CODCARRERA = '" + carreras.getCodCarrera() + "'";
			contador = db.delete("CARRERAS", where, null);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al eliminar el registro, Registro"
						+ "no encontrado. Verificar eliminación";
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String eliminar(EncargadoDeServicioSocial encargado) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro eliminado # = ";

		if (db != null) {
			String where = "CARNETEMPLEADO = '" + encargado.getCarnetEmpleado()
					+ "'";
			contador = db.delete("ENCARGADO_DE_SERVICIO_SOCIAL", where, null);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al eliminar el registro, Registro"
						+ "no encontrado. Verificar eliminación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String eliminar(Escuela escuela) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro eliminado # = ";

		if (db != null) {
			String where = "CODESCUELA = '" + escuela.getCodEscuela() + "'";
			contador = db.delete("ESCUELA", where, null);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al eliminar el registro, Registro"
						+ "no encontrado. Verificar eliminación";
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String eliminar(Informe informe) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro eliminado # = ";

		if (db != null) {
			String where = "CORRINFORME = '" + informe.getCorrInforme() + "'";
			contador = db.delete("INFORME", where, null);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al eliminar el registro, Registro"
						+ "no encontrado. Verificar eliminación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String eliminar(Precios precios) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro eliminado # = ";

		if (db != null) {
			String where = "CORR = '" + precios.getCorr() + "'";
			contador = db.delete("PRECIOS", where, null);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al eliminar el registro, Registro"
						+ "no encontrado. Verificar eliminación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String eliminar(Proyecto proyecto) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro eliminado # = ";

		if (db != null) {
			String where = "IDPROYECTO = '" + proyecto.getIdProyecto() + "'";
			contador = db.delete("PROYECTO", where, null);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al eliminar el registro, Registro"
						+ "no encontrado. Verificar eliminación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String eliminar(TipoDeProyecto tipoDeProyecto) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro eliminado # = ";

		if (db != null) {
			String where = "IDTIPODEPROYECTO = '" + tipoDeProyecto.getIdTipoProyecto() + "'";
			contador = db.delete("TIPO_DE_PROYECTO", where, null);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al eliminar el registro, Registro"
						+ "no encontrado. Verificar eliminación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String eliminar(TipoDeTrabajo tipoDeTrabajo) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro eliminado # = ";

		if (db != null) {
			String where = "IDTIPODETRABAJO = '" + tipoDeTrabajo.getIdTipoDeTrabajo() + "'";
			contador = db.delete("TIPO_DE_TRABAJO", where,null);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al eliminar el registro, Registro"
						+ "no encontrado. Verificar eliminación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}

	public String eliminar(Tutor tutor) {
		// Abriendo la base de datos
		SQLiteDatabase db = getWritableDatabase();

		// Variables para controlar los registros insertados
		long contador = 0;
		String registrosModificados = "Registro eliminado # = ";

		if (db != null) {
			String where = "CODIGOTUTOR = '" + tutor.getCodigoTutor() + "'";
			contador = db.delete("TUTOR", where, null);

			// Cerrando base de datos
			db.close();

			if (contador == -1 || contador == 0) {
				registrosModificados = "Error al eliminar el registro, Registro"
						+ "no encontrado. Verificar eliminación";
			} else {
				registrosModificados = registrosModificados + contador;
			}
			return registrosModificados;
		}
		return "La Base de Datos no existe";
	}
	// FIN de funciones de eliminación de datos

	
	// Funciones de consulta de datos

	// FIN de funciones de consulta de datos

	// FIN FUNCIONES DE INSERCIÓN, ACTUALIZACIÓN, ELIMINACIÓN Y CONSULTA DE LAS
	// TABLAS

}
