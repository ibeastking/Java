import java.util.*;

class LinkedList1 {
    public static void main(String args[]) {
        LinkedList<Integer> ls = new LinkedList<Integer>();

        ls.add(10);
        ls.add(20);
        ls.add(30);

        System.out.println("Data: " + ls);
        System.out.println("Size: " + ls.size());

        int i = 0, n = ls.size();

        while (i < n) {
            System.out.println(ls.get(i));
            i++;
        }

        i = 0;
        int tot = 0;
        while (i < n) {
            Integer obj = ls.get(i);
            int val = obj.intValue();
            tot = tot + val;
            i++;
        }

        System.out.println("Total: " + tot);

        Iterator<Integer> it = ls.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        ListIterator<Integer> a = ls.listIterator();

        while (a.hasNext()) {
            System.out.println(a.next());
        }

        while (a.hasPrevious()) {
            System.out.println(a.previous());
        }

        ls.remove(1);
        System.out.println("Data: " + ls);

        ls.add(40);
        ls.add(50);
        ls.add(60);
        ls.add(70);

        System.out.println("Data: " + ls);

        ls.remove();

        System.out.println("Data: " + ls);

        ls.removeLast();

        System.out.println("Data: " + ls);

        Integer arr[] = new Integer[ls.size()];
        arr = ls.toArray(arr);

        System.out.println(Arrays.toString(arr));
    }

}