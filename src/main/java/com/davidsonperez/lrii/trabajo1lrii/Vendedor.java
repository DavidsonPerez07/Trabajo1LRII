package com.davidsonperez.lrii.trabajo1lrii;

public class Vendedor {
    private String codigo, nombre;
    private char sexo;
    private double totalVentas;
    
    public Vendedor(String codigo, String nombre, char sexo, double totalVentas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.sexo = sexo;
        this.totalVentas = totalVentas;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }

    @Override
    public String toString() {
        return codigo + " | " + nombre + " | " + sexo + " | " + totalVentas + "$";
    }
}
