import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T>  {
    public T show;
    private Object[] array;
    private int size = 0;
    private int capacity = 10;
    public MyArrayList(){
        array = new Object[capacity];  //declaration
    }
    public T get(int index){
        return (T )array[index];
    }
    
    public void show(){
        for(int i=0;i<size-1;i++){
            System.out.print((T)array[i] +" \t");
        }
    }


    private void IncreaseBuffer(){
        capacity = (int) (capacity*1.5);
        Object[] array2 = new Object[capacity];
        for (int i =0;i<size;i++){
            array2[i]=array[i];
        }
        array = array2;
    }

    public void add(T item){
          if(size==capacity){
          IncreaseBuffer();
          }
          array[size++]=item;
    }

    public void remove(int index){
        for (int i =index;i<size-1;i++){
            array[i]=array[i+1];
        }
        size--;
    }
    public int size(){
        return size;
    }
    public void add(T item,int index){
        if(size==capacity) {
            IncreaseBuffer();
        }
        for (int i =size;i>index;i--){
            array[i]=array[i-1];
        }
        array[index]=item;
        size++;
    }
     public void addFirst(T item){
        if(size==capacity){
            IncreaseBuffer();
        }
        for (int i=size;i>0;i--){
            array[i]=array[i-1];
        }
        size++;
        array[0]=item;
     }
     public void  addLast(T item){
        if(size==capacity){
            IncreaseBuffer();
        }size++;
        array[size-1]=item;
      }
      public void removeLast(){
        size--;
      }
      public void removeFirst(){
        for(int i =0;i<size-1;i++){
            array[i]=array[i+1];
        }
        size--;
      }
      public T getFirst(){
        return (T) array[0];
      }
      public T getLast(){
        return (T) array[size-1];
      }

     public   void sort() {
        for (int i = 1; i < size; i++) {
            T key = (T) array[i];
            int j = i - 1;

            while (j >= 0 && ((T)array[j]).compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }
     public int indexOf(Object object){
        int i;
        for(i=0;i<size;i++){
            if(((T)array[i]).equals(object)){
                return i;

            }


        }
         System.out.println("There is no such element here");
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        int i =0;
        for(i=0;i<size;i++){
            if(((T)array[i]).equals(object)){
                return true;

            }


        }
        return false;
    }

    public void clear(){

            array = null;

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

