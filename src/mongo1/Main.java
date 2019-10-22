package mongo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MongoClient mongoClient = ConnectionManager.getMongo();
		MongoDatabase database = ConnectionManager.getDb("test");
		MongoCollection<Document> collection = database.getCollection("cafes");

//		MongoCursor<Document> cursor = collection
//				.find(Filters.nin("state",Arrays.asList("NY","TX")))
//				.iterator();
//		while (cursor.hasNext()) {
//			Document d = (Document) cursor.next();
//			String city = d.getString("city");
//			int pop = d.getInteger("pop");
//			String state = d.getString("state");
//			System.out.printf("City: %s | Population: %d | State:%s\n", city, pop, state);
//		}

//		Document document1 = new Document("name", "Café Con Leche")
//				.append("contact",
//						new Document("phone", "228-555-0149").append("email", "cafeconleche@example.com")
//								.append("location", Arrays.asList(-73.92502, 40.8279556)))
//				.append("stars", 5).append("categories", Arrays.asList("Bakery", "Coffee", "Pastries"));
//		Document document2 = new Document("name", "Café Con Leche")
//				.append("contact",
//						new Document("phone", "228-555-0149").append("email", "cafeconleche@example.com")
//								.append("location", Arrays.asList(-73.92502, 40.8279556)))
//				.append("stars", 5).append("categories", Arrays.asList("Bakery", "Coffee", "Pastries"));
//		Document document3 = new Document("name", "Café Con Leche")
//				.append("contact",
//						new Document("phone", "228-555-0149").append("email", "cafeconleche@example.com")
//								.append("location", Arrays.asList(-73.92502, 40.8279556)))
//				.append("stars", 5).append("categories", Arrays.asList("Bakery", "Coffee", "Pastries"));
//
//		List<Document> docs = new ArrayList<>();
//		docs.add(document1);
//		docs.add(document2);
//		docs.add(document3);
//		collection.insertMany(docs);
//		collection.insertOne(document);

//		collection.deleteOne(Filters.eq("_id", new ObjectId("5dae97d42f01f961eba9fbf3")));
		
		collection.updateOne(Filters.eq("_id", new ObjectId("5daea1e19e6f5a44b247f6fe")), 
				Updates.combine(
						Updates.set("name", "Café new Leche"),
						Updates.set("contact.phone", "233-111-0011"), 
						Updates.set("stars", 5))
				);

		ConnectionManager.close();

	}

}
