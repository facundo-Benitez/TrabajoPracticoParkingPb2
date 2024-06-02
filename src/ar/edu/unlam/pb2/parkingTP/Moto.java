package ar.edu.unlam.pb2.parkingTP;

public class Moto extends Vehiculo {
	Double precioMotoHora = 500.00;

	public Moto(Cliente cliente, String marca, String color, String patente, Double basePrecio) {
		super(marca, color, patente, basePrecio, cliente);
		
	}


	@Override
	public Double obtenerPrecioPorHora(Double basePrecio) {
	
		return basePrecio + precioMotoHora;
	}

}
