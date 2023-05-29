package cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class GestorClientes {

    public void inicializarClientes() {
        File file = new File("../clientes.txt");
        if (file.exists()) {
            System.out.println("El archivo esta inicializado");
        } else {
            try {
                FileWriter writer = new FileWriter(file);
                writer.write("Aaron, Garcia, 23459934Q, Calle Real 23, 627384654, aarongarcia@gmail.com, aarongarcia, 1234\n");
                writer.write("Carlota, Fernandez, 84273345I, Calle Mayor 12, 638511033, carlotafernandez@gmail.com, carlotafernandez, 1234");
                writer.close();
                System.out.println("Archivo creado");
            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void addCliente(Cliente cliente) {
        File file = new File("../clientes.txt");
        if (file.exists()) {
            try {
                FileWriter writer = new FileWriter(file);
                writer.write(cliente.getNombre() + ", " + cliente.getApellidos() + ", " + cliente.getDni() + ", " + cliente.getDireccion() + ", " + cliente.getTelefono() + ", " + cliente.getEmail() + ", " + cliente.getUsuario() + ", " + cliente.getContraseña());
                writer.close();
                System.out.println("Cliente añadido");
            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo no existe");
        }
    }


    public List<Cliente> readClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            File file = new File("../clientes.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(", ");
                Cliente cliente = new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], datos[7]);
                clientes.add(cliente);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe");
            e.printStackTrace();
        }
    return clientes;
    }


    public Cliente buscarCliente(String user) {
        List<Cliente> clientes = new ArrayList<>();
        try{
            File file = new File("../clientes.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(", ");
                Cliente cliente = new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], datos[7]);
                clientes.add(cliente);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe");
            e.printStackTrace();
        }

        for(int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getUsuario().equals(user)) {
                Cliente clienteBuscado = clientes.get(i);
                return clienteBuscado;
            }
        }
        return null;
    }

    public Cliente buscarClienteDni(String dni){
        List<Cliente> clientes = new ArrayList<>();
        try{
            File file = new File("../clientes.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(", ");
                Cliente cliente = new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], datos[7]);
                clientes.add(cliente);
            }
            scanner.close();
        }   catch (IOException e) {
            System.out.println("El archivo no existe");
            e.printStackTrace();
        }

        for(int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDni().equals(dni)) {
                Cliente clienteBuscado = clientes.get(i);
                return clienteBuscado;
            }
        }
        Cliente noexiste = new Cliente("No existe", "No existe", "No existe", "No existe", "No existe", "No existe", "No existe", "No existe");
        return noexiste;
    }



    public void updateCliente(String dniModificar, Cliente clienteNuevo){
        List<Cliente> clientes = new ArrayList<>();
        try{
            File file = new File("../clientes.txt");
            Scanner scanner = new Scanner(file);
while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(", ");
                Cliente cliente = new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], datos[7]);
                clientes.add(cliente);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe");
            e.printStackTrace();
        }

        for(int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDni().equals(dniModificar)) {
                clientes.set(i, clienteNuevo);
            }
        }

        try {
            PrintWriter writer = new PrintWriter("clientes.txt");
            writer.print("");
            writer.close();

            PrintWriter out = new PrintWriter("clientes.txt");
            for (Cliente cliente : clientes) {
                out.println(cliente.getNombre() + ", " + cliente.getApellidos() + ", " + cliente.getDni() + ", "
                        + cliente.getDireccion() + ", " + cliente.getTelefono() + ", " + cliente.getEmail() + ", "
                        + cliente.getUsuario() + ", " + cliente.getContraseña());
            }
            out.close();

            Scanner scanner = new Scanner(new File("../clientes.txt"));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe.");
            e.printStackTrace();
        }
    }

    public void deleteCliente(String dni) {
        File archivoTemporal = new File("../clientes_temp.txt");

        try {
            BufferedReader lector = new BufferedReader(new FileReader("../clientes.txt"));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal));

            String lineaActual;

            while ((lineaActual = lector.readLine()) != null) {
                String[] atributos = lineaActual.split(", ");

                if (!atributos[2].equals(dni)) {
                    escritor.write(lineaActual);
                    escritor.newLine();
                }
            }

            lector.close();
            escritor.close();

            File archivoOriginal = new File("../clientes.txt");
            archivoTemporal.renameTo(archivoOriginal);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean authentificarCliente(String usuario, String contraseña) {
        Cliente clienteAuthentificar = buscarCliente(usuario);
        if(clienteAuthentificar.getContraseña().equals(contraseña))
            return true;
        else
            return false;
    }
    public boolean existeUsuario(String usuario) {
        List<Cliente> clienteList = readClientes();
        for (int i = 0; i < clienteList.size(); i++) {
            if (clienteList.get(i).getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }



    }

