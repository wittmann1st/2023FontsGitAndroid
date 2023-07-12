package devandroid.wittmann.appgaseta.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import devandroid.wittmann.appgaseta.R;
import devandroid.wittmann.appgaseta.apoio.UtilGasEta;
import devandroid.wittmann.appgaseta.controller.CombustivelController;
import devandroid.wittmann.appgaseta.model.Combustivel;

public class GasEtaActivity extends AppCompatActivity {

    CombustivelController controller;
    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;

    EditText editGasolina;
    EditText editEtanol;

    TextView txtResultado;

    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    double precoGasolina;
    double precoEtanol;
    String recomendacao;

    List<Combustivel> dados;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gaseta);

        controller = new CombustivelController(GasEtaActivity.this);
        dados = controller.getListaDeDados();

        Combustivel objAlteracao = dados.get(1);

        objAlteracao.setNomeDoCombustivel("***GASOLINA***");
        objAlteracao.setPrecoDoCombustivel(5.97);
        objAlteracao.setRecomendacao("***Abastecer Gasolina");

 //     controller.alterar(objAlteracao);

        controller.deletar(13);

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);

        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isDadosOk = true;

                if(TextUtils.isEmpty(editGasolina.getText())){
                    editGasolina.setError("* Obrigatótio");
                    editGasolina.requestFocus();
                    isDadosOk = false;
                }
                if(TextUtils.isEmpty(editEtanol.getText())){
                    editEtanol.setError("* Obrigatótio");
                    editEtanol.requestFocus();
                    isDadosOk = false;
                }

                if(isDadosOk) {

                    precoGasolina = Double.parseDouble(editGasolina.getText().toString());
                    precoEtanol = Double.parseDouble(editEtanol.getText().toString());

                    recomendacao = UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol);

                    txtResultado.setText(recomendacao);

                    btnSalvar.setEnabled(true);
                }
                    else{
                        Toast.makeText(GasEtaActivity.this, "Digite os dados obrigatórios ...",
                                Toast.LENGTH_LONG).show();
                        btnSalvar.setEnabled(false);
                    }
                }

        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                combustivelGasolina = new Combustivel();
                combustivelEtanol = new Combustivel();

                combustivelGasolina.setNomeDoCombustivel("Gasolina");
                combustivelGasolina.setPrecoDoCombustivel(precoGasolina);

                combustivelEtanol.setNomeDoCombustivel("Etanol");
                combustivelEtanol.setPrecoDoCombustivel(precoEtanol);

                combustivelGasolina.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol));
                combustivelEtanol.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol));

                controller.Salvar(combustivelGasolina);
                controller.Salvar(combustivelEtanol);

                int parada = 0;

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editEtanol.setText("");
                editGasolina.setText("");
                txtResultado.setText("RESULTADO");

                btnSalvar.setEnabled(false);

                controller.limpar();
            }

        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GasEtaActivity.this, "Gas Eta boa economia!",
                        Toast.LENGTH_LONG).show();
                finish();
            }
        });

//        Toast.makeText(GasEtaActivity.this, UtilGasEta.calcularMelhorOpcao(5.12,3.49),
//        Toast.LENGTH_LONG).show();

    }

}

