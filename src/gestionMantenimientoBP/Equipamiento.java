package gestionMantenimientoBP;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public abstract class Equipamiento {
	//ATRIBUTOS
	private int id;
	
	//CONSTRUCTOR
	public Equipamiento(int id) {
		this.id = id;
	}

	//METODOS
	@Override
	public String toString() {
		return "Equipamiento [id=" + id + "]";
	}
	
	public static void agregarEquipamiento(List<Edificio> listaEdificios) {
		int posicion = Edificio.buscarEdificio(listaEdificios);
		Scanner scanner = new Scanner(System.in);

		if(posicion==-1) {
			System.out.println("****Nro DE EDIFICIO NO EXISTE****\n");
			MantenimientoBP.menuPrincipal(listaEdificios);
		}else {
			int id = listaEdificios.get(posicion).getIdEdificio();
			String nombre = listaEdificios.get(posicion).getNombreEdificio();
			String localidad = listaEdificios.get(posicion).getLocalidadEdificio();
			String direccion = listaEdificios.get(posicion).getDireccionEdificio();
			
			System.out.println("***********TIPO DE EQUIPO************");
			System.out.println("1- Aire Acondicionado");
			System.out.println("2- Grupo Electrogeno");
			System.out.println("3- Sistema de Energia Solar");
			System.out.println("4- Ascensor");
			System.out.println("9- Volver");
			System.out.println("Ingrese la opcion que desea: ");
			
			try {
				int opcion = scanner.nextInt();
				switch(opcion) {
			case 1:  {   
				System.out.println("Ingrese el numero de equipo: ");
				int idEquipo = scanner.nextInt();
				System.out.println("Ingrese la marca del equipo: ");
				String marca = scanner.next();
				System.out.println("Ingrese el modelo del equipo: ");
				String modelo = scanner.next();
				System.out.println("Ingrese la capacidad del equipo: ");
				double capacidad = scanner.nextDouble();
				
				Equipamiento equipo = new EquipoAA(idEquipo, marca, modelo, capacidad);
				List<Equipamiento> equipamiento = listaEdificios.get(posicion).getEquipamiento();
				equipamiento.add(equipo);
				listaEdificios.set(posicion, new Edificio(id, nombre, localidad, direccion, equipamiento));
				
				System.out.println("***Aire Acondicionado AGREGADO***\n");
				MantenimientoBP.menuPrincipal(listaEdificios);
            break;
			}
			
			case 2:  {   
				System.out.println("Ingrese el numero de equipo: ");
				int idEquipo = scanner.nextInt();
				System.out.println("Ingrese la marca del equipo: ");
				String marca = scanner.next();
				System.out.println("Ingrese el modelo del equipo: ");
				String modelo = scanner.next();
				System.out.println("Ingrese la capacidad del equipo: ");
				double capacidad = scanner.nextDouble();
				
				Equipamiento equipo = new GrupoElectrogeno(idEquipo, marca, modelo, capacidad);
				List<Equipamiento> equipamiento = listaEdificios.get(posicion).getEquipamiento();
				equipamiento.add(equipo);
				listaEdificios.set(posicion, new Edificio(id, nombre, localidad, direccion, equipamiento));
				
				System.out.println("***Grupo Electrogeno AGREGADO***\n");
				MantenimientoBP.menuPrincipal(listaEdificios);
            break;
			}
			
			case 3:  {   
				System.out.println("Ingrese el numero de equipo: ");
				int idEquipo = scanner.nextInt();
				System.out.println("Ingrese la marca del equipo: ");
				String marca = scanner.next();
				System.out.println("Ingrese la capacidad del equipo: ");
				double capacidad = scanner.nextDouble();
				
				Equipamiento equipo = new SistemaSolar(idEquipo, marca, capacidad);
				List<Equipamiento> equipamiento = listaEdificios.get(posicion).getEquipamiento();
				equipamiento.add(equipo);
				listaEdificios.set(posicion, new Edificio(id, nombre, localidad, direccion, equipamiento));
				
				System.out.println("***Sistema de Energia Solar AGREGADO***\n");
				MantenimientoBP.menuPrincipal(listaEdificios);
            break;
			}
			
			case 4:  {   
				System.out.println("Ingrese el numero de equipo: ");
				int idEquipo = scanner.nextInt();
				System.out.println("Ingrese la marca del equipo: ");
				String marca = scanner.next();
				System.out.println("Ingrese la potencia del motor del equipo: ");
				double potenciaMotor = scanner.nextDouble();
				
				Equipamiento equipo = new Ascensor(idEquipo, marca, potenciaMotor);
				List<Equipamiento> equipamiento = listaEdificios.get(posicion).getEquipamiento();
				equipamiento.add(equipo);
				listaEdificios.set(posicion, new Edificio(id, nombre, localidad, direccion, equipamiento));
				
				System.out.println("***Ascensor AGREGADO***\n");
				MantenimientoBP.menuPrincipal(listaEdificios);
            break;
			}
			
			case 9:  {   
				MantenimientoBP.menuPrincipal(listaEdificios);
            break;
			}
			
			default: {
				System.out.println("\nOpcion incorrecta, por favor ingresar un numero valido!!!\n");
				MantenimientoBP.menuPrincipal(listaEdificios);
			}
			}
			}catch(InputMismatchException e) {
				System.out.println("\nEntrada no valida, por favor ingrese un número.\n");
	            scanner.next();
	            MantenimientoBP.menuPrincipal(listaEdificios);
			}
		}
	}
	
	public static void mostrarEquipamiento(List<Edificio> listaEdificios) {
		Scanner scanner = new Scanner(System.in);

		int posicion = Edificio.buscarEdificio(listaEdificios);
		
		if(posicion==-1) {
			System.out.println("****Nro DE EDIFICIO NO EXISTE****\n");
			MantenimientoBP.menuPrincipal(listaEdificios);
		}else {
			List<Equipamiento> equipamiento = listaEdificios.get(posicion).getEquipamiento();
			for(Equipamiento e:equipamiento) {
				System.out.println(e.toString());
			}
		}
	}
}
