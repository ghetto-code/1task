import java.util.*;
class Level1 {
        public static int squirrel(int N) {
            if (N <= 0) {
                return 0;
            }
        int fact = N;
        for (int i = N-1; i > 1; -- i) {
            fact *= i;
        }
        char quant = Integer.toString(fact).charAt(0);

        return Integer.parseInt(String.valueOf(quant));
    }
}