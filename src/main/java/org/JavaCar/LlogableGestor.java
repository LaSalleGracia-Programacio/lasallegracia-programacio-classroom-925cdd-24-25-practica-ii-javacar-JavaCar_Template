package org.JavaCar;

import java.util.List;
import java.util.stream.Collectors;

public class LlogableGestor {
    public double calcularIngressosTotals(List<Vehicle> vehicles, int dies) {
        double total = 0;
        for (Vehicle vehicle : vehicles) {
            total += vehicle.calcularPreu(dies);
        }
        return total;
    }

    public List<Vehicle> filtrarPerPreu(List<Vehicle> vehicles, double preuMax) {
        return vehicles.stream()
                .filter(v -> v.calcularPreu(1) <= preuMax)
                .collect(Collectors.toList());
    }


}
