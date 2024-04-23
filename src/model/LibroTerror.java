package model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibroTerror extends Libro {
    private final Tipo tipo = Tipo.terror;
    private int calificacionEdad;


    public LibroTerror() {
    }

    public LibroTerror(int calificacionEdad) {
        this.calificacionEdad = calificacionEdad;
    }

    public LibroTerror(int isbn, String titulo, String autor, int numeroPaginas, Tipo tipo, int calificacionEdad) {
        super(isbn, titulo, autor, numeroPaginas);
        this.calificacionEdad = calificacionEdad;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Tipo = " + tipo);
        super.mostrarDatos();
        System.out.println("Calificación por edad = " + calificacionEdad);
    }

    @Override
    public void pedirDatosLibro() {
        super.pedirDatosLibro();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la clasificación por edad");
        try{
            calificacionEdad = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Edad no válida");
        }
    }

    public LibroTerror generarTerror(){
        pedirDatosLibro();
        LibroTerror libroTerror = new LibroTerror(isbn, titulo, autor, numeroPaginas, tipo, calificacionEdad);
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

    @Override
    public Tipo getTipo() {
        return tipo;
    }
}
