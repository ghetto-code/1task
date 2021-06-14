public class Main {
    public static void main(String[] args) {
        String str = "1) строка разбивается на набор строк через выравнивание по заданной ширине.";

        String substr = "строк";

        int[] z = Level1.WordSearch(12, str, substr);

        for(int x : z){
            System.out.println(x);
        }
    }
}

