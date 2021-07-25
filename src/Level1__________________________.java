public class Level1__________________________ {
    public static boolean white_walkers(String village) {
        char [] mapArr = village.toCharArray();
        int firstNumb = -1;
        int secondNumb = -1;
        int firstIdx = 0;
        int secondIdx = 0;

        boolean flag = true;

        for (int i = 0; i < mapArr.length; i ++) {
            if (!flag) {
                return false;
            }
            if (i != mapArr.length - 1) {
                if (isANum(mapArr[i]) && isANum(mapArr[i + 1])) {
                    return false;
                }
            }
            if (isANum(mapArr[i])) {
                int numb  = Integer.parseInt(String.valueOf(mapArr[i]));
                if (firstNumb == -1 && secondNumb == -1) {
                    firstNumb = numb;
                    firstIdx = i;
                } else if (firstNumb != -1 && secondNumb == -1) {
                    secondNumb = numb;
                    secondIdx = i;

                    if(firstNumb + secondNumb == 10) {
                        flag = false;
                        if (wasAFound(firstIdx, secondIdx, mapArr)) {
                            flag = true;
                        }
                    }
                } else if (firstNumb != -1 && secondNumb != -1) {
                    firstNumb = secondNumb;
                    firstIdx = secondIdx;
                    secondNumb = numb;
                    secondIdx = i;

                    if(firstNumb + secondNumb == 10) {
                        flag = false;
                        if (wasAFound(firstIdx, secondIdx, mapArr)) {
                            flag = true;
                        }
                    }
                }
            }
        }
        if(firstNumb == -1 || secondNumb == -1){
            flag = false;
        }

        return flag;
    }

    // функция проверяет, является ли числом входящая строка
    public static boolean isANum(char symbol) {
        try {
            Integer.parseInt(String.valueOf(symbol));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean wasAFound(int firstIdx, int secIdx, char [] arr) {
        int count = 0;
        for (int i = firstIdx + 1; i < secIdx; i ++) {
            if (arr[i] == '=') {
                count++;
            }
        }
        if (count < 3) {
            return false;
        } else {
            return true;
        }
    }
}
