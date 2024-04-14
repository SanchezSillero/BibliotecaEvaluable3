package controller;

import exceptions.LibroNoEncontradoException;
import model.Biblioteca;

import java.util.Scanner;

public class Aplicacion {
    private Scanner scanner = new Scanner(System.in);
    private Biblioteca biblioteca;

    public Aplicacion() {
    }

    public Aplicacion(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void menu(Biblioteca... bibliotecas) { //los ... indica que el parametro es un array variable
        System.out.println("\t\t------BIENVENIDO AL GESTOR DE BIBLIOTECAS------");
        System.out.println("\n\n\t\t    Pulse Enter para continuar");
        scanner.nextLine();

        int opcion;
        Aplicacion[] aplicacions = new Aplicacion[bibliotecas.length]; //creamos un array de gestores, uno para cada objeto Biblioteca
        for (int i = 0; i < bibliotecas.length; i++) {
            aplicacions[i] = new Aplicacion(bibliotecas[i]);
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
                aplicacions[opcion - 1].menuSub(bibliotecas[opcion - 1]); //accedemos al metodo menuSub del gestor correspondiente a la biblioteca seleccionada
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
                case 1: { // Buscar información sobre un libro aunque no este en el catalogo (lo busca en la libreria externa)
                    try {
                        biblioteca.buscarPorIsbn();
                    }catch (LibroNoEncontradoException e){
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
                case 4: {
                    biblioteca.agregarLibro();
                    break;
                }
                case 5: {
                    biblioteca.sacarLibro();
                    break;
                }
                case 6: {
                    biblioteca.borrarCatalogo();
                    pulseEnter();
                    break;
                }
                case 7: {

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
        System.out.println("\n\n\t\t\t    Pulse Enter para continuar");
        scanner.nextLine();
    }
}
