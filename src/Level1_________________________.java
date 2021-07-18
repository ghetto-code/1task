import java.util.*;

public class Level1_________________________ {
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


        for (int  i = 0; i < A.length; i ++) {
            for (int  j = 0; j < A.length - i; j ++) {
                int k = i + j;
                int max = A[j];
                for (int x = j; x < k + 1; x ++){
                    if (A[x] >= max) {
                        max = A[x];
                    }
                }
                B.add(max);

            }
        }

        int idx = 0;
        int [] arrB = new int[B.size()];
        for (int x : B) {
            arrB[idx] = x;
            idx++;
        }

        return arrB;
    }

}

