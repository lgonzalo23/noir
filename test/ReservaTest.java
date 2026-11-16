import java.time.LocalDate;

public class ReservaTest {

    public static void main(String[] args) {

        assert Reserva.validarFechas(
                LocalDate.of(2026, 11, 10),
                LocalDate.of(2026, 11, 13)
        );

        assert !Reserva.validarFechas(
                LocalDate.of(2026, 11, 15),
                LocalDate.of(2026, 11, 10)
        );

        assert Reserva.validarDisponibilidad(false);
        assert !Reserva.validarDisponibilidad(true);

        assert Reserva.calcularCostoEstimado(
                LocalDate.of(2026, 11, 10),
                LocalDate.of(2026, 11, 13),
                200.0
        ) == 600.0;

        System.out.println("Todas las pruebas pasaron.");
    }
}
