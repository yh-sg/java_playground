package seralizer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args){
		// Serialization = 		The process of converting an object into a byte stream
		//						Persists (saves the state) the object after program exits
		//						This byte stream can be saved as a file or sent over a network
		//						Can be sent to a different machine
		//						Byte stream can be saved as a file (.ser) which is platform independent
		//						(Think of this as if you're saving a file with the object's information)
		
		// Deserialization = 	The reverse process of converting a btye stream into an object.
		//						(Think of this as if you're loading a saved file)
		
		//		Steps to Serialize
		//1.	Your object class should implement Serializable interface
		//2.	FileOutputStream fileOut = new FileOutputStream(file path);
		//3. 	ObjectOutputStream out = new ObjectOutputStream(fileOut);
		//4. 	out.writeObject(objectName)
		//5.	out.close(); fileOut.close();
		
		User user = new User("Jimmy","john");
		
			try {
				FileOutputStream fileOut = new FileOutputStream("UserInfo.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(user);
				out.close();
				fileOut.close();
				
				System.out.println("Object saved =)");
				System.out.println(User.serialVersionUID);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}
