package spring.demo.conference.service;

import java.util.List;

import spring.demo.conference.entity.Speaker;
import spring.demo.conference.repository.HibernateSpeakerRepository;
import spring.demo.conference.repository.HibernateSpeakerRepositoryImpl;

public class SpeakerServiceImpl implements SpeakerService {

	private HibernateSpeakerRepository repository;
	
	//Constructor Injection
	public SpeakerServiceImpl (HibernateSpeakerRepository speakerRepository) {
		repository = speakerRepository;
	}

	@Override
	public List<Speaker> findAll() {
		return repository.findAll();
	}

	//Setter Injection
	public void setRepository(HibernateSpeakerRepository repository) {
		this.repository = repository;
	}

}
