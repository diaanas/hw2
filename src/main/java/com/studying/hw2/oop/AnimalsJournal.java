package com.studying.hw2.oop;


import java.util.*;


class AnimalsJournal {

    private List<Object> animalJournal = new ArrayList<>();
    private HashSet<Animal> set = new HashSet<>();
    private List<Animal> animals = new ArrayList<>();


    public void addNewAnimal(Object animal) {
        animalJournal.add(animal);

    }


    public String[] getAnimalsNames() {
        sort();
        String[] journal = new String[animals.size()];
        int index = 0;
        for (Animal animal : animals) {
            journal[index] = animal.toString();
            index++;
        }
        return journal;
    }

    private void duplicate() {
        for (Object o : animalJournal) {
            if (!set.contains(o)) {
                set.add((Animal) o);

            }
        }


    }

    private void sort(){
        duplicate();
        animals.clear();
        for(Object animal : set){
            animals.add((Animal) animal);
        }

        Collections.sort(animals);
        for (Animal animal: animals){
            System.out.println(animal);
        }

    }




    public  Animal findHeaviestAnimal() {
        getAnimalsNames();
        Object heaviestAnimal = new Object();
        int weight = 0;
        if (set.isEmpty()) {
            return null;
        } else {
            for (Object animal : set) {
                if (weight <= ((Animal) animal).getWeight()) {
                    heaviestAnimal = animal;
                    weight = ((Animal) animal).getWeight();
                }
            }
            return ((Animal) heaviestAnimal);
        }
    }

}


