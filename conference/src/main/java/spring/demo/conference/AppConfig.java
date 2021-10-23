package spring.demo.conference;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.demo.conference.repository.HibernateSpeakerRepository;
import spring.demo.conference.repository.HibernateSpeakerRepositoryImpl;
import spring.demo.conference.service.SpeakerService;
import spring.demo.conference.service.SpeakerServiceImpl;

//Singleton
//Return only one instances
@Configuration
public class AppConfig {
	
	@Bean(name="speakerService")
	public SpeakerService getSpeakerService() {
		//Setter injection example
//		SpeakerServiceImpl service = new SpeakerServiceImpl();
//		service.setRepository(getSpeakerRepository());
		
		//Constructor injection example
		SpeakerServiceImpl service = new SpeakerServiceImpl(getSpeakerRepository());
		return service;
	}
	
	@Bean(name="speakerRepository")
	public HibernateSpeakerRepository getSpeakerRepository() {
		return new HibernateSpeakerRepositoryImpl();
	}
	
}
