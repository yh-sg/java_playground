package spring.demo.conference.service;

import java.util.List;

import spring.demo.conference.entity.Speaker;
import spring.demo.conference.repository.HibernateSpeakerRepository;
import spring.demo.conference.repository.HibernateSpeakerRepositoryImpl;

public class SpeakerServiceImpl implements SpeakerService {
	
	private HibernateSpeakerRepository repository = new HibernateSpeakerRepositoryImpl();
	
	@Override
	public List<Speaker> findAll(){
		return repository.findAll();
	}
	
}
