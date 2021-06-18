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
        int res = 0;
        for (int x : votes) {
            res += x;
        }
        return res;
    }
    public static double[] getPercents(int [] votes, int commonV) {
        double [] percentsArr = new double[votes.length];

        for (int i = 0; i < percentsArr.length; i ++) {
            int x = (votes[i] * 100) / commonV;
            percentsArr[i] = x;
        }

        return percentsArr;
    }
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
            if (votes[i] == maxVoices && i != idxMaxVoices) {
                repeat = true;
                return repeat;
            }
        }

        return repeat;
    }

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
