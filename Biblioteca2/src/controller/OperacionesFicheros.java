package controller;

import model.Biblioteca;
import model.Libro;

import java.io.*;
import java.util.ArrayList;

public class OperacionesFicheros {
    Biblioteca biblioteca;
    Libro libro;
    private static final String rutaCatalogos = "Biblioteca2/src/resources/catalogos/";

    public void escrituraLibro(String nombreArchivo, ArrayList<Libro> libros) {
        File carpeta = new File(rutaCatalogos);
        if (!carpeta.exists()) {  //creamos la carpeta para almacenar catalogos
            System.out.println("creando carpeta");
            carpeta.mkdir();
            System.out.println("carpeta creada");
        }
        File file = new File(rutaCatalogos+"libros_"+nombreArchivo);
        if (!file.exists()) {
            System.out.println("creando fichero");
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Fallo en la creación del fichero");
            }
            System.out.println("fichero creado");
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            for (Libro libro : libros) {
                objectOutputStream.writeObject(libro);
            }
            System.out.println("Datos guardados en el fichero correctamente");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                System.out.println("Error en cerrado");
            } catch (NullPointerException e) {
                System.out.println("Cerrado en nulo");
            }
        }
    }

    public ArrayList<Libro> lecturaLibro(String nombreArchivo) {
        ArrayList<Libro> libros = new ArrayList<>();
        File file = new File(rutaCatalogos+"libros_"+nombreArchivo);
        if (!file.exists()) {
            System.out.println("No existe el fichero");
        }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            while (true) {
                try {
                    Libro libro = (Libro) objectInputStream.readObject();
                    libros.add(libro);
                }catch (EOFException e){
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada");
        } catch (IOException e) {
            System.out.println("Error en la lectura");
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                System.out.println("Error en el cerrado");
            } catch (NullPointerException e) {
                System.out.println("Cerrado en nulo");
            }
        }
        return libros;
    }
}
