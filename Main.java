
public class Main {
    public static void main(String[] args) {

    MyArrayList<Integer> integ = new MyArrayList<>();
        integ.addFirst(1);
        System.out.println(integ.exists(1));//true
        System.out.println(integ.size());//1
        System.out.println(integ.get(0));//1
        System.out.println(integ.getFirst());//1
        System.out.println(integ.getLast());//1
        System.out.println(integ.indexOf(1));//0
        integ.add(2);
        integ.addLast(4);
        integ.add(5);
        integ.add(5);
        integ.add(5);
        integ.add(5);
        integ.remove(2); //remove 4
        integ.removeFirst();// remove 1
        integ.removeLast(); //remove 5
        integ.show(); //2 5 5
        System.out.println();
        System.out.println( "LINKED LIST");
        //for linked list:
        MyLinkedList<Integer> integers = new MyLinkedList<>();
        integers.addLast(2);
        integers.size();
        System.out.println(integers.size());//1
        System.out.println(integers.exists(2));//true
        System.out.println(integers.getLast());//2
        System.out.println(integers.get(0));//0
        System.out.println(integers.indexOf(2)); //0
        System.out.println(integers.getFirst());//2
        integers.addFirst(1);
        integers.add(6);
        integers.addLast(89);
        integers.sort();
        integers.removeFirst();
        integers.set(2,6);
        



        }





    }
