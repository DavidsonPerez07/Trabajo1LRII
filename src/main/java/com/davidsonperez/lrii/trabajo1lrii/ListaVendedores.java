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
    
    public Vendedor mostrarLista(char orden) {
        Vendedor v = null;
        if (orden == 'd') {
            x = x.getLigaDer();
            
            if (x == null) {
                x = cab;
            }
            
            v = x.getVendedor();
        }
        else if (orden == 'r') {
            if (y == cab) {
                y = ult;
                return null;
            }
            
            y = y.getLigaIzq();
            v = y.getLigaDer().getVendedor();
        }
        return v;
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
    
    public boolean vendedorExiste(String codigo) {
        boolean existe = false;
        NodoDobleVendedor p = cab.getLigaDer();
        
        while (p != null) {
            if (p.getVendedor().getCodigo().equals(codigo)) {
                existe = true;
                p = null;
            }
            else {
                p.getLigaDer();
            }
        }
        return existe;
    }
    
    public void eliminarVendedor(String codigo) {
        NodoDobleVendedor p = cab.getLigaDer();
        
        while (p != null) {
            if (p.getVendedor().getCodigo().equals(codigo)) {
                p.getLigaDer().setLigaIzq(p.getLigaDer());
            }
            else {
                p.getLigaDer();
            }
        }
    }
}
