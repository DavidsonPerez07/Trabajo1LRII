package com.davidsonperez.lrii.trabajo1lrii;

public class ListaVendedores {
    private NodoDobleVendedor cab, ult, x, y;
    
    public ListaVendedores() {
        cab = new NodoDobleVendedor();
        ult = cab;
        x = cab;
    }
    
    public void ingresarVendedor(String codigo, String nombre, char sexo, double ventas) {
        NodoDobleVendedor p = new NodoDobleVendedor(codigo, nombre, sexo, ventas);
        p.setLigaIzq(ult);
        ult.setLigaDer(p);
        ult = p;
        y = ult;
    }
    
    public Vendedor mostrarAlDerecho() {
        x = x.getLigaDer();
        
        if (x == null) {
            x = cab;
        }
        
        return x.getVendedor();
    }
    
    public Vendedor mostrarAlReves() {
        if (y == cab) {
            y = ult;
            return null;
        }
        
        y = y.getLigaIzq();
        return y.getLigaDer().getVendedor();
    }
}
