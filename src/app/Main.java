package app;
import modelo.Administrativo;
import modelo.Medico;
import servicio.EmpleadoServicio;
import util.Validador;

public class Main {
    public static void main(String[] args) {
        EmpleadoServicio servicio = new EmpleadoServicio();
        int opcion = 0;

        do {
            System.out.println("\n===== CLÍNICA SALUD TOTAL =====");
            System.out.println("1. Registrar médico");
            System.out.println("2. Registrar administrativo");
            System.out.println("3. Mostrar empleados");
            System.out.println("4. Buscar por cédula");
            System.out.println("5. Reemplazar información");
            System.out.println("6. Eliminar registro");
            System.out.println("7. Calcular pagos");
            System.out.println("8. Mostrar estadísticas");
            System.out.println("9. Salir");

            opcion = Validador.leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    // Solicitar datos (agregando validaciones positivas con bucles en Validador para mayor robustness)
                    String cedM = Validador.leerTextoNoVacio("Cédula: ");
                    String nomM = Validador.leerTextoNoVacio("Nombre: ");
                    int edadM = Validador.leerEdad("Edad: ");
                    String telM = Validador.leerTelefono("Teléfono: ");
                    String corrM = Validador.leerCorreo("Correo: ");
                    String esp = Validador.leerTextoNoVacio("Especialidad: ");
                    int pac = Validador.leerEntero("Pacientes atendidos: ");
                    double valCons = Validador.leerDouble("Valor por consulta: ");
                    if(pac > 0 && valCons > 0) {
                        servicio.registrarEmpleado(new Medico(cedM, nomM, edadM, telM, corrM, esp, pac, valCons));
                    } else {
                        System.out.println("Error: Valores deben ser mayores a cero. Volver a pedir.");
                    }
                    break;
                case 2:
                    String cedA = Validador.leerTextoNoVacio("Cédula: ");
                    String nomA = Validador.leerTextoNoVacio("Nombre: ");
                    int edadA = Validador.leerEdad("Edad: ");
                    String telA = Validador.leerTelefono("Teléfono: ");
                    String corrA = Validador.leerCorreo("Correo: ");
                    String dep = Validador.leerTextoNoVacio("Departamento: ");
                    int hrs = Validador.leerEntero("Horas trabajadas: ");
                    double valHr = Validador.leerDouble("Valor por hora: ");
                    if(hrs > 0 && valHr > 0) {
                        servicio.registrarEmpleado(new Administrativo(cedA, nomA, edadA, telA, corrA, dep, hrs, valHr));
                    } else {
                        System.out.println("Error: Valores deben ser mayores a cero. Volver a pedir.");
                    }
                    break;
                case 3:
                    servicio.mostrarRegistros();
                    break;
                case 4:
                    String cBuscar = Validador.leerTextoNoVacio("Ingrese cédula a buscar: ");
                    modelo.Empleado emp = servicio.buscarPorCedula(cBuscar);
                    if (emp != null) emp.mostrarInformacion();
                    else System.out.println("Registro no encontrado.");
                    break;
                case 6:
                    String cEliminar = Validador.leerTextoNoVacio("Ingrese cédula a eliminar: ");
                    servicio.eliminarRegistro(cEliminar);
                    break;
                case 7:
                    // Cálculo se procesa al mostrar registros
                    System.out.println("Pagos calculados. Utilice la opción 3 para verlos junto a cada empleado.");
                    break;
                case 8:
                    servicio.mostrarEstadisticas();
                    break;
                case 9:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Error: opción inválida.");
            }
        } while (opcion != 9);
    }
}