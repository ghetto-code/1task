public class Level1 {
    public static int SumOfThe(int N, int [] data) {
        if (N < 2){
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < data.length; i ++) {
            if(data[i] == returnSum(i,data)) {
                sum = data[i];
                return sum;
            }
        }
        return sum;
    }

    public static int returnSum(int idx, int [] data) {
        int sum = 0;
        for (int i  = 0; i < data.length; i ++) {
            if (i != idx) {
                sum += data[i];
            }
        }
        return sum;
    }
}
