package com.studying.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.studying.hw2.oop.Cat;
import com.studying.hw2.oop.Dog;
import com.studying.hw2.oop.Sparrow;
import com.studying.hw2.oop.Veterinarian;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OopTest {

  private Veterinarian veterinarian;

  @BeforeEach
  void setUp() {
    veterinarian = new Veterinarian();
  }

  /**
   * Implementation of canAnimalFly from {@link Veterinarian}
   * should properly decide if passed animal can fly
   */
  @Test
  void decideIfAnimalCanFly() {
    Cat tomCat = new Cat("tom", 3);
    Dog luckyDog = new Dog("lucky", 5);
    Sparrow jackSparrow = new Sparrow("jack", 1, 100);

    assertFalse(veterinarian.canAnimalFly(tomCat));
    assertFalse(veterinarian.canAnimalFly(luckyDog));
    assertTrue(veterinarian.canAnimalFly(jackSparrow));
  }

  /**
   * Implementation of registerNewAnimal from {@link Veterinarian}
   * should properly save information about registered animal,
   * and implementation of getListOfRegisteredAnimals from {@link Veterinarian}
   * should reply with list of registered animals, size of this list should have valid number of registered animals
   */
  @Test
  void increaseListSizeWhenRegisterOneAnimal() {
    assertEquals(0, veterinarian.getListOfRegisteredAnimals().length);

    Cat tomCat = new Cat("tom", 3);
    veterinarian.registerNewAnimal(tomCat);

    assertEquals(1, veterinarian.getListOfRegisteredAnimals().length);
  }

  /**
   * Implementation of getListOfRegisteredAnimals from {@link Veterinarian}
   * should reply with list, that should properly be increased each time when new animal is registered
   */
  @Test
  void increaseListSizeWhenRegisterTwoAnimals() {
    assertEquals(0, veterinarian.getListOfRegisteredAnimals().length);

    Cat tomCat = new Cat("tom", 3);
    Dog luckyDog = new Dog("lucky", 5);
    veterinarian.registerNewAnimal(tomCat);
    veterinarian.registerNewAnimal(luckyDog);

    assertEquals(2, veterinarian.getListOfRegisteredAnimals().length);
  }

  /**
   * Implementation of registerNewAnimal from {@link Veterinarian}
   * should not store animals that were already registered, so that size of list in getListOfRegisteredAnimals()
   * should not be changed
   */
  @Test
  void ignoreDuplicatesAndKeepListSizeWhenRegisterMultipleAnimals() {
    Cat tomCat = new Cat("tom", 3);
    Dog luckyDog = new Dog("lucky", 5);

    assertEquals(0, veterinarian.getListOfRegisteredAnimals().length);

    veterinarian.registerNewAnimal(tomCat);
    veterinarian.registerNewAnimal(luckyDog);
    assertEquals(2, veterinarian.getListOfRegisteredAnimals().length);

    veterinarian.registerNewAnimal(tomCat);
    veterinarian.registerNewAnimal(luckyDog);
    assertEquals(2, veterinarian.getListOfRegisteredAnimals().length);
  }

  /**
   * Implementation of registerNewAnimal from {@link Veterinarian}
   * should store animals with the same names but with different types so that size of list in getListOfRegisteredAnimals()
   * should be incremented
   */
  @Test
  void doNotIgnoreDuplicatedNamesWhenRegisterDifferentAnimalsTypes() {
    Cat tomCat = new Cat("tom", 3);
    Dog tomDog = new Dog("tom", 5);

    assertEquals(0, veterinarian.getListOfRegisteredAnimals().length);

    veterinarian.registerNewAnimal(tomCat);
    veterinarian.registerNewAnimal(tomDog);
    assertEquals(2, veterinarian.getListOfRegisteredAnimals().length);

    veterinarian.registerNewAnimal(tomCat);
    veterinarian.registerNewAnimal(tomDog);
    assertEquals(2, veterinarian.getListOfRegisteredAnimals().length);
  }

  /**
   * Implementation of getListOfRegisteredAnimals from {@link Veterinarian}
   * should return list of Strings with extend details about registered animal
   */
  @Test
  void returnExtendedJournalEntityAfterRegisteredOneAnimal() {
    Cat tomCat = new Cat("tom", 3);
    veterinarian.registerNewAnimal(tomCat);

    assertEquals("name: tom, type: cat, weight: 3", veterinarian.getListOfRegisteredAnimals()[0]);
  }

  /**
   * Implementation of getListOfRegisteredAnimals from {@link Veterinarian}
   * should return sort and reply with list of Strings with extend details about all registered animals
   */
  @Test
  void returnSorterListOfJournalEntitiesAfterRegisteredMultipleAnimal() {
    Dog luckyDog = new Dog("lucky", 6);
    Cat luckyCat = new Cat("lucky", 4);
    Cat tomCat = new Cat("tom", 3);
    Sparrow jackSparrow = new Sparrow("jack", 1, 100);
    Sparrow worobSparrow = new Sparrow("worob", 2, 50);

    veterinarian.registerNewAnimal(luckyDog);
    veterinarian.registerNewAnimal(luckyCat);
    veterinarian.registerNewAnimal(tomCat);
    veterinarian.registerNewAnimal(jackSparrow);
    veterinarian.registerNewAnimal(worobSparrow);

    assertEquals("name: jack, type: sparrow, weight: 1", veterinarian.getListOfRegisteredAnimals()[0]);
    assertEquals("name: lucky, type: cat, weight: 4", veterinarian.getListOfRegisteredAnimals()[1]);
    assertEquals("name: lucky, type: dog, weight: 6", veterinarian.getListOfRegisteredAnimals()[2]);
    assertEquals("name: tom, type: cat, weight: 3", veterinarian.getListOfRegisteredAnimals()[3]);
    assertEquals("name: worob, type: sparrow, weight: 2", veterinarian.getListOfRegisteredAnimals()[4]);
  }

  /**
   * Implementation of findHeaviestAnimal from {@link Veterinarian}
   * should return null if method registerNewAnimal() was never called yet
   */
  @Test
  void returnNullIfThereIsNoHeaviestAnimalYet() {
    Dog luckyDog = new Dog("lucky", 6);
    Cat luckyCat = new Cat("lucky", 4);
    Cat tomCat = new Cat("tom", 3);
    Sparrow jackSparrow = new Sparrow("jack", 1, 100);
    Sparrow worobSparrow = new Sparrow("worob", 2, 50);

    assertNull(veterinarian.findHeaviestAnimal());
  }

  /**
   * Implementation of findHeaviestAnimal from {@link Veterinarian}
   * should reply with the same object that was passed to registerNewAnimal()
   */
  @Test
  void returnHeaviestAnimalIfItWasJustRegistered() {
    Dog luckyDog = new Dog("lucky", 6);
    Cat luckyCat = new Cat("lucky", 4);
    Cat tomCat = new Cat("tom", 3);
    Sparrow jackSparrow = new Sparrow("jack", 1, 100);
    Sparrow worobSparrow = new Sparrow("worob", 2, 50);

    veterinarian.registerNewAnimal(jackSparrow);

    assertEquals(jackSparrow, veterinarian.findHeaviestAnimal());
  }

  /**
   * Implementation of findHeaviestAnimal from {@link Veterinarian}
   * should reply with last object that was passed to registerNewAnimal()
   */
  @Test
  void returnAnotherHeaviestAnimalIfMoreHeavyAnimalWasAddedAfterPreviousHeaviest() {
    Dog luckyDog = new Dog("lucky", 6);
    Cat luckyCat = new Cat("lucky", 4);
    Cat tomCat = new Cat("tom", 3);
    Sparrow jackSparrow = new Sparrow("jack", 1, 100);
    Sparrow worobSparrow = new Sparrow("worob", 2, 50);

    veterinarian.registerNewAnimal(jackSparrow);
    assertEquals(jackSparrow, veterinarian.findHeaviestAnimal());

    veterinarian.registerNewAnimal(tomCat);
    assertEquals(tomCat, veterinarian.findHeaviestAnimal());

    veterinarian.registerNewAnimal(luckyDog);
    assertEquals(luckyDog, veterinarian.findHeaviestAnimal());
  }

  /**
   * Implementation of findHeaviestAnimal from {@link Veterinarian}
   * should reply with object that was passed to registerNewAnimal() only if passed animal has the maximum value of Weight
   */
  @Test
  void doNotChangeHeaviestAnimalIfLessHeavyAnimalWasAddedAfterPreviousHeaviest() {
    Dog luckyDog = new Dog("lucky", 6);
    Cat luckyCat = new Cat("lucky", 4);
    Cat tomCat = new Cat("tom", 3);
    Sparrow jackSparrow = new Sparrow("jack", 1, 100);
    Sparrow worobSparrow = new Sparrow("worob", 2, 50);

    veterinarian.registerNewAnimal(jackSparrow);
    assertEquals(jackSparrow, veterinarian.findHeaviestAnimal());

    veterinarian.registerNewAnimal(luckyCat);
    assertEquals(luckyCat, veterinarian.findHeaviestAnimal());

    // Lucky cat should bet still the heaviest after we registered Tom cat
    veterinarian.registerNewAnimal(tomCat);
    assertEquals(luckyCat, veterinarian.findHeaviestAnimal());

    veterinarian.registerNewAnimal(luckyDog);
    assertEquals(luckyDog, veterinarian.findHeaviestAnimal());

    // Lucky dog should bet still the heaviest after we registered Worob
    veterinarian.registerNewAnimal(worobSparrow);
    assertEquals(luckyDog, veterinarian.findHeaviestAnimal());
  }


}
