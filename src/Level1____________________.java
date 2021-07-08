import java.util.*;

public class Level1____________________ {
    public static String [] ShopOLAP(int N, String [] items) {

        HashMap<String, String> itemsHash = new HashMap<>();

        for (String item : items){
            String[] arr = item.split(" ");
            if (itemsHash.containsKey(arr[0])) {
                itemsHash.put(arr[0],String.valueOf(Integer.parseInt(arr[1]) + Integer.parseInt(itemsHash.get(arr[0]))));
            } else {
                itemsHash.put(arr[0],arr[1]);
            }

        }


        String[][] preResult = new String[itemsHash.size()][2];
        int idx = 0;
        for (Map.Entry<String,String> x : itemsHash.entrySet()) {
            preResult[idx][0] = x.getKey();
            preResult[idx][1] = x.getValue();
            idx++;
        }

        for (int i = 0; i < preResult.length; i ++) {
            for (int j = 0; j < preResult.length - 1; j ++) {
                if (Integer.parseInt(preResult[j][1]) < Integer.parseInt(preResult[j+1][1])) {
                    String[] swap = preResult[j];
                    preResult[j] = preResult[j + 1];
                    preResult[j + 1] = swap;
                }
            }
        }

            for (int j = 0; j < preResult.length - 1; j ++) {
                if (Integer.parseInt(preResult[j][1]) == Integer.parseInt(preResult[j+1][1])) {
                    int len;
                    if(preResult[j][0].length() <= preResult[j + 1][0].length()){
                        len = preResult[j][0].length();
                    } else {
                        len = preResult[j + 1][0].length();
                    }
                    for (int l = 0; l < len; l ++) {
                        char currentEl = preResult[j][0].charAt(l);
                        char nextEl = preResult[j + 1][0].charAt(l);

                        if (currentEl > nextEl && l != len-1) {
                            String[] swap = preResult[j];
                            preResult[j] = preResult[j + 1];
                            preResult[j + 1] = swap;
                            break;

                        }
                    }


                }
            }



        String [] result = new String[preResult.length];
        int id = 0;
        for (String[] x : preResult) {
            result[id] = x[0] + " " + x[1];
            id++;
        }

        return result;
    }
}
