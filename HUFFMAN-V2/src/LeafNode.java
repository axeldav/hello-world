public class LeafNode extends MyNode{
    char ch;

    LeafNode(int freq, char ch ){
        super(freq);
        this.ch = ch;
    }

    public char getCh() {
        return ch;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}