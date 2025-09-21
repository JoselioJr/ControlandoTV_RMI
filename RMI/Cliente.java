
import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            ControleRemoto controle = (ControleRemoto) Naming.lookup("rmi://192.168.1.105/ControleRemoto");
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("=== CONTROLE REMOTO ===");
            
            while (true) {
                System.out.println("\n1 - Ligar/Desligar TV");
                System.out.println("2 - Mudar Canal");
                System.out.println("3 -Aumentar Volume");
                System.out.println("4 - Diminuir Volume");
                System.out.println("5 - Mutar/Desmutar");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                
                int opcao = scanner.nextInt();
                
                switch (opcao) {
                    case 1:
                        controle.ligarDesligar();
                        break;
                    case 2:
                        System.out.print("Digite o canal: ");
                        int canal = scanner.nextInt();
                        controle.mudarCanal(canal);
                        break;
                    case 3:
                        controle.aumentarVolume();
                        break;
                    case 4:
                        controle.diminuirVolume();
                        break;
                    case 5:
                        controle.mutarDesmutar();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            }
        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.getMessage());
        }
    }
}