package ar.edu.unlam.pb2.parkingTP;

public abstract class Vehiculo {

	private String marca;
	private String color;
	private String patente;
	private Double basePrecio;
	private Cliente cliente;

	public Vehiculo(String marca, String color, String patente, Double basePrecio, Cliente cliente) {
		this.marca = marca;
		this.color = color;
		this.basePrecio = basePrecio;
		this.patente = patente;
		this.cliente = cliente;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Double getBasePrecio() {
		return basePrecio;
	}
	
	public void setBasePrecio(Double basePrecio) {
		this.basePrecio = basePrecio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public abstract Double obtenerPrecioPorHora(Double basePrecio);

	public void add(Vehiculo vehiculo) {
		
		
	}
		
		
	}
	

