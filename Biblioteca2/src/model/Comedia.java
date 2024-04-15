package model;

import java.util.Scanner;

public class Comedia extends Libro {
    private TipoHumor tipoDeHumor;
    private Scanner scanner = new Scanner(System.in);

    public Comedia() {
    }

    public Comedia(int isbn, String titulo, String autor, int numeroPaginas, TipoHumor tipoDeHumor) {
        super(isbn, titulo, autor, numeroPaginas);
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
        System.out.println("Introduce el tipo de humor (absurdo, blanco, satira, parodia o negro)");
        String tipoDeHumorStr = scanner.nextLine();
        tipoDeHumor = TipoHumor.valueOf(tipoDeHumorStr.toLowerCase());
    }

    public  Comedia generarComedia(){
        pedirDatosLibro();
        Comedia comedia = new Comedia(isbn,titulo,autor,numeroPaginas,tipoDeHumor);
        return comedia;
    }

    public TipoHumor getTipoDeHumor() {
        return tipoDeHumor;
    }

    public void setTipoDeHumor(TipoHumor tipoDeHumor) {
        this.tipoDeHumor = tipoDeHumor;
    }
}
