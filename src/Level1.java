import java.util.ArrayList;

public class Level1 {
    public static int idx = 0;
    public static ArrayList<String> combinationsList = new ArrayList<>();
    public  static String BiggerGreater(String input){
        String resultString = "";

        int N = input.length();

        getAllCombinations(input, N*N*N);
        combinationsList.sort(String::compareTo);

        for (int i = 0; i < combinationsList.size() - 1; i ++) {
            if (combinationsList.get(i).equals(input) && i != combinationsList.size() - 1) {
                resultString = combinationsList.get(i + 1);
            }
        }

        return resultString;
    }
    public static void getAllCombinations(String input, int quantity) {
        if(combinationsList.size() == quantity){
            return;
        }
        if (!combinationsList.contains(input)) {
            combinationsList.add(input);
        } else {
            return;
        }



        ArrayList<String> charArr = new ArrayList<>();
        for (int i = 0; i < input.length() - 1; i ++) {
            char [] arr = input.toCharArray();
            char swap = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = swap;
            charArr.add(String.valueOf(arr));
        }
        for (String x : charArr) {
            getAllCombinations(x,quantity);
        }
    }
}

