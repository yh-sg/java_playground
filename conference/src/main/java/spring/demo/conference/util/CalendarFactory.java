package spring.demo.conference.util;

import java.util.Calendar;

import org.springframework.beans.factory.FactoryBean;

//Build on initMethod concept, Factory method pattern, Contract without constructor, Static methods.
public class CalendarFactory implements FactoryBean<Calendar> {
	
	private Calendar instance = Calendar.getInstance();

	@Override
	public Calendar getObject() throws Exception {
		return instance;
	}

	@Override
	public Class<?> getObjectType() {
		return Calendar.class;
	}
	
	//Static instances
	public void addDays(int num) {
		instance.add(Calendar.DAY_OF_YEAR, num);
	}
}
