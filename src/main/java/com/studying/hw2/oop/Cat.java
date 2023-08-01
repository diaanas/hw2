package com.studying.hw2.oop;

public class Cat implements Animal {
  private String name;
  private int weight;

  public Cat(String name, int weight) {
    this.name = name;
    this.weight = weight;

  }

  @Override
  public String getAnimalType() {
    return "cat";
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
    if(o.getName().equals(name)){
      return -1;
    }
    return name.compareTo(o.getName());
  }


  @Override
  public String toString() {
   return "name: " + name  +
            ", type: " + getAnimalType() +
            ", weight: " + weight  ;
  }
}
