import java.util.*;

public class Level1 {
    public static boolean Football(int[] F, int N) {

        // создаем два клона входящего массива чисел
        int[] FootballArr = F.clone();
        int[] FootballArrClone = FootballArr.clone();

        // сортируем один из клонов
        Arrays.sort(FootballArrClone);

        // задаем переменную, в которую положим количество перестановок, из-за глупости просто поставил, что мол
        // оно равно количеству элементов в 3 степени
        int qts = N*N*N;

        // создаем коллекцию, куда сложим комбинации индексов, элементы которых мы будем менять местами в дальнейшем
        ArrayList<int[]> combsList = new ArrayList<>();
        // получить индексы на перестановку(заполняет коллекцю combinationsList)
        getAllIdxForReplace(FootballArr, qts, combsList);
        // проходимся по каждой комбинации в коллекции
        for (int[] x: combsList) {
            int [] sortCLone = FootballArr.clone();
            // меняем местами элементы
            int firstIdx = x[0];
            int secondIdx = x[1];
            int swap = sortCLone[firstIdx];
            sortCLone[firstIdx] = sortCLone[secondIdx];
            sortCLone[secondIdx] = swap;
            // если он отсортирован, возвращаем true
            if (isSort(sortCLone)) {
                return true;
            }
        }
        for (int[] x: combsList) {
            int [] footballClone = FootballArr.clone();
            reversReplaceElements(footballClone, x[0], x[1]);
            if (isSort(footballClone)) {
                return true;
            }
        }

        return false;
}

    // фукнция заполняет массив всеми комбинациями замены пары элементов
    public static void getAllIdxForReplace(int[] currentState, int quantity, ArrayList<int[]> combList) {
        if (combList.size() == quantity) {
            return;
        }
        for (int i = 0; i < currentState.length; i ++) {
            for (int j = 0; j < currentState.length; j++) {
                if (i != j) {
                    combList.add(new int[]{i,j});
                }
            }
        }
    }

    // проверка на 'отсортированность'
    public static boolean isSort(int[] f) {
        for (int i = 0; i < f.length - 1; i ++) {
            if (f[i+1]<f[i]) {
                return false;
            }
        }
        return true;
    }

    // функция 'зеркалящая' входящий массив
    public static void reversReplaceElements(int[] arr, int el1, int el2) {

        // на случай, если массив пуст оборачиваем цикл в try/catch
        try {
            if (arr.length == 2) {
                int swap = arr[0];
                arr[0] = arr[1];
                arr[1] = swap;
            } else if (arr.length > 2) {
                for (int i = el1; i < el2 + 1; i ++) {
                    int swap = arr[i];
                    arr[i] = arr[arr.length - i - 1];
                    arr[arr.length - i - 1] = swap;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }
}
