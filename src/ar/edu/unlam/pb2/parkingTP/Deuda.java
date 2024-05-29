package ar.edu.unlam.pb2.parkingTP;

public class Deuda {
    private int mes;
    private double saldoAdeudado;

    public Deuda(int mes, double saldoAdeudado) {
        this.mes = mes;
        this.saldoAdeudado = saldoAdeudado;
    }

    public int getMes() {
        return mes;
    }

    public double getSaldoAdeudado() {
        return saldoAdeudado;
    }

    public void setSaldoAdeudado(double saldoAdeudado) {
        this.saldoAdeudado = saldoAdeudado;
    }
}
