package br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.model;

public class PessoaJuridica extends Cliente {
    private String cnpj;
    private String razaoSocial;

    public PessoaJuridica(String nome, String cnpj, String razaoSocial) {
        super(nome, cnpj);  
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }
}
