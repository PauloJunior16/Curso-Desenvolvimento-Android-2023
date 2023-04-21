package devandroid.paulo.applistacurso.controller;

import android.util.Log;

import devandroid.paulo.applistacurso.model.Pessoa;

public class PessoaController {

    public void salvar(Pessoa pessoa) {
        Log.i("MVC_Controller", "Salvo: "+pessoa.toString());
    }
}
