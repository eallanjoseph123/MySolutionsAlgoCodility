package queue;

public class QNode {
	
	Node r,f;
	
	int lenght = 0;
	
	
	public static void main(String[] args) {
		QNode q = new QNode();
		q.insert(2);
		q.insert(1);
		q.insert(3);
		
		q.dequeue();
		
	}
	
	public void print() {
        Node temp = f;
		while(temp != null) {
			System.out.print(r.data+" ");
		    temp = temp.next;
		}
	}
	
	public int data() {
		return f.data;
	}
	
	public void insert(int data) {
		Node newQue = new Node(data);
		if(lenght == 0) {
			f = newQue;
		}else{
			r.next = newQue;
		}
		lenght+=1;
		r = newQue;
	}
	
	public int dequeue() {
		int res = f.data;
		f = f.next;
		lenght-=1;
		return res;
	}
	
	
	private static class Node{
		int data;
		
		Node next;

		public Node(int data) {
			this.data = data;
		}
		
		
	}

}
