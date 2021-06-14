public class Main {
    public static void main(String[] args) {
//        String str = "1) строка разбивается на набор строк через выравнивание по заданной ширине.";
//        String substr = "строк";
        String str = "12345";
        String substr = "123";
        int[] z = Level1.WordSearch(3, str, substr);
        for(int i : z ){
            System.out.println(i);
        }
    }
}

