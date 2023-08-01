package com.studying.hw2.oop;

public abstract class Flying implements Animal {
  private long maxFlyingDistance;

  public long getMaxFlyingDistance() {
    return maxFlyingDistance;
  }

  public void setMaxFlyingDistance(long maxFlyingDistance) {
    this.maxFlyingDistance = maxFlyingDistance;
  }
}
