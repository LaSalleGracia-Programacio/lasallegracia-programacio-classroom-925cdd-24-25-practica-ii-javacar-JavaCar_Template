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
//Menú principal para gestionar el alquiler de vehículos tanto como usuario como administrador
    public static void main(String[] args) {
        inicialitzarVehicles();

        boolean sortir = false;
        while (!sortir) {
            System.out.println("\n=== SISTEMA DE GESTIÓ DE LLOGUER DE VEHICLES ===");
            System.out.println("1. Mode Usuari");
            System.out.println("2. Mode Administrador");
            System.out.println("3. Sortir");
            System.out.print("Seleccioneu una opció: ");

            int opcioPrincipal = escaner.nextInt();
            escaner.nextLine();

            switch (opcioPrincipal) {
                case 1:
                    menuUsuari();
                    break;
                case 2:
                    menuAdministrador();
                    break;
                case 3:
                    sortir = true;
                    System.out.println("Sortint del sistema...");
                    break;
                default:
                    System.out.println("Opció no vàlida. Intenteu-ho novament.");
            }
        }
        escaner.close();
    }
//Menú para que el usuario consulte y solicite alquileres de vehículos
    private static void menuUsuari() {
        boolean tornar = false;
        while (!tornar) {
            System.out.println("\n=== MODE USUARI ===");
            System.out.println("1. Calcular preu de lloguer per dia");
            System.out.println("2. Calcular cost total del lloguer");
            System.out.println("3. Buscar vehicles disponibles");
            System.out.println("4. Filtrar per rang de preus");
            System.out.println("5. Filtrar per tipus de vehicle");
            System.out.println("6. Solicitar lloguer");
            System.out.println("7. Tornar al menú principal");
            System.out.print("Seleccioneu una opció: ");

            int opcio = escaner.nextInt();
            escaner.nextLine();

            switch (opcio) {
                case 1:
                    calcularPreuLloguerDia();
                    break;
                case 2:
                    calcularCostTotalLloguer();
                    break;
                case 3:
                    llistarVehiclesDisponibles();
                    break;
                case 4:
                    filtrarPerRangPreu();
                    break;
                case 5:
                    filtrarPerTipusVehicle();
                    break;
                case 6:
                    solicitarLloguer();
                    break;
                case 7:
                    tornar = true;
                    break;
                default:
                    System.out.println("Opció no vàlida. Intenteu-ho novament.");
            }
        }
    }
    }
}