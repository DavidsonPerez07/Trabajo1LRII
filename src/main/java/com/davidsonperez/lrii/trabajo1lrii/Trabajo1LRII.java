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
                    
                    System.out.println("Codigo: ");
                    var codigo = input.nextLine();
                    
                    if (!existe) {
                        System.out.println("Nombre: ");
                        var nombre = input.nextLine();
                        System.out.println("Sexo: ");
                        var sexo = input.next().charAt(0);
                        System.out.println("Total ventas: ");
                        var ventas = input.nextDouble();
                        
                        lista.ingresarVendedor(codigo, nombre, sexo, ventas);
                        
                        System.out.println("Ingreso exitoso");
                    }
                    else {
                        System.out.println("El usuario ya se encuentra registrado");
                    }
                }
                case '2' -> {
                    System.out.println("Ingrese el código del vendedor a eliminar: ");
                    var codigo = input.nextLine();
                    
                    if (!existe) {
                        System.out.println("Vendedor eliminado exitosamente");
                    }
                    else {
                        System.out.println("No existe vendedor con este código");
                    }
                }
                case '3' -> {
                    System.out.println("El promedio de ventas de la empresa es: ");
                }
                case '4' -> {
                    System.out.println("El mayor total ventas de la mujeres es: ");
                }
                case '5' -> {
                    System.out.println("El menor total ventas de los hombres es: ");
                }
                case '6' -> {
                    System.out.println("Ingrese el sexo del total de las personas a consultar: ");
                    var sexo = input.next().charAt(0);
                    System.out.println("El total de vendedores de este sexo es: ");
                }
                case '7' -> {
                    char orden;
                    do {
                        System.out.println("Ingrese el orden en el que quiere imprimir la lista (d: al derecho, r: al revés): ");
                        orden = input.next().charAt(0);
                    } while (orden != 'd' || orden != 'r');
                    System.out.println("El listado de los vendedores es: ");
                }
                case '8' -> System.out.println("Saliendo del programa...");
                default -> {
                }
            }
        } while (opc != '8');
    }
    
    static char menu() {
        char opcion;
        Scanner input = new Scanner(System.in);
        
        do {
            System.out.println("MENU");
            System.out.println("1. Ingresar nuevo vendedor");
            System.out.println("2. Eliminar vendedor");
            System.out.println("3. Promedio de ventas de la empresa");
            System.out.println("4. Mostrar mayor total ventas de las mujeres");
            System.out.println("5. Mostrar menor total ventas de los hombres");
            System.out.println("6. Mostrar total de vendedores hombres o mujeres");
            System.out.println("7. Mostrar los datos de la lista");
            System.out.println("8. Salir");
            opcion = input.next().charAt(0);
        } while (opcion < '1' || opcion > '3');
        
        return opcion;
    }
}
