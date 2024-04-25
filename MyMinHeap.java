import java.util.NoSuchElementException;

public class MyMinHeap<T extends Comparable<T>> {
    MyLinkedList<T> linky = new MyLinkedList<T>();

    public MyMinHeap() {
        linky = linky;
    }

    public boolean empty() {
        if (linky.size() == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return linky.size();
    }

    public T getMin() {
        return linky.getFirst();
    }

    public void insert(T element) {
        linky.addLast(element);
        heapify(linky.size()-1);
    }

    public T extraMin() {
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
