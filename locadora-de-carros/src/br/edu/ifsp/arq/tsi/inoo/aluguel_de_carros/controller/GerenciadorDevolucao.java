package br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.controller;

import java.time.LocalDate;

import br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.model.Locacao;

public class GerenciadorDevolucao {
    public void realizarDevolucao(Locacao locacao) {
        // se a locação já foi devolvida
        if (locacao.getDataDevolucao() != null) {
            System.out.println("Esta locação já foi devolvida anteriormente.");
            return;
        }

        // data de devolução como a data atual
        locacao.setDataDevolucao(LocalDate.now());

        // valor total da locação
        double valorTotal = locacao.calcularValorTotal();

        // Atualiza o estado da aplicação 
        locacao.getCarro().setDisponivel(true);

        // o valor total da locação 
        System.out.println("Valor total da locação: R$ " + valorTotal);

    
    }
}
