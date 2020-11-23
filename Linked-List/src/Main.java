public class Main {

    public static void main(String[] args) {
        // write your code here
        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(1);
        list.addFirst(3);
        list.add(1,1990);
        System.out.println(list);
        list.addFirst(13);
        System.out.println(list);
        list.addLast(2);
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        list.removeElement(1990);
        System.out.println(list);
    }
}
