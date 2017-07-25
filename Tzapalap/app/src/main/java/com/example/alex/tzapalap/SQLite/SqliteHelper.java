package com.example.alex.tzapalap.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class SqliteHelper extends SQLiteOpenHelper {
    private static final String _database_ = "bd";
    private static final int _version_ = 4;

    public SqliteHelper(Context context) {
        super(context, _database_, null, _version_);
    }

    public String usuarios="usuarios";
    public String usuario_id="id_usuario";
    public String nombre = "nombre";
    public String apellido_p = "apellido_p";
    public String apellido_m = "apellido_m";
    public String edad="edad";
    public String localidad="localidad";
    public String contra="contra";
    private String sql = "CREATE TABLE IF NOT EXISTS " + usuarios + "(" + usuario_id+ " TEXT PRIMARY KEY , " + nombre + " TEXT, "+apellido_p+" TEXT, "+apellido_m+
            " TEXT, "+edad+" INTEGER, "+localidad+" TEXT, "+contra+" TEXT)";


    public String inventario="inventarios";
    public String inventario_id="id_inventario";
    public String cantidad_colmenas= "cantidad_colmenas";
    public String cantidad_bastidores = "cantidad_bastidores";
    public String kilos_extraidos = "kilos_extraidos";
    public String inventario_usuario_id="usuario_id";
    private String sql2 = "CREATE TABLE IF NOT EXISTS " + inventario + "(" +inventario_id + " INTEGER PRIMARY KEY , " + cantidad_colmenas + " INTEGER, "
            +cantidad_bastidores+" INTEGER, "+kilos_extraidos+ " REAL, "+inventario_usuario_id+" TEXT REFERENCES "+usuarios+")";



    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("base de datos", _database_ + "creada con exito");
        db.execSQL(sql);
        db.execSQL(sql2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            ;
            db.execSQL("DROP TABLE IF EXISTS " + usuarios);
            db.execSQL(sql);
            db.execSQL(sql2);
        }
    }
}
