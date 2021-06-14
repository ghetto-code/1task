import java.util.*;

public class Level1 {
    public static int [] WordSearch(int len, String s, String subs) {

        ArrayList<String> linesCollection = new ArrayList<>();
        ArrayList<Integer> resultCollection = new ArrayList<>();
        strTreatment(len, s, linesCollection);

        for (String line : linesCollection){
            if (!line.contains(subs)){
                resultCollection.add(0);
            } else {
                String[] arr = line.split(" ");
                boolean flag = false;
                for(String x : arr){
                    if (x.equals(subs)) {
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    resultCollection.add(0);
                } else {
                    resultCollection.add(1);
                }
            }
        }

        int [] resultArray = new int[resultCollection.size()];
        for (int i = 0; i < resultArray.length; i ++) {
            resultArray[i] = resultCollection.get(i);
        }
        return resultArray;
    }


    public static String strTreatment(int len, String str, ArrayList<String> lines) {
        if (str.length() <= len) {
            lines.add(str);
            return str;
        }

        int idx = len;
        String newLine;
        String newString;
        if (str.charAt(len) == ' ') {
            newLine = str.substring(0,idx).trim();
            newString = str.substring(idx).trim();
            lines.add(newLine);
            return strTreatment(len, newString, lines);
        }

        for (int i = idx; i > 0; i --) {
            if (str.charAt(i) == ' ') {
                idx = i;
                newLine = str.substring(0,idx).trim();
                newString = str.substring(idx).trim();
                lines.add(newLine);
                return strTreatment(len, newString, lines);
            }
            if (i == 1) {
                for (int j = idx; j < str.length(); j ++) {
                    if (str.charAt(j) == ' '|| j == str.length() - 1) {
                        idx = j;
                        int from = 0;
                        String newStr = str.substring(0,idx).trim();
                        for (int z = 0; z + len < newStr.length(); z += len) {
                            lines.add(newStr.substring(z, z + len).trim());
                            from = z + len;
                        }
                        newStr = str.substring(from, idx + 1);
                        lines.add(newStr.trim());

                        newString = str.substring(idx+1).trim();
                        return strTreatment(len, newString, lines);

                    }
                }
            }
        }
        return strTreatment(len, str, lines);
    }
}
