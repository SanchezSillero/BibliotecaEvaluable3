package model;

import exceptions.SinHuecoEnCatalogoException;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaEspecializada extends Biblioteca{
    Tematica tematica;


    public BibliotecaEspecializada() {
    }

    @Override
    public void agregarLibroAlCatalogo() throws SinHuecoEnCatalogoException {
        ArrayList<Libro> listaLibros = getListaLibros();
        for (Libro item : listaLibros) {
            if ( item instanceof LibroTerror && tematica.equals(Tematica.terror)){
                super.agregarLibroAlCatalogo();
            }
            if ( item instanceof Ensayo && tematica.equals(Tematica.ensayo)){
                super.agregarLibroAlCatalogo();
            }
            if ( item instanceof LibroComedia && tematica.equals(Tematica.comedia)){
                super.agregarLibroAlCatalogo();
            }
            if ( item instanceof LibroPoliciaca && tematica.equals(Tematica.policiaca)){
                super.agregarLibroAlCatalogo();
            }
        }


    }

    public BibliotecaEspecializada(String nombre, String director, Tematica tematica) {
        super(nombre, director);
        this.tematica = tematica;
    }

    public Tematica getTematica() {
        return tematica;
    }

    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }
}
