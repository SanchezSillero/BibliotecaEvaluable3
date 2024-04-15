package model;

import exceptions.SinHuecoEnCatalogoException;

public class BibliotecaGeneral extends Biblioteca{
    public BibliotecaGeneral() {
    }

    public BibliotecaGeneral(String nombre, String director) {
        super(nombre, director);
    }

    @Override
    public void agregarLibroAlCatalogo() throws SinHuecoEnCatalogoException {
        super.agregarLibroAlCatalogo();
    }

}
