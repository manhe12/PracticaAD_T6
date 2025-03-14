package es.studium.practicaT6;

import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoRead {
	/* Obtener la conexión a la base de datos */
	public static MongoCollection<Document> conexion(String URL, String bd, String nombreColeccion) {
		MongoClient conexion = MongoClients.create(URL);
		MongoDatabase database = conexion.getDatabase(bd);
		MongoCollection<Document> coleccionJava = database.getCollection(nombreColeccion);
		return coleccionJava;
	}

	public static void consultar1(MongoCollection<Document> nombreColeccion) {
		/* Mostrar todos los personajes cuyo atributo "species" tenga como valor "human" */
		FindIterable<Document> buscaHuman = nombreColeccion.find(Filters.eq("species", "human"));

		for (Document specieBuscada : buscaHuman) {
			System.out.println(specieBuscada.toJson());
		}
	}

	public static void consultar2(MongoCollection<Document> nombreColeccion) {

		/* Mostrar todos los personajes cuyo atributo "yearOfBirth" sea anterior a 1979, no vale igual a 1979.*/
		FindIterable<Document> busquedaAnterior1979 = nombreColeccion.find(Filters.lt("yearOfBirth", 1979));

		for (Document añoBuscado : busquedaAnterior1979) {
			System.out.println(añoBuscado.toJson());
		}
	}

	public static void consultar3(MongoCollection<Document> nombreColeccion) {

		/* Mostrar todos los personajes cuyo atributo "wood" de la propiedad "wand" sea "holly".*/
		FindIterable<Document> buscaHolly = nombreColeccion.find(Filters.eq("wand.wood", "holly"));

		for (Document wwBuscado : buscaHolly) {
			System.out.println(wwBuscado.toJson());
		}
	}

	public static void consultar4(MongoCollection<Document> nombreColeccion) {

		/* Mostrar todos los personajes que estén vivos (propiedad "alive" igual a true) 
		 * y además sean estudiantes (propiedad "hogwartsStudent" igual a true) */
		FindIterable<Document> buscaAliveStudent = nombreColeccion.
				find(Filters.and(Filters.eq("alive", true), Filters.eq("hogwartsStudent", true)));

		for (Document vivoBuscado : buscaAliveStudent) {
			System.out.println(vivoBuscado.toJson());
		}
	}
}
