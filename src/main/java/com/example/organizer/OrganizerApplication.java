package com.example.organizer;

import com.example.organizer.dtos.EventBirthdayDTO;
import com.example.organizer.dtos.EventMeetingDTO;
import com.example.organizer.dtos.PersonDTO;
import com.example.organizer.services.BirthdayService;
import com.example.organizer.services.MeetingService;
import com.example.organizer.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class OrganizerApplication implements CommandLineRunner {

	@Autowired
	public BirthdayService birthdayeventService;

	@Autowired
	public MeetingService meetingeventService;

	@Autowired
	public PersonService personService;

	static Random rnd = new Random();
	static String glas = "qwrtpsdfghjklzxcvbnm";
	static String soglas = "eyuioa";

	private int randRange (int min, int max){
		return rnd.nextInt(max - min) + min;
	}
	private String randName (){
		int slogs = randRange(6,9), i = randRange(0,2);
		String res = "";
		for (; i < slogs; i++)
			res +=  (i % 2 == 0)?
							glas.charAt(randRange(0, glas.length()))
						: soglas.charAt(randRange(0, soglas.length()));
		return (res.charAt(0)+"").toUpperCase() + res.substring(1);
	}

	private void contextLoads() {
		// random add a base
		final int count = 20;
		PersonDTO[] persons = new PersonDTO[count];
		for (int i = 0; i < count; i++) {
			persons[i] = new PersonDTO();
			persons[i].setArgs(i + 1, randRange(10,100), randName());

			personService.add(persons[i]);
		}
		PersonDTO h = persons[randRange(count/2,count)],
				  m = persons[randRange(0,count/2)];

		m.setName("Mind killer");
		m.setAge(9000);
		personService.edit(m);

//		PersonDTO h = new PersonDTO();
//		h.setArgs(1, 10, randName());
//		personService.add(h);
//		System.out.println(personService.get(1));
//		h.setAge(11);
//		personService.edit(h);
//		System.out.println(personService.get(1));
//
//		PersonDTO m = new PersonDTO();
//		m.setArgs(2, 60, randName());
//		personService.add(m);
//		System.out.println(personService.get(2));
//		m.setName(randName());
//		personService.edit(m);
//		System.out.println(personService.get(2));
		System.out.println(personService.getAll());

		EventBirthdayDTO bday0 = new EventBirthdayDTO();
		bday0.setArgs(1, h, LocalDate.of(2017, 12, 31),
				LocalTime.of(12,00,00),
				"Harry has a bday only once in year","friendly kick");
		birthdayeventService.add(bday0);
		System.out.println(birthdayeventService.get(bday0.getId()));
		bday0.setBirthdaytime(LocalTime.of(16, 00, 00));
		birthdayeventService.edit(bday0);
		System.out.println(birthdayeventService.get(bday0.getId()));
		System.out.println(birthdayeventService.getAll());

		EventMeetingDTO meet = new EventMeetingDTO();
		meet.setArgs(1, m, LocalDate.of(2000, 8, 10),
				LocalTime.of(15,0,0), "I need to talk to mindkiller (do not fear)");

		meetingeventService.add(meet);
		System.out.println(meetingeventService.get(1));
		meet.setMeetingtime(LocalTime.of(20, 00, 00));
		meetingeventService.edit(meet);
		System.out.println(meetingeventService.get(1));
		System.out.println(meetingeventService.getAll());

		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();

		birthdayeventService.delete(1);
		meetingeventService.delete(1);
		for (int i = 0; i < count; i++)
			personService.delete(i + 1);

		System.out.println(birthdayeventService.getAll());
		System.out.println(meetingeventService.getAll());
		System.out.println(personService.getAll());
	}

	public static void main(String[] args) {
		SpringApplication.run(OrganizerApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		contextLoads();
	}
}
