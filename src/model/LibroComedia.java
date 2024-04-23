package model;

import java.util.Scanner;

public class LibroComedia extends Libro {
    private TipoHumor tipoDeHumor;

    public LibroComedia() {
    }

    public LibroComedia(int isbn, String titulo, String autor, int numeroPaginas, Tipo tipo, TipoHumor tipoDeHumor) {
        super(isbn, titulo, autor, numeroPaginas, tipo);
        this.tipoDeHumor = tipoDeHumor;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Tipo de humor = " + tipoDeHumor);
    }

    @Override
    public void pedirDatosLibro() {
        super.pedirDatosLibro();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el tipo de humor (absurdo, blanco, satira, parodia o negro)");
        String tipoDeHumorStr = scanner.nextLine();
        tipoDeHumor = TipoHumor.valueOf(tipoDeHumorStr.toLowerCase());
    }

    @Override
    public String toString() {
        return "LibroComedia{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", tipoDeHumor=" + tipoDeHumor +
                '}';
    }

    public LibroComedia generarComedia(){
        pedirDatosLibro();
        LibroComedia libroComedia = new LibroComedia(isbn,titulo,autor,numeroPaginas,tipo,tipoDeHumor);
        return libroComedia;
    }



    public TipoHumor getTipoDeHumor() {
        return tipoDeHumor;
    }

    public void setTipoDeHumor(TipoHumor tipoDeHumor) {
        this.tipoDeHumor = tipoDeHumor;
    }
}
