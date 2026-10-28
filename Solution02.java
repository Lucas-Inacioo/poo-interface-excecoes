import java.util.*;

// Escreva a classe InsufficientFundsException aqui, herdando de Exception

// Escreva a classe Account aqui

// Escreva a classe Bank aqui, com o método process

public class Solution02 {
    public static void main(String[] args) {
        // Garante o ponto como separador decimal, qualquer que seja o idioma do computador
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        double initialBalance = Double.parseDouble(scanner.next());
        int n = Integer.parseInt(scanner.next());
        String[] types = new String[n];
        double[] amounts = new double[n];

        for (int i = 0; i < n; i++) {
            types[i] = scanner.next();
            amounts[i] = Double.parseDouble(scanner.next());
        }
        scanner.close();

        Account account = new Account(initialBalance);
        Bank.process(account, types, amounts);
        System.out.printf("final balance: %.2f%n", account.getBalance());
    }
}
