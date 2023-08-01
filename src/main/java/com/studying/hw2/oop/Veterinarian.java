package com.studying.hw2.oop;



public class Veterinarian {
  private AnimalsJournal animalsJournal = new AnimalsJournal();



  public boolean canAnimalFly(Object animal) {
    return animal instanceof Flying;
  }

  public void registerNewAnimal(Object animal) {
      animalsJournal.addNewAnimal(animal);

  }


  public String[] getListOfRegisteredAnimals() {
    return animalsJournal.getAnimalsNames();
  }

  public Animal findHeaviestAnimal() {
    return animalsJournal.findHeaviestAnimal();


  }
}
