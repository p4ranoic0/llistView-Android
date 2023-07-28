package com.isil.pregunta1;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class ProductoAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Producto> productList;

    public ProductoAdapter(Context context, ArrayList<Producto> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_product, parent, false);
        }

        Producto product = productList.get(position);

        TextView textViewCode = convertView.findViewById(R.id.textViewCode);
        TextView textViewName = convertView.findViewById(R.id.textViewName);

        textViewCode.setText("Código: " + product.getCodigo());
        textViewName.setText("Nombre: " + product.getNombre());

        return convertView;
    }
}
