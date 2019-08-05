package queue;

public class Queue {
	
	private int[] qArray;
	
	private int rear;
	
	private int front;
	
	private int size;
	
	private static int CAPACITY = 16;
	
	
	public Queue(int capacity){
		capacity = capacity == 0 ? CAPACITY : capacity;
		qArray = new int[capacity];
	}
	
	public static void main(String[] args) throws Exception {
		Queue que = new Queue(4);
		que.enqueue(2);
		que.enqueue(1);
		que.enqueue(5);
		que.enqueue(6);
		
		
		que.dequeue();
		que.print();
	}
	
	
	public boolean isEmpty() {
		return size <= 0;
	}
	
	public int front() {
		return qArray[front];
	}
	
	public void enqueue(int data) throws Exception{
		if(size == qArray.length) {
			throw new Exception("overflow");
		}else {
			size+=1;
			qArray[rear] = data;
			int lenght = qArray.length;
			rear = (rear+1)%lenght;
		}
	}
	
	public int dequeue() throws Exception {
		if(size == 0) {
			throw new Exception("underflow");
		}else {
			size-=1;
			int lenght=qArray.length;
			int data = qArray[(front%lenght)];
			front = (front+1) % lenght;
			return data;
		}
	}

	
	public void print() {
		for(int a:qArray) {
			System.out.print(a+" ");
		}
	}
}
