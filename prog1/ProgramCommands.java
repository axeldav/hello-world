// Axel Davidsson, axda2670

import java.util.ArrayList;

public class ProgramCommands {


    private MyScanner scan = new MyScanner();

    // --- List of owners ---
    private ArrayList<Owner> ownersList = new ArrayList<>();

    // --- List of dogs ---
    private ArrayList<Dog> dogList = new ArrayList<>();

    // --- List of auctions ---
    private ArrayList<Auction> auctionList = new ArrayList<>();


    // -------------- Methods ---------- //

    /// ********** Dog-methods **********//

    public void registerNewDog(){


        String name = scan.readName("Name");
        String breed = scan.readString("Breed");
        int age = scan.readNumber("Age");
        int weight = scan.readNumber("Weight");

        dogList.add(new Dog(name, breed, age, weight));
        System.out.println(name + " added to the register");
    }

    public void listDogs(){

        sortDogs();
        if (dogList.isEmpty()){
            System.out.println("Error: no dogs in register");
            return;
        }

        double tailLengthChoice = scan.readDouble("Smallest tail length to display");
        for (Dog dog: dogList){
            printDogWithTailLength(tailLengthChoice, dog);
        }
    }

    private void printDogWithTailLength(double tailLengthChoice, Dog dog) {
        if (tailLengthChoice <= dog.getTailLength()){
            System.out.println("* " + dog.getName() + " (" + dog.getBreed() + ", " +
                    dog.getAge() + " years, " + dog.getWeight() + " kilo, " +
                    dog.getTailLength() + "cm tail) " + "owned by: " + dog.getOwner());
        }
    }

    private Dog findDog(String name){
        for (Dog dog:dogList){
            if(name.equalsIgnoreCase(dog.getName())){
                return dog;
            }
        }
        return null;
    }

    public void increaseAge(){

        Dog dog = findDog(scan.readName("Enter the name of the dog"));

        //if dog doesnt exist
        if(dog == null){
            System.out.println("Error: no such dog");
            return;
        }

        dog.increaseAge();
        System.out.println(dog.getName() + " is now one year older");
    }

    public void removeDog(){

        // if dog is null ->
        Dog dog = findDog(scan.readName("Enter the name of the dog"));
        if(dog == null){
            System.out.println("Error: no such dog");
            return;
        }

        //dog is removed from list in Assignment
        dogList.remove(dog);
        System.out.println(dog.getName() + " is now removed from the register");

        //if dog has owner
        if (dog.getOwner() != null){
            //dog is removed from owner list also
            dog.getOwner().removeDog(dog);
        }
        // if dog is in auction, remove auction
        if(findAuction(dog) != null){
            //auction for dog is removed
            auctionList.remove(findAuction(dog));
        }

    }

    private void sortDogs(){
        for (int i = 1; i < dogList.size(); i++) {
            for (int j = i-1; j >= -1; j--) {

                //If 'j' reach end of list (left side) or i.tail(outer index) is bigger or equal to j.tail(inner index...
                if(j == -1 || dogList.get(i).getTailLength() > dogList.get(j).getTailLength()) {

                    //put the value on the right side of index j
                    Dog element = dogList.remove(i);
                    dogList.add(j + 1, element);

                    //end inner loop
                    break;
                }

                //if i and j index tail lenght is same AND
                //if i.char(outer 'right' index) is bigger than j.char...
                else if(dogList.get(i).getTailLength() == dogList.get(j).getTailLength() &&
                        dogList.get(i).getName().compareTo(dogList.get(j).getName()) >= 0) {

                    //put the value on the right side of current index j
                    Dog element = dogList.remove(i);
                    dogList.add(j + 1, element);

                    //end inner for loop with 'j'
                    break;

                }
            }
        }
    }

    // ******* Owner-Methods ********* //

    public void registerNewOwner(){

        String name = scan.readName("Name");
        ownersList.add(new Owner(name));

    }

    private Owner findOwner(String name){
        for (Owner owner:ownersList) {
            if(owner.getName().equalsIgnoreCase(name)){
                return owner;
            }
        }
        return null;
    }

    public void giveDog(){

        String nameDog = scan.readName("Enter the name of the dog");
        Dog dog = findDog(nameDog);

        //if dog == null, dog doesnt exist, print error message, return
        if (dog == null){
            System.out.println("error: no such dog");
            return;
        }
        //error if dog already has a owner, return
        if (dog.getOwner() != null){
            System.out.println("error: dog already has owner");
            return;
        }


        //Get owner
        String nameOwner = scan.readName("Enter the name of the owner");
        Owner owner = findOwner(nameOwner);

        //if owner doesnt exist, print error message, return
        if(owner == null){
            System.out.println("error: no such owner");
            return;
        }

        //else. add dog to owner list, and dog gets an owner
        owner.addDogToList(dog);
        //dog.addToOwnersList(owner);

        //auction for dog is removed, if dog is up for auction
        auctionList.remove(findAuction(dog));
    }

    public void listOwners(){

        //prints owners
        if (ownersList.isEmpty()){
            System.out.println("Error: no owners in register");
            return;
        }
        for (Owner owner:ownersList) {
            System.out.print(owner);
            printOwnersDogs(owner);
            System.out.print("\n");
        }
    }

    private void printOwnersDogs(Owner owner) {
        if (owner.getDogsOwnedLength() > 0) {
            System.out.print(" (");
            owner.printDogsOwned(owner);
            System.out.print(" )");
        }
    }

    //Removes owner, dog that is owned by owner also gets removed from doglist
    public void removeOwner(){

        Owner owner = findOwner(scan.readName("Enter the name of the user"));

        //if owner dont exist, error message and return
        if(owner == null){
            System.out.println("Error: no such user");
            return;
        }

        //go trough all auctions
        //find if the bid is by owner, and remove
        for (Auction a : auctionList) {
            a.removeBid(a.findBidByOwner(owner));
        }


        removeAllDogsOfOwner(owner);

        //last, remove owner
        System.out.println("owner " + owner.getName() + " is removed" );
        ownersList.remove(owner);
    }

    private void removeAllDogsOfOwner(Owner owner) {
        //if dog in doglist has the owner that is being removed
        //then remove dog from doglist
        //problem because iterating and removing simultaneously
        ArrayList<Dog> dogsToRemove = new ArrayList<>();
        for (Dog dog: dogList) {
            if (owner.equals(dog.getOwner())) {
                dogsToRemove.add(dog);
            }
        }
        if (!dogsToRemove.isEmpty()){
            dogList.removeAll(dogsToRemove);
            dogsToRemove.clear();
        }
    }

    // ******* Auction-Methods ************//

    public void startAuction(){

        Dog dog = findDog(scan.readName("Enter the name of the dog"));

        // if dog does not exist
        if(dog == null){
            System.out.println("Error: No such dog");
            return;
        }

        //If dog is already in an auction
        if (findAuction(dog) != null){
            System.out.println("Error: this dog is already up for auction");
            return;
        }

        //if dog already has owner
        if (dog.getOwner() != null){
            System.out.println("Error: this dog already has an owner");
            return;
        }


        auctionList.add(new Auction(dog));
        System.out.println(dog.getName()+
                " has been put up for auction in auction #" +
                auctionList.get(auctionList.indexOf(findAuction(dog))).getAuctionId());

    }

    private Auction findAuction(Dog dog){

        for (Auction a:auctionList) {
            if(a.getDog().equals(dog)) {
                return a;
            }
        }
        return null;

    }

    public void makeBid(){


        //enter name of user
        Owner owner = findOwner(scan.readName("Enter the name of the user"));
        if(owner == null){
            System.out.println("Error: no such user");
            return;
        }

        //enter name of dog
        Dog dog = findDog(scan.readName("Enter the name of the dog"));
        if(dog == null){
            System.out.println("Error: no such dog");
            return;
        }


        //Find the right auction for this dog
        Auction auction = findAuction(dog);

        //if the auction doesnt exist
        if (auction == null){
            System.out.println("Error: this dog is not up for auction");
            return;
        }

        int bidAmount = scan.readNumber("Amount to bid (min " +
                (auction.getHighestBid() + 1) + " kr)");

        // while the bid is too low print bid is too low
        bidAmount = checkBidAmount(auction, bidAmount);
        //help method
        addOrChangeBid(owner, auction, bidAmount);
    }

    private void addOrChangeBid(Owner owner, Auction auction, int bidAmount) {
        //if there already is a bid by the owner in the auction
        if (auction.findBidByOwner(owner) != null ){

            // that old bid should be pulled out of the list, and
            Bid b = auction.removeBid(auction.findBidByOwner(owner));
            //the amount changed, and then,
            b.setAmount(bidAmount);
            // Put back in at the end of the list
            auction.addBid(b);
            return;
        }

        //otherwise create new bid, add to list
        Bid bid = new Bid(bidAmount, owner);
        auction.addBid(bid);
    }

    private int checkBidAmount(Auction auction, int bidAmount) {
        while (bidAmount <= auction.getHighestBid() || bidAmount <= 0) {
            System.out.println("Error: too low bid");
            bidAmount = scan.readNumber("Amount to bid (min " +
                    (auction.getHighestBid() + 1) + " kr)");
        }
        return bidAmount;
    }

    public void listBids(){

        //Enter the name of the dog
        Dog dog = findDog(scan.readName("Enter the name of the dog"));

        // if dog doesnt have an auction
        if (findAuction(dog) == null){
            System.out.println("Error: dog is not up for auction");
            return; }


        //make a list of all the bids
        Auction a = findAuction(dog);

        if(a.numberOfBids() == 0){
            System.out.println("No bids registrated yet for this auction");
            return; }

        printBids(a);
    }

    private void printBids(Auction a) {
        for (int i = a.numberOfBids()-1; i >= 0; i--) {
            System.out.println(a.getBidAtIndex(i).getOwner().getName() + " " +
                    a.getBidAtIndex(i).getAmount());
        }
    }

    // list auctions with their three highest bids
    public void listAuctions(){

        //if there are no auctions -> error message, return
        if(auctionList.isEmpty()){
            System.out.println("Error: no auctions in progress");
            return;
        }

        //Go trough all the auctions
        for (Auction a : auctionList) {
            System.out.print("Auction #");
            System.out.print(a.getAuctionId() + ":  " + a.getDog().getName() +
                    ". Top bids:  (");
            // at every auction
            printHighestBids(a, 3);
            System.out.print(")\n");
        }

    }

    //The highest bids are sorted from the right(highest) to left(lowest)
    private void printHighestBids(Auction a, int nrBidsToShow ) {
        for (int i = a.numberOfBids()-1; i > a.numberOfBids() - nrBidsToShow - 1 && i >= 0; i--) {
            // print name
            System.out.print(a.getBidAtIndex(i).getOwner().getName() + " ");
            // print bid
            System.out.print(a.getBidAtIndex(i).getAmount() + " kr, ");
        }
    }

    public void closeAuction(){

        //user get question which dogs auction
        Dog dog = findDog(scan.readName("Enter the name of the dog"));

        //find auction for dog
        Auction a = findAuction(dog);

        if (a == null){
            System.out.println("Error this dog is not up for auction");
            return; }
        if (a.numberOfBids() == 0){
            System.out.println("The auction is closed. No bids where made for Rex");
            auctionList.remove(a);
            return; }

        Owner owner = a.getBidAtIndex(a.numberOfBids()-1).getOwner();
        owner.addDogToList(dog);

        //the auction is closed. the winning bid was 200 kr and was made by anna
        System.out.println("the auction is closed. the winning bid was" + a.findBidByOwner(owner).getAmount() +
                "kr and was made by " + owner.getName());
        auctionList.remove(a);
    }

    public MyScanner getScan() {
        return scan;
    }
}
