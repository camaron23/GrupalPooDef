package empleado;

import cliente.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class GestorEmpleados {

    public void inicializarEmpleados() {
        File file = new File("../empleados.txt");
        if (file.exists()) {
            System.out.println("El archivo esta inicializado");
        } else {
            try {
                FileWriter writer = new FileWriter(file);
                writer.write("Mario, Perez, 12345678A, Calle Tajo 6, 654433234, marioperez@gmail.com, Encargado, 1500, 1234, true");
                writer.write("\nMaria, Garcia, 3726349I, Calle Jarama 21, 635522333, mariagarcia@gmail.com, Cajera, 1200, 1234, false");
                writer.close();
                System.out.println("Archivo creado");
            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void addEmpleado(Empleado empleado) {
        File file = new File("../empleados.txt");
        if (file.exists()) {
            try {
                FileWriter writer = new FileWriter(file, true);
                writer.write("\n" + empleado.getNombre() + ", " + empleado.getApellidos() + ", " + empleado.getDni() + ", " + empleado.getDireccion() + ", " + empleado.getTelefono() + ", " + empleado.getEmail() + ", " + empleado.getPuesto() + ", " + empleado.getSalario() + ", " + empleado.getContraseña() + ", " + empleado.isPrivilegios()+"\n");
                writer.close();
                System.out.println("Empleado añadido");
            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo no existe");
        }
    }

    public List<Empleado> readEmpleados(){
        List<Empleado> empleados = new ArrayList<>();
        try{
            File file = new File("../empleados.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String[] datos = scanner.nextLine().split(", ");
                Empleado empleado = new Empleado(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], Double.parseDouble(datos[7]), datos[8], Boolean.parseBoolean(datos[9]));
                empleados.add(empleado);
            }
            scanner.close();
            return empleados;
        } catch (FileNotFoundException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
            e.printStackTrace();
        }
    return empleados;
    }

    public Empleado buscarEmpleado(String dni){
        List<Empleado> empleados = new ArrayList<>();
        try {
            File file = new File("../empleados.txt");
            if (!file.exists()) {
                inicializarEmpleados();
            }
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(", ");
                Empleado empleado = new Empleado(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], Double.parseDouble(datos[7]), datos[8], Boolean.parseBoolean(datos[9]));
                empleados.add(empleado);
            }
            scanner.close();
        }   catch (FileNotFoundException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
            e.printStackTrace();
        }
        for (int i = 0; i < empleados.size(); i++){
            System.out.println(empleados.get(i).toString());
        }
        for(int i = 0; i < empleados.size(); i++){
            if(empleados.get(i).getDni().equals(dni)){
                return empleados.get(i);
            }
        }
        return null;
    }

    public void updateEmpleado(String dniModificar, Empleado empleadoNuevo){
        List<Empleado> empleados = new ArrayList<>();
        try{
            File file = new File("../empleados.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String[] datos = scanner.nextLine().split(", ");
                Empleado empleado = new Empleado(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6], Double.parseDouble(datos[7]), datos[8], Boolean.parseBoolean(datos[9]));
                empleados.add(empleado);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
            e.printStackTrace();
        }

        for (int i = 0; i < empleados.size(); i++){
            if(empleados.get(i).getDni().equals(dniModificar)){
                empleados.set(i, empleadoNuevo);
            }
        }

        try{
            PrintWriter writer = new PrintWriter("../empleados.txt");
            writer.print("");
            writer.close();

            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("../empleados.txt", true)));
            for (int i = 0; i < empleados.size(); i++){
                out.println(empleados.get(i).getNombre() + ", " + empleados.get(i).getApellidos() + ", " + empleados.get(i).getDni() + ", " + empleados.get(i).getDireccion() + ", " + empleados.get(i).getTelefono() + ", " + empleados.get(i).getEmail() + ", " + empleados.get(i).getPuesto() + ", " + empleados.get(i).getSalario() + ", " + empleados.get(i).getContraseña() + ", " + empleados.get(i).isPrivilegios());
            }
            out.close();

            Scanner scanner = new Scanner(new File("../empleados.txt"));
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("El archivo no existe.");
            e.printStackTrace();
        }
    }

    public void deleteEmpleado(String dni){
        File inputFile = new File("../empleados.txt");
        File tempFile = new File("../empleadosTemporal.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split(", ");
                if (!data[2].equals(dni)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
            System.out.println("Empleado eliminado");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean authentificarEmpleado(String dni, String contraseña) {
        Empleado empleadoAuthentificar = buscarEmpleado(dni);
        if (empleadoAuthentificar != null) {
            if (empleadoAuthentificar.getContraseña().equals(contraseña)) {
                return true;
            }
        }
        else{
            System.out.println("Credenciales incorrectas");
            return false;
        }
        return false;
    }

    public boolean existeEmpleado(String dni){
        Empleado empleadoAuthentificar = buscarEmpleado(dni);
        if(empleadoAuthentificar != null){
            return true;
        } else {
            return false;
        }
    }

}


