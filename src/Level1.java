import java.util.*;

public class Level1 {


    public static String BiggerGreater(String input) {
        ArrayList<String> combinationsList = new ArrayList<>();
        String resultString = "";
        int N = input.length();
        if (N < 2) {
            return resultString;
        }
        getAllCombinations(input, N * N * N, combinationsList);
        combinationsList.sort(String::compareTo);
        for (int i = 0; i < combinationsList.size() - 1; i ++) {
            if (combinationsList.get(i).equals(input) && i != combinationsList.size() - 1) {
                resultString = combinationsList.get(i + 1);
            }
        }
        return resultString;
    }

    public static void getAllCombinations(String input, int quantity, ArrayList<String> combList) {

        if (combList.size() == quantity) {
            return;
        }
        if (!combList.contains(input)) {
            combList.add(input);
        } else {
            return;
        }
        ArrayList<String> charArr = new ArrayList<>();
        for (int i = 0; i < input.length() - 1; i ++) {
            char [] arr = input.toCharArray();
            char swap = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = swap;
            charArr.add(String.valueOf(arr));
        }
        for (String x : charArr) {
            getAllCombinations(x,quantity, combList);
        }

    }

}

