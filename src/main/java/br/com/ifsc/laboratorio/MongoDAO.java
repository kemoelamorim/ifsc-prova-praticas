package br.com.ifsc.laboratorio;

import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import java.util.ArrayList;

import org.bson.types.ObjectId;

public class MongoDAO<E extends AbstractMongoEntity> {

  private MongoCollection col;
  private Class clazz;
  
  public MongoCollection getCol() {
      return col;
  }

  public MongoDAO(Class clazz) {
      this.col = MongoConnectionUtil.getInstance().getCollection(clazz.getName());
      this.clazz = clazz;
  }

  public void salvar(E e) {
      if (e.codigo == null) {
          System.out.println("Inserindo " + e);
          col.insert(e);
      } else {
          System.out.println("Atualizando " + e);
          col.update(new ObjectId(e.codigo)).with(e);
      }
  }

  public void remover(E e) {
      col.remove(new ObjectId(e.codigo));
  }

  public void removerTodos() {
      col.remove();
  }

  public ArrayList<E> getAll() {
      ArrayList<E> lista = new ArrayList<>();
      MongoCursor<E> res = col.find().as(clazz);
      for (E re : res) {
          lista.add(re);
      }
      return lista;
  }
}

