import java.util.HashMap;

public class Level1 {
    public static int PrintingCosts(String Line) {
        // количество потраченных чернил
        int consumption = 0;
        // таблица расхода
        HashMap<String,Integer> collect = new HashMap<>();
        collect.put(" ", 0);
        collect.put("!", 9);
        collect.put("\"", 6);
        collect.put("#", 24);
        collect.put("$", 29);
        collect.put("%", 22);
        collect.put("&", 24);
        collect.put("'", 3);
        collect.put("(", 12);
        collect.put(")", 12);
        collect.put("*", 17);
        collect.put( "+", 13);
        collect.put(",", 7);
        collect.put("-", 7);
        collect.put(".", 4);
        collect.put("/", 10);
        collect.put("0", 22);
        collect.put("1", 19);
        collect.put("2", 22);
        collect.put("3", 23);
        collect.put("4", 21);
        collect.put("5", 27);
        collect.put("6", 26);
        collect.put("7", 16);
        collect.put("8", 23);
        collect.put("9", 26);
        collect.put(":", 8);
        collect.put(";", 11);
        collect.put("<", 10);
        collect.put("=", 14);
        collect.put(">", 10);
        collect.put("?", 15);
        collect.put("@", 32);
        collect.put("A", 24);
        collect.put("B", 29);
        collect.put("C", 20);
        collect.put("D", 26);
        collect.put("E", 26);
        collect.put("F", 20);
        collect.put("G", 25);
        collect.put("H", 25);
        collect.put("I", 18);
        collect.put("J", 18);
        collect.put("K", 21);
        collect.put("L", 16);
        collect.put("M", 28);
        collect.put("N", 25);
        collect.put("O", 26);
        collect.put("P", 23);
        collect.put("Q", 31);
        collect.put("R", 28);
        collect.put("S", 25);
        collect.put("T", 16);
        collect.put("U", 23);
        collect.put("V", 19);
        collect.put("W", 26);
        collect.put("X", 18);
        collect.put("Y", 14);
        collect.put("Z", 22);
        collect.put("[", 18);
        collect.put("\\", 10);
        collect.put("]", 18);
        collect.put("^", 7);
        collect.put("_", 8);
        collect.put("`", 3);
        collect.put("a", 23);
        collect.put("b", 25);
        collect.put("c", 17);
        collect.put("d", 25);
        collect.put("e", 23);
        collect.put("f", 18);
        collect.put("g", 30);
        collect.put("h", 21);
        collect.put("i", 15);
        collect.put("j", 20);
        collect.put("k", 21);
        collect.put("l", 16);
        collect.put("m", 22);
        collect.put("n", 18);
        collect.put("o", 20);
        collect.put("p", 25);
        collect.put("q", 25);
        collect.put("r", 13);
        collect.put("s", 21);
        collect.put("t", 17);
        collect.put("u", 17);
        collect.put("v", 13);
        collect.put("w", 19);
        collect.put("x", 13);
        collect.put("y", 24);
        collect.put("z", 19);
        collect.put("{", 18);
        collect.put("|", 12);
        collect.put("}", 18);
        collect.put("~", 9);

        for (int i = 0; i < Line.length(); i ++ ) {

            if (collect.containsKey(String.valueOf(Line.charAt(i)))) {
               consumption += collect.get(String.valueOf(Line.charAt(i)));
            } else {
                consumption += 23;
            }

        }

        return consumption;
    }
}
