package model;

public class BibliotecaEspecializada extends Biblioteca {
    private Tematica tematica;

    public BibliotecaEspecializada(String nombre, String director, Tematica tematica) {
        super(nombre, director);
        this.tematica = tematica;
    }

    @Override
    public void agregarLibro(Libro libro) {
        if ((libro instanceof Terror && tematica == Tematica.terror) ||
                (libro instanceof Comedia && tematica == Tematica.comedia) ||
                (libro instanceof Ensayo && tematica == Tematica.ensayo) ||
                (libro instanceof Policiaca && tematica == Tematica.policiaca))
            super.agregarLibro(libro);
        else {
            System.out.println("Libro no agregado. Solo se aceptan libros de temática " + this.tematica);
        }
    }
}
