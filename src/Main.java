import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ids = new int[]{98,23,61,49,1,79,9};
        int[] payments = new int[]{1,15,32,47,68,39,24};
        int m = ids.length + payments.length;
        int[] xyu = Level1.SynchronizingTables(m,ids,payments);
            for (int x: xyu) {
                System.out.println(x);
            }
    }
}

