package devandroid.wittmann.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import devandroid.wittmann.applistacurso.R;
import devandroid.wittmann.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        // Atribuir conteúdo, dados, valores para objeto
        // Conforme o seu MODELO, TEMPLATE

        pessoa = new Pessoa();


    }
}