/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author gorenjaa
 */
public class LinkedListAndArrayListUseCaseComparison {
    Node integerLinkedList;
    ArrayList<Integer> integerArrayList, duplicateArrayList;
    Node list = new Node(10); 
     
    public LinkedListAndArrayListUseCaseComparison(){
        initList();
        initDuplicateList();
    }
     static class Node { 
  
        int data; 
        Node next; 
  
        Node(int d) { 
            data = d; 
            next = null; 
        } 
    }
     
     final void initDuplicateList (){
        duplicateArrayList = new ArrayList<>();
       for (int i=0; i<=10000; i++){
           if(i%2 ==0){
            duplicateArrayList.add(2);
           }
           else {
               duplicateArrayList.add(i);
           }
        }
        list.next = new Node(10); 
        list.next.next = new Node(12); 
        list.next.next.next = new Node(11); 
        list.next.next.next.next = new Node(11); 
        list.next.next.next.next.next = new Node(12); 
        list.next.next.next.next.next = new Node(11); 
        list.next.next.next.next.next.next = new Node(10); 
        list.next.next.next.next.next.next.next = new Node(10); 
        list.next.next.next.next.next.next.next.next = new Node(10); 
        integerLinkedList = list;
     }
     
    /**
     *It removes duplicate node form linked list
     * @param head
     * @return
     */
    public long removeDuplicatesLinkedList(Node head) { 
         
        long startTime = System.currentTimeMillis();
         // Hash to store seen values 
        HashSet<Integer> hs = new HashSet<>(); 
      
        /* Pick elements one by one */
        Node current = head; 
        Node prev = null; 
        while (current != null)  
        { 
            int curval = current.data; 
              
             // If current value is seen before 
            if (hs.contains(curval)) { 
                prev.next = current.next; 
            } else { 
                hs.add(curval); 
                prev = current; 
            } 
            current = current.next; 
        } 
        long endTime = System.currentTimeMillis();
        
        return endTime - startTime;
    } 
    
    public long removeDuplicatesArrayList(){
        long startTime = System.currentTimeMillis();
         List<Integer> listWithoutDuplicates = integerArrayList.stream().distinct().collect(Collectors.toList());
         long endTime = System.currentTimeMillis();
         
         return endTime - startTime;
    }
    
    public long getElementInLinkedList(int index){
        Node current = integerLinkedList; 
        long startTime = System.currentTimeMillis();
        int count = 0; /* index of Node we are 
                          currently looking at */
        while (current != null) 
        { 
            if (count == index) 
            {System.out.println(String.valueOf(current.data));}
            else{
            count++; 
            current = current.next; 
            }
        } 
        /* if we get to this line, the caller was asking 
        for a non-existent element so we assert fail */
        long endTime = System.currentTimeMillis();
        return count; 
    }
    
    
    public long getElementInArrayList(int index){
        long startTime = System.currentTimeMillis();
        int currentTime = integerArrayList.get(index);
        long stopTime = System.currentTimeMillis();
        
        return stopTime - startTime;
    }
    
    
    public void CalculateDifferentLinkedListOperationtime(){
        // remove duplicates comarison
        
      if (removeDuplicatesArrayList() > removeDuplicatesLinkedList(list)){
      System.out.println("Linkedlist<E> is suitable to remove depulicates list because is faster by " +
              (removeDuplicatesLinkedList(list)- removeDuplicatesArrayList()) );
      };
      
      if (getElementInArrayList(6) < getElementInLinkedList(6)){
           System.out.println("ArrayList<E> is suitable to get an element at a prticular index because is faster by " +
              (getElementInArrayList(6)- getElementInLinkedList(6)) );
      }   
//        long end
    }

    private void initList() {
        integerArrayList = new ArrayList<>();
       for (int i=0; i<=100000; i++){
            integerArrayList.add(i);
        }
       
    }
}
