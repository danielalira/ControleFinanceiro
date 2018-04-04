package br.com.senaijandira.controlefinanceiro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class lancamentosActivity extends AppCompatActivity {

    TextView txt_valor_salario;
    TextView txt_valor_investimento;
    TextView txt_valor_poupanca;
    TextView txt_valor_aluguel;
    TextView txt_valor_lazer;
    TextView txt_valor_transporte;
    TextView txt_valor_saude;
    TextView txt_valor_moradia;
    String salario;
    String investimento;
    String poupanca;
    String aluguel;
    String lazer;
    String transporte;
    String saude;
    String moradia;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancamentos);

        txt_valor_salario = (TextView) findViewById(R.id.txt_valor_salario);
        txt_valor_investimento = (TextView) findViewById(R.id.txt_valor_investimento);
        txt_valor_poupanca = (TextView) findViewById(R.id.txt_valor_poupanca);
        txt_valor_aluguel = (TextView) findViewById(R.id.txt_valor_aluguel);
        txt_valor_lazer = (TextView) findViewById(R.id.txt_valor_lazer);
        txt_valor_transporte = (TextView) findViewById(R.id.txt_valor_transporte);
        txt_valor_saude = (TextView) findViewById(R.id.txt_valor_saude);
        txt_valor_moradia = (TextView) findViewById(R.id.txt_valor_moradia);

    }

    @Override
    protected void onResume () {
        super.onResume();

        visualizarSalario();
        visualizarInvestimento();
        visualizarPoupanca();
        visualizarAluguel();
        visualizarLazer();
        visualizarTransporte();
        visualizarSaude();
        visualizarMoradia();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void visualizarSalario(){

        salario = receitaDAO.getInstance().selectionarPorCategoria(this,"Salario").toString();
        txt_valor_salario.setText(salario);

    }

    public void visualizarInvestimento(){

        investimento = receitaDAO.getInstance().selectionarPorCategoria(this,"Investimento").toString();
        txt_valor_investimento.setText(investimento);

    }

    public void visualizarPoupanca(){

        poupanca = receitaDAO.getInstance().selectionarPorCategoria(this,"Poupanca").toString();
        txt_valor_poupanca.setText(poupanca);

    }

    public void visualizarAluguel(){

        aluguel = receitaDAO.getInstance().selectionarPorCategoria(this,"Aluguel").toString();
        txt_valor_aluguel.setText(aluguel);

    }

    public void visualizarLazer(){

        lazer = despesaDAO.getInstance().selectionarPorCategoria(this,"Lazer").toString();
        txt_valor_lazer.setText(lazer);

    }

    public void visualizarTransporte(){

        transporte = despesaDAO.getInstance().selectionarPorCategoria(this,"Transporte").toString();
        txt_valor_transporte.setText(transporte);

    }

    public void visualizarSaude(){

        saude = despesaDAO.getInstance().selectionarPorCategoria(this,"Saude").toString();
        txt_valor_saude.setText(saude);

    }

    public void visualizarMoradia(){

        moradia = despesaDAO.getInstance().selectionarPorCategoria(this,"Moradia").toString();
        txt_valor_moradia.setText(moradia);

    }
}
