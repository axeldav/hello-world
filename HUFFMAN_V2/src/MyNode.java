public class MyNode implements Comparable {
    private Integer freq;
    private char ch = '0';
    private MyNode left, right;

    MyNode(int freq){
        this.freq = freq;
    }

    public MyNode getLeft() {
        return left;
    }

    public MyNode getRight() {
        return right;
    }

    public void setLeft(MyNode left) {
        this.left = left;
    }

    public void setRight(MyNode right) {
        this.right = right;
    }

    public char getCh() {
        return ch;
    }

    public int getFreq() {
        return freq;
    }

    public boolean isLeaf(){
        return false;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof MyNode){
            MyNode m = (MyNode) o;
            return this.freq.compareTo(m.freq);
        }
        else
            return -1;
    }

}