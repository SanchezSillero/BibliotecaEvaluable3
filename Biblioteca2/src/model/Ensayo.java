package model;

public class Ensayo extends Libro {
    private String tematica;

    public Ensayo() {
    }

    public Ensayo(int isbn, String titulo, String autor, int numeroPaginas, String tematica) {
        super(isbn, titulo, autor, numeroPaginas);
        this.tematica = tematica;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("tematica = " + tematica);
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }
}
