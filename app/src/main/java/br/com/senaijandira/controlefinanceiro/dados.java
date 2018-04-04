package br.com.senaijandira.controlefinanceiro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class dados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
    }

    public void btn_receita(View view) {
             Intent intent =
                  new Intent(getApplicationContext(),
                        receitaActivity.class );

              startActivity(intent);

    }


    public void btn_despesa(View view) {
            Intent intent =
                new Intent(getApplicationContext(),
                        DespesaActivity.class );

                startActivity(intent);
    }


    public void lancamentos(View view) {
        Intent intent =
                new Intent(getApplicationContext(),
                        lancamentosActivity.class );

        startActivity(intent);

    }
}
