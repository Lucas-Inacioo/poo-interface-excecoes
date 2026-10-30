import java.util.*;

// Escreva a classe InsufficientFundsException aqui, herdando de Exception

// Escreva a classe AccountNotFoundException aqui, herdando de Exception

// Escreva a classe Account aqui

// Escreva a classe Bank aqui

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

        Bank bank = new Bank(accounts);
        bank.process(operations);

        for (Account account : accounts) {
            System.out.printf("final balance %s: %.2f%n", account.getId(), account.getBalance());
        }
    }
}
