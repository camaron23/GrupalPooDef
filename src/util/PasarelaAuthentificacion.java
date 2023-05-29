package util;

import cliente.Cliente;
import cliente.GestorClientes;
import empleado.GestorEmpleados;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasarelaAuthentificacion {
    public static Object autentificar(){
        String rutaArchivo = "../empleados.txt"; // Ruta del archivo a borrar
        File file = new File(rutaArchivo);
        file.delete();
        file = new File("../clientes.txt");
        file.delete();
        int sel1, sel2;
        int sel3;
        String user, pass;
        boolean bool1, bool2, bool3, bool4, bool5;
        Scanner sc = new Scanner(System.in);
        GestorClientes gestorClientes = new GestorClientes();
        GestorEmpleados gestorEmpleados = new GestorEmpleados();

        bool1 = false;
        while (bool1 == false) {
            System.out.println("¿Eres cliente o empleado?");
            System.out.println("1. Cliente");
            System.out.println("2. Empleado");

            sel1 = sc.nextInt();
            sc.nextLine();

            bool2 = false;
            switch (sel1){
                case 1:
                    System.out.println("Introduce tu usuario: ");
                    user = sc.nextLine();
                    System.out.println("Introduce tu contraseña: ");
                    pass = sc.nextLine();
                    bool3 = gestorClientes.authentificarCliente(user, pass);
                    if (bool3 == true) {
                        return gestorClientes.buscarCliente(user);
                    }

                    else{
                        System.out.println("Usuario o contraseña incorrectos.");
                        System.out.println("¿Quieres volver a intentarlo?");
                        System.out.println("1. Sí");
                        System.out.println("2. No");
                        sel2 = sc.nextInt();
                        sc.nextLine();
                        switch (sel2){
                            case 1:
                                break;
                            case 2:
                                bool1 = true;
                                break;
                            default:
                                System.out.println("Opción incorrecta.");
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Introduce tu DNI: ");
                    user = sc.nextLine();
                    System.out.println("Introduce tu contraseña: ");
                    pass = sc.nextLine();
                    bool3 = gestorEmpleados.authentificarEmpleado(user, pass);
                    if (bool3 == true) {
                        return gestorEmpleados.buscarEmpleado(user);
                    }

                    else{
                        System.out.println("DNI o contraseña incorrectos.");
                        System.out.println("¿Quieres volver a intentarlo?");
                        System.out.println("1. Sí");
                        System.out.println("2. No");
                        sel2 = sc.nextInt();
                        sc.nextLine();
                        switch (sel2){
                            case 1:
                                break;
                            case 2:
                                bool1 = true;
                                break;
                            default:
                                System.out.println("Opción incorrecta.");
                                break;
                        }
                    }


            }
        }
        return null;
    }
}