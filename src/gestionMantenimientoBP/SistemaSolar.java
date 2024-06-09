package gestionMantenimientoBP;

public class SistemaSolar extends Equipamiento{
	//ATRIBUTOS
	private String marca;
	private double capacidad;
	
	//CONSTRUCTOR
	public SistemaSolar(int id, String marca, double capacidad) {
		super(id);
		this.marca = marca;
		this.capacidad = capacidad;
	}

	//METODOS
	@Override
	public String toString() {
		return "SistemaSolar [marca=" + marca + ", capacidad=" + capacidad + "]";
	}

}
