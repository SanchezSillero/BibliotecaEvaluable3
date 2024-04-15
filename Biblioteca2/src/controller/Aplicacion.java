package controller;

import exceptions.LibroNoEncontradoException;
import model.*;

import java.util.Scanner;

public class Aplicacion<T extends Libro> {
    private Scanner scanner = new Scanner(System.in);
    private Biblioteca<T> biblioteca;

    public Aplicacion() {
    }

    public Aplicacion(Biblioteca<T> biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void menu(Biblioteca<T>... bibliotecas) { //los ... indica que el parametro es un array variable
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
                aplicaciones[opcion - 1].menuSub(bibliotecas[opcion - 1]); //accedemos al metodo menuSub dela aplicacion correspondiente a la biblioteca seleccionada
            } else if (opcion == bibliotecas.length + 1) { //verificamos si la opcion es la del apendice salir del menu
                System.out.println("¡HASTA PRONTO!");
            } else {
                System.out.println("Opción no válida");
            }
        } while (opcion != bibliotecas.length + 1);
    }

    public void menuSub(Biblioteca<T> biblioteca) {
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
                    pulseEnter();
                    break;
                }
                case 4: {//agregar libros al catalogo
                    /*System.out.println("Introduce el ISBN del libro que deseas agregar:");
                    int isbn = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    // Buscar el libro en la lista compartida
                    Libro libroExistente = null;
                    for (Libro libro : Biblioteca.getListaLibros()) {
                        if (libro.getIsbn() == isbn) {
                            libroExistente = (T)libro;
                            break;
                        }
                    }
                    // Si el libro existe, agrégalo al catálogo de la biblioteca
                    if (libroExistente != null) {
                        biblioteca.agregarLibro((T) libroExistente);

                    } else {
                        System.out.println("No se encontró ningún libro con el ISBN proporcionado. Proceda a registrarlo");

                        System.out.println("Seleccione el tipo de libro:\n\t1. Terror\n\t2. Comedia\n\t3. Ensayo\n\t4. Policiaca");
                        int opcionTipoLibro = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea
                        T nuevoLibro;
                        switch (opcionTipoLibro) {
                            case 1:
                                nuevoLibro = new Terror();
                                break;
                            case 2:
                                nuevoLibro = new Comedia();
                                break;
                            case 3:
                                nuevoLibro = new Ensayo();
                                break;
                            case 4:
                                nuevoLibro = new Policiaca();
                                break;
                            default:
                                System.out.println("Opción no válida");
                                pulseEnter();
                                return; // Salir del case 4
                        }
                        nuevoLibro.pedirDatosLibro(); // Solicitar al usuario los datos del nuevo libro
                        biblioteca.agregarLibro((T) nuevoLibro);// Agregar el nuevo libro al catálogo de la biblioteca
                    }*/
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

                    pulseEnter();
                    break;
                }
                case 8: {
                    System.out.println("Volviendo al menú Bibliotecas");
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
}
