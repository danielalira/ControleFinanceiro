package br.com.senaijandira.controlefinanceiro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class receitaDAO {

    ArrayList <receita> lstReceita = new ArrayList<>();

    private Integer idReceita = 0;

    Context context;

    private static receitaDAO instance;

    public static receitaDAO getInstance()  {
        //SE NÃO HOUVER UM CONTATO CRIA UM NOVO

        if (instance == null) {
            instance = new receitaDAO ();

        }


        return instance;

    }


/*Metodo inserir*/

    public Boolean inserir(Context context, receita r){

        //Classe que contém os métodos de manipulação dos dados no banco;

        SQLiteDatabase db = new dbHelper(context).getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put("data", r.getData());
        valores.put("categoria", r.getCategoria());
        valores.put("descricao", r.getDescricao());
        valores.put("valor", r.getValor());

        long id = db.insert ( "tbl_receita", null, valores);

        //Verifica se deu erro ou não na hora de inserir
        if(id != -1) {
            return true;
        }else{
            return false;
        }
    }


    public receita selectionarUm(Context context, int id) {

        SQLiteDatabase db = new dbHelper(context).getReadableDatabase();
        String sql = "select * from tbl_receita where _id =" +id;

        Cursor cursor= db.rawQuery(sql, null);

        if(cursor.getCount() > 0) {
            cursor.moveToFirst();

            receita r  = new receita();
            r.setId(cursor.getInt(0) /*acessando a coluna do id*/);
            r.setData(cursor.getString(1));
            r.setCategoria(cursor.getString(2));
            r.setDescricao(cursor.getString(3));
            r.setValor(cursor.getString(4));


            cursor.close();
            return r;

        }

        return null;
    }


/*SELECIONAR TODOS OS GANHOS - VISUALIZAR*/

    public ArrayList<receita> selecionarTodos (Context context) {

        ArrayList<receita> retorno = new ArrayList<>();

        SQLiteDatabase db = new dbHelper(context).getReadableDatabase();
        String sql = " Select * from tbl_receita;";
        Cursor cursor= db.rawQuery(sql, null);


        while (cursor.moveToNext()){
            receita r = new receita();
            r.setId(cursor.getInt(0));
            r.setData(cursor.getString(1));
            r.setCategoria(cursor.getString(2));
            r.setDescricao(cursor.getString(3));
            r.setValor(cursor.getString(4));

            retorno.add(r);

        }

        return retorno;
    }


/*Metodo Atualizar*/


/*Metodo Remover*/

    public Boolean remover(Context context, Integer id) {
        SQLiteDatabase db = new dbHelper(context).getWritableDatabase();
        db.delete("tbl_receita", "_id=?", new String[]{id.toString()});

        return true;
    }

//Função para mostrar vaores das categorias

    public Double selectionarPorCategoria(Context context, String categoria) {

        SQLiteDatabase db = new dbHelper (context).getReadableDatabase();

        String sql = "select * from tbl_receita where categoria = ? ;" ;

        Cursor cursor= db.rawQuery(sql,new String[] {categoria });


        Double soma = 0.0;
        while (cursor.moveToNext()){

            soma += cursor.getDouble(4);

        }

        cursor.close();

        return soma;

    }
}





