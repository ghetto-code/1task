import java.util.*;
import java.util.stream.Collectors;

public class Level1 {
    public static int MaximumDiscount(int N, int [] price) {
        int result = 0;
        int [] copyPrice = price;


        Integer [] priceList = new Integer[copyPrice.length];
        for (int i = 0; i < copyPrice.length; i ++) {
            priceList[i] = copyPrice[i];
        }
        List<Integer> list = Arrays.asList(priceList);
        List<Integer> sortedList = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        for (int i = 0; i < copyPrice.length; i ++) {
            copyPrice[i] = sortedList.get(i);
        }



        try {
            for (int i = 0; i < copyPrice.length; i += 3) {
                result += copyPrice[i+2];
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }




        return result;
    }
}
