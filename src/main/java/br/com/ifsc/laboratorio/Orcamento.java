package br.com.ifsc.laboratorio;

import java.util.Date;
import java.util.LinkedList;

public class Orcamento extends AbstractMongoEntity {

  LinkedList<Procedimento> procedimentos = new LinkedList<Procedimento>();
  double valor;
  Date data;
  
  public double valorTotalOrcamento(){
    for(Procedimento procedimento : procedimentos){
      this.valor += procedimento.valor;
    }
    return this.valor;
  }
 
}
