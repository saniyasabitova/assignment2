import java.util.EmptyStackException;

public class MyStack<T extends Comparable<T>> {
    MyLinkedList<T> linky = new MyLinkedList<T>();
    /*This method checks whether the list is empty or not. In case of empty, returns the value true,otherwise false*/
    public boolean empty(){
        if (linky.size() == 0) {
            return true;
        }return false;
    }
/*This method get the top element from Stack (in case of linked list,it is the last element ) but does not remove it
* In case of list is empty, returns null*/
	public Object peek(){
       if(linky.size()==0){
           return null;
       }
        return linky.getLast();
    }

/*This method does not take anything as parameter and returns the size of list*/
    public int size(){
       return linky.size();
   }


   /*This Method deletes the top most element from stack (the last added in the list) then returns it
   * Does not take any parameter
   *  throws EmptyStackException is thrown if the stack is empty.*/
	public Object pop(){
        if (linky.size()==0){
            throw new EmptyStackException();
        }
        Object o = linky.getLast();
        linky.removeLast();
        return o;
    }
/*This Method takes as parameter object of type Object and adds it to the top of Stack, what means the end of linked list
* then returns that element */
	public Object push(Object element){
        linky.addLast((T) element);
        return element;
    }

/*This method searches the element from list, takes parameter element of type Object
* if it finds, returns the distance from top of Stack, otherwise returns -1*/
int search(Object element){
        int a = linky.indexOf((T)element);
        if(linky.exists((T)element)){
            return linky.size()-a;
        }
        return -1;
}

}
