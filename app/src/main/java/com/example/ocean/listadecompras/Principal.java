package com.example.ocean.listadecompras;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import com.example.ocean.listadecompras.swipe.SwipeDismissListViewTouchListener;

import java.util.ArrayList;


public class Principal extends ActionBarActivity {

    private ListView lv;
    private AutoCompleteTextView textView;
    private ArrayAdapter<String> mAdapter;

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
        final ArrayList<String> produtos2 = new ArrayList<>();

        //TODO Usar Array mAdapter com imagem no AutoComplete
       ArrayAdapter<String> arrayAdapterInserir = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, produtos );
        textView.setAdapter(arrayAdapterInserir);

       //TODO Utilizar ArrayAdapter com imagem na Lista com Check
        mAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, produtos2);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        lv.setAdapter(mAdapter);

        textView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                produtos2.add(textView.getText().toString());

                textView.setText("");

                mAdapter.notifyDataSetChanged();
            }
        });

        SwipeDismissListViewTouchListener touchListener =
                new SwipeDismissListViewTouchListener(
                        lv,
                        new SwipeDismissListViewTouchListener.OnDismissCallback() {
                            @Override
                            public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                                for (int position : reverseSortedPositions) {
                                    mAdapter.remove(mAdapter.getItem(position));
                                }
                                mAdapter.notifyDataSetChanged();
                            }
                        });
        lv.setOnTouchListener(touchListener);
        // Setting this scroll listener is required to ensure that during ListView scrolling,
        // we don't look for swipes.
        lv.setOnScrollListener(touchListener.makeScrollListener());
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
