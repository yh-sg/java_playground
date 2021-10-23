package spring.demo.conference;

import spring.demo.conference.service.SpeakerService;
import spring.demo.conference.service.SpeakerServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
    	//PainPoint --> alot of such hardcoded references around the projects, spring solve such issues
        SpeakerService service = new SpeakerServiceImpl();
        
        System.out.println(service.findAll().get(0).getFirstName());
    }
}
