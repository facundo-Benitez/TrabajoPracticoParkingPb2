package ar.edu.unlam.pb2.parkingTP;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class ClienteTest {

	private Estacionamiento estacionamiento;

	@Before
	public void init() {
		this.estacionamiento = new Estacionamiento("");
	}

	@Test
	public void queSePuedaCrearUnaReservaDeEstadiaMensual() {
		// Generar Plazas y Clientes
		Cliente cliente = estacionamiento.registrarCliente("Juan", "1158743920");
		estacionamiento.agregarPlazasAlEstacionamiento(new Plaza(1, "", false, TipoDeVehiculo.AUTO));

		boolean reservaCreada = estacionamiento.asignarPlazaACliente(cliente);

		assertTrue(reservaCreada);
	}

	@Test
	public void queSePuedaCrearUnaReservaDeEstadiaMensualYVerificarQueOcupeUnaPlazaDesocupada() {
		registrarClienteYAsignarlePlaza(1, "Juan", "1158743920");

		ReservaPlaza reservaPlazaAgregada = estacionamiento.getReservaPlazaPorNumeroDePlaza(1);

		assertEquals("Juan", reservaPlazaAgregada.getCliente().getNombre());
		assertTrue(estacionamiento.verificarSiPlazaEstaOcupada(1));
	}

	@Test
	public void queSePuedaDarDeBajaUnaReservaDeEstadiaMensualConNumeroDePlazaYSeDesocupeLaPlaza() {
		registrarClienteYAsignarlePlaza(1, "Juan", "1158743920");

		boolean reservaEliminada = estacionamiento.darDeBajaReserva(1);

		assertTrue(reservaEliminada);
		assertFalse(estacionamiento.verificarSiPlazaEstaOcupada(1));
	}

	@Test
	public void queSeQuieraDarDeBajaUnaReservaConNumeroDePlazaInexistenteYDevuelvaFalse() {
		registrarClienteYAsignarlePlaza(1, "Juan", "1158743920");

		boolean reservaEliminada = estacionamiento.darDeBajaReserva(2);

		assertFalse(reservaEliminada);
	}

	@Test
	public void queSePuedaDebitarLaDeudaDelMesCorrienteVerificandoQueNoHayaSidoPreviamenteAcreditadaYObtenerElTotalDeDeuda() {
		registrarClienteYAsignarlePlaza(1, "Juan", "1158743920");
		ReservaPlaza reservaPlazaAgregada = estacionamiento.getReservaPlazaPorNumeroDePlaza(1);
		int mes = 5;

		boolean acreditacionDeDeuda = reservaPlazaAgregada.debitarDeuda(mes);
		double deudaTotal = reservaPlazaAgregada.getSaldoTotalAdeudado();

		assertTrue(acreditacionDeDeuda);
		assertEquals(ReservaPlaza.PRECIO_ESTADIA_MENSUAL, deudaTotal, 0.0);
	}

	@Test
	public void queNoSePuedaDebitarUnaDeudaParaElMesCorrienteCuandoYaExisteUnaDeudaParaEseMes() {
		registrarClienteYAsignarlePlaza(1, "Juan", "1158743920");
		ReservaPlaza reservaPlazaAgregada = estacionamiento.getReservaPlazaPorNumeroDePlaza(1);
		int mes = 5;

		boolean acreditacionDeDeuda = reservaPlazaAgregada.debitarDeuda(mes);
		boolean segundaAcreditacionDeDeuda = reservaPlazaAgregada.debitarDeuda(mes);

		double deudaTotal = reservaPlazaAgregada.getSaldoTotalAdeudado();

		assertTrue(acreditacionDeDeuda);
		assertFalse(segundaAcreditacionDeDeuda);
		assertEquals(ReservaPlaza.PRECIO_ESTADIA_MENSUAL, deudaTotal, 0.0);
	}

	@Test
	public void queSeLeDebiteLaDeudaATodasLasReservasElPrimerDiaDeCadaMes() {
		registrarClienteYAsignarlePlaza(1, "Juan", "1158743920");
		registrarClienteYAsignarlePlaza(2, "Manuel", "1158744220");
		registrarClienteYAsignarlePlaza(3, "Estefania", "20589002");
		LocalDate fecha = LocalDate.of(2024, 5, 1);

		estacionamiento.debitarDeudaMensualPorFecha(fecha);

		ReservaPlaza reserva1 = estacionamiento.getReservaPlazaPorNumeroDePlaza(1);
		ReservaPlaza reserva2 = estacionamiento.getReservaPlazaPorNumeroDePlaza(1);
		ReservaPlaza reserva3 = estacionamiento.getReservaPlazaPorNumeroDePlaza(1);

		assertEquals(ReservaPlaza.PRECIO_ESTADIA_MENSUAL, reserva1.getSaldoTotalAdeudado(), 0.0);
		assertEquals(ReservaPlaza.PRECIO_ESTADIA_MENSUAL, reserva2.getSaldoTotalAdeudado(), 0.0);
		assertEquals(ReservaPlaza.PRECIO_ESTADIA_MENSUAL, reserva3.getSaldoTotalAdeudado(), 0.0);
	}

	@Test
	public void queNoSeDebiteLaDeudaCuandoNoEsElPrimerDiaDelMes() {
		registrarClienteYAsignarlePlaza(3, "Estefania", "20589002");
		LocalDate fecha = LocalDate.of(2024, 5, 17);

		boolean deudaDebitada = estacionamiento.debitarDeudaMensualPorFecha(fecha);
		ReservaPlaza reserva3 = estacionamiento.getReservaPlazaPorNumeroDePlaza(3);

		assertTrue(deudaDebitada);
		assertEquals(0.0, reserva3.getSaldoTotalAdeudado(), 0.0);
	}

	@Test
	public void queSePuedaObtenerElEstadoDePagoDeUnaReservaMensualQueNoPresentaDeuda() {
		registrarClienteYAsignarlePlaza(1, "Juan", "1158743920");
		ReservaPlaza reserva1 = estacionamiento.getReservaPlazaPorNumeroDePlaza(1);
		double saldoAdeudado = reserva1.getSaldoTotalAdeudado();

		assertEquals(0.0, saldoAdeudado, 0.0);
	}

	private void registrarClienteYAsignarlePlaza(int nroPlaza, String nombreCliente, String telefonoCliente) {
		Cliente cliente = estacionamiento.registrarCliente(nombreCliente, telefonoCliente);
		estacionamiento.agregarPlazasAlEstacionamiento(new Plaza(nroPlaza, "", false, TipoDeVehiculo.AUTO));
		estacionamiento.asignarPlazaACliente(cliente);
	}

}
