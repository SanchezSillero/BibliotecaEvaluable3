package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Policiaca extends Libro {
    Trama trama;
    ArrayList<String> listaPersonajes;

    public Policiaca() {
    }

    public Policiaca(int isbn, String titulo, String autor, int numeroPaginas, Trama trama, ArrayList<String> listaPersonajes) {
        super(isbn, titulo, autor, numeroPaginas);
        this.trama = trama;
        this.listaPersonajes = listaPersonajes;
    }



    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("trama = " + trama);
        System.out.println("Lista persobajes: ");
        for (String personaje : listaPersonajes) {
            System.out.println(personaje);
        }
    }

    @Override
    public void pedirDatosLibro() {
        super.pedirDatosLibro();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la trama (misterio/intriga)");
        String tramaStr = scanner.nextLine();
        trama = Trama.valueOf(tramaStr.toLowerCase());
        listaPersonajes = pedirPersonajes();
    }

    public ArrayList<String> pedirPersonajes() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listaPersonajes = new ArrayList<>();
        System.out.println("Introduce los nombres de los personajes (presiona Enter después de cada nombre, escribe 'fin' para terminar):");
        String nombrePersonaje;
        do {
            nombrePersonaje = scanner.nextLine();
            if (!nombrePersonaje.equals("fin")) {
                listaPersonajes.add(new String(nombrePersonaje));
            }
        } while (!nombrePersonaje.equals("fin"));
        return listaPersonajes;
    }

    public Policiaca generarPoliciaca(){
        pedirDatosLibro();
        pedirPersonajes();
        Policiaca policiaca = new Policiaca(isbn, titulo, autor, numeroPaginas, trama, listaPersonajes);
        return policiaca;
    }

    @Override
    public String toString() {
        return "Policiaca{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", trama=" + trama +
                ", listaPersonajes=" + listaPersonajes +
                '}';
    }

    public Trama getTrama() {
        return trama;
    }

    public void setTrama(Trama trama) {
        this.trama = trama;
    }

    public ArrayList<String> getListaPersonajes() {
        return listaPersonajes;
    }

    public void setListaPersonajes(ArrayList<String> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }
}
