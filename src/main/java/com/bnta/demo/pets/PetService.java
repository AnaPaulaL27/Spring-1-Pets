package com.bnta.demo.pets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service

//service is an access point (in this case is like a portal for pets)- responsible for accessing the database/ data
// access layer. DAO
//DAO- assign all responsibilities for CRUD operations to a class - keeps everything separate
//not creating DAO explicitly since don't have persistence layer in this, we are going to use our service to maintain
//a collection of pets - so will use PetModel to maintain a collection of pets
public class PetService {

    //field-
    // creating a factory
    private PetModel petModelFactory;
    private List<PetModel> pets = new ArrayList<>();
    private int nextId = 0; // generating id- this is a workaround when working with db, dont need to do this

    protected PetService() {
    }

    @Autowired
    //Constructor - will take in pet model object
    public PetService(PetModel petModelFactory) { // not newing up pet model, its being injected through autowired,
        //not using new keyword to create this factory
        // take in blank petModel. That's why we need empty constructor in pet model, so can create empty objects
        // without passing in all information- just creating a blank model
        this.petModelFactory = petModelFactory; //
    }

    //CRUD: Create, read, update, delete

    //method for creating pet, C
    public void createPet(String name, LocalDate dob, String type, Set<String> characteristics, float price) {
        this.pets.add(petModelFactory.createNew(nextId, name, dob, type, characteristics, price));//when creating a pet want
        //to add it to the collection, basically substituting for our database
        nextId++; //incrementing id so that every time method is called, will have a new id assigned to the object
    }

    //method to get pet by id, R
    public PetModel getPet(int id) {
        for (PetModel pet : pets) {//using loops , for pet in pets, go through every pet in pet collection
            if (pet.getId() == id)
                return pet;
        }
//        Alternative: using streams
//
//        return pets.stream().filter(pet -> pet.getId() == id).collect(Collectors.toList()).get(0);

        //if we don't find what we say in loop
        return null;

    }
    //Getting all our pets,  R
    public List<PetModel>getPets(){ //don't need to provide id since we want all
        return pets;
    }

    //Removing pet, D
    public void removePet(int id){ //we want to remove a pet with id x
        for(PetModel pet : pets){
            if(pet.getId() == id) pets.remove(pet);  // if  the id of the pet that we get == id provided, access collection
            // + remove pet. pets is our collection that we are accessing
        }
    }
}