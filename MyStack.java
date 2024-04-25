public class MyStack<T extends Comparable<T>> {
    MyLinkedList<T> linky = new MyLinkedList<T>();
    public boolean empty(){
        if (linky.size() == 0) {
            return true;
        }return false;
    }
//Проверяет, является ли стек пустым. Возвращает true, если стек пустой. Возвращает false, если стек содержит элементы.
	public Object peek(){
       return linky.getLast();
    }

//Возвращает элемент, находящийся в верхней части стэка, но не удаляет его.
    public int size(){
       return linky.size();
   }
	public Object pop(){
        Object o = linky.getLast();
        linky.removeLast();
        return o;
    }
//Возвращает элемент, находящийся в верхней части стэка, удаляя его в процессе.
	public Object push(Object element){
        linky.addLast((T) element);
        return element;
    }
//Вталкивает элемент в стек. Элемент также возвращается.
int search(Object element){
        int a = linky.indexOf((T)element);
        if(linky.exists((T)element)){
            return linky.size()-a;
        }
        return -1;
}

}
