# Locadora de Carros em Java

Este é um projeto de uma locadora de carros implementado em Java, onde usuários podem alugar carros disponíveis no sistema.

## Funcionalidades
-Cadastro de Clientes:
  * Cada cliente possui um código único, nome e informações específicas de pessoa física (CPF) ou pessoa jurídica (CNPJ e razão social).
  * A estrutura de dados impede a inserção de clientes duplicados.

-Cadastro de Carros:
  * Cada carro possui um código único, marca, modelo, ano, placa, quantidade de portas, presença de ar-condicionado, valor da diária de locação e estado (disponível ou locado).
  * Inicialmente, todos os carros cadastrados estão disponíveis.

-Realização de Locações:
  * O sistema permite a realização de locações, registrando informações como número da locação, data de realização, número de diárias, cliente e carro escolhido.
  * Atualizações necessárias são realizadas por uma classe de gerenciamento.

-Devoluções:
  * A realização de devoluções calcula e exibe o valor total da locação com base no valor da diária e no número de diárias efetivadas.
  * O sistema atualiza o estado do carro para disponível e finaliza a locação.
  * A responsabilidade pela devolução é atribuída a uma classe específica de gerenciamento.

-Gerenciamento Flexível:
  * Classes de gerenciamento de clientes e carros são codificadas de forma flexível e acessíveis globalmente.
  * Utilização do padrão de projeto Singleton para garantir uma única coleção de clientes e carros.

## Tecnologias Utilizadas
- Java

## Pré-requisitos
- Java JDK instalado

## Configuração

1. Clone o repositório:
   ```bash
   git clone https://github.com/joana-elias-oliveira/Projeto-alocadora-de-carros.git
