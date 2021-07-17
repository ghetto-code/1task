import java.util.*;

public class Level1 {
    public static boolean TransformTransform(int[] A, int N) {
        int x [] = someFunc(someFunc(A));
        int sum = 0;
        for (int z : x) {
            sum += z;
        }
        if (sum % 2 != 0){
            return false;
        }
        return true;
    }
    public static int[] someFunc(int [] A) {
        List<Integer> B = new ArrayList<>();
        for (int  i = 0; i < A.length - 1; i ++) {
            ArrayList<Integer> arrKeys = new ArrayList<>();
            for (int  j = 0; j < A.length - 1 - i; j ++) {
                int  k = i + j;
                arrKeys.add(k);
            }
            int max = 0;
            for (int x : arrKeys) {
                if (A[x] >= max) {
                    max = A[x];
                }
            }
            B.add(max);
        }
        int idx = 0;
        int [] arrB = new int[B.size()];
        for(int x : B){
            arrB[idx] = x;
            idx++;
        }

        return arrB;
    }

}
