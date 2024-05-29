package ar.edu.unlam.pb2.parkingTP;

public class Auto extends Vehiculo {
    private Integer puertas;
    private String patente;

    public Auto(Integer puertas, String patente) {
        this.puertas = puertas;
        this.patente = patente;
    }

    public String getPatente() {
        return patente;
    }
}
