package br.com.ifsc.laboratorio;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

public class MongoConnectionUtil {
  private static MongoConnectionUtil instance;
  private Jongo jongo;
  public static MongoConnectionUtil getInstance() {
      if(instance==null){
          instance = new MongoConnectionUtil();
      }
      return instance;
  }
  /**
   * 
   */
  private MongoConnectionUtil(){
      try {
          MongoClient mongoClient = new MongoClient("localhost");
          DB mdb = mongoClient.getDB("praticas");
          jongo = new Jongo(mdb);
          
      } catch (UnknownHostException ex) {
          Logger.getLogger(MongoConnectionUtil.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  public MongoCollection getCollection(String col){
      return jongo.getCollection(col);
  }
  public DB getDB(String string) {
    return null;
  }
}
