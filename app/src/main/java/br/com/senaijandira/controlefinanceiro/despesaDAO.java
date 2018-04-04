package br.com.senaijandira.controlefinanceiro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by 17170082 on 04/04/2018.
 */

public class despesaDAO {

    ArrayList<despesa> lstDespesa = new ArrayList<>();

    private Integer idDespesa = 0;

    Context context;

    private static despesaDAO instance;

    public static despesaDAO getInstance()  {
        //SE NÃO HOUVER UM CONTATO CRIA UM NOVO

        if (instance == null) {
            instance = new despesaDAO();

        }


        return instance;

    }

/*Metodo inserir*/

    public Boolean inserir(Context context, despesa d){

        //Classe que contém os métodos de manipulação dos dados no banco;

        SQLiteDatabase db = new dbHelper(context).getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("categoria", d.getCategoria());
        valores.put("descricao", d.getDescricao());
        valores.put("valor", d.getValor());
        valores.put("data", d.getData().toString());

        long id = db.insert ( "tbl_despesa", null, valores);

        //Verifica se deu erro ou não na hora de inserir
        if(id != -1) {
            return true;
        }else{
            return false;
        }
    }


    public despesa selectionarUm(Context context, int id) {

        SQLiteDatabase db = new dbHelper(context).getReadableDatabase();
        String sql = "select * from tbl_despesa where _id =" +id;

        Cursor cursor= db.rawQuery(sql, null);

        if(cursor.getCount() > 0) {
            cursor.moveToFirst();

            despesa d  = new despesa();
            d.setId(cursor.getInt(0) /*acessando a coluna do id*/);
            d.setCategoria(cursor.getString(2));
            d.setDescricao(cursor.getString(3));
            d.setValor(cursor.getString(4));


            cursor.close();
            return d;

        }

        return null;
    }


/*SELECIONAR TODOS OS GANHOS - VISUALIZAR*/

    public ArrayList<despesa> selecionarTodos (Context context) {

        ArrayList<despesa> retorno = new ArrayList<>();

        SQLiteDatabase db = new dbHelper(context).getReadableDatabase();
        String sql = " Select * from tbl_despesa;";
        Cursor cursor= db.rawQuery(sql, null);


        while (cursor.moveToNext()){
            despesa d = new despesa();
            d.setId(cursor.getInt(0));
            d.setData(cursor.getString(1));
            d.setCategoria(cursor.getString(2));
            d.setDescricao(cursor.getString(3));
            d.setValor(cursor.getString(4));

            retorno.add(d);

        }

        return retorno;
    }


/*Metodo Atualizar*/


/*Metodo Remover*/

    public Boolean remover(Context context, Integer id) {
        SQLiteDatabase db = new dbHelper(context).getWritableDatabase();
        db.delete("tbl_despesa", "_id=?", new String[]{id.toString()});

        return true;
    }

//Função para mostrar vaores das categorias

    public Double selectionarPorCategoria(Context context, String categoria) {

        SQLiteDatabase db = new dbHelper (context).getReadableDatabase();

        String sql = "select * from tbl_despesa where categoria = ? ;" ;

        Cursor cursor= db.rawQuery(sql,new String[] {categoria });


        Double soma = 0.0;
        while (cursor.moveToNext()){


            soma += cursor.getDouble(4);

        }

        cursor.close();

        return soma;

    }


}
