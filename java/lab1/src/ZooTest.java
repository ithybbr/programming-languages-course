package src;
public class ZooTest{
public static void main(String args[]){
    Zoo zoo = new Zoo();
    // some test subjects
    Giraffe giraffe1 = new Giraffe("Melman", 300);
    Giraffe giraffe2 = new Giraffe("Big Bird", 1450);
    Tiger tiger1 = new Tiger("Alex", 141);
    Tiger tiger2 = new Tiger("Vitaly", 501);
    Penguin penguin1 = new Penguin("Kowalski", 140);
    Penguin penguin2 = new Penguin("Rico", 1243);
    Penguin penguin3 = new Penguin("CriticalHit", 1243);
    zoo.addAnimal(giraffe1);
    zoo.addAnimal(giraffe2);
    zoo.addAnimal(tiger1);
    zoo.addAnimal(tiger2);
    zoo.addAnimal(penguin1);
    zoo.addAnimal(penguin2);
    zoo.addAnimal(penguin3);
    //test toString
    System.out.println( zoo.toString());
    //test totalFoodNeeded
    System.out.println( "amount of fish needed " + zoo.totalFoodNeeded("fish") + "\n");
    System.out.println( "amount of meat needed " + zoo.totalFoodNeeded("meat") + "\n");
    System.out.println( "amount of leaves needed " + zoo.totalFoodNeeded("leaves") + "\n");
    System.out.println( "amount of lasagna needed " + zoo.totalFoodNeeded("lasagna") + "\n");
    //test totalSqMetersNeeded
    System.out.println( "amount of water needed " + zoo.totalSqMetersNeeded("water") + "\n");
    System.out.println( "amount of grassland needed " + zoo.totalSqMetersNeeded("grassland") + "\n");
    System.out.println( "amount of sky needed " + zoo.totalSqMetersNeeded("sky") + "\n");
}
}