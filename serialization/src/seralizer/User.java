package seralizer;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	protected static final long serialVersionUID = 1;
	private String name;
	transient private String password;
	
	User(String name, String password){
		this.name = name;
		this.password = password;
	}

	public void sayHello() {
		System.out.println("hello "+name + "  " + password);
	}
}
