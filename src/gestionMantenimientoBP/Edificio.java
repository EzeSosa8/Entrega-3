package gestionMantenimientoBP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Edificio {
	//ATRIBUTOS
	private int id;
	private String nombre;
	private String localidad;
	private String direccion;
	private List<Equipamiento> equipamiento;
	
	//CONSTRUCTOR
	public Edificio(int id, String nombre, String localidad, String direccion, List<Equipamiento> equipamiento) {
		this.id = id;
		this.nombre = nombre;
		this.localidad = localidad;
		this.direccion = direccion;
		this.equipamiento = equipamiento;
	}
	
	//METODOS
	public String mostrarEdificios() {
		return("Edificio Nro: " +id+ " ("+ nombre + ") - Localidad: " + localidad + " - Direccion: " + direccion);
	}
	
	public static void agregarEdificio(List<Edificio> listaEdificios) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingrese el numero de edificio: ");
		int id = scanner.nextInt();
		System.out.println("Ingrese el nombre del edificio: ");
		String nombre = scanner.next();
		System.out.println("Ingrese la localidad del edificio: ");
		String localidad = scanner.next();
		System.out.println("Ingrese la direccion del edificio: ");
		String direccion = scanner.next();
		
		List<Equipamiento> equipamiento = new ArrayList<>();
		Edificio edificio = new Edificio(id, nombre, localidad, direccion, equipamiento);
		listaEdificios.add(edificio);
		
		System.out.println("***NUEVO EDIFICIO AGREGADO***\n");
	}
	
	public static int buscarEdificio(List<Edificio> listaEdificios) {
		Scanner scanner = new Scanner(System.in);
		Edificio auxiliar[] = new Edificio[listaEdificios.size()];
		listaEdificios.toArray(auxiliar);
		int posicion = -1;
		
		System.out.println("\n****LISTADO DE EDIFICIOS****");
		for(Edificio e:listaEdificios) {
			System.out.println(e.mostrarEdificios());
		}
		System.out.println("\n***Ingrese numero de edificio al que desea agregar equipamiento(-1 para volver a Menu Principal): ");
		int id = scanner.nextInt();
		
		for(int i=0; i<auxiliar.length; i++) {
			if(auxiliar[i].getIdEdificio()==id) {
				posicion = i;
			}
		}
		return posicion;
	}
	
	public static void modificarEdificio(List<Edificio> listaEdificios) {
		Scanner scanner = new Scanner(System.in);

		int posicion = buscarEdificio(listaEdificios);
		
		if(posicion==-1) {
			System.out.println("****Nro DE EDIFICIO NO EXISTE****\n");
			MantenimientoBP.menuPrincipal(listaEdificios);
		}else {
			int id = listaEdificios.get(posicion).getIdEdificio();
			System.out.println("Ingrese el nombre del edificio: ");
			String nombre = scanner.next();
			System.out.println("Ingrese la localidad del edificio: ");
			String localidad = scanner.next();
			System.out.println("Ingrese la direccion del edificio: ");
			String direccion = scanner.next();
			
			List<Equipamiento> equipamiento = listaEdificios.get(posicion).getEquipamiento();
			listaEdificios.set(posicion, new Edificio(id, nombre, localidad, direccion, equipamiento));
		}
	}
	
	public int getIdEdificio() {
		return id;
	}
	
	public String getNombreEdificio() {
		return nombre;
	}
	
	public String getLocalidadEdificio() {
		return localidad;
	}
	
	public String getDireccionEdificio() {
		return direccion;
	}
	
	public List<Equipamiento> getEquipamiento(){
		return equipamiento;
	}
}
