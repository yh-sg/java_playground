package seralizer;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeseralizerMain {

	public static void main(String[] args) {
		// Steps to Deserialize
		//1. Declare your object(don't instantiate)
		//2. Your class should implement Serializable interface
		//3. FileInputStream fileIn = new FileInputStream(file path)
		//4. ObjectInputStream in = new ObjectInputStream(fileIn)
		//5, objectName = (Class) in.readObject();
		//6. in.close(); fileIn.close();
		
		User user = null;
		try {
			FileInputStream fileIn = new FileInputStream("UserInfo.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			user = (User) in.readObject();
			in.close();
			fileIn.close();
			user.sayHello();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
