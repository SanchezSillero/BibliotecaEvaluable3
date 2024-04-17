package controller;

import exceptions.LibroNoEncontradoException;
import exceptions.SinHuecoEnCatalogoException;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion {
    private transient Scanner scanner = new Scanner(System.in);
    private Biblioteca biblioteca;

    public Aplicacion() {
    }

    public Aplicacion(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    OperacionesFicheros operacionesCatalogo = new OperacionesFicheros();


    public void menu(Biblioteca... bibliotecas) { //los ... indica que el parametro es un array variable
        System.out.println("\t\t------BIENVENIDO AL GESTOR DE BIBLIOTECAS------");
        pulseEnter();
        // scanner.nextLine();

        int opcion;
        Aplicacion[] aplicaciones = new Aplicacion[bibliotecas.length]; //creamos un array de aplicaciones, uno para cada objeto Biblioteca
        for (int i = 0; i < bibliotecas.length; i++) {
            aplicaciones[i] = new Aplicacion(bibliotecas[i]);
        }
        do {
            System.out.println("¿Qué biblioteca desea gestionar?");
            for (int i = 0; i < bibliotecas.length; i++) {  //itteramos para mostrar en pantalla un indice con las bibliotecas que tenemos
                System.out.println("\t" + (i + 1) + ". " + bibliotecas[i].getNombre());
            }
            System.out.println("\t" + (bibliotecas.length + 1) + ". Salir");

            opcion = scanner.nextInt();
            if (opcion >= 1 && opcion <= bibliotecas.length) {//validamos si la opcion esta dentro del rango de bibliotecas
                System.out.println("\t-----" + bibliotecas[opcion - 1].getNombre() + "-----");
                cargarLibrosListaEstatica(bibliotecas[opcion - 1]);//cargamos la lista de libros compartida por todas las bibliotecas
                cargarCatalogo(bibliotecas[opcion - 1]);//cargamos el catalogo de la biblioteca selecc
                aplicaciones[opcion - 1].menuSub(bibliotecas[opcion - 1]); //accedemos al metodo menuSub dela aplicacion correspondiente a la biblioteca seleccionada
            } else if (opcion == bibliotecas.length + 1) { //verificamos si la opcion es la del apendice salir del menu
                System.out.println("¡HASTA PRONTO!");
            } else {
                System.out.println("Opción no válida");
            }
        } while (opcion != bibliotecas.length + 1);
    }

    public void menuSub(Biblioteca biblioteca) {
        int opcionSub;

        do {
            System.out.println("\t1. Buscar información sobre un libro\n\t2. Construir un catálogo\n\t3. Consultar " +
                    "catálogo\n\t4. Agregar libro al catálogo\n\t5. Sacar libro del catálogo\n\t6. Borrar catálogo\n\t7. Expotar el catálogo a un fichero\n\t8. Salir");

            opcionSub = scanner.nextInt();
            switch (opcionSub) {
                case 1: { // Buscar información sobre un libro aunque no este en el catalogo (lo busca en la lista statica que comparten todas las bibliotecas)
                    try {
                        biblioteca.buscarPorIsbn();
                    } catch (LibroNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    pulseEnter();
                    break;
                }
                case 2: { //Construir un catálogo de n libros
                    biblioteca.construirCatalogo();
                    pulseEnter();
                    break;
                }
                case 3: { //COnsultamos todos los libros del catalogo, el de la biblioteca
                    biblioteca.mostrarDatos();
                    scanner.nextLine();
                    pulseEnter();
                    break;
                }
                case 4: {//agregar libros al catalogo
                    try {
                        biblioteca.agregarLibroAlCatalogo();
                    } catch (NullPointerException falloCatalogoNulo) {
                        System.out.println("No hay catálogo para añadir libros");
                    } catch (SinHuecoEnCatalogoException e) {
                        System.out.println(e.getMessage());
                    }
                    pulseEnter();
                    break;
                }
                case 5: {
                    biblioteca.sacarLibro();
                    pulseEnter();
                    break;
                }
                case 6: {
                    biblioteca.borrarCatalogo();
                    pulseEnter();
                    break;
                }
                case 7: {
                    String nombreArchivo = biblioteca.getNombreArchivoCatalogo();
                    ArrayList<Libro> libros = biblioteca.getListaLibrosCatalogo();
                    operacionesCatalogo.escrituraLibro(nombreArchivo, libros);
                    System.out.println("Catálogo guardado en el archivo "+nombreArchivo);
                    pulseEnter();
                    break;
                }
                case 8: {
                    System.out.println("Volviendo al menú Bibliotecas");
                    guardarLibrosListaEstatica();
                    break;
                }
                default: {
                    System.out.println("Opción no válida");
                }
            }

        } while (opcionSub != 8);
    }

    public void pulseEnter() {
        System.out.println("\n\t\t\t    Pulse Enter para continuar");
        scanner.nextLine();
    }

    public void  cargarCatalogo(Biblioteca biblioteca){
        String nombreArchivo = biblioteca.getNombreArchivoCatalogo();
        ArrayList<Libro> libros = operacionesCatalogo.lecturaLibro(nombreArchivo);
        int capacidad = libros.size();
        biblioteca.construirCatalogoCarga(capacidad);
        for (Libro item : libros) {
            try {
                biblioteca.agregarLibroCargado(item);
            } catch (SinHuecoEnCatalogoException e) {
                System.out.println(e.getMessage());;
            }
        }
    }
    public void cargarLibrosListaEstatica(Biblioteca biblioteca){
        ArrayList<Libro> libros = operacionesCatalogo.lecturaLibro("ListaEstatica.obj");
        for (Libro item : libros) {
            biblioteca.agregarLibroListaCompartida(item);
        }
    }
    public void guardarLibrosListaEstatica(){
       ArrayList<Libro> libros = biblioteca.getListaLibros();
       operacionesCatalogo.escrituraLibro("ListaEstatica.obj", libros);
    }
}
