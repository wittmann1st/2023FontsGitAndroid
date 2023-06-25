package devandroid.wittmann.appgaseta.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.wittmann.appgaseta.R;
import devandroid.wittmann.appgaseta.apoio.UtilGasEta;

public class GasEtaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gaseta);

        Toast.makeText(GasEtaActivity.this, UtilGasEta.calcularMelhorOpcao(5.12,3.49),
        Toast.LENGTH_LONG).show();


    }

}

