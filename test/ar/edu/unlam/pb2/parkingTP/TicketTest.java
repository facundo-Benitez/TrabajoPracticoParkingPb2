package ar.edu.unlam.pb2.parkingTP;

import static org.junit.Assert.*;
import java.time.LocalDateTime;

import org.junit.Test;

public class TicketTest {

	@Test
	public void crearCorrectamenteUnTicket() {
		 Integer id=1;
		 LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 22, 50, 0);
		 Integer nroPlaza=30;
		 Tickets ticketClient = new Tickets(id, fechaHoraEntrada, nroPlaza);
		 assertTrue(ticketClient.getId()==1);
	}
	
	@Test
	public void registrarCorrectamenteLaSalidaDeUnVehiculo() {
		 Integer id=1;
		 LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 22, 50, 0);
		 LocalDateTime fechaHoraSalida=LocalDateTime.of(2023, 5, 24, 23, 50, 0);
		 Integer nroPlaza=30;
		 Tickets ticketClient = new Tickets(id, fechaHoraEntrada, nroPlaza);
		 ticketClient.registrarSalida(fechaHoraSalida);
		 assertEquals(fechaHoraSalida, ticketClient.getFechaHoraSalida());
		 

	}

	
	@Test
	public void calcularCorrectamenteElTiempoDeEstadia() {
		 Integer id=1;
		 LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 22, 50, 0);
		 LocalDateTime fechaHoraSalida=LocalDateTime.of(2023, 5, 24, 23, 50, 0);
		 Integer nroPlaza=30;
		 Tickets ticketClient = new Tickets(id, fechaHoraEntrada, nroPlaza);
		 ticketClient.registrarSalida(fechaHoraSalida);
		 Integer estadiaEnMinutos=ticketClient.calculoTiempoEstadiaEnMinutos();
		 /* 
	     long minutos =(int) a.toMinutes();
	     long segundos = a.getSeconds();*/
	     assertTrue(estadiaEnMinutos==60);
	}

	@Test
	public void imprimirTicket() throws VehiculoNoEncontradoException {
		Integer id=1;
		String patente="abc123";
		LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 21, 00, 0);
		LocalDateTime fechaHoraSalida=LocalDateTime.of(2023, 5, 24, 23, 50, 0);
		Integer nroDePlaza=30;
	
		Estacionamiento estacionamiento = new Estacionamiento("E");
		Auto auto= new Auto(patente, TipoDeVehiculo.AUTO,null);
		estacionamiento.agregarVehiculo(auto);
		Tickets ticketCliente=estacionamiento.generarTickets(id,fechaHoraEntrada,nroDePlaza);
		estacionamiento.asignarUnTicketAUnVehiculo("abc123",ticketCliente);
		ticketCliente.registrarSalida(fechaHoraSalida);
		
		ticketCliente.imprimirTicket();

	}

}
