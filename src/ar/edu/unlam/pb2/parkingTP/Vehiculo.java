package ar.edu.unlam.pb2.parkingTP;

import java.util.Objects;

public abstract class Vehiculo {
	private String patente;
	private TipoDeVehiculo tipo;
	private Cliente duenio;
	private Tickets tickets;
	
	public Vehiculo(String patente,TipoDeVehiculo tipo,Cliente duenio) {
		this.patente = patente;
		this.tipo=tipo;
		this.duenio=duenio;
	}
	
	public Vehiculo(String patente,TipoDeVehiculo tipo,Tickets tickets) {
		this.patente = patente;
		this.tipo=tipo;
		this.tickets=tickets;
	}
	
	public Vehiculo(String patente,TipoDeVehiculo tipo,Cliente duenio,Tickets tickets) {
		this.patente = patente;
		this.tipo=tipo;
		this.duenio=duenio;
		this.tickets=tickets;
	}

    public String getPatente() {
		return patente;
	}
	
	public TipoDeVehiculo getTipo() {
		return tipo;
	}

	public Cliente getDuenio() {
		return duenio;
	}

	public void setDuenio(Cliente duenio) {
		this.duenio = duenio;
	}

	public Tickets getTickets() {
		return tickets;
	}

	public void setTickets(Tickets tickets) {
		this.tickets = tickets;
	}

	public abstract Double calcularCosto();
	
	@Override
	public int hashCode() {
		return Objects.hash(patente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(patente, other.patente);
	}

}
