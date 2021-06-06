import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] x = new int[]{1,2,3,4,5,6,7};

        for(int i = 0; i < x.length; i ++){
            System.out.println(x[i]);
        }
        System.out.println(Arrays.toString(Level1.MadMax(x.length, x)));

    }
}

