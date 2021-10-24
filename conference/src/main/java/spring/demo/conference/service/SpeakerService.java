package spring.demo.conference.service;

import java.util.List;

import spring.demo.conference.entity.Speaker;

public interface SpeakerService {

	List<Speaker> findAll();

}