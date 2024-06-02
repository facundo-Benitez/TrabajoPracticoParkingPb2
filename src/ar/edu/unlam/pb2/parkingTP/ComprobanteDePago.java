package ar.edu.unlam.pb2.parkingTP;

abstract public class ComprobanteDePago {
    private double montoPago;

    public ComprobanteDePago(double montoPago) {
        this.montoPago = montoPago;
    }

    abstract boolean realizarCobro();

    abstract boolean realizarCobro(ReservaPlaza reservaPlaza);

    public double getMontoPago() {
        return montoPago;
    }
}
