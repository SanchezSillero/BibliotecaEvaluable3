package model;

public class Comedia extends Libro{
    private String tipoDeHumor;

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

    public String getTipoDeHumor() {
        return tipoDeHumor;
    }

    public void setTipoDeHumor(String tipoDeHumor) {
        this.tipoDeHumor = tipoDeHumor;
    }
}
