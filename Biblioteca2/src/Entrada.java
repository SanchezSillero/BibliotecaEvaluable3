import controller.Aplicacion;
import model.*;

public class Entrada {
    public static void main(String[] args) {
        Biblioteca<Libro> bibliotecaGeneral = new Biblioteca<>();
        Aplicacion aplicacion = new Aplicacion();
        aplicacion.menu(bibliotecaGeneral);


}
}
