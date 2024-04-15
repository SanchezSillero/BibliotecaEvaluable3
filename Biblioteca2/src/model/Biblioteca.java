package model;

import exceptions.LibroNoEncontradoException;
import exceptions.SinHuecoEnCatalogoException;

import java.util.*;

public class Biblioteca<T extends Libro> implements Mostrable {
    private String nombre;
    private String director;
    private Catalogo<T> catalogo;
    private Scanner scanner = new Scanner(System.in);
    private static ArrayList<Libro> listaLibros = new ArrayList<>(); //lista de libros compartida por cualquier instancia de Biblioteca (static)

    public Biblioteca() {
    }

    public Biblioteca(String nombre, String director) {
        this.nombre = nombre;
        this.director = director;
    }


    public void mostrarListaLibros() {  //metodo para ver la lista de libros compartida por todas las instancias de biblioteca
        System.out.println();
        System.out.println("Lista de libros registrados:");
        Collections.sort(listaLibros, Comparator.comparingInt(Libro::getIsbn)); //ordenamos el array por isbn
        for (Libro item : listaLibros) {
            item.mostrarDatos();
            System.out.println("------------------------------------");
        }
    }

    public void agregarLibroListaCompartida(Libro libro) {//para añadir libros a la lista compartida
        boolean isbnDuplicado = false;
        for (Libro item : listaLibros) {
            if (libro.getIsbn() == item.getIsbn()) {
                isbnDuplicado = true;
                break;
            }
        }
        if (!isbnDuplicado) {
            listaLibros.add(libro);
            System.out.println("Libro añadido correctamente");
        } else {
            System.out.println("Ya hay un libro con ese ISBN");
        }
    }

    public void construirCatalogo() {
        if (catalogo == null) {
            try {
                System.out.println("Introduce la capacidad que tendrá el catálogo");
                int capacidad = scanner.nextInt();
                this.catalogo = new Catalogo<T>(capacidad);
                System.out.println("Construido catálogo con capacidad para " + capacidad + " libros");
            } catch (Exception e) {
                System.out.println("El dato introducido no es correcto");
            }
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
        System.out.println("\nnombre = " + nombre);
        System.out.println("director = " + director);
        try {
            if (catalogo.listaLibrosCatalogo.isEmpty()) {
                System.out.println("No hay libros para mostrar");
            } else {
                System.out.println("Lista de libros en el catálogo:");
                System.out.println();
                Collections.sort(catalogo.listaLibrosCatalogo, Comparator.comparingInt(Libro::getIsbn));
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
                return true;
            }
        }
        return false;
    }

    public void agregarLibro(T libro) {
        boolean libroExistente = estaLibro(libro);
        if (!libroExistente) {
            listaLibros.add(libro);
            System.out.println("El libro y sus datos han quedado registrados");
        }
        try {
            catalogo.agregarLibro(libro);
        } catch (NullPointerException falloCatalogoNulo) {
            System.out.println("No hay catálogo para añadir libros");
        } catch (SinHuecoEnCatalogoException sinHuecoEnCatalogo) {
            System.out.println(sinHuecoEnCatalogo.getMessage());
        }
        if (libroExistente) {
            System.out.println("Existe un libro con ese ISBN en nuestro registro");
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

    class Catalogo<T extends LibroInterfaz> {
        int capacidad;
        ArrayList<T> listaLibrosCatalogo;

        public Catalogo() {
        }

        public Catalogo(int capacidad) {
            this.capacidad = capacidad;
            listaLibrosCatalogo = new ArrayList<>(capacidad);
        }

        public boolean estaLibroCatalogo(Libro libro) {
            for (T item : listaLibrosCatalogo) {
                if (item.getIsbn() == libro.getIsbn()) {
                    return true;
                }
            }
            return false;
        }

        public void agregarLibro(Libro libro) throws SinHuecoEnCatalogoException {
            if (capacidad > listaLibrosCatalogo.size() && !estaLibroCatalogo(libro)) {
                listaLibrosCatalogo.add((T) libro);
                System.out.println("Libro agregado satisfactoriamente al catálogo");
            } else if(capacidad <= listaLibrosCatalogo.size()) {
                throw new SinHuecoEnCatalogoException("No se podido añadir al catálogo por falta de espacio");
            } else if (estaLibroCatalogo(libro)) {
                System.out.println("El libro con ISBN ya está en el catálogo");
            }
        }


        public void sacarLibro() {
            System.out.println("Introduce el ISBN del libro que desea sacar del catálogo");
            int isbn = scanner.nextInt();
            boolean encontrado = false;
            for (T item : listaLibrosCatalogo) {
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

        public ArrayList<T> getListaLibrosCatalogo() {
            return listaLibrosCatalogo;
        }

        public void setListaLibrosCatalogo(ArrayList<T> listaLibrosCatalogo) {
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

    public static ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public static void setListaLibros(ArrayList<Libro> listaLibros) {
        Biblioteca.listaLibros = listaLibros;
    }

    public Catalogo<T> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo<T> catalogo) {
        this.catalogo = catalogo;
    }
}
