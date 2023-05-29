package pedido;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import util.GestorId;
import pedido.Venta;


public class GestorPedidos {
    GestorId gestorId = new GestorId();
    public void inicializarPedidos() {
        File file = new File("../pedidos.txt");
        if (file.exists()) {
            System.out.println("El archivo está inicializado");
        } else {
            try{
                FileWriter writer = new FileWriter(file);
                writer.write(gestorId.assignId() + ", 01/01/2021, 23459934Q, 1, 1, 1128");
                writer.write(gestorId.assignId() + ", 02/01/2021, 84273345I, 2, 1, 999");
                writer.close();
                System.out.println("Archivo creado");
            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
                e.printStackTrace();
            }
            }
        }

        public void addPedido(Venta pedido){
        File file = new File("../pedidos.txt");
        if(file.exists()){
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(pedido.getId() + ", " + pedido.getFecha() + ", " + pedido.getDniCliente() + ", " + pedido.getIdProducto() + ", " + pedido.getCantidad() + ", " + pedido.getPrecio());
                writer.close();
                System.out.println("Pedido añadido");
            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo no existe");
        }
    }

    public List<Venta> readPedidos(){
        List<Venta> pedidos = new ArrayList<>();
        try{
            File file = new File("../pedidos.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String[] datos = scanner.nextLine().split(", ");
                Venta pedido = new Venta(Integer.parseInt(datos[0]), datos[1], datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), Integer.parseInt(datos[5]));
                pedidos.add(pedido);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe");
            e.printStackTrace();
        }
        return pedidos;
    }

    public Venta buscarVenta(int id){
        List<Venta> ventas = new ArrayList<>();
        try{
            File file = new File("../pedidos.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(", ");
                Venta venta = new Venta(Integer.parseInt(datos[0]), datos[1], datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), Integer.parseInt(datos[5]));
                ventas.add(venta);
            }
            scanner.close();
        }   catch (FileNotFoundException e) {
            System.out.println("El archivo no existe");
            e.printStackTrace();
        }

        for (int i = 0; i < ventas.size(); i++) {
            if (ventas.get(i).getId() == id) {
                return ventas.get(i);
            }
        }
        Venta noexiste = new Venta(0, "0", "0", 0, 0, 0);
        return noexiste;
    }


        public void updatePedido(int idModificar, Venta pedidoNuevo){
            List<Venta> pedidos = new ArrayList<>();
            try{
                File file = new File("../pedidos.txt");
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String[] datos = scanner.nextLine().split(", ");
                    Venta pedido = new Venta(Integer.parseInt(datos[0]), datos[1], datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), Double.parseDouble(datos[5]));
                    pedidos.add(pedido);
                }
                scanner.close();
            }   catch (FileNotFoundException e) {
                System.out.println("El archivo no existe");
                e.printStackTrace();
            }

            for (int i = 0; i < pedidos.size(); i++) {
                if (pedidos.get(i).getId() == idModificar) {
                    pedidos.set(i, pedidoNuevo);
                }
            }

            try {
                PrintWriter writer = new PrintWriter("../pedidos.txt");
                writer.print("");
                writer.close();

                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("../pedidos.txt")));
                for (int i = 0; i < pedidos.size(); i++) {
                    out.println(pedidos.get(i).getId() + ", " + pedidos.get(i).getFecha() + ", " + pedidos.get(i).getDniCliente() + ", " + pedidos.get(i).getIdProducto() + ", " + pedidos.get(i).getCantidad() + ", " + pedidos.get(i).getPrecio());
                }
                out.close();

                Scanner scanner = new Scanner(new File("../pedidos.txt"));
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            }   catch (FileNotFoundException e) {
                System.out.println("El archivo no existe");
                e.printStackTrace();
            }   catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
                e.printStackTrace();
            }
        }

        public void deletePedido(int idPedido){
        File archivoTemporal = new File("../pedidosTemporal.txt");

        try{
            BufferedReader lector = new BufferedReader(new FileReader("../pedidos.txt"));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal));

            String lineaActual;

            while ((lineaActual = lector.readLine()) != null) {
                String[] datos = lineaActual.split(", ");

                if (datos[0].equals(idPedido)) {
                    escritor.write(lineaActual);
                    escritor.newLine();
                }
            }

            lector.close();
            escritor.close();

            File archivoOriginal = new File("../pedidos.txt");
            archivoTemporal.renameTo(archivoOriginal);
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean existePedido(int id){
        if(readPedidos().size() <= id){
            return true;
        }
        else
            return false;
    }

}