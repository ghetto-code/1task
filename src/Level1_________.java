public class Level1_________ {
    public static String TheRabbitsFoot(String s, boolean encode) {
        String newStr = "";

        if(encode){
            String [][] mx = getMatrixFromEncodingString(s);
            newStr = getCodingStringFromMatrix(mx);
            return newStr;
        }
        String [][] mx = getMatrixFromCodingString(s);
        newStr = getEncodingStringFromMatrix(mx);

        return newStr;
    }
    // получить матрицу из раскодированной строки
    public static String[][] getMatrixFromEncodingString(String encodingStr) {
        // очищаем строку от пробелов
        String strWithoutSpaces  = String.join("",encodingStr.split(" "));

        // получаем длину строки без пробелов
        int len = strWithoutSpaces.length();

        // вычислсяем квадратный корень
        double squareRoot = Math.sqrt(len);

        // получаем количество строк и столбцов
        int rows = (int) Math.floor(squareRoot);
        int columns = (int) Math.ceil(squareRoot);

        // если произведение сторон меньше длины строки, тогда добавить еще одну строку
        while (rows*columns < len) {
            rows++;
        }

        // создаем матрицу, куда будем записывать буквы из строки
        String [][] matrix = new String[rows][columns];

        int idx = 0;

        // проходим по строке без пробелов
        for (int i = 0; i + columns < strWithoutSpaces.length(); i += columns){

            // проходим по колонкам
            for (int j = 0; j < columns; j ++) {

                // записываем в матрицу элемент строки
                matrix[idx][j] = String.valueOf(strWithoutSpaces.charAt(i+j));
            }

            // увеличиваем idx строки
            idx++;
        }

        // отлавливаем исключение
        try {

            //дописываем в матрицу остаток строки
            for (int i = 0; i < strWithoutSpaces.length(); i ++) {
                matrix[idx][i] = String.valueOf(strWithoutSpaces.charAt(idx*columns+i));
            }
        } catch (Exception e) {

        }

        return matrix;
    }

    // получить матрицу из закодированной строки
    public static String[][] getMatrixFromCodingString(String codingStr) {

        // очищаем строку от пробелов
        String strWithoutSpaces  = String.join("",codingStr.split(" "));

        // получаем длину строки без пробелов
        int len = strWithoutSpaces.length();

        // вычислсяем квадратный корень
        double squareRoot = Math.sqrt(len);

        // получаем количество строк и столбцов
        int rows = (int) Math.floor(squareRoot);
        int columns = (int) Math.ceil(squareRoot);

        // если произведение сторон меньше длины строки, тогда добавить еще одну строку
        while (rows*columns < len) {
            rows++;
        }

        // создаем матрицу, куда будем записывать буквы из строки
        String [][] matrix = new String[columns][rows];
        String[] arr = codingStr.split(" ");
       for (int i = 0; i < arr.length; i ++) {
           for (int j = 0; j < arr[i].length(); j ++) {
               matrix[j][i] = String.valueOf(arr[i].charAt(j));
           }
       }

        return matrix;
    }


    // получить зашифрованную сроку из матрицы
    public static String getCodingStringFromMatrix(String[][] str) {
        String resultStr = "";
        int idx = 0;
        for (int i = 0; i < str[0].length; i ++ ) {
            for (int j = 0; j < str.length; j ++) {
                if (str[j][i] != null){
                    resultStr += str[j][i];
                }
            }
            if(i != str[0].length - 1){
                resultStr += " ";
            }

            idx++;
        }
        return resultStr;
    }

//     получить расшифрованную сроку из матрицы
    public static String getEncodingStringFromMatrix(String[][] str) {
        String resultStr = "";
        for (int i = 0; i < str.length; i ++ ) {
            for (int j = 0; j < str[i].length; j ++) {
                if (str[i][j] != null){
                    resultStr += str[i][j];
                }
            }
        }
        return resultStr;
    }

}
