import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numb = new int[]{50, 1, 1024};
        int[] payments = new int[]{20000, 100000, 20000};
        int m = numb.length + payments.length;
        int[] xyu = Level1.SynchronizingTables(m,numb,payments);

    }
}

