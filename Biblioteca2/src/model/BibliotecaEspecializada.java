package model;

import exceptions.SinHuecoEnCatalogoException;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaEspecializada extends Biblioteca{
    Tematica tematica;


    public BibliotecaEspecializada() {
    }

    @Override
    public void agregarLibroAlCatalogo() throws SinHuecoEnCatalogoException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el ISBN del libro");
        int isbn = scanner.nextInt();
        ArrayList<Libro> listaLibros = getListaLibros();
        boolean coincideTematica = false;
        boolean coincideIsbn = false;

        for (Libro item : listaLibros) {
            if (item.getIsbn() == isbn) {
                coincideIsbn = true;
                if (item instanceof LibroTerror && tematica.equals(Tematica.terror)) {
                    super.agregarLibroCargado(item);
                    System.out.println("Libro agregado satisfactoriamente");
                    coincideTematica=true;
                    break;
                }
                if (item.getIsbn() == isbn && item instanceof Ensayo && tematica.equals(Tematica.ensayo)) {
                    super.agregarLibroCargado(item);
                    System.out.println("Libro agregado satisfactoriamente");
                    coincideTematica=true;
                    break;
                }
                if (item.getIsbn() == isbn && item instanceof LibroComedia && tematica.equals(Tematica.comedia)) {
                    super.agregarLibroCargado(item);
                    System.out.println("Libro agregado satisfactoriamente");
                    coincideTematica=true;
                    break;
                }
                if (item.getIsbn() == isbn && item instanceof LibroPoliciaca && tematica.equals(Tematica.policiaca)) {
                    super.agregarLibroCargado(item);
                    System.out.println("Libro agregado satisfactoriamente");
                    coincideTematica=true;
                    break;
                }
            }
        }
        if (!coincideTematica && coincideIsbn){
            System.out.println("El libro con ISBN "+isbn+ " no corresponde con la temática de esta biblioteca");
        }
        if (!coincideIsbn){
            System.out.println("No tenemos datos de ningún libro con ese ISBN, proceda a registrarlos:");
            super.agregarLibroAlCatalogo();
        }

    }

    public BibliotecaEspecializada(String nombre, String director, Tematica tematica) {
        super(nombre, director);
        this.tematica = tematica;
    }

    public Tematica getTematica() {
        return tematica;
    }

    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }
}
