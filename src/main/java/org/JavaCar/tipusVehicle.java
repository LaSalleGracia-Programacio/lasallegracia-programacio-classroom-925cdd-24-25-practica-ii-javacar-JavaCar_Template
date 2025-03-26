package org.JavaCar;

public enum tipusVehicle {
    GASOLINA("Gasolina"), ELECTRIC("Electric"), HIBRID_DIESEL("HibridDiesel"), DIESEL("Diesel"),HIBRID_GASOLINA("HibridGasolina"), GAS("Gas");
    final String atr;

    tipusVehicle(String tipo) {
        this.atr = tipo;
    }
    public String getatr(){
        return atr;
    }
}
