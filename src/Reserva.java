import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

        if (!validarFechas(fechaInicio, fechaFin)) {
            System.out.println("La fecha de fin debe ser posterior a la fecha de inicio.");
            sc.close();
            return;
        }

        boolean tieneReservaSuperpuesta = false;

        if (!validarDisponibilidad(tieneReservaSuperpuesta)) {
            System.out.println("El vehiculo no esta disponible en el periodo seleccionado.");
            sc.close();
            return;
        }

        System.out.print("Ingrese precio por dia: ");
        double precioDia = sc.nextDouble();

        double costoEstimado = calcularCostoEstimado(fechaInicio, fechaFin, precioDia);

        System.out.println("\nReserva registrada correctamente.");
        System.out.println("Usuario: " + usuarioId);
        System.out.println("Vehiculo: " + vehiculoId);
        System.out.println("Fecha de inicio: " + fechaInicio);
        System.out.println("Fecha de fin: " + fechaFin);
        System.out.println("Estado: Vehiculo disponible");
        System.out.println("Costo estimado: S/ " + costoEstimado);

        sc.close();
    }

    public static boolean validarFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return fechaFin.isAfter(fechaInicio);
    }

    public static boolean validarDisponibilidad(boolean tieneReservaSuperpuesta) {
        return !tieneReservaSuperpuesta;
    }

    public static double calcularCostoEstimado(
            LocalDate fechaInicio,
            LocalDate fechaFin,
            double precioDia) {

        long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        return dias * precioDia;
    }
}
