const formulario = document.getElementById("reservaForm");
const resultado = document.getElementById("resultado");

formulario.addEventListener("submit", function (event) {
    event.preventDefault();

    const fechaInicio = new Date(document.getElementById("fechaInicio").value);
    const fechaFin = new Date(document.getElementById("fechaFin").value);
    const precioDia = Number(document.getElementById("vehiculo").value);

    if (fechaFin <= fechaInicio) {
        resultado.classList.remove("oculto");
        resultado.innerHTML = "La fecha de fin debe ser posterior a la fecha de inicio.";
        return;
    }

    const milisegundosPorDia = 1000 * 60 * 60 * 24;
    const dias = Math.round((fechaFin - fechaInicio) / milisegundosPorDia);
    const costo = dias * precioDia;

    resultado.classList.remove("oculto");
    resultado.innerHTML =
        "<strong>Vehículo disponible</strong><br>" +
        "Días de reserva: " + dias + "<br>" +
        "Costo estimado: S/ " + costo.toFixed(2);
});
