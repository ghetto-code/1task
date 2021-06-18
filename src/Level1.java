import java.util.ArrayList;

public class Level1 {
    public static String BigMinus(String s1, String s2) {
        String result = "";
        String maxStr = "";
        String minStr = "";
        if(bigger(s1, s2) == 1 || bigger(s1, s2) == 0){
            maxStr = s1;
            minStr = s2;
        } else if (bigger(s1, s2) == 2) {
            maxStr = s2;
            minStr = s1;
        }

        if (minStr.length() < maxStr.length()) {
           String newStr = "";
           for (int i = 0; i < maxStr.length() - minStr.length(); i ++) {
               newStr += "0";
           }

           minStr = newStr.concat(minStr);
        }
        result = minus(maxStr,minStr);

        return result;
    }
    public static int bigger(String s1, String s2) {
       if (s1.length() == s2.length()) {
            for(int i = 0; i < s1.length(); i ++) {
                if ((int)s1.charAt(i) > (int)s2.charAt(i)){
                    return 1;
                }
                if ((int)s1.charAt(i) < (int)s2.charAt(i)){
                    return 2;
                }
            }
        }
        if (s1.length() > s2.length()) {
            return 1;
        }
        if (s2.length() > s1.length()) {
            return 2;
        }
        return 0;
    }

    public static String minus(String max, String min) {
        String result = "";
        ArrayList<String> resCol = new ArrayList<>();
        char [] maxChars = max.toCharArray();
        char [] minChars = min.toCharArray();
        if (max.equals(min)) {
            resCol.add("0");
        } else {
            for (int i = maxChars.length - 1; i >= 0; i --) {
                if ((int)maxChars[i] - (int)minChars[i] >= 0) {
                    resCol.add(0,String.valueOf((int)maxChars[i] - (int)minChars[i]));
                } else {
                    for (int j = i - 1; j >= 0; j --) {
                        if (maxChars[j] != '0') {
                            // получаем строку из символа
                            String stringFromElem = String.valueOf(maxChars[j]);
                            // конвертируем в int и вычитаем - 1
                            String stringFromSecondElem = String.valueOf(minChars[i]);
                            int intFromSecondString = Integer.parseInt(stringFromSecondElem);
                            int intFromString = Integer.parseInt(stringFromElem) - 1;
                            // получаем строку из результата
                            stringFromElem = String.valueOf(intFromString);
                            // создаем массив символов
                            char [] numbers = stringFromElem.toCharArray();
                            // создаем символ, в который запишем первый элемент массива
                            char numb = numbers[0];
                            // обновим символ, из которого вычитали единицу
                            maxChars[j] = numb;

                            stringFromElem = String.valueOf(maxChars[i]);
                            intFromString = Integer.parseInt(stringFromElem) + 10 - intFromSecondString;
                            stringFromElem = String.valueOf(intFromString);
                            numbers = stringFromElem.toCharArray();
                            numb = numbers[0];
                            maxChars[i] = numb;
                            resCol.add(0,stringFromElem);
                            break;
                        } else {
                            // создаем символ, в который запишем первый элемент массива
                            char numb = '9';
                            // обновим символ, из которого вычитали единицу
                            maxChars[j] = numb;
                        }
                    }
                }
            }
        }


        for (int i = 0; i < resCol.size(); i ++) {
            if (resCol.get(0).equals("0") && resCol.size() > 1) {
                resCol.remove(0);
            }
        }
//        resCol.add(0,"\"");
//        resCol.add("\"");
        if(resCol.size() ==1 && resCol.get(0).equals("0")){
            resCol.add(0,"'");
            resCol.add("'");
        }


        for (String x : resCol){
            result += x;
        }

        return result;
    }
}
