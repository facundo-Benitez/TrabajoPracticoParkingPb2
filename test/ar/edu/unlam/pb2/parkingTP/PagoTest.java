package ar.edu.unlam.pb2.parkingTP;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

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

    @Test
    public void queSePuedaPagarUnTicketEnEfectivo() throws VehiculoNoEncontradoException {
        // Crear vehículo y asignarle plaza generando el ticket
        String nombre = "E";
        Integer nroDePlaza=1;
        String seccion="zona A";
        Boolean estaOcupado = false;
        TipoDeVehiculo tipo = TipoDeVehiculo.AUTO;
        LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 22, 50, 0);
        String patente = "AJ123A3";

        Estacionamiento estacionamiento = new Estacionamiento(nombre);
        Plaza plaza = new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
        estacionamiento.agregarPlazasAlEstacionamiento(plaza);
        VehiculoPlaza lugarParaEstacionamiento1 = estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza);
        estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento1);
        Vehiculo auto = new Auto(patente ,TipoDeVehiculo.AUTO,null);
        estacionamiento.agregarVehiculo(auto);
        Tickets ticketCliente=estacionamiento.generarTickets(1,fechaHoraEntrada,nroDePlaza);
        estacionamiento.asignarUnTicketAUnVehiculo(patente ,ticketCliente);

        // Registrar la salida del vehiculo.
        LocalDateTime fechaHoraSalida=LocalDateTime.of(2023, 5, 24, 23, 50, 0);
        ticketCliente.registrarSalida(fechaHoraSalida);

        // Calcular el monto del ticket con la patente del vehiculo
        double monto = estacionamiento.buscarVehiculoPorPatente(patente).calcularCosto();

        // Hacer el cobro
        Efectivo comprobanteDePago = new Efectivo(monto);
        boolean cobroRealizado = comprobanteDePago.realizarCobro();

        assertTrue(cobroRealizado);
    }

    @Test
    public void queSePuedaPagarUnTicketConTarjeta() throws VehiculoNoEncontradoException {
        // Crear vehículo y asignarle plaza generando el ticket
        String nombre = "E";
        Integer nroDePlaza=1;
        String seccion="zona A";
        Boolean estaOcupado = false;
        TipoDeVehiculo tipo = TipoDeVehiculo.AUTO;
        LocalDateTime fechaHoraEntrada=LocalDateTime.of(2023, 5, 24, 22, 50, 0);
        String patente = "AJ123A3";

        Estacionamiento estacionamiento = new Estacionamiento(nombre);
        Plaza plaza = new Plaza(nroDePlaza,seccion,estaOcupado,tipo);
        estacionamiento.agregarPlazasAlEstacionamiento(plaza);
        VehiculoPlaza lugarParaEstacionamiento1 = estacionamiento.crearUnLugarDeEstacionamientoAlSistemaParaEstacionarVehiculo(plaza);
        estacionamiento.agregarUnLugarDeEstacionamientoAlSistema(lugarParaEstacionamiento1);
        Vehiculo auto = new Auto(patente ,TipoDeVehiculo.AUTO,null);
        estacionamiento.agregarVehiculo(auto);
        Tickets ticketCliente=estacionamiento.generarTickets(1,fechaHoraEntrada,nroDePlaza);
        estacionamiento.asignarUnTicketAUnVehiculo(patente ,ticketCliente);

        // Registrar la salida del vehiculo.
        LocalDateTime fechaHoraSalida=LocalDateTime.of(2023, 5, 24, 23, 50, 0);
        ticketCliente.registrarSalida(fechaHoraSalida);

        // Calcular el monto del ticket con la patente del vehiculo
        double monto = estacionamiento.buscarVehiculoPorPatente(patente).calcularCosto();

        // Hacer el cobro verificando los datos de la tarjeta
        Tarjeta comprobanteDePago = new Tarjeta(monto , "1223455678891223", "331");
        boolean cobroRealizado = comprobanteDePago.realizarCobro();

        assertTrue(cobroRealizado);
    }

    private void registrarClienteYAsignarlePlaza(int nroPlaza, String nombreCliente, String telefonoCliente) {
        Cliente cliente = estacionamiento.registrarCliente(nombreCliente, telefonoCliente);
        estacionamiento.agregarPlazasAlEstacionamiento(new Plaza(nroPlaza, "", false, TipoDeVehiculo.AUTO));
        estacionamiento.asignarPlazaACliente(cliente);
    }

}
