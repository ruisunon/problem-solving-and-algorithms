package net.interviews.revisit.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class CyclicLinkedListTest {

	public static void main(String args[]) { 
		
	    //
		CyclicLinkedList cyLinkedList = new CyclicLinkedList();
		cyLinkedList.appendIntoTail(new CyclicLinkedList.Node("101"));
		CyclicLinkedList.Node cycle = new CyclicLinkedList.Node("201");
		cyLinkedList.appendIntoTail(cycle); 
		cyLinkedList.appendIntoTail(new CyclicLinkedList.Node("301")); 
		cyLinkedList.appendIntoTail(new CyclicLinkedList.Node("401")); 
		cyLinkedList.appendIntoTail(cycle); 
	    //don't call toString method in case of cyclic linked list, it will throw OutOfMemoryError
	    //System.out.println("Linked List : " + linkedList); 
	    if(cyLinkedList.isCyclic())
	    { System.out.println("Linked List is cyclic as it contains cycles or loop"); }
	    else
	    {
	    	System.out.println("LinkedList is not cyclic, no loop or cycle found"); } 
		}
}
