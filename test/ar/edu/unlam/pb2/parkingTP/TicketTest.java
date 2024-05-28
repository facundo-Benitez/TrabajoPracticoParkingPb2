package ar.edu.unlam.pb2.parkingTP;

import static org.junit.Assert.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Test;

public class TicketTest {

@Test
	public void crearCorrectamenteUnTicket() {
		 Integer id=1;
		 LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 22, 50, 0);
		 LocalDateTime fechaHoraSalida=LocalDateTime.of(2023, 5, 24, 23, 50, 0);
		 Integer nroPlaza=30;
		 Double costo=10.5;
		 Ticket ticketClient = new Ticket(id, fechaHoraEntrada, fechaHoraSalida, nroPlaza, costo);
		 assertTrue(ticketClient.getId()==1);
	}
	
	@Test
	public void calcularCorrectamenteElTiempoDeEstadia() {
		 Integer id=1;
		 LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 22, 50, 0);
		 LocalDateTime fechaHoraSalida=LocalDateTime.of(2023, 5, 24, 23, 50, 0);
		 Integer nroPlaza=30;
		 Double costo=10.5;
		 Ticket ticketClient = new Ticket(id, fechaHoraEntrada, fechaHoraSalida, nroPlaza, costo);
		 Duration a=ticketClient.calculoTiempoEstadia();
	     long minutos =(int) a.toMinutes();
	     long segundos = a.getSeconds();
	     assertTrue(minutos==60);
	}
	
	
	@Test
	public void calcularElCostoDeLaEstadia() {
		Integer id=1;
		LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 22, 50, 0);
		LocalDateTime fechaHoraSalida=LocalDateTime.of(2023, 5, 24, 23, 50, 0);
		Integer nroPlaza=30;
		Double costo=10.5;
		Ticket ticketClient = new Ticket(id, fechaHoraEntrada, fechaHoraSalida, nroPlaza, costo);
		Auto auto= new Auto(id);
		double valor=ticketClient.getValorVehiculo(auto);
		assertTrue(valor==2000.0);

	}

}
