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

import devandroid.wittmann.appgaseta.R;
import devandroid.wittmann.appgaseta.apoio.UtilGasEta;

public class GasEtaActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gaseta);

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
                }
                    else{
                        Toast.makeText(GasEtaActivity.this, "Digite os dados obrigatórios ...",
                                Toast.LENGTH_LONG).show();
                    }
                }

        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editEtanol.setText("");
                editGasolina.setText("");
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

        Toast.makeText(GasEtaActivity.this, UtilGasEta.calcularMelhorOpcao(5.12,3.49),
        Toast.LENGTH_LONG).show();

    }

}

