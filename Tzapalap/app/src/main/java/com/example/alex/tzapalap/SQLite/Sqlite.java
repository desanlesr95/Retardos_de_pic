package com.example.alex.tzapalap.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;

import java.util.ArrayList;
import java.util.List;

public class Sqlite {
    SqliteHelper sqliteHelper;
    SQLiteDatabase database;

    public Sqlite(Context context) {
        sqliteHelper = new SqliteHelper(context);
    }

    public void abrir() {
        database = sqliteHelper.getReadableDatabase();
    }

    public void cerrar() {
        sqliteHelper.close();
    }

    /////////Escribir Cursor//////////////////////////////////////////////////
    public List<String> escribe(Cursor cursor, int n) {
        List<String> lista = new ArrayList();
        if (cursor.moveToFirst()) {
            do {
                for (int num = 0; num < n; num++) {
                    lista.add(cursor.getString(num));
                }
            } while (cursor.moveToNext());
        }
        return lista;
    }

    /////////////////////Selects///////////////////////////////////////////////////////////////////
    public Cursor selectusuarios() {
        String[] datos = new String[]{
                sqliteHelper.usuario_id,
                sqliteHelper.nombre,
                sqliteHelper.apellido_p,
                sqliteHelper.apellido_m,
                sqliteHelper.edad,
                sqliteHelper.localidad,
                sqliteHelper.contra
        };
        //Tablas,columnas,where,arqumetoswhere,groupby,having,orderby
        return database.query(sqliteHelper.usuarios, datos, null, null, null, null, null);
    }
    public Cursor selectusuarios(String id,String contra) {
        String[] datos = new String[]{
                sqliteHelper.usuario_id,
                sqliteHelper.nombre,
                sqliteHelper.apellido_p,
                sqliteHelper.apellido_m,
                sqliteHelper.edad,
                sqliteHelper.localidad,
                sqliteHelper.contra
        };
        String where =  sqliteHelper.usuario_id+" =? AND "+sqliteHelper.contra+" =?";
        String arg[] = {id,contra};
        //Tablas,columnas,where,arqumetoswhere,groupby,having,orderby
        return database.query(sqliteHelper.usuarios, datos, where, arg, null, null, null);
    }

    public Cursor selectinventario(String id) {
        String[] datos = new String[]{
                sqliteHelper.inventario_id,
                sqliteHelper.cantidad_colmenas,
                sqliteHelper.cantidad_bastidores,
                sqliteHelper.kilos_extraidos,
                sqliteHelper.inventario_usuario_id
        };
        String where =  " usuario_id = ? ";
        String arg[] = {id};
        //Tablas,columnas,where,arqumetoswhere,groupby,having,orderby
        return database.query(sqliteHelper.inventario, datos, where, arg, null, null, null);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////


    //Inserts//////////////////////////////////////////////////////////////////////////
    public long insertausuario(String id, String nombre,String apellido_p,String apellido_m,int edad,String localidad,String contra) {
        ContentValues values = new ContentValues();
        values.put(sqliteHelper.usuario_id, id);
        values.put(sqliteHelper.nombre, nombre);
        values.put(sqliteHelper.apellido_p, apellido_p);
        values.put(sqliteHelper.apellido_m, apellido_m);
        values.put(sqliteHelper.edad, edad);
        values.put(sqliteHelper.localidad, localidad);
        values.put(sqliteHelper.contra, contra);
        return database.insert(sqliteHelper.usuarios, null, values);
    }

    public long insertainventario(int id, int cantidad_colmenas, int cantidad_bastidores, float kilos,String id_usuario) {
        ContentValues values = new ContentValues();
        values.put(sqliteHelper.inventario_id,id);
        values.put(sqliteHelper.cantidad_colmenas, cantidad_colmenas);
        values.put(sqliteHelper.cantidad_bastidores, cantidad_bastidores);
        values.put(sqliteHelper.kilos_extraidos, kilos);
        values.put(sqliteHelper.inventario_usuario_id, id_usuario);
        return database.insert(sqliteHelper.inventario, null, values);
    }

}
