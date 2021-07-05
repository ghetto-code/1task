
public class Main {
    public static void main(String[] args) {
        String [] list = new String[] {
                "платье1 5",
                "сумка32 2",
                "платье1 1",
                "сумка23 2",
                "сумка128 4",
        };
//        String [] list = new String[] {
//                "123 5",
//                "32 3",
//                "124 5",
//                "128 1",
//                "32 2",
//                "23 4",
//                "128 4",
//                "128 1"
//        };
        int N = list.length;

        String [] goodList = Level1.ShopOLAP(N, list);
        for (String x : goodList){
            System.out.println(x);
        }
    }
}

