package br.com.ifsc.laboratorio;

import java.util.LinkedList;

public class Cliente extends AbstractMongoEntity{
  String nome;
  String telefone;
  LinkedList <Orcamento> orcamentos = new LinkedList<Orcamento>();
  String cpf;

}
