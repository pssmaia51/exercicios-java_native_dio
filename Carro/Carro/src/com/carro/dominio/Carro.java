package com.carro.dominio;

public class Carro {
    private boolean ligado;
    private int velocidade;
    private int marcha;

    // Construtor
    public Carro(boolean ligado, int velocidade, int marcha) {
        this.ligado = ligado;
        this.velocidade = velocidade;
        this.marcha = marcha;
    }

    public Carro() {
        this.ligado = false;
        this.velocidade = 0;
        this.marcha = 0;
    }

    // Getters e Setters
    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getMarcha() {
        return marcha;
    }

    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }

    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("Carro ligado.");
        }
    }

    public void desligar() {
        if (ligado && velocidade == 0 && marcha == 0) {
            ligado = false;
            System.out.println("Carro desligado.");
        }
    }

    private void validarVelocidade() {
        int[][] limites = {
                {0, 0},
                {0, 20},
                {21, 40},
                {41, 60},
                {61, 80},
                {81, 100},
                {101, 120}
        };
        int minVel = limites[marcha][0];
        int maxVel = limites[marcha][1];

        if (velocidade < minVel || velocidade > maxVel) {
            System.out.println("Velocidade " + velocidade + " km/h incompatível com a marcha " + marcha + ". Ajustando...");
            velocidade = minVel;
        }
    }

    public void acelerar(){
        if (ligado){
            if (marcha == 0){
                System.out.println("Não e possivel acelerar quando a marcha estiver em ponto morto");
                return;
            }
            if (velocidade < 120){
                velocidade++;
                validarVelocidade();
            }
        }
    }

    public void diminuirVelocidade(){
        if (ligado && velocidade > 0){
            velocidade--;
        }
    }

    public void virar(String direcao) {
        if (ligado && velocidade >= 1 && velocidade <= 40) {
            if ("esquerda".equalsIgnoreCase(direcao) || "direita".equalsIgnoreCase(direcao)) {
                System.out.println("Virando para " + direcao + ".");
            } else {
                System.out.println("Direção inválida.");
            }
        } else {
            System.out.println("Velocidade inadequada para virar.");
        }
    }

    public void verificarVelocidade() {
        System.out.println("Velocidade atual: " + velocidade + " km/h");
    }

    public void trocarMarcha(int novaMarcha) {
        if (!ligado) {
            System.out.println("O carro está desligado.");
            return;
        }
        if (novaMarcha < 0 || novaMarcha > 6) {
            System.out.println("Marcha inválida.");
            return;
        }
        if (Math.abs(novaMarcha - marcha) != 1) {
            System.out.println("Não é permitido pular marchas.");
            return;
        }
        marcha = novaMarcha;
        validarVelocidade();
    }




}
