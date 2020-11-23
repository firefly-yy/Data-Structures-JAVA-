public class Main {

    public static void main(String[] args) {

        Array arr = new Array(12);
        for(int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1,100);
        System.out.println(arr);
        arr.addFirst(-1);
        System.out.println(arr);
        arr.addLast(-1);
        System.out.println(arr);
        System.out.println(arr.get(3));
        arr.set(3,1000);
        System.out.println(arr.get(3));
        System.out.println(arr.find(100));
        System.out.println(arr);
        arr.removeFirst();
        arr.removeLast();
        System.out.println(arr);
        arr.remove(3);
        System.out.println(arr);
        System.out.println(arr.contains(5));
    }
}
