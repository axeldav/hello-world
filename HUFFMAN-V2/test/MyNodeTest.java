import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MyNodeTest {


    @Test
    public void testString(){
        System.out.print(s);
    }

    @Test
    public void testNodes(){
        MyNode node = new MyNode(2);
        MyNode leaf = new LeafNode(2, 'a');


        ArrayList<MyNode> nodes = new ArrayList<>();
        nodes.add(node);
        nodes.add(leaf);
        for(MyNode myNode: nodes){
            myNode.isLeaf();
        }
    }
}