package ar.edu.unlam.pb2.parkingTP;

public class Efectivo extends ComprobanteDePago {
    public Efectivo(double montoAPagar) {
        super(montoAPagar);
    }

    @Override
    boolean realizarCobro() {
        return getMontoPago() > 0;
    }

    @Override
    public boolean realizarCobro(ReservaPlaza reservaPlaza) {
        return reservaPlaza.acreditarDeuda(super.getMontoPago());
    }

}
