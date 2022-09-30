package br.com.ifsc.laboratorio;

import org.jongo.MongoCollection;

public class Main {
  public static void main(String[] args) {
    
    MongoConnectionUtil mongoClient = MongoConnectionUtil.getInstance();
    MongoCollection col = mongoClient.getCollection("laboratorio");
    System.out.println(col.getName());

    
    MongoDAO<Cliente> cliente =  new MongoDAO<Cliente>(Cliente.class);
      for (Cliente c : cliente.getAll()) {
          System.out.println(c.nome);
      }
        

  }
}
