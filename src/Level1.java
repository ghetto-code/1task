import java.lang.reflect.Array;
import java.util.Arrays;

public class Level1 {
    public static int [] SynchronizingTables(int N, int [] ids, int [] salary) {
        int[] sal = salary;
        int[] id = ids;
        for (int i = 0;  i < sal.length; i ++) {
            for (int j = 0; j < sal.length - 1; j ++) {
                if(sal[j] < sal[j + 1]){
                    int swap = sal[j];
                    sal[j] = sal[j + 1];
                    sal[j + 1] = swap;
                }
            }
        }
        int l = 0;
        int idx = 0;
        for (int i = 0; i < sal.length; i ++) {
            int min = id[0];
            for (int j = l; j < id.length; j ++) {
                if (id[j] >= min) {
                    min = id[j];
                    idx = j;

                }
            }
            int swap = sal[idx];
            sal[idx] = sal[i];
            sal[i] = swap;
            l++;
        }
        for (int i = 0; i < sal.length / 2;i++){
            int swap = sal[i];
            sal[i] = sal[sal.length-1 - i];
            sal[sal.length-1 - i] = swap;
        }
        return sal;
    }
}
