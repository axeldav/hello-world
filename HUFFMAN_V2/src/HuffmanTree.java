import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanTree {

    MyNode root;

    public final ArrayList<MyNode> nodeList = new ArrayList();

    public HashMap<Character, String> charMapping = new HashMap<>();

    public void setRoot(MyNode root) {
        this.root = root;
    }

    public MyNode getRoot() {
        return root;
    }

    /**
     * Creates a Mapping for all the characters and their frequencies in the String-input
     *
     * @param msg message to generate a frequency-list from
     * @return a frequencylist with pair < character, frequency in input-message >
     */
    public HashMap<Character, Integer> createFreqList(String msg){

        HashMap<Character, Integer> freqs = new HashMap<>();

        for(int i = 0; i<msg.length(); i++){
            Integer amount;
            if (freqs.containsKey(msg.charAt(i))) {
                amount = freqs.get(msg.charAt(i));
                amount++;
                freqs.put(msg.charAt(i), amount);

            }
            else
                freqs.put(msg.charAt(i), 0);
        }
        return freqs;
    }

    public void buildNodeList(String msg){

        HashMap<Character, Integer> freqList = createFreqList(msg);

        for (Character ch: freqList.keySet()){
            nodeList.add(new LeafNode(freqList.get(ch), ch ) );
        }
    }

    public MyNode buildHuffmanTree(String msg){

        //builds a node with their frequencies from input string
        buildNodeList(msg);

        //min heap
        PriorityQueue<MyNode> minHeap = new PriorityQueue<MyNode>();
        minHeap.addAll(nodeList);

        while (minHeap.size() > 1) {

            //take the two smallest elements
            MyNode temp1 = minHeap.poll();
            MyNode temp2 = minHeap.poll();

            //create a new subtree from those nodes, where parent has sum of childrens frequencies
            MyNode temp3 = new MyNode(temp1.getFreq() + temp2.getFreq()) ;
            temp3.setLeft(temp1);
            temp3.setRight(temp2);

            //put it back in the heap
            minHeap.add(temp3);

        }

        root = minHeap.peek();
        return minHeap.remove();

    }

    /**
     * läser in meddelandet och för varje symbol(bokstav)
     * så kollar den vad dess andra par är i Key/Value -Mappen charMapping som mappar
     * symboler till dess binära motsvarighet:
     * ex:
     * a : 000,
     * b : 011
     *
     *
     * @param message sträng som ska bli encoded
     * @return En binär sträng, encodat meddelande
     */
    public String encodeMessage(String message){

        //creates the mapping: a -> 000, b ...
        //fills the charMapping
        addEncodedCharsToMap(root);

        StringBuilder encodedM = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            encodedM.append(charMapping.get(message.charAt(i)));
        }
        return encodedM.toString();
    }

    /**
     * Encodes a single char by traversing trough the tree
     *
     * @param ch character to be encoded
     * @param root rootnode of huffmanTree
     * @return the encoded string
     */
    private StringBuilder encodeChar(char ch, MyNode root){
        StringBuilder encoded = new StringBuilder();
        MyNode temp = root;

        if (temp.isLeaf() && temp.getCh() == ch){
            return encoded.append("x");
        }

        else if (!temp.isLeaf()) {

            encoded.insert(0, encodeChar(ch, temp.getLeft()) );
            if (encoded.length() > 0) {
                encoded.insert(0, "0");
                return encoded;
            }

            encoded = encodeChar(ch, temp.getRight());
            if (encoded.length() > 0 ) {
                encoded.insert(0, "1");
                return encoded;
            }
        }
        return encoded;
    }


    private void addEncodedCharsToMap(MyNode root){
        for (MyNode indexNode: nodeList) {
            Character ch = indexNode.getCh();

            //gets the encoded char
            String encoded = encodeChar(ch,root).toString();

            charMapping.put(ch, encoded);
        }
    }


}
