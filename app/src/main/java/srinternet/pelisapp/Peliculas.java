package srinternet.pelisapp;

import android.graphics.Bitmap;

/**
 * Created by Rebeca on 21/05/2018.
 */

public class Peliculas {
    String nombre;
    Bitmap imagen;
    String duracion;
    int valoración;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getValoración() {
        return valoración;
    }

    public void setValoración(int valoración) {
        this.valoración = valoración;
    }

    public Peliculas(String nombre, Bitmap imagen, String duracion, int valoración) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.duracion = duracion;
        this.valoración=valoración;
    }

    public Peliculas(String nombre, String duracion, int valoración) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.valoración=valoración;
    }
}
