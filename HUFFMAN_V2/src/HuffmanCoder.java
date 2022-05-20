public class HuffmanCoder {

	public EncodedMessage<?, ?> encode(String msg) {

		//build the tree from the message
		HuffmanTree huffmanTree = new HuffmanTree();
		huffmanTree.buildHuffmanTree(msg);


		//encode message with tree
		String encoded = huffmanTree.encodeMessage(msg);

		//return the encoded message and the root of the tree
		return new EncodedMessage<>(huffmanTree.getRoot(), encoded);
	}

	/**
	 * for decoding the tree we need to traverse trought the tree for every character
	 *
	 * @param msg the encoded message
	 * @return decoded message
	 */
	public String decode(EncodedMessage<?, ?> msg) {

		//at the beginning current is set to root
		MyNode current = (MyNode) msg.header;
		//the message to be decoded
		String message = (String) msg.message;

		StringBuilder decodedMsg = new StringBuilder();

		for (int i = 0; i < message.length(); i++){

			if (current.isLeaf()){
				decodedMsg.append(current.getCh());
				//set current to root again
				current = (MyNode) msg.header;
			}
			else{ //else - its not leaf

				if(message.charAt(i) == '0')
					current = current.getLeft();
				else //else if is '1' in encoded message... get right child
					current = current.getRight();

			}
		}

		return decodedMsg.toString();
	}

}
