package spring.demo.conference.repository;

import java.util.ArrayList;
import java.util.List;

import spring.demo.conference.entity.Speaker;

public class HibernateSpeakerRepositoryImpl implements HibernateSpeakerRepository {

	@Override
	public List<Speaker> findAll(){
		List<Speaker> speakers = new ArrayList<>();
		
		Speaker speaker = new Speaker();
		
		speaker.setFirstName("Teiou");
		speaker.setLastName("Tokai");
		
		speakers.add(speaker);
		
		return speakers;
	}
	
}
