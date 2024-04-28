public class MyQueue<T extends Comparable<T>> {
   MyLinkedList<T> linky = new MyLinkedList<T>();

    public MyQueue() {
        this.linky = linky;
    }
    /*This method checks whether the list is empty or not. In case of empty, returns the value true,otherwise false*/
    public boolean empty(){
       if(linky.size()==0){
           return true;
       }
       return false;
   }
   /*This method does not take anything as parameter and returns the size of array*/
   public int size(){
       return linky.size();
   }
   /*This method gets the first element of (the element at the front the container) linked list but does not delete it
   * In case of list empty, it does not through any exception, instead returns null*/
      public T peek(){
       if(linky.size()==0){
           return null;
       }
       return linky.getFirst();
      }
/*This method takes item of parameter T and adds it to the end of linked list */
      public T enqueue(T item){
       linky.addLast(item);
       return item;
      }
      /*This method deletes the front element(in the beginning of list) from linked list*/
      public T dequeue(){
       T item_deleted = linky.getFirst();
       linky.removeFirst();
       return item_deleted; //look again
      }



}
