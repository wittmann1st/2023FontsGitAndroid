package devandroid.wittmann.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import devandroid.wittmann.applistacurso.R;
import devandroid.wittmann.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    Pessoa outraPessoa;
    String dadosPessoa;
    String dadosOutraPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        // Atribuir conteúdo, dados, valores para objeto
        // Conforme o seu MODELO, TEMPLATE

        pessoa = new Pessoa();

        // Atribuir conteúdo, dados, valores para o Objeto
        pessoa.setPrimeiroNome("Roberto");
        pessoa.setSobreNome("Wittmann");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("11 1 1111 1111");

        outraPessoa = new Pessoa();

        outraPessoa.setPrimeiroNome("Carmela");
        outraPessoa.setSobreNome("Laurenzana");
        outraPessoa.setCursoDesejado("Java");
        outraPessoa.setTelefoneContato("22 2 2222 2222");

        dadosPessoa = "Primeiro Nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa += " Sobrenome: ";
        dadosPessoa += pessoa.getSobreNome();
        dadosPessoa += " Curso Desejado: ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa += " Telefone de contato: ";
        dadosPessoa += pessoa.getTelefoneContato();

        dadosOutraPessoa = "Primeiro Nome: ";
        dadosOutraPessoa += outraPessoa.getPrimeiroNome();
        dadosOutraPessoa += " Sobrenome: ";
        dadosOutraPessoa += outraPessoa.getSobreNome();
        dadosOutraPessoa += " Curso Desejado: ";
        dadosOutraPessoa += outraPessoa.getCursoDesejado();
        dadosOutraPessoa += " Telefone de contato: ";
        dadosOutraPessoa += outraPessoa.getTelefoneContato();

        int parada = 0;
    }
}