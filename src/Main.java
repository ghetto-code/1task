
public class Main {
    public static void main(String[] args) {
        String [] list = new String[] {
                "платье1 5",
                "сумка32 2",
                "платье1 1",
                "сумка23 2",
                "сумка128 4",
        };
        String [] list1 = new String[] {
                "123 5",
                "32 3",
                "124 5",
                "128 1",
                "32 2",
                "23 4",
                "128 4",
                "128 1"
        };
        String [] list2 = new String[] {
                "dress1 5",
                "handbug32 2",
                "dress1 1",
                "handbug23 2",
                "handbug128 4"
        };
        int N = list.length;

        String [] goodList = Level1.ShopOLAP(N, list);
        String [] goodList1 = Level1.ShopOLAP(N, list1);
        String [] goodList2 = Level1.ShopOLAP(N, list2);
        for (String x : goodList){
            System.out.println(x);
        }
        for (String x : goodList1){
            System.out.println(x);
        }
        for (String x : goodList2){
            System.out.println(x);
        }
    }
}

