package ar.edu.unlam.pb2.parkingTP;

public class Tarjeta extends ComprobanteDePago {
    String numero;
    String codigoSeguridad;

    public Tarjeta(double montoPago, String numero, String codigoSeguridad) {
        super(montoPago);
        this.numero = numero;
        this.codigoSeguridad = codigoSeguridad;
    }

    @Override
    public boolean realizarCobro(ReservaPlaza reservaPlaza) {
        if (verificarTarjeta()) {
            reservaPlaza.acreditarDeuda(super.getMontoPago());
            return true;
        }
        return false;
    }

    private boolean verificarTarjeta() {
        if (this.numero.length() == 16 && this.codigoSeguridad.length() == 3) {
            for (char c : this.numero.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            for (char c : this.codigoSeguridad.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
