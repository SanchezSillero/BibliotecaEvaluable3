package model;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Biblioteca implements Mostrable {
    private String nombre;
    private String director;
    private Catalogo catalogo;
    private Scanner scanner = new Scanner(System.in);

    public Biblioteca() {
    }

    public Biblioteca(String nombre, String director) {
        this.nombre = nombre;
        this.director = director;
    }

    public void construirCatalogo(int capacidad) {
        this.catalogo = new Catalogo(capacidad);
        System.out.println("Construido catálogo con capacidad para " + capacidad + " libros");
    }

    @Override
    public void mostrarDatos() {
        if (catalogo.listaLibros.isEmpty()) {
            System.out.println("No hay libros para mostrar");
        } else {
            System.out.println("Lista de libros");
            for (Libro libro : catalogo.listaLibros) {
                libro.mostrarDatos();
                System.out.println("--------------------------------");
            }
        }
    }

    public void agregarLibro(Libro libro) {
        catalogo.agregarLibro(libro);
    }
    public void sacarLibro(){
        catalogo.sacarLibro();
    }

    class Catalogo {
        int capacidad;
        ArrayList<Libro> listaLibros;

        public Catalogo() {
        }

        public Catalogo(int capacidad) {
            this.capacidad = capacidad;
            listaLibros = new ArrayList<>(capacidad);
        }

        public void agregarLibro(Libro libro) {
            if (capacidad > listaLibros.size() && !estaLibro(libro)) {
                listaLibros.add(libro);
                System.out.println("Libro agregado satisfactoriamente");
            }else {
                if (capacidad <= listaLibros.size()){
                    System.out.println("No hay espacio para más libros");
                }
            }
        }

        public void sacarLibro() {
            System.out.println("Introduce el ISBN del libro que desea sacar del catálogo");
            int isbn = scanner.nextInt();
            boolean encontrado = false;
            for (Libro item : listaLibros) {
                if (item.getIsbn() == isbn){
                    listaLibros.remove(item);
                    System.out.println("Libro sacado del catálogo satisfactoriamente");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado){
                System.out.println("No se ha encontrado ningún libro con ese ISBN en el catálogo");
            }
        }

        public boolean estaLibro(Libro libro) {
            for (Libro item : listaLibros) {
                if (item.getIsbn() == libro.getIsbn()) {
                    System.out.println("Ya existe un libro con ese ISBN en el catálogo");
                    return true;
                }
            }
            return false;
        }

        public int getCapacidad() {
            return capacidad;
        }

        public void setCapacidad(int capacidad) {
            this.capacidad = capacidad;
        }

        public ArrayList<Libro> getListaLibros() {
            return listaLibros;
        }

        public void setListaLibros(ArrayList<Libro> listaLibros) {
            this.listaLibros = listaLibros;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

}
