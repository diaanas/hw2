package com.studying.hw2.oop;

public interface Animal extends Comparable<Animal>{
  String getAnimalType();
  String getName();
  int getWeight();

  @Override
  int compareTo(Animal o);
}
