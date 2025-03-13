package PetShop;


public class MaquinaDeBanhoPet {
    private int nivelAgua = 30;
    private int nivelShampoo = 10;
    private boolean animalEstimacao = false;
    private boolean limparMaquina = true;

    public void adicionarAgua() {
        if (nivelAgua <= 28) {
            nivelAgua += 2;
            System.out.println("Água abastecida. Nível atual: " + nivelAgua);
        } else {
            System.out.println("Tanque de água cheio.");
        }
    }

    public void adicionarShampoo() {
        if (nivelShampoo <= 8) {
            nivelShampoo += 2;
            System.out.println("Shampoo abastecido. Nível atual: " + nivelShampoo);
        } else {
            System.out.println("Tanque de shampoo cheio.");
        }
    }

    public void checarNivelAgua() {
        System.out.println("Nível de água: " + nivelAgua);
    }

    public void chegarNivelshampoo() {
        System.out.println("Nível de shampoo: " + nivelShampoo);
    }

    public void colocarPet() {
        if (!animalEstimacao) {
            animalEstimacao = true;
            limparMaquina = false;
            System.out.println("Pet colocado na máquina.");
        } else {
            System.out.println("Já existe um pet na máquina.");
        }
    }

    public void removePet() {
        if (animalEstimacao) {
            animalEstimacao = false;
            System.out.println("Pet removido da máquina.");
        } else {
            System.out.println("Não há pet na máquina.");
        }
    }

    public void darbanho() {
        if (animalEstimacao && nivelAgua >= 10 && nivelShampoo >= 2) {
            nivelAgua -= 10;
            nivelShampoo -= 2;
            limparMaquina = true;
            System.out.println("Banho dado com sucesso.");
        } else if (!animalEstimacao) {
            System.out.println("Não há pet na máquina.");
        } else {
            System.out.println("Níveis insuficientes de água ou shampoo.");
        }
    }

    public void executarLimpezaMaquina() {
        if (nivelAgua >= 3 && nivelShampoo >= 1) {
            nivelAgua -= 3;
            nivelShampoo -= 1;
            limparMaquina = true;
            System.out.println("Máquina limpa.");
        } else {
            System.out.println("Níveis insuficientes de água ou shampoo para limpar.");
        }
    }
}