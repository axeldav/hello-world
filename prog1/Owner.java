//Axel Davidsson, axda2670

public class Owner {

    private String name;
    private Dog[] dogsOwned = {};

    public Owner (String  name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //copies dogList, +1 lenght, and adds dog to copyList, then copies back to dogList
    public void addDogToList(Dog d) {

        // Make copy of array, and +1 bigger
        Dog[] copyDogsOwned = new Dog[dogsOwned.length + 1];

        //help Method, does manual copying with a for-loop
        copyToLongerLengthList(d, copyDogsOwned);

        //copy the copyArray back to the original array
        dogsOwned = copyDogsOwned;

        //referring to its own object
        d.setOwner(this);

    }

    // Private help method to "addDogToList"
    private void copyToLongerLengthList(Dog d, Dog[] copyDogsOwned) {
        // If length of 'array' is 0, just add element to copy
        if (dogsOwned.length == 0) {
            copyDogsOwned[0] = d;
            return; }

        //for-loop to copy the array
        for (int i = 0; i < dogsOwned.length; i++) {
            copyDogsOwned[i] = dogsOwned[i];
        }
        //add element to copyArray at the end (length)
        copyDogsOwned[dogsOwned.length] = d;
    }

    //create a copyList, -1 length, add every dog, except dog to be removed. copy back to dogList
    public void removeDog(Dog d){

        // Make copy of array, and -1 smaller
        Dog[] copyDogsOwned = new Dog[dogsOwned.length - 1];
        if(copyDogsOwned.length != 0 ) {
            copyListWithoutDog(d, copyDogsOwned);
        }
        //copy the copyArray back to the original array
        dogsOwned = copyDogsOwned;
    }

    // Private help method to "removeDog"
    private void copyListWithoutDog(Dog d, Dog[] copyDogsOwned) {
        //For the length of the copy list
        int i = 0;
        for (Dog dog: dogsOwned) {
            //If its not the dog to be removed -> add to new copyList
            if (!dog.equals(d)){
                copyDogsOwned[i] = dog;
                i++;
            }
        }
    }

    public boolean ownerOfDog(Dog d){
        for (Dog dog:dogsOwned){

            if(dog.equals(d)){
                return true;
            }
        }
        return false;
    }

    public void printDogsOwned(Owner owner) {
        for (Dog dog : dogsOwned) {
            System.out.print(dog.getName() + ",");
        }
    }

    public int getDogsOwnedLength() {
        return dogsOwned.length;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
