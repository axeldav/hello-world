// Axel Davidsson, axda2670


import java.util.Scanner;

public class MyScanner {


    //Static because counter should not reset in newly created objects
    private static int counterScanners;

    private Scanner readIn = new Scanner(System.in);


    //If more than one object is created, prints error message

    public MyScanner(){
        if(counterScanners>0){
            System.err.println("too many scanner-objects");
        }
        counterScanners++;
    }



    // String that takes name of any format and returns Name with first letter capitalized
    // Also removes whitespaces
    //Also handles if input are empty or consists of only whitespaces
    public String readName(String prompt){

        while (true) {
            System.out.println(prompt + "?> ");
            String name = readIn.nextLine().toLowerCase();

            if (name.isBlank()){
                System.out.println("the name can't be empty");
            }else{
                //Removes whitespaces from beginning and end name-input
                name = name.trim();

                //Makes first letter upper case and rest is left lower case
                return name.substring(0,1).toUpperCase() + name.substring(1);
            }
        }
    }
    public String readString(String prompt){
        System.out.println(prompt + "?> ");
        return readIn.nextLine().trim();
    }

    public String readStringSimple(){
        return readIn.nextLine();
    }


    // \n. returns integer number
    public int readNumber (String prompt) {
        System.out.println(prompt + "?> ");
        int number = readIn.nextInt();
        // Removes input buffer
        readIn.nextLine();
        return number;


    }

    public double readDouble (String prompt) {
        System.out.println(prompt+ "?> ");
        double d = readIn.nextDouble();
        // Removes input buffer
        readIn.nextLine();
        return d;

    }

}
