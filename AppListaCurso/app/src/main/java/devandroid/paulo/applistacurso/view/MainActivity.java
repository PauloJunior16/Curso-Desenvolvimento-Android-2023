package devandroid.paulo.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import devandroid.paulo.applistacurso.R;
import devandroid.paulo.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;

    String dadosPessoa;

    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editNomeCurso;
    EditText editContato;

    Button button;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editContato = findViewById(R.id.editContato);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editContato.setText(pessoa.getTelefoneContato());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editNomeCurso.setText("");
                editContato.setText("");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(
                        MainActivity.this,
                        "Volte Sempre!",
                        Toast.LENGTH_SHORT
                ).show();

                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editSobrenome.getText().toString());
                pessoa.setCursoDesejado(editNomeCurso.getText().toString());
                pessoa.setTelefoneContato(editContato.getText().toString());

                Toast.makeText(
                        MainActivity.this,
                        "Dados Salvos",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });


//        dadosPessoa += pessoa.getPrimeiroNome();
//        dadosPessoa += " Sobrenome: ";
//        dadosPessoa += pessoa.getSobreNome();
//        dadosPessoa += " Curso desejado: ";
//        dadosPessoa += pessoa.getCursoDesejado();
//        dadosPessoa += " Telefone ";
//        dadosPessoa += pessoa.getTelefoneContato();

        int parada = 0;
    }
}