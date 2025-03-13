package com.app;
import PetShop.MaquinaDeBanhoPet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MaquinaDeBanhoPet maquina = new MaquinaDeBanhoPet();
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Abastecer com água");
            System.out.println("2. Abastecer com shampoo");
            System.out.println("3. Verificar nível de água");
            System.out.println("4. Verificar nível de shampoo");
            System.out.println("5. Colocar pet na máquina");
            System.out.println("6. Dar banho no pet");
            System.out.println("7. Retirar pet da máquina");
            System.out.println("8. Limpar máquina");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1 -> maquina.adicionarAgua();
                case 2 -> maquina.adicionarShampoo();
                case 3 -> maquina.checarNivelAgua();
                case 4 -> maquina.chegarNivelshampoo();
                case 5 -> maquina.colocarPet();
                case 6 -> maquina.darbanho();
                case 7 -> maquina.removePet();
                case 8 -> maquina.executarLimpezaMaquina();
                case 9 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (escolha != 9);

        scanner.close();
    }
}
