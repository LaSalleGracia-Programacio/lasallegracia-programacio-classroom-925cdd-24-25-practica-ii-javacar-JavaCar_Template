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
//Gestiona las solicitudes de alquiler pendientes, permitiendo aprobar o rechazar solicitudes
    private static void gestionarSolicituds() {
        System.out.println("\n=== SOL·LICITUDS PENDENTS ===");
        if (solicitudes.isEmpty()) {
            System.out.println("No hi ha sol·licituds pendents.");
            return;
        }

        for (int i = 0; i < solicitudes.size(); i++) {
            Solicitud s = solicitudes.get(i);
            System.out.println((i+1) + ". Matrícula: " + s.getMatricula() +
                    ", Client: " + s.getClient() +
                    ", Dies: " + s.getDies());
        }

        System.out.print("Seleccioneu una sol·licitud (0 per tornar): ");
        int seleccio = escaner.nextInt();
        escaner.nextLine();

        if (seleccio > 0 && seleccio <= solicitudes.size()) {
            Solicitud s = solicitudes.get(seleccio-1);

            Vehicle vehicle = null;
            for (Vehicle v : vehicles) {
                if (v.getMatricula().equals(s.getMatricula())) {
                    vehicle = v;
                    break;
                }
            }

            if (vehicle != null) {
                System.out.println("1. Aprovar sol·licitud");
                System.out.println("2. Rebutjar sol·licitud");
                System.out.print("Seleccioneu una opció: ");
                int opcio = escaner.nextInt();
                escaner.nextLine();

                if (opcio == 1) {
                    vehiclesLlogats.add(vehicle);
                    System.out.println("Lloguer iniciat per a " + s.getClient() +
                            " amb el vehicle " + s.getMatricula());
                }
                solicitudes.remove(seleccio-1);
            } else {
                System.out.println("Vehicle no trobat.");
            }
        }
    }

//Información sobre cómo iniciar un alquiler, redirigiendo al usuario al menú de gestión de solicitudes
    private static void iniciarLloguer() {
        System.out.println("\n=== INICIAR LLOGUER ===");
        System.out.println("Aquesta opció s'ha de fer des de 'Gestionar sol·licituds'");
        System.out.println("Torna al menú i selecciona 'Gestionar sol·licituds'");
    }

  //Permite al administrador agregar un nuevo vehículo, seleccionando tipo, matrícula, marca, modelo y otros detalles
    private static void afegirVehicle() {
        System.out.println("\n=== AFEGIR VEHICLE ===");
        System.out.println("Seleccioneu el tipus de vehicle:");
        System.out.println("1. Cotxe");
        System.out.println("2. Moto");
        System.out.println("3. Furgoneta");
        System.out.print("Opció: ");


        if (!escaner.hasNextInt()) {
            System.out.println("Error: Ha de ser un número (1-3)");
            escaner.nextLine();
            return;
        }
        int tipus = escaner.nextInt();
        escaner.nextLine();

        if (tipus < 1 || tipus > 3) {
            System.out.println("Tipus no vàlid.");
            return;
        }


        System.out.print("Matrícula: ");
        String matricula = escaner.nextLine();
        if (matricula.isBlank()) {
            System.out.println("La matrícula no pot estar buida");
            return;
        }

        System.out.print("Marca: ");
        String marca = escaner.nextLine();

        System.out.print("Model: ");
        String model = escaner.nextLine();


        System.out.print("Preu base per dia: ");
        if (!escaner.hasNextDouble()) {
            System.out.println("Error: El preu ha de ser un número");
            escaner.nextLine();
            return;
        }
        double preu = escaner.nextDouble();
        escaner.nextLine();
        if (preu <= 0) {
            System.out.println("El preu ha de ser positiu");
            return;
        }


        System.out.print("Tipus de motor: ");
        String tipusMotor = escaner.nextLine();

        System.out.print("Potència del motor: ");
        if (!escaner.hasNextInt()) {
            System.out.println("Error: La potència ha de ser un número enter");
            escaner.nextLine();
            return;
        }
        int potenciaMotor = escaner.nextInt();
        escaner.nextLine();
        if (potenciaMotor <= 0) {
            System.out.println("La potència ha de ser positiva");
            return;
        }
        Motor motor = new Motor(tipusMotor, potenciaMotor);


        System.out.print("Marca de les rodes: ");
        String marcaRodes = escaner.nextLine();

        System.out.print("Diàmetre de les rodes: ");
        if (!escaner.hasNextDouble()) {
            System.out.println("Error: El diàmetre ha de ser un número");
            escaner.nextLine();
            return;
        }
        double diametreRodes = escaner.nextDouble();
        escaner.nextLine();
        if (diametreRodes <= 0) {
            System.out.println("El diàmetre ha de ser positiu");
            return;
        }

        Roda[] rodes = new Roda[4];
        for (int i = 0; i < rodes.length; i++) {
            rodes[i] = new Roda(marcaRodes, diametreRodes);
        }


        switch (tipus) {
            case 1:
                System.out.print("Nombre de places: ");
                if (!escaner.hasNextInt()) {
                    System.out.println("Error: Nombre de places ha de ser enter");
                    escaner.nextLine();
                    return;
                }
                int places = escaner.nextInt();
                escaner.nextLine();
                if (places <= 0) {
                    System.out.println("Les places han de ser positives");
                    return;
                }
                vehicles.add(new Cotxe(matricula, marca, model, preu, places, motor, rodes));
                break;

            case 2:
                System.out.print("Cilindrada: ");
                if (!escaner.hasNextInt()) {
                    System.out.println("Error: Cilindrada ha de ser enter");
                    escaner.nextLine();
                    return;
                }
                int cilindrada = escaner.nextInt();
                escaner.nextLine();
                if (cilindrada <= 0) {
                    System.out.println("La cilindrada ha de ser positiva");
                    return;
                }
                vehicles.add(new Moto(matricula, marca, model, preu, cilindrada, motor, rodes));
                break;

            case 3:
                System.out.print("Capacitat de càrrega (kg): ");
                if (!escaner.hasNextDouble()) {
                    System.out.println("Error: Capacitat ha de ser número");
                    escaner.nextLine();
                    return;
                }
                double capacitat = escaner.nextDouble();
                escaner.nextLine();
                if (capacitat <= 0) {
                    System.out.println("La capacitat ha de ser positiva");
                    return;
                }
                vehicles.add(new Furgoneta(matricula, marca, model, preu, capacitat, motor, rodes));
                break;
        }

        System.out.println("Vehicle afegit correctament.");
    }
//Permite al administrador actualizar los detalles de un vehículo, como marca, modelo, precio y motor
    private static void actualitzarVehicle() {
        System.out.println("\n=== ACTUALITZAR VEHICLE ===");
        llistarTotsVehicles();
        System.out.print("Introduïu la matrícula del vehicle a actualitzar: ");
        String matricula = escaner.nextLine();

        Vehicle vehicle = trobarVehiclePerMatricula(matricula);
        if (vehicle != null) {
            System.out.print("Nova marca (" + vehicle.getMarca() + "): ");
            String marca = escaner.nextLine();
            if (marca.length() > 0) vehicle.marca = marca;

            System.out.print("Nou model (" + vehicle.getModel() + "): ");
            String model = escaner.nextLine();
            if (model.length() > 0) vehicle.model = model;

            System.out.print("Nou preu base (" + vehicle.getPreuBase() + "): ");
            String preuStr = escaner.nextLine();
            if (preuStr.length() > 0) vehicle.preuBase = Double.parseDouble(preuStr);


            System.out.print("Nou tipus de motor (" + vehicle.getMotor().getTipus() + "): ");
            String tipusMotor = escaner.nextLine();
            if (tipusMotor.length() > 0) vehicle.motor.tipus = tipusMotor;

            System.out.print("Nova potència (" + vehicle.getMotor().getPotencia() + "): ");
            String potenciaStr = escaner.nextLine();
            if (potenciaStr.length() > 0) vehicle.motor.potencia = Integer.parseInt(potenciaStr);

            System.out.println("Vehicle actualitzat correctament.");
        } else {
            System.out.println("Vehicle no trobat.");
        }
    }
    }
}