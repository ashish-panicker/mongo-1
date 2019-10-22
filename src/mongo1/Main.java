package mongo1;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = mongoClient.getDatabase("test");
		MongoCollection<Document> collection = database.getCollection("zips");	
		
		MongoCursor<Document> cursor =  collection.find().iterator();
		while (cursor.hasNext()) {
			Document document = (Document) cursor.next();
			System.out.println(document);
		}
		mongoClient.close();

	}

}
