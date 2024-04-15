import controller.Aplicacion;
import exceptions.SinHuecoEnCatalogoException;
import model.*;

import java.util.ArrayList;

public class Entrada {
    public static void main(String[] args) {
        //1. CREAMOS ALGUNAS INSTANCIAS DE BIBLIOTECAS
        Biblioteca<Libro> bibliotecaGenerica = new Biblioteca<>("Biblioteca Municipal", "Francisco Sánchez"); //Acepta cualquier tipo de libro
        Biblioteca<Ensayo> bibliotecaEspEnsayos = new Biblioteca<>("Biblioteca Universidad Politécnica", "Patricia Sillero");//solo aceptara ENSAYOS
        Biblioteca<Terror> bibliotecaEspTerror = new Biblioteca<>("Biblioteca Halloween", "María José Ruiz");//solo aceptara libros de TERROR

        //creamos algunos libros (no están en ningun catalogo)
        Terror libroTerror1 = new Terror(1, "Frankenstein", "Mary Shelley", 168, 14);
        Comedia libroComedia1 = new Comedia(2, "La vida secreta de Walter Mitty", "James Thurber", 160, TipoHumor.parodia);
        Ensayo ensayo1 = new Ensayo(3, "Los orígenes de la creatividad humana", "Edward O.Wilson", 256, "Evolución Humana");
        ArrayList<String> listaPersonajesLibroPoliciaca1 = new ArrayList<>();
        listaPersonajesLibroPoliciaca1.add("Auguste Dupin");
        listaPersonajesLibroPoliciaca1.add("Narrador");
        listaPersonajesLibroPoliciaca1.add("Madame L'Espanaye");
        Policiaca libroPoliciaca1 = new Policiaca(4, "Los crímenes de la calle Morgue", "Edgar Allan Poe", 66, Trama.intriga, listaPersonajesLibroPoliciaca1);
        Ensayo ensayo2 = new Ensayo(5, "El arte de la guerra", "Sun Tzu", 112, "Estrategia");

        //añadimos estos libros a la lista (estatica) que comparten todas las bibliotecas(Fuera de sus respectivos catálogos)(se puede hacer desde cualquier instancia de biblioteca)
        bibliotecaGenerica.agregarLibroListaCompartida(libroTerror1);
        bibliotecaEspTerror.agregarLibroListaCompartida(libroComedia1);//vemos que aqui no hay problemas por agregar un libro que no es de su tematica
        bibliotecaGenerica.agregarLibroListaCompartida(libroTerror1);//comprobamos que no nos deja añadir libros con el mismo ISBN
        bibliotecaGenerica.agregarLibroListaCompartida(libroPoliciaca1);
        bibliotecaGenerica.agregarLibroListaCompartida(ensayo1);
        bibliotecaGenerica.agregarLibroListaCompartida(ensayo2);
        bibliotecaGenerica.mostrarListaLibros();//mostramos la lista de libros compartida por las bibliotecas*/

        //2. CREAMOS CATALOGO DE 4 LIBROS




        //3. AGREGAMOS 5 LIBROS AL CATALOGO
        /*bibliotecaGenerica.agregarLibro(libroComedia1);
        bibliotecaGenerica.agregarLibro(libroPoliciaca1);
        bibliotecaGenerica.agregarLibro(libroTerror1);
        bibliotecaGenerica.agregarLibro(ensayo1);
        bibliotecaGenerica.agregarLibro(ensayo2);// vemos que no hay espacio para este libro*/

        //4. MOSTRAMOS INFORMACION DE LOS LIBROS
        //bibliotecaGenerica.mostrarDatos();

        //5. EXPORTAMOS LOS LIBROS DEL CATALOGO A UN FICHERO

        //CREAMOS UNA INSTANCIA DE LA APLICACION
        Aplicacion aplicacion = new Aplicacion();
        aplicacion.menu(bibliotecaGenerica, bibliotecaEspEnsayos, bibliotecaEspTerror);//podemos meter tantas bibliotecas como tengamos instanciadas
    }
}
