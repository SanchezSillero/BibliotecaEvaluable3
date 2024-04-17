import controller.Aplicacion;
import controller.OperacionesFicheros;
import exceptions.SinHuecoEnCatalogoException;
import model.*;

import java.util.ArrayList;

public class Entrada {
    public static void main(String[] args) {
        //1. CREAMOS ALGUNAS INSTANCIAS DE BIBLIOTECAS Y DAMOS NOMBRE AL ARCHIVO DE SU CATALAGO
        BibliotecaGeneral bibliotecaGenerica = new BibliotecaGeneral("Biblioteca Municipal", "Francisco Sánchez"); //Acepta cualquier tipo de libro
        bibliotecaGenerica.setNombreArchivoCatalogo("bibliotecaGenerica.obj");
        BibliotecaEspecializada bibliotecaEspEnsayos = new BibliotecaEspecializada("Biblioteca Universidad Politécnica", "Patricia Sillero", Tematica.ensayo);//solo aceptara ENSAYOS
        bibliotecaEspEnsayos.setNombreArchivoCatalogo("bibliotecaEspEnsayos");
        Biblioteca bibliotecaEspTerror = new BibliotecaEspecializada("Biblioteca Halloween", "María José Ruiz", Tematica.terror);//solo aceptara libros de TERROR
        bibliotecaEspTerror.setNombreArchivoCatalogo("bibliotecaEspTerror");

        //creamos algunos libros (no están en ningun catalogo)
        LibroTerror libroTerror1 = new LibroTerror(1, "Frankenstein", "Mary Shelley", 168, 14);
        LibroComedia libroComedia1 = new LibroComedia(2, "La vida secreta de Walter Mitty", "James Thurber", 160, TipoHumor.parodia);
        Ensayo ensayo1 = new Ensayo(3, "Los orígenes de la creatividad humana", "Edward O.Wilson", 256, "Evolución Humana");
        ArrayList<String> listaPersonajesLibroPoliciaca1 = new ArrayList<>();
        listaPersonajesLibroPoliciaca1.add("Auguste Dupin");
        listaPersonajesLibroPoliciaca1.add("Narrador");
        listaPersonajesLibroPoliciaca1.add("Madame L'Espanaye");
        LibroPoliciaca libroPoliciaca1 = new LibroPoliciaca(4, "Los crímenes de la calle Morgue", "Edgar Allan Poe", 66, Trama.intriga, listaPersonajesLibroPoliciaca1);
        Ensayo ensayo2 = new Ensayo(5, "El arte de la guerra", "Sun Tzu", 112, "Estrategia");

        //añadimos estos libros a la lista (estatica) que comparten todas las bibliotecas(Fuera de sus respectivos catálogos)(se puede hacer desde cualquier instancia de biblioteca)
        bibliotecaGenerica.agregarLibroListaCompartida(libroTerror1);
        bibliotecaEspTerror.agregarLibroListaCompartida(libroComedia1);//vemos que aqui no hay problemas por agregar un libro que no es de su tematica
        bibliotecaGenerica.agregarLibroListaCompartida(libroTerror1);//comprobamos que no nos deja añadir libros con el mismo ISBN
        bibliotecaGenerica.agregarLibroListaCompartida(libroPoliciaca1);
        bibliotecaGenerica.agregarLibroListaCompartida(ensayo1);
        bibliotecaGenerica.agregarLibroListaCompartida(ensayo2);
        // bibliotecaGenerica.mostrarListaLibros();//mostramos la lista de libros compartida por las bibliotecas
/*

        //2. CREAMOS CATALOGO DE 4 LIBROS
        bibliotecaGenerica.construirCatalogoCarga(4);


        //3. AGREGAMOS 5 LIBROS AL CATALOGO
        try {
            bibliotecaGenerica.agregarLibroCargado(libroComedia1);
            bibliotecaGenerica.agregarLibroCargado(libroPoliciaca1);
            bibliotecaGenerica.agregarLibroCargado(libroTerror1);
            bibliotecaGenerica.agregarLibroCargado(ensayo1);
            bibliotecaGenerica.agregarLibroCargado(ensayo2);// vemos que no hay espacio para este libro
        } catch (SinHuecoEnCatalogoException e) {
            System.out.println(e.getMessage());
        }

        //4. MOSTRAMOS INFORMACION DE LOS LIBROS
            bibliotecaGenerica.mostrarDatos();

        //5. EXPORTAMOS LOS LIBROS DEL CATALOGO A UN FICHERO
        OperacionesFicheros operacionesFicheros = new OperacionesFicheros();
        String nombreArchivo = bibliotecaGenerica.getNombreArchivoCatalogo();
        ArrayList<Libro> libros = bibliotecaGenerica.getListaLibrosCatalogo();
        operacionesFicheros.escrituraLibro(nombreArchivo, libros);

        /*Hasta aquí el método main desarrolla los puntos que requiere el ejercicio, pero se
          ha desarrollado un aplicacion para gestionar estas cuestiones en cualquier instancia de Biblioteca,
          así como mantener su datos mediante ficheros

*/
        //CREAMOS UNA INSTANCIA DE LA APLICACION
        Aplicacion aplicacion = new Aplicacion();
        aplicacion.menu(bibliotecaGenerica, bibliotecaEspEnsayos, bibliotecaEspTerror);//podemos meter tantas bibliotecas como tengamos instanciadas
    }
}
