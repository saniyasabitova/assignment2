public class MyStack<T extends Comparable<T>> {
    MyLinkedList<T> linky = new MyLinkedList<T>();
    public boolean empty(){
        if (linky.size() == 0) {
            return true;
        }return false;
    }

	public Object peek(){
       return linky.getLast();
    }


    public int size(){
       return linky.size();
   }
	public Object pop(){
        Object o = linky.getLast();
        linky.removeLast();
        return o;
    }

	public Object push(Object element){
        linky.addLast((T) element);
        return element;
    }

int search(Object element){
        int a = linky.indexOf((T)element);
        if(linky.exists((T)element)){
            return linky.size()-a;
        }
        return -1;
}

}
