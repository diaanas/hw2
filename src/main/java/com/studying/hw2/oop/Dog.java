package com.studying.hw2.oop;

public class Dog implements Animal {
  private String name;
  private int weight;

  public Dog(String name, int weight) {
    this.name = name;
    this.weight = weight;

  }

  @Override
  public String getAnimalType() {
    return "dog";
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getWeight() {
    return this.weight;
  }

  @Override
  public int compareTo(Animal o) {
    return name.compareTo(o.getName());
  }

  //  "name: tom, type: cat, weight: 3"
  @Override
  public String toString() {
    return   "name: " + name  +
            ", type: " + getAnimalType() +
            ", weight: " + weight  ;
  }
}
