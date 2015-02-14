package com.example.ocean.listadecompras.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ocean.listadecompras.R;
import com.example.ocean.listadecompras.model.bean.Produto;

import java.util.ArrayList;

/**
 * Created by Ismael on 09/02/2015.
 *
 * Adapter customizado para imagem da foto do produto
 */
public class ListaProdutoAdapter extends ArrayAdapter<Produto> {

    private final ArrayList<Produto> listaProdutos;
//    private final Activity activity;
    private Context context;

    //Context context, int textViewResourceId, ArrayList<Country> countryList
    public ListaProdutoAdapter(Context context, int textViewResourceId, ArrayList<Produto> listaProdutos) {
        super(context, textViewResourceId, listaProdutos);
        this.context = context;
        this.listaProdutos = new ArrayList<Produto>();
        this.listaProdutos.addAll(listaProdutos);
    }

    private class ViewHolder {
        Bitmap bmp;
        TextView name;
        CheckBox produto;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Log.v("ConvertView", String.valueOf(position));

        if (convertView == null){
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.item, null);

            holder = new ViewHolder();
            holder.bmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.no_images);
            holder.bmp = Bitmap.createScaledBitmap(holder.bmp, 100, 100, true);
            ImageView foto = (ImageView) convertView.findViewById(R.id.itemFoto);
            foto.setImageBitmap(holder.bmp);

            holder.name = (TextView) convertView.findViewById(R.id.itemNome);
            holder.produto = (CheckBox) convertView.findViewById(R.id.checkbox);
            convertView.setTag(holder);
            //TODO ENTENDER...
            holder.name.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v;
                    Produto produto = (Produto) cb.getTag();
                    Toast.makeText(context.getApplicationContext(), "Clicked on Checkbox: " +" is " + cb.isChecked(),
                             Toast.LENGTH_LONG).show();
                    produto.setSelected(cb.isSelected());
                }
            });
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        //TODO ENTENDER...
        Produto produto = listaProdutos.get(position);
        holder.name.setText(" (" + produto.getNome() + ")");
        holder.name.setText(produto.getNome());
        holder.name.setSelected(produto.getSelected());
        holder.name.setTag(produto);

        return convertView;
    }
}
