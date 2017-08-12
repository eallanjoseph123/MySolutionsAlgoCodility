package main.java.algo;

public class Node<T>{
	private Node<T> next;
	private T data;

	public Node(T t) {
		this.data = t;
	}
	public Node() {
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	
	
	
}
