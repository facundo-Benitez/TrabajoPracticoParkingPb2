package ar.edu.unlam.pb2.parkingTP;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Plaza implements Comparable<Plaza> {
   
	private Integer numero;
    private List<Vehiculo> vehiculos;
    private Integer CantidadMaximaDePlazasMoto;
    private TipoDeVehiculo tipo;
    private Vehiculo vehiculo;
    private Set<Plaza>plazas;
   
    

    public Plaza(int numero, TipoDeVehiculo tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.vehiculos = new ArrayList<>();
        this.CantidadMaximaDePlazasMoto = CantidadMaximaDePlazasMoto;
        this.plazas = new TreeSet<>();
        
        
    }


	public void setTipo(TipoDeVehiculo tipo) {
		this.tipo = tipo;
	}



	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public boolean estaLLeno() {
		if (Integer.SIZE == CantidadMaximaDePlazasMoto);
		return true;
	}

	public boolean estaLibre() {
        return vehiculos.isEmpty();
    }

    public void asignarVehiculo(Vehiculo vehiculo, TipoDeVehiculo tipo) {
        this.vehiculos.add(vehiculo);
    
        
    }
    public void asignarUnNumeroAPlaza(Plaza numero) {
    	this.plazas.add(numero);
    }

    public void liberarPlaza() {
        this.vehiculos.clear();
    }
    public boolean ocupado(Vehiculo vehiculo) {
  	  
        return this.vehiculos.contains(vehiculo);
    }
   

    public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	    

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public TipoDeVehiculo getTipo() {
        return tipo;
    }

    @Override
    public int compareTo(Plaza otraPlaza) {
        return Integer.compare(this.numero, otraPlaza.numero);
    }

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plaza other = (Plaza) obj;
		return Objects.equals(numero, other.numero);
	}
	
	}
    
