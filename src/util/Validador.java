package util;
import java.util.Scanner;

public class Validador {
    private static Scanner sc = new Scanner(System.in);

    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número válido.");
            }
        }
    }

    public static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número decimal válido.");
            }
        }
    }

    public static String leerTextoNoVacio(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();
            if (!texto.isEmpty()) return texto;
            System.out.println("Error: El campo no puede estar vacío.");
        }
    }

    public static String leerCorreo(String mensaje) {
        while (true) {
            String correo = leerTextoNoVacio(mensaje);
            if (correo.contains("@")) return correo;
            System.out.println("Error: El correo debe contener '@'.");
        }
    }

    public static String leerTelefono(String mensaje) {
        while (true) {
            String tel = leerTextoNoVacio(mensaje);
            if (tel.matches("\\d+")) return tel;
            System.out.println("Error: El teléfono solo debe contener números.");
        }
    }

    public static int leerEdad(String mensaje) {
        while (true) {
            int edad = leerEntero(mensaje);
            if (edad > 0 && edad < 150) return edad;
            System.out.println("Error: Edad fuera de rango válido (1-149).");
        }
    }
}