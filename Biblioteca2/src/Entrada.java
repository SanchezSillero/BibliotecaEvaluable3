import model.*;

import java.util.ArrayList;

public class Entrada {
    public static void main(String[] args) {

        BibliotecaEspecializada bibliotecaEspecializada = new BibliotecaEspecializada("BibTerror","hflk", Tematica.terror);
        //bibliotecaEspecializada.construirCatalogo(1);
        bibliotecaEspecializada.agregarLibro(new Terror(12,"dfsdf", "fdadfdsf", 342, 18));
        bibliotecaEspecializada.mostrarDatos();
        bibliotecaEspecializada.borrarCatalogo();
        bibliotecaEspecializada.sacarLibro();




    }
}
