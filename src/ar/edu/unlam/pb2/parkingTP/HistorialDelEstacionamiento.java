package ar.edu.unlam.pb2.parkingTP;

import java.util.HashSet;
import java.util.Set;

public class HistorialDelEstacionamiento {
    private Set<Ticket> historialTickets;

    public HistorialDelEstacionamiento() {
        this.historialTickets = new HashSet<>();
    }

    public void agregarTicket(Ticket ticket) {
        this.historialTickets.add(ticket);
    }

    public Set<Ticket> getHistorialTickets() {
        return historialTickets;
    }

    public void setHistorialTickets(Set<Ticket> historialTickets) {
        this.historialTickets = historialTickets;
    }
}
