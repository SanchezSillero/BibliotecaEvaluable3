package model;

import java.util.Scanner;

public class Terror extends Libro {
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

    @Override
    public void pedirDatosLibro() {
        super.pedirDatosLibro();
        System.out.println("Introduce la clasificación por edad");
        calificacionEdad = scanner.nextInt();
    }

    public Terror generarTerror(){
        pedirDatosLibro();
        Terror terror = new Terror(isbn, titulo, autor, numeroPaginas, calificacionEdad);
        return terror;
    }

    @Override
    public String toString() {
        return "Terror{" +
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

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
