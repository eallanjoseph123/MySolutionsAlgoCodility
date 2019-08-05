package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Stack {
	
	static int length = 10;
	
	 int top = -1;
	
	 int []array;
	 
	 int min = 0;
	
	public Stack(int capacity){
		length = capacity;
	  array = new int[length];	
	}
	
	public Stack(){
		this(length);
	}
	
	public static void main(String[] args) throws Exception{
		Map<Integer,Integer> map = new HashMap<>();
		map.put(0, 5);
		map.put(0, 3);
		
		map.forEach((x,y)->System.out.println(y));
		
	}
	
	
	
	public static void helperS2(java.util.Stack<Integer> s1,java.util.Stack<Integer> s2) {
		 if(s2.isEmpty()){
             while(!s1.isEmpty()){
                 s2.push(s1.pop());
             }
         }
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
			if(array[min] > item){
				min = top;
			}
		}
	}
	
	public int min() {
		return array[min];
	}

	public boolean isEmpty() {
		return top < 0 ;
	}
	
	public int size(){
		return top+1;
	}
	
	
}
