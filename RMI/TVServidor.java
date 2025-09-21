
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TVServidor extends UnicastRemoteObject implements ControleRemoto {
    private boolean ligada = false;
    private int canal = 1;
    private int volume = 10;
    private boolean mutada = false;

    public TVServidor() throws RemoteException {
        super();
    }

    @Override
    public void ligarDesligar() throws RemoteException {
        ligada = !ligada;

        if (ligada) {
            System.out.println("TV ligada");
        } else {
            System.out.println("TV desligada");
        }
    }

    @Override
    public void mudarCanal(int novoCanal) throws RemoteException {
        if (ligada && novoCanal > 0) {
            canal = novoCanal;
            System.out.println("Canal alterado para: " + canal);
        } else {
            System.out.println("TV desligada ou canal inválido");
        }
    }

    @Override
    public void aumentarVolume() throws RemoteException {
        if (ligada) {
            if (volume < 100) {
                volume++;
                System.out.println("Volume: " + volume);
            } else {
                System.out.println("Volume máximo");
            }
        } else {
            System.out.println("TV desligada");
        }
    }

    @Override
    public void diminuirVolume() throws RemoteException {
        if (ligada) {
            if (volume > 0) {
                volume--;
                System.out.println("Volume: " + volume);
            } else {
                System.out.println("Volume mínimo");
            }
        } else {
            System.out.println("TV desligada");
        }
    }

    @Override
    public void mutarDesmutar() throws RemoteException {
        if (ligada) {
            mutada = !mutada;
            
            if (mutada) {
                System.out.println("TV mutada");
            } else {
                System.out.println("TV desmutada");
            }
        } else {
            System.out.println("TV desligada");
        }
    }
}