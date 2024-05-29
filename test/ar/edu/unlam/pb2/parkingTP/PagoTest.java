package ar.edu.unlam.pb2.parkingTP;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PagoTest {

    private Estacionamiento estacionamiento;

    @Before
    public void init() {
        this.estacionamiento = new Estacionamiento("");
    }

    @Test
    public void queSePuedaAcreditarLaDeudaDeUnaReservaMensualEnEfectivo() {
        registrarClienteYAsignarlePlaza(1, "Juan", "1158743920");
        ReservaPlaza reserva1 = estacionamiento.getReservaPlazaPorNumeroDePlaza(1);
        reserva1.debitarDeuda(5);

        Efectivo comprobanteDePago = new Efectivo(reserva1.getSaldoTotalAdeudado());
        boolean cobroRealizado = comprobanteDePago.realizarCobro(reserva1);
        double saldoAdeudado = reserva1.getSaldoTotalAdeudado();

        assertTrue(cobroRealizado);
        assertEquals(0.0, saldoAdeudado, 0.0);
    }

    @Test
    public void queNoSePuedaPagarConUnaTarjetaQueNoTenga16NumerosOQueNoTengaUnCodigoDeSeguridadDe3Numeros() {
        registrarClienteYAsignarlePlaza(1, "Juan", "1158743920");
        ReservaPlaza reserva1 = estacionamiento.getReservaPlazaPorNumeroDePlaza(1);
        reserva1.debitarDeuda(5);

        Tarjeta comprobanteDePago = new Tarjeta(reserva1.getSaldoTotalAdeudado(), "1223P5567Y8912237", "ABC");
        boolean cobroRealizado = comprobanteDePago.realizarCobro(reserva1);
        double saldoAdeudado = reserva1.getSaldoTotalAdeudado();

        assertFalse(cobroRealizado);
        assertEquals(ReservaPlaza.PRECIO_ESTADIA_MENSUAL, saldoAdeudado, 0.0);
    }

    @Test
    public void queSeLePuedaCobrarDeudaDeUnaReservaMensualConTarjeta() {
        registrarClienteYAsignarlePlaza(1, "Juan", "1158743920");
        ReservaPlaza reserva1 = estacionamiento.getReservaPlazaPorNumeroDePlaza(1);
        reserva1.debitarDeuda(5);

        Tarjeta comprobanteDePago = new Tarjeta(reserva1.getSaldoTotalAdeudado(), "1223455678891223", "331");
        boolean cobroRealizado = comprobanteDePago.realizarCobro(reserva1);
        double saldoAdeudado = reserva1.getSaldoTotalAdeudado();

        assertTrue(cobroRealizado);
        assertEquals(0.0, saldoAdeudado, 0.0);
    }

    @Test
    public void queSePuedaDarDeBajaUnaReservaQuePresentaUnaDeuda() {
        registrarClienteYAsignarlePlaza(1, "Juan", "1158743920");
        ReservaPlaza reserva1 = estacionamiento.getReservaPlazaPorNumeroDePlaza(1);
        reserva1.debitarDeuda(5);

        boolean seDioDeBajaReserva = estacionamiento.darDeBajaReserva(1);

        assertFalse(seDioDeBajaReserva);
    }

    private void registrarClienteYAsignarlePlaza(int nroPlaza, String nombreCliente, String telefonoCliente) {
        Cliente cliente = estacionamiento.registrarCliente(nombreCliente, telefonoCliente);
        estacionamiento.agregarPlazasAlEstacionamiento(new Plaza(nroPlaza, "", false, TipoDeVehiculo.AUTO));
        estacionamiento.asignarPlazaACliente(cliente);
    }

}
