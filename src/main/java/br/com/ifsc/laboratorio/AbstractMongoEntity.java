package br.com.ifsc.laboratorio;

import org.jongo.marshall.jackson.oid.MongoObjectId;

public class AbstractMongoEntity {
  @MongoObjectId
  public String codigo;
}
