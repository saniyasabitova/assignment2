
public class Main {
    public static void main(String[] args) {

    MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        System.out.println(queue.peek());
        System.out.println(queue.size());


        System.out.println("LINKED LIST _________________________________________");

        MyLinkedList<Integer> linky = new MyLinkedList<Integer>();
        linky.addLast(6);

        System.out.println(linky.size());




        }





    }
