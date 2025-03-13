import banco.ContaBancaria;
import banco.Operacoes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor do depósito inicial para abrir a conta: ");
        double depositoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(depositoInicial);
        int opcao;

        do {
            System.out.println("\nMENU:");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar cheque especial");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Pagar boleto");
            System.out.println("6 - Verificar uso de cheque especial");
            System.out.println("7 - Cobrar taxa de cheque especial");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Operacoes.consultarSaldo(conta);
                    break;
                case 2:
                    Operacoes.consultarChequeEspecial(conta);
                    break;
                case 3:
                    System.out.print("Digite o valor a ser depositado: ");
                    double deposito = scanner.nextDouble();
                    Operacoes.realizarDeposito(conta, deposito);
                    break;
                case 4:
                    System.out.print("Digite o valor a ser sacado: ");
                    double saque = scanner.nextDouble();
                    Operacoes.realizarSaque(conta, saque);
                    break;
                case 5:
                    System.out.print("Digite o valor do boleto: ");
                    double boleto = scanner.nextDouble();
                    Operacoes.pagarBoleto(conta, boleto);
                    break;
                case 6:
                    Operacoes.verificarChequeEspecial(conta);
                    break;
                case 7:
                    Operacoes.cobrarTaxaChequeEspecial(conta);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}