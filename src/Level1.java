import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Level1 {
    public static String MassVote(int N, int [] Votes) {
        String voteResult = "";
        int commonVoices = getCommonVoices(Votes);
        double [] percentsVoices = getPercents(Votes,commonVoices);
        if (isRepeat(Votes)) {
            voteResult = "no winner";
            return voteResult;
        }
        HashMap<Integer,Double> res = getMax(percentsVoices);

        for (Map.Entry<Integer,Double> x : res.entrySet()){
            if (x.getValue() > 50) {
                voteResult = "majority winner " + (x.getKey() + 1);
            } else  {
                voteResult = "minority winner " + (x.getKey() + 1);
            }
        }


        return voteResult;
    }
    public static int getCommonVoices(int [] votes) {

        // общее количество голосов
        int res = 0;

        // проходим по каждому кандидату
        for (int x : votes) {

            // и прибавляем к общему количеству голосов то количество голосов, которое было
            // отдано за текущего кандидата
            res += x;
        }

        // возвращаем результат
        return res;
    }

    // функция, которая получает на вход массив с результатом голосования и общее количество голосов
    // и возвращает массив элементов double с результатом голования, сконвертированном в проценты
    public static double[] getPercents(int [] votes, int commonV) {

        // результирующий массив с процентами
        double [] percentsArr = new double[votes.length];

        // проходимся по результату голосования
        for (int i = 0; i < votes.length; i ++) {
            MathContext context = new MathContext(4, RoundingMode.HALF_UP);

            // записываем в переменную х результат вычесления процентов
            double x = ((double) votes[i] * 100) / commonV;
            BigDecimal result = new BigDecimal(x,context);

            // записываем в результирующий массив количество проголосовавших в процентах
            percentsArr[i] = result.doubleValue();
        }

        // возвращаем результирующий массив
        return percentsArr;
    }

    // функция, которая определяет наличие одинакового количества голосов у лидеров голосования
    // принимает массив с результатом голосования, находит лидера, ищет повторение такого же результата
    public static boolean isRepeat(int [] votes) {
        boolean repeat = false;
        int maxVoices = 0;
        int idxMaxVoices = 0;
        for (int i = 0; i < votes.length; i ++) {
            if (votes[i] > maxVoices) {
                maxVoices = votes[i];
                idxMaxVoices = i;
            }
        }

        for (int i = 0; i < votes.length; i ++) {

            // если повтор есть, возвращаем истину
            if (votes[i] == maxVoices && i != idxMaxVoices) {
                repeat = true;
                return repeat;
            }
        }
        // иначе ложь
        return repeat;
    }

    // функция принимает резуьтат голосования в процентах и возвращает коллекцию hashMap, состоящую из индекса
    // лидера и количества проголосовавших в процентах
    public static HashMap<Integer, Double> getMax(double [] arr) {

        HashMap<Integer,Double> max= new HashMap<>();
        double maxVoices = 0;
        int idxMaxVoices = 0;
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] > maxVoices) {
                maxVoices = arr[i];
                idxMaxVoices = i;
            }
        }
        max.put(idxMaxVoices, maxVoices);
        return max;
    }
}
