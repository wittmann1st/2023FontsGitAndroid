package devandroid.wittmann.appminhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import devandroid.wittmann.appminhaideia.R;
import devandroid.wittmann.appminhaideia.core.AppUtil;
import devandroid.wittmann.appminhaideia.model.Cliente;

public class MainActivity extends AppCompatActivity {

    TextView txtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(AppUtil.TAG, "onCreate Tela Principal carregada ...");

        Bundle bundle = getIntent().getExtras();

        Log.d(AppUtil.TAG, "onCreate: Nome... "+bundle.getString("nome"));
        Log.d(AppUtil.TAG, "onCreate: email... "+bundle.getString("email"));

        txtNome = findViewById(R.id.txtNome);
        txtNome.setText("Bem vindo... "+bundle.getString("nome"));


    }
}