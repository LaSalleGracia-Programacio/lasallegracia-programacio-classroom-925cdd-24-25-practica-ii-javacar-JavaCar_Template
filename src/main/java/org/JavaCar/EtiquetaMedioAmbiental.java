package org.JavaCar;

public enum EtiquetaMedioAmbiental {
    ETIQUETA_0_EMISIONES("Etiqueta 0 Emisiones", "Azul"),
    ETIQUETA_ECO("Etiqueta Eco", "Verde"),
    ETIQUETA_C("Etiqueta C", "Verde"),
    ETIQUETA_B("Etiqueta B", "Amarilla");

    private String nombre;
    private String color;

    EtiquetaMedioAmbiental(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }
}