package br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.model;

public class PessoaFisica extends Cliente {
    private String cpf;

    public PessoaFisica(String nome, String cpf) {
        super(nome, cpf);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
