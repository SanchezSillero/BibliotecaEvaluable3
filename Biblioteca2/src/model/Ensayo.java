package model;

import java.util.Scanner;

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

    @Override
    public void pedirDatosLibro() {
        super.pedirDatosLibro();
        System.out.println("Introduce la temática");
        tematica = scanner.nextLine();
    }

    public  Ensayo generarEnsayo(){
        pedirDatosLibro();
        Ensayo ensayo = new Ensayo(isbn,titulo,autor,numeroPaginas, tematica);
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
