import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Huffman {

    ArrayList<MyNode> nodeList = new ArrayList<>();

    public HashMap<Character, String> charAndCodes = new HashMap<>();

    Huffman(){

    }

    /**
     *
     * @param ch
     * @param root
     * @return - a StringBuilder Object with the encoded message
     */
    public StringBuilder encodeChar(char ch, MyNode root){
        StringBuilder encoded = new StringBuilder();
        MyNode temp = root;

        if (temp.isLeaf() && temp.getCh() == ch){
            return encoded.append("x");
        }

        else if (!temp.isLeaf()) {

            encoded.insert(0, encodeChar(ch, temp.getLeft()) );
            if (encoded.length() > 0) {
                encoded.insert(0, "1");
                return encoded;
            }

            encoded = encodeChar(ch, temp.getRight());
            if (encoded.length() > 0 ) {
                encoded.insert(0, "0");
                return encoded;
            }
        }
        return encoded;
    }

    /**
     *
     * @param root - must send the root of the Tree
     */
    public void encodeAllChars(MyNode root){
        for (MyNode myNode: nodeList) {
            Character ch = myNode.getCh();
            String encoded = encodeChar(ch,root).toString();
            charAndCodes.put(ch, encoded);
        }
    }


    public String encodeMessage(String message){
        StringBuilder encodedM = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            encodedM.append(charAndCodes.get(message.charAt(i)));
        }
        return encodedM.toString();
    }


    public void addToNodeList(MyNode myNode){
        nodeList.add(myNode);
    }

    /**
     * Return the rootNode
     */
    public MyNode buildHuffmanTree(){

        //min heap
        PriorityQueue<MyNode> minHeap = new PriorityQueue<MyNode>();
        minHeap.addAll(nodeList);

        while (minHeap.size() > 1) {

            //pop two elements from the heap
            MyNode temp1 = minHeap.poll();
            MyNode temp2 = minHeap.poll();

            MyNode temp3 = new MyNode(temp1.getFreq() + temp2.getFreq()) ;
            temp3.setLeft(temp1);
            temp3.setRight(temp2);

            minHeap.add(temp3);

        }

        return minHeap.remove();

    }

    public void buildFrequencyList(String message){
        for(int i = 0; i<message.length(); i++){
            char ch = message.charAt(i);
            if ()
        }
    }


}
