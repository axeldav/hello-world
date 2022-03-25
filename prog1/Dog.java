//Axel Davidsson, axda2670
public class Dog {

    private static final double TAIL_LENGTH = 3.7;
    private String name;
    private String breed;
    private int age;
    private int weight;

    private Owner owner;

    public Dog(String name, String breed, int age, int weight) {

        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;

    }

    public String getName(){
        return name;
    }

    public String getBreed(){
        return breed;
    }

    public int getAge(){
        return age;
    }

    public int getWeight(){
        return weight;
    }

    public double getTailLength(){

        if(breed.equalsIgnoreCase("tax") || breed.equalsIgnoreCase("dachshund")){
            return TAIL_LENGTH;
        }else{
            return (double) age * weight / 10;
        }
    }

    public Owner getOwner(){
        return owner;
    }

    public Owner setOwner(Owner o){
        return this.owner = o;
    }


    public void increaseAge(){
        age++;
    }

    public void addToOwnersList(Owner o){
        //Add this dog to owner
        o.addDogToList(this);
    }

    public String toString(){
        return "name: " + name + " age: " + age +
                "\nbreed: " + breed + " weight: " + weight +
                "\nTaillength:  " + getTailLength();

    }

}

