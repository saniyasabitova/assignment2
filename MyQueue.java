public class MyQueue<T extends Comparable<T>> {
   MyLinkedList<T> linky = new MyLinkedList<T>();

    public MyQueue() {
        this.linky = linky;
    }

    public boolean empty(){
       if(linky.size()==0){
           return true;
       }
       return false;
   }
   public int size(){
       return linky.size();
   }
      public T peek(){
       if(linky.size()==0){
           throw new RuntimeException("You can not access the 1st element");
       }
       return linky.getFirst();
      }

      public T enqueue(T item){
       linky.addLast(item);
       return item;
      }
      public T dequeue(){
       T item_deleted = linky.getFirst();
       linky.removeFirst();
       return item_deleted; //look again
      }



}
