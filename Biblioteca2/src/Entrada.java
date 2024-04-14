import controller.OperacionesMenu;
import exceptions.LibroNoEncontradoException;
import model.*;

import java.util.ArrayList;

public class Entrada {
    public static void main(String[] args) {
    BibliotecaEspecializada bibliotecaEspecializada = new BibliotecaEspecializada("ldksjfn", "ñdfjln", Tematica.comedia);
    OperacionesMenu operacionesMenu = new OperacionesMenu();
    operacionesMenu.menu(bibliotecaEspecializada);

}
}
