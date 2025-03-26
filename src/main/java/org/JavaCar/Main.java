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
//Menú para que el administrador gestione vehículos, alquileres e ingresos
    private static void menuAdministrador() {
        boolean tornar = false;
        while (!tornar) {
            System.out.println("\n=== MODE ADMINISTRADOR ===");
            System.out.println("1. Gestionar vehicles");
            System.out.println("2. Consultar llista de vehicles disponibles");
            System.out.println("3. Gestionar lloguers");
            System.out.println("4. Gestionar sol·licituds");
            System.out.println("5. Consultar ingressos acumulats");
            System.out.println("6. Tornar al menú principal");
            System.out.print("Seleccioneu una opció: ");

            int opcio = escaner.nextInt();
            escaner.nextLine();

            switch (opcio) {
                case 1:
                    gestionarVehicles();
                    break;
                case 2:
                    llistarTotsVehicles();
                    break;
                case 3:
                    gestionarLloguers();
                    break;
                case 4:
                    gestionarSolicituds();
                    break;
                case 5:
                    mostrarIngressosTotals();
                    break;
                case 6:
                    tornar = true;
                    break;
                default:
                    System.out.println("Opció no vàlida. Intenteu-ho novament.");
            }
        }
    }
//Calcula el precio de alquiler por día de un vehículo disponible
    private static void calcularPreuLloguerDia() {
        System.out.println("\n=== CALCULAR PREU DE LLOGUER PER DIA ===");
        llistarVehiclesDisponibles();
        System.out.print("Introduïu la matrícula del vehicle: ");
        String matricula = escaner.nextLine();

        Vehicle vehicle = trobarVehiclePerMatricula(matricula);
        if (vehicle != null) {
            boolean estaLlogat = false;
            for (Vehicle v : vehiclesLlogats) {
                if (v.getMatricula().equalsIgnoreCase(matricula)) {
                    estaLlogat = true;
                    break;
                }
            }

            if (!estaLlogat) {
                System.out.printf("Preu per dia del vehicle %s: %.2f€\n",
                        vehicle.getMatricula(), vehicle.getPreuBase());
            } else {
                System.out.println("Vehicle no disponible (ja està llogat).");
            }
        } else {
            System.out.println("Vehicle no trobat.");
        }
    }
//Calcula el coste total del alquiler de un vehículo según su duración
    private static void calcularCostTotalLloguer() {
        System.out.println("\n=== CALCULAR COST TOTAL DEL LLOGUER ===");
        llistarVehiclesDisponibles();
        System.out.print("Introduïu la matrícula del vehicle: ");
        String matricula = escaner.nextLine();

        Vehicle vehicle = trobarVehiclePerMatricula(matricula);
        if (vehicle != null) {
            boolean estaLlogat = false;
            for (Vehicle v : vehiclesLlogats) {
                if (v.getMatricula().equalsIgnoreCase(matricula)) {
                    estaLlogat = true;
                    break;
                }
            }

            if (!estaLlogat) {
                System.out.print("Introduïu la durada del lloguer en dies: ");
                int dies = escaner.nextInt();
                escaner.nextLine();

                double costTotal = vehicle.calcularPreu(dies);
                System.out.printf("Cost total del lloguer per %d dies: %.2f€\n", dies, costTotal);
            } else {
                System.out.println("Vehicle no disponible (ja està llogat).");
            }
        } else {
            System.out.println("Vehicle no trobat.");
        }
    }
//Muestra la lista de vehículos disponibles que no están alquilados
    private static void llistarVehiclesDisponibles() {
        System.out.println("\n=== VEHICLES DISPONIBLES ===");
        for (Vehicle vehicle : vehicles) {
            boolean estaLlogat = false;

            for (Vehicle llogat : vehiclesLlogats) {
                if (llogat.getMatricula().equals(vehicle.getMatricula())) {
                    estaLlogat = true;
                    break;
                }
            }

            if (!estaLlogat) {
                mostrarDetallsVehicle(vehicle);
            }
        }
    }
//Filtra y muestra vehículos disponibles dentro de un rango de precios especificado
    private static void filtrarPerRangPreu() {
        System.out.println("\n=== FILTRAR PER RANG DE PREUS ===");
        System.out.print("Introduïu el preu mínim: ");
        double preuMinim = escaner.nextDouble();
        System.out.print("Introduïu el preu màxim: ");
        double preuMaxim = escaner.nextDouble();
        escaner.nextLine();

        List<Vehicle> filtrats = new ArrayList<>();

        List<Vehicle> perPreuMaxim = GestorLloguers.filtrarPerPreu(vehicles, preuMaxim);

        for (Vehicle vehicle : perPreuMaxim) {
            if (vehicle.getPreuBase() >= preuMinim) {
                boolean estaLlogat = false;
                for (Vehicle llogat : vehiclesLlogats) {
                    if (llogat.getMatricula().equals(vehicle.getMatricula())) {
                        estaLlogat = true;
                        break;
                    }
                }

                if (!estaLlogat) {
                    filtrats.add(vehicle);
                }
            }
        }

        System.out.println("\nResultats del filtre:");
        for (Vehicle vehicle : filtrats) {
            mostrarDetallsVehicle(vehicle);
        }
    }
//Filtra y muestra vehículos disponibles según el tipo (coche, moto o furgoneta)
    private static void filtrarPerTipusVehicle() {
        System.out.println("\n=== FILTRAR PER TIPUS DE VEHICLE ===");
        System.out.println("1. Cotxes");
        System.out.println("2. Motos");
        System.out.println("3. Furgonetes");
        System.out.print("Seleccioneu un tipus: ");
        int tipus = escaner.nextInt();
        escaner.nextLine();

        // Validar tipus seleccionat
        if (tipus < 1 || tipus > 3) {
            System.out.println("Tipus no vàlid.");
            return;
        }

        TipusVehicle tipusBuscat = null;
        switch(tipus) {
            case 1: tipusBuscat = TipusVehicle.COTXE; break;
            case 2: tipusBuscat = TipusVehicle.MOTO; break;
            case 3: tipusBuscat = TipusVehicle.FURGONETA; break;
        }

        System.out.println("\nResultats del filtre:");
        for (Vehicle vehicle : vehicles) {
            // Comprovar disponibilitat
            boolean disponible = true;
            for (Vehicle llogat : vehiclesLlogats) {
                if (llogat.getMatricula().equals(vehicle.getMatricula())) {
                    disponible = false;
                    break;
                }
            }

            if (disponible && vehicle.getTipus() == tipusBuscat) {
                mostrarDetallsVehicle(vehicle);
            }
        }
    }
//Menú para gestionar vehículos: añadir, actualizar o eliminar vehículos
    private static void gestionarVehicles() {
        boolean tornar = false;
        while (!tornar) {
            System.out.println("\n=== GESTIÓ DE VEHICLES ===");
            System.out.println("1. Afegir vehicle");
            System.out.println("2. Actualitzar vehicle");
            System.out.println("3. Eliminar vehicle");
            System.out.println("4. Tornar al menú d'administrador");
            System.out.print("Seleccioneu una opció: ");

            int opcio = escaner.nextInt();
            escaner.nextLine(); // Netejar buffer

            switch (opcio) {
                case 1:
                    afegirVehicle();
                    break;
                case 2:
                    actualitzarVehicle();
                    break;
                case 3:
                    eliminarVehicle();
                    break;
                case 4:
                    tornar = true;
                    break;
                default:
                    System.out.println("Opció no vàlida. Intenteu-ho novament.");
            }
        }
    }

//Permite al usuario solicitar un alquiler de vehículo, verificando disponibilidad y registrando la solicitud
    private static void solicitarLloguer() {
        System.out.println("\n=== SOL·LICITAR LLOGUER ===");
        llistarVehiclesDisponibles();
        System.out.print("Introduïu la matrícula del vehicle: ");
        String matricula = escaner.nextLine();
        System.out.print("Introduïu el vostre nom: ");
        String client = escaner.nextLine();
        System.out.print("Introduïu els dies de lloguer: ");
        int dies = escaner.nextInt();
        escaner.nextLine();

        boolean vehicleDisponible = false;
        for (Vehicle vehicle : vehicles) {
            boolean llogat = false;
            for (Vehicle llogatVehicle : vehiclesLlogats) {
                if (llogatVehicle.getMatricula().equals(vehicle.getMatricula())) {
                    llogat = true;
                    break;
                }
            }
            if (vehicle.getMatricula().equals(matricula) && !llogat) {
                vehicleDisponible = true;
                break;
            }
        }

        if (vehicleDisponible) {
            solicitudes.add(new Solicitud(matricula, client, dies));
            System.out.println("Solicitud registrada correctament.");
        } else {
            System.out.println("Vehicle no trobat o no disponible.");
        }
    }
    }
}