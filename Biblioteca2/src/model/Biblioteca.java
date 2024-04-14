package model;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Biblioteca implements Mostrable{
    private String nombre;
    private String director;
    private Catalogo catalogo;
    private Scanner scanner = new Scanner(System.in);
    private static ArrayList<Libro>  listaLibros = new ArrayList<>(); //lista de libros compartida por cualquier instancia de Biblioteca (static)

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
        if (catalogo.listaLibrosCatalogo.isEmpty()) {
            System.out.println("No hay libros para mostrar");
        } else {
            System.out.println("Lista de libros");
            for (Libro libro : catalogo.listaLibrosCatalogo) {
                libro.mostrarDatos();
                System.out.println("--------------------------------");
            }
        }
    }

    public boolean estaLibro(Libro libro) {
        for (Libro item : listaLibros) {
            if (item.getIsbn() == libro.getIsbn()) {
                //System.out.println("Ya existe un libro con ese ISBN");
                return true;
            }
        }
        return false;
    }

    public void agregarLibro(Libro libro) {
        if (!estaLibro(libro)) {
            listaLibros.add(libro);
        }
        catalogo.agregarLibro(libro);
    }

    public void sacarLibro() {
        catalogo.sacarLibro();
    }

    public void buscarPorIsbn (){
        System.out.println("Introduce el ISBN del libro que desea buscar");
        int isbnBuscar = scanner.nextInt();
        for (Libro item : listaLibros) {
            if (isbnBuscar== item.getIsbn()){
                item.mostrarDatos();
            }
        }
    }

    class Catalogo {
        int capacidad;
        ArrayList<Libro> listaLibrosCatalogo;

        public Catalogo() {
        }

        public Catalogo(int capacidad) {
            this.capacidad = capacidad;
            listaLibrosCatalogo = new ArrayList<>(capacidad);
        }

        public boolean estaLibroCatalogo(Libro libro) {
            for (Libro item : listaLibrosCatalogo) {
                if (item.getIsbn() == libro.getIsbn()) {
                    System.out.println("Ya existe un libro con ese ISBN en el catálogo");
                    return true;
                }
            }
            return false;
        }

        public void agregarLibro(Libro libro) {
            if (capacidad > listaLibrosCatalogo.size() && !estaLibroCatalogo(libro)) {
                listaLibrosCatalogo.add(libro);
                System.out.println("Libro agregado satisfactoriamente");
            } else {
                if (capacidad <= listaLibrosCatalogo.size()) {
                    System.out.println("No hay espacio para más libros");
                }
            }
        }

        public void sacarLibro() {
            System.out.println("Introduce el ISBN del libro que desea sacar del catálogo");
            int isbn = scanner.nextInt();
            boolean encontrado = false;
            for (Libro item : listaLibrosCatalogo) {
                if (item.getIsbn() == isbn) {
                    listaLibrosCatalogo.remove(item);
                    System.out.println("Libro sacado del catálogo satisfactoriamente");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No se ha encontrado ningún libro con ese ISBN en el catálogo");
            }
        }

        public int getCapacidad() {
            return capacidad;
        }

        public void setCapacidad(int capacidad) {
            this.capacidad = capacidad;
        }

        public ArrayList<Libro> getListaLibrosCatalogo() {
            return listaLibrosCatalogo;
        }

        public void setListaLibrosCatalogo(ArrayList<Libro> listaLibrosCatalogo) {
            this.listaLibrosCatalogo = listaLibrosCatalogo;
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
