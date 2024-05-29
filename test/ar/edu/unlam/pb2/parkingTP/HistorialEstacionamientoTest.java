package ar.edu.unlam.pb2.parkingTP;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.Set;

import org.junit.Test;

public class HistorialEstacionamientoTest {

	@Test
	public void testQueSePuedaCrearUnHistorialDelEstacionamiento() {
		Estacionamiento estacionamiento = new Estacionamiento();

		// Crear algunos tickets
		Ticket ticket1 = new Ticket(1, LocalDateTime.now().minusHours(3), LocalDateTime.now(), 1, 6000.0);
		Ticket ticket2 = new Ticket(2, LocalDateTime.now().minusHours(2), LocalDateTime.now(), 2, 2000.0);

		// Poner los tickets al estacionamiento
		estacionamiento.agregarTicket(ticket1);
		estacionamiento.agregarTicket(ticket2);

		// Generar el historial del estacionamiento
		HistorialDelEstacionamiento historial = estacionamiento.generarHistorial();

		// Verificar que el historial no es nulo
		assertNotNull(historial);

		// Verificar que el historial contiene los mismos tickets que el estacionamiento
		Set<Ticket> ticketsHistorial = historial.getHistorialTickets();
		assertEquals(2, ticketsHistorial.size());
		assertEquals(estacionamiento.getGananciaTotal(), ticketsHistorial.stream().mapToDouble(Ticket::getCosto).sum(),
				0.01);
	}
}
