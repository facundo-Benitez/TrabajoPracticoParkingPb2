package ar.edu.unlam.pb2.parkingTP;

import java.util.Objects;

public class HistorialDelEstacionamiento {
	private Integer idHistorial;
    private Tickets ticketGenerado;
    private VehiculoPlaza plazaDeEstacionamiento;
    private Vehiculo vehiculoEstacionado;
    private Cliente cliente;
	 
    public HistorialDelEstacionamiento(Integer idHistorial,Tickets ticketGenerado, VehiculoPlaza plazaDeEstacionamiento,
			Vehiculo vehiculoEstacionado, Cliente cliente) {
    	this.idHistorial=idHistorial;
		this.ticketGenerado = ticketGenerado;
		this.plazaDeEstacionamiento = plazaDeEstacionamiento;
		this.vehiculoEstacionado = vehiculoEstacionado;
		this.cliente = cliente;
	}
    
	public Integer getIdHistorial() {
		return idHistorial;
	}

	public Tickets getTicketGenerado() {
		return ticketGenerado;
	}
	public VehiculoPlaza getPlazaDeEstacionamiento() {
		return plazaDeEstacionamiento;
	}
	public Vehiculo getVehiculoEstacionado() {
		return vehiculoEstacionado;
	}
	public Cliente getCliente() {
		return cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idHistorial);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistorialDelEstacionamiento other = (HistorialDelEstacionamiento) obj;
		return Objects.equals(idHistorial, other.idHistorial);
	}
	
	
}
