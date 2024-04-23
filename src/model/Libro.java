package model;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Libro implements Serializable {
    private static final long serialVersionUID = 12345678987654321L;
    protected int isbn;
    protected String titulo;
    protected String autor;
    protected int numeroPaginas;
    protected Tipo tipo;


    public Libro() {
    }

    public Libro(int isbn, String titulo, String autor, int numeroPaginas, Tipo tipo) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.tipo = tipo;
    }

    public void mostrarDatos() {
        System.out.println("isbn = " + isbn);
        System.out.println("titulo = " + titulo);
        System.out.println("autor = " + autor);
        System.out.println("temática = " + tipo);
        System.out.println("numeroPaginas = " + numeroPaginas);
        System.out.println("tipo = " + tipo);
    }

    public void pedirDatosLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce los datos del libro");
        System.out.println("ISBN:");
        isbn = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Título");
        titulo = scanner.nextLine();
        System.out.println("Autor");
        autor = scanner.nextLine();
        System.out.println("Número de páginas");
        try {
        numeroPaginas = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Número de páginas no válido");
        }
        System.out.println("Tipo (terror/comedia/ensayo/policica):");
        String tipoStr = scanner.nextLine();
        tipo = Tipo.valueOf(tipoStr.toLowerCase());
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", tipo=" + tipo +
                '}';
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
