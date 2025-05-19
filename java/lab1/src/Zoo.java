package src;

import java.util.ArrayList;

public class Zoo {
    ArrayList<Animal> animals = new ArrayList<Animal>();
    public void addAnimal(Animal ani){
        animals.add(ani);
    }
    public int numOfAnimals(){
        return animals.size();
    }
    public String toString(){
        StringBuilder list = new StringBuilder("List of the animals:\n");
        for(Animal animal: animals){
            list.append(animal).append("\n");
        }
        return list.toString();
    }
    public int totalFoodNeeded(String food){
        int needed = 0;
        for(Animal animal: animals){
            if(food.equals(animal.getFood())){
                needed += animal.getQuantity();
            }
        }
        return needed;
    }
    public int totalSqMetersNeeded(String area){
        int areaNeeded = 0;
        for(Animal animal: animals){
            if(area.equals(animal.getEnvironment())){
                areaNeeded += animal.getArea();
            }
        }
        return areaNeeded;
    }
}
