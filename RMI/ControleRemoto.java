
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ControleRemoto extends Remote {
    void ligarDesligar() throws RemoteException;
    void mudarCanal(int canal) throws RemoteException;
    void aumentarVolume() throws RemoteException;
    void diminuirVolume() throws RemoteException;
    void mutarDesmutar() throws RemoteException;
}