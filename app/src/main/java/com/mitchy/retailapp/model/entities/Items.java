package com.mitchy.retailapp.model.entities;

import android.graphics.drawable.Drawable;

/**
 * Created by mitchelle on 10/1/17.
 */

public class Items {
    private Drawable imagen;
    private String nombre;
    private String visitas;
    private String shop;

    public Items(Drawable imagen, String nombre, String visitas, String shop) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.visitas = visitas;
        this.shop = shop;
    }

    public String getNombre() {
        return nombre;
    }

    public String getVisitas() {
        return visitas;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public String getShop(){
        return shop;
    }
}
