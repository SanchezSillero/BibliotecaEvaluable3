package controller;

import java.util.Scanner;

public class Aplicacion {
    private Scanner scanner=new Scanner(System.in);
    public void menu(){
        System.out.println("\t\t------BIENVENIDO AL GESTOR DE BIBLIOTECAS------");
        System.out.println("\n\n\t\t    Pulse Enter para continuar");
        scanner.nextLine();
    }
}
