
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    @Override
    public void add(T item, int index) {
         // Check for a valid index
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        // Find the node to be updated
        ListNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        // Update the data of the node
        current.data = item;

    }

    private static class ListNode<T extends Comparable<T>> implements Comparable<ListNode<T>> {
        T data;
        ListNode<T> next;
        ListNode<T> prev;

        ListNode(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        ListNode(T data, ListNode<T> next, ListNode<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public int compareTo(ListNode<T> other) {
            // Delegate to T's compareTo method
            return this.data.compareTo(other.data);
        }
    }


    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    @Override
    public void add(T item) {
        // If the list is empty, add the new node as the head and tail.
        if (head == null) {
            head = new ListNode<>(item);
            tail = head;
        } else {
            // Otherwise, add the new node after the tail and update the tail reference.
            ListNode<T> newNode = new ListNode<>(item, null, tail);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    public void set(int index, T item) {
        // Check for a valid index
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        // Find the node to be updated
        ListNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        // Update the data of the node
        current.data = item;
    }


    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        // If adding at the start, use addFirst method.
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            // If adding at the end, use addLast method.
            addLast(item);
        } else {
            // Otherwise, find the node currently at the specified index.
            ListNode<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            // Create a new node and re-link the references.
            ListNode<T> newNode = new ListNode<>(item, current, current.prev);
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        // Create a new node that points to the current head.
        ListNode<T> newNode = new ListNode<>(item, head, null);
        // If the list is empty, head and tail should both point to the new node.
        if (head == null) {
            tail = newNode;
        } else {
            // Otherwise, update the previous head to point back to the new node.
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }

    @Override
    public void addLast(T item) {
        // This method is the same as the add method which adds the item at the end.
        add(item);
    }

    @Override
    public T get(int index) {
        // Check for a valid index
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        ListNode<T> current;
        // If the index is in the first half of the list, start from the head
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next; // Move to the next node
            }
        } else {
            // If the index is in the second half of the list, start from the tail
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev; // Move to the previous node
            }
        }
        return current.data;
    }

    @Override
    public T getFirst() {
        // If the list is empty, throw an exception
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data; // Return the data of the first node
    }

    @Override
    public T getLast() {
        // If the list is empty, throw an exception
        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail.data; // Return the data of the last node
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // Special cases: remove first or last
        if (index == 0) {
            removeFirst();
            return;
        } else if (index == size - 1) {
            removeLast();
            return;
        }

        // Find the node to remove
        ListNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        // Unlink the node from the list
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.next = null; // Help garbage collection
        current.prev = null; // Help garbage collection

        size--;
    }

    @Override
    public void removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        // Move the head pointer to the next node, which will become the new head
        ListNode<T> nextNode = head.next;

        if (nextNode != null) {
            // If there's a next node, update its prev pointer to null
            nextNode.prev = null;
        } else {
            // If there's no next node, the list is now empty and tail should also be null
            tail = null;
        }

        // Help garbage collection
        head.next = null;
        head = nextNode;

        size--;
    }

    @Override
    public void removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }

        // Move the tail pointer to the previous node, which will become the new tail
        ListNode<T> prevNode = tail.prev;

        if (prevNode != null) {
            // If there's a previous node, update its next pointer to null
            prevNode.next = null;
        } else {
            // If there's no previous node, the list is now empty and head should also be null
            head = null;
        }

        // Help garbage collection
        tail.prev = null;
        tail = prevNode;

        size--;
    }

    @Override
    public void sort() {
        if (head == null || head.next == null) {
            return; // List is already sorted or empty.
        }

        // New sorted (dummy) list
        ListNode<T> sorted = new ListNode<>(null); // Dummy head

        while (head != null) {
            // Remove the first node from the original list
            ListNode<T> current = head;
            head = head.next;

            // Find the correct place to insert the node in the sorted list
            ListNode<T> sortedCurrent = sorted;
            while (sortedCurrent.next != null && sortedCurrent.next.data.compareTo(current.data) < 0) {
                sortedCurrent = sortedCurrent.next;
            }

            // Insert the node in the sorted list
            current.next = sortedCurrent.next;
            if (sortedCurrent.next != null) {
                sortedCurrent.next.prev = current;
            }
            sortedCurrent.next = current;
            current.prev = sortedCurrent;

            // Update tail if necessary
            if (sortedCurrent == tail || tail == null) {
                tail = current;
            }
        }

        // Replace the old list with the sorted list (skipping the dummy head)
        head = sorted.next;
        if (head != null) {
            head.prev = null;
        }
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        ListNode<T> current = head;

        // If the object is null, look for a null element in the list.
        if (object == null) {
            while (current != null) {
                if (current.data == null) {
                    return index;
                }
                current = current.next;
                index++;
            }
        } else {
            // If the object is not null, look for an element equal to the object.
            while (current != null) {
                if (object.equals(current.data)) {
                    return index;
                }
                current = current.next;
                index++;
            }
        }
        return -1; // Return -1 if the object is not found.
    }



    public int lastIndexOf(Object object) {
        int index = size - 1;
        ListNode<T> current = tail;

        // If the object is null, look for a null element from the end of the list.
        if (object == null) {
            while (current != null) {
                if (current.data == null) {
                    return index;
                }
                current = current.prev;
                index--;
            }
        } else {
            // If the object is not null, look for an element equal to the object from the end.
            while (current != null) {
                if (object.equals(current.data)) {
                    return index;
                }
                current = current.prev;
                index--;
            }
        }
        return -1; // Return -1 if the object is not found.
    }


    @Override
    public boolean exists(Object object) {
        ListNode<T> current = head;

        // If the object is null, look for a null element in the list.
        if (object == null) {
            while (current != null) {
                if (current.data == null) {
                    return true; // Found a null element in the list.
                }
                current = current.next;
            }
        } else {
            // If the object is not null, look for an element equal to the object.
            while (current != null) {
                if (object.equals(current.data)) {
                    return true; // Found an element equal to the object.
                }
                current = current.next;
            }
        }
        return false; // Object not found in the list.
    }


//    @Override
//    public Object[] toArray() {
//        Object[] result = new Object[size]; // Initialize an array of Object with the size of the linked list.
//        int i = 0; // Start with the first index.
//        ListNode<T> current = head; // Start traversal from the head of the list.
//
//        // Traverse the list and fill the array.
//        while (current != null) {
//            result[i++] = current.data; // Assign the data from the current node to the array.
//            current = current.next; // Move to the next node.
//        }
//
//        return result; // Return the filled array.
//    }


    @Override
    public void clear() {
        // Iterate through the list and remove all references
        ListNode<T> current = head;
        while (current != null) {
            ListNode<T> next = current.next;
            current.data = null; // Help garbage collection by clearing the data reference
            current.next = null; // Clear reference to the next node
            current.prev = null; // Clear reference to the previous node
            current = next;      // Move to the next node
        }

        // Finally, reset head and tail to null to fully clear the list
        head = null;
        tail = null;
        size = 0; // Reset the size of the list
    }


    @Override
    public int size() {
        return size; // Return the size of the list which is updated on every add/remove operation.
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private ListNode<T> current = head;  // Start with the first element in the list.

            @Override
            public boolean hasNext() {
                return current != null;  // Return true if there is another element next.
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();  // Throw an exception if there is no next element.
                }
                T data = current.data;  // Retrieve the data from the current node.
                current = current.next;  // Move to the next node.
                return data;  // Return the data.
            }
        };
    }

}