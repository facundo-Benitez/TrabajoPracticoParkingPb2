package ar.edu.unlam.pb2.parkingTP;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class HistorialEstacionamientoTest {

	@Test
	public void testQueSePuedaCrearUnHistorialDelEstacionamiento() {
		Integer idHistorial=1;
		LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 22, 50, 0);
		LocalDateTime fechaHoraSalida=LocalDateTime.of(2023, 5, 24, 23, 50, 0);
		Integer nroDePlaza=1;
		String seccion="zona a";
		Boolean estaOcupado=true;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;
		String patente="AJ123A3";
		String nombre="juan";
		String telefono="+54912312456";
		
		Estacionamiento estacionamiento = new Estacionamiento("E");
		
		// Creo ticket
		Tickets ticketClient = new Tickets(1, fechaHoraEntrada, fechaHoraSalida, 1);
		// Creo plaza de estacionamiento
		Plaza plaza= new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		VehiculoPlaza lugarParaEstacionamiento=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza);
		//Creo auto
		Vehiculo auto=new Auto(patente,tipo,ticketClient);
		//Creo cliente
		Cliente cliente=new Cliente(nombre,telefono);
		//Creo el historial
		HistorialDelEstacionamiento historial = estacionamiento.generarHistorial(idHistorial,ticketClient,lugarParaEstacionamiento,auto,cliente);

		// Verificar que el historial no es nulo
		assertNotNull(historial);
		// Verificar los datos del historial
		assertEquals(idHistorial, historial.getIdHistorial());
		assertEquals(ticketClient, historial.getTicketGenerado());
		assertEquals(lugarParaEstacionamiento,historial.getPlazaDeEstacionamiento());
		assertEquals(auto,historial.getVehiculoEstacionado());
		assertEquals(cliente,historial.getCliente());
	}
	
}
