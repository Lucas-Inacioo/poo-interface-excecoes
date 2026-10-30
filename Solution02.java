import java.util.*;

// Contrato do banco, não altere esta interface
interface Bank {
    Account find(String id) throws AccountNotFoundException;

    void deposit(String id, double amount) throws AccountNotFoundException;

    void withdraw(String id, double amount) throws AccountNotFoundException, InsufficientFundsException;

    void transfer(String fromId, String toId, double amount) throws AccountNotFoundException, InsufficientFundsException;
}

// Escreva aqui as classes InsufficientFundsException, AccountNotFoundException, Account e SimpleBank

public class Solution02 {
    public static void main(String[] args) {
        // Garante o ponto como separador decimal, qualquer que seja o idioma do computador
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        Account[] accounts = new Account[m];

        for (int i = 0; i < m; i++) {
            String[] parts = scanner.nextLine().split(" ");
            accounts[i] = new Account(parts[0], Double.parseDouble(parts[1]));
        }

        int n = Integer.parseInt(scanner.nextLine());
        String[] operations = new String[n];

        for (int i = 0; i < n; i++) {
            operations[i] = scanner.nextLine();
        }
        scanner.close();

        Bank bank = new SimpleBank(accounts);

        // Processe as operações aqui, na ordem da entrada, com uma linha de saída para cada uma

        for (Account account : accounts) {
            System.out.printf("final balance %s: %.2f%n", account.getId(), account.getBalance());
        }
    }
}
