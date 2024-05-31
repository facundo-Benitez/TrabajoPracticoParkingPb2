package ar.edu.unlam.pb2.parkingTP;

import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {
    private Integer id;
    private LocalDateTime fechaHoraEntrada;
    private LocalDateTime fechaHoraSalida;
    private Integer nroPlaza;
    private Double costo;
    private static final double HORA_COCHE = 2000.0;
    private static final double HORA_MOTO = 1000.0;
    
    private Vehiculo vehiculo;

    public Ticket(Integer id, LocalDateTime fechaHoraEntrada, LocalDateTime fechaHoraSalida, Integer nroPlaza, Double costo) {
        this.id = id;
        this.fechaHoraEntrada = fechaHoraEntrada;
        this.fechaHoraSalida = fechaHoraSalida;
        this.nroPlaza = nroPlaza;
        this.costo = costo;
    }

    public double calcularCosto(Vehiculo vehiculo) {
        Double valorVehiculo = getValorVehiculo(vehiculo);
        Duration tiempoEstadia = calculoTiempoEstadia();
        long horas = tiempoEstadia.toHours();
        return horas * valorVehiculo;
    }

    public Double getValorVehiculo(Vehiculo vehiculo) {
        String tipoVehiculo = vehiculo.getClass().getSimpleName();
        Double valorDependiendoDeVehiculo = 0.0;
        switch (tipoVehiculo) {
            case "Auto":
                valorDependiendoDeVehiculo = HORA_COCHE;
                break;
            case "Bici":
                valorDependiendoDeVehiculo = HORA_MOTO;
                break;
        }
        return valorDependiendoDeVehiculo;
    }

    public Duration calculoTiempoEstadia() {
        return Duration.between(this.fechaHoraEntrada, this.fechaHoraSalida);
    }

    // Getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNroPlaza() {
        return nroPlaza;
    }

    public void setNroPlaza(Integer nroPlaza) {
        this.nroPlaza = nroPlaza;
    }

    public LocalDateTime getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public void setFechaHoraEntrada(LocalDateTime fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
}

