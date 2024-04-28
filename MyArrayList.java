import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T>  {
    public T show;
    private Object[] array;
    private int size = 0;
    private int capacity = 10;
    public MyArrayList(){
        array = new Object[capacity];  //declaration
    }

    //This method takes parameter  index of type integer and returns the element of that index from array.
    //Time complexity is O(1)
    public T get(int index){
        return (T )array[index];
    }
    //This method go through the array from the beginning and prints out all the elements from array
    //Time complexity is O(n)
    public void show(){
        for(int i=0;i<size-1;i++){
            System.out.print((T)array[i] +" \t");
        }
    }

/*This method increases the size of array, it copies all the elements of array and creates new array2 with greater size and put all copied elements there. In the end equate them
* Time complexity is O(n) */
    private void IncreaseBuffer(){
        capacity = (int) (capacity*1.5);
        Object[] array2 = new Object[capacity];
        for (int i =0;i<size;i++){
            array2[i]=array[i];
        }
        array = array2;
    }
 /* This method takes as parameter item of type T and add it to the end of array. If the array is full already, it calls the function IncreaseBuffer() in order to increase the size and put that item.
 * Time complexity  O(n) in the case IncreaseBuffer() was called  */
    public void add(T item){
          if(size==capacity){
          IncreaseBuffer();
          }
          array[size++]=item;
    }

    /*This method takes parameter  index of type integer and remove that corresponding element from array
    * Time complexity  O(n) */

    public void remove(int index){
        for (int i =index;i<size-1;i++){
            array[i]=array[i+1];
        }
        size--;
    }
    /*This method just return the size of array*/
    public int size(){
        return size;
    }
     /*This method takes parameter  index of type integer and T item and adds the item to that index. In case of array was full, it calls the method IncreaseBuffer()
     * Time complexity  O(n) */
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
    /*This method takes parameter T item and adds the item to the first index,In case of array was full, it calls the method IncreaseBuffer()
    *  Time complexity  O(n) */
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
      /*This method takes parameter T item and adds the item to the last index,In case of array was full, it calls the method IncreaseBuffer()
    *  Time complexity  O(n) */
     public void  addLast(T item){
        if(size==capacity){
            IncreaseBuffer();
        }size++;
        array[size-1]=item;
      }
       /*This method just deletes the last element from array
       * Time complexity  O(1)*/
      public void removeLast(){
        size--;
      }
      /*This method just deletes the first element from array and all elements were equated their previous elements using loop
       * Time complexity  O(n)*/
      public void removeFirst(){
        for(int i =0;i<size-1;i++){
            array[i]=array[i+1];
        }
        size--;
      }
      /*This method just get the first element from array and return it
      * Time complexity  O(1)*/
      public T getFirst(){
        return (T) array[0];
      }
      /*This method just get the last element from array and return it
      * Time complexity  O(1)*/
      public T getLast(){
        return (T) array[size-1];
      }

      /*This method compares all the elements to their previous elements from start. In the case the previous was greater,  they change positions
      * Tome complexity is O(n)*/
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
    /*This method shows the index of item
    * Tome complexity is O(n)*/

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
/*This method shows whether the object is contained in the array or not.
* In case of  founding  it returns boolean type true, otherwise false.
* Time complexity is O(n) */
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
    /*All the elements of array become null*/

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

