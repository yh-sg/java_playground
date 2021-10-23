package spring.demo.conference;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.demo.conference.repository.HibernateSpeakerRepository;
import spring.demo.conference.repository.HibernateSpeakerRepositoryImpl;
import spring.demo.conference.service.SpeakerService;
import spring.demo.conference.service.SpeakerServiceImpl;

//Singleton
//Return only one instances
@Configuration
@ComponentScan({"spring.demo"})
public class AppConfig {

/*	
	@Bean(name="speakerService")
//	@Scope(value= BeanDefinition.SCOPE_SINGLETON)
	public SpeakerService getSpeakerService() {
		//Setter injection example
//		SpeakerServiceImpl service = new SpeakerServiceImpl();
//		service.setRepository(getSpeakerRepository());
		
		//Constructor injection example
//		SpeakerServiceImpl service = new SpeakerServiceImpl(getSpeakerRepository());
		
		
		//Autowired example, what it does was it automatically inject the speakerRepository bean into the setter using @Autowired in service
		SpeakerServiceImpl service = new SpeakerServiceImpl();
		
		return service;
	}
	

	
	@Bean(name="speakerRepository")
	public HibernateSpeakerRepository getSpeakerRepository() {
		return new HibernateSpeakerRepositoryImpl();
	}
	
*/
	
}
