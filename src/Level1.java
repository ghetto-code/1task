public class Level1 {
    public static boolean LineAnalysis(String line){

        String lineCopy = line;
        String part = String.valueOf(lineCopy.charAt(0));
        if (line.charAt(0) != '*' || line.charAt(line.length()-1) != '*') {
            return false;
        }
        if (lineCopy.length() == 1 || lineCopy.length() == 2 || lineCopy.length() == 3) {
            return true;
        }


        for (int i = 1; i < lineCopy.length(); i ++) {
            part += lineCopy.charAt(i);
            if (lineCopy.charAt(i) == '*') {
                break;
            }
        }
        lineCopy = lineCopy.substring(part.length() - 1);

        if(lineCopy.length() == 0) {
            return true;
        }


        while (lineCopy.length() >= part.length()) {
            String x = lineCopy.substring(0,part.length());
            if (!x.equals(part)) {
                return false;
            }
            lineCopy = lineCopy.substring(part.length()-1);
        }
        if (lineCopy.length() != 1) {
            return false;
        }
        if (lineCopy.charAt(0) != '*') {
            return false;
        }


        return true;
    }
}
