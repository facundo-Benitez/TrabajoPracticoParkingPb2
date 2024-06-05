package ar.edu.unlam.pb2.parkingTP;

import static org.junit.Assert.*;

import org.junit.Test;

public class testParking {

	@Test
	public void QueSePuedaCrearUnEstacionamientoTest() {
		
		String nombre = "E";
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		String nombreEsperado = "E";
		assertEquals(nombreEsperado,estacionamiento.getNombre());
	}

	@Test
	public void QueSePuedaAgregarUnAutoAlEstacionamientoYObtenerElPrecioPorHoraTest() {
		
		String marca = "BMW";
		String color = "rojo";
		String patente = "A2002E";
		Double precioBase = 500.00;
		String nombre = "E";
		Cliente cliente = new Cliente(nombre, null);
		Vehiculo auto = new Auto(cliente, marca, color, patente, precioBase);
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		assertTrue(estacionamiento.agregarVehiculo(auto));
		Double precioPorHoraEsperado = 1500.00;
		assertEquals(precioPorHoraEsperado,auto.obtenerPrecioPorHora(precioBase));
	}
	@Test
	public void QueSePuedaAgregarUnaMotoAlEstacionamientoYObtenerElPrecioPorHoraTest() {
		
		String marca = "Kawasaki";
		String color = "verde";
		String patente = "A3003ER";
		Double precioBase = 500.00;
		String nombre = "E";
		Cliente cliente = new Cliente(nombre, null);
		Vehiculo moto = new Moto(cliente,marca, color, patente, precioBase);
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		assertTrue(estacionamiento.agregarVehiculo(moto));
		Double precioPorHoraEsperado = 1000.00;
		assertEquals(precioPorHoraEsperado,moto.obtenerPrecioPorHora(precioBase));
	}
	@Test
	public void QueSePuedaAgregarUnaBiciAlEstacionamientoYObtenerElPrecioPorHoraTest() {
		
		String marca = "Vairo";
		String color = "Verde";
		String patente = "5";
		Double precioBase = 500.00;
		String nombre = "E";
		Cliente cliente = new Cliente(nombre, null);
		Vehiculo bici = new Bici(cliente, marca, color, patente, precioBase);
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		assertTrue(estacionamiento.agregarVehiculo(bici));
		Double precioPorHoraEsperado = 600.00;
		assertEquals(precioPorHoraEsperado,bici.obtenerPrecioPorHora(precioBase));
	}
	
	@Test
	public void QueSePuedaAgregarUnaCamionetaAlEstacionamientoYObtenerElPrecioPorHoraTest() {
	
		String marca = "Ford";
		String color = "Blanca";
		String patente = "A5600FF";
		Double precioBase = 500.00;
		String nombre = "E";
		Cliente cliente = new Cliente(nombre, null);
		Vehiculo camioneta = new Camioneta(cliente, marca, color, patente, precioBase);
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		assertTrue(estacionamiento.agregarVehiculo(camioneta));
		Double precioPorHoraEsperado = 2000.00;
		assertEquals(precioPorHoraEsperado, camioneta.obtenerPrecioPorHora(precioBase));
	}
	
	@Test
	public void QueSePuedaObtenerElClienteVinculadoAlVehiculoPorSuPatenteTest() {
		
		String marca = "BMW";
		String color = "rojo";
		String patente = "A2002E";
		Double basePrecio = 500.00;
		String nombreCliente = "Pepe";
		Integer dni = 1;
		String nombre = "E";
		Cliente cliente = new Cliente(nombreCliente, dni);
		Vehiculo vehiculo = new Auto(cliente,marca, color, patente, basePrecio);
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		estacionamiento.agregarVehiculo(vehiculo);
		assertEquals(nombreCliente,estacionamiento.queSePuedeVincularElClienteConLaPatente(patente).getNombre());
	}


			
	@Test
	public void QueSePuedaEncontrarLaPlazaDondeEstaElEstacionamientoDeUnAutoPorSuPatenteTest()  {
		
		String marca = "BMW";
		String color = "rojo";
		String patente = "A2002E";
		Double basePrecio = 500.00;
		String nombreCliente = "Pepe";
		Integer dni = 1;
		String nombre = "E";		
		Cliente cliente = new Cliente(nombreCliente, dni);
		Auto auto = new Auto(cliente, marca, color, patente, basePrecio);
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza = new Plaza(1, TipoDeVehiculo.AUTO);		
		assertTrue(estacionamiento.agregarUnaPlazaAlEstacionamiento(plaza));
		assertTrue(estacionamiento.asignarUnVehiculoAUnaPlazaLibre(auto, plaza,TipoDeVehiculo.AUTO));
		assertEquals(plaza, estacionamiento.obtenerEstacionamientoDeAutoPorPatente2(patente));	
	}


	@Test
	public void QueSePuedaEncontrarLaPlazaDondeEstacionoUnaMotoPorSuPatenteTest() {

		String marca = "BMW";
		String color = "rojo";
		String patente = "A2002E";
		Double basePrecio = 500.00;
		String nombreCliente = "Pepe";
		Integer dni = 1;
		String nombre = "E";
		Integer numero = 1;
		Cliente cliente = new Cliente(nombreCliente, dni);
		Moto moto = new Moto(cliente, marca, color, patente, basePrecio);
		Estacionamiento estacionamiento = new Estacionamiento(nombre);
		Plaza plaza = new Plaza(numero, TipoDeVehiculo.MOTO);
		assertTrue(estacionamiento.agregarUnaPlazaAlEstacionamiento(plaza));
		assertTrue(estacionamiento.asignarUnVehiculoAUnaPlazaLibre(moto,plaza,TipoDeVehiculo.MOTO));
		assertEquals(plaza, estacionamiento.obtenerEstacionamientoDeAutoPorPatente2(patente));
	}
	
	@Test
	public void QueSePuedaEncontrarLaPlazaDondeEstaEstacionadoUnaBicicletaPorSuMarcaYColorTest()  {
		
		String marca = "Vairo";
		String color = "rojo";
		Cliente cliente = new Cliente("pepe",1);
		Bici bici = new Bici(cliente, marca, color, "5", 500.0);
		Integer numeroPlaza = 5;
		Plaza plaza = new Plaza(numeroPlaza,TipoDeVehiculo.BICI);
		Estacionamiento estacionamiento = new Estacionamiento("E");
		assertTrue(estacionamiento.agregarUnaPlazaAlEstacionamiento(plaza));
		assertTrue(estacionamiento.asignarUnVehiculoAUnaPlazaLibre(bici,plaza, TipoDeVehiculo.BICI));
		assertEquals(plaza,estacionamiento.buscarBici(marca,color, TipoDeVehiculo.BICI));
	}
	
	 @Test
	 public void QueSeQuieraIngresarUnaMotoAlEstacionamientoPeroEstenTodasLasPlazasOcupadasTest() throws sobreCargaDePlazasExcepcion {
	        String marca = "BMW";
	        String color = "rojo";
	        String patente = "A2002E";
	        Double basePrecio = 500.00;
	        String nombreCliente = "Pepe";
	        Integer dni = 1;
	        Integer numero =1;
	        Cliente cliente = new Cliente(nombreCliente, dni);
	        Moto moto1 = new Moto(cliente, marca, color, patente, basePrecio);
	        Moto moto2 = new Moto(cliente, marca, color, patente, basePrecio);
	        Estacionamiento estacionamiento = new Estacionamiento("E");
	        Plaza plaza = new Plaza(numero, TipoDeVehiculo.MOTO);
			assertTrue(estacionamiento.agregarUnaPlazaAlEstacionamiento(plaza));
	        assertTrue(estacionamiento.asignarUnVehiculoAUnaPlazaLibre(moto1,plaza,TipoDeVehiculo.MOTO));
	        assertTrue(estacionamiento.asignarUnVehiculoAUnaPlazaLibre(moto2,plaza,TipoDeVehiculo.MOTO));
	    }
		
	
	@Test
	public void QueSeQuieraIngresarUnAutoAlEstacionamientoPeroEstenTodasLasPlazasOcupadasTest()throws sobreCargaDePlazasExcepcion {

		        String marca = "BMW";
		        String color = "rojo";
		        String patente = "A2002E";
		        Double basePrecio = 500.00;
		        String nombreCliente = "Pepe";
		        Integer dni = 1;
		        Integer numero =1;
		        Cliente cliente = new Cliente(nombreCliente, dni);
		        Auto auto = new Auto(cliente, marca, color, patente, basePrecio);
		        Auto auto2 = new Auto(cliente, marca, color, patente, basePrecio);
		        Estacionamiento estacionamiento = new Estacionamiento("E");
		        Plaza plaza = new Plaza(numero,TipoDeVehiculo.AUTO);
				assertTrue(estacionamiento.agregarUnaPlazaAlEstacionamiento(plaza));
				assertTrue(estacionamiento.asignarUnVehiculoAUnaPlazaLibre(auto,plaza,TipoDeVehiculo.AUTO));
			    assertTrue(estacionamiento.asignarUnVehiculoAUnaPlazaLibre(auto2,plaza,TipoDeVehiculo.AUTO));
	}
	
	@Test
	public void QueSeQuieraIngresarUnaBicicletaAlEstacionamientoPeroEstenTodasLasPlazasOcupadasTest()throws sobreCargaDePlazasExcepcion{
	       String marca = "BMW";
	        String color = "rojo";
	        String patente = "A2002E";
	        Double basePrecio = 500.00;
	        String nombreCliente = "Pepe";
	        Integer dni = 1;
	        Integer numero =1;
	        Cliente cliente = new Cliente(nombreCliente, dni);
	        Bici bici = new Bici(cliente, marca, color, patente, basePrecio);
	        Bici bici2 = new Bici(cliente, marca, color, patente, basePrecio);
	        Estacionamiento estacionamiento = new Estacionamiento("E");
	        Plaza plaza = new Plaza(numero,TipoDeVehiculo.BICI);
			assertTrue(estacionamiento.agregarUnaPlazaAlEstacionamiento(plaza));
			assertTrue(estacionamiento.asignarUnVehiculoAUnaPlazaLibre(bici,plaza,TipoDeVehiculo.BICI));
		    assertTrue(estacionamiento.asignarUnVehiculoAUnaPlazaLibre(bici2,plaza,TipoDeVehiculo.BICI));
	}
	
	@Test
	public void QueSePuedaRetirarUnVehiculoDelEstacionamientoTest() throws sobreCargaDePlazasExcepcion  {
	    Estacionamiento estacionamiento = new Estacionamiento("E");
	    Plaza plaza = new Plaza(1, TipoDeVehiculo.AUTO);
	    estacionamiento.agregarUnaPlazaAlEstacionamiento(plaza);
	    String patente = "A2002E";
	    Cliente cliente = new Cliente("Cliente", 1);
	    Auto auto = new Auto(cliente, "Marca", "Color", patente, 100.0); // Asegúrate de que la patente aquí coincide con la que buscas
	    estacionamiento.asignarUnVehiculoAUnaPlazaLibre(auto, plaza, TipoDeVehiculo.AUTO);
	    assertTrue(estacionamiento.retirarVehiculo(patente));
	    assertNull(plaza.getVehiculo());
	}
}
	