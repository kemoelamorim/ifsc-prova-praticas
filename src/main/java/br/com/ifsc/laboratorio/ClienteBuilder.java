package br.com.ifsc.laboratorio;

import java.util.Date;

public class ClienteBuilder {
  
  public Cliente cliente;
  public Orcamento orcamento;
  public Procedimento procedimento;

  public ClienteBuilder addNomeCliente(String nome){
    cliente.nome = nome;
    return this;
  }

  public ClienteBuilder addTelefoneCliente(String telefone){
    cliente.telefone = telefone;
    return this;
  }

  public ClienteBuilder addCpfCliente(String cpf){
    cliente.cpf = cpf;
    return this;
  }

  public ClienteBuilder addProcedimentoCliente(String nome, double valor){
    this.procedimento.nome = nome;
    this.procedimento.valor = valor;
    this.orcamento.procedimentos.add(this.procedimento);
    return this;
  }

  public ClienteBuilder dataOrcamentoCliente(Date data){
    this.orcamento.data = data;
    return this;
  }

  public Cliente build(){
    this.orcamento.valor = this.orcamento.valorTotalOrcamento();
    this.cliente.orcamentos.add(this.orcamento);
    return cliente;
  }

}
