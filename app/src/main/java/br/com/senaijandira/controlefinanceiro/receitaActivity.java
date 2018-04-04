package br.com.senaijandira.controlefinanceiro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class receitaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String [] lista = {"Salario", "Investimento", "Poupanca", "Aluguel", "Outros"};

    EditText valor;
    EditText descricao;
    EditText txt_dt_nascimento;
    EditText data;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receita);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txt_dt_nascimento = (EditText) findViewById((R.id.txt_dt_nascimento));
        descricao = (EditText) findViewById(R.id.descricao);
        valor = (EditText) findViewById(R.id.valor);
        data = (EditText) findViewById(R.id.valor);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void onNothingSelected(AdapterView<?> adapterView) {


    }



    public void salvar_receita(View view) {

        receita r = new receita();

        r.setValor(valor.getText().toString());
        r.setDescricao(descricao.getText().toString());
        r.setData(data.getText().toString());
        r.setCategoria(spinner.getSelectedItem().toString());

        receitaDAO.getInstance().inserir(this,r);

        Intent intent = new Intent(getApplicationContext(),
                        lancamentosActivity.class );

        startActivity(intent);

    }
}
