package ar.edu.unlam.pb2.parkingTP;

import static org.junit.Assert.*;

import java.awt.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Test;

public class EstacionamientoTest {

	@Test
	public void QueSePuedaCrearUnEstacionamiento() {
		String nombreEstacionamiento = "Parking";

		Estacionamiento estacionamiento = new Estacionamiento(nombreEstacionamiento);

		assertNotNull(estacionamiento);
		assertEquals(nombreEstacionamiento, estacionamiento.getNombreEstacionamiento());

	}

	@Test
	public void testObetenerGananciaTotal() {
		Estacionamiento estacionamiento = new Estacionamiento();

		// Crear algunos tickets
		Ticket ticket1 = new Ticket(1, LocalDateTime.now().minusHours(3), LocalDateTime.now(), 1, 6000.0);
		Ticket ticket2 = new Ticket(2, LocalDateTime.now().minusHours(2), LocalDateTime.now(), 2, 2000.0);

		// Asignar los tickets al estacionamiento
		estacionamiento.agregarTicket(ticket1);
		estacionamiento.agregarTicket(ticket2);

		// Calcular el costo esperado
		double costoEsperado = 6000.0 + 2000.0;

		// Verificar que la ganancia total es la suma de los costos de los tickets
		assertEquals(costoEsperado, estacionamiento.getGananciaTotal(), 0.0);
	}

	@Test
	public void testQueSePuedaAsociarLosVehiculosConLosTickets() {
		// Crear instancias de vehículos
		Auto auto = new Auto(1, null);
		Bici bici = new Bici();
		Moto moto = new Moto();

		// Crear instancias de tickets y asociar vehículos
		Ticket ticket1 = new Ticket(1, LocalDateTime.now().minusHours(3), LocalDateTime.now(), 3, 2000.0);
		ticket1.setVehiculo(auto);

		Ticket ticket2 = new Ticket(2, LocalDateTime.now().minusHours(2), LocalDateTime.now(), 1, 1000.0);
		ticket2.setVehiculo(bici);

		Ticket ticket3 = new Ticket(3, LocalDateTime.now().minusHours(1), LocalDateTime.now(), 2, 1500.0);
		ticket3.setVehiculo(moto);

		// Crear estacionamiento y agregar tickets
		Estacionamiento estacionamiento = new Estacionamiento();
		estacionamiento.agregarTicket(ticket1);
		estacionamiento.agregarTicket(ticket2);
		estacionamiento.agregarTicket(ticket3);

		// Verificar que los vehiculos de cada ticket sean los asociados
		assertEquals(3, estacionamiento.getTickets().size());
		assertEquals("Auto", ticket1.getVehiculo().getClass().getSimpleName());
		assertEquals("Bici", ticket2.getVehiculo().getClass().getSimpleName());
		assertEquals("Moto", ticket3.getVehiculo().getClass().getSimpleName());

	}

	@Test
	public void testQueSePuedanObtenerLosDatosDeUnVehiculoPorElNumeroDePlaza() {
		// Crear instancias de vehículos
		Auto auto = new Auto(1, null);
		Bici bici = new Bici();
		Moto moto = new Moto();

		// Crear instancias de tickets y asociar vehículos
		Ticket ticket1 = new Ticket(1, LocalDateTime.now().minusHours(3), LocalDateTime.now(), 3, 2000.0);
		ticket1.setVehiculo(auto);

		Ticket ticket2 = new Ticket(2, LocalDateTime.now().minusHours(2), LocalDateTime.now(), 1, 1000.0);
		ticket2.setVehiculo(bici);

		Ticket ticket3 = new Ticket(3, LocalDateTime.now().minusHours(1), LocalDateTime.now(), 2, 1500.0);
		ticket3.setVehiculo(moto);

		// Crear una instancia de estacionamiento y agregar tickets
		Estacionamiento estacionamiento = new Estacionamiento();
		estacionamiento.agregarTicket(ticket1);
		estacionamiento.agregarTicket(ticket2);
		estacionamiento.agregarTicket(ticket3);

		// Obtener los datos de un vehículo por número de plaza
		String datosVehiculoAuto = estacionamiento.obtenerDatosVehiculoPorNumeroPlaza(3);
		String datosVehiculoBici = estacionamiento.obtenerDatosVehiculoPorNumeroPlaza(1);
		String datosVehiculoMoto = estacionamiento.obtenerDatosVehiculoPorNumeroPlaza(2);

		// Verificar los datos obtenidos
		assertEquals("Auto, Plaza: 3", datosVehiculoAuto);
		assertEquals("Bici, Plaza: 1", datosVehiculoBici);
		assertEquals("Moto, Plaza: 2", datosVehiculoMoto);
	}

	@Test
	public void testQueExistiendoVehiculosEnElEstacionamientoSeBusqueUnAutoPorPatenteExistente() {
		// Crear instancias de vehículos
		Auto auto1 = new Auto(1, "ABC123");
		Auto auto2 = new Auto(2, "DEF456");
		Bici bici = new Bici();
		Moto moto = new Moto();

		// Crear instancias de tickets y asociar vehículos
		Ticket ticket1 = new Ticket(1, LocalDateTime.now().minusHours(3), LocalDateTime.now(), 3, 2000.0);
		ticket1.setVehiculo(auto1);

		Ticket ticket2 = new Ticket(2, LocalDateTime.now().minusHours(2), LocalDateTime.now(), 1, 1000.0);
		ticket2.setVehiculo(bici);

		Ticket ticket3 = new Ticket(3, LocalDateTime.now().minusHours(1), LocalDateTime.now(), 2, 1500.0);
		ticket3.setVehiculo(moto);

		Ticket ticket4 = new Ticket(4, LocalDateTime.now().minusHours(2), LocalDateTime.now(), 4, 2500.0);
		ticket4.setVehiculo(auto2);

		// Crear una instancia de estacionamiento y agregar tickets
		Estacionamiento estacionamiento = new Estacionamiento();
		estacionamiento.agregarTicket(ticket1);
		estacionamiento.agregarTicket(ticket2);
		estacionamiento.agregarTicket(ticket3);
		estacionamiento.agregarTicket(ticket4);

		// Buscar un auto por una patente existente
		Auto autoEncontrado = estacionamiento.buscarAutoPorPatente("ABC123");

		// Verificar que se haya encontrado el auto correcto
		assertEquals(auto1, autoEncontrado);
	}
}
