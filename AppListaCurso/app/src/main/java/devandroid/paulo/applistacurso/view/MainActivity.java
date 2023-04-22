package devandroid.paulo.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import devandroid.paulo.applistacurso.R;
import devandroid.paulo.applistacurso.controller.CursoController;
import devandroid.paulo.applistacurso.controller.PessoaController;
import devandroid.paulo.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {
    Pessoa pessoa;
    List<String> nomesDosCursos;

    CursoController cursoController;
    PessoaController controller;

    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editNomeCurso;
    EditText editContato;

    Button button;
    Button button2;
    Button button3;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        controller = new PessoaController(MainActivity.this);

        pessoa = new Pessoa();

        controller.buscar(pessoa);

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        editContato = findViewById(R.id.editContato);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editContato.setText(pessoa.getTelefoneContato());

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        cursoController = new CursoController();
        nomesDosCursos = cursoController.dadosParaSpinner();
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                cursoController.dadosParaSpinner()
        );

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editNomeCurso.setText("");
                editContato.setText("");

                controller.limpar();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(
                        MainActivity.this,
                        "Volte sempre!",
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
                        "Dados Salvos: " + pessoa.toString(),
                        Toast.LENGTH_SHORT
                ).show();

                controller.salvar(pessoa);
            }
        });
    }
}