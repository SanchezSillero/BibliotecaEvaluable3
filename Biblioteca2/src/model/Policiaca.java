package model;

import java.util.ArrayList;

public class Policiaca extends Libro {
    Trama trama;
    ArrayList<String> listaPersonajes;

    public Policiaca() {
    }

    public Policiaca(int isbn, String titulo, String autor, int numeroPaginas, Trama trama, ArrayList<String> listaPersonajes) {
        super(isbn, titulo, autor, numeroPaginas);
        this.trama = trama;
        this.listaPersonajes = listaPersonajes;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("trama = " + trama);
        System.out.println("Lista persobajes: ");
        for (String personaje : listaPersonajes) {
            System.out.println(personaje);
        }
    }

    public Trama getTrama() {
        return trama;
    }

    public void setTrama(Trama trama) {
        this.trama = trama;
    }

    public ArrayList<String> getListaPersonajes() {
        return listaPersonajes;
    }

    public void setListaPersonajes(ArrayList<String> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }
}
