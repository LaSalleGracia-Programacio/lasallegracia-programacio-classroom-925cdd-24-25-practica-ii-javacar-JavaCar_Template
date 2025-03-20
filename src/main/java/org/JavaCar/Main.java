package org.JavaCar;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)  {

       menu();

    }


    public static void menu() {
        int opcio = 0;
        System.out.println("\n     ██╗ █████╗ ██╗   ██╗ █████╗  ██████╗ █████╗ ██████╗ \n" +
                "     ██║██╔══██╗██║   ██║██╔══██╗██╔════╝██╔══██╗██╔══██╗\n" +
                "     ██║███████║██║   ██║███████║██║     ███████║██████╔╝\n" +
                "██   ██║██╔══██║╚██╗ ██╔╝██╔══██║██║     ██╔══██║██╔══██╗\n" +
                "╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║╚██████╗██║  ██║██║  ██║\n" +
                " ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚═╝  ╚═╝\n" +
                "                                                         ");
        do {
            System.out.println("1. Crear vehicle");
            System.out.println("2. Veure vehicles");
            System.out.println("3. Llogar vehicle");
            System.out.println("4. Retornar vehicle");
            System.out.println("5. Crear informe dels vehicles");
            System.out.println("6. Sortir");
            opcio = pedirOpcion(1, 6);
        } while (opcio != 6);
    }

}
