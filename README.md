#ASSIGNMENT 2 FOR ALGORITHMS AND DATA STRUCTURES
 MyArrayList,MyLinkedList,MyStack, MyQueue,MyMinHeap.

 DESCRIPTION:
 
 This projects provides classes as  MyArrayList,MyLinkedList which are implementations of  ArrayList and LinkedList respectively. They 
contain all the necessary methods as add(T item, int index),set(T item, int index),add(T item), addFirst(T item), addLast(T item), get(int index), getFirst(),getLast(), remove(int index), sort(),clear(),size(),iterator() which are implemented from interface  MyList, java.util.* was not used at all, except of java.util.Iterator.Also there are classes MyStack, MyQueue and MyMinHeap. All of them were based on MyLinkedList.In the main all methods were tested.

MyArrayList:
Fields:
    private Object[] array: an array to hold all the elements.
    
    private int size: number of elemenets currently in the list.
    
    private int capacity: maximum number of elements of the array.
    
MyLinkedList:

    private ListNode<T> head: the front, beginning of linked list
    
    private ListNode<T> tail: the end of the list
    
    private int size:number of elemenets currently in the list.
    
   Both of them have methods described above.
 
