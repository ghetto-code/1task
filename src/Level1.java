import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Level1 {
    public static boolean SherlockValidString(String s) {
        if (s.length() < 2) {
            return false;
        }
        String rusStr = "aя";
        String enStr = "az";
        Range rusRange = new Range(rusStr.charAt(0), rusStr.charAt(1));
        Range engRange = new Range(enStr.charAt(0), enStr.charAt(1));
        HashMap<String, Integer> quantity = new HashMap<>();

        if (isEng(s, engRange)) {
            getLetters(s, engRange, quantity);
        } else {
            getLetters(s, rusRange, quantity);
        }

        int [] qts = new int[quantity.size()];
        int id = 0;

        for (Map.Entry<String,Integer> x : quantity.entrySet()) {
            qts[id] = x.getValue();
            id++;
        }
        Arrays.sort(qts);
        HashMap<Integer, Integer> ints = new HashMap<>();
        for (Map.Entry<String,Integer> x : quantity.entrySet()) {
            if (!ints.containsKey(x.getValue())) {
                ints.put(x.getValue(), 1);
            } else {
                ints.put(x.getValue(), ints.get(x.getValue())+1);
            }

        }

        int [][] intsArr = new int[2][2];
        int idx = 0;
        try {
            for (Map.Entry<Integer, Integer> x : ints.entrySet()) {
                intsArr[idx][0] = x.getKey();
                intsArr[idx][1] = x.getValue();
                idx++;
            }
        } catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
        int firstNumber = intsArr[0][0];
        int firstNumberQuantity = intsArr[0][1];
        int secondNumber = intsArr[1][0];
        int secondNumberQuantity = intsArr[1][1];
        if (ints.size() == 1) {
            return true;
        } else if (ints.size() == 2) {
             if (firstNumberQuantity == 1 && secondNumberQuantity == 1) {
                 if (firstNumber == 1 || secondNumber == 1){
                     return true;
                 }
                 if (firstNumber - secondNumber == 1 || secondNumber - firstNumber == 1) {
                    return true;
                 }

             } else if (firstNumberQuantity == 1) {
                 if (firstNumber - secondNumber == 1) {
                     return true;
                 }
             } else if (secondNumberQuantity == 1) {
                 if (secondNumber - firstNumber == 1) {
                     return true;
                 }
             }
        } else {
            return false;
        }

        return false;
    }
    public static boolean isEng(String str, Range eng){
        for (int i = 0; i < str.length(); i++) {
            if (!eng.contains(str.charAt(i))) {
                return false;
            }
        }
         return true;
    }
    public static void getLetters(String str, Range range, HashMap<String,Integer> qts) {
        for (int i = 0; i < str.length(); i ++) {
            if (range.contains(str.charAt(i))) {
                if (!qts.containsKey(String.valueOf(str.charAt(i)))) {
                    qts.put(String.valueOf(str.charAt(i)),1);
                } else {
                    qts.put(String.valueOf(str.charAt(i)), qts.get(String.valueOf(str.charAt(i))) + 1);
                }

            }
        }
    }

}
class Range {
    private final int min;
    private final int max;
    public Range(int min, int max){
        this.min = min;
        this.max = max;
    }
    public boolean contains(int number) {
        return (number >= min && number <= max);
    }
}
