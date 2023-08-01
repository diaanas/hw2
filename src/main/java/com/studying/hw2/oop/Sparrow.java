package com.studying.hw2.oop;

public class Sparrow extends Flying {
  private String name;
  private int weight;
  private long maxFlyingDistance;

  public Sparrow(String name, int weight, long maxFlyingDistance) {
    this.name = name;
    this.weight = weight;
    this.maxFlyingDistance = maxFlyingDistance;
  }

  @Override
  public String getAnimalType() {
    return "sparrow";
  }

  public String getName() {
    return name;
  }

  public int getWeight() {
    return weight;
  }

  @Override
  public int compareTo(Animal o) {
    return name.compareTo(o.getName());
  }

  public long getMaxFlyingDistance() {
    return maxFlyingDistance;
  }


  @Override
  public String toString() {
    return  "name: " + name  +
            ", type: " + getAnimalType() +
            ", weight: " + weight ;
  }
}
