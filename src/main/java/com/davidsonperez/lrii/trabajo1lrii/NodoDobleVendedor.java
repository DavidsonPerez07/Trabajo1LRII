package com.davidsonperez.lrii.trabajo1lrii;

public class NodoDobleVendedor {
    Vendedor vendedor;
    NodoDobleVendedor ligaIzq, ligaDer;
    
    public NodoDobleVendedor(){
        vendedor = null;
        ligaIzq = ligaDer = null;
    }
    
    public NodoDobleVendedor(String codigo, String nombre, char sexo, double totalVentas) {
        vendedor = new Vendedor(codigo, nombre, sexo, totalVentas);
        ligaIzq = ligaDer = null;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public NodoDobleVendedor getLigaIzq() {
        return ligaIzq;
    }

    public void setLigaIzq(NodoDobleVendedor ligaIzq) {
        this.ligaIzq = ligaIzq;
    }

    public NodoDobleVendedor getLigaDer() {
        return ligaDer;
    }

    public void setLigaDer(NodoDobleVendedor ligaDer) {
        this.ligaDer = ligaDer;
    }
}
