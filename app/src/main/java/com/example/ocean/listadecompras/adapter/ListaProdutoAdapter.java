package com.example.ocean.listadecompras.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ocean.listadecompras.R;

import java.util.List;

/**
 * Created by Ismael on 09/02/2015.
 *
 * Adapter customizado para imagem da foto do produto
 */
public class ListaProdutoAdapter extends BaseAdapter {

    private final List<String> listaProdutos;
    private final Activity activity;

    public ListaProdutoAdapter(List<String> listaProdutos, Activity activity) {
        this.listaProdutos = listaProdutos;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listaProdutos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaProdutos.get(position);
    }

    //TODO implementar apos a construção do banco
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Infla o layout na view
        View view = activity.getLayoutInflater().inflate(R.layout.item, null);

        String produto = listaProdutos.get(position);

        TextView nome = (TextView) view.findViewById(R.id.itemNome);
        nome.setText(produto);

        Bitmap bmp;
        bmp = BitmapFactory.decodeResource(activity.getResources(), R.drawable.no_images);
        bmp = Bitmap.createScaledBitmap(bmp, 100,100, true);
        ImageView foto = (ImageView) view.findViewById(R.id.itemFoto);
        foto.setImageBitmap(bmp);

       // TODO Colocar o Check na listview
       // CheckBox checkBox = (CheckBox) view.findViewById(R.id.itemCheck);
       //checkBox.setChecked(true);

        return view;
    }
}
