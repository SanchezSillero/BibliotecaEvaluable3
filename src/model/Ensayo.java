package model;

import java.util.Scanner;

public class Ensayo extends Libro {
    private String tematica;

    public Ensayo() {
    }

    public Ensayo(int isbn, String titulo, String autor, int numeroPaginas, Tipo tipo, String tematica) {
        super(isbn, titulo, autor, numeroPaginas, tipo);
        this.tematica = tematica;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("temática = " + tematica);
    }

    @Override
    public void pedirDatosLibro() {
        super.pedirDatosLibro();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la temática");
        tematica = scanner.nextLine();
    }

    public  Ensayo generarEnsayo(){
        pedirDatosLibro();
        Ensayo ensayo = new Ensayo(isbn,titulo,autor,numeroPaginas,tipo,tematica);
        return ensayo;
    }

    @Override
    public String toString() {
        return "Ensayo{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", tematica='" + tematica + '\'' +
                '}';
    }


    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }
}
