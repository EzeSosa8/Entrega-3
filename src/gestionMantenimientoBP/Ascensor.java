package gestionMantenimientoBP;

public class Ascensor extends Equipamiento{
	//ATRIBUTOS
	private String marca;
	private double potenciaMotor;
	
	//CONSTRUCTOR
	public Ascensor(int id, String marca, double potenciaMotor) {
		super(id);
		this.marca = marca;
		this.potenciaMotor = potenciaMotor;
	}

	//METODOS
	@Override
	public String toString() {
		return "Ascensor [marca=" + marca + ", potenciaMotor=" + potenciaMotor + "]";
	}

	
}
