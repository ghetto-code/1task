public class Level1 {
    public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2) {
        int [][] map = getArray(H1, W1, S1);
        int [][] target = getArray(H2, W2, S2);
        return isEnemyClose(map, target);
    }

    // функция, которая принимает высоту и ширину массива, а так же строку с описанием карты или с описанием
    // координат врага и преобразует эту карту в массив, и возвращает его
    public static int [][] getArray(int h, int w, String str) {

        // задаем пустой массив, куда будем записывыть результат
        int [][] arr = new int[h][w];

        // делим входную строку по пробелам
        String[] strArr = str.split(" ");

        // проходимся по всем участкам
        for (int i = 0; i < strArr.length; i ++) {

            // проходим по конкретному участку
            for (int j = 0; j < strArr[i].length(); j ++) {

                // преобазуем в символ элемент строки
                char z = strArr[i].charAt(j);

                // преобразуем в строку символ
                String x = String.valueOf(z);

                // получаем из стоки число
                int v = Integer.parseInt(x);

                //записываем число в массив
                arr[i][j] = v;
            }
        }
        // возвращаем массив
        return arr;
    }
    // функция определяет попадают ли враги в поле нашего зрения
    public static boolean isEnemyClose(int [][] m, int [][] t) {

        // проходим по всем строкам в массиве
        for (int i = 0; i < m.length; i ++) {

            // проходим по каждому лементу каждой строки в массив
            for (int j = 0; j < m[i].length; j ++) {

                // если текущий элемент равен первому элементу из массива с вражескими координатами
                if (m[i][j] == t[0][0]) {
                    boolean flag = true;
                //////////////////////////////////////////////////////////////////////////
                    // проходим по второму массиву и сравниваем элементы с первым
                    for (int c = 0; c < t.length; c ++) {
                        for (int v = 0; v < t[c].length; v ++) {
                            if (t[c][v] != m[i+c][j+v]) {
                                flag = false;
                                break;
                            }
                        }
                        if(!flag) {
                            break;
                        }
                    }
                    if (flag){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
