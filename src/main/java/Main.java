import arrayList.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<Integer>();
        System.out.println(myList.getCount());
        myList.add(1);
        myList.add(2);
        System.out.println(myList.getCount());
        myList.add(3);
        System.out.println(myList.removeAt(1));
        System.out.println(myList.getCount());
        myList.add(2);
        System.out.println(myList.get(0));
    }
}
