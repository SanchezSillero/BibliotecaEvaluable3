package model;

import exceptions.LibroNoEncontradoException;
import exceptions.SinHuecoEnCatalogoException;

import java.io.Serializable;
import java.util.*;

public abstract class Biblioteca implements Serializable {
    private static final long serialVersionUID = 18575678987654321L;

    private String nombre;
    private String director;
    private Catalogo catalogo;
    private transient Scanner scanner = new Scanner(System.in);
    private static ArrayList<Libro> listaLibros = new ArrayList<>(); //lista de libros compartida por cualquier instancia de Biblioteca (static)
    private String nombreArchivoCatalogo;

    public Biblioteca() {
    }

    public Biblioteca(String nombre, String director) {
        this.nombre = nombre;
        this.director = director;
    }


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

    public void mostrarListaLibros() {  //metodo para ver la lista de libros compartida por todas las instancias de biblioteca
        System.out.println();
        System.out.println("Lista de libros registrados:");
        Collections.sort(listaLibros, Comparator.comparingInt(Libro::getIsbn)); //ordenamos el array por isbn
        for (Libro item : listaLibros) {
            item.mostrarDatos();
            System.out.println("------------------------------------");
        }
    }

    public void construirCatalogo() {
        if (catalogo == null) {
            try {
                System.out.println("Introduce la capacidad que tendrá el catálogo");
                int capacidad = scanner.nextInt();
                this.catalogo = new Catalogo(capacidad);
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
            System.out.println("Libro añadido correctamente A LA LISTA ESTATICA");
        } else {
            System.out.println("Ya hay un libro con ese ISBN EN LA LISTA ESTATICA, este no se agregará");
        }
    }

    public Libro generarLibro() throws IllegalArgumentException {
        System.out.println("¿Qué tipo de libro va a agregar?\n\t1. LibroTerror\n\t2. Ensayo\n\t3. LibroComedia\n\t4. LibroPoliciaca");
        int tipoLibro = scanner.nextInt();
        switch (tipoLibro) {
            case 1: {
                LibroTerror libroAgregar = new LibroTerror();
                libroAgregar.generarTerror();
                return libroAgregar;
            }
            case 2: {
                Ensayo libroAgregar = new Ensayo();
                libroAgregar.generarEnsayo();
                return libroAgregar;
            }
            case 3: {
                LibroComedia libroAgregar = new LibroComedia();
                libroAgregar.generarComedia();
                return libroAgregar;
            }
            case 4: {
                LibroPoliciaca libroAgregar = new LibroPoliciaca();
                libroAgregar.generarPoliciaca();
                return libroAgregar;
            }
            default:
                throw new IllegalArgumentException("Opción no válida");
        }
    }

    public void agregarLibroAlCatalogo() throws SinHuecoEnCatalogoException {
        Libro libro = generarLibro();
        agregarLibroListaCompartida(libro);
        catalogo.agregarLibro(libro);
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

    public ArrayList<Libro> getListaLibrosCatalogo(){
        return catalogo.listaLibrosCatalogo;
    }



    class Catalogo implements Serializable{
        private static final long serialVersionUID = 92345678987654321L;

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
                    return true;
                }
            }
            return false;
        }

        public void agregarLibro(Libro libro) throws SinHuecoEnCatalogoException {
            if (capacidad > listaLibrosCatalogo.size() && !estaLibroCatalogo(libro)) {
                listaLibrosCatalogo.add(libro);
                System.out.println("Libro agregado satisfactoriamente al catálogo");
            } else if (capacidad <= listaLibrosCatalogo.size()) {
                throw new SinHuecoEnCatalogoException("No se podido añadir al catálogo por falta de espacio");
            } else if (estaLibroCatalogo(libro)) {
                System.out.println("El libro con ISBN ya está en el catálogo");
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

    public static ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public static void setListaLibros(ArrayList<Libro> listaLibros) {
        Biblioteca.listaLibros = listaLibros;
    }

    public String getNombreArchivoCatalogo() {
        return nombreArchivoCatalogo;
    }
    public void setNombreArchivoCatalogo(String nombreArchivoCatalogo){
        this.nombreArchivoCatalogo = nombreArchivoCatalogo;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }
}
