package model;

import java.util.Scanner;

public class Comedia extends Libro {
    private String tipoDeHumor;
    private Scanner scanner = new Scanner(System.in);

    public Comedia() {
    }

    public Comedia(int isbn, String titulo, String autor, int numeroPaginas, String tipoDeHumor) {
        super(isbn, titulo, autor, numeroPaginas);
        this.tipoDeHumor = tipoDeHumor;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("tipoDeHumor = " + tipoDeHumor);
    }

    @Override
    public void pedirDatosLibro() {
        super.pedirDatosLibro();
        System.out.println("Introduce el tipo de humor");
        tipoDeHumor=scanner.nextLine();
    }

    public String getTipoDeHumor() {
        return tipoDeHumor;
    }

    public void setTipoDeHumor(String tipoDeHumor) {
        this.tipoDeHumor = tipoDeHumor;
    }
}
