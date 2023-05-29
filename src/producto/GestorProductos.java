package producto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import util.GestorId;

public class GestorProductos {
    GestorId gestorId = new GestorId();


    public void inicializarProductos() {
        File file = new File("../productos.txt");
        if (file.exists()) {
            System.out.println("El archivo esta inicializado");
        } else {
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(gestorId.assignId() + "Galaxy S10, " + 1128.0 + ", " + 10 + ", " + 4128 + ", Android, Samsung, Galaxy S10, Negro, Smartphone");
                writer.write(gestorId.assignId() + ", iPhone X, " + 999.0 + ", " + 10 + ", " + 3 + ", " + 64 + ", iOS, Apple, iPhone X, Gris, Smartphone");
                writer.write(gestorId.assignId() + ", JBL Flip4, " + 120 + ", " + 8 + ", " + 2800 + ", JBL, Flip 4, Negro, Altavoz");
                writer.write(gestorId.assignId() + ", Mi Speaker, " + 50 + ", " + 8 + ", " + 1000 + ", Xiaomi, Mi Speaker, Blanco, Altavoz");
                writer.write(gestorId.assignId() + ", Portatil, " + 1000 + ", " + 10 + ", " + 8 + ", " + 512 + ", Windows, Asus, Portatil, Gris, Ordenador");
                writer.write(gestorId.assignId() + ", Productos.Ordenador de sobremesa, " + 1500 + ", " + 10 + ", " + 16 + ", " + 1024 + ", Windows, Asus, Sobremesa, Negro, Ordenador");
                writer.write(gestorId.assignId() + ", miTv" + ", " + 580 + ", " + 12 + ", " + 52 + ", Xiaomi, miTv, Blanco, Televisor");
                writer.write(gestorId.assignId() + ", Sony, " + 1000 + ", " + 12 + ", " + 65 + ", Sony, qledTv, Negro, Televisor");
                writer.close();
                System.out.println("Archivo creado");
            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public void addProducto(Producto producto){
        File file = new File("../productos.txt");
        if (file.exists()){
            try {
                if(producto instanceof Altavoz){
                    FileWriter writer = new FileWriter(file);
                    writer.write(producto.getId()+", "+producto.getNombre()+", Acaba el codigo"+", Altavoz"); //SIN ACABAR
                    writer.close();
                }
                if(producto instanceof Ordenador){
                    FileWriter writer = new FileWriter(file);
                    writer.write(producto.getId()+", "+producto.getNombre()+", Acaba el codigo"+", Ordenador"); //SIN ACABAR
                    writer.close();
                }
                if(producto instanceof Smartphone){
                    FileWriter writer = new FileWriter(file);
                    writer.write(producto.getId()+", "+producto.getNombre()+", Acaba el codigo"+", Smartphone"); //SIN ACABAR
                }
                if(producto instanceof Televisor){
                    FileWriter writer = new FileWriter(file);
                    writer.write(producto.getId()+", "+producto.getNombre()+", Acaba el codigo"+", Televisor"); //SIN ACABAR
                }

            }   catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
                e.printStackTrace();
            }
        }
}

    public List<Producto> readProductos(){
        List<Producto> productos = new ArrayList<>();
        try{
            File file = new File("../productos.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                String[] datos = scanner.nextLine().split(", ");
                if(datos[9].equals("Altavoz")){
                    Altavoz altavoz = new Altavoz(Integer.parseInt(datos[0]), datos[1], Double.parseDouble(datos[2]), Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), datos[5], datos[6], datos[7]);
                    productos.add(altavoz);
                }
                if(datos[10].equals("Ordenador")){
                    Ordenador ordenador = new Ordenador(Integer.parseInt(datos[0]), datos[1], Double.parseDouble(datos[2]), Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), Integer.parseInt(datos[5]), datos[6], datos[7], datos[8], datos[9]);
                    productos.add(ordenador);
                }
                if(datos[10].equals("Smartphone")){
                    Smartphone smartphone = new Smartphone(Integer.parseInt(datos[0]), datos[1], Double.parseDouble(datos[2]), Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), Integer.parseInt(datos[5]), datos[5], datos[6], datos[7], datos[8]);
                    productos.add(smartphone);
                }
                if(datos[9].equals("Televisor")){
                    Televisor televisor = new Televisor(Integer.parseInt(datos[0]), datos[1], Double.parseDouble(datos[2]), Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), datos[5], datos[6], datos[7]);
                    productos.add(televisor);
                }
            }
            scanner.close();
        }   catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
            e.printStackTrace();
        }

        return productos;
    }

    public Producto buscarProducto(int id){
        List<Producto> productos = readProductos();
        for (Producto producto : productos) {
            if(producto.getId() == id){
                return producto;
            }
        }
        return null;
    }

    public Producto buscarProducto(String nombre){
        List<Producto> productos = readProductos();
        for (Producto producto : productos) {
            if(producto.getNombre().equals(nombre)){
                return producto;
            }
        }
        return null;
    }

    public Producto buscarProducto(int id, String nombre){
        List<Producto> productos = readProductos();
        for (Producto producto : productos) {
            if(producto.getId() == id && producto.getNombre().equals(nombre)){
                return producto;
            }
        }
        return null;
    }

    public void updateProducto(int id, Producto producto) {
        List<Producto> productos = readProductos();
        for (Producto producto1 : productos) {
            if (producto1.getId() == id) {
                if (producto1 instanceof Altavoz) {
                    Altavoz altavoz = (Altavoz) producto1;
                    Altavoz altavoz1 = (Altavoz) producto;
                    altavoz.setPotencia(altavoz1.getPotencia());
                }
                if (producto1 instanceof Ordenador) {
                    Ordenador ordenador = (Ordenador) producto1;
                    Ordenador ordenador1 = (Ordenador) producto;
                    ordenador.setRam(ordenador1.getRam());
                    ordenador.setAlmacenamiento(ordenador1.getAlmacenamiento());
                    ordenador.setSistemaOperativo(ordenador1.getSistemaOperativo());
                }
                if (producto1 instanceof Smartphone) {
                    Smartphone smartphone = (Smartphone) producto1;
                    Smartphone smartphone1 = (Smartphone) producto;
                    smartphone.setSistemaOperativo(smartphone1.getSistemaOperativo());
                }
                if (producto1 instanceof Televisor) {
                    Televisor televisor = (Televisor) producto1;
                    Televisor televisor1 = (Televisor) producto;
                    televisor.setPulgadas(televisor1.getPulgadas());
                }
            }
        }
        try {
            File file = new File("../productos.txt");
            FileWriter writer = new FileWriter(file);
            for (Producto producto1 : productos) {
                if (producto1 instanceof Altavoz) {
                    writer.write(producto1.getId() + ", " + producto1.getNombre() + ", Acaba el codigo" + ", Altavoz"); //SIN ACABAR
                }
                if (producto1 instanceof Ordenador) {
                    writer.write(producto1.getId() + ", " + producto1.getNombre() + ", Acaba el codigo" + ", Ordenador"); //SIN ACABAR
                }
                if (producto1 instanceof Smartphone) {
                    writer.write(producto1.getId() + ", " + producto1.getNombre() + ", Acaba el codigo" + ", Movil"); //SIN ACABAR
                }
                if (producto1 instanceof Televisor) {
                    writer.write(producto1.getId() + ", " + producto1.getNombre() + ", Acaba el codigo" + ", Televisor"); //SIN ACABAR
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteProducto(int id){
        List<Producto> productos = readProductos();
        for (Producto producto : productos) {
            if(producto.getId() == id){
                productos.remove(producto);
                break;
            }
        }
        try {
            File file = new File("../productos.txt");
            FileWriter writer = new FileWriter(file);
            for (Producto producto : productos) {
                if (producto instanceof Altavoz) {
                    writer.write(producto.getId() + ", " + producto.getNombre() + ", Acaba el codigo" + ", Altavoz"); //SIN ACABAR
                }
                if (producto instanceof Ordenador) {
                    writer.write(producto.getId() + ", " + producto.getNombre() + ", Acaba el codigo" + ", Ordenador"); //SIN ACABAR
                }
                if (producto instanceof Smartphone) {
                    writer.write(producto.getId() + ", " + producto.getNombre() + ", Acaba el codigo" + ", Movil"); //SIN ACABAR
                }
                if (producto instanceof Televisor) {
                    writer.write(producto.getId() + ", " + producto.getNombre() + ", Acaba el codigo" + ", Televisor"); //SIN ACABAR
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void getIdProducto(String nombre){
        for (Producto producto : readProductos()) {
            if(producto.getNombre().equals(nombre)){
                System.out.println(producto.getId());
            }
        }
    }

    public boolean existeProducto(int id){
        if(readProductos().size() <= id){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean existeProducto(String nombre){
        for(int i = 0; i < readProductos().size(); i++){
            if(readProductos().get(i).getNombre() == nombre){
                return true;
            }
        }
        return false;
    }

    public boolean existeProducto(String nombreProducto, int idProducto) {
        for (Producto producto : readProductos()) {
            if (producto.getNombre().equals(nombreProducto) && producto.getId() == idProducto) {
                return true;
            }
        }
        return false;
    }
}
