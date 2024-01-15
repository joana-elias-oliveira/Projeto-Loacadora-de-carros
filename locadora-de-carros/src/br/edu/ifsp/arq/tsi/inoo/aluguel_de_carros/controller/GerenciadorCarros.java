package br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.model.Carro;

public class GerenciadorCarros {
    private static GerenciadorCarros instancia;
    private List<Carro> carros;

    private GerenciadorCarros() {
        this.carros = new ArrayList<>();
    }

    public static GerenciadorCarros getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorCarros();
        }
        return instancia;
    }

    public void adicionarCarro(Carro carro) {
        carros.add(carro);
    }

    public Carro buscarCarroPorPlaca(String placa) {
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)) {
                return carro;
            }
        }
        return null;
    }
}
