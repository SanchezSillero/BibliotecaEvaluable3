import model.*;

import java.util.ArrayList;

public class Entrada {
    public static void main(String[] args) {
        BibliotecaGeneral bibliotecaGeneral = new BibliotecaGeneral("BiblioteK", "Yo mismo");
        bibliotecaGeneral.construirCatalogo(2);
        //bibliotecaGeneral.mostrarDatos();
        bibliotecaGeneral.agregarLibro(new Terror(1, "La Maldicion", "Anonimo", 150, 18));
        //bibliotecaGeneral.mostrarDatos();
        bibliotecaGeneral.agregarLibro(new Terror(2,"dfsdf", "fdadfdsf", 342, 18));
        //bibliotecaGeneral.mostrarDatos();
        /*bibliotecaGeneral.agregarLibro(new Comedia());
        bibliotecaGeneral.mostrarDatos();
        bibliotecaGeneral.sacarLibro();
        bibliotecaGeneral.mostrarDatos();
        bibliotecaGeneral.buscarPorIsbn();*/
        BibliotecaEspecializada bibliotecaEspecializada = new BibliotecaEspecializada("BibTerror","hflk", Tematica.terror);
        bibliotecaEspecializada.construirCatalogo(1);
        bibliotecaEspecializada.agregarLibro(new Terror());
        bibliotecaEspecializada.agregarLibro(new Terror(3, "ljbhd", "ñbn", 3531, 18));
        //bibliotecaEspecializada.buscarPorIsbn();
        bibliotecaEspecializada.construirCatalogo(2);
        bibliotecaEspecializada.borrarCatalogo();
        bibliotecaEspecializada.construirCatalogo(5);
        bibliotecaGeneral.mostrarListaLibros();
        bibliotecaGeneral.mostrarDatos();


    }
}
