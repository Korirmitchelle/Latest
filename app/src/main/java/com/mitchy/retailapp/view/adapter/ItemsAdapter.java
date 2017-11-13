package com.mitchy.retailapp.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mitchy.retailapp.R;
import com.mitchy.retailapp.model.entities.Items;

import java.util.List;

/**
 * Created by mitchelle on 10/1/17.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.AnimeViewHolder> {
    private List<Items> items;

    public static class AnimeViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;
        public TextView visitas;
        public TextView shop;

        public AnimeViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
            visitas = (TextView) v.findViewById(R.id.visitas);
            shop = (TextView) v.findViewById(R.id.shopurl);
        }
    }

    public ItemsAdapter(List<Items> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public AnimeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerview_item_row, viewGroup, false);
        return new AnimeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AnimeViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageDrawable(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.visitas.setText("Price: "+String.valueOf(items.get(i).getVisitas())+" KES");
        viewHolder.shop.setText(items.get(i).getShop());
    }
}
