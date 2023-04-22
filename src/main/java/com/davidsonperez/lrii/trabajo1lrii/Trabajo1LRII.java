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
                    System.out.println("Ingrese los datos del/la vendedor/a: ");
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
                        
                        System.out.println("Ingreso exitoso");
                        input.nextLine();
                    }
                    else {
                        System.out.println("El usuario ya se encuentra registrado");
                    }
                    saltarLinea();
                }
                case '2' -> {
                    System.out.print("Ingrese el código del vendedor a eliminar: ");
                    var codigo = input.nextLine();
                    existe = lista.vendedorExiste(codigo);
                    
                    if (existe == true) {
                        lista.eliminarVendedor(codigo);
                        System.out.println("Vendedor eliminado exitosamente");
                    }
                    else {
                        System.out.println("No existe vendedor con este código");
                    }
                    saltarLinea();
                }
                case '3' -> {
                    System.out.println("El promedio de ventas de la empresa es: " + lista.promedioVentas());
                }
                case '4' -> {
                    System.out.println("El mayor total ventas de la mujeres es: " + lista.mayorVentasMujeres());
                }
                case '5' -> {
                    System.out.println("El menor total ventas de los hombres es: " + lista.menorVentasHombres());
                }
                case '6' -> {
                    System.out.print("Ingrese el sexo del total de las personas a consultar: ");
                    var sexo = input.next().charAt(0);
                    input.nextLine();
                    System.out.println("El total de vendedores de este sexo es: " + lista.totalVendedores(sexo));
                    saltarLinea();
                }
                case '7' -> {
                    char orden;
                    
                    do {
                        System.out.print("Ingrese el orden en el que quiere imprimir la lista (d: al derecho, r: al revés): ");
                        orden = input.next().charAt(0);
                        input.nextLine();
                    } while (orden != 'd' && orden != 'r');
                    
                    System.out.println("El listado de los vendedores es: ");
                    
                    vendedor = lista.mostrarLista(orden);
                    while (vendedor != null) {
                        System.out.println(vendedor.toString());
                        vendedor = lista.mostrarLista(orden);
                    }
                    saltarLinea();
                }
                case '8' -> System.out.println("Saliendo del programa...");
                default -> {
                }
            }
        } while (opc != '8');
    }
    
    private static void saltarLinea(){
        System.out.println("\nPresione ENTER para continuar.");
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }
    
    static char menu() {
        char opcion;
        Scanner input = new Scanner(System.in);
        
        do {
            System.out.println("MENU");
            System.out.println("1. Ingresar nuevo vendedor.");
            System.out.println("2. Eliminar vendedor.");
            System.out.println("3. Promedio de ventas de la empresa.");
            System.out.println("4. Mostrar mayor total ventas de las mujeres.");
            System.out.println("5. Mostrar menor total ventas de los hombres.");
            System.out.println("6. Mostrar total de vendedores hombres o mujeres.");
            System.out.println("7. Mostrar los datos de la lista.");
            System.out.println("8. Salir");
            System.out.print("Ingrese la opción: ");
            opcion = input.next().charAt(0);
        } while (opcion < '1' || opcion > '8');
        
        return opcion;
    }
}
