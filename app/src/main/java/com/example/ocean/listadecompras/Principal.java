package com.example.ocean.listadecompras;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import com.example.ocean.listadecompras.adapter.ListaProdutoAdapter;

import java.util.ArrayList;


public class Principal extends ActionBarActivity {

    private ListView lv;
    private AutoCompleteTextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal_layout);

        lv = (ListView) findViewById(R.id.lvListagem);
        textView = (AutoCompleteTextView) findViewById(R.id.edAutoComplete);

        // TODO utilizar o bean produto
        ArrayList<String> produtos = new ArrayList<>();
        produtos.add("arroz");
        produtos.add("feijão");
        produtos.add("macarrão");
        produtos.add("azeite");

        // TODO utilizar o bean produto
        ArrayList<String> produtos2 = new ArrayList<>();

        //TODO Criar ArrayAdapter para o auto complete mostrar imagem
       ArrayAdapter<String> arrayAdapterInserir = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, produtos );
        textView.setAdapter(arrayAdapterInserir);

       // Utilizando o array adapter customizado
        final ListaProdutoAdapter arrayAdapter = new ListaProdutoAdapter(produtos2, this);
       lv.setAdapter(arrayAdapter);

        textView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                produtos2.add(textView.getText().toString());

                textView.setText("");

                arrayAdapter.notifyDataSetChanged();
            }
        });

       // Escuta o evento de Click Curto
       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // TODO form direcionar para o CADASTRO
               Intent form = new Intent(Principal.this, Cadastro.class);

               String produto = (String) lv.getItemAtPosition(position);

              // Toast.makeText(Principal.this, produto, Toast.LENGTH_LONG).show();

               form.putExtra("PRODUTO", produto);

               startActivity(form);
           }
       });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
