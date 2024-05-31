package ar.edu.unlam.pb2.parkingTP;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehiculoTest {

	@Test
	public void QueSePuedaAgregarUnAutoAlEstacionamientoyVerificarLosDatos() {
		String nombre = "E";
		String patente = "A2002E";
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;
		Tickets ticketEstacionamiento=null;
		
		Vehiculo auto = new Auto(patente, tipo,ticketEstacionamiento);
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		assertTrue(estacionamiento.agregarVehiculo(auto));
		assertEquals(patente,auto.getPatente());
		assertEquals(tipo,auto.getTipo());
	}
	
	@Test
	public void QueSePuedaAgregarUnaMotoAlEstacionamientoyVerificarLosDatos() {		
		String nombre = "E";
		String patente = "A4403E";
		TipoDeVehiculo tipo=TipoDeVehiculo.MOTO;
		Tickets ticketEstacionamiento=null;
		
		Vehiculo moto = new Moto(patente, tipo,ticketEstacionamiento);
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		assertTrue(estacionamiento.agregarVehiculo(moto));
		assertEquals(patente,moto.getPatente());
		assertEquals(tipo,moto.getTipo());
	}
	
	@Test
	public void QueSePuedaAgregarUnaBiciAlEstacionamientoyVerificarLosDatos() {	
		String nombre = "E";
		String patente = "A3001E";
		TipoDeVehiculo tipo=TipoDeVehiculo.BICI;
		Tickets ticketEstacionamiento=null;
		
		Vehiculo bici = new Bici(patente, tipo,ticketEstacionamiento);
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		assertTrue(estacionamiento.agregarVehiculo(bici));
		assertEquals(patente,bici.getPatente());
		assertEquals(tipo,bici.getTipo());
	}
	
	@Test
	public void QueSePuedaAgregarUnaCamionetaAlEstacionamientoyVerificarLosDatos() {	
		String nombre = "E";
		String patente = "A2212E";
		TipoDeVehiculo tipo=TipoDeVehiculo.CAMIONETA;
		Tickets ticketEstacionamiento=null;
		
		Vehiculo Camioneta = new Camioneta(patente, tipo,ticketEstacionamiento);
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		assertTrue(estacionamiento.agregarVehiculo(Camioneta));
		assertEquals(patente,Camioneta.getPatente());
		assertEquals(tipo,Camioneta.getTipo());
		
	}

}
