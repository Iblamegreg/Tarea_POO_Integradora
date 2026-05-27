package servicio;
import modelo.Administrativo;
import modelo.Empleado;
import modelo.Medico;
import java.util.ArrayList;

public class EmpleadoServicio {
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public void registrarEmpleado(Empleado e) {
        for (Empleado emp : empleados) {
            if (emp.getCedula().equals(e.getCedula())) {
                System.out.println("Error: La cédula ya existe. Registro bloqueado.");
                return;
            }
        }
        empleados.add(e);
        System.out.println("Empleado registrado con éxito.");
    }

    public void mostrarRegistros() {
        if (empleados.isEmpty()) { System.out.println("No hay registros."); return; }
        for (Empleado e : empleados) { e.mostrarInformacion(); }
    }

    public Empleado buscarPorCedula(String cedula) {
        for (Empleado e : empleados) {
            if (e.getCedula().equals(cedula)) return e;
        }
        return null;
    }

    public void eliminarRegistro(String cedula) {
        Empleado e = buscarPorCedula(cedula);
        if (e != null) {
            empleados.remove(e);
            System.out.println("Registro eliminado.");
        } else {
            System.out.println("Registro no encontrado.");
        }
    }

    public void mostrarEstadisticas() {
        int totalMedicos = 0, totalAdmins = 0;
        double pagoMedicos = 0, pagoAdmins = 0, mayorIngreso = 0;
        String empMayorIngreso = "";

        for (Empleado e : empleados) {
            double pago = e.calcularPago();
            if (e instanceof Medico) {
                totalMedicos++;
                pagoMedicos += pago;
            } else if (e instanceof Administrativo) {
                totalAdmins++;
                pagoAdmins += pago;
            }
            if (pago > mayorIngreso) {
                mayorIngreso = pago;
                empMayorIngreso = e.getCedula(); // O el nombre
            }
        }

        System.out.println("--- Estadísticas ---");
        System.out.println("Total médicos: " + totalMedicos);
        System.out.println("Total administrativos: " + totalAdmins);
        System.out.println("Total empleados: " + empleados.size());
        System.out.println("Pago total médicos: $" + pagoMedicos);
        System.out.println("Pago total administrativos: $" + pagoAdmins);
        System.out.println("Cédula empleado con mayor ingreso: " + empMayorIngreso + " ($" + mayorIngreso + ")");
    }
}