package org.JavaCar;
//Importación de clases para manejar listas y leer entrada del usuario
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Declaración de listas para vehículos, solicitudes y control de ingresos
    private static List<Vehicle> vehicles = new ArrayList<>();
    private static List<Vehicle> vehiclesLlogats = new ArrayList<>();
    private static Scanner escaner = new Scanner(System.in);
    private static List<Solicitud> solicitudes = new ArrayList<>();
    private static double ingressosTotals = 0;
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}