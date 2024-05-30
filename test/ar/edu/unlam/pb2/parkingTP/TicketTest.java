package ar.edu.unlam.pb2.parkingTP;

import static org.junit.Assert.*;
import java.time.Duration;
import java.time.LocalDateTime;


import org.junit.Test;

public class TicketTest {

	@Test
	public void crearCorrectamenteUnTicket() {
		 Integer id=1;
		 LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 22, 50, 0);
		 LocalDateTime fechaHoraSalida=LocalDateTime.of(2023, 5, 24, 23, 50, 0);
		 Integer nroPlaza=30;
		 Double costo=10.5;
		 Tickets ticketClient = new Tickets(id, fechaHoraEntrada, nroPlaza);
		 assertTrue(ticketClient.getId()==1);
	}
	
	@Test
	public void registrarCorrectamenteLaSalidaDeUnVehiculo() {
		 Integer id=1;
		 LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 22, 50, 0);
		 LocalDateTime fechaHoraSalida=LocalDateTime.of(2023, 5, 24, 23, 50, 0);
		 Integer nroPlaza=30;
		 Double costo=10.5;
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
		 Double costo=10.5;
		 Tickets ticketClient = new Tickets(id, fechaHoraEntrada, nroPlaza);
		 Integer estadiaEnMinutos=ticketClient.calculoTiempoEstadiaEnMinutos();
		 /* 
	     long minutos =(int) a.toMinutes();
	     long segundos = a.getSeconds();*/
	     assertTrue(estadiaEnMinutos==60);
	}
	
	
	@Test
	public void calcularElCostoDeLaEstadiaDeUnChoche() {
		Integer id=1;
		String patente="abc123";
		LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 22, 50, 0);
		LocalDateTime fechaHoraSalida=LocalDateTime.of(2023, 5, 24, 23, 50, 0);
		Integer nroPlaza=30;
		Double costo=10.5;
		Tickets ticketClient = new Tickets(id, fechaHoraEntrada, nroPlaza);
		Auto auto= new Auto(patente, TipoDeVehiculo.AUTO);
		double valor=ticketClient.getValorVehiculo(auto);
		assertTrue(valor==2000.0);

	}

	@Test
	public void cobrarCorrectamenteLaEstadiaEnBaseVehiculoYTiempo() {
		Integer id=1;
		String patente="abc123";
		LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 21, 00, 0);
		LocalDateTime fechaHoraSalida=LocalDateTime.of(2023, 5, 24, 23, 50, 0);
		Integer nroPlaza=30;
		Double costo=10.5;
		Tickets ticketClient = new Tickets(id, fechaHoraEntrada, nroPlaza);
		Auto auto= new Auto(patente, TipoDeVehiculo.AUTO);
		Double valorTotal=0.0;
		if(ticketClient.registrarSalida(fechaHoraSalida)){
			valorTotal=ticketClient.calcularCosto(auto);
		 
			System.out.println(ticketClient.getCosto());
			System.out.println("valor total "+ticketClient.calcularCosto(auto));
			System.out.println("estadia en minutos "+ticketClient.calculoTiempoEstadiaEnMinutos());
		}
		
		assertEquals(5666.6,valorTotal,0.10);
	}

}
