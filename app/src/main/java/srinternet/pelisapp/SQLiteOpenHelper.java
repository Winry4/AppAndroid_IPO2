package srinternet.pelisapp;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Rebeca on 23/05/2018.
 */

public class SQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper{
    String sqlCrearTabla = "CREATE TABLE Contactos(nombre TEXT, telefono TEXT)";

    public SQLiteOpenHelper(Context contexto, String nombreBD, SQLiteDatabase.CursorFactory factory, int versionBD) {
        super(contexto, nombreBD, factory, versionBD);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
/*Se ejecuta la sentencia SQL de creación de la tabla*/
            db.execSQL(sqlCrearTabla);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        try {
/*Se elimina la versión anterior de la table*/
            db.execSQL("DROP TABLE IF EXISTS Peliculas");
/*Se crea la nueva versión de la table*/
            db.execSQL(sqlCrearTabla);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
