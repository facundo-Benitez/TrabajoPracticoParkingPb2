package ar.edu.unlam.pb2.parkingTP;

import static org.junit.Assert.*;

<<<<<<< HEAD
=======
import java.awt.List;
import java.time.LocalDateTime;
>>>>>>> NazarenoBranch
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
	public void QueSePuedaCrearyAgregarUnaPlazaAlEstacionamiento() {	
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;
		
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		
		Plaza plaza=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);		
		assertNotNull(plaza);
		assertEquals(nroDePlaza,plaza.getNroDePlaza());
		assertEquals(seccion,plaza.getSeccion());
		assertEquals(estaOcupado,plaza.getEstaOcupado());
		assertEquals(tipo,plaza.getTipo());
		
		Boolean seAgrego=estacionamiento.agregarPlazasAlEstacionamiento(plaza);	
		assertTrue(seAgrego);

<<<<<<< HEAD
	}
	
	@Test 
	public void QueSePuedaEliminarUnaPlazasDelEstacionamiento() {	
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;
		
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);		
		estacionamiento.agregarPlazasAlEstacionamiento(plaza);   
		Boolean seElimino=estacionamiento.eliminarUnaPlazaDelEstacionamiento(plaza);
        
        assertTrue(seElimino);
        
	}

	@Test 
	public void QueSePuedaCrearYAgregarAlSistemaDelEstacionamientoUnaPlazaParaEstacionarUnVehiculo() {	
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;
		
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza);	
		VehiculoPlaza lugarParaEstacionamiento=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza);
		Boolean SeAgrego=estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento);
		
		assertNotNull(lugarParaEstacionamiento);
		assertTrue(SeAgrego);
	
	}
	
	@Test
	public void QueSePuedaObtenerLaCantidadDePlazasTotalesDelEstacionamientoParaHabilitarloAlSistema(){
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;
		
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza1=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		Plaza plaza2=new Plaza(2,seccion,estaOcupado,TipoDeVehiculo.MOTO);
		Plaza plaza3=new Plaza(3,seccion,estaOcupado,TipoDeVehiculo.BICI);
		Plaza plaza4=new Plaza(4,seccion,estaOcupado,TipoDeVehiculo.CAMIONETA);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza1);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza2);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza3);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza4);
		
		Integer plazasTotalesEspedas=4;
		Integer plazasTotalesObtenidas=estacionamiento.ObtenerCantidadDePlazas();
		
		assertEquals(plazasTotalesEspedas,plazasTotalesObtenidas);
	
	}
	
	@Test
	public void QueSePuedaObtenerLaCantidadDePlazasTotalesHabilitadasParaElsistemaDelEstacionamiento(){
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;
		
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza1=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		Plaza plaza2=new Plaza(2,seccion,estaOcupado,TipoDeVehiculo.MOTO);
		Plaza plaza3=new Plaza(3,seccion,estaOcupado,TipoDeVehiculo.BICI);
		Plaza plaza4=new Plaza(4,seccion,estaOcupado,TipoDeVehiculo.CAMIONETA);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza1);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza2);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza3);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza4);			
		VehiculoPlaza lugarParaEstacionamiento1=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza1);
		VehiculoPlaza lugarParaEstacionamiento2=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza2);
		VehiculoPlaza lugarParaEstacionamiento3=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza3);
		VehiculoPlaza lugarParaEstacionamiento4=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza4);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento1);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento2);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento3);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento4);
			
		Integer plazasTotalesEspedas=4;
		Integer plazasTotalesObtenidas=estacionamiento.ObtenerCantidadDeLugaresTotalesHabilitadasParaEstacionar();
		
		assertEquals(plazasTotalesEspedas,plazasTotalesObtenidas);
		
	}
	
	@Test
	public void QueSePuedaDarDeBajaUnaPlazaAgregadaAlSistemaDeEstacionamiento(){
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;
		
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza1=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		Plaza plaza2=new Plaza(2,seccion,estaOcupado,TipoDeVehiculo.MOTO);
		Plaza plaza3=new Plaza(3,seccion,estaOcupado,TipoDeVehiculo.BICI);
		Plaza plaza4=new Plaza(4,seccion,estaOcupado,TipoDeVehiculo.CAMIONETA);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza1);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza2);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza3);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza4);	
		VehiculoPlaza lugarParaEstacionamiento1=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza1);
		VehiculoPlaza lugarParaEstacionamiento2=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza2);
		VehiculoPlaza lugarParaEstacionamiento3=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza3);
		VehiculoPlaza lugarParaEstacionamiento4=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza4);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento1);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento2);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento3);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento4);
			
        Boolean seElimino=estacionamiento.darDeBajaUnaPlazaVehiculoDelSistema(lugarParaEstacionamiento4);
        assertTrue(seElimino);
        
        Integer lugarEspedos=3;
		Integer lugaresObtenidas=estacionamiento.ObtenerCantidadDeLugaresTotalesHabilitadasParaEstacionar();	
		assertEquals(lugarEspedos,lugaresObtenidas);
		
	}
	
	@Test
	public void QueSePuedaMostrarLaDisponibilidadDeTodasLasPlazasDelEstacionamiento(){
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;
			
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza1=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		Plaza plaza2=new Plaza(2,seccion,estaOcupado,TipoDeVehiculo.MOTO);
		Plaza plaza3=new Plaza(3,seccion,estaOcupado,TipoDeVehiculo.BICI);
		Plaza plaza4=new Plaza(4,seccion,estaOcupado,TipoDeVehiculo.CAMIONETA);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza1);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza2);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza3);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza4);	
		VehiculoPlaza lugarParaEstacionamiento1=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza1);
		VehiculoPlaza lugarParaEstacionamiento2=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza2);
		VehiculoPlaza lugarParaEstacionamiento3=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza3);
		VehiculoPlaza lugarParaEstacionamiento4=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza4);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento1);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento2);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento3);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento4);
				
		ArrayList<VehiculoPlaza> PlazasDisponibles = estacionamiento.MostrarLaDisponibilidadDeTodasLasPlazasDelEstacionamientoDelSistema();
		    
		assertEquals((int)4, PlazasDisponibles.size());
		assertTrue(PlazasDisponibles.contains(lugarParaEstacionamiento1)); 
		assertTrue(PlazasDisponibles.contains(lugarParaEstacionamiento2));    
		assertTrue(PlazasDisponibles.contains(lugarParaEstacionamiento3));
		assertTrue(PlazasDisponibles.contains(lugarParaEstacionamiento4));
 	    
	}

	@Test
	public void QueSePuedaObtenerTodasLasPlazasDisponiblesPorTipoDeVehiculo(){
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;
			
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza1=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		Plaza plaza2=new Plaza(2,seccion,estaOcupado,TipoDeVehiculo.MOTO);
		Plaza plaza3=new Plaza(3,seccion,estaOcupado,TipoDeVehiculo.BICI);
		Plaza plaza4=new Plaza(4,seccion,estaOcupado,TipoDeVehiculo.CAMIONETA);
		Plaza plaza5=new Plaza(5,seccion,estaOcupado,TipoDeVehiculo.CAMIONETA);
		Plaza plaza6=new Plaza(6,seccion,estaOcupado,TipoDeVehiculo.CAMIONETA);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza1);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza2);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza3);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza4);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza5);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza6);			
		VehiculoPlaza lugarParaEstacionamiento1=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza1);
		VehiculoPlaza lugarParaEstacionamiento2=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza2);
		VehiculoPlaza lugarParaEstacionamiento3=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza3);
		VehiculoPlaza lugarParaEstacionamiento4=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza4);
		VehiculoPlaza lugarParaEstacionamiento5=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza5);
		VehiculoPlaza lugarParaEstacionamiento6=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza6);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento1);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento2);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento3);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento4);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento5);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento6);
	    
		ArrayList<VehiculoPlaza> PlazasDisponiblePorTipoDeVehiculo = estacionamiento.MostrarLaDisponibilidadDeTodasLasPlazasDelEstacionamientoDelSistemaPorTipoDeVehiculo(TipoDeVehiculo.CAMIONETA);
		    
		assertEquals((int)3, PlazasDisponiblePorTipoDeVehiculo.size());
		assertTrue(PlazasDisponiblePorTipoDeVehiculo.contains(lugarParaEstacionamiento4)); 
		assertTrue(PlazasDisponiblePorTipoDeVehiculo.contains(lugarParaEstacionamiento5));    
		assertTrue(PlazasDisponiblePorTipoDeVehiculo.contains(lugarParaEstacionamiento6));
		assertFalse(PlazasDisponiblePorTipoDeVehiculo.contains(lugarParaEstacionamiento1)); 
		assertFalse(PlazasDisponiblePorTipoDeVehiculo.contains(lugarParaEstacionamiento2));    
		assertFalse(PlazasDisponiblePorTipoDeVehiculo.contains(lugarParaEstacionamiento3));
		
	}
	
	@Test       
	public void QueSePuedaAsignarUnVehiculoAlEstacionamientoYColocarLaPlazaEnOcupado(){
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;
			
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza1=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza1);		
		VehiculoPlaza lugarParaEstacionamiento1=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza1);		
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento1);
		Vehiculo auto=new Auto("AJ123A3",TipoDeVehiculo.AUTO);
		estacionamiento.agregarVehiculo(auto);
		
		Boolean seAsignoVehiculo=estacionamiento.asignarUnVehiculoAUnaPlazaDelSistemayUnaVezAsignadoPonerOcupado(auto, plaza1);
		assertTrue(seAsignoVehiculo);
		
		Boolean lugarOcupadoEsperado=true;
		assertEquals(lugarOcupadoEsperado,lugarParaEstacionamiento1.getPlazaDeVehiculo().getEstaOcupado());
		
	}
	
	@Test
	public void QueSePuedaMostrarTodasDeLasPlazasDelEstacionamientoOcupadas(){
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;
			
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza1=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		Plaza plaza2=new Plaza(2,seccion,estaOcupado,TipoDeVehiculo.MOTO);
		Plaza plaza3=new Plaza(3,seccion,estaOcupado,TipoDeVehiculo.BICI);
		Plaza plaza4=new Plaza(4,seccion,estaOcupado,TipoDeVehiculo.CAMIONETA);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza1);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza2);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza3);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza4);			
		Vehiculo auto=new Auto("AJ123A3",TipoDeVehiculo.AUTO);
		Vehiculo moto=new Moto("GR456U1",TipoDeVehiculo.MOTO);
		Vehiculo bici=new Bici("JKT1234A",TipoDeVehiculo.BICI);
		estacionamiento.agregarVehiculo(bici);
		estacionamiento.agregarVehiculo(auto);
		estacionamiento.agregarVehiculo(moto);	
		VehiculoPlaza lugarParaEstacionamiento1=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza1);
		VehiculoPlaza lugarParaEstacionamiento2=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza2);
		VehiculoPlaza lugarParaEstacionamiento3=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza3);
		VehiculoPlaza lugarParaEstacionamiento4=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza4);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento1);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento2);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento3);
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento4);	       
	    estacionamiento.asignarUnVehiculoAUnaPlazaDelSistemayUnaVezAsignadoPonerOcupado(auto,plaza1);	
	    estacionamiento.asignarUnVehiculoAUnaPlazaDelSistemayUnaVezAsignadoPonerOcupado(moto,plaza2);	
	    estacionamiento.asignarUnVehiculoAUnaPlazaDelSistemayUnaVezAsignadoPonerOcupado(bici,plaza3);
	    
		ArrayList<VehiculoPlaza> PlazasOcupadas = estacionamiento.MostrarTodasLasPlazasDelEstacionamientoDelSistemaQueEstenOcupadas();
		    
		assertEquals((int)3, PlazasOcupadas.size());
		assertTrue(PlazasOcupadas.contains(lugarParaEstacionamiento1)); 
		assertTrue(PlazasOcupadas.contains(lugarParaEstacionamiento2));    
		assertTrue(PlazasOcupadas.contains(lugarParaEstacionamiento3));
		assertFalse(PlazasOcupadas.contains(lugarParaEstacionamiento4)); 
		    
	}
    
	@Test
	public void QueSeNoPuedaOcuparUnaPlazaDeEstacionamientoCuandoElVehiculoEsIncompatibleConLaPlaza(){
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.MOTO;
			
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza1=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza1);			
		VehiculoPlaza lugarParaEstacionamiento1=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza1);		
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento1);
		Vehiculo auto=new Auto("AJ123A3",TipoDeVehiculo.AUTO);
		estacionamiento.agregarVehiculo(auto);
		
		Boolean seAsignoVehiculo=estacionamiento.asignarUnVehiculoAUnaPlazaDelSistemayUnaVezAsignadoPonerOcupado(auto, plaza1);
		 
		assertFalse(seAsignoVehiculo);
		
	}
	
	@Test
	public void QueNoSePuedaOcuparUnaPlazaDeEstacionamientoCuandoEstaOcupada(){
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;
			
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza1=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza1);			
		VehiculoPlaza lugarParaEstacionamiento1=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza1);		
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento1);
		Vehiculo auto=new Auto("AJ123A3",TipoDeVehiculo.AUTO);
		estacionamiento.agregarVehiculo(auto);
		Vehiculo auto2=new Auto("KS123A4",TipoDeVehiculo.AUTO);
		estacionamiento.agregarVehiculo(auto2);	
		Boolean seAsignoVehiculo1=estacionamiento.asignarUnVehiculoAUnaPlazaDelSistemayUnaVezAsignadoPonerOcupado(auto, plaza1);
		Boolean seAsignoVehiculo2=estacionamiento.asignarUnVehiculoAUnaPlazaDelSistemayUnaVezAsignadoPonerOcupado(auto2, plaza1);
		
		assertTrue(seAsignoVehiculo1);
		assertFalse(seAsignoVehiculo2);
		
	}
	
	@Test
	public void QueUnaVezLiberadaUnaPlazaDeEstacionamientoSePuedaHabilitarNuevamente(){
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;
			
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza);			
		VehiculoPlaza lugarParaEstacionamiento1=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza);		
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento1);
		Vehiculo auto=new Auto("AJ123A3",TipoDeVehiculo.AUTO);
		estacionamiento.agregarVehiculo(auto);		
		estacionamiento.asignarUnVehiculoAUnaPlazaDelSistemayUnaVezAsignadoPonerOcupado(auto, plaza);
		Boolean seHabilitoPlaza=estacionamiento.habilitarPlazaUnaVesDesocupada(lugarParaEstacionamiento1);
		assertTrue(seHabilitoPlaza);
		
	}
	
=======
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
>>>>>>> NazarenoBranch
}
