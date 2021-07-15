import java.util.*;

public class Level1_______________________ {
    public static String [] TreeOfLife(int H, int W, int N, String [] tree) {

        // задаем результирующий массив
        String [] result = new String[H];

        String [][] clone = new String[H][W];

        for (int i = 0; i < tree.length; i ++) {
            for (int j = 0; j < tree[i].length(); j ++) {
                if (tree[i].charAt(j) == '.') {
                    clone[i][j] = "0";
                } else {
                    clone[i][j] = "1";
                }

            }
        }

        for (int years = 0; years < N; years ++) {
            if (years % 2 != 0) {
                oneYearAgo(clone);
                destroy(clone);

            } else {
                oneYearAgo(clone);
            }
        }
        for (int i = 0; i < clone.length; i ++) {
            String res = "";
            for (int j = 0; j < clone[i].length; j++) {
                if (Integer.valueOf(clone[i][j]) > 0) {
                    res += "+";
                } else {
                    res += ".";
                }
            }
            result[i] = res;

        }

        return result;
    }

    public static void oneYearAgo(String[][] tree) {
        for (int i = 0; i < tree.length; i ++) {
            for (int j = 0; j < tree[i].length; j ++) {
                int x = Integer.parseInt(tree[i][j]);
                tree[i][j] = String.valueOf(++x);
            }
        }
    }
    public static void destroy(String[][] tree) {
        HashMap<Integer[],Integer> destroyPointsHash = new HashMap<>();

        for (int i = 0; i < tree.length; i ++) {
            for (int j = 0; j < tree[i].length; j++) {
                if (Integer.parseInt(tree[i][j]) >= 3) {

                    destroyPointsHash.putIfAbsent(new Integer[]{i, j}, 0);
                    destroyPointsHash.putIfAbsent(new Integer[]{i - 1, j}, 0);
                    destroyPointsHash.putIfAbsent(new Integer[]{i + 1, j}, 0);
                    destroyPointsHash.putIfAbsent(new Integer[]{i, j - 1}, 0);
                    destroyPointsHash.putIfAbsent(new Integer[]{i, j + 1}, 0);
                }
            }
        }

        for (Map.Entry<Integer[],Integer> x : destroyPointsHash.entrySet()) {
            try {
                tree[x.getKey()[0]][x.getKey()[1]] = String.valueOf(0);
            } catch (IndexOutOfBoundsException e) {

            }

        }
    }
}
