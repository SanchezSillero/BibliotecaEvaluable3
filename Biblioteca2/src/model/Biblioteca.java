package model;

import java.util.ArrayList;

public abstract class Biblioteca implements Mostrable {
    private String nombre;
    private String director;
    private Catalogo catalogo;

    public Biblioteca() {
    }

    public Biblioteca(String nombre, String director) {
        this.nombre = nombre;
        this.director = director;
    }

    public void construirCatalogo(int capacidad){
        this.catalogo = new Catalogo(capacidad);
    }

    @Override
    public void mostrarDatos() {
        for (Libro libro : catalogo.listaLibros) {
            System.out.println(libro);
        }
    }

    class Catalogo{
        int capacidad;
        ArrayList<Libro> listaLibros;

        public Catalogo(int capacidad) {
            this.capacidad = capacidad;
            listaLibros= new ArrayList<>(capacidad);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

}
