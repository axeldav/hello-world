//import org.junit.Test;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class MyNodeTest {


    @Test
    public void testCompareToNode(){
        MyNode m1 = new MyNode(4);
        MyNode m2 = new MyNode(5);
        MyNode m3 = new MyNode(5);


        System.out.println(m2.compareTo(m1));
        assertEquals( 1 , m2.compareTo(m1));
        assertEquals( 0 , m2.compareTo(m3));
    }

    @Test
    public void testString(){
        String s = "hej";
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

    @Test
    public void testEncodeChar(){
        LeafNode a = new LeafNode(3,'a');
        LeafNode b = new LeafNode(3,'b');

        LeafNode c = new LeafNode(3,'c');
        LeafNode d = new LeafNode(3,'d');

        LeafNode e = new LeafNode(3,'e');
        LeafNode f = new LeafNode(3,'f');

        LeafNode g = new LeafNode(3,'g');
        LeafNode h = new LeafNode(3,'h');


        InnerNode i1 = new InnerNode(1);
        InnerNode i2 = new InnerNode(2);
        InnerNode i3 = new InnerNode(3);
        InnerNode i4 = new InnerNode(4);
        InnerNode i5 = new InnerNode(5);
        InnerNode i6 = new InnerNode(6);
        InnerNode i7 = new InnerNode(7);

        i1.setLeft(i2);
        i1.setRight(i3);

        i2.setLeft(i4);
        i2.setRight(i5);

        i3.setLeft(i6);
        i3.setRight(i7);

        i4.setLeft(a);
        i4.setRight(b);

        i5.setLeft(c);
        i5.setRight(d);

        i6.setLeft(e);
        i6.setRight(f);

        i7.setLeft(g);
        i7.setRight(h);

        Huffman huffman = new Huffman();
        StringBuilder s = huffman.encodeChar('e', i1);
        assertEquals("011x" , s.toString());
        System.out.println(s.toString());
    }

    @Test
    public void testPutInEncodedMap(){
        LeafNode a = new LeafNode(3,'a');
        LeafNode b = new LeafNode(3,'b');
        LeafNode c = new LeafNode(3,'c');
        LeafNode d = new LeafNode(3,'d');
        LeafNode e = new LeafNode(3,'e');
        LeafNode f = new LeafNode(3,'f');
        LeafNode g = new LeafNode(3,'g');
        LeafNode h = new LeafNode(3,'h');


        InnerNode i1 = new InnerNode(1);
        InnerNode i2 = new InnerNode(2);
        InnerNode i3 = new InnerNode(3);
        InnerNode i4 = new InnerNode(4);
        InnerNode i5 = new InnerNode(5);
        InnerNode i6 = new InnerNode(6);
        InnerNode i7 = new InnerNode(7);

        i1.setLeft(i2);
        i1.setRight(i3);

        i2.setLeft(i4);
        i2.setRight(i5);

        i3.setLeft(i6);
        i3.setRight(i7);

        i4.setLeft(a);
        i4.setRight(b);

        i5.setLeft(c);
        i5.setRight(d);

        i6.setLeft(e);
        i6.setRight(f);

        i7.setLeft(g);
        i7.setRight(h);

        Huffman huffman = new Huffman();
        huffman.addToNodeList(a);
        huffman.addToNodeList(b);
        huffman.addToNodeList(c);
        huffman.addToNodeList(d);
        huffman.addToNodeList(e);
        huffman.addToNodeList(f);
        huffman.addToNodeList(g);
        huffman.addToNodeList(h);

        huffman.encodeAllChars(i1);

        System.out.println(huffman.charAndCodes.get('a'));
        System.out.println(huffman.charAndCodes.get('b'));
        System.out.println(huffman.charAndCodes.get('d'));
        System.out.println(huffman.charAndCodes.get('e'));
    }

    @Test
    public void testEncodeMessage(){
        LeafNode a = new LeafNode(3,'a');
        LeafNode b = new LeafNode(3,'b');
        LeafNode c = new LeafNode(3,'c');
        LeafNode d = new LeafNode(3,'d');
        LeafNode e = new LeafNode(3,'e');
        LeafNode f = new LeafNode(3,'f');
        LeafNode g = new LeafNode(3,'g');
        LeafNode h = new LeafNode(3,'h');


        InnerNode i1 = new InnerNode(1);
        InnerNode i2 = new InnerNode(2);
        InnerNode i3 = new InnerNode(3);
        InnerNode i4 = new InnerNode(4);
        InnerNode i5 = new InnerNode(5);
        InnerNode i6 = new InnerNode(6);
        InnerNode i7 = new InnerNode(7);

        i1.setLeft(i2);
        i1.setRight(i3);

        i2.setLeft(i4);
        i2.setRight(i5);

        i3.setLeft(i6);
        i3.setRight(i7);

        i4.setLeft(a);
        i4.setRight(b);

        i5.setLeft(c);
        i5.setRight(d);

        i6.setLeft(e);
        i6.setRight(f);

        i7.setLeft(g);
        i7.setRight(h);

        Huffman huffman = new Huffman();
        huffman.addToNodeList(a);
        huffman.addToNodeList(b);
        huffman.addToNodeList(c);
        huffman.addToNodeList(d);
        huffman.addToNodeList(e);
        huffman.addToNodeList(f);
        huffman.addToNodeList(g);
        huffman.addToNodeList(h);

        huffman.encodeAllChars(i1);

        String s = huffman.encodeMessage("aabcdbfgdee");
        System.out.println(s);
    }

    @Test
    public void testMinHeap(){
        LeafNode a = new LeafNode(1,'a');
        LeafNode b = new LeafNode(2,'b');
        LeafNode c = new LeafNode(3,'c');
        LeafNode d = new LeafNode(4,'d');
        LeafNode e = new LeafNode(5,'e');
        LeafNode f = new LeafNode(6,'f');
        LeafNode g = new LeafNode(7,'g');

        PriorityQueue<MyNode> min_heap = new PriorityQueue<>();
        min_heap.add(a);
        min_heap.add(b);
        min_heap.add(c);
        min_heap.add(d);

        System.out.println(min_heap.peek().getCh());
        min_heap.remove();
        System.out.println(min_heap.peek().getCh());
    }

    @Test
    public void testBuildingHoffmanTree(){
        LeafNode a = new LeafNode(1,'a');
        LeafNode b = new LeafNode(2,'b');
        LeafNode c = new LeafNode(3,'c');
        LeafNode d = new LeafNode(4,'d');
        LeafNode e = new LeafNode(5,'e');
        LeafNode f = new LeafNode(6,'f');
        LeafNode g = new LeafNode(7,'g');

        Huffman huffman = new Huffman();
        huffman.addToNodeList(a);
        huffman.addToNodeList(b);
        huffman.addToNodeList(c);
        huffman.addToNodeList(d);
        /*
        huffman.addToNodeList(e);
        huffman.addToNodeList(f);
        huffman.addToNodeList(g);
        */
        MyNode n = huffman.buildHuffmanTree();
        assertEquals(n.getFreq(), 10);
    }

    @Test
    public void testEncodeHuffmanTree(){
        LeafNode a = new LeafNode(1,'a');
        LeafNode b = new LeafNode(2,'b');
        LeafNode c = new LeafNode(3,'c');
        LeafNode d = new LeafNode(4,'d');
        LeafNode e = new LeafNode(5,'e');
        LeafNode f = new LeafNode(6,'f');
        LeafNode g = new LeafNode(7,'g');

        Huffman huffman = new Huffman();
        huffman.addToNodeList(a);
        huffman.addToNodeList(b);
        huffman.addToNodeList(c);
        huffman.addToNodeList(d);
        /*
        huffman.addToNodeList(e);
        huffman.addToNodeList(f);
        huffman.addToNodeList(g);
        */

        MyNode root = huffman.buildHuffmanTree();

        assertEquals(
                huffman.encodeChar('d', root).toString(), "1x"  );
        assertEquals(
                huffman.encodeChar('b', root).toString(), "000x" );


        String s = huffman.encodeChar('d', root).toString();
        System.out.println(s);
    }

}