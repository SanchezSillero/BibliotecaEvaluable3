package model;

import exceptions.SinHuecoEnCatalogoException;

public class BibliotecaEspecializada extends Biblioteca{
    Tematica tematica;

    public BibliotecaEspecializada() {
    }

    @Override
    public void agregarLibroAlCatalogo() throws SinHuecoEnCatalogoException {
        Libro libro = generarLibro();
        if ( libro instanceof Terror && tematica.equals(Tematica.terror)){
            super.agregarLibroAlCatalogo();
        }
        if ( libro instanceof Ensayo && tematica.equals(Tematica.ensayo)){
            super.agregarLibroAlCatalogo();
        }
        if ( libro instanceof Comedia && tematica.equals(Tematica.comedia)){
            super.agregarLibroAlCatalogo();
        }
        if ( libro instanceof Policiaca && tematica.equals(Tematica.policiaca)){
            super.agregarLibroAlCatalogo();
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