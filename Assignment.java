// Axel Davidsson, axda2670
import java.util.*;

public class Assignment {

    /*
     * Allt eftersom du skriver dina metoder fyller du i deras namn i konstanterna
     * nedan. Testprogrammet använder dessa konstanter för att hitta dina metoder,
     * så det är viktigt att namnen stämmer.
     */
    public static final String REGISTER_NEW_DOG_METHOD = "registerNewDog"; // U7.1
    public static final String LIST_DOGS_METHOD = "listDogs"; // U7.2 och U8.4
    public static final String FIND_DOG_METHOD = "findDog"; // U7.3 - hjälpmetod tänkt att användas i de följande stegen
    public static final String INCREASE_AGE_METHOD = "increaseAge"; // U7.4
    public static final String REMOVE_DOG_METHOD = "removeDog"; // U7.5, U8.6 och U9.6
    public static final String SORT_DOGS_METHOD = "sortDogs"; // U7.6
    public static final String REGISTER_NEW_OWNER_METHOD = "registerNewOwner"; // U8.1
    public static final String FIND_OWNER_METHOD = "findOwner"; // U8.2 - hjälpmetod tänkt att användas i de följande stegen
    public static final String GIVE_DOG_METHOD = "giveDog"; // U8.3 och framåt
    public static final String LIST_OWNERS_METHOD = "listOwners"; // U8.4
    public static final String OWNER_OF_DOG_METHOD = "ownerOfDog"; // U8.5, obs! metoden ska ligga i Owner-klassen
    public static final String REMOVE_OWNER_METHOD = "removeOwner"; // U8.7 och U9.6
    public static final String START_AUCTION_METHOD = "startAuction"; // U9.1 och framåt
    public static final String FIND_AUCTION_METHOD = "findAuction"; // U9.2 - hjälpmetod tänkt att användas i de följande stegen
    public static final String MAKE_BID_METHOD = "makeBid"; // U9.3 och framåt
    public static final String LIST_BIDS_METHOD = "listBids"; // U9.4 och framåt
    public static final String LIST_AUCTIONS_METHOD = "listAuctions"; // U9.5 och framåt
    public static final String CLOSE_AUCTION_METHOD = "closeAuction"; // U9.6


    // --- List of owners ---
    private ArrayList<Owner> ownersList = new ArrayList<>();

    // --- List of dogs ---
    private ArrayList<Dog> dogList = new ArrayList<>();

    // --- Object of my own class MyScanner ---
    private MyScanner scan = new MyScanner();

    // --- List of auctions ---
    private ArrayList<Auction> auctionList = new ArrayList<>();



    /********************************************************************************
     * Här nedanför skriver du dina metoder. Du kommer att kunna lämna in samma
     * fil(er) i samtliga inlämningar, så du behöver inte börja om för varje ny
     * metod.
     ********************************************************************************/

    // U7.1


    public void registerNewDog(){


        String name = scan.readName("Name");
        String breed = scan.readString("Breed");
        int age = scan.readNumber("Age");
        int weight = scan.readNumber("Weight");

        dogList.add(new Dog(name, breed, age, weight));
        System.out.println(name + " added to the register");
    }

    public void listDogs(){

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
    /*
    public void listDogs(){

        if (dogList.isEmpty()){
            System.out.println("Error: no dogs in register");
        }
        else{
            double tailLengthChoice = scan.readDouble("Smallest tail length to display");
            for (Dog dog: dogList){
                if (tailLengthChoice <= dog.getTailLength()){
                    System.out.println("* " + dog.getName() + " (" + dog.getBreed() + ", " +
                            dog.getAge() + " years, " + dog.getWeight() + " kilo, " +
                            dog.getTailLength() + "cm tail) " + "owned by: " + dog.getOwner());
                }
            }
        }

    }
    */

    public Dog findDog(String name){
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
    /*
    public void increaseAge(){

        Dog dog = findDog(scan.readName("Enter the name of the dog"));
        if(dog == null){
            System.out.println("Error: no such dog");
        } else {
            dog.increaseAge();
            System.out.println(dog.getName() + " is now one year older");
        }

    }
     */


    //7.5
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
    /*
    //7.5
    public void removeDog(){

        // if dog is null ->
        Dog dog = findDog(scan.readName("Enter the name of the dog"));
        if(dog == null){
            System.out.println("Error: no such dog");
        } else {
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
    }
*/
    


    /*
    * U7.6: Insertion Sort, found information here:
    * https://en.wikipedia.org/wiki/Insertion_sort
    * https://brilliant.org/wiki/insertion/
    * https://www.youtube.com/watch?v=nKzEJWbkPbQ&t=396s
    *
    * Takes An ArrayList of Dog object and sort it.
    * Normally it seems to be done with a inner while loop
    * but i did it with two for loops
    * Starts at index 2 and looks for a smaller number to the
    * left in the list. if smaller value found, place to right
    * of that value. otherwise continue to beginning of list
    * and place there
     */

    public void sortDogs(){
        for (int i = 1; i < dogList.size(); i++) {
            for (int j = i-1; j >= -1; j--) {

                //If 'j' reach end of list (left side) or i.tail(outer index) is bigger or equal to j.tail(inner index...
                if(j == -1 || dogList.get(i).getTailLength() > dogList.get(j).getTailLength()) {

                    //put the value on the right side of index j
                    Dog element = dogList.remove(i);
                    dogList.add(j + 1, element);

                    //end inner loop
                    j = -2;
                }

                //if i and j index tail lenght is same AND
                //if i.char(outer 'right' index) is bigger than j.char...
                else if(dogList.get(i).getTailLength() == dogList.get(j).getTailLength() &&
                        dogList.get(i).getName().compareTo(dogList.get(j).getName()) >= 0) {

                        //put the value on the right side of current index j
                        Dog element = dogList.remove(i);
                        dogList.add(j + 1, element);

                        //end inner for loop with 'j'
                        j = -2;

                }
            }
        }
    }


    //8.1


    public void registerNewOwner(){

        String name = scan.readName("Name");
        ownersList.add(new Owner(name));

    }

    //8.2
    public Owner findOwner(String name){
        for (Owner owner:ownersList) {
            if(owner.getName().equalsIgnoreCase(name)){
                return owner;
            }
        }
        return null;
    }

    //8.3
    //Give dog to owner. Reference to object in Dog Class and in Owner Class
    //A dog can have ONE owner, a owner can have MANY dogs
    //auction should close


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
    /*
    public void giveDog(){
        String nameDog = scan.readName("Enter the name of the dog");
        Dog dog = findDog(nameDog);

        //if dog == null, dog doesnt exist, print error message
        if (dog == null){
            System.out.println("error: no such dog");
            return;
        }
        //error if dog already has a owner
        else if (dog.getOwner() != null){
            System.out.println("error: dog already has owner");
        }
        //if dog exists
        else{

            //Get owner
            String nameOwner = scan.readName("Enter the name of the owner");
            Owner owner = findOwner(nameOwner);

            //if owner doesnt exist, print error message
            if(owner == null){
                System.out.println("error: no such owner");
            }
            //else. add dog to owner list, and dog gets an owner
            else {
                owner.addDogToList(dog);
                //dog.addToOwnersList(owner);
                auctionList.remove(findAuction(dog));
            }
        }

    }
    */

    //8.4
    //prints the owners and the dogs they own
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

    /*
    public void listOwners(){

        //prints owners
        if (ownersList.isEmpty()){
            System.out.println("Error: no owners in register");
        }else{
            for (Owner owner:ownersList) {
                System.out.print(owner);

                if (owner.getDogsOwned().length > 0) {
                    System.out.print(" (");
                    for (Dog dog : owner.getDogsOwned()) {
                        System.out.print(dog.getName() + ",");
                    }
                }
                System.out.print(")\n");
            }
        }
    }
    */


    //8.7
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

        //if dog in doglist has the owner that is being removed
        //then remove dog from doglist
        for (Dog dog: dogList) {
                if (owner.equals(dog.getOwner())) {
                    dogList.remove(dog);
                }
            }

        //last, remove owner
        System.out.println("owner " + owner.getName() + " is removed" );
        ownersList.remove(owner);
    }


    /*
    public void removeOwner(){
        Owner owner = findOwner(scan.readName("Enter the name of the user"));

        if(owner == null){
            System.out.println("Error: no such user");
        } else {

            //go trough all auctions
            for (Auction a : auctionList) {

                //go trough all the bids in that auction
                //find if the bid is by owner, and remove
                a.removeBid(a.findBidByOwner(owner));

            }
            for (Dog dog: dogList) {
                //if dog in doglist has the owner that is being removed
                if (owner.equals(dog.getOwner())) {
                    //then remove dog from doglist
                    dogList.remove(dog);
                }
            }
            //last, remove owner
            System.out.println("owner " + owner.getName() + " is removed" );
            ownersList.remove(owner);
        }
    }
    */


    //9.1
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

    // U9.2
    // Check trough list of auctions
    public Auction findAuction(Dog dog){

        for (Auction a:auctionList) {
            if(a.getDog().equals(dog)) {
                return a;
            }
        }
        return null;

    }

    //U9.3
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

        //if there is a bid by the owner in the auction
        if (auction.findBidByOwner(owner) != null ){

            // that old bid should be pulled out of the list, and
            Bid b = auction.removeBid(auction.findBidByOwner(owner));
            //the amount changed, and then,
            b.setAmount(bidAmount);
            // Put back in at the end of the list
            auction.addBid(b);
            return;
        }

        //create new bid, add to list
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

    /*
    public void makeBid(){

        //enter name of user
        Owner owner = findOwner(scan.readName("Enter the name of the user"));

        if(owner == null){
            System.out.println("Error: no such user");
        } else {

            //enter name of dog
            Dog dog = findDog(scan.readName("Enter the name of the dog"));
            if(dog == null){
                System.out.println("Error: no such dog");
            } else {
                //Find the right auction for this dog
                Auction auction = findAuction(dog);

                //if the auction doesnt exist
                if (auction == null){
                    System.out.println("Error: this dog is not up for auction");
                } else {
                    int bidAmount = scan.readNumber("Amount to bid (min " +
                            (auction.getHighestBid() + 1) + " kr)");

                    // while the bid is too low print bid is too low
                    while (bidAmount <= auction.getHighestBid() || bidAmount <= 0) {
                        System.out.println("Error: too low bid");

                        bidAmount = scan.readNumber("Amount to bid (min " +
                                (auction.getHighestBid() + 1) + " kr)");
                    }
                    //if there is a bid by the owner in the auction
                    if (auction.findBidByOwner(owner) != null ){

                        // that old bid should be pulled out of the list, and
                        Bid b = auction.removeBid(auction.findBidByOwner(owner));
                        //the amount changed, and then,
                        b.setAmount(bidAmount);
                        // Put back in at the end of the list
                        auction.addBid(b);
                    } else {
                        //create new bid, add to list
                        Bid bid = new Bid(bidAmount, owner);
                        auction.addBid(bid);
                    }

                }
            }
        }
    }
    */

    //U9.4
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

    /*
    public void listBids(){

        //Enter the name of the dog
        Dog dog = findDog(scan.readName("Enter the name of the dog"));

        // if dog doesnt have an auction
        if (findAuction(dog) == null){
            System.out.println("Error: dog is not up for auction");
        } else{
            //make a list of all the bids
            Auction a = findAuction(dog);

            if(a.numberOfBids() == 0){
                System.out.println("No bids registrated yet for this auction");
            }
            else {
                for (int i = a.numberOfBids()-1; i >= 0; i--) {
                    System.out.println(a.getBidAtIndex(i).getOwner().getName() + " " +
                            a.getBidAtIndex(i).getAmount());
                }
            }
        }
    }
    */


    //U9.5
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
            printThreeHighestBids(a);
            System.out.print(")\n");
        }

    }

    //The highest bids are sorted from the right(highest) to left(lowest)
    private void printThreeHighestBids(Auction a) {
        for (int i = a.numberOfBids()-1; i > a.numberOfBids() - 3 && i >= 0; i--) {
            // print name
            System.out.print(a.getBidAtIndex(i).getOwner().getName() + " ");
            // print bid
            System.out.print(a.getBidAtIndex(i).getAmount() + " kr, ");
        }
    }

    /*
    public void listAuctions(){
        // list auctions with the three highest bids

        //if there are no auctions -> error message
        if(auctionList.isEmpty()){
            System.out.println("Error: no auctions in progress");
        }
        else {
            //Go trough all the auctions
            for (Auction a : auctionList) {
                System.out.print("Auction #");
                System.out.print(a.getAuctionID() + ":  " + a.getDog().getName() +
                        ". Top bids:  (");
                // at every auction
                for (int i = a.numberOfBids()-1; i > a.numberOfBids() - 3 && i >= 0; i--) {

                    // print name
                    System.out.print(a.getBidAtIndex(i).getOwner().getName() + " ");
                    // print bid
                    System.out.print(a.getBidAtIndex(i).getAmount() + " kr, ");
                }
                System.out.print(")\n");
            }
        }
    }
    */


    //U9.7 -- Finish the auction --
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

        
        

    
    
    /*
     * Metoderna nedan är till för att testprogrammet ska sätta upp och kontrollera
     * olika saker. De är INTE tänkta att användas i din egen kod. Du måste fylla i
     * den saknade koden i metoderna allteftersom de behövs av testprogrammet.
     */

    /*
     * Byt ut koden i nedanstående metod så att den väntar på att användaren trycker
     * på return. Du gör detta genom att anropa nextLine-metoden på din scanner.
     *
     * Om du inte du gjort övningen till F6 där man ska skriva en egen klass för att
     * hantera inmatning så gör den. Den är ett bra exempel på en klass med
     * funktionalitet, och kommer att göra inlämningsuppgifterna enklare eftersom du
     * inte kommer att drabbas av några vanliga fel.
     *
     * Behövs från U7.5, eventuellt tidigare
     */
    public void waitForUserInput() {
        // Ersätt raden nedan med NAMNPÅSCANNER.nextLine() eller motsvarande anrop på din egen klass
        // throw new RuntimeException("Assignment.waitForUserInput är inte implementerad");
        scan.readStringSimple();


    }

    /*
     * Byt ut koden i nedanstående metod så att hunden läggs in i listan av hundar.
     * Kravet i uppgiften är formulerat så att en ArrayList ska användas, men det är
     * okej att använda andra klasser ur Javas Collection-api om du känner till dem.
     *
     * Behövs från U7.2
     */
    public void addDog(Dog d) {
        // Ersätt raden nedan med NAMNPÅLISTAN.add(d); eller motsvarande anrop
        //throw new RuntimeException("Assignment.addDog(Dog) är inte implementerad");
        dogList.add(d);
    }

    /*
     * Byt ut koden i nedanstående metod så att listan på hundar returneras.
     *
     * Kravet i uppgiften är formulerat så att en ArrayList ska användas, men det är
     * okej att använda andra list-klasser ur Javas Collection-api om du känner till
     * det, och föredrar en annan klass därifrån. Returtypen List gör att det går
     * att skicka tillbaka vilken listtyp som helst.
     *
     * Denna metod är ENBART till för testprogrammet i steg U7.1 till U9.7. Den ska
     * nästan säkert INTE finnas i det slutgiltiga fullständiga programmet, så
     * använd den inte i din egen kod.
     *
     * Behövs från U7.1
     */
    public List<Dog> getDogs() {
        // Ersätt raden nedan med return NAMNPÅLISTAN; eller motsvarande anrop
        return dogList;
        //throw new RuntimeException("Assignment.getDogs är inte implementerad");
    }




    /*
     * Byt ut koden i nedanstående metod så att ägaren läggs in i listan av ägare.
     * Uppgiften har inget specifikt krav på vilken typ av samling du ska använda
     * för detta, utan det får du bestämma själv. Det kan vara en array, en
     * ArrayList, en annan av Javas samlingsklasser, eller något du skrivit själv.
     *
     * Kravet i uppgiften är formulerat så att en ArrayList ska användas, men det är
     * okej att använda andra klasser ur Javas Collection-api om du känner till det,
     *
     * Behövs från U8.2
     */
	public void addOwner(Owner o) {
//		// Ersätt raden nedan med NAMNPÅLISTAN.add(o); eller motsvarande anrop
//		throw new RuntimeException("Assignment.addOwner(Owner) är inte implementerad");
        ownersList.add(o);
	}

    /*
     * Byt ut koden i nedanstående metod så att ägaren läggs in i listan av ägare.
     * Uppgiften har inget specifikt krav på vilken typ av samling du ska använda
     * för detta, utan det får du bestämma själv. Det kan vara en array, en
     * ArrayList, en annan av Javas samlingsklasser, eller något du skrivit själv.
     *
     * Kravet i uppgiften är formulerat så att en ArrayList ska användas, men det är
     * okej att använda andra klasser ur Javas Collection-api om du känner till dem.
     *
     * Behövs från U8.1
     */
	public Collection<Owner> getOwners() {
		// Ersätt raden nedan med return NAMNPÅSAMLINGEN; eller motsvarande anrop
//		throw new RuntimeException("Assignment.getOwners är inte implementerad");
        return ownersList;
	}

    /*
     * Om du använder en array för att spara ägarna kan nedanstående variant
     * användas istället
     */
//	public Collection<Owner> getOwners() {
//		return Arrays.asList(NAMNET_PÅ_ARRAYEN);
//	}

}