import java.util.*;

public class ProgramTests {

    public static void main(String[] args) {

        String withWhiteSpace = "                hej mamma och pappa ";
        System.out.println(withWhiteSpace);

        String withoutWhiteSpace = withWhiteSpace.trim();
        System.out.println(withoutWhiteSpace);
        System.err.println("Error: no dogs in register");

        //MyScanner scanOne = new MyScanner();
        //MyScanner scanTwo = new MyScanner();


        //System.out.println(scan1.readName("Skriv ditt namn"));

        //System.out.println(scan1.readNumber("skriv ett nummer"));

        //MyScanner scan2 = new MyScanner();

        /*
        Dog d1 = new Dog("A", "tax", 8, 15);
        Dog d2 = new Dog("B", "tax", 5, 20);
        Dog d3 = new Dog("C", "Corgi", 8, 15);
        Dog d4 = new Dog("D", "Bulldog", 3, 4);
        Dog d5 = new Dog("F", "tax", 6, 20);
        Dog d6 = new Dog("F", "Cocker spaniel", 6, 20);
        */





        //Assignment a1 = new Assignment();
        //a1.registerNewDog();
        //a1.registerNewDog();
        //a1.registerNewDog();

        //a1.listDogs();

        /*
        System.out.println("Nedanför ska jag sortera lite");

        ArrayList<Dog> lista = new ArrayList<>();

        lista.add(d1);
        lista.add(d2);
        lista.add(d3);
        lista.add(d4);
        lista.add(d5);
        */

        Assignment a = new Assignment();
        // Vilka hundar man lägger in innan man sorterar beror på vad det är man vill
        // testa. I början kanske man bara har två och ser att de byter plats, eller
        // inte byter plats, som de ska. Därefter lägger man till fler, byter ordning på
        // dem, etc.


        // Manually enter dogs

        /*
        a.addDog(new Dog("Fido","Schäfer",1, 1 )); // längsta svanslängd
        a.addDog(new Dog("Molly", "Cocker spaniel", 6, 1));
        a.addDog(new Dog("Bella", "Dachshund", 1, 6)); // minsta svanslängd
        a.addDog(new Dog("Milo", "Tax", 3, 4)); // Borde komma före Milou pga namnet
        a.addDog(new Dog("Nilo", "Tax", 3, 4)); // Borde komma före Milou pga namnet
        */


        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            a.addDog(new Dog("Dog" + i, "Ras", rnd.nextInt(5), rnd.nextInt(5)));
        }




        for (Dog d : a.getDogs()) {
            System.out.printf("%s\t%5.2f%n", d.getName(), d.getTailLength());
        }
        /*
        [   name: Fido age: 1 breed: Schäfer weight: 1 Taillength: 0.1,
            name: Molly age: 1 breed: Cocker spaniel weight: 1 Taillength: 0.1,
            name: Bella age: 6 breed: Dachshund weight: 6 Taillength: 3.7,
            name: Milou age: 5 breed: Tax weight: 5 Taillength: 3.7,
            name: Milo age: 5 breed: Tax weight: 5 Taillength: 3.7,
            name: Wilma age: 8 breed: Terrier weight: 8 Taillength: 6.4,
            name: Charlie age: 9 breed: Chihuahua weight: 9 Taillength: 8.1]
        */

        ArrayList<Integer> listA = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listA.add(rnd.nextInt(10));
        }
        System.out.println("random list int:");
        System.out.println(listA.toString());

        for (int i = 1; i < listA.size() ; i++) {
            for (int j = i-1; j >=-1 ; j--) {
                if (j == -1 || listA.get(j)<=listA.get(i)){

                    //Om det har index i == j ovan
                    //se om index i sträng är större än index j
                    Integer element = listA.remove(i);
                    listA.add(j + 1, element);
                    j = -2;
                }
            }
        }

        System.out.println("Sorterad:");
        System.out.println(listA.toString());
        //System.out.println(lista.toString());


        /*
        for (Dog dog:lista){
            System.out.println(dog.getTailLength() + " " + dog.getName());
        }
        */


        //om i hittar mindre än sig själv ELLER listar tar slut -> placera i där
        // remove() element from list then add() it back in
        //[4,5,1,2,3]

        /*
        //Insertion Sort
        for (int i = 1; i < lista.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {

                if (lista.get(i) > lista.get(j)) {
                    Integer element = lista.remove(i);
                    lista.add(j + 1, element);

                    //måste avbryta loopen varje gång denna if är TRUE, annars går inre for loopen igenom
                    //hela vägen ner till noll
                    //Då kan fler byten ske i listan och det blir knas
                    j = -1;
                }
                //om listan är slut och den ej hittat mindre tal till höger, placera j
                //längst till höger
                if (j == 0) {
                    Integer element = lista.remove(i);
                    lista.add(j, element);
                }

            }
        }
        */

        /*
        //Alternativ Insertion Sort
        for (int i = 1; i < lista.size(); i++) {
            int j = i - 1;

            //j går till -1, och om villkor 2 står först så blir det out of bounds, index -1"
            //Men det spelar ingen roll om den villkor 1 står först för då kollar den bara
            //på den.
            //       1                    2
            while (j >= 0  && lista.get(i)<lista.get(j) ){
                j--;
            }
            Integer element = lista.remove(i);
            lista.add(j+1, element);
        }
        */

        /*
        //Insertion Sort, tredje sort, Tail length and char //////////FINISHED///////////
        //Tar en ArrayList med Objekt som input
        for (int i = 1; i < lista.size(); i++) {
            for (int j = i-1; j >= -1; j--) {

                //If 'j' at end of list (left side) or i.tail(outer index) is bigger or equal to j.tail...
                //otherwise continue next iteration..
                if(j == -1 || lista.get(i).getTailLength() >= lista.get(j).getTailLength()){

                    //if also at end of list (left) or i.char(outer 'right' index) is bigger than j.char...
                    //otherwise continue next iteration..
                    if (j == -1 || lista.get(i).getName().charAt(0) > lista.get(j).getName().charAt(0)) {

                        //put the value on the right side of current index j
                        Dog element = lista.remove(i);
                        lista.add(j + 1, element);
                        //end inner for loop with 'j'
                        j = -2;
                    }
                }
            }
        }
        */

        /*
        //Insertion Sort, tredje sort, Sorted by name
        for (int i = 1; i < lista.size(); i++) {
            for (int j = i-1; j >= -1; j--) {
                if(j == -1 || lista.get(i).getName().charAt(0) > lista.get(j).getName().charAt(0)){

                    Dog element = lista.remove(i);
                    lista.add(j+1, element);
                    j = -2;
                }
            }
        }
         */







        //System.out.println(lista.toString());






        //Dog object = lista.get(0);
        //System.out.println(object.getName());

        System.out.println("sortera");
        a.sortDogs();

        for (Dog d : a.getDogs()) {
            System.out.printf("%s\t%5.2f%n", d.getName(), d.getTailLength());
        }

        /*
        String text = "Exel";
        String text2 = "Axel";
                     //om större -> +x   //om större -> -x
        System.out.println(text.compareTo(text2));
        */

        /*
        a.registerNewOwner();
        System.out.println(a.ownersList.get(0).getName());
        Owner enOWner = a.findOwner("Axel");
        boolean boool = a.ownersList.get(0) == enOWner;
        System.out.println(boool);
        */

        int[] myNumbers = {1,2,3,4};
        System.out.println(Arrays.toString(myNumbers));
        int[] newMyNumbers = new int[myNumbers.length + 1];
        System.out.println(Arrays.toString(newMyNumbers));

        int addNr = 5;

        /*
        for (int i = 0; i <= myNumbers.length ; i++) {
            newMyNumbers[i] = myNumbers[i];
        }
         */

        //newMyNumbers[myNumbers.length] = addNr;

        //System.out.println("after adding 'addNr'");
        //System.out.println(Arrays.toString(newMyNumbers));

        /*
        Parameters: No parameters, use the stuff that are in the classes
                    Or maybe 1.array 2.element to be added
        does:
        - Makes array size -> +1
        - adds thing to end of array
        - if array size is 0 -> needs to be exception??
         */

        System.out.println("before adding number");
        System.out.println(Arrays.toString(myNumbers));

        myNumbers = addElementToArray(myNumbers, addNr);

        System.out.println("after adding number");
        System.out.println(Arrays.toString(myNumbers));


        Dog d = new Dog("Fido", "Tax", 7, 20);
        Dog d2 = new Dog("Hicko", "Tax", 7, 20);

        Owner o = new Owner("Svea");
        //d.addToOwnersList(o);
        //o.addDogToList(d);

        /*
        a.registerNewOwner();
        //a.registerNewOwner();

        a.registerNewDog();
        a.registerNewDog();
        a.registerNewDog();

        a.gia.veDog();
        a.giveDog();
        a.giveDog();
        a.removDog();
        a.listOwners();

         */

        a.registerNewDog();
        a.registerNewOwner();
        a.startAuction();
        a.makeBid();









    }

    static public int[] addElementToArray(int[] array, int element){

        // Make copy of array, and +1 bigger
        int[] copyArray = new int[array.length + 1];

        // If length of 'array' is 0, just add element to copy
        if(array.length == 0){
            copyArray[0] = element;
        }
        //else: copy each index to new array
        else{
            //forloop to copy the array
            for (int i = 0; i < array.length; i++) {
                copyArray[i] = array[i];
            }
        }

        //add element to copyArray
        copyArray[array.length] = element;

        //copy the copyArray back to the original array
        array = copyArray;

        return array;
    }


    /*
    for (int i = 1; i < dogList.size(); i++) {
        for (int j = i-1; j >= -1; j--) {

            //If 'j' at end of list (left side) or i.tail(outer index) is bigger or equal to j.tail...
            //otherwise continue next iteration..
            if(j == -1 || dogList.get(i).getTailLength() >= dogList.get(j).getTailLength()){

                //if also at end of list (left) or i.char(outer 'right' index) is bigger than j.char...
                //otherwise continue next iteration..
                if (j == -1 || dogList.get(i).getName().compareTo(dogList.get(j).getName()) >= 0) {

                    //put the value on the right side of current index j
                    Dog element = dogList.remove(i);
                    dogList.add(j + 1, element);
                    //end inner for loop with 'j'
                    j = -2;
                }
            }
        }
    }
    */
}

