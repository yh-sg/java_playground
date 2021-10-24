package spring.demo.conference.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.demo.conference.entity.Speaker;
import spring.demo.conference.repository.HibernateSpeakerRepository;

@Service("speakerService")
public class SpeakerServiceImpl implements SpeakerService {

	@Autowired
	private HibernateSpeakerRepository repository;
	
	public SpeakerServiceImpl() {
		System.out.println("SpeakServiceImpl no agrs constructor");
	}
	
	@PostConstruct //This is coming from bean-lifecycle example, should use for configurations but not database connection. let spring handle for database connections. 
	private void initialize() {
		System.out.println("Called after the constructors");
	}
	
	//Constructor Injection
	public SpeakerServiceImpl (HibernateSpeakerRepository speakerRepository) {
		System.out.println("SpeakServiceImpl repository constructor");
		repository = speakerRepository;
	}

	@Override
	public List<Speaker> findAll() {
		return repository.findAll();
	}

	//Setter Injection
//	@Autowired  //automatically inject the speakerRepository bean into the setter using @Autowired
	public void setRepository(HibernateSpeakerRepository repository) {
		System.out.println("SpeakServiceImpl setter");
		this.repository = repository;
	}

}
