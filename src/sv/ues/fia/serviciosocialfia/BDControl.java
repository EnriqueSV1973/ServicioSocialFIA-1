package sv.ues.fia.serviciosocialfia;

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
			+ "(IDEXPEDIENTE         CHAR(10)             not null,"
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
			+ "constraint PK_ALUMNOEXPEDIENTE primary key (IDEXPEDIENTE));";

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
			+ "constraint PK_INFORME primary key (IDEXPEDIENTE, CODIGOTUTOR));";

	// TABLA: PRECIOS
	private static final String TABLA_PRECIOS = "create table PRECIOS "
			+ "(IDTIPODETRABAJO     CHAR(10)             not null,"
			+ "CORR                 CHAR(2),"
			+ "PRECIO               FLOAT                not null,"
			+ "FECHAINICIALAPLIPRE  CHAR(10)             not null,"
			+ "FECHAFINALAPLIPRE    CHAR(10) ," + "OBSERVACION          CHAR(25),"
			+ "constraint PK_PRECIOS primary key (IDTIPODETRABAJO));";

	// TABLA: PROYECTO
	private static final String TABLA_PROYECTO = "create table PROYECTO "
			+ "(IDPROYECTO          CHAR(10)             not null,"
			+ "IDBENEFICIARIO       CHAR(10)             not null,"
			+ "IDTIPOPROYECTO       CHAR(10),"
			+ "CARNETEMPLEADO       CHAR(7),"
			+ "IDTIPODETRABAJO      CHAR(10)             not null,"
			+ "NOMBREDEPROYECTO     CHAR(100)            not null,"
			+ "DESCRIPCIONPROYECTO  CHAR(100)            not null,"
			+ "DURACIONPROYECTO     FLOAT,"
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
			+ "HORAINICIO           CHAR(10) ," + "HORAFIN              CHAR(5) ,"
			+ "FECHAACTIVIDAD       CHAR(10) ," + "CANTIDADHORAS        INTEGER,"
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

	// FIN de funciones de inserción de datos

	// Funciones de actualización de datos

	// FIN de funciones de actualización de datos

	// Funciones de eliminación de datos

	// FIN de funciones de eliminación de datos

	// Funciones de consulta de datos

	// FIN de funciones de consulta de datos

	// FIN FUNCIONES DE INSERCIÓN, ACTUALIZACIÓN, ELIMINACIÓN Y CONSULTA DE LAS
	// TABLAS

}
