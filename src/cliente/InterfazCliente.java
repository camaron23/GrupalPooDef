package cliente;

import pedido.GestorPedidos;
import producto.GestorProductos;
import producto.Producto;
import pedido.Venta;


import java.util.Scanner;

public class InterfazCliente {
    public static void InterfazCli(Cliente cliente){
        Scanner sc = new Scanner(System.in);
        GestorProductos gestorProductos = new GestorProductos();
        GestorPedidos gestorPedidos = new GestorPedidos();

        System.out.println("Bienvenido " + cliente.getNombre());
        System.out.println("¿Que desea hacer?");
        System.out.println("1. Ver productos");
        System.out.println("2. Ver pedidos");
        System.out.println("3. Salir");
        System.out.println("Introduzca el numero de la opcion que desea: ");
        int opcion = sc.nextInt();

        switch(opcion){
            case 1:
                System.out.println("producto");
                System.out.println("1. Ver todos los productos");
                System.out.println("2. Ver productos por categoria");
                System.out.println("Introduzca el numero de la opcion que desea: ");
                int opcion2 = sc.nextInt();

                switch(opcion2){
                    case 1:

                        System.out.println("Todos los productos");
                        for(int i = 0; i < gestorProductos.readProductos().size(); i++){
                            System.out.println(gestorProductos.readProductos().get(i));
                        }
                        break;
                    case 2:
                        System.out.println("Productos por categoria");
                        System.out.println("1. Altavoces");
                        System.out.println("2. Ordenadores");
                        System.out.println("3. Smartphones");
                        System.out.println("4. Televisores");
                        System.out.println("Introduzca el numero de la opcion que desea: ");
                        int opcion3 = sc.nextInt();

                        switch (opcion3) {
                            case 1:
                                System.out.println("Altavoces");
                                for(int i = 0; i < gestorProductos.readProductos().size(); i++){
                                    if(gestorProductos.readProductos().get(i).getClass().equals("Productos.Altavoz")){
                                        System.out.println(gestorProductos.readProductos().get(i));
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Ordenadores");
                                for(int i = 0; i < gestorProductos.readProductos().size(); i++){
                                    if(gestorProductos.readProductos().get(i).getClass().equals("Productos.Ordenador")){
                                        System.out.println(gestorProductos.readProductos().get(i));
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("Smartphones");
                                for(int i = 0; i < gestorProductos.readProductos().size(); i++){
                                    if(gestorProductos.readProductos().get(i).getClass().equals("Productos.Smartphone")){
                                        System.out.println(gestorProductos.readProductos().get(i));
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("Televisores");
                                for(int i = 0; i < gestorProductos.readProductos().size(); i++){
                                    if(gestorProductos.readProductos().get(i).getClass().equals("Productos.Televisor")){
                                        System.out.println(gestorProductos.readProductos().get(i));
                                    }
                                }
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;
                        }
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }


                break;
            case 2:
                System.out.println("Pedidos");
                for(int i = 0; i < gestorPedidos.readPedidos().size(); i++){
                    if(gestorPedidos.readPedidos().get(i).getClienteDni().equals(cliente.getDni())){
                        System.out.println(gestorPedidos.readPedidos().get(i));
                    }
                }
                break;

            case 3:
                System.out.println("Saliendo...");
                break;

            default:
                System.out.println("Opcion no valida");
                break;
        }



    }
}