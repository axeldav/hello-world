// Axel Davidsson, axda2670
import java.util.ArrayList;
public class Auction {

    // Counter ID
    private static int counter;
    private int auctionId;

    // Should include one dog
    private Dog dog;

    // Should include many bids
    private ArrayList<Bid> bids = new ArrayList<>();
    
    public Auction(Dog d){
        counter++;
        this.auctionId = counter;
        this.dog = d;
    }

    public int getAuctionId(){
        return auctionId;
    }

    public void addBid(Bid b){
        bids.add(b);
    }

    public Bid removeBid(Bid b){
        if (b != null){
            return bids.remove(bids.indexOf(b));
        }
        return null;
    }

    public Dog getDog() {
        return dog;
    }

    public int getHighestBid(){
        int highestAmount = 0;
        for (Bid bid:bids) {
            if(bid.getAmount()>highestAmount){
                highestAmount = bid.getAmount();
            }
        }
        return highestAmount;
        
    }

    public Bid getBidAtIndex(int i){
        //because bids is private and cant be acessed from 'Assignment'
        return bids.get(i);
    }

    public int numberOfBids(){
        return bids.size();
    }

    public Bid findBidByOwner(Owner owner){
        for (Bid bid:bids) {
            if(bid.getOwner() == owner)
                return bid;
        }
        return null;
    }
}
