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
            v = mostrarAlDerecho();
        }
        else if (orden == 'r') {
            v = mostrarAlReves();
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
                p = p.getLigaDer();
            }
        }
        return existe;
    }
    
    public void eliminarVendedor(String codigo) {
        NodoDobleVendedor p = cab.getLigaDer();
        
        while (p != null) {
            if (p.getVendedor().getCodigo().equals(codigo)) {
                desligarNodo(p);
            }
             p = p.getLigaDer();
        }
    }
    
    private void desligarNodo(NodoDobleVendedor nodoDesligar){
        if(nodoDesligar == ult){
            nodoDesligar.getLigaIzq().setLigaDer(nodoDesligar.getLigaDer());
        }
        else{
            nodoDesligar.getLigaDer().setLigaIzq(nodoDesligar.getLigaIzq());
            nodoDesligar.getLigaIzq().setLigaDer(nodoDesligar.getLigaDer());
        }
    }
    
    public double promedioVentas() {
        double totalVentas = 0.0d;
        int totalVendedores = 0;
        NodoDobleVendedor p = cab.getLigaDer();
        
        while (p != null) {
            totalVentas += p.getVendedor().getTotalVentas();
            totalVendedores++;
            p = p.getLigaDer();
        }
        
        return totalVentas/totalVendedores;
    }
    
    public double mayorVentasMujeres() {
        NodoDobleVendedor p = cab.getLigaDer();
        double mayorVentas = 0.0d;
        
        while (p != null) {
            if (p.getVendedor().getSexo() == 'f' && p.getVendedor().getTotalVentas() > mayorVentas) {
                mayorVentas = p.getVendedor().getTotalVentas();
            }
            p = p.getLigaDer();
        }
        
        return mayorVentas;
    }
    
    public double menorVentasHombres() {
        NodoDobleVendedor p = cab.getLigaDer();
        double menorVentas = p.getVendedor().getTotalVentas();
        
        while (p != null) {
            if (p.getVendedor().getSexo() == 'm' && p.getVendedor().getTotalVentas() < menorVentas) {
                menorVentas = p.getVendedor().getTotalVentas();
            }
            p = p.getLigaDer();
        }
        
        return menorVentas;
    }
    
    public int totalVendedores(char sexo) {
        int total = 0;
        NodoDobleVendedor p = cab.getLigaDer();
        
        while (p != null) {
            if (p.getVendedor().getSexo() == sexo) {
                total++;
            }
            p = p.getLigaDer();
        }
        
        return total;
    }
}
