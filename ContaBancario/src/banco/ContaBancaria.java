package banco;

import java.util.Scanner;

public class ContaBancaria {
    private double saldo;
    private double chequeEspecial;
    private double limiteChequeEspecial;

    public ContaBancaria(double depositoInicial) {
        this.saldo = depositoInicial;
        if (depositoInicial <= 500) {
            this.limiteChequeEspecial = 50.0;
        } else {
            this.limiteChequeEspecial = depositoInicial * 0.5;
        }
        this.chequeEspecial = 0.0;
    }

    // Consultar o saldo total (incluindo cheque especial)
    public double consultarSaldo() {
        return saldo + chequeEspecial;
    }

    // Consultar o limite do cheque especial
    public double consultarChequeEspecial() {
        return limiteChequeEspecial;
    }

    // Depositar dinheiro
    public void depositar(double valor) {
        saldo += valor;
    }

    // Realizar saque
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        } else if (valor <= saldo + limiteChequeEspecial) {
            // Pergunta ao usuário se deseja usar o cheque especial
            Scanner scanner = new Scanner(System.in);
            System.out.println("Você não tem saldo suficiente para esse saque.");
            if (limiteChequeEspecial > 0) {
                System.out.print("Deseja usar o cheque especial? (S/N): ");
                String resposta = scanner.nextLine();
                if (resposta.equalsIgnoreCase("S")) {
                    double valorUsadoChequeEspecial = valor - saldo;
                    chequeEspecial -= valorUsadoChequeEspecial;
                    saldo = 0;

                    // Mostrar o valor utilizado do cheque especial e o saldo atualizado
                    System.out.println("Valor usado do cheque especial: R$" + valorUsadoChequeEspecial);
                    double saldoChequeEspecialRestante = limiteChequeEspecial - Math.abs(chequeEspecial);
                    System.out.println("Saldo do cheque especial restante: R$" + saldoChequeEspecialRestante);
                    return true;
                } else {
                    System.out.println("Operação cancelada.");
                    return false;
                }
            } else {
                System.out.println("Você não tem limite de cheque especial para saque.");
                return false;
            }
        }
        return false;
    }

    // Pagar boleto
    public boolean pagarBoleto(double valor) {
        if (valor <= saldo) {
            // Pagar com o saldo disponível
            saldo -= valor;
            return true;
        } else if (valor <= saldo + limiteChequeEspecial) {
            // Perguntar se deseja usar o cheque especial
            Scanner scanner = new Scanner(System.in);
            System.out.println("Saldo insuficiente para pagar o boleto.");
            System.out.print("Deseja usar o cheque especial para pagar o boleto? (S/N): ");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("S")) {
                // Calcular quanto será utilizado do cheque especial
                double valorUsadoChequeEspecial = valor - saldo;
                chequeEspecial -= valorUsadoChequeEspecial;
                saldo = 0;

                // Mostrar o valor utilizado do cheque especial e o saldo atualizado
                System.out.println("Valor usado do cheque especial: R$" + valorUsadoChequeEspecial);
                double saldoChequeEspecialRestante = limiteChequeEspecial - Math.abs(chequeEspecial);
                System.out.println("Saldo do cheque especial restante: R$" + saldoChequeEspecialRestante);
                return true;
            } else {
                System.out.println("Operação cancelada.");
                return false;
            }
        }
        // Caso não haja saldo e nem limite de cheque especial
        System.out.println("Saldo insuficiente e não há limite de cheque especial para pagar o boleto.");
        return false;
    }

    // Verificar o uso do cheque especial
    public boolean verificarUsoChequeEspecial() {
        if (chequeEspecial < 0) {
            System.out.println("Você está utilizando o cheque especial.");
            System.out.println("Valor utilizado do cheque especial: R$" + Math.abs(chequeEspecial));
            double saldoChequeEspecialRestante = limiteChequeEspecial - Math.abs(chequeEspecial);
            System.out.println("Saldo do cheque especial restante: R$" + saldoChequeEspecialRestante);
            return true;
        }
        System.out.println("Você não está utilizando o cheque especial.");
        return false;
    }

    // Cobrar taxa de 20% sobre o valor utilizado do cheque especial
    public void cobrarTaxa() {
        if (chequeEspecial < 0) {
            double taxa = Math.abs(chequeEspecial) * 0.20; // Calcula 20% da dívida no cheque especial
            chequeEspecial += taxa;

            // Exibe a cobrança da taxa
            System.out.println("Foi cobrada uma taxa de R$" + taxa + " sobre o cheque especial utilizado.");
            double saldoChequeEspecialRestante = limiteChequeEspecial - Math.abs(chequeEspecial);
            System.out.println("Saldo do cheque especial após cobrança: R$" + saldoChequeEspecialRestante);
        }
    }
}
