package main.java.algo;

public class LinkedList<T> {

	private Node<T> head;

	private int size;

	// Traversal to print all O(n) worst case
	public void printList() {
		Node<T> n = this.head;
		while (n != null) {
			System.out.print(n.getData() + " ");
			n = n.getNext();
		}
		System.out.println();
	}

	public Node<T> insertEnd(T data) {
		Node<T> node = this.getHead();
		if (node == null){
			node = new Node<T>();
			node.setData(data);
			this.setHead(node);
			return this.getHead();
		}else{
			while (head != null) {
				if (node.getNext() == null) {
					Node<T> newNode = new Node<T>(data);
					node.setNext(newNode);
					break;
				} else {
					node = node.getNext();
				}
			}
		}
		
		return head;
	}

	// O(1) constant time to make inseration into the front of list
	public Node<T> inserHead(T data) {
		Node<T> newHead = new Node<>();
		newHead.setData(data);
		newHead.setNext(this.getHead());
		this.setHead(newHead);
		return this.getHead();
	}
   //
	public Node<T> add(T data, int position) {
		int currentPosition = 0;
		Node<T> res = this.getHead();
		Node<T> lastNode = null;
		if (position == 0) {
			return this.inserHead(data);
		} else {
			
		}
		return res;
	}

	public int getSize() {
		Node<T> n = this.head;
		while (n != null) {
			size += 1;
			n = n.getNext();
		}
		return size;
	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

}
