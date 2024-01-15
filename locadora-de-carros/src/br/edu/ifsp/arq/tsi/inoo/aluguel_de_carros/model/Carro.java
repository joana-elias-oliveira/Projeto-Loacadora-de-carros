package br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.model;

public class Carro {
    private static int contadorCarros = 0;
    private int codigo;
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private int quantidadePortas;
    private boolean arCondicionado;
    private double valorDiaria;
    private boolean disponivel;

    public Carro(String marca, String modelo, int ano, String placa, int quantidadePortas, boolean arCondicionado, double valorDiaria) {
        this.codigo = ++contadorCarros;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.quantidadePortas = quantidadePortas;
        this.arCondicionado = arCondicionado;
        this.valorDiaria = valorDiaria;
        this.disponivel = true;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public String getPlaca() {
        return placa;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }


}
