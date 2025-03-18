package org.JavaCar;
/**
 * Interfície que defineix el mètode per calcular el preu del lloguer.
 */
public interface Llogable {
    /**
     * Calcula el preu del lloguer en funció dels dies.
     *
     * @param dies Nombre de dies de lloguer.
     * @return Preu total del lloguer.
     */
    double calcularPreu(int dies);
}
