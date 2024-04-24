public interface MyList<T> extends Iterable<T>{
 void add(T item);
 //void get(T item,int index);
 void add(T item, int index);
 void addFirst(T item);
 void addLast(T item);
 T get (int index);
 T getFirst();
 T getLast();
 void removeFirst();
 void removeLast();
 void remove(int index);
 void sort ();
int indexOf(Object object);
// int lastIndexOf(Object object);
// boolean exists(Object object);
// public Object[] toArray();
 void clear();
 int size();


}
