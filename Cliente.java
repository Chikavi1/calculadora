import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class Cliente {
	private static final String IP = "localhost"; // Puedes cambiar a localhost
	private static final int PUERTO = 1200; //Si cambias aquí el puerto, recuerda cambiarlo en el servidor

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(IP, PUERTO);
        Interfaz interfaz = (Interfaz) registry.lookup("Ejemplo"); //Buscar en el registro...
		float respuesta = 0;
		float a, b, resultado;
		int menu;
		Scanner sc = new Scanner(System.in);
		//int eleccion;
		do {
			System.out.println("\t\t**** CALCULADORA RMI ****");
			System.out.println("Que quieres hacer?");
			System.out.println("1. Sumar \n2. Restar \n3. Multiplicacar \n4. Dividir");

			try {
                menu = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                menu = -1;
            }

			switch(menu){
				case 1:
				System.out.println("Ingresa el primer numero: ");
				a = sc.nextFloat();
				System.out.println("Ingresa el segundo numero: ");
				b = sc.nextFloat();
				resultado = a + b;
				respuesta = interfaz.suma(resultado);
				break;

				case 2:
				System.out.println("Ingresa el primer numero: ");
				a = sc.nextFloat();
				System.out.println("Ingresa el segundo numero: ");
				b = sc.nextFloat();
				resultado = a - b;
				respuesta = interfaz.resta(resultado);

				break;

				case 3:
				System.out.println("Ingresa el primer numero: ");
				a = sc.nextFloat();
				System.out.println("Ingresa el segundo numero: ");
				b = sc.nextFloat();
				resultado = a * b;
				respuesta = interfaz.multiplicacion(resultado);

				break;

				case 4:
				System.out.println("Ingresa el primer numero: ");
				a = sc.nextFloat();
				System.out.println("Ingresa el segundo numero: ");
				b = sc.nextFloat();
				resultado = a / b;
				respuesta = interfaz.division(resultado);

				break;

				default:
				System.out.println("Ingresa opcion valida");


			}

				System.out.println("El resultado es: " + respuesta);
                sc.nextLine();

        } while (menu != -1);
    }
}
