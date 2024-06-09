package gestionMantenimientoBP;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MantenimientoBP {
	//MAIN
	public static void main(String[] args) {
		List<Edificio> listaEdificios = new ArrayList<Edificio>();
		menuPrincipal(listaEdificios);
	}
	
	
	//METODOS
	public static void menuPrincipal(List<Edificio> listaEdificios) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("***********GESTION MANTENIMIENTO BP************");
		System.out.println("****Menu Principal****");
		System.out.println("1- Agregar Edificio");
		System.out.println("2- Lista de Edificios");
		System.out.println("3- Modificar Edificio (Nombre, Localidad y Direccion)");
		System.out.println("4- Agregar Equipamiento");
		System.out.println("5- Mostrar Equipamiento por Nro de Edificio");
		System.out.println("9- Salir");
		System.out.println("**********************************************");
		
		System.out.println("Elija una opcion: ");
		try {
			int opcion = scanner.nextInt();
			
			switch(opcion) {
				case 1:  {   
					Edificio.agregarEdificio(listaEdificios);
					menuPrincipal(listaEdificios);
	            break;
				}
				
				case 2:  {   
					for(Edificio e:listaEdificios) {
						System.out.println(e.mostrarEdificios());
					}
					menuPrincipal(listaEdificios);
	            break;
				}
				
				case 3:  {   
					Edificio.modificarEdificio(listaEdificios);
					menuPrincipal(listaEdificios);
	            break;
				}
				
				case 4:  {   
					Equipamiento.agregarEquipamiento(listaEdificios);
					menuPrincipal(listaEdificios);
	            break;
				}
				
				case 5:  {   
					Equipamiento.mostrarEquipamiento(listaEdificios);
					menuPrincipal(listaEdificios);
	            break;
				}
				
				case 9:  {   
					System.out.println("\n***PROGRAMA FINALIZADO***");
					System.exit(0);
	            break;
				}
				
				default: {
					System.out.println("\nOpcion incorrecta, por favor ingresar un numero valido!!!\n");
					menuPrincipal(listaEdificios);
				}
			}
		}catch(InputMismatchException e) {
			System.out.println("\nEntrada no valida, por favor ingrese un número.\n");
            scanner.next();
            menuPrincipal(listaEdificios);
		}
	}
}
