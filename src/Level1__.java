import java.util.*;

public class Level1__ {
    public static int ConquestCampaign(int N, int M, int L, int[] battalion) {
        int days = 1;
        HashMap<Integer, String> collection = new HashMap<>();
        int hashIdx = 0;
        int [] bat = battalion;
        for (int i = 0; i < bat.length; i += 2) {
            if(!collection.containsValue(bat[i] + " " + bat[i + 1])){
                collection.put(hashIdx, bat[i] + " " + bat[i + 1]);
                hashIdx++;
            }
        }
        while (collection.size() < M * N){
            bat = getNewList(bat, M, N);
            for (int i = 0; i < bat.length; i += 2) {
                if (!collection.containsValue(bat[i] + " " + bat[i + 1])) {
                    collection.put(hashIdx, bat[i] + " " + bat[i + 1]);
                    hashIdx++;
                }
            }
            days++;
        }
       return days;
    }

    public static int[] getNewList(int [] points, int x, int y) {
       ArrayList<Integer> a = new ArrayList<>();
       for (int i = 0; i < points.length; i += 2) {
           if(points[i + 1] - 1 > 0) {
               a.add(points[i]);
               a.add(points[i + 1] - 1);
           }
           if(points[i] - 1 > 0) {
               a.add(points[i] - 1);
               a.add(points[i + 1]);
           }
            if(points[i] + 1 <= x) {
                a.add(points[i] + 1);
                a.add(points[i + 1]);
            }
            if(points[i + 1] + 1 <= y) {
                a.add(points[i]);
                a.add(points[i + 1] + 1);
            }
       }
       int [] newList;
       newList = a.stream().mapToInt(i -> i).toArray();
       return newList;
    }

}
