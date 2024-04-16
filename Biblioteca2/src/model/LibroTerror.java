package model;

import java.util.Scanner;

public class LibroTerror extends Libro {
    private int calificacionEdad;


    public LibroTerror() {
    }

    public LibroTerror(int isbn, String titulo, String autor, int numeroPaginas, int calificacionEdad) {
        super(isbn, titulo, autor, numeroPaginas);
        this.calificacionEdad = calificacionEdad;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("calificacionEdad = " + calificacionEdad);
    }

    @Override
    public void pedirDatosLibro() {
        super.pedirDatosLibro();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la clasificación por edad");
        calificacionEdad = scanner.nextInt();
    }

    public LibroTerror generarTerror(){
        pedirDatosLibro();
        LibroTerror libroTerror = new LibroTerror(isbn, titulo, autor, numeroPaginas, calificacionEdad);
        return libroTerror;
    }

    @Override
    public String toString() {
        return "LibroTerror{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", calificacionEdad=" + calificacionEdad +
                '}';
    }

    public int getCalificacionEdad() {
        return calificacionEdad;
    }

    public void setCalificacionEdad(int calificacionEdad) {
        this.calificacionEdad = calificacionEdad;
    }
}
