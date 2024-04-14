import controller.Aplicacion;
import model.*;

public class Entrada {
    public static void main(String[] args) {
    BibliotecaEspecializada bibliotecaEspecializada = new BibliotecaEspecializada("ldksjfn", "ñdfjln", Tematica.comedia);
    Aplicacion aplicacion = new Aplicacion();
    aplicacion.menu(bibliotecaEspecializada);

}
}
