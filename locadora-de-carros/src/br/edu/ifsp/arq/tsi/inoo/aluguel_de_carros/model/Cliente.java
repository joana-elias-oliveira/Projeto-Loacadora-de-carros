package br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.model;

public abstract class Cliente {
    private static int contadorClientes = 1;

    private int codigo;
    private String nome;
    private String documento;

    public Cliente(String nome, String documento) {
        this.codigo = contadorClientes++;
        this.nome = nome;
        this.documento = documento;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                '}';
    }
}
