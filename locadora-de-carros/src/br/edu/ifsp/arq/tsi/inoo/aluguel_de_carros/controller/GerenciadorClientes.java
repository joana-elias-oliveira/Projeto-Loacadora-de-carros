package br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.model.Cliente;
import br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.model.PessoaFisica;
import br.edu.ifsp.arq.tsi.inoo.aluguel_de_carros.model.PessoaJuridica;

public class GerenciadorClientes {
    private static GerenciadorClientes instancia;
    private List<Cliente> clientes;

    private GerenciadorClientes() {
        this.clientes = new ArrayList<>();
    }

    public static GerenciadorClientes getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorClientes();
        }
        return instancia;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente instanceof PessoaFisica && ((PessoaFisica) cliente).getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente buscarClientePorCnpj(String cnpj) {
        for (Cliente cliente : clientes) {
            if (cliente instanceof PessoaJuridica && ((PessoaJuridica) cliente).getCnpj().equals(cnpj)) {
                return cliente;
            }
        }
        return null;
    }
}
