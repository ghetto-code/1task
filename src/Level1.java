import java.util.*;
class Level1 {
    public static int squirrel(int N) {
        if (N <= 1) {
            return 1;
        }
        int fact = 1;
        for (int i = 2; i < N + 1; i++) {
            fact *= i;

        }
        char quant = Integer.toString(fact).charAt(0);

        return Integer.parseInt(String.valueOf(quant));
    }
}