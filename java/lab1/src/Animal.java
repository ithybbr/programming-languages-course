package src;
public class Animal {
    private String Name;
    private int Weight;
    private String Food;
    private int Quantity;
    private String Environment;
    private int Area;
    Animal(String name, int weight, String food, int quantity, String environment, int area){
        Name = name;
        Weight = weight;
        Food = food;
        Quantity = quantity;
        Environment = environment;
        Area = area;
    }
    public String toString() {
        return Name + " weights " + Weight + " kg" + " eats " + Quantity + " units of " + Food + " a day; needs " + Area + " m^2 of " + Environment; 
    }
    public int getQuantity(){
        return Quantity;
    }
    public int getArea(){
        return Area;
    }
    public String getEnvironment(){
        return Environment;
    }
    public String getFood(){
        return Food;
    }
}
