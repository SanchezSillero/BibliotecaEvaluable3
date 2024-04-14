import model.*;

import java.util.ArrayList;

public class Entrada {
    public static void main(String[] args) {
        BibliotecaGeneral bibliotecaGeneral = new BibliotecaGeneral("BiblioteK", "Yo mismo");
        bibliotecaGeneral.construirCatalogo(2);
        bibliotecaGeneral.mostrarDatos();
        bibliotecaGeneral.agregarLibro(new Terror(1, "La Maldicion", "Anonimo", 150, 18));
        bibliotecaGeneral.mostrarDatos();
        bibliotecaGeneral.agregarLibro(new Terror(2,"dfsdf", "fdadfdsf", 342, 18));
        bibliotecaGeneral.mostrarDatos();
        bibliotecaGeneral.agregarLibro(new Comedia());
        bibliotecaGeneral.mostrarDatos();
        bibliotecaGeneral.sacarLibro();
        bibliotecaGeneral.mostrarDatos();


    }
}
