package main;

public class Stack {
	
	static int length = 10;
	
	 int top = -1;
	
	 int []array;
	
	public Stack(int capacity){
		length = capacity;
	  array = new int[length];	
	}
	
	public Stack(){
		this(length);
	}
	
	public static void main(String[] args) throws Exception{
		Stack stack = new Stack(3);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		int p = 2;
	}
	
	public int top() throws Exception{
		int result = 0;
		if(top < 0){
			throw new Exception("stack is empty");
		}else {
			result = array[top];
		}
		return result;
	}
	
	public int pop() throws Exception {
		int result = 0;
		if(top > 0){
			result = array[top];
			array[top] = -1;
			top = top -1;
		}else {
			throw new Exception("Stack is underflow");
		}
		return result;
	}
	
	public void push(int item) throws Exception{
		
		if((length-1) == top) {
			throw new Exception("stack is overflow");
		}else {
			top = top + 1;
			array[top] = item;
		}
	}

	public boolean isEmpty() {
		return top < 0 ;
	}
	
	public int size(){
		return top+1;
	}
	
	
}
