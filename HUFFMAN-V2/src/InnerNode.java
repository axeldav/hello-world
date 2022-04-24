public class InnerNode extends MyNode{

    InnerNode(int freq) {
        super(freq);
    }

    @Override
    public boolean isLeaf() {
        return super.isLeaf();
    }

    @Override
    public String toString() {
        return Integer.toString(super.getFreq());
    }
}