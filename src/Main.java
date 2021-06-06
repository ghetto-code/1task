import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numb = new int[]{1,3,2};
        int[] payments = new int[]{1000,500,350};
        int m = numb.length + payments.length;
        int[] xyu = Level1.SynchronizingTables(m,numb,payments);
        for (int x: xyu) {
            System.out.println(x);
        }
    }
}

