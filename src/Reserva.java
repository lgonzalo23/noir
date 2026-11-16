import java.time.LocalDate;
import java.util.Scanner;

public class Reserva {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese ID del usuario: ");
        long usuarioId = sc.nextLong();

        System.out.print("Ingrese ID del vehiculo: ");
        long vehiculoId = sc.nextLong();

        System.out.print("Ingrese fecha de inicio (AAAA-MM-DD): ");
        LocalDate fechaInicio = LocalDate.parse(sc.next());

        System.out.print("Ingrese fecha de fin (AAAA-MM-DD): ");
        LocalDate fechaFin = LocalDate.parse(sc.next());

        System.out.println("\nReserva registrada correctamente.");
        System.out.println("Usuario: " + usuarioId);
        System.out.println("Vehiculo: " + vehiculoId);
        System.out.println("Fecha de inicio: " + fechaInicio);
        System.out.println("Fecha de fin: " + fechaFin);

        sc.close();
    }
}
