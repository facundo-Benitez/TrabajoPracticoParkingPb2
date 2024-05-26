package ar.edu.unlam.pb2.parkingTP;

import static org.junit.Assert.*;

import org.junit.Test;

public class EstacionamientoTest {

	@Test 
	public void QueSePuedaCrearUnEstacionamiento() {	
		String nombreEstacionamiento = "Parking";
		
		Estacionamiento estacionamiento = new Estacionamiento(nombreEstacionamiento);

		assertNotNull(estacionamiento);
		assertEquals(nombreEstacionamiento,estacionamiento.getNombreEstacionamiento());
		
	}

}
