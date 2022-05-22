package com.bnta.demo.pets;

//model essentially represents a row in the table
//we have a table of pets and this pet model is what defines one of those
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

// A POJO:  plain old java object
//A Java Beam = a POJO that follows certain basic conventions- getters + setters are named in a  certain way
// e.g.,    public String getName rather than getMyName
// A framework can then assume certain things about your class  when looking at our code

@Component //component extends (includes) bean, its telling us it's a component
//Model is M in model view controller
public class PetModel {

    //When we implement persistence layer, connect to db, id is normally marked
    //as primary key + auto generated
    private int id;
    private String name;
    private LocalDate dob;
    private String type;
    private Set<String> characteristics;
    private float price;

    //A beam = a POJO with certain conventions


    //create constructor(2)

    //(1) default = empty version

    public PetModel(){}

    //(2) regular: accepts parameters for fields

    public PetModel(int id, String name, LocalDate dob, String type, Set<String>characteristics, float price ){
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.type = type;
        this.characteristics = characteristics;
        this.price = price;
    }

    //Getters + Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<String> getCharacteristics() {
        return characteristics;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCharacteristics(Set<String> characteristics) {
        this.characteristics = characteristics;


    }
    //readable

    @Override
    public String toString() {
        return "PetModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", type='" + type + '\'' +
                ", characteristics=" + characteristics +
                ", price=" + price +
                '}';
    }

    //design pattern - "factory methods" - you have some kind of method  or a class with methods
    //and you delegate it responsibility of newing up objects to that method
    //so every time someone wants a pet, they come to the factory to get the pet- instead of having many classes
    //saying new pet, you just have this method here

    public PetModel createNew(int id, String name, LocalDate dob, String type, Set<String> characteristics,
                              float price){
        return new PetModel(id, name, dob, type, characteristics, price);

        //so once we have an instance of pet model, we can use that instance to create a new instance, mypet.create new
        //avoids having new keyword in all different places
        //change it in this one place, rather than everywhere you use 'new' keyword

        //factory enables single responsibility for the construction of an object by delegating to a factory
        //usually for custom objects- things you've designed yourself
    }
}

