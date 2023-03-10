/*
	Name: Ozair Khailq
	netID: okhali3
	email: okhali3@uic.edu
	Brief Description: For project 1 we implement our own versions of the stack and queue data structures.
					   Using built-in implementations for Iterator<E> and Iterable<T> interfaces.
					   Basically implementing the push/pop methods for Stack data structure and
					   enqueue/dequeue methods for Queue data structure.
 */
import java.util.ArrayList;

public class GLProject {

	public static void main(String[] args) {
		System.out.println("Welcome to project 1");
		GenericQueue<String> str1 = new GenericQueue<String>("x dequeue this");
		GenericStack<String> str2 = new GenericStack<String>("->this stays");

		//testing GenericQueue.java to see if enqueue and dequeue methods as intended
		System.out.println("\n***testing Queue elements:");
		str1.enqueue("->this stays");
		str1.print();
		str1.dequeue();
		System.out.println("Queue list after dequeue:");
		str1.print();
		System.out.println();

		//testing GenericStack.java to see if push and pop methods are working as intended
		System.out.println("***testing Stack elements:");
		str2.push("x pop this");
		str2.print();
		str2.pop();
		System.out.println("Stack after pop:");
		str2.print();
	}
}
