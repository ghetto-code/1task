import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;

public class Level1 {
    public static String PatternUnlock(int N, int [] hits) {
        int leg = 1;
        double hypotenuse = Math.hypot(leg,leg);
        BigDecimal hypo = new BigDecimal(hypotenuse);
        hypo = hypo.setScale(5, RoundingMode.HALF_UP);
        double x = hypo.doubleValue();

        String str = "";
        HashMap<String,String> newList = new HashMap<>();
        newList.put("15","51");
        newList.put("18","81");
        newList.put("24","42");
        newList.put("27","72");
        newList.put("53","35");
        newList.put("38","83");
        newList.put("62","26");
        newList.put("29","92");
        int [] hitExpand = new int[N * 2];
        for (int i = 0; i < hitExpand.length - 1; i += 2) {
            hitExpand[i] = hits[i / 2];
            hitExpand[i + 1] = hits[i / 2];

        }

        ArrayList<Double> resList = new ArrayList<>();
        for (int i = 1; i < hitExpand.length - 2; i += 2) {

            if (isDiagonal(hitExpand[i],hitExpand[i+1],newList)) {
               resList.add(x);
               continue;
            }
            resList.add(1.0);
        }


        double rez = 0;
        for (Double d: resList) {
            rez += d;
        }

        BigDecimal lastRez = new BigDecimal(rez);
        lastRez= lastRez.setScale(5, RoundingMode.HALF_UP);

        String lastStr = lastRez.toString();

        String[] convert = lastStr.split("\\.");
        lastStr = String.join("",convert);
        convert = lastStr.split("0");
        lastStr = String.join("",convert);

        str = lastStr;


        return str;
    }

    public static boolean isDiagonal(int a,int b, HashMap<String,String> list) {
        boolean isDiag = false;

        String firstStr = Integer.toString(a) + Integer.toString(b);
        String secondStr = Integer.toString(b) + Integer.toString(a);

        if (list.containsKey(firstStr)
                || list.containsValue(firstStr)
                || list.containsKey(secondStr)
                || list.containsValue(secondStr)) {

            isDiag = true;
            return isDiag;

        }

        return isDiag;
    }
}
