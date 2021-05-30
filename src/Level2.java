import java.util.*;

public class Level2 {
    public static int odometer(int[] oksana) {
        int distance = 0;
        if (oksana.length >= 2) {
            for (int i = 0; i < oksana.length; i += 2) {
                distance += oksana[i] * oksana[i + 1];
            }
        }
        return distance;
    }
}
