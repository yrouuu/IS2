
public abstract class Transporte {
	private String id, capacidad, origen, destino;
	private boolean disponibilidad;
	private double precio;
	
	
	
	public Transporte (String id, String capacidad, double precio) {
		this.id=id;
		this.capacidad=capacidad;
		this.precio = precio;
		this.disponibilidad=true;

	}
	
	public void setPrecio (double precio){
	    this.precio=precio;
	}
	
	public double getPrecio (){
	    return this.precio;
	}
	
	public void setDisponibilidad (boolean disponibilidad){
	    this.disponibilidad=disponibilidad;
	}
	
	public boolean getDisponibilidad (){
		return this.disponibilidad;
	}
	
	public String getCapacidad (){
	    return this.capacidad;
	}
	
	public void setOrigen (String origen){
	    this.origen=origen;
	}
	
	public void setDestino (String destino){
	    this.destino=destino;
	}
	
}
