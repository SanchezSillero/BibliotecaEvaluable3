package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OperacionesCatalogo {

    public void escrituraObjeto(){
        ObjectOutputStream objectOutputStream = null;
        File file = new File("src/resources/catalogoPrueba");

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                System.out.println("Error en cerrado");
            }catch (NullPointerException e){
                System.out.println("Cerrado en nulo");
            }
        }
    }

    public void lecturaObjeto(){

    }
}
