//Axel Davidsson, axda2670
public class Bid {

    private Owner owner;
    private int amount;

    public Bid(int amount, Owner owner){
        this.amount = amount;
        this.owner = owner;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String toString(){
        return String.valueOf(amount);
    }

}
