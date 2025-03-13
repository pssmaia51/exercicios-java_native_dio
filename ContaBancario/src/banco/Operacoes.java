package banco;

public class Operacoes {

    public static void realizarDeposito(ContaBancaria conta, double valor) {
        conta.depositar(valor);
        System.out.println("Depósito realizado com sucesso!");
    }

    public static void realizarSaque(ContaBancaria conta, double valor) {
        if (conta.sacar(valor)) {
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public static void pagarBoleto(ContaBancaria conta, double valor) {
        if (conta.pagarBoleto(valor)) {
            System.out.println("Boleto pago com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para pagar o boleto!");
        }
    }

    public static void consultarSaldo(ContaBancaria conta) {
        System.out.println("Saldo total (incluindo cheque especial): R$" + conta.consultarSaldo());
    }

    public static void consultarChequeEspecial(ContaBancaria conta) {
        System.out.println("Limite de cheque especial: R$" + conta.consultarChequeEspecial());
    }

    public static void verificarChequeEspecial(ContaBancaria conta) {
        if (conta.verificarUsoChequeEspecial()) {
            System.out.println("Você está utilizando o cheque especial.");
        } else {
            System.out.println("Você não está utilizando o cheque especial.");
        }
    }

    public static void cobrarTaxaChequeEspecial(ContaBancaria conta) {
        conta.cobrarTaxa();
        System.out.println("Taxa de cheque especial cobrada.");
    }
}
