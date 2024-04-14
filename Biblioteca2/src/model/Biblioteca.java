package model;

import exceptions.LibroNoEncontradoException;
import exceptions.SinHuecoEnCatalogoException;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Biblioteca implements Mostrable {
    private String nombre;
    private String director;
    private Catalogo catalogo;
    private Scanner scanner = new Scanner(System.in);
    private static ArrayList<Libro> listaLibros = new ArrayList<>(); //lista de libros compartida por cualquier instancia de Biblioteca (static)

    public Biblioteca() {
    }

    public Biblioteca(String nombre, String director) {
        this.nombre = nombre;
        this.director = director;
    }


    public void mostrarListaLibros() {  //metodo para ver la lista de libros compartida por todas las instancias de biblioteca
        for (Libro item : listaLibros) {
            item.mostrarDatos();
            System.out.println("------------------------------------");
        }
    }

    public void construirCatalogo(int capacidad) {
        if (catalogo == null) {
            this.catalogo = new Catalogo(capacidad);
            System.out.println("Construido catálogo con capacidad para " + capacidad + " libros");
        } else {
            System.out.println("Ya existe un catálogo en la biblioteca");
        }
    }

    public void borrarCatalogo() {
        if (catalogo != null) {
            catalogo = null;
            System.out.println("Catálogo eliminado correctamente");
        } else {
            System.out.println("No existe ningún catálogo que borrar");
        }
    }


    @Override
    public void mostrarDatos() {
        System.out.println("nombre = " + nombre);
        System.out.println("director = " + director);
        try {
            if (catalogo.listaLibrosCatalogo.isEmpty()) {
                System.out.println("No hay libros para mostrar");
            } else {
                System.out.println("Lista de libros en el catálogo");
                for (Libro libro : catalogo.listaLibrosCatalogo) {
                    libro.mostrarDatos();
                    System.out.println("--------------------------------");
                }
            }
        } catch (NullPointerException falloCatalogoNulo) {
            System.out.println("No existe ningún catálogo sobre el que mostrar datos");
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
            try {
                catalogo.agregarLibro(libro);
            } catch (NullPointerException falloCatalogoNulo) {
                System.out.println("No hay catálogo para añadir libros");
            } catch (SinHuecoEnCatalogoException sinHuecoEnCatalogo) {
                System.out.println(sinHuecoEnCatalogo.getMessage());
            }
        } else {
            System.out.println("Ya existe un libro con ese ISBN");
        }
    }

    public void sacarLibro() {
        try {
            catalogo.sacarLibro();
        } catch (NullPointerException falloCatalogoNulo) {
            System.out.println("No existe ningún catálogo sobre el que sacar un libro");
        }
    }

    public void buscarPorIsbn() throws LibroNoEncontradoException {
        System.out.println("Introduce el ISBN del libro que desea buscar");
        int isbnBuscar = scanner.nextInt();
        boolean encontrado = false;
        for (Libro item : listaLibros) {
            if (isbnBuscar == item.getIsbn()) {
                item.mostrarDatos();
                encontrado = true;
            }
        }
        if (!encontrado) {
            throw new LibroNoEncontradoException("No existe un libro con el ISBN " + isbnBuscar + " en nuestra aplicación");
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

        public void agregarLibro(Libro libro) throws SinHuecoEnCatalogoException {
            if (capacidad > listaLibrosCatalogo.size() && !estaLibroCatalogo(libro)) {
                listaLibrosCatalogo.add(libro);
                System.out.println("Libro agregado satisfactoriamente");
            } else {
                if (capacidad <= listaLibrosCatalogo.size()) {
                    throw new SinHuecoEnCatalogoException("No hay espacio para más libros en el catálogo");
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
