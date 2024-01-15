package br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.model.Carro;
import br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.model.Cliente;
import br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.model.Locacao;

public class GerenciadorLocacao {
    private List<Locacao> locacoes;

    public GerenciadorLocacao() {
        this.locacoes = new ArrayList<>();
    }

    public Locacao realizarLocacao(int numeroDiarias, Cliente cliente, Carro carro) {
        Locacao locacao = new Locacao(numeroDiarias, cliente, carro);
        locacoes.add(locacao);

        return locacao;
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

}
