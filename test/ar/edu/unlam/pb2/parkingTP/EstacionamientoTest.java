package ar.edu.unlam.pb2.parkingTP;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class EstacionamientoTest {

	@Test 
	public void QueSePuedaCrearUnEstacionamiento() {	
		String nombreEstacionamiento = "Parking";
		
		Estacionamiento estacionamiento = new Estacionamiento(nombreEstacionamiento);

		assertNotNull(estacionamiento);
		assertEquals(nombreEstacionamiento,estacionamiento.getNombreEstacionamiento());
		
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
	
}
