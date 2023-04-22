package com.davidsonperez.lrii.trabajo1lrii;

import java.util.Scanner;

public class Trabajo1LRII {

    public static void main(String[] args) {
        ListaVendedores lista = new ListaVendedores();
        char opc;
        Vendedor vendedor;
        boolean existe;
        Scanner input = new Scanner(System.in);
        
        do {
            opc = menu();
            
            switch (opc) {
                case '1' -> {
                    System.out.println("\t\nIngrese los datos del/la vendedor/a: ");
                    System.out.print("Código: ");
                    var codigo = input.nextLine();
                    existe = lista.vendedorExiste(codigo);
                    
                    if (!existe) {
                        System.out.print("Nombre: ");
                        var nombre = input.nextLine();
                        System.out.print("Sexo: ");
                        var sexo = input.next().charAt(0);
                        System.out.print("Total ventas: ");
                        var ventas = input.nextDouble();
                        
                        lista.ingresarVendedor(codigo, nombre, sexo, ventas);
                        
                        System.out.println("\t\nIngreso exitoso");
                        input.nextLine();
                    }
                    else {
                        System.out.println("\t\nEl usuario ya se encuentra registrado");
                    }
                    saltarLinea();
                }
                case '2' -> {
                    System.out.print("\t\nIngrese el código del vendedor a eliminar: ");
                    var codigo = input.nextLine();
                    existe = lista.vendedorExiste(codigo);
                    
                    if (existe == true) {
                        lista.eliminarVendedor(codigo);
                        System.out.println("\t\nVendedor eliminado exitosamente");
                    }
                    else {
                        System.out.println("\t\nNo existe vendedor con este código");
                    }
                    saltarLinea();
                }
                case '3' -> {
                    System.out.println("\t\nEl promedio de ventas de la empresa es: " + lista.promedioVentas() + "$");
                    saltarLinea();
                }
                case '4' -> {
                    System.out.println("\t\nEl mayor total ventas de la mujeres es: " + lista.mayorVentasMujeres() + "$");
                    saltarLinea();
                }
                case '5' -> {
                    System.out.println("\t\nEl menor total ventas de los hombres es: " + lista.menorVentasHombres() + "$");
                    saltarLinea();
                }
                case '6' -> {
                    System.out.print("\t\nIngrese el sexo del total de las personas a consultar: ");
                    var sexo = input.next().charAt(0);
                    input.nextLine();
                    System.out.println("\t\nEl total de vendedores de este sexo es: " + lista.totalVendedores(sexo));
                    saltarLinea();
                }
                case '7' -> {
                    char orden;
                    
                    do {
                        System.out.print("\t\nIngrese el orden en el que quiere imprimir la lista (d: al derecho, r: al revés): ");
                        orden = input.next().charAt(0);
                        input.nextLine();
                    } while (orden != 'd' && orden != 'r');
                    
                    System.out.println("\t\nEl listado de los vendedores es: ");
                    
                    vendedor = lista.mostrarLista(orden);
                    while (vendedor != null) {
                        System.out.println(vendedor.toString());
                        vendedor = lista.mostrarLista(orden);
                    }
                    saltarLinea();
                }
                case '8' -> System.out.println("\t\nSaliendo del programa...");
                default -> {
                }
            }
        } while (opc != '8');
    }
    
    private static void saltarLinea(){
        System.out.println("\t\nPresione ENTER para continuar.");
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }
     
    static char menu() {
        char opcion;
        Scanner input = new Scanner(System.in);
        
        do {
            System.out.println("\t============= MENU =============");
            System.out.println("\t1. Ingresar nuevo vendedor.");
            System.out.println("\t2. Eliminar vendedor.");
            System.out.println("\t3. Promedio de ventas de la empresa.");
            System.out.println("\t4. Mostrar mayor total ventas de las mujeres.");
            System.out.println("\t5. Mostrar menor total ventas de los hombres.");
            System.out.println("\t6. Mostrar total de vendedores hombres o mujeres.");
            System.out.println("\t7. Mostrar los datos de la lista.");
            System.out.println("\t8. Salir");
            System.out.print("\nIngrese la opción: ");
            opcion = input.next().charAt(0);
        } while (opcion < '1' || opcion > '8');
        
        return opcion;
    }
}
