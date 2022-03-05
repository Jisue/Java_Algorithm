import java.util.ArrayList;

public class arrayTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);
        int a = list.get(1);
        System.out.println(a);

        list.remove(1);
        System.out.println(list);
        int b = list.get(1);
        System.out.println(b);

    }
}
