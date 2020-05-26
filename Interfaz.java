import java.rmi.Remote;
import java.rmi.RemoteException;

/*
	Declarar firma de métodos que serán sobrescritos
*/
public interface Interfaz extends Remote {
    //String hola(String nombre) throws RemoteException;
    float suma(float resultado) throws RemoteException;
    float resta(float resultado) throws RemoteException;
    float multiplicacion(float resultado) throws RemoteException;
    float division(float resultado) throws RemoteException;



}