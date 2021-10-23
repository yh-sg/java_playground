package spring.demo.conference.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import spring.demo.conference.entity.Speaker;

@Repository("speakerRepository")
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
