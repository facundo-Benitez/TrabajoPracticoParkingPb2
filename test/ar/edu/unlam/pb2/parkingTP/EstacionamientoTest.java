package ar.edu.unlam.pb2.parkingTP;

import static org.junit.Assert.*;

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
		
		Integer plazasTotalesEsperadas=4;
		Integer plazasTotalesObtenidas=estacionamiento.ObtenerCantidadDePlazas();
		
		assertEquals(plazasTotalesEsperadas,plazasTotalesObtenidas);
	
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
			
		Integer plazasTotalesEsperadas=4;
		Integer plazasTotalesObtenidas=estacionamiento.ObtenerCantidadDeLugaresTotalesHabilitadasParaEstacionar();
		
		assertEquals(plazasTotalesEsperadas,plazasTotalesObtenidas);
		
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
        
        Integer lugarEsperados=3;
		Integer lugaresObtenidas=estacionamiento.ObtenerCantidadDeLugaresTotalesHabilitadasParaEstacionar();	
		assertEquals(lugarEsperados,lugaresObtenidas);
		
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
	public void QueSePuedaObtenerTodasLasPlazasDisponiblesPorUnTipoDeVehiculo(){
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
	    
		ArrayList<VehiculoPlaza> PlazasDisponiblePorTipoDeVehiculo = estacionamiento.MostrarLaDisponibilidadDeTodasLasPlazasDelEstacionamientoDelSistemaPorUnTipoDeVehiculo(TipoDeVehiculo.CAMIONETA);
		    
		assertEquals((int)3, PlazasDisponiblePorTipoDeVehiculo.size());
		assertTrue(PlazasDisponiblePorTipoDeVehiculo.contains(lugarParaEstacionamiento4)); 
		assertTrue(PlazasDisponiblePorTipoDeVehiculo.contains(lugarParaEstacionamiento5));    
		assertTrue(PlazasDisponiblePorTipoDeVehiculo.contains(lugarParaEstacionamiento6));
		assertFalse(PlazasDisponiblePorTipoDeVehiculo.contains(lugarParaEstacionamiento1)); 
		assertFalse(PlazasDisponiblePorTipoDeVehiculo.contains(lugarParaEstacionamiento2));    
		assertFalse(PlazasDisponiblePorTipoDeVehiculo.contains(lugarParaEstacionamiento3));
		
	}
	
	@Test       
	public void QueSePuedaAsignarUnVehiculoAlEstacionamientoYColocarLaPlazaEnOcupado() throws VehiculoNoEncontradoException{
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;
		LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 22, 50, 0);
		
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza1=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza1);		
		VehiculoPlaza lugarParaEstacionamiento1=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza1);		
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento1);
		Vehiculo auto=new Auto("AJ123A3",TipoDeVehiculo.AUTO,null);
		estacionamiento.agregarVehiculo(auto);
		Tickets ticketCliente=estacionamiento.generarTickets(1,fechaHoraEntrada,nroDePlaza);
		estacionamiento.asignarUnTicketAUnVehiculo("AJ123A3",ticketCliente);
		
		Boolean seAsignoVehiculo=estacionamiento.asignarUnVehiculoAUnaPlazayUnaVezAsignadoPonerElLugarEnOcupado(auto, plaza1);
		assertTrue(seAsignoVehiculo);
		
		Boolean lugarOcupadoEsperado=true;
		assertEquals(lugarOcupadoEsperado,lugarParaEstacionamiento1.getPlazaDeVehiculo().getEstaOcupado());
		
	}
	
	@Test
	public void QueSePuedaMostrarTodasDeLasPlazasDelEstacionamientoOcupadas() throws VehiculoNoEncontradoException{
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;
		LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 22, 50, 0);
		
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza1=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		Plaza plaza2=new Plaza(2,seccion,estaOcupado,TipoDeVehiculo.MOTO);
		Plaza plaza3=new Plaza(3,seccion,estaOcupado,TipoDeVehiculo.BICI);
		Plaza plaza4=new Plaza(4,seccion,estaOcupado,TipoDeVehiculo.CAMIONETA);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza1);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza2);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza3);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza4);			
		Vehiculo auto=new Auto("AJ123A3",TipoDeVehiculo.AUTO,null);
		Vehiculo moto=new Moto("GR456U1",TipoDeVehiculo.MOTO,null);
		Vehiculo bici=new Bici("JKT1234A",TipoDeVehiculo.BICI,null);
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
		Tickets ticketCliente1=estacionamiento.generarTickets(1,fechaHoraEntrada,nroDePlaza);
		estacionamiento.asignarUnTicketAUnVehiculo("AJ123A3",ticketCliente1);
		Tickets ticketCliente2=estacionamiento.generarTickets(2,LocalDateTime.of(2023, 5, 24, 22, 30, 0),2);
		estacionamiento.asignarUnTicketAUnVehiculo("GR456U1",ticketCliente2);
		Tickets ticketCliente3=estacionamiento.generarTickets(3,LocalDateTime.of(2023, 5, 24, 23, 00, 0),3);
		estacionamiento.asignarUnTicketAUnVehiculo("JKT1234A",ticketCliente3);
	    estacionamiento.asignarUnVehiculoAUnaPlazayUnaVezAsignadoPonerElLugarEnOcupado(auto,plaza1);	
	    estacionamiento.asignarUnVehiculoAUnaPlazayUnaVezAsignadoPonerElLugarEnOcupado(moto,plaza2);	
	    estacionamiento.asignarUnVehiculoAUnaPlazayUnaVezAsignadoPonerElLugarEnOcupado(bici,plaza3);
	    
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
		Vehiculo auto=new Auto("AJ123A3",TipoDeVehiculo.AUTO,null);
		estacionamiento.agregarVehiculo(auto);
		
		Boolean seAsignoVehiculo=estacionamiento.asignarUnVehiculoAUnaPlazayUnaVezAsignadoPonerElLugarEnOcupado(auto, plaza1);
		 
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
		Vehiculo auto=new Auto("AJ123A3",TipoDeVehiculo.AUTO,null);
		estacionamiento.agregarVehiculo(auto);
		Vehiculo auto2=new Auto("KS123A4",TipoDeVehiculo.AUTO,null);
		estacionamiento.agregarVehiculo(auto2);	
		Boolean seAsignoVehiculo1=estacionamiento.asignarUnVehiculoAUnaPlazayUnaVezAsignadoPonerElLugarEnOcupado(auto, plaza1);
		Boolean seAsignoVehiculo2=estacionamiento.asignarUnVehiculoAUnaPlazayUnaVezAsignadoPonerElLugarEnOcupado(auto2, plaza1);
		
		assertTrue(seAsignoVehiculo1);
		assertFalse(seAsignoVehiculo2);
		
	}
	
	@Test
	public void QueUnaVezLiberadaUnaPlazaDeEstacionamientoSePuedaHabilitarNuevamente() throws VehiculoNoEncontradoException{
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;
		LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 22, 50, 0);
		LocalDateTime fechaHoraSalida=LocalDateTime.of(2023, 5, 24, 23, 50, 0);
			
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza);			
		VehiculoPlaza lugarParaEstacionamiento1=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza);		
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento1);
		Vehiculo auto=new Auto("AJ123A3",TipoDeVehiculo.AUTO,null);
		estacionamiento.agregarVehiculo(auto);	
		Tickets ticketCliente=estacionamiento.generarTickets(1,fechaHoraEntrada,nroDePlaza);
		estacionamiento.asignarUnTicketAUnVehiculo("AJ123A3",ticketCliente);
		estacionamiento.asignarUnVehiculoAUnaPlazayUnaVezAsignadoPonerElLugarEnOcupado(auto, plaza);
		ticketCliente.registrarSalida(fechaHoraSalida);
		Boolean seHabilitoPlaza=estacionamiento.habilitarPlazaUnaVesDesocupada(lugarParaEstacionamiento1);
		assertTrue(seHabilitoPlaza);
		
	}
	
	@Test
	public void testQueSePuedaObtenerLaGananciaDelEstacionamiento()throws VehiculoNoEncontradoException{
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;	
		LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 21, 00, 0);
		LocalDateTime fechaHoraSalida=LocalDateTime.of(2023, 5, 24, 23, 50, 0);
		
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza);			
		VehiculoPlaza lugarParaEstacionamiento1=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza);		
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento1);
		Vehiculo auto=new Auto("AJ123A3",TipoDeVehiculo.AUTO,null);
		estacionamiento.agregarVehiculo(auto);
		Tickets ticketCliente=estacionamiento.generarTickets(1,fechaHoraEntrada,nroDePlaza);
		estacionamiento.asignarUnTicketAUnVehiculo("AJ123A3",ticketCliente);
		estacionamiento.asignarUnVehiculoAUnaPlazayUnaVezAsignadoPonerElLugarEnOcupado(auto, plaza);
		ticketCliente.registrarSalida(fechaHoraSalida);
		estacionamiento.habilitarPlazaUnaVesDesocupada(lugarParaEstacionamiento1);
		
		Double valorEsperado=5666.6;
		Double valorObtenido=estacionamiento.obtenerGananciaDelEstacionamiento();
		assertEquals(valorEsperado,valorObtenido,0.1);
		
	}

	@Test 
	public void QueSePermitaBuscarUnVehiculoPorPatenteYAsignarleUnTicket() throws VehiculoNoEncontradoException{
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;
		LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 22, 50, 0);
			
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza);			
		VehiculoPlaza lugarParaEstacionamiento1=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza);		
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento1);
		Vehiculo auto=new Auto("AJ123A3",TipoDeVehiculo.AUTO,null);
		estacionamiento.agregarVehiculo(auto);
		//genero un ticket
		Tickets ticketCliente=estacionamiento.generarTickets(1,fechaHoraEntrada,nroDePlaza);
		//busco un vehiculo por patente y le asigno un ticket de ingreso.
		Boolean seAsigno=estacionamiento.asignarUnTicketAUnVehiculo("AJ123A3",ticketCliente);
		//verifico si el ticket se agrego al vehiculo
		assertTrue(seAsigno);
		
	}
	
	@Test
	public void testQueSePuedanObtenerUnVehiculoPorElNumeroDePlaza() throws VehiculoNoEncontradoException, PlazaNoEncontradaException {
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;	
		LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 21, 00, 0);
		
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza);			
		VehiculoPlaza lugarParaEstacionamiento1=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza);		
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento1);
		Vehiculo auto=new Auto("AJ123A3",TipoDeVehiculo.AUTO,null);
		estacionamiento.agregarVehiculo(auto);
		Tickets ticketCliente=estacionamiento.generarTickets(1,fechaHoraEntrada,nroDePlaza);
		estacionamiento.asignarUnTicketAUnVehiculo("AJ123A3",ticketCliente);
		estacionamiento.asignarUnVehiculoAUnaPlazayUnaVezAsignadoPonerElLugarEnOcupado(auto, plaza);
		Vehiculo vehiculoEsperado=auto;
		Vehiculo vehiculoBuscado=estacionamiento.buscarUnVehiculoPorElNroDePlaza(nroDePlaza);
		assertEquals(vehiculoEsperado,vehiculoBuscado);
		
	}
	
	@Test
	public void testQueExistiendoVehiculosEnElEstacionamientoSeBusqueUnAutoPorPatenteExistente() throws VehiculoNoEncontradoException {
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;	
		LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 21, 00, 0);
		
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza);			
		VehiculoPlaza lugarParaEstacionamiento=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza);		
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento);
		Vehiculo auto=new Auto("AJ123A3",TipoDeVehiculo.AUTO,null);
		estacionamiento.agregarVehiculo(auto);
		Tickets ticketCliente=estacionamiento.generarTickets(1,fechaHoraEntrada,nroDePlaza);
		estacionamiento.asignarUnTicketAUnVehiculo("AJ123A3",ticketCliente);
		estacionamiento.asignarUnVehiculoAUnaPlazayUnaVezAsignadoPonerElLugarEnOcupado(auto, plaza);
		
		Plaza lugarEsperado=plaza;
		Plaza lugarBuscado=estacionamiento.buscarUnVehiculoPorPatenteParaVerSuUbicacion("AJ123A3");
		assertEquals(lugarEsperado,lugarBuscado);
		
	}
	
	@Test (expected=PlazaNoEncontradaException.class)
	public void testQueNoSePuedanObtenerUnVehiculoPorElNumeroDePlazaYLanceUnaException() throws VehiculoNoEncontradoException, PlazaNoEncontradaException {
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;	
		LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 21, 00, 0);
		
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza);			
		VehiculoPlaza lugarParaEstacionamiento1=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza);		
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento1);
		Vehiculo auto=new Auto("AJ123A3",TipoDeVehiculo.AUTO,null);
		estacionamiento.agregarVehiculo(auto);
		Tickets ticketCliente=estacionamiento.generarTickets(1,fechaHoraEntrada,nroDePlaza);
		estacionamiento.asignarUnTicketAUnVehiculo("AJ123A3",ticketCliente);
		estacionamiento.asignarUnVehiculoAUnaPlazayUnaVezAsignadoPonerElLugarEnOcupado(auto, plaza);
		
	    estacionamiento.buscarUnVehiculoPorElNroDePlaza(3);

		
	}
	
	@Test (expected=VehiculoNoEncontradoException.class)
	public void testQueNoExistiendoVehiculosEnElEstacionamientoSeBusqueUnAutoPorPatenteExistenteYLanceUnaExceptions() throws VehiculoNoEncontradoException {
		String nombre = "E";
		Integer nroDePlaza=1;
		String seccion="zona A";
		Boolean estaOcupado=false;
		TipoDeVehiculo tipo=TipoDeVehiculo.AUTO;	
		LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 21, 00, 0);
		
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza=new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
		estacionamiento.agregarPlazasAlEstacionamiento(plaza);			
		VehiculoPlaza lugarParaEstacionamiento=estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza);		
		estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento);
		Vehiculo auto=new Auto("AJ123A3",TipoDeVehiculo.AUTO,null);
		estacionamiento.agregarVehiculo(auto);
		Tickets ticketCliente=estacionamiento.generarTickets(1,fechaHoraEntrada,nroDePlaza);
		estacionamiento.asignarUnTicketAUnVehiculo("AJ123A3",ticketCliente);
		estacionamiento.asignarUnVehiculoAUnaPlazayUnaVezAsignadoPonerElLugarEnOcupado(auto, plaza);
		
		estacionamiento.buscarUnVehiculoPorPatenteParaVerSuUbicacion("AJ123B1");
		
	}

}
