
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Servidor {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            TVServidor tv = new TVServidor();
            Naming.rebind("rmi://192.168.1.105/ControleRemoto", tv);
            System.out.println("Servidor RMI iniciado. TV pronta para receber comandos...");
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.getMessage());
        }
    }
}