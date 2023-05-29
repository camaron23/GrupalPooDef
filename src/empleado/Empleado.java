package empleado;

public class Empleado {
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private String telefono;
    private String email;
    private String puesto;
    private double salario;
    private String contraseña;
    private boolean privilegios;

    public Empleado(String nombre, String apellidos, String dni, String direccion, String telefono, String email, String puesto, double salario, String contraseña, boolean privilegios) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.puesto = puesto;
        this.salario = salario;
        this.contraseña = contraseña;
        this.privilegios = privilegios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }


    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(boolean privilegios) {
        this.privilegios = privilegios;
    }

    @Override
    public String toString() {
        return "Empleado [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", direccion=" + direccion +
                ", telefono=" + telefono + ", email=" + email + ", puesto=" + puesto + ", salario=" + salario + ", contraseña=" + contraseña +
                ", privilegios=" + privilegios + "]";
    }

    public String isPrivilegios() {
        if(privilegios == true) {
            return "true";
        } else {
            return "false";
        }
    }
}
