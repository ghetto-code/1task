public class Level1__________________ {
    public static boolean MisterRobot(int N, int [] data) {
        if (N <= 4) {
            return false;
        }
        for (int i = 0; i < data.length - 2; i ++) {
            if (!isAscending(data[i], data[i + 1], data[i + 2])) {
                makeRotation(i, data);
                if (isAscending(data[i], data[i + 1], data[i + 2])) {
                    break;
                }
                if (i == 2 && !isAscending(data[i], data[i + 1], data[i + 2])) {
                    return false;
                }
            }
        }



        return true;
    }

    public static boolean isAscending(int a, int b, int c) {
        return a < b && b < c;
    }
    public static void makeRotation(int count, int [] arr) {
        int swap = arr[count];
        arr[count] = arr[count + 1];
        arr[count + 1] = arr[count + 2];
        arr[count + 2] = swap;
    }
}
