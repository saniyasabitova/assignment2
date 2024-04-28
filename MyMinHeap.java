import java.util.NoSuchElementException;

public class MyMinHeap<T extends Comparable<T>> {
    MyLinkedList<T> linky = new MyLinkedList<T>();

    public MyMinHeap() {
        linky = linky;
    }
    /*This method checks whether the list is empty or not. In case of empty, returns the value true,otherwise false*/
    public boolean empty() {
        if (linky.size() == 0) {
            return true;
        }
        return false;
    }
   /*This method does not take anything as parameter and returns the size of array*/
    public int size() {
        return linky.size();
    }
/*The method returns the root element of Min Heap
* does not take anything as parameter
* Time Complexity is O(1)*/
    public T getMin() {
        return linky.getFirst();
    }

/*The method takes as parameter element and adds it to the end of list,
* if they violates the property, calls method traverse up
* Time complexity is O(log n)*/
    public void insert(T element) {
        linky.addLast(element);
        heapify(linky.size()-1);
    }
    /*The method deletes the root element also returns the root element of Min Heap
    *after removing the root, it calls heapify down method
    * (it address the issue of violating the rule)
    * that's why time complexity is O(log n)
* does not take anything as parameter
* in case of size empty, throws new NoSuchElementException */

    public T extracMin() {
if (linky.size()==0) {
        throw new NoSuchElementException("Heap is empty");
    }

    T top = linky.getFirst(); // Get the top element (minimum element)
    if (linky.size() > 1) {
        linky.set(0, linky
                .getLast()); // Replace the top element with the last element
        linky.removeLast(); // Remove the last element
        heapifyDown(0); // Heapify down from the root to maintain the heap property
    } else {
        linky.removeFirst(); // If there's only one element, remove it
    }
    return top; // Return the deleted top element
    }

    //privates:
    /**/
    private void swap(int i, int j) {
        T temp = linky.get(i);
        linky.set(i, linky.get(j));
        linky.set(j, temp);
    }

    private void traverse_up(int index) {
    while (index > 0) {
        int parentIndex = (index - 1) / 2;
        if (linky.get(index).compareTo(linky.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
        } else {
            break; // Stop if the current element is in the correct position
        }
    }
}

private void heapify(int index) {
    traverse_up(index);
}
private void heapifyDown(int index) {
        while (index < linky.size() / 2) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallerChildIndex = leftChildIndex;

            if (rightChildIndex < linky.size() &&
                linky.get(rightChildIndex).compareTo(linky.get(leftChildIndex)) < 0) {
                smallerChildIndex = rightChildIndex;
            }

            if (linky.get(index).compareTo(linky.get(smallerChildIndex)) > 0) {
                swap(index, smallerChildIndex);
                index = smallerChildIndex;
            } else {
                break;
            }
        }
    }

}
