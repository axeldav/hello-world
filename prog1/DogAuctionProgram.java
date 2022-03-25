// Axel Davidsson, axda2670

import java.util.ArrayList;

public class DogAuctionProgram {


    private static final String LIST_DOGS = "listdogs"; // U7.2 och U8.4
    private static final String INCREASE_AGE = "increaseage"; // U7.4
    private static final String REMOVE_DOG = "removedog"; // U7.5, U8.6 och U9.6
    private static final String REGISTER_NEW_OWNER = "registernewowner"; // U8.1
    private static final String GIVE_DOG = "givedog"; // U8.3 och framåt
    private static final String LIST_OWNERS = "listowners"; // U8.4
    private static final String REGISTER_NEW_DOG = "registernewdog"; // U7.1
    private static final String REMOVE_OWNER = "removeowner"; // U8.7 och U9.6
    private static final String START_AUCTION = "startauction"; // U9.1 och framåt
    private static final String MAKE_BID = "makebid"; // U9.3 och framåt
    private static final String LIST_BIDS = "listbids"; // U9.4 och framåt
    private static final String LIST_AUCTIONS = "listauctions"; // U9.5 och framåt
    private static final String CLOSE_AUCTION = "closeauction"; // U9.6
    private static final String EXIT = "exit";

    private ProgramCommands myCommand = new ProgramCommands();

    // --- List of owners ---
    private ArrayList<Owner> ownersList = new ArrayList<>();

    // --- List of dogs ---
    private ArrayList<Dog> dogList = new ArrayList<>();

    // --- List of auctions ---
    private ArrayList<Auction> auctionList = new ArrayList<>();



    public static void main(String[] args) {

        DogAuctionProgram program = new DogAuctionProgram();
        program.start();

    }

    private void start() {

        printMenu();
        runCommandLoop();

    }

    private void printMenu() {
        System.out.println("Welcome to the dog, owner, auction, bid program");
        System.out.println("Write whihch of these commands you would like to do: ");
        System.out.println("---------------------------------------------------");
        System.out.println("'register new dog',  " +
                "'list dogs',  " +
                "'register new dog'\n" +
                "'increase age',  " +
                "'remove dog',  " +
                "'sort dogs'\n" +
                "'give dog',  " +
                "'list owners',  " +
                "'remove owner'\n" +
                "'start auction',  " +
                "'make bid',  " +
                "'list bids' \n" +
                "'list auctions',  " +
                "'close auction' \n");
    }

    private void runCommandLoop() {

        String choice;
        do {
            choice = readCommand();
            doCommand(choice);
        } while(!choice.equals(EXIT));

    }

    private String readCommand() {
        String choice = myCommand.getScan().readString("choose command");
        choice = choice.toLowerCase().replaceAll(" ","");
        return choice;
    }

    private void doCommand(String choice) {
        switch (choice){

            case REGISTER_NEW_DOG:
                myCommand.registerNewDog();
                break;
            case LIST_DOGS:
                myCommand.listDogs();
                break;
            case INCREASE_AGE:
                myCommand.increaseAge();
                break;
            case REMOVE_DOG:
                myCommand.removeDog();
                break;
            case REGISTER_NEW_OWNER:
                myCommand.registerNewOwner();
                break;
            case GIVE_DOG:
                myCommand.giveDog();
                break;
            case LIST_OWNERS:
                myCommand.listOwners();
                break;
            case REMOVE_OWNER:
                myCommand.removeOwner();
                break;
            case START_AUCTION:
                myCommand.startAuction();
                break;
            case MAKE_BID:
                myCommand.makeBid();
                break;
            case LIST_BIDS:
                myCommand.listBids();
                break;
            case LIST_AUCTIONS:
                myCommand.listAuctions();
                break;
            case CLOSE_AUCTION:
                myCommand.closeAuction();
                break;
            case EXIT:
                //close program
                System.out.println("program is closing");
                break;
            default:
                System.out.println("Error, wrong input");
                break;



        }
    }

}
