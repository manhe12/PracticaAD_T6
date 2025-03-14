package es.studium.practicaT6;

import org.bson.Document;
import com.mongodb.client.MongoCollection;

public class Principal {
	public static void main(String[] args) {
		
		MongoCollection<Document> coleccionJava = MongoRead.conexion("mongodb://localhost:27017", "harry", "harry-potter");
		
//		MongoRead.consultar1(coleccionJava);
		
//		MongoRead.consultar2(coleccionJava);
	
//		MongoRead.consultar3(coleccionJava);
	
		MongoRead.consultar4(coleccionJava);
	
	}
}
