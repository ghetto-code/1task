
public class Main {
    public static void main(String[] args) {
        String [] list = new String[] {
                "платье1 5",
                "сумка32 2",
                "платье1 1",
                "сумка23 2",
                "сумка128 4",
        };
        int N = list.length;

        String [] goodList = Level1.ShopOLAP(N, list);
        for (String x : goodList){
            System.out.println(x);
        }
    }
}

