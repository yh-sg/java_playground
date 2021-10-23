package spring.demo.conference;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.demo.conference.service.SpeakerService;

public class App 
{
    public static void main( String[] args )
    {
    	//PainPoint --> alot of such hardcoded references around the projects, spring solve such issues
    	//SpeakerService service = new SpeakerServiceImpl();
    	
    	ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	SpeakerService service = appContext.getBean("speakerService", SpeakerService.class);
        
        System.out.println(service.findAll().get(0).getFirstName());
        System.out.println(service.findAll().get(0).getLastName());
    	
        ((AnnotationConfigApplicationContext) appContext).close();
    }
}
