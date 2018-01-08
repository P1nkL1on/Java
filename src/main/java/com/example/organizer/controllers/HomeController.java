package com.example.organizer.controllers;

import com.example.organizer.dtos.PersonDTO;
import  com.example.organizer.utils.*;
import com.example.organizer.entities.Person;
import com.example.organizer.repositories.BirthdayRepository;
import com.example.organizer.services.BirthdayService;
import com.example.organizer.services.MeetingService;
import com.example.organizer.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class HomeController {
    private BirthdayService bds;
    private MeetingService mts;
    private PersonService pss;
    private int count = 20;

    @Inject
    public HomeController(BirthdayService bdayService, MeetingService meetService, PersonService persService) {
        System.out.print("Created home controller");
        bds = bdayService;
        mts = meetService;
        pss = persService;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("persons", Utils.iterableToList(pss.getAll()));
        model.addAttribute("birthdays", Utils.iterableToList(bds.getAll()));
        model.addAttribute("meets", Utils.iterableToList(mts.getAll()));
        return "index";
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<?> delete(@PathVariable String name) {
        System.out.print("Delete method requested! " + name);
        try {
            bds.delete(0);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @RequestMapping(value = "/persons", method = RequestMethod.PUT)
    @ResponseBody
    public boolean newPerson(@RequestBody String name) {
        System.out.print("Added a " + name + ", ");
        PersonDTO newP = new PersonDTO();
        count++;
        newP.setArgs(count, 1, name);
        pss.add(newP);
        return true;
    }
    @RequestMapping(value = "/persons/{index}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteGenre(@PathVariable String index) {
        System.out.print("Delete a " + index);
        List<PersonDTO> genres = Utils.iterableToList(pss.getAll());
        PersonDTO p = genres.get(Integer.parseInt(index));
        pss.delete(p.getId());
        return true;
    }
//    @ModelAttribute("persons")
//    public List<Person> channels() {
//        return Utils.iterableToList(pss.getAll());
//    }
}
