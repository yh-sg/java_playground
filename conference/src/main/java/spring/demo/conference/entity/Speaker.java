package spring.demo.conference.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Speaker {
	
	private String firstName;
	private String lastName;
	private double seedNum;
}
