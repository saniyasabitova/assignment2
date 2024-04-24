import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {

    private class Node <E>{
    E data;
    Node next;
}

    Node head;

    public void add(T item){
        Node <T> node = new Node<>();
        node.data = item;
        node.next = null;

        if(head==null){
            head = node;
        }
        else{
            Node n = head;
            while(n.next!=null) {
                n = n.next;

            }
            n.next = node;
        }
    }

 //void get(T item,int index);
 public void add(T data, int index){
        Node<T> node = new Node<>();
        node.data = data;
        node.next = null;

        Node n = head;
        for(int i =0;i<index-1;i++){
            n=n.next;
        }
        node.next = n.next;
        n.next = node;


 }
 public void addFirst(T data){
        Node n = head;
        Node<T> node = new Node<>();
        node.data = data;
        head = node;
        node.next = n;

 }
 public void addLast(T data){
        Node <T> node = new Node<>();
        node.data = data;
        node.next = null;

        if(head==null){
            head = node;
        }
        else{
            Node n = head;
            while(n.next!=null) {
                n = n.next;

            } n.next = node;
        }
 }
 public void show(){
        Node node = head;
        while(node.next!=null){
            System.out.println(node.data);
            node = node.next;
        }
     System.out.println(node.data);

 }
 public T get (int index){
        Node<T> n = head;
        for (int i=0;i<index;i++){
            n = n.next;
        }
     System.out.println(n.data);
        return (T) n;
 }
 public T getFirst(){
        return (T) head.data;
 }
public T getLast(){
        Node <T> n = head;
        while(n.next!=null){
            n = n.next;
        }
     System.out.println(n.data);
        return (T) n;
 }
 public void removeFirst(){
       head = head.next;
 }
 public void removeLast(){
        Node<T> n=head;
        int c=0;
        while(n.next!=null){
            n = n.next;
            c++;
        }
        remove(c);

 }
public void remove(int index){
        Node<T> n = head;
        Node n1 =null;
        for(int i=0;i<index-1;i++){
            n = n.next;
        }
        n1 = n.next;
        n.next = n1.next;
}
public void sort (){

}
public int indexOf(Object object){
        int i =0;
        Node <T> n = head;
        while(n.next!=null){
            Object c= n.data;
            if(c.equals(object)){
                System.out.println("Index of " + n.data + " is "+ i);
                return i;
            }
            n=n.next;
            i++;
        }Object c= n.data;
        if (c.equals(object)){
            System.out.println("Index of " + n.data + " is "+ i);
            return i;
        }
    System.out.println("There is no such item" );
        return -1;
}
// int lastIndexOf(Object object);
boolean exists(Object object){
         int i =0;
        Node<T> n = head;
        while(n.next!=null){
            Object c= n.data;
            if(c.equals(object)){
                return true;
            }
            n=n.next;
            i++;
        }Object c= n.data;
        if (c.equals(object)){
            return true;
        }
    System.out.println("There is no such item" );
        return false;
}
//// public Object[] toArray();
 public void clear(){
        head = null;


 }
public int size(){
        if(head == null){
            return 0;
        }
      Node<T> n=head;
        int c=0;
        while(n.next!=null){
            n = n.next;
            c++;
        }
    //System.out.println("The size is "+ c+1);
        return c+1;
}
public T getData(Node<T> node){
        return node.data;
}



    @Override
    public Iterator<T> iterator() {
         return new  MyIterator();
    }
     private class MyIterator implements Iterator <T>{
        int cursor =0;
        @Override
        public boolean hasNext() {
            return cursor!=size();
        }

        @Override
        public T next() {
            T nextItem = get(cursor);
            cursor++;
            return nextItem;
        }
    }
}
