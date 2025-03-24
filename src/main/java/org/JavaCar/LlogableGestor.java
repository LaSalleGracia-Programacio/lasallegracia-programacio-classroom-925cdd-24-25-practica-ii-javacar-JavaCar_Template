package org.JavaCar;

import java.util.List;

public class LlogableGestor {
    public double calcularIngressosTotals(List<Vehicle> vehicles, int dies) {
        double total = 0;
        for (Vehicle vehicle : vehicles) {
            total += vehicle.calcularPreu(dies);
        }
        return total;
    }

}
