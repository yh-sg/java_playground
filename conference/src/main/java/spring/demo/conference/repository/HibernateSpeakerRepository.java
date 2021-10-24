package spring.demo.conference.repository;

import java.util.List;

import spring.demo.conference.entity.Speaker;

public interface HibernateSpeakerRepository {

	List<Speaker> findAll();

}