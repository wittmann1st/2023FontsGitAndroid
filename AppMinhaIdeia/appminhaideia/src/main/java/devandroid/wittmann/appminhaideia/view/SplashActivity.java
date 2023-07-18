package devandroid.wittmann.appminhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import devandroid.wittmann.appminhaideia.R;
import devandroid.wittmann.appminhaideia.controller.ClienteController;
import devandroid.wittmann.appminhaideia.core.AppUtil;
import devandroid.wittmann.appminhaideia.model.Cliente;

public class SplashActivity extends AppCompatActivity {

    int tempoDeEspera = 1000 * 3;
    TextView txtAppVersion;
    Cliente objCliente;
    ClienteController clienteController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Log.d(AppUtil.TAG, "onCreate: Tela Splash carregada ...");

        txtAppVersion = findViewById(R.id.txtAppVersion);
        txtAppVersion.setText(AppUtil.versaoDoAplicativo());

        clienteController = new ClienteController();

        trocarTela();

    }
    private void trocarTela() {

        Log.d(AppUtil.TAG, "trocarTela: Mudando de tela...");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                objCliente = new Cliente("Roberto", "teste@teste.com",
                        "1111-1111",
                        49,true);

                Log.d(AppUtil.TAG, "trocarTela: Esperando um tempo...");

                Intent trocarDeTela = new Intent(SplashActivity.this, MainActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("nome", objCliente.getNome());
                bundle.putString("email", objCliente.getEmail());

                trocarDeTela.putExtras(bundle);

                startActivity(trocarDeTela);
                finish();

            }
        },tempoDeEspera);


    }
}