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
		System.out.println(personService.getAll());

		EventBirthdayDTO bday0 = new EventBirthdayDTO();
		bday0.setArgs(1, persons[randRange(count/2,count)], LocalDate.of(2017, 12, 6),
				LocalTime.of(12,00,00),
				"Usuall birthday","1 dolla");
		birthdayeventService.add(bday0);

		EventBirthdayDTO bday1 = new EventBirthdayDTO();
		bday1.setArgs(2, h, LocalDate.of(2017, 11, 4),
				LocalTime.of(6,00,00),
				"Harry has a bday only once in year","friendly kick");
		birthdayeventService.add(bday1);

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

		EventMeetingDTO meet2 = new EventMeetingDTO();
		meet2.setArgs(2,  persons[randRange(0,count)], LocalDate.of(2010, 9, 13),
				LocalTime.of(16,0,0), "Thanx god we have a meet");
		meetingeventService.add(meet2);
		EventMeetingDTO meet3 = new EventMeetingDTO();
		meet3.setArgs(3,  persons[randRange(0,count)], LocalDate.of(2017, 12, 29),
				LocalTime.of(15,0,0), "Java время сдавать практику!");
		meetingeventService.add(meet3);


		System.out.println(meetingeventService.get(1));
		System.out.println(meetingeventService.getAll());




		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();

		for (int i = 0; i < 2; i++)
		birthdayeventService.delete(i + 1);
		for (int i = 0; i < 3; i++)
		meetingeventService.delete(i + 1);
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
