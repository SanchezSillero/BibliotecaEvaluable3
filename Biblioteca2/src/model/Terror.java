package model;

public class Terror extends Libro{
    private int calificacionEdad;

    public Terror() {
    }

    public Terror(int isbn, String titulo, String autor, int numeroPaginas, int calificacionEdad) {
        super(isbn, titulo, autor, numeroPaginas);
        this.calificacionEdad = calificacionEdad;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("calificacionEdad = " + calificacionEdad);
    }

    public int getCalificacionEdad() {
        return calificacionEdad;
    }

    public void setCalificacionEdad(int calificacionEdad) {
        this.calificacionEdad = calificacionEdad;
    }
}
