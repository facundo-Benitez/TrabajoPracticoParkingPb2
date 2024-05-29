package ar.edu.unlam.pb2.parkingTP;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReservaPlaza {

    static final double PRECIO_ESTADIA_MENSUAL = 30000.00;
    private Plaza plaza;
    private Cliente cliente;
    private List<Deuda> deudas;


    public ReservaPlaza(Plaza plaza, Cliente cliente) {
        this.plaza = plaza;
        this.cliente = cliente;
        this.deudas = new ArrayList();
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Plaza getPlaza() {
        return this.plaza;
    }

    public boolean debitarDeuda(int mes) {
        // Comprobar que todavia no se haya creado una deuda para este mes
        if (getUltimaDeuda() == null || getUltimaDeuda().getMes() != mes) {
            Deuda nuevaDeuda = new Deuda(mes, PRECIO_ESTADIA_MENSUAL);
            deudas.add(nuevaDeuda);
            return true;
        }
        return false;
    }

    public boolean acreditarDeuda(double montoAcreditado) {
        double monto = montoAcreditado;
        Iterator<Deuda> itDeuda = deudas.iterator();

        while (itDeuda.hasNext()) {
            Deuda deuda = itDeuda.next();
            if (deuda.getSaldoAdeudado() <= monto) {
                monto -= deuda.getSaldoAdeudado();
                itDeuda.remove();
            } else {
                deuda.setSaldoAdeudado(monto - deuda.getSaldoAdeudado());
                break;
            }
        }

        itDeuda.forEachRemaining(deudas::add);
        return monto == 0;
    }

    public double getSaldoTotalAdeudado() {
        if (deudas.isEmpty()) {
            return 0.0;
        } else {
            Iterator<Deuda> it = deudas.iterator();
            double saldoTotalAdeudado = 0;
            while (it.hasNext()) {
                Deuda deuda = it.next();
                saldoTotalAdeudado += deuda.getSaldoAdeudado();
            }
            return saldoTotalAdeudado;
        }
    }

    private Deuda getUltimaDeuda() {
        if (deudas.isEmpty()) {
            return null;
        } else {
            return deudas.get(deudas.size() - 1);
        }
    }

}
