public class Main {
    public static void main(String[] args) {
        String str = "1) строка разбивается на набор строк через выравнивание по заданной ширине.";

        String substr = "строк";
//        String str = "12345";
//
//        String substr = "subs";
        int[] z = Level1.WordSearch(10, str, substr);

    }
}

