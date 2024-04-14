import exceptions.LibroNoEncontradoException;
import model.*;

import java.util.ArrayList;

public class Entrada {
    public static void main(String[] args) {
    BibliotecaEspecializada bibliotecaEspecializada = new BibliotecaEspecializada("ldksjfn", "ñdfjln", Tematica.comedia);
    bibliotecaEspecializada.construirCatalogo(5);
    bibliotecaEspecializada.agregarLibro(new Comedia());
    bibliotecaEspecializada.agregarLibro(new Comedia(1,"kljbf", "dlljfsd", 120, "dsvsv"));


}
}
