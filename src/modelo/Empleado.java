package modelo;

public abstract class Empleado {
    private String cedula;
    private String nombre;
    private int edad;
    private String telefono;
    private String correo;

    public Empleado(String cedula, String nombre, int edad, String telefono, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    // Métodos abstractos y de instancia
    public void mostrarInformacion() {
        System.out.println("Cédula: " + cedula + " | Nombre: " + nombre + " | Edad: " + edad + " | Tel: " + telefono + " | Correo: " + correo);
    }

    public abstract double calcularPago();
}