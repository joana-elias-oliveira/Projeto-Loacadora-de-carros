package br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.model;

import java.time.LocalDate;

public class Locacao {
    private static int contadorLocacoes = 0;
    private int numero;
    private LocalDate dataRealizacao;
    private int numeroDiarias;
    private LocalDate dataMaximaDevolucao;
    private LocalDate dataDevolucao;
    private Cliente cliente;
    private Carro carro;
    private double valorTotal;

    public Locacao(int numeroDiarias, Cliente cliente, Carro carro) {
        this.numero = ++contadorLocacoes;
        this.dataRealizacao = LocalDate.now();
        this.numeroDiarias = numeroDiarias;
        this.dataMaximaDevolucao = calcularDataMaximaDevolucao();
        this.dataDevolucao = null; // data de devolução é nula
        this.cliente = cliente;
        this.carro = carro;
    }

    private LocalDate calcularDataMaximaDevolucao() {
        return dataRealizacao.plusDays(numeroDiarias);
    }

    public int getNumero() {
        return numero;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public int getNumeroDiarias() {
        return numeroDiarias;
    }

    public LocalDate getDataMaximaDevolucao() {
        return dataMaximaDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Carro getCarro() {
        return carro;
    }
    public double calcularValorTotal() {
        if (dataDevolucao != null) {
            long diasEfetivados = dataDevolucao.toEpochDay() - dataRealizacao.toEpochDay() + 1;
            System.out.println("Dias efetivados: " + diasEfetivados);
            System.out.println("Valor da diária: " + carro.getValorDiaria());
    
            valorTotal = diasEfetivados * carro.getValorDiaria();
            return valorTotal;
        } else {
            return 0.0; // Ainda não foi devolvido
        }
    }
    
    

    public double getValorTotal() {
        return valorTotal;
    }
}
