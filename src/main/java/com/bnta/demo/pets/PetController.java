package com.bnta.demo.pets;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RestController //says this class is a controller class + says every method is to return JSON
@RequestMapping("pets")
public class PetController {

    private PetService petService;

    //constructor
    protected PetController() {}

    @Autowired
    //constructor
    public  PetController(PetService petService){
        this.petService= petService;


        this.petService.createPet("Fluffy", LocalDate.of(2000, 4, 26), "Rabbit",
                new HashSet<String>(Arrays.asList("Happy", "Clever")), (float) 39.99 ); //had to cast price because default is double


        this.petService.createPet("Captain Tiggles", LocalDate.of(2005, 3, 20), "Rabbit",
                new HashSet<String>(Arrays.asList("Jolly", "Silly")), (float) 89.99 ); //had to cast price because default is double

        this.petService.createPet("Poodle", LocalDate.of(2004, 5, 20), "Rabbit",
                new HashSet<String>(Arrays.asList("Happy", "Clever")), (float) 29.99 ); //had to cast price because default is double

        this.petService.createPet("Bonnie", LocalDate.of(2012, 9, 12), "Rabbit",
                new HashSet<String>(Arrays.asList("Playful", "Clever")), (float) 59.99 ); //had to cast price because default is double

        this.petService.createPet("Miskers", LocalDate.of(2011, 6, 19), "Rabbit",
                new HashSet<String>(Arrays.asList("Troublesome", "Silly")), (float) 29.99 ); //had to cast price because default is double

        this.petService.createPet("Softy", LocalDate.of(2003, 1, 14), "Rabbit",
                new HashSet<String>(Arrays.asList("Happy", "Fast")), (float) 19.99 ); //had to cast price because default is double

    }

    @GetMapping
    public List<PetModel> getPets(){
//        return Arrays.asList("Hello", "BNTA", ":-)");
         return this.petService.getPets();
    }
    @GetMapping(value= "/{id}") //localhost:8080/pets/id , id is path variable, needs to be provided , } = place holder + can use below
    public PetModel getPet(@PathVariable("id") int id){  // converting path variable into an actual variable
        return  this.petService.getPet(id);
    }

}
