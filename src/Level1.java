import java.util.HashMap;
import java.util.Map;

public class Level1 {
    public static int [] SynchronizingTables(int N, int [] ids, int [] salary) {
        int[] sal = salary;
        int[] id = ids;
        int[] asd = new int[sal.length + id.length];
        HashMap<Integer,Integer> newList = new HashMap<>();
        for (int i = 0;  i < sal.length; i ++) {
            for (int j = 0; j < sal.length - 1; j ++) {
                if(sal[j] > sal[j + 1]){
                    int swap = sal[j];
                    sal[j] = sal[j + 1];
                    sal[j + 1] = swap;
                }
            }
        }

        for (int i = 0; i < asd.length; i += 2) {
            asd[i] = sal[i / 2];

        }
        for (int i = 0; i < asd.length; i += 2) {
            asd[i+1] = id[i / 2];

        }
        for(int i = 0; i < asd.length; i += 2) {
            for(int j = 0; j < asd.length -2; j += 2){
                if(asd[j + 1] > asd[j + 3]){
                    int swap = asd[j + 1];
                    asd[j + 1] = asd[j + 3];
                    asd[j + 3] = swap;
                }
            }
        }
        for (int i = 0; i < asd.length; i += 2) {
            newList.put(asd[i + 1], asd[i]);
        }
        for (int i = 0; i < id.length; i ++){
            if(newList.containsKey(id[i])){
                sal[i] = newList.get(id[i]);
            }
        }

        return sal;
    }
}
