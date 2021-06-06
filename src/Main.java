import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] x = new int[7];
        Random random = new Random();
        for (int i = 0; i < x.length; i ++){
            x[i] = (int) (Math.random() * 255);

        }
        for(int i = 0; i < x.length; i ++){
            System.out.println(x[i]);
        }
        System.out.println(Arrays.toString(Level1.MadMax(x.length, x)));

    }
}

