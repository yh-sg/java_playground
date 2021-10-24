package spring.demo.conference.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import spring.demo.conference.entity.Speaker;

@Repository("speakerRepository")
public class HibernateSpeakerRepositoryImpl implements HibernateSpeakerRepository {
	
	@Autowired
	private Calendar cal;
	
	//This is spring expression language(SpEL), one of the example is for configuration
	//Security purpose, for password/secret configuration 
	@Value("#{ T(java.lang.Math).random()*100}")
	private double seedNum;

	@Override
	public List<Speaker> findAll(){
		List<Speaker> speakers = new ArrayList<>();
		
		Speaker speaker = new Speaker();
		
		speaker.setFirstName("Teiou");
		speaker.setLastName("Tokai");
		speaker.setSeedNum(seedNum);
		
		System.out.println("cal: " + cal.getTime());
		
		speakers.add(speaker);
		
		return speakers;
	}
	
}
