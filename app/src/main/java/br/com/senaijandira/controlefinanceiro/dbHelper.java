package br.com.senaijandira.controlefinanceiro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "controleFinancas.db";

    private static int DB_VERSION = 1;

    public dbHelper (Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);}


    @Override
    public void onCreate(SQLiteDatabase  db) {

        String sql = "create table tbl_receita(" +
                "_id INTEGER primary key autoincrement," +
                "data TEXT," +
                "categoria CHAR," +
                "descricao TEXT," +
                "valor FLOAT);";

        db.execSQL(sql);

        String sql2 = "create table tbl_despesa(" +
                "_id INTEGER primary key autoincrement," +
                "data TEXT," +
                "categoria CHAR," +
                "descricao TEXT," +
                "valor FLOAT);";

        db.execSQL(sql2);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table tbl_receita");
        onCreate(db);
        db.execSQL("drop table tbl_despesa");
        onCreate(db);
    }
}
