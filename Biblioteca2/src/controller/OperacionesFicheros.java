package controller;

import model.Biblioteca;
import model.Libro;

import java.io.*;

public class OperacionesFicheros {
    Biblioteca biblioteca;
    Libro libro;

    public void escrituraObjeto(Libro libro) {
        File carpeta = new File("Biblioteca2/src/resources/catalogos");
        if (!carpeta.exists()) {  //creamos la carpeta para almacenar catalogos
            System.out.println("creando carpeta");
            carpeta.mkdir();
            System.out.println("carpeta creada");
        }
        File file = new File("Biblioteca2/src/resources/catalogos/libros.obj");
        if (!file.exists()) {
            System.out.println("creando fichero");
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Fallo en la creación del fichero");
            }
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(libro);
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

    public void lecturaObjeto() {
        File carpeta = new File("Biblioteca2/src/resources/catalogos");
        if (!carpeta.exists()) {  //creamos la carpeta para almacenar catalogos
            carpeta.mkdir();
        }
       /* if (carpeta.isDirectory()) {
            File[] ficheros = carpeta.listFiles();
            for (File item : ficheros) {
                System.out.println(item.getName());
            }
        }*/
        File file = new File("Biblioteca2/src/resources/catalogos/libros.obj");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Fallo en la creación del fichero");
            }
        }


        ObjectInputStream objectInputStream = null;
       /* try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Libro libro = (Libro)objectInputStream.readObject();
            System.out.println(libro);

        } catch (IOException e) {
            System.out.println("Error en la lectura");
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada");
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                System.out.println("Error en el cerrado");
            } catch (NullPointerException e) {
                System.out.println("Cerrado en nulo");
            }*/
    }
}
